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
import android.widget.TextView;

public class Pupuk extends Activity implements OnClickListener,
		OnItemSelectedListener,Observer {

	private Model model;
	private Spinner spPupuk1, spPupuk7, spPupuk4;
	private CheckBox cbPupuk2, cbPupuk31, cbPupuk32, cbPupuk33, cbPupuk6;
	private EditText etPupuk5, etPupuk51, etPupuk52, etPupuk53;
	private Button btnPupuk8, btnPupuk9, btnPupuk10, btnPupuk11;
	private ArrayList<String> pupuk1List, pupuk4List, pupuk7List;
	private String pupuk1Data, pupuk4Data, pupuk7Data;
	private TextView tvPupuk51,tvPupuk52,tvPupuk53,Time,Pokok;
	private String empCode;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pupuk);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		Intent modul1 = getIntent();
		model = (Model) modul1.getSerializableExtra("object");
		model.addObserver(this);
		spPupuk1 = (Spinner) findViewById(R.id.spPupuk1);
		spPupuk7 = (Spinner) findViewById(R.id.spPupuk7);
		spPupuk4 = (Spinner) findViewById(R.id.spPupuk4);
		cbPupuk2 = (CheckBox) findViewById(R.id.cbPupuk2);
		cbPupuk31 = (CheckBox) findViewById(R.id.cbPupuk31);
		cbPupuk32 = (CheckBox) findViewById(R.id.cbPupuk32);
		cbPupuk33 = (CheckBox) findViewById(R.id.cbPupuk33);
		cbPupuk6 = (CheckBox) findViewById(R.id.cbPupuk6);
		etPupuk5 = (EditText) findViewById(R.id.etPupuk5);
		etPupuk51 = (EditText) findViewById(R.id.etPupuk51);
		etPupuk52 = (EditText) findViewById(R.id.etPupuk52);
		etPupuk53 = (EditText) findViewById(R.id.etPupuk53);
		btnPupuk8 = (Button) findViewById(R.id.btnPupuk8);
		btnPupuk9 = (Button) findViewById(R.id.btnPupuk9);
		btnPupuk10 = (Button) findViewById(R.id.btnPupuk10);
		btnPupuk11 = (Button) findViewById(R.id.btnPupuk11);
		tvPupuk51 = (TextView) findViewById(R.id.tvPupuk51);
		tvPupuk52 = (TextView) findViewById(R.id.tvPupuk52);
		tvPupuk53 = (TextView) findViewById(R.id.tvPupuk53);
		Time = (TextView) findViewById(R.id.pupukheader2);
		Pokok = (TextView) findViewById(R.id.pupukheader1);
		btnPupuk8.setOnClickListener(this);
		btnPupuk9.setOnClickListener(this);
		btnPupuk10.setOnClickListener(this);
		btnPupuk11.setOnClickListener(this);
		pupuk1List = new ArrayList<String>();
		pupuk4List = new ArrayList<String>();
		pupuk7List = new ArrayList<String>();
		pupuk1List.add("Barren/Steril");
		pupuk1List.add("Mati/Kosong");
		pupuk1List.add("Sisipan");
		pupuk1List.add("Tumbang");
		pupuk1List.add("Kembar");
		pupuk1List.add("Normal");
		pupuk4List.add("Becek");
		pupuk4List.add("Tergenang");
		pupuk4List.add("Gulma");
		pupuk4List.add("Objek Asing");
		pupuk4List.add("Normal");
		pupuk7List.add("Menggumpal");
		pupuk7List.add("Basah");
		pupuk7List.add("Baik");
		spPupuk1.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_dropdown_item, pupuk1List));
		spPupuk4.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_dropdown_item, pupuk4List));
		spPupuk7.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_dropdown_item, pupuk7List));
		spPupuk1.setOnItemSelectedListener(this);
		spPupuk7.setOnItemSelectedListener(this);
		spPupuk4.setOnItemSelectedListener(this);
		if (model.getArealAplikasi().equalsIgnoreCase("0")){
			etPupuk5.setVisibility(View.VISIBLE);
			tvPupuk51.setVisibility(View.GONE);
			tvPupuk52.setVisibility(View.GONE);
			tvPupuk53.setVisibility(View.GONE);
			etPupuk51.setVisibility(View.GONE);
			etPupuk52.setVisibility(View.GONE);
			etPupuk53.setVisibility(View.GONE);
		}else{
			etPupuk5.setVisibility(View.GONE);
			tvPupuk51.setVisibility(View.VISIBLE);
			tvPupuk52.setVisibility(View.VISIBLE);
			tvPupuk53.setVisibility(View.VISIBLE);
			etPupuk51.setVisibility(View.VISIBLE);
			etPupuk52.setVisibility(View.VISIBLE);
			etPupuk53.setVisibility(View.VISIBLE);
		}
		//get EmpCode
		try {
			empCode=model.readFRTKaryawanType();
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(empCode);
		Thread myThread = null;
		Runnable runnable = new Time();
		myThread = new Thread(runnable);
		myThread.start();
		model.setFrtpokok(1);
		Pokok.setText(""+model.getFrtpokok());
		new readRecord().execute();
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
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_pupuk, menu);
		return true;
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.spPupuk1:
			if (spPupuk1.getItemAtPosition(spPupuk1.getSelectedItemPosition()).toString()
					.equals("Barren/Steril")) {
				pupuk1Data = "b";
			} else if (spPupuk1.getItemAtPosition(spPupuk1.getSelectedItemPosition()).toString()
					.equals("Mati/Kosong")) {
				pupuk1Data = "x";
			} else if (spPupuk1.getItemAtPosition(spPupuk1.getSelectedItemPosition()).toString()
					.equals("Sisipan")) {
				pupuk1Data = "s";
			} else if (spPupuk1.getItemAtPosition(spPupuk1.getSelectedItemPosition()).toString()
					.equals("Tumbang")) {
				pupuk1Data = "t";
			} else if (spPupuk1.getItemAtPosition(spPupuk1.getSelectedItemPosition()).toString()
					.equals("Kembar")) {
				pupuk1Data = "k";
			} else if (spPupuk1.getItemAtPosition(spPupuk1.getSelectedItemPosition()).toString()
					.equals("Normal")) {
				pupuk1Data = "";
			}
			break;
		case R.id.spPupuk4:
			if (spPupuk4.getItemAtPosition(arg2).toString().equals("Becek")) {
				pupuk4Data = "b";
			} else if (spPupuk4.getItemAtPosition(arg2).toString()
					.equals("Tergenang")) {
				pupuk4Data = "t";
			} else if (spPupuk4.getItemAtPosition(arg2).toString()
					.equals("Gulma")) {
				pupuk4Data = "w";
			} else if (spPupuk4.getItemAtPosition(arg2).toString()
					.equals("Objek Asing")) {
				pupuk4Data = "o";
			} else if (spPupuk4.getItemAtPosition(arg2).toString()
					.equals("Normal")) {
				pupuk4Data = "";
			}
			break;
		case R.id.spPupuk7:
			if (spPupuk7.getItemAtPosition(arg2).toString()
					.equals("Menggumpal")) {
				pupuk7Data = "g";
			} else if (spPupuk7.getItemAtPosition(arg2).toString()
					.equals("Basah")) {
				pupuk7Data = "b";
			} else if (spPupuk7.getItemAtPosition(arg2).toString()
					.equals("Baik")) {
				pupuk7Data = "";
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
		switch (arg0.getId()) {
		case R.id.btnPupuk8:
			model.prevFRT();
			saveData();
			break;
		case R.id.btnPupuk9:
			saveData();
			Intent i = new Intent(this,Setelahpupuk.class);
			i.putExtra("object",model);
			startActivity(i);
			finish();
			break;
		case R.id.btnPupuk10:
			model.nextFRT();
			saveData();
			break;
		case R.id.btnPupuk11:
			saveData();
			Intent j = new Intent(this,Karyawan.class);
			j.putExtra("object", model);
			startActivity(j);
			finish();
		}
	}

	private void saveData() {
		String pupuk2 = "0";
		if (cbPupuk2.isChecked()) {
			pupuk2 = "-1";
		}
		String pupuk31 = "0";
		if (cbPupuk31.isChecked()) {
			pupuk31 = "-1";
		}
		String pupuk32 = "0";
		if (cbPupuk32.isChecked()) {
			pupuk32 = "-1";
		}
		String pupuk33 = "0";
		if (cbPupuk33.isChecked()) {
			pupuk33 = "-1";
		}
		String pupuk5 = "0";
		if (!etPupuk5.getText().toString().isEmpty()) {
			pupuk5 = etPupuk5.getText().toString();
		}
		String pupuk51 = "0";
		if (!etPupuk51.getText().toString().isEmpty()) {
			pupuk51 = etPupuk51.getText().toString();
		}
		String pupuk52 = "0";
		if (!etPupuk52.getText().toString().isEmpty()) {
			pupuk52 = etPupuk52.getText().toString();
		}
		String pupuk53 = "0";
		if (!etPupuk53.getText().toString().isEmpty()) {
			pupuk53 = etPupuk53.getText().toString();
		}
		String pupuk6 = "0";
		if (cbPupuk6.isChecked()) {
			pupuk6 = "-1";
		}
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		String Time = new SimpleDateFormat("HH:mm:ss").format(date);
		try {
			model.storeFRTSemasa(empCode, pupuk1Data, pupuk2, pupuk31, pupuk32,pupuk33, pupuk4Data, pupuk5, pupuk51, pupuk52, pupuk53, pupuk6, pupuk7Data, Time);
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

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		int pokokpointer = model.getFrtpokok();
		Pokok.setText(""+pokokpointer);
		spPupuk1.setSelected(false);
		cbPupuk2.setChecked(false);
		cbPupuk31.setChecked(false);
		cbPupuk32.setChecked(false);
		cbPupuk33.setChecked(false);
		spPupuk4.setSelected(false);
		etPupuk5.setText(null);
		etPupuk51.setText(null);
		etPupuk52.setText(null);
		etPupuk53.setText(null);
		cbPupuk6.setChecked(false);
		spPupuk7.setSelected(false);
		if (pokokpointer ==1){
			btnPupuk8.setEnabled(false);
		}else{
			btnPupuk8.setEnabled(true);
		}
		new readRecord().execute();
	}
	
	private class readRecord extends AsyncTask<Void, Void, Void> {
		ProgressDialog progressBar;
		boolean found;

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			progressBar = new ProgressDialog(Pupuk.this);
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
				found = model.readFRTPupukSemasa();
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
					result = model.readFRTPupukSemasaDetail();
					int pupuk1 = 0;
					String pupuk1Saved = result.get(0);
					if (pupuk1Saved.equals("")){
						pupuk1 = pupuk1List.indexOf("Normal");
					}else if(pupuk1Saved.equals("b")){
						pupuk1 = pupuk1List.indexOf("Barren/Steril");
					}else if(pupuk1Saved.equals("x")){
						pupuk1 = pupuk1List.indexOf("Mati/Kosong");
					}else if(pupuk1Saved.equals("s")){
						pupuk1 = pupuk1List.indexOf("Sisipan");
					}else if(pupuk1Saved.equals("t")){
						pupuk1 = pupuk1List.indexOf("Tumbang");
					}else if(pupuk1Saved.equals("k")){
						pupuk1 = pupuk1List.indexOf("Kembar");
					}
					spPupuk1.setSelection(pupuk1);
					if (result.get(1).equals("-1")){
						cbPupuk2.setChecked(true);
					}
					if (result.get(2).equals("-1")){
						cbPupuk31.setChecked(true);
					}
					if (result.get(3).equals("-1")){
						cbPupuk32.setChecked(true);
					}
					if (result.get(4).equals("-1")){
						cbPupuk33.setChecked(true);
					}
					int pupuk4 = 0;
					String pupuk4Saved = result.get(5);
					if (pupuk4Saved.equals("")){
						pupuk4 = pupuk4List.indexOf("Normal");
					}else if(pupuk4Saved.equals("b")){
						pupuk4 = pupuk4List.indexOf("Becek");
					}else if(pupuk4Saved.equals("t")){
						pupuk4 = pupuk4List.indexOf("Tergenang");
					}else if(pupuk4Saved.equals("w")){
						pupuk4 = pupuk4List.indexOf("Gulma");
					}else if(pupuk4Saved.equals("o")){
						pupuk4 = pupuk4List.indexOf("Objek Asing");
					}
					spPupuk4.setSelection(pupuk4);
					etPupuk5.setText(result.get(6));
					etPupuk51.setText(result.get(7));
					etPupuk52.setText(result.get(8));
					etPupuk53.setText(result.get(9));
					if (result.get(10).equals("-1")){
						cbPupuk6.setChecked(true);
					}
					int pupuk7 =0;
					String pupuk7Saved = result.get(11);
					if (pupuk7Saved.equals("")){
						pupuk7 = pupuk7List.indexOf("Baik");
					}else if(pupuk7Saved.equals("g")){
						pupuk7 = pupuk7List.indexOf("Menggumpal");
					}else if(pupuk7Saved.equals("b")){
						pupuk7 = pupuk7List.indexOf("Basah");
					}
					spPupuk7.setSelection(pupuk7);
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
