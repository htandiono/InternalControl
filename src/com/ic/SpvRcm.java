package com.ic;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

public class SpvRcm extends Activity implements OnClickListener,
		OnItemSelectedListener {

	private Model model;
	private EditText etspv1111, etspv1112, etspv1113, etspv1121, etspv1122,
			etspv1123, etspv1131, etspv1132, etspv1133, etspv1141, etspv1142,
			etspv1143, etSpv31;
	private CheckBox cb211, cb212, cb221, cb222, cb231, cb232, cb241, cb242,
			cb251, cb252, cb261, cb262, cb271, cb272, cb281, cb282, cb291,
			cb292, cb2101, cb2102;
	private Spinner spSpv3;
	private ArrayList<String> listbulan;
	private String selectedBulan;
	private Button btnPemupukan, btnAuditPemupukan;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spv_rcm);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		Intent modul1 = getIntent();
		model = (Model) modul1.getSerializableExtra("object");
		etspv1111 = (EditText) findViewById(R.id.etspv1111);
		etspv1112 = (EditText) findViewById(R.id.etspv1112);
		etspv1113 = (EditText) findViewById(R.id.etspv1113);
		etspv1121 = (EditText) findViewById(R.id.etspv1121);
		etspv1122 = (EditText) findViewById(R.id.etspv1122);
		etspv1123 = (EditText) findViewById(R.id.etspv1123);
		etspv1131 = (EditText) findViewById(R.id.etspv1131);
		etspv1132 = (EditText) findViewById(R.id.etspv1132);
		etspv1133 = (EditText) findViewById(R.id.etspv1133);
		etspv1141 = (EditText) findViewById(R.id.etspv1141);
		etspv1142 = (EditText) findViewById(R.id.etspv1142);
		etspv1143 = (EditText) findViewById(R.id.etspv1143);
		etSpv31 = (EditText) findViewById(R.id.etSpv31);
		cb211 = (CheckBox) findViewById(R.id.cb211);
		cb212 = (CheckBox) findViewById(R.id.cb212);
		cb221 = (CheckBox) findViewById(R.id.cb221);
		cb222 = (CheckBox) findViewById(R.id.cb222);
		cb231 = (CheckBox) findViewById(R.id.cb231);
		cb232 = (CheckBox) findViewById(R.id.cb232);
		cb241 = (CheckBox) findViewById(R.id.cb241);
		cb242 = (CheckBox) findViewById(R.id.cb242);
		cb251 = (CheckBox) findViewById(R.id.cb251);
		cb252 = (CheckBox) findViewById(R.id.cb252);
		cb261 = (CheckBox) findViewById(R.id.cb261);
		cb262 = (CheckBox) findViewById(R.id.cb262);
		cb271 = (CheckBox) findViewById(R.id.cb271);
		cb272 = (CheckBox) findViewById(R.id.cb272);
		cb281 = (CheckBox) findViewById(R.id.cb281);
		cb282 = (CheckBox) findViewById(R.id.cb282);
		cb291 = (CheckBox) findViewById(R.id.cb291);
		cb292 = (CheckBox) findViewById(R.id.cb292);
		cb2101 = (CheckBox) findViewById(R.id.cb2101);
		cb2102 = (CheckBox) findViewById(R.id.cb2102);
		spSpv3 = (Spinner) findViewById(R.id.spSpv3);
		btnPemupukan = (Button) findViewById(R.id.btnPemupukan);
		btnAuditPemupukan = (Button) findViewById(R.id.btnAuditPemupukan);
		btnPemupukan.setOnClickListener(this);
		btnAuditPemupukan.setOnClickListener(this);
		listbulan = new ArrayList<String>();
		listbulan.add("Januari");
		listbulan.add("Februari");
		listbulan.add("Maret");
		listbulan.add("April");
		listbulan.add("Mei");
		listbulan.add("Juni");
		listbulan.add("Juli");
		listbulan.add("Agustus");
		listbulan.add("September");
		listbulan.add("Oktober");
		listbulan.add("November");
		listbulan.add("Desember");
		spSpv3.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_dropdown_item, listbulan));
		spSpv3.setOnItemSelectedListener(this);
		new readRecord().execute();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_spv_rcm, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.btnPemupukan:
			saveData();
			Intent i = new Intent(this, AplikasiPemupukan.class);
			i.putExtra("object", model);
			startActivity(i);
			finish();
			break;
		case R.id.btnAuditPemupukan:
			saveData();
			Intent j = new Intent(this, Karyawan.class);
			j.putExtra("object", model);
			startActivity(j);
			finish();
			break;
		}
	}

	private void saveData() {
		String spv1111 = "0";
		if (!etspv1111.getText().toString().isEmpty()) {
			spv1111 = etspv1111.getText().toString();
		}
		String spv1112 = "0";
		if (!etspv1112.getText().toString().isEmpty()) {
			spv1112 = etspv1112.getText().toString();
		}
		String spv1113 = "0";
		if (!etspv1113.getText().toString().isEmpty()) {
			spv1113 = etspv1113.getText().toString();
		}
		String spv1121 = "0";
		if (!etspv1121.getText().toString().isEmpty()) {
			spv1121 = etspv1121.getText().toString();
		}
		String spv1122 = "0";
		if (!etspv1122.getText().toString().isEmpty()) {
			spv1122 = etspv1122.getText().toString();
		}
		String spv1123 = "0";
		if (!etspv1123.getText().toString().isEmpty()) {
			spv1123 = etspv1123.getText().toString();
		}
		String spv1131 = "0";
		if (!etspv1131.getText().toString().isEmpty()) {
			spv1131 = etspv1131.getText().toString();
		}
		String spv1132 = "0";
		if (!etspv1132.getText().toString().isEmpty()) {
			spv1132 = etspv1132.getText().toString();
		}
		String spv1133 = "0";
		if (!etspv1133.getText().toString().isEmpty()) {
			spv1133 = etspv1133.getText().toString();
		}
		String spv1141 = "0";
		if (!etspv1141.getText().toString().isEmpty()) {
			spv1141 = etspv1141.getText().toString();
		}
		String spv1142 = "0";
		if (!etspv1142.getText().toString().isEmpty()) {
			spv1142 = etspv1142.getText().toString();
		}
		String spv1143 = "0";
		if (!etspv1143.getText().toString().isEmpty()) {
			spv1143 = etspv1143.getText().toString();
		}
		String Spv31 = "0";
		if (!etSpv31.getText().toString().isEmpty()) {
			Spv31 = etSpv31.getText().toString();
		}
		String c211 = "0";
		if (cb211.isChecked()) {
			c211 = "-1";
		}
		String c212 = "0";
		if (cb212.isChecked()) {
			c212 = "-1";
		}
		String c221 = "0";
		if (cb221.isChecked()) {
			c221 = "-1";
		}
		String c222 = "0";
		if (cb222.isChecked()) {
			c222 = "-1";
		}
		String c231 = "0";
		if (cb231.isChecked()) {
			c231 = "-1";
		}
		String c232 = "0";
		if (cb232.isChecked()) {
			c232 = "-1";
		}
		String c241 = "0";
		if (cb241.isChecked()) {
			c241 = "-1";
		}
		String c242 = "0";
		if (cb242.isChecked()) {
			c242 = "-1";
		}
		String c251 = "0";
		if (cb251.isChecked()) {
			c251 = "-1";
		}
		String c252 = "0";
		if (cb252.isChecked()) {
			c252 = "-1";
		}
		String c261 = "0";
		if (cb261.isChecked()) {
			c261 = "-1";
		}
		String c262 = "0";
		if (cb262.isChecked()) {
			c262 = "-1";
		}
		String c271 = "0";
		if (cb271.isChecked()) {
			c271 = "-1";
		}
		String c272 = "0";
		if (cb272.isChecked()) {
			c272 = "-1";
		}
		String c281 = "0";
		if (cb281.isChecked()) {
			c281 = "-1";
		}
		String c282 = "0";
		if (cb282.isChecked()) {
			c282 = "-1";
		}
		String c291 = "0";
		if (cb291.isChecked()) {
			c291 = "-1";
		}
		String c292 = "0";
		if (cb292.isChecked()) {
			c292 = "-1";
		}
		String c2101 = "0";
		if (cb2101.isChecked()) {
			c2101 = "-1";
		}
		String c2102 = "0";
		if (cb2102.isChecked()) {
			c2102 = "-1";
		}
		// save to file
		model.setMandorJumlah(spv1111);
		model.setMandorFT(spv1112);
		model.setMandorPT(spv1113);
		model.setAslapJumlah(spv1121);
		model.setAslapFT(spv1122);
		model.setAslapPT(spv1123);
		model.setAskepJumlah(spv1131);
		model.setAskepFT(spv1132);
		model.setAskepPT(spv1133);
		model.setManagerJumlah(spv1141);
		model.setManagerFT(spv1142);
		model.setManagerPT(spv1143);
		model.setMandor1(c211);
		model.setMandor2(c221);
		model.setMandor3(c231);
		model.setMandor4(c241);
		model.setMandor5(c251);
		model.setMandor6(c261);
		model.setMandor7(c271);
		model.setMandor8(c281);
		model.setMandor9(c291);
		model.setMandor10(c2101);
		model.setAslap1(c212);
		model.setAslap2(c222);
		model.setAslap3(c232);
		model.setAslap4(c242);
		model.setAslap5(c252);
		model.setAslap6(c262);
		model.setAslap7(c272);
		model.setAslap8(c282);
		model.setAslap9(c292);
		model.setAslap10(c2102);
		model.setRekomendasi(selectedBulan);
		model.setAlasanBeda(Spv31);
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
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		if (spSpv3.getItemAtPosition(arg2).toString().equals("Januari")) {
			selectedBulan = "1";
		} else if (spSpv3.getItemAtPosition(arg2).toString().equals("Febuari")) {
			selectedBulan = "2";
		} else if (spSpv3.getItemAtPosition(arg2).toString().equals("Maret")) {
			selectedBulan = "3";
		} else if (spSpv3.getItemAtPosition(arg2).toString().equals("April")) {
			selectedBulan = "4";
		} else if (spSpv3.getItemAtPosition(arg2).toString().equals("Mei")) {
			selectedBulan = "5";
		} else if (spSpv3.getItemAtPosition(arg2).toString().equals("Juni")) {
			selectedBulan = "6";
		} else if (spSpv3.getItemAtPosition(arg2).toString().equals("Juli")) {
			selectedBulan = "7";
		} else if (spSpv3.getItemAtPosition(arg2).toString().equals("Agustus")) {
			selectedBulan = "8";
		} else if (spSpv3.getItemAtPosition(arg2).toString()
				.equals("September")) {
			selectedBulan = "9";
		} else if (spSpv3.getItemAtPosition(arg2).toString().equals("Oktober")) {
			selectedBulan = "10";
		} else if (spSpv3.getItemAtPosition(arg2).toString().equals("November")) {
			selectedBulan = "11";
		} else if (spSpv3.getItemAtPosition(arg2).toString().equals("Desember")) {
			selectedBulan = "12";
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}

	private class readRecord extends AsyncTask<Void, Void, Void> {
		ProgressDialog progressBar;

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			progressBar = new ProgressDialog(SpvRcm.this);
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
			etspv1111.setText(model.getMandorJumlah());
			etspv1112.setText(model.getMandorFT());
			etspv1113.setText(model.getMandorPT());
			etspv1121.setText(model.getAslapJumlah());
			etspv1122.setText(model.getAslapFT());
			etspv1123.setText(model.getAslapPT());
			etspv1131.setText(model.getAskepJumlah());
			etspv1132.setText(model.getAskepFT());
			etspv1133.setText(model.getAskepPT());
			etspv1141.setText(model.getManagerJumlah());
			etspv1142.setText(model.getManagerFT());
			etspv1143.setText(model.getManagerPT());
			if(model.getMandor1().equals("-1")){
				cb211.setChecked(true);
			}
			if(model.getMandor2().equals("-1")){
				cb221.setChecked(true);
			}
			if(model.getMandor3().equals("-1")){
				cb231.setChecked(true);
			}
			if(model.getMandor4().equals("-1")){
				cb241.setChecked(true);
			}
			if(model.getMandor5().equals("-1")){
				cb251.setChecked(true);
			}
			if(model.getMandor6().equals("-1")){
				cb261.setChecked(true);
			}
			if(model.getMandor7().equals("-1")){
				cb271.setChecked(true);
			}
			if(model.getMandor8().equals("-1")){
				cb281.setChecked(true);
			}
			if(model.getMandor9().equals("-1")){
				cb291.setChecked(true);
			}
			if(model.getMandor10().equals("-1")){
				cb2101.setChecked(true);
			}
			if(model.getAslap1().equals("-1")){
				cb212.setChecked(true);
			}
			if(model.getAslap2().equals("-1")){
				cb222.setChecked(true);
			}
			if(model.getAslap3().equals("-1")){
				cb232.setChecked(true);
			}
			if(model.getAslap4().equals("-1")){
				cb242.setChecked(true);
			}
			if(model.getAslap5().equals("-1")){
				cb252.setChecked(true);
			}
			if(model.getAslap6().equals("-1")){
				cb262.setChecked(true);
			}
			if(model.getAslap7().equals("-1")){
				cb272.setChecked(true);
			}
			if(model.getAslap8().equals("-1")){
				cb282.setChecked(true);
			}
			if(model.getAslap9().equals("-1")){
				cb292.setChecked(true);
			}
			if(model.getAslap10().equals("-1")){
				cb2102.setChecked(true);
			}
			String bulan = model.getRekomendasi();
			int rekomendasi= 0;
			if (bulan.equals("1")){
				rekomendasi = listbulan.indexOf("Januari");
			}else if(bulan.equals("2")){
				rekomendasi = listbulan.indexOf("Februari");
			}else if(bulan.equals("3")){
				rekomendasi = listbulan.indexOf("Maret");
			}else if(bulan.equals("4")){
				rekomendasi = listbulan.indexOf("April");
			}else if(bulan.equals("5")){
				rekomendasi = listbulan.indexOf("Mei");
			}else if(bulan.equals("6")){
				rekomendasi = listbulan.indexOf("Juni");
			}else if(bulan.equals("7")){
				rekomendasi = listbulan.indexOf("Juli");
			}else if(bulan.equals("8")){
				rekomendasi = listbulan.indexOf("Agustus");
			}else if(bulan.equals("9")){
				rekomendasi = listbulan.indexOf("September");
			}else if(bulan.equals("10")){
				rekomendasi = listbulan.indexOf("Oktober");
			}else if(bulan.equals("11")){
				rekomendasi = listbulan.indexOf("November");
			}else if(bulan.equals("12")){
				rekomendasi = listbulan.indexOf("Desember");
			}
			spSpv3.setSelection(rekomendasi);
			etSpv31.setText(model.getAlasanBeda());
		}
	}

}
