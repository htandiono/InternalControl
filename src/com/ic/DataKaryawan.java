package com.ic;

import java.io.IOException;
import java.util.ArrayList;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

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

public class DataKaryawan extends Activity implements OnClickListener, OnItemSelectedListener {
	private Model model;
	private EditText etKaryawan1, etKaryawan3, etKaryawan4, etKaryawan1011,
			etKaryawan1012, etKaryawan1021, etKaryawan1022, etKaryawan1031,
			etKaryawan1032, etKaryawan1041, etKaryawan1042;
	private Spinner spKaryawan2, spKaryawan71, spKaryawan72;
	private CheckBox cbKaryawan5, cbKaryawan6, cbKaryawan8, cbKaryawan932, cbKaryawan933, cbKaryawan942,
			cbKaryawan943, cbKaryawan952, cbKaryawan953, cbKaryawan962,
			cbKaryawan963, cbKaryawan972, cbKaryawan973;
	private Button btnSemasaPemupukan, btnSesudahPemupukan;
	private ArrayList<String> karyawan2List, karyawan71List,karyawan72List;
	private String karyawan2Data,karyawan71Data, karyawan72Data;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_data_karyawan);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		Intent modul1 = getIntent();
		model = (Model) modul1.getSerializableExtra("object");
		etKaryawan1 = (EditText) findViewById(R.id.etKaryawan1);
		etKaryawan3 = (EditText) findViewById(R.id.etKaryawan3);
		etKaryawan4 = (EditText) findViewById(R.id.etKaryawan4);
		etKaryawan1011 = (EditText) findViewById(R.id.etKaryawan1011);
		etKaryawan1012 = (EditText) findViewById(R.id.etKaryawan1012);
		etKaryawan1021 = (EditText) findViewById(R.id.etKaryawan1021);
		etKaryawan1022 = (EditText) findViewById(R.id.etKaryawan1022);
		etKaryawan1031 = (EditText) findViewById(R.id.etKaryawan1031);
		etKaryawan1032 = (EditText) findViewById(R.id.etKaryawan1032);
		etKaryawan1041 = (EditText) findViewById(R.id.etKaryawan1041);
		etKaryawan1042 = (EditText) findViewById(R.id.etKaryawan1042);
		spKaryawan2 = (Spinner) findViewById(R.id.spKaryawan2);
		spKaryawan71 = (Spinner) findViewById(R.id.spKaryawan71);
		spKaryawan72 = (Spinner) findViewById(R.id.spKaryawan72);
		cbKaryawan5 = (CheckBox) findViewById(R.id.cbKaryawan5);
		cbKaryawan6 = (CheckBox) findViewById(R.id.cbKaryawan6);
		cbKaryawan8 = (CheckBox) findViewById(R.id.cbKaryawan8);
		cbKaryawan932 = (CheckBox) findViewById(R.id.cbKaryawan932);
		cbKaryawan933 = (CheckBox) findViewById(R.id.cbKaryawan933);
		cbKaryawan942 = (CheckBox) findViewById(R.id.cbKaryawan942);
		cbKaryawan943 = (CheckBox) findViewById(R.id.cbKaryawan943);
		cbKaryawan952 = (CheckBox) findViewById(R.id.cbKaryawan952);
		cbKaryawan953 = (CheckBox) findViewById(R.id.cbKaryawan953);
		cbKaryawan962 = (CheckBox) findViewById(R.id.cbKaryawan962);
		cbKaryawan963 = (CheckBox) findViewById(R.id.cbKaryawan963);
		cbKaryawan972 = (CheckBox) findViewById(R.id.cbKaryawan972);
		cbKaryawan973 = (CheckBox) findViewById(R.id.cbKaryawan973);
		btnSemasaPemupukan = (Button) findViewById(R.id.btnSemasaPemupukan);
		btnSesudahPemupukan = (Button) findViewById(R.id.btnSesudahPemupukan);
		karyawan2List = new ArrayList<String>();
		karyawan71List = new ArrayList<String>();
		karyawan72List = new ArrayList<String>();
		karyawan2List.add("BHL");
		karyawan2List.add("Tetap");
		karyawan2List.add("Kontrak");
		karyawan71List.add("Coklat Muda");
		karyawan71List.add("Biru");
		karyawan71List.add("Kuning");
		karyawan71List.add("Hijau");
		karyawan71List.add("Orange");
		karyawan71List.add("Merah");
		spKaryawan2.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_dropdown_item, karyawan2List));
		spKaryawan71.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_dropdown_item, karyawan71List));
		spKaryawan2.setOnItemSelectedListener(this);
		spKaryawan71.setOnItemSelectedListener(this);
		spKaryawan72.setOnItemSelectedListener(this);
		btnSemasaPemupukan.setOnClickListener(this);
		btnSesudahPemupukan.setOnClickListener(this);
		new readRecord().execute();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_data_karyawan, menu);
		return true;
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.spKaryawan2:
			if(spKaryawan2.getItemAtPosition(arg2).toString().equals("BHL")){
				karyawan2Data = "0";				
			}else if(spKaryawan2.getItemAtPosition(arg2).toString().equals("Tetap")){
				karyawan2Data = "1";
			}else if(spKaryawan2.getItemAtPosition(arg2).toString().equals("Kontrak")){
				karyawan2Data = "2";
			}
			break;
		case R.id.spKaryawan71:
			if(spKaryawan71.getItemAtPosition(arg2).toString().equals("Coklat Muda")){
				karyawan71Data = "Coklat Muda";
				karyawan72List.clear();
				karyawan72List.add("1000 gram");
				spKaryawan72.setAdapter(new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_dropdown_item, karyawan72List));
				spKaryawan2.setOnItemSelectedListener(this);
			}else if(spKaryawan71.getItemAtPosition(arg2).toString().equals("Biru")){
				karyawan71Data = "Biru";
				karyawan72List.clear();
				karyawan72List.add("750 gram");
				karyawan72List.add("500 gram");
				spKaryawan72.setAdapter(new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_dropdown_item, karyawan72List));
				spKaryawan2.setOnItemSelectedListener(this);
			}else if(spKaryawan71.getItemAtPosition(arg2).toString().equals("Kuning")){
				karyawan71Data = "Kuning";
				karyawan72List.clear();
				karyawan72List.add("750 gram");
				karyawan72List.add("500 gram");
				spKaryawan72.setAdapter(new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_dropdown_item, karyawan72List));
				spKaryawan2.setOnItemSelectedListener(this);
			}else if(spKaryawan71.getItemAtPosition(arg2).toString().equals("Hijau")){
				karyawan71Data = "Hijau";
				karyawan72List.clear();
				karyawan72List.add("750 gram");
				karyawan72List.add("500 gram");
				spKaryawan72.setAdapter(new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_dropdown_item, karyawan72List));
				spKaryawan2.setOnItemSelectedListener(this);
			}else if(spKaryawan71.getItemAtPosition(arg2).toString().equals("Orange")){
				karyawan71Data = "Orange";
				karyawan72List.clear();
				karyawan72List.add("750 gram");
				karyawan72List.add("500 gram");
				spKaryawan72.setAdapter(new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_dropdown_item, karyawan72List));
				spKaryawan2.setOnItemSelectedListener(this);
			}else if(spKaryawan71.getItemAtPosition(arg2).toString().equals("Merah")){
				karyawan71Data = "Merah";
				karyawan72List.clear();
				karyawan72List.add("50 gram");
				spKaryawan72.setAdapter(new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_dropdown_item, karyawan72List));
				spKaryawan2.setOnItemSelectedListener(this);
			}
			break;
		case R.id.spKaryawan72:
			if(spKaryawan72.getItemAtPosition(arg2).toString().equals("1000 gram")){
				karyawan72Data = "1000 gram";
			}else if(spKaryawan72.getItemAtPosition(arg2).toString().equals("750 gram")){
				karyawan72Data = "750 gram";
			}else if(spKaryawan72.getItemAtPosition(arg2).toString().equals("500 gram")){
				karyawan72Data = "500 gram";
			}else if(spKaryawan72.getItemAtPosition(arg2).toString().equals("50 gram")){
				karyawan72Data = "50 gram";
			}
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.btnSemasaPemupukan:
			saveData();
			Intent i = new Intent(this,Pupuk.class);
			i.putExtra("object",model);
			startActivity(i);
			finish();
			break;
		case R.id.btnSesudahPemupukan:
			saveData();
			Intent j = new Intent(this,Setelahpupuk.class);
			j.putExtra("object",model);
			startActivity(j);
			finish();
		}
	}
	
	private void saveData(){
		String karyawan1 = "";
		if (!etKaryawan1.getText().toString().isEmpty()){
			karyawan1 = etKaryawan1.getText().toString();
		}
		String karyawan3 = "";
		if (!etKaryawan3.getText().toString().isEmpty()){
			karyawan3 = etKaryawan3.getText().toString();
		}
		String karyawan4 = "0";
		if(!etKaryawan4.getText().toString().isEmpty()){
			karyawan4 = etKaryawan4.getText().toString();
		}
		String karyawan5 = "0";
		if(cbKaryawan5.isChecked()){
			karyawan5 = "-1";
		}
		String karyawan6 = "0";
		if(cbKaryawan6.isChecked()){
			karyawan6 ="-1";
		}
		String karyawan8 = "0";
		if(cbKaryawan8.isChecked()){
			karyawan8 = "-1";
		}
		String karyawan932= "0";
		if(cbKaryawan932.isChecked()){
			karyawan932 = "-1";
		}
		String karyawan933 = "0";
		if(cbKaryawan933.isChecked()){
			karyawan933 = "-1";
		}
		String karyawan942= "0";
		if(cbKaryawan942.isChecked()){
			karyawan942 = "-1";
		}
		String karyawan943 = "0";
		if(cbKaryawan943.isChecked()){
			karyawan943 = "-1";
		}
		String karyawan952= "0";
		if(cbKaryawan952.isChecked()){
			karyawan952 = "-1";
		}
		String karyawan953 = "0";
		if(cbKaryawan953.isChecked()){
			karyawan953 = "-1";
		}
		String karyawan962= "0";
		if(cbKaryawan962.isChecked()){
			karyawan962 = "-1";
		}
		String karyawan963 = "0";
		if(cbKaryawan963.isChecked()){
			karyawan963 = "-1";
		}
		String karyawan972= "0";
		if(cbKaryawan972.isChecked()){
			karyawan972 = "-1";
		}
		String karyawan973 = "0";
		if(cbKaryawan973.isChecked()){
			karyawan973 = "-1";
		}
		String karyawan1011 = "0";
		if(!etKaryawan1011.getText().toString().isEmpty()){
			karyawan1011 = etKaryawan1011.getText().toString();
		}
		String karyawan1012 = "0";
		if(!etKaryawan1012.getText().toString().isEmpty()){
			karyawan1012 = etKaryawan1012.getText().toString();
		}
		String karyawan1021 = "0";
		if(!etKaryawan1021.getText().toString().isEmpty()){
			karyawan1021 = etKaryawan1021.getText().toString();
		}
		String karyawan1022 = "0";
		if(!etKaryawan1022.getText().toString().isEmpty()){
			karyawan1022 = etKaryawan1022.getText().toString();
		}
		String karyawan1031 = "0";
		if(!etKaryawan1031.getText().toString().isEmpty()){
			karyawan1031 = etKaryawan1031.getText().toString();
		}
		String karyawan1032 = "0";
		if(!etKaryawan1032.getText().toString().isEmpty()){
			karyawan1032 = etKaryawan1032.getText().toString();
		}
		String karyawan1041 = "0";
		if(!etKaryawan1041.getText().toString().isEmpty()){
			karyawan1041 = etKaryawan1041.getText().toString();
		}
		String karyawan1042 = "0";
		if(!etKaryawan1042.getText().toString().isEmpty()){
			karyawan1042 = etKaryawan1042.getText().toString();
		}
		//save to file code
		try {
			model.storeFRTKary(karyawan1,karyawan2Data,karyawan3,karyawan4,karyawan5,karyawan6, karyawan71Data,karyawan72Data, karyawan8,karyawan932,karyawan933,karyawan942,karyawan943, karyawan952, karyawan953, karyawan962, karyawan963, karyawan972, karyawan973,karyawan1011, karyawan1012, karyawan1021,karyawan1022,karyawan1031,karyawan1032,karyawan1041,karyawan1042);
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
	
	private class readRecord extends AsyncTask<Void, Void, Void> {
		ProgressDialog progressBar;
		boolean found;

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			progressBar = new ProgressDialog(DataKaryawan.this);
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
				found = model.readFRTKaryawanNo();
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
					result = model.readFRTKaryawan();
					etKaryawan1.setText(result.get(0));
					int karyawan2 =0;
					String karyawan2Saved = result.get(1);
					if (karyawan2Saved.equals("0")){
						karyawan2 = karyawan2List.indexOf("BHL");
					}else if (karyawan2Saved.equals("1")){
						karyawan2 = karyawan2List.indexOf("Tetap");
					}else if(karyawan2Saved.equals("2")){
						karyawan2 = karyawan2List.indexOf("Kontrak");
					}
					spKaryawan2.setSelection(karyawan2);
					etKaryawan3.setText(result.get(2));
					etKaryawan4.setText(result.get(3));
					if (result.get(4).equals("-1")){
						cbKaryawan5.setChecked(true);
					}
					if (result.get(5).equals("-1")){
						cbKaryawan6.setChecked(true);
					}
					spKaryawan71.setSelection(karyawan71List.indexOf(result.get(6)));
					spKaryawan72.setSelection(karyawan72List.indexOf(result.get(7)));
					if (result.get(8).equals("-1")){
						cbKaryawan8.setChecked(true);
					}
					if(result.get(9).equals("-1")){
						cbKaryawan932.setChecked(true);
					}
					if(result.get(10).equals("-1")){
						cbKaryawan933.setChecked(true);
					}
					if(result.get(11).equals("-1")){
						cbKaryawan942.setChecked(true);
					}
					if(result.get(12).equals("-1")){
						cbKaryawan943.setChecked(true);
					}
					if(result.get(13).equals("-1")){
						cbKaryawan952.setChecked(true);
					}
					if(result.get(14).equals("-1")){
						cbKaryawan953.setChecked(true);
					}
					if(result.get(15).equals("-1")){
						cbKaryawan962.setChecked(true);
					}
					if(result.get(16).equals("-1")){
						cbKaryawan963.setChecked(true);
					}
					if(result.get(17).equals("-1")){
						cbKaryawan972.setChecked(true);
					}
					if(result.get(18).equals("-1")){
						cbKaryawan973.setChecked(true);
					}
					etKaryawan1011.setText(result.get(19));
					etKaryawan1012.setText(result.get(20));
					etKaryawan1021.setText(result.get(21));
					etKaryawan1022.setText(result.get(22));
					etKaryawan1031.setText(result.get(23));
					etKaryawan1032.setText(result.get(24));
					etKaryawan1041.setText(result.get(25));
					etKaryawan1042.setText(result.get(26));
				} catch (BiffException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}


}
