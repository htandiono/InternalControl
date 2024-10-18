package com.ic;

import java.io.IOException;
import java.text.ParseException;

import jxl.write.WriteException;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
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
import android.widget.RadioGroup.OnCheckedChangeListener;

public class AplikasiPemupukan extends Activity implements OnClickListener,
		OnCheckedChangeListener {

	private Model model;
	private EditText aplikasi1, aplikasi3, aplikasi4, aplikasi5, aplikasi6,
			aplikasi711, aplikasi712, aplikasi713, aplikasi8, aplikasi81,
			aplikasi911, aplikasi912, aplikasi913, aplikasi914, aplikasi915,
			aplikasi916, aplikasi917, aplikasi918, aplikasi919, aplikasi9110,
			aplikasi1051, aplikasi11;
	private CheckBox aplikasi2;
	private RadioGroup aplikasi10;
	private Button aplikasi12, aplikasi13;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_aplikasi_pemupukan);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		Intent modul1 = getIntent();
		model = (Model) modul1.getSerializableExtra("object");
		aplikasi1 = (EditText) findViewById(R.id.aplikasi1);
		aplikasi3 = (EditText) findViewById(R.id.aplikasi3);
		aplikasi4 = (EditText) findViewById(R.id.aplikasi4);
		aplikasi5 = (EditText) findViewById(R.id.aplikasi5);
		aplikasi6 = (EditText) findViewById(R.id.aplikasi6);
		aplikasi711 = (EditText) findViewById(R.id.aplikasi711);
		aplikasi712 = (EditText) findViewById(R.id.aplikasi712);
		aplikasi713 = (EditText) findViewById(R.id.aplikasi713);
		aplikasi8 = (EditText) findViewById(R.id.aplikasi8);
		aplikasi81 = (EditText) findViewById(R.id.aplikasi81);
		aplikasi911 = (EditText) findViewById(R.id.aplikasi911);
		aplikasi912 = (EditText) findViewById(R.id.aplikasi912);
		aplikasi913 = (EditText) findViewById(R.id.aplikasi913);
		aplikasi914 = (EditText) findViewById(R.id.aplikasi914);
		aplikasi915 = (EditText) findViewById(R.id.aplikasi915);
		aplikasi916 = (EditText) findViewById(R.id.aplikasi916);
		aplikasi917 = (EditText) findViewById(R.id.aplikasi917);
		aplikasi918 = (EditText) findViewById(R.id.aplikasi918);
		aplikasi919 = (EditText) findViewById(R.id.aplikasi919);
		aplikasi9110 = (EditText) findViewById(R.id.aplikasi9110);
		aplikasi1051 = (EditText) findViewById(R.id.aplikasi1051);
		aplikasi11 = (EditText) findViewById(R.id.aplikasi11);
		aplikasi2 = (CheckBox) findViewById(R.id.aplikasi2);
		aplikasi10 = (RadioGroup) findViewById(R.id.aplikasi10);
		aplikasi12 = (Button) findViewById(R.id.aplikasi12);
		aplikasi13 = (Button) findViewById(R.id.aplikasi13);
		aplikasi12.setOnClickListener(this);
		aplikasi13.setOnClickListener(this);
		aplikasi10.setOnCheckedChangeListener(this);
		new readRecord().execute();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_aplikasi_pemupukan, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.aplikasi12:
			saveData();
			Intent i = new Intent(this,SpvRcm.class);
			i.putExtra("object", model);
			startActivity(i);
			finish();
			break;
		case R.id.aplikasi13:
			saveData();
			Intent j = new Intent(this,Karyawan.class);
			j.putExtra("object", model);
			startActivity(j);
			finish();
		}
	}

	private void saveData() {
		String aplikasi1data = "0";
		if (!aplikasi1.getText().toString().isEmpty()) {
			aplikasi1data = aplikasi1.getText().toString();
		}
		String aplikasi2data = "0";
		if (aplikasi2.isChecked()) {
			aplikasi2data = "-1";
		}
		String aplikasi3data = "0";
		if (!aplikasi3.getText().toString().isEmpty()) {
			aplikasi3data = aplikasi3.getText().toString();
		}
		String aplikasi4data = "0";
		if (!aplikasi4.getText().toString().isEmpty()) {
			aplikasi4data = aplikasi4.getText().toString();
		}
		String aplikasi5data = "0";
		if (!aplikasi5.getText().toString().isEmpty()) {
			aplikasi5data = aplikasi5.getText().toString();
		}
		String aplikasi6data = "0";
		if (!aplikasi6.getText().toString().isEmpty()) {
			aplikasi6data = aplikasi6.getText().toString();
		}
		String aplikasi711data = "";
		if (!aplikasi711.getText().toString().isEmpty()) {
			aplikasi711data = aplikasi711.getText().toString();
		}
		String aplikasi712data = "";
		if (!aplikasi712.getText().toString().isEmpty()) {
			aplikasi712data = aplikasi712.getText().toString();
		}
		String aplikasi713data = "";
		if (!aplikasi713.getText().toString().isEmpty()) {
			aplikasi713data = aplikasi713.getText().toString();
		}
		String aplikasi8data = "0";
		if (!aplikasi8.getText().toString().isEmpty()) {
			aplikasi8data = aplikasi8.getText().toString();
		}
		String aplikasi81data = "";
		if (!aplikasi81.getText().toString().isEmpty()) {
			aplikasi81data = aplikasi81.getText().toString();
		}
		String aplikasi911data = "0";
		if (!aplikasi911.getText().toString().isEmpty()) {
			aplikasi911data = aplikasi911.getText().toString();
		}
		String aplikasi912data = "0";
		if (!aplikasi912.getText().toString().isEmpty()) {
			aplikasi912data = aplikasi912.getText().toString();
		}
		String aplikasi913data = "0";
		if (!aplikasi913.getText().toString().isEmpty()) {
			aplikasi913data = aplikasi913.getText().toString();
		}
		String aplikasi914data = "0";
		if (!aplikasi914.getText().toString().isEmpty()) {
			aplikasi914data = aplikasi914.getText().toString();
		}
		String aplikasi915data = "0";
		if (!aplikasi915.getText().toString().isEmpty()) {
			aplikasi915data = aplikasi915.getText().toString();
		}
		String aplikasi916data = "0";
		if (!aplikasi916.getText().toString().isEmpty()) {
			aplikasi916data = aplikasi916.getText().toString();
		}
		String aplikasi917data = "0";
		if (!aplikasi917.getText().toString().isEmpty()) {
			aplikasi917data = aplikasi917.getText().toString();
		}
		String aplikasi918data = "0";
		if (!aplikasi918.getText().toString().isEmpty()) {
			aplikasi918data = aplikasi918.getText().toString();
		}
		String aplikasi919data = "0";
		if (!aplikasi919.getText().toString().isEmpty()) {
			aplikasi919data = aplikasi919.getText().toString();
		}
		String aplikasi9110data = "0";
		if (!aplikasi9110.getText().toString().isEmpty()) {
			aplikasi9110data = aplikasi9110.getText().toString();
		}
		String aplikasi10data = "";
		RadioButton rbAplikasi10 = (RadioButton) findViewById(aplikasi10.getCheckedRadioButtonId());
		if (rbAplikasi10.getId() == R.id.aplikasi101) {
			aplikasi10data = "1";
		} else if (rbAplikasi10.getId() == R.id.aplikasi102) {
			aplikasi10data = "2";
		} else if (rbAplikasi10.getId() == R.id.aplikasi103) {
			aplikasi10data = "3";
		} else if (rbAplikasi10.getId() == R.id.aplikasi104) {
			aplikasi10data = "4";
		} else if (rbAplikasi10.getId() == R.id.aplikasi105) {
			aplikasi10data = "0";
		}
		String aplikasi1051data = "";
		if (!aplikasi1051.getText().toString().isEmpty()) {
			aplikasi1051data = aplikasi1051.getText().toString();
		}
		String aplikasi11data = "0";
		if (!aplikasi11.getText().toString().isEmpty()) {
			aplikasi11data = aplikasi11.getText().toString();
		}
		// save to file code
		model.setKarungPecah(aplikasi1data);
		model.setPanenSaatPemupukan(aplikasi2data);
		model.setJumlahPenabur(aplikasi3data);
		model.setJatahPenabur(aplikasi4data);
		model.setJumlahKarung(aplikasi5data);
		model.setSelisihBerat(aplikasi6data);
		model.setWaktuMulai(aplikasi711data);
		model.setWaktuIstirahat(aplikasi712data);
		model.setWaktuSelesai(aplikasi713data);
		model.setJumlahTidakAplikasi(aplikasi8data);
		model.setAlasanTidakAplikasi(aplikasi81data);
		model.setSudahAplikasi1(aplikasi911data);
		model.setSudahAplikasi2(aplikasi912data);
		model.setSudahAplikasi3(aplikasi913data);
		model.setSudahAplikasi4(aplikasi914data);
		model.setSudahAplikasi5(aplikasi915data);
		model.setSudahAplikasi6(aplikasi916data);
		model.setSudahAplikasi7(aplikasi917data);
		model.setSudahAplikasi8(aplikasi918data);
		model.setSudahAplikasi9(aplikasi919data);
		model.setSudahAplikasi10(aplikasi9110data);
		model.setKarungKosong(aplikasi10data);
		model.setKarungKosongLain(aplikasi1051data);
		model.setKarungDikembalikanKeGudang(aplikasi11data);
		try {
			model.saveFRTMain();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.aplikasi10:
			RadioButton temp = (RadioButton)findViewById(aplikasi10.getCheckedRadioButtonId());
			if (temp.getId() == R.id.aplikasi105) {
				aplikasi1051.setVisibility(View.VISIBLE);
			} else {
				aplikasi1051.setVisibility(View.GONE);
			}
			break;
		}
	}
	private class readRecord extends AsyncTask<Void, Void, Void> {
		ProgressDialog progressBar;

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			progressBar = new ProgressDialog(AplikasiPemupukan.this);
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

			return null;
		}

		@Override
		protected void onPostExecute(Void result2) {
			// TODO Auto-generated method stub
			super.onPostExecute(result2);
			progressBar.dismiss();
			aplikasi1.setText(model.getKarungPecah());
			if(model.getPanenSaatPemupukan().equals("-1")){
				aplikasi2.setChecked(true);
			}
			aplikasi3.setText(model.getJumlahPenabur());
			aplikasi4.setText(model.getJatahPenabur());
			aplikasi5.setText(model.getJumlahKarung());
			aplikasi6.setText(model.getSelisihBerat());
			aplikasi711.setText(model.getWaktuMulai());
			aplikasi712.setText(model.getWaktuIstirahat());
			aplikasi713.setText(model.getWaktuSelesai());
			aplikasi8.setText(model.getJumlahTidakAplikasi());
			aplikasi81.setText(model.getAlasanTidakAplikasi());
			aplikasi911.setText(model.getSudahAplikasi1());
			aplikasi912.setText(model.getSudahAplikasi2());
			aplikasi913.setText(model.getSudahAplikasi3());
			aplikasi914.setText(model.getSudahAplikasi4());
			aplikasi915.setText(model.getSudahAplikasi5());
			aplikasi916.setText(model.getSudahAplikasi6());
			aplikasi917.setText(model.getSudahAplikasi7());
			aplikasi918.setText(model.getSudahAplikasi8());
			aplikasi919.setText(model.getSudahAplikasi9());
			aplikasi9110.setText(model.getSudahAplikasi10());
			String karungkosong = model.getKarungKosong();
			if (karungkosong.equals("0")){
			aplikasi10.check(R.id.aplikasi105);	
			}else if(karungkosong.equals("1")){
				aplikasi10.check(R.id.aplikasi101);
			}else if(karungkosong.equals("2")){
				aplikasi10.check(R.id.aplikasi102);
			}else if(karungkosong.equals("3")){
				aplikasi10.check(R.id.aplikasi103);
			}else if(karungkosong.equals("4")){
				aplikasi10.check(R.id.aplikasi104);
			}
			aplikasi1051.setText(model.getKarungKosongLain());
			aplikasi11.setText(model.getKarungDikembalikanKeGudang());
		}

	}
}
