package com.ic;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TPHDetails extends Activity implements OnClickListener {

	private Model model;
	private TextView Time, TPH, tandan;
	private CheckBox cbUkuranTPH, cbAlas, cbBersih, cbCek;
	private EditText etKodePermanen1, etKodePermanen2, etTulis1, etTulis2,
			etHitung1, etHitung2, etMentah, etMengkal, etMasak, etTerlalu,
			etBusuk, etLess50, et50to75, etMore75, etTangkaiPanjang,
			etKastrasi, etPotongan, etRestan, etBaru, etLama, etJumlahTumpukan,
			etBeratTumpukan1, etBeratTumpukan2, etBeratTumpukan3,
			etBeratTumpukan4, etBeratTumpukan5, etBeratTumpukan6, etSampah,
			etBerondolKgSegar, etBerondolKgBusuk;
	private Button btnPhoto1, btnPhoto2, btnCekBuah, btnNextTPH, btnSaveExit;
	private Uri mImageCaptureUri;
	private String photo1path, photo2path, imageName, currTPH;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tphdetails);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		Intent TPHDetail = getIntent();
		model = (Model) TPHDetail.getSerializableExtra("object");
		Time = (TextView) findViewById(R.id.tvTime);
		TPH = (TextView) findViewById(R.id.tvTPHNo);
		tandan = (TextView) findViewById(R.id.tvTandanPanen);
		cbUkuranTPH = (CheckBox) findViewById(R.id.cbUkuranTPH);
		cbAlas = (CheckBox) findViewById(R.id.cbAlas);
		cbBersih = (CheckBox) findViewById(R.id.cbBersih);
		cbCek = (CheckBox) findViewById(R.id.cbCek);
		etKodePermanen1 = (EditText) findViewById(R.id.etKodePermanen1);
		etKodePermanen2 = (EditText) findViewById(R.id.etKodePermanen2);
		etTulis1 = (EditText) findViewById(R.id.etTulis1);
		etTulis2 = (EditText) findViewById(R.id.etTulis2);
		etHitung1 = (EditText) findViewById(R.id.etHitung1);
		etHitung2 = (EditText) findViewById(R.id.etHitung2);
		etMentah = (EditText) findViewById(R.id.etMentah);
		etMengkal = (EditText) findViewById(R.id.etMengkal);
		etMasak = (EditText) findViewById(R.id.etMasak);
		etTerlalu = (EditText) findViewById(R.id.etTerlalu);
		etBusuk = (EditText) findViewById(R.id.etBusuk);
		etLess50 = (EditText) findViewById(R.id.etLess50);
		et50to75 = (EditText) findViewById(R.id.et50to75);
		etMore75 = (EditText) findViewById(R.id.etMore75);
		etTangkaiPanjang = (EditText) findViewById(R.id.etTangkaiPanjang);
		etKastrasi = (EditText) findViewById(R.id.etKastrasi);
		etPotongan = (EditText) findViewById(R.id.etPotongan);
		etRestan = (EditText) findViewById(R.id.etRestan);
		etBaru = (EditText) findViewById(R.id.etBaru);
		etLama = (EditText) findViewById(R.id.etLama);
		etJumlahTumpukan = (EditText) findViewById(R.id.etJumlahTumpukan);
		etBeratTumpukan1 = (EditText) findViewById(R.id.etBeratTumpukan1);
		etBeratTumpukan2 = (EditText) findViewById(R.id.etBeratTumpukan2);
		etBeratTumpukan3 = (EditText) findViewById(R.id.etBeratTumpukan3);
		etBeratTumpukan4 = (EditText) findViewById(R.id.etBeratTumpukan4);
		etBeratTumpukan5 = (EditText) findViewById(R.id.etBeratTumpukan5);
		etBeratTumpukan6 = (EditText) findViewById(R.id.etBeratTumpukan6);
		etSampah = (EditText) findViewById(R.id.etSampah);
		etBerondolKgSegar = (EditText) findViewById(R.id.etBerondolKgSegar);
		etBerondolKgBusuk = (EditText) findViewById(R.id.etBerondolKgBusuk);
		btnPhoto1 = (Button) findViewById(R.id.btnPhoto1);
		btnPhoto2 = (Button) findViewById(R.id.btnPhoto2);
		btnCekBuah = (Button) findViewById(R.id.btnCekBuah);
		btnNextTPH = (Button) findViewById(R.id.btnNextTPH);
		btnSaveExit = (Button) findViewById(R.id.btnSaveExit);
		btnPhoto1.setOnClickListener(this);
		btnPhoto2.setOnClickListener(this);
		btnCekBuah.setOnClickListener(this);
		btnNextTPH.setOnClickListener(this);
		btnSaveExit.setOnClickListener(this);
		if (model.getEvaluator().equals("Rudi Iswanto")
				|| model.getEvaluator().equals("Satria")) {
			cbCek.setVisibility(View.VISIBLE);
		} else {
			cbCek.setVisibility(View.INVISIBLE);
		}
		Thread myThread = null;
		Runnable runnable = new Time();
		myThread = new Thread(runnable);
		myThread.start();
		String[] noTPH =  model.getNomorTPH();;
		switch (model.getPointer()) {
		case 1:
			TPH.setText("Sekarang berada pada TPH: " + noTPH[0]);
			currTPH = noTPH[0];
			break;
		case 41:
			TPH.setText("Sekarang berada pada TPH: " + noTPH[1]);
			currTPH = noTPH[1];
			break;
		case 81:
			TPH.setText("Sekarang berada pada TPH: " + noTPH[2]);
			currTPH = noTPH[2];
			break;
		case 121:
			TPH.setText("Sekarang berada pada TPH: " + noTPH[3]);
			currTPH = noTPH[3];
			break;
		case 161:
			TPH.setText("Sekarang berada pada TPH: " + noTPH[4]);
			currTPH = noTPH[4];
			break;
		case 201:
			TPH.setText("Sekarang berada pada TPH: " + noTPH[5]);
			currTPH = noTPH[5];
			break;
		case 241:
			TPH.setText("Sekarang berada pada TPH: " + noTPH[6]);
			currTPH = noTPH[6];
			break;
		case 281:
			TPH.setText("Sekarang berada pada TPH: " + noTPH[7]);
			currTPH = noTPH[7];
			break;
		case 321:
			TPH.setText("Sekarang berada pada TPH: " + noTPH[8]);
			currTPH = noTPH[8];
			break;
		case 361:
			TPH.setText("Sekarang berada pada TPH: " + noTPH[9]);
			currTPH = noTPH[9];
			break;
		}
		tandan.setText("Sekarang berada pada tandan: " + model.getTandan());
		new readRecord().execute();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_tphdetails, menu);
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
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.btnPhoto1:
			imageName = model.getFormNo() + "." + tandan.getText().toString()
					+ "." + "photo1.jpg";
			takephoto(1);
			break;
		case R.id.btnPhoto2:
			imageName = model.getFormNo() + "." + tandan.getText().toString()
					+ "." + "photo1.jpg";
			takephoto(1);
			break;
		case R.id.btnCekBuah:
			Intent Fruit = new Intent(this,Fruit.class);
			Fruit.putExtra("object", model);
			startActivityForResult(Fruit, 0);
			break;
		case R.id.btnNextTPH:
			saveData();
			Intent TPHSelection = new Intent(this,TPHSelection.class);
			TPHSelection.putExtra("object", model);
			startActivity(TPHSelection);
			finish();
			break;
		case R.id.btnSaveExit:
			saveData();
			finish();
			break;
		}
	}

	public void saveData() {
		String ukuranTPH = "0";
		if (cbUkuranTPH.isChecked()) {
			ukuranTPH = "-1";
		}
		String alas = "0";
		if (cbAlas.isChecked()) {
			alas = "-1";
		}
		String bersih = "0";
		if (cbBersih.isChecked()) {
			bersih = "-1";
		}
		String KodePermanen1 = "";
		if (!etKodePermanen1.getText().toString().isEmpty()) {
			KodePermanen1 = etKodePermanen1.getText().toString();
		}

		String KodePermanen2 = "";
		if (!etKodePermanen2.getText().toString().isEmpty()) {
			KodePermanen2 = etKodePermanen2.getText().toString();
		}

		String Tulis1 = "0";
		if (!etTulis1.getText().toString().isEmpty()) {
			Tulis1 = etTulis1.getText().toString();
		}

		String Tulis2 = "0";
		if (!etTulis2.getText().toString().isEmpty()) {
			Tulis2 = etTulis2.getText().toString();
		}

		String Hitung1 = "0";
		if (!etHitung1.getText().toString().isEmpty()) {
			Hitung1 = etHitung1.getText().toString();
		}

		String Hitung2 = "0";
		if (!etHitung2.getText().toString().isEmpty()) {
			Hitung2 = etHitung2.getText().toString();
		}

		String Mentah = "0";
		if (!etMentah.getText().toString().isEmpty()) {
			Mentah = etMentah.getText().toString();
		}

		String Mengkal = "0";
		if (!etMengkal.getText().toString().isEmpty()) {
			Mengkal = etMengkal.getText().toString();
		}

		String Masak = "0";
		if (!etMasak.getText().toString().isEmpty()) {
			Masak = etMasak.getText().toString();
		}

		String Terlalu = "0";
		if (!etTerlalu.getText().toString().isEmpty()) {
			Terlalu = etTerlalu.getText().toString();
		}

		String Busuk = "0";
		if (!etBusuk.getText().toString().isEmpty()) {
			Busuk = etBusuk.getText().toString();
		}

		String Less50 = "0";
		if (!etLess50.getText().toString().isEmpty()) {
			Less50 = etLess50.getText().toString();
		}

		String $50to75 = "0";
		if (!et50to75.getText().toString().isEmpty()) {
			$50to75 = et50to75.getText().toString();
		}

		String More75 = "0";
		if (!etMore75.getText().toString().isEmpty()) {
			More75 = etMore75.getText().toString();
		}

		String TangkaiPanjang = "0";
		if (!etTangkaiPanjang.getText().toString().isEmpty()) {
			TangkaiPanjang = etTangkaiPanjang.getText().toString();
		}

		String Kastrasi = "0";
		if (!etKastrasi.getText().toString().isEmpty()) {
			Kastrasi = etKastrasi.getText().toString();
		}

		String Potongan = "0";
		if (!etPotongan.getText().toString().isEmpty()) {
			Potongan = etPotongan.getText().toString();
		}

		String Restan = "0";
		if (!etRestan.getText().toString().isEmpty()) {
			Restan = etRestan.getText().toString();
		}

		String Baru = "0";
		if (!etBaru.getText().toString().isEmpty()) {
			Baru = etBaru.getText().toString();
		}

		String Lama = "0";
		if (!etLama.getText().toString().isEmpty()) {
			Lama = etLama.getText().toString();
		}

		String JumlahTumpukan = "0";
		if (!etJumlahTumpukan.getText().toString().isEmpty()) {
			JumlahTumpukan = etJumlahTumpukan.getText().toString();
		}

		String BeratTumpukan1 = "0";
		if (!etBeratTumpukan1.getText().toString().isEmpty()) {
			BeratTumpukan1 = etBeratTumpukan1.getText().toString();
		}

		String BeratTumpukan2 = "0";
		if (!etBeratTumpukan2.getText().toString().isEmpty()) {
			BeratTumpukan2 = etBeratTumpukan2.getText().toString();
		}

		String BeratTumpukan3 = "0";
		if (!etBeratTumpukan3.getText().toString().isEmpty()) {
			BeratTumpukan3 = etBeratTumpukan3.getText().toString();
		}

		String BeratTumpukan4 = "0";
		if (!etBeratTumpukan4.getText().toString().isEmpty()) {
			BeratTumpukan4 = etBeratTumpukan4.getText().toString();
		}

		String BeratTumpukan5 = "0";
		if (!etBeratTumpukan1.getText().toString().isEmpty()) {
			BeratTumpukan5 = etBeratTumpukan5.getText().toString();
		}

		String BeratTumpukan6 = "0";
		if (!etBeratTumpukan6.getText().toString().isEmpty()) {
			BeratTumpukan6 = etBeratTumpukan6.getText().toString();
		}

		String Sampah = "0";
		if (!etSampah.getText().toString().isEmpty()) {
			Sampah = etSampah.getText().toString();
		}

		String BerondolKgSegar = "0";
		if (!etBerondolKgSegar.getText().toString().isEmpty()) {
			BerondolKgSegar = etBerondolKgSegar.getText().toString();
		}

		String BerondolKgBusuk = "0";
		if (!etBerondolKgBusuk.getText().toString().isEmpty()) {
			BerondolKgBusuk = etBerondolKgBusuk.getText().toString();
		}

		String cek = "0";
		if (cbCek.isChecked()) {
			cek = "-1";
		}

		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		String Time = new SimpleDateFormat("HH:mm:ss").format(date);

		try {
			model.storeTPHH(currTPH, ukuranTPH, alas, bersih, KodePermanen1,
					KodePermanen2, Tulis1, Tulis2, Hitung1, Hitung2, Mentah,
					Mengkal, Masak, Terlalu, Busuk, Less50, $50to75, More75,
					TangkaiPanjang, Kastrasi, Potongan, Restan, Baru, Lama,
					JumlahTumpukan, BeratTumpukan1, BeratTumpukan2,
					BeratTumpukan3, BeratTumpukan4, BeratTumpukan5,
					BeratTumpukan6, Sampah, BerondolKgSegar, BerondolKgBusuk,
					cek, photo1path, photo2path, Time);
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
	public class readRecord extends AsyncTask<Void, Void, Void>{
		ProgressDialog progressBar;
		boolean found;
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			progressBar = new ProgressDialog(TPHDetails.this);
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
				found = model.readMTPH();
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
			if (found) {
				ArrayList<String> result = null;
				try {
					result = model.readMPTHDetail();
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
				String size = result.get(0);
				if (size.equals("-1")){
					cbUkuranTPH.setChecked(true);
				}
				String alas = result.get(1);
				if (alas.equals("-1")){
					cbAlas.setChecked(true);
				}
				String bersih = result.get(2);
				if (bersih.equals("-1")){
					cbBersih.setChecked(true);
				}
				etKodePermanen1.setText(result.get(3));
				etKodePermanen2.setText(result.get(4));
				etTulis1.setText(result.get(5));
				etTulis2.setText(result.get(6));
				etHitung1.setText(result.get(7));
				etHitung2.setText(result.get(8));
				etMentah.setText(result.get(9));
				etMengkal.setText(result.get(10));
				etMasak.setText(result.get(11));
				etTerlalu.setText(result.get(12));
				etBusuk.setText(result.get(13));
				etLess50.setText(result.get(14));
				et50to75.setText(result.get(15));
				etMore75.setText(result.get(16));
				etTangkaiPanjang.setText(result.get(17));
				etKastrasi.setText(result.get(18));
				etPotongan.setText(result.get(19));
				etRestan.setText(result.get(20));
				etBaru.setText(result.get(21));
				etLama.setText(result.get(22));
				etJumlahTumpukan.setText(result.get(23));
				etBeratTumpukan1.setText(result.get(24));
				etBeratTumpukan2.setText(result.get(25));
				etBeratTumpukan3.setText(result.get(26));
				etBeratTumpukan4.setText(result.get(27));
				etBeratTumpukan5.setText(result.get(28));
				etBeratTumpukan6.setText(result.get(29));
				etSampah.setText(result.get(30));
				etBerondolKgSegar.setText(result.get(31));
				etBerondolKgBusuk.setText(result.get(32));
				String cek = result.get(33);
				if (cek.equals("-1")){
					cbCek.setChecked(true);
				}
				photo1path = result.get(34);
				photo2path = result.get(35);
			}
		}
		
	}
	
}
