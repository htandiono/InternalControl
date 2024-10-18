package com.ic;

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
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Fruit extends Activity implements Observer, OnClickListener {

	private Model model;
	private TextView tvCurrentTPH, tvCurrentFruit, Time, tvCurrentTandan;
	private EditText etBuah, etBeratBuah;
	private RadioGroup rgJenisBuah;
	private RadioButton rbJenisBuah;
	private CheckBox cbCek;
	private Button btnPrev, btnNext, btnExit;
	private Intent i;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fruit);
		i = getIntent();
		model = (Model) i.getSerializableExtra("object");
		model.addObserver(this);
		tvCurrentTPH = (TextView) findViewById(R.id.tvCurrentTPH);
		tvCurrentFruit = (TextView) findViewById(R.id.tvCurrentFruit);
		tvCurrentTandan = (TextView) findViewById(R.id.tvCurrentTandan);
		rgJenisBuah = (RadioGroup) findViewById(R.id.rgJenisBuah);
		Time = (TextView) findViewById(R.id.tvTime);
		etBuah = (EditText) findViewById(R.id.etBuah);
		etBeratBuah = (EditText) findViewById(R.id.etBeratBuah);
		cbCek = (CheckBox) findViewById(R.id.cbCek);
		btnPrev = (Button) findViewById(R.id.btnPrev);
		btnNext = (Button) findViewById(R.id.btnNext);
		btnExit = (Button) findViewById(R.id.btnExit);
		if (model.getEvaluator().equals("Rudi Iswanto")
				|| model.getEvaluator().equals("Satria")) {
			cbCek.setVisibility(View.VISIBLE);
		} else {
			cbCek.setVisibility(View.INVISIBLE);
		}
		btnNext.setOnClickListener(this);
		btnPrev.setOnClickListener(this);
		btnExit.setOnClickListener(this);
		model.setBuah(1);
		String[] nomorTPH = model.getNomorTPH();
		String[] TandanPanen = model.getTandanPanen();
		int pointer = model.getPointer();
		int index = (pointer - 1) / 40;
		tvCurrentTPH.setText("Anda berada pada TPH: " + nomorTPH[index]);
		tvCurrentFruit.setText("Anda sedang mengecek buah ke: "
				+ model.getBuah());
		tvCurrentTandan.setText("Tandan panen pada TPH ini: "
				+ TandanPanen[index]);
		etBuah.setText(""+model.getBuah());
		Thread myThread = null;
		Runnable runnable = new Time();
		myThread = new Thread(runnable);
		myThread.start();
		new readRecord().execute();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_fruit, menu);
		return true;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		tvCurrentFruit.setText("Anda sedang mengecek buah ke: "
				+ model.getBuah());
		etBuah.setText(""+model.getBuah());
		etBeratBuah.setText("");
		rgJenisBuah.check(R.id.rbTenera);
		cbCek.setChecked(false);
		new readRecord().execute();
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.btnPrev:
			model.prevTPH();
			saveData();
			break;
		case R.id.btnNext:
			model.nextTPH();
			saveData();
			break;
		case R.id.btnExit:
			saveData();
			setResult(RESULT_OK, i);
			finish();
			break;
		}
	}

	private void saveData() {
		String beratBuah = "0";
		if (!etBeratBuah.getText().toString().isEmpty()) {
			beratBuah = etBeratBuah.getText().toString();
		}
		int selectedid;
		selectedid = rgJenisBuah.getCheckedRadioButtonId();
		rbJenisBuah = (RadioButton) findViewById(selectedid);
		String jenisbuah = null;
		if (rbJenisBuah.getId() == R.id.rbDura) {
			jenisbuah = "0";
		} else if (rbJenisBuah.getId() == R.id.rbTenera) {
			jenisbuah = "1";
		} else if (rbJenisBuah.getId() == R.id.rbPisifera) {
			jenisbuah = "2";
		}
		String cek = "0";
		if (cbCek.isChecked()){
			cek = "-1";
		}
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		String Time = new SimpleDateFormat("HH:mm:ss").format(date);
		try {
			model.storeMTPH(beratBuah, jenisbuah, cek, Time);
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
	
	public class readRecord extends AsyncTask<Void, Void, Void>{

		ProgressDialog progressBar2;
		boolean found;
		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			//super.onPreExecute();
			progressBar2 = new ProgressDialog(Fruit.this);
			progressBar2.setCancelable(false);
			progressBar2.setMessage("Reading...");
			progressBar2.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			progressBar2.setProgress(0);
			progressBar2.setMax(1);
			progressBar2.show();
		}
		@Override
		protected Void doInBackground(Void... arg0) {
			// TODO Auto-generated method stub
			found = false;
			try {
				found = model.readMTPH(Integer.parseInt(etBuah.getText()
						.toString()));
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
			progressBar2.dismiss();
			if (found) {
				ArrayList<String> result = null;
				try {
					result = model.readMTPHDetail(Integer.parseInt(etBuah
							.getText().toString()));
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
				etBeratBuah.setText(result.get(0));
				String jenisbuah = result.get(1);
				if (jenisbuah.equals("0")){
					rgJenisBuah.check(R.id.rbDura);
				}else if (jenisbuah.equals("1")){
					rgJenisBuah.check(R.id.rbTenera);
				}else if (jenisbuah.equals("2")){
					rgJenisBuah.check(R.id.rbPisifera);
				}
				String cek = result.get(2);
				if (cek.equals("-1")){
					cbCek.setChecked(true);
				}
			}
		}
		
	}

}
