package com.ic;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TPH extends Activity implements Observer, OnClickListener {

	private Model model;
	private TextView Time, tvPrevTPH, tvNextTPH;
	private EditText etTPH, etTandanTinggal, etberondolsegar, etberondolbusuk;
	private Button btnPhoto1, btnPhoto2, btnPrev, btnNext, btnSaveExit;
	private String imageName, photo1path, photo2path;
	private Uri mImageCaptureUri;
	private CheckBox cbCek;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tph);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		Intent pokok = getIntent();
		model = (Model) pokok.getSerializableExtra("object");
		model.addObserver(this);
		Time = (TextView) findViewById(R.id.tvTime);
		tvPrevTPH = (TextView) findViewById(R.id.tvPrevTPH);
		tvNextTPH = (TextView) findViewById(R.id.tvNextTPH);
		etTPH = (EditText) findViewById(R.id.etTPH);
		etTandanTinggal = (EditText) findViewById(R.id.etTandanTinggal);
		etberondolsegar = (EditText) findViewById(R.id.etberondolsegar);
		etberondolbusuk = (EditText) findViewById(R.id.etberondolbusuk);
		btnPhoto1 = (Button) findViewById(R.id.btnPhoto1);
		btnPhoto2 = (Button) findViewById(R.id.btnPhoto2);
		btnPrev = (Button) findViewById(R.id.btnTphPrev);
		btnNext = (Button) findViewById(R.id.btnTphNext);
		btnSaveExit = (Button) findViewById(R.id.btnSaveExit);
		cbCek = (CheckBox)findViewById(R.id.cbCek);
		if (model.getEvaluator().equals("Rudi Iswanto") || model.getEvaluator().equals("Satria")){
			cbCek.setVisibility(View.VISIBLE);
		}else{
			cbCek.setVisibility(View.INVISIBLE);
		}
		btnPhoto1.setOnClickListener(this);
		btnPhoto2.setOnClickListener(this);
		btnPrev.setOnClickListener(this);
		btnNext.setOnClickListener(this);
		btnSaveExit.setOnClickListener(this);
		if (model.getTphIndex()==1){
			btnPrev.setEnabled(false);
		}
		new readRecord().execute();
		Thread myThread = null;
		Runnable runnable = new Time();
		myThread = new Thread(runnable);
		myThread.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_tph, menu);
		return true;
	}

	public void doWork() {
		runOnUiThread(new Runnable() {
			@SuppressLint("SimpleDateFormat")
			public void run() {
				try {
					Calendar c = Calendar.getInstance();
					SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
					String curTime = df.format(c.getTime());
					Time.setText("Current Time: " + curTime);
				} catch (Exception e) {
				}
			}
		});
	}

	class Time implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (!Thread.currentThread().isInterrupted()) {
				try {
					doWork();
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				} catch (Exception e) {
				}
			}
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		etTPH.setText("");
		etTandanTinggal.setText("");
		etberondolsegar.setText("");
		etberondolbusuk.setText("");
		cbCek.setChecked(false);
		if (model.getTphIndex() == 1) {
			btnPrev.setEnabled(false);
		} else {
			btnPrev.setEnabled(true);
		}
		new readRecord().execute();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btnPhoto1:
			imageName = model.getFormNo() + "." + etTPH.getText().toString()
					+ "." + "photo1.jpg";
			takephoto(1);
			break;
		case R.id.btnPhoto2:
			imageName = model.getFormNo() + "." + etTPH.getText().toString()
					+ "." + "photo2.jpg";
			takephoto(2);
			break;
		case R.id.btnTphNext:
			model.nextTPH();
			saveData();
			break;
		case R.id.btnTphPrev:
			model.prevTPH();
			saveData();
			break;
		case R.id.btnSaveExit:
			saveData();
			finish();
			break;
		}
	}

	@SuppressLint("SimpleDateFormat")
	public void saveData() {
		boolean error = false;
		String errormsg = "";
		String TPH = null;
		if (!etTPH.getText().toString().isEmpty()) {
			TPH = etTPH.getText().toString();
		} else {
			error = true;
			errormsg += "Silakan input nomor TPH";
		}
		String tandantinggal = null;
		if (!etTandanTinggal.getText().toString().isEmpty()) {
			tandantinggal = etTandanTinggal.getText().toString();
		} else {
			tandantinggal = "0";
		}
		String brondolsegar = null;
		if (!etberondolsegar.getText().toString().isEmpty()) {
			brondolsegar = etberondolsegar.getText().toString();
		} else {
			brondolsegar = "0";
		}
		String brondolbusuk = null;
		if (!etberondolbusuk.getText().toString().isEmpty()) {
			brondolbusuk = etberondolbusuk.getText().toString();
		} else {
			brondolbusuk = "0";
		}
		String cek = "0";
		if (cbCek.isChecked()){
			cek = "-1";
		}
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		String Time = new SimpleDateFormat("HH:mm:ss").format(date);
		if (!error) {
			try {
				model.storeTPH(TPH, tandantinggal, brondolsegar, brondolbusuk,
						photo1path, photo2path, Time, cek);
			} catch (RowsExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BiffException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			Toast.makeText(this, errormsg, Toast.LENGTH_LONG).show();
		}
	}

	public void takephoto(int i) {
		Intent takephoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		String dirName = "/InternalControl/photo";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, imageName);
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, imageName);
		}
		mImageCaptureUri = Uri.fromFile(file);
		if (i == 1) {
			photo1path = mImageCaptureUri.getPath();
		} else {
			photo2path = mImageCaptureUri.getPath();
		}
		takephoto.putExtra(android.provider.MediaStore.EXTRA_OUTPUT,
				mImageCaptureUri);
		startActivityForResult(takephoto, 0);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
		case 0:
			if (resultCode == RESULT_OK) {
				// photo1path = mImageCaptureUri1.getPath();
			} else {
				Toast.makeText(this, "Canceled", Toast.LENGTH_SHORT).show();
			}
			break;
		case 1:
			if (resultCode == RESULT_OK) {
				// photo2path = mImageCaptureUri2.getPath();
			} else {
				Toast.makeText(this, "Canceled", Toast.LENGTH_SHORT).show();
			}
		}
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
			AlertDialog.Builder back = new AlertDialog.Builder(this);
			back.setTitle("Peringatan!");
			back.setMessage("Apa anda yakin untuk membatal input?");
			back.setPositiveButton("OK", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO Auto-generated method stub
					finish();
				}
			});
			back.setNegativeButton("Cancel",
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface arg0, int arg1) {
							// TODO Auto-generated method stub

						}
					});
			back.show();
		}
		return super.onKeyDown(keyCode, event);
	}

	private class readRecord extends AsyncTask<Void, Void, Void> {
		ProgressDialog progressBar;
		boolean found;

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			progressBar = new ProgressDialog(TPH.this);
			progressBar.setCancelable(false);
			progressBar.setMessage("Reading...");
			progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			progressBar.setProgress(0);
			progressBar.setMax(1);
			progressBar.show();
		}

		@Override
		protected Void doInBackground(Void... arg0) {
			// TODO Auto-generated method stub
			found = false;
			try {
				found = model.readTPH(model.getTphIndex());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BiffException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return null;
		}

		@Override
		protected void onPostExecute(Void result2) {
			// TODO Auto-generated method stub
			super.onPostExecute(result2);
			progressBar.dismiss();
			try {
				String prevTPH = model.readTPHprev(model.getTphIndex());
				if (prevTPH.equals("")){
					tvPrevTPH.setText("TPH Sebelumnya: ...");
				}else{
					tvPrevTPH.setText("TPH Sebelumnya: "+prevTPH);
				}
				String nextTPH = model.readTPHnext(model.getTphIndex());
				if (nextTPH.equals("")){
					tvNextTPH.setText("TPH Berikutnya: ...");
				}else{
					tvNextTPH.setText("TPH Berikutnya: "+nextTPH);
				}
			} catch (BiffException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if (found) {
				ArrayList<String> result = null;
				try {
					result = model.readTPHDetail(model.getTphIndex());
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BiffException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				etTPH.setText(result.get(0));
				etTandanTinggal.setText(result.get(1));
				etberondolsegar.setText(result.get(2));
				etberondolbusuk.setText(result.get(3));
				String cek = result.get(4);
				if (cek.equals("-1")){
					cbCek.setChecked(true);
				}
				photo1path = result.get(5);
				photo2path = result.get(6);
			}
		}
	}
}
