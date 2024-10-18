package com.ic;

import java.io.IOException;

import jxl.read.biff.BiffException;
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
import android.widget.EditText;

public class Karyawan extends Activity implements OnClickListener {
	private Model model;
	private EditText etJenisKaryawan1, etJenisKaryawan2, etJenisKaryawan3,
			etJenisKaryawan4, etJenisKaryawan5, etJenisKaryawan6,
			etJenisKaryawan7, etJenisKaryawan8, etJenisKaryawan9,
			etJenisKaryawan10, etKodeKaryawan1, etKodeKaryawan2,
			etKodeKaryawan3, etKodeKaryawan4, etKodeKaryawan5, etKodeKaryawan6,
			etKodeKaryawan7, etKodeKaryawan8, etKodeKaryawan9,
			etKodeKaryawan10;
	private Button tvSwipe1, tvSwipe2, tvSwipe3, tvSwipe4, tvSwipe5, tvSwipe6,
			tvSwipe7, tvSwipe8, tvSwipe9, tvSwipe10;
	private String[] KodeKaryawan,JenisKaryawan;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_karyawan);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		Intent modul1 = getIntent();
		model = (Model) modul1.getSerializableExtra("object");
		etJenisKaryawan1 = (EditText) findViewById(R.id.etJenisKaryawan1);
		etJenisKaryawan2 = (EditText) findViewById(R.id.etJenisKaryawan2);
		etJenisKaryawan3 = (EditText) findViewById(R.id.etJenisKaryawan3);
		etJenisKaryawan4 = (EditText) findViewById(R.id.etJenisKaryawan4);
		etJenisKaryawan5 = (EditText) findViewById(R.id.etJenisKaryawan5);
		etJenisKaryawan6 = (EditText) findViewById(R.id.etJenisKaryawan6);
		etJenisKaryawan7 = (EditText) findViewById(R.id.etJenisKaryawan7);
		etJenisKaryawan8 = (EditText) findViewById(R.id.etJenisKaryawan8);
		etJenisKaryawan9 = (EditText) findViewById(R.id.etJenisKaryawan9);
		etJenisKaryawan10 = (EditText) findViewById(R.id.etJenisKaryawan10);
		etKodeKaryawan1 = (EditText) findViewById(R.id.etKodeKaryawan1);
		etKodeKaryawan2 = (EditText) findViewById(R.id.etKodeKaryawan2);
		etKodeKaryawan3 = (EditText) findViewById(R.id.etKodeKaryawan3);
		etKodeKaryawan4 = (EditText) findViewById(R.id.etKodeKaryawan4);
		etKodeKaryawan5 = (EditText) findViewById(R.id.etKodeKaryawan5);
		etKodeKaryawan6 = (EditText) findViewById(R.id.etKodeKaryawan6);
		etKodeKaryawan7 = (EditText) findViewById(R.id.etKodeKaryawan7);
		etKodeKaryawan8 = (EditText) findViewById(R.id.etKodeKaryawan8);
		etKodeKaryawan9 = (EditText) findViewById(R.id.etKodeKaryawan9);
		etKodeKaryawan10 = (EditText) findViewById(R.id.etKodeKaryawan10);
		tvSwipe1 = (Button) findViewById(R.id.tvSwipe1);
		tvSwipe2 = (Button) findViewById(R.id.tvSwipe2);
		tvSwipe3 = (Button) findViewById(R.id.tvSwipe3);
		tvSwipe4 = (Button) findViewById(R.id.tvSwipe4);
		tvSwipe5 = (Button) findViewById(R.id.tvSwipe5);
		tvSwipe6 = (Button) findViewById(R.id.tvSwipe6);
		tvSwipe7 = (Button) findViewById(R.id.tvSwipe7);
		tvSwipe8 = (Button) findViewById(R.id.tvSwipe8);
		tvSwipe9 = (Button) findViewById(R.id.tvSwipe9);
		tvSwipe10 = (Button) findViewById(R.id.tvSwipe10);
		tvSwipe1.setOnClickListener(this);
		tvSwipe2.setOnClickListener(this);
		tvSwipe3.setOnClickListener(this);
		tvSwipe4.setOnClickListener(this);
		tvSwipe5.setOnClickListener(this);
		tvSwipe6.setOnClickListener(this);
		tvSwipe7.setOnClickListener(this);
		tvSwipe8.setOnClickListener(this);
		tvSwipe9.setOnClickListener(this);
		tvSwipe10.setOnClickListener(this);
		KodeKaryawan = new String[10];
		JenisKaryawan = new String[10];
		new readRecord().execute();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_karyawan, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent i = new Intent(this, DataKaryawan.class);
		i.putExtra("object", model);
		switch (arg0.getId()) {
		case R.id.tvSwipe1:
			model.setKaryawancounter(1);
			startActivity(i);
			finish();
			break;
		case R.id.tvSwipe2:
			model.setKaryawancounter(2);
			startActivity(i);
			finish();
			break;
		case R.id.tvSwipe3:
			model.setKaryawancounter(3);
			startActivity(i);
			finish();
			break;
		case R.id.tvSwipe4:
			model.setKaryawancounter(4);
			startActivity(i);
			finish();
			break;
		case R.id.tvSwipe5:
			model.setKaryawancounter(5);
			startActivity(i);
			finish();
			break;
		case R.id.tvSwipe6:
			model.setKaryawancounter(6);
			startActivity(i);
			finish();
			break;
		case R.id.tvSwipe7:
			model.setKaryawancounter(7);
			startActivity(i);
			finish();
			break;
		case R.id.tvSwipe8:
			model.setKaryawancounter(8);
			startActivity(i);
			finish();
			break;
		case R.id.tvSwipe9:
			model.setKaryawancounter(9);
			startActivity(i);
			finish();
			break;
		case R.id.tvSwipe10:
			model.setKaryawancounter(10);
			startActivity(i);
			finish();
			break;
		}
	}

	private class readRecord extends AsyncTask<Void, Void, Void> {
		ProgressDialog progressBar;

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			progressBar = new ProgressDialog(Karyawan.this);
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
			outerloop: for (int i = 0; i < 10; i++) {
				try {
					KodeKaryawan[i] = model.readKodeKaryawan(i+1);
					JenisKaryawan[i]= model.readJenisKaryawan(i+1);
					if (KodeKaryawan[i].equals("") && JenisKaryawan[i].equals("")) {
						break outerloop;
					}
				} catch (BiffException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			progressBar.dismiss();
			outerloop: for (int i=0;i<JenisKaryawan.length;i++){
				if(JenisKaryawan[i].isEmpty()){
					break outerloop;
				}
				if(JenisKaryawan[i].equals("0")){
					JenisKaryawan[i] = "BHL";
				}else if(JenisKaryawan[i].equals("1")){
					JenisKaryawan[i] = "Tetap";
				}else if(JenisKaryawan[i].equals("2")){
					JenisKaryawan[i] = "Kontrak";
				}
			}
			etKodeKaryawan1.setText(KodeKaryawan[0]);
			etJenisKaryawan1.setText(JenisKaryawan[0]);
			etKodeKaryawan2.setText(KodeKaryawan[1]);
			etJenisKaryawan2.setText(JenisKaryawan[1]);
			etKodeKaryawan3.setText(KodeKaryawan[2]);
			etJenisKaryawan3.setText(JenisKaryawan[2]);
			etKodeKaryawan4.setText(KodeKaryawan[3]);
			etJenisKaryawan4.setText(JenisKaryawan[3]);
			etKodeKaryawan5.setText(KodeKaryawan[4]);
			etJenisKaryawan5.setText(JenisKaryawan[4]);
			etKodeKaryawan6.setText(KodeKaryawan[5]);
			etJenisKaryawan6.setText(JenisKaryawan[5]);
			etKodeKaryawan7.setText(KodeKaryawan[6]);
			etJenisKaryawan7.setText(JenisKaryawan[6]);
			etKodeKaryawan8.setText(KodeKaryawan[7]);
			etJenisKaryawan8.setText(JenisKaryawan[7]);
			etKodeKaryawan9.setText(KodeKaryawan[8]);
			etJenisKaryawan9.setText(JenisKaryawan[8]);
			etKodeKaryawan10.setText(KodeKaryawan[9]);
			etJenisKaryawan10.setText(JenisKaryawan[9]);
		}

	}

}
