package com.ic;

import java.io.IOException;

import jxl.read.biff.BiffException;
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
import android.widget.Toast;

public class TPHSelection extends Activity implements OnClickListener{
	
	private Model model;
	private EditText etTPH1,etTPH2,etTPH3,etTPH4,etTPH5,etTPH6,etTPH7,etTPH8,etTPH9,etTPH10,etTandanPanen1,etTandanPanen2,etTandanPanen3,etTandanPanen4,etTandanPanen5,etTandanPanen6,etTandanPanen7,etTandanPanen8,etTandanPanen9,etTandanPanen10;
	private CheckBox cbPermanen1,cbPermanen2,cbPermanen3,cbPermanen4,cbPermanen5,cbPermanen6,cbPermanen7,cbPermanen8,cbPermanen9,cbPermanen10;
	private Button btnClick1,btnClick2,btnClick3,btnClick4,btnClick5,btnClick6,btnClick7,btnClick8,btnClick9,btnClick10;
	private String[] nomorTPH,permanen,tandanpanen;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tphselection);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		Intent TPH = getIntent();
		model = (Model) TPH.getSerializableExtra("object");
		etTPH1 = (EditText) findViewById(R.id.etNoTPH1);
		etTPH2 = (EditText) findViewById(R.id.etNoTPH2);
		etTPH3 = (EditText) findViewById(R.id.etNoTPH3);
		etTPH4 = (EditText) findViewById(R.id.etNoTPH4);
		etTPH5 = (EditText) findViewById(R.id.etNoTPH5);
		etTPH6 = (EditText) findViewById(R.id.etNoTPH6);
		etTPH7 = (EditText) findViewById(R.id.etNoTPH7);
		etTPH8 = (EditText) findViewById(R.id.etNoTPH8);
		etTPH9 = (EditText) findViewById(R.id.etNoTPH9);
		etTPH10 = (EditText) findViewById(R.id.etNoTPH10);
		etTandanPanen1 = (EditText) findViewById(R.id.etTandanPanen1);
		etTandanPanen2 = (EditText) findViewById(R.id.etTandanPanen2);
		etTandanPanen3 = (EditText) findViewById(R.id.etTandanPanen3);
		etTandanPanen4 = (EditText) findViewById(R.id.etTandanPanen4);
		etTandanPanen5 = (EditText) findViewById(R.id.etTandanPanen5);
		etTandanPanen6 = (EditText) findViewById(R.id.etTandanPanen6);
		etTandanPanen7 = (EditText) findViewById(R.id.etTandanPanen7);
		etTandanPanen8 = (EditText) findViewById(R.id.etTandanPanen8);
		etTandanPanen9 = (EditText) findViewById(R.id.etTandanPanen9);
		etTandanPanen10 = (EditText) findViewById(R.id.etTandanPanen10);
		cbPermanen1 = (CheckBox) findViewById(R.id.cbPermanen1);
		cbPermanen2 = (CheckBox) findViewById(R.id.cbPermanen2);
		cbPermanen3 = (CheckBox) findViewById(R.id.cbPermanen3);
		cbPermanen4 = (CheckBox) findViewById(R.id.cbPermanen4);
		cbPermanen5 = (CheckBox) findViewById(R.id.cbPermanen5);
		cbPermanen6 = (CheckBox) findViewById(R.id.cbPermanen6);
		cbPermanen7 = (CheckBox) findViewById(R.id.cbPermanen7);
		cbPermanen8 = (CheckBox) findViewById(R.id.cbPermanen8);
		cbPermanen9 = (CheckBox) findViewById(R.id.cbPermanen9);
		cbPermanen10 = (CheckBox) findViewById(R.id.cbPermanen10);
		btnClick1 = (Button) findViewById(R.id.btnClick1);
		btnClick2 = (Button) findViewById(R.id.btnClick2);
		btnClick3 = (Button) findViewById(R.id.btnClick3);
		btnClick4 = (Button) findViewById(R.id.btnClick4);
		btnClick5 = (Button) findViewById(R.id.btnClick5);
		btnClick6 = (Button) findViewById(R.id.btnClick6);
		btnClick7 = (Button) findViewById(R.id.btnClick7);
		btnClick8 = (Button) findViewById(R.id.btnClick8);
		btnClick9 = (Button) findViewById(R.id.btnClick9);
		btnClick10 = (Button) findViewById(R.id.btnClick10);
		btnClick1.setOnClickListener(this);
		btnClick2.setOnClickListener(this);
		btnClick3.setOnClickListener(this);
		btnClick4.setOnClickListener(this);
		btnClick5.setOnClickListener(this);
		btnClick6.setOnClickListener(this);
		btnClick7.setOnClickListener(this);
		btnClick8.setOnClickListener(this);
		btnClick9.setOnClickListener(this);
		btnClick10.setOnClickListener(this);
		nomorTPH = new String[10];
		permanen = new String[10];
		tandanpanen = new String[10];
		new readRecord().execute();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_tphselection, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.btnClick1:
			if (!etTPH1.getText().toString().isEmpty()){
				if (!etTandanPanen1.getText().toString().isEmpty()){
					model.setPointer(1);
					saveData();
				}else{
					Toast.makeText(this, "Silakan masukan tandan panen"	 ,Toast.LENGTH_LONG).show();
				}
			}else{
				Toast.makeText(this, "Silakan masukan nomor TPH", Toast.LENGTH_LONG).show();
			}
			break;
		case R.id.btnClick2:
			if (!etTPH2.getText().toString().isEmpty()){
				if (!etTandanPanen2.getText().toString().isEmpty()){
					model.setPointer(41);
					saveData();
				}else{
					Toast.makeText(this, "Silakan masukan tandan panen"	 ,Toast.LENGTH_LONG).show();
				}
			}else{
				Toast.makeText(this, "Silakan masukan nomor TPH", Toast.LENGTH_LONG).show();
			}
			break;
		case R.id.btnClick3:
			if (!etTPH3.getText().toString().isEmpty()){
				if (!etTandanPanen3.getText().toString().isEmpty()){
					model.setPointer(81);
					saveData();
				}else{
					Toast.makeText(this, "Silakan masukan tandan panen"	 ,Toast.LENGTH_LONG).show();
				}
			}else{
				Toast.makeText(this, "Silakan masukan nomor TPH", Toast.LENGTH_LONG).show();
			}
			break;
		case R.id.btnClick4:
			if (!etTPH4.getText().toString().isEmpty()){
				if (!etTandanPanen4.getText().toString().isEmpty()){
					model.setPointer(121);
					saveData();
				}else{
					Toast.makeText(this, "Silakan masukan tandan panen"	 ,Toast.LENGTH_LONG).show();
				}
			}else{
				Toast.makeText(this, "Silakan masukan nomor TPH", Toast.LENGTH_LONG).show();
			}
			break;
		case R.id.btnClick5:
			if (!etTPH5.getText().toString().isEmpty()){
				if (!etTandanPanen5.getText().toString().isEmpty()){
					model.setPointer(161);
					saveData();
				}else{
					Toast.makeText(this, "Silakan masukan tandan panen"	 ,Toast.LENGTH_LONG).show();
				}
			}else{
				Toast.makeText(this, "Silakan masukan nomor TPH", Toast.LENGTH_LONG).show();
			}
			break;
		case R.id.btnClick6:
			if (!etTPH6.getText().toString().isEmpty()){
				if (!etTandanPanen6.getText().toString().isEmpty()){
					model.setPointer(201);
					saveData();
				}else{
					Toast.makeText(this, "Silakan masukan tandan panen"	 ,Toast.LENGTH_LONG).show();
				}
			}else{
				Toast.makeText(this, "Silakan masukan nomor TPH", Toast.LENGTH_LONG).show();
			}
			break;
		case R.id.btnClick7:
			if (!etTPH7.getText().toString().isEmpty()){
				if (!etTandanPanen7.getText().toString().isEmpty()){
					model.setPointer(241);
					saveData();
				}else{
					Toast.makeText(this, "Silakan masukan tandan panen"	 ,Toast.LENGTH_LONG).show();
				}
			}else{
				Toast.makeText(this, "Silakan masukan nomor TPH", Toast.LENGTH_LONG).show();
			}
			break;
		case R.id.btnClick8:
			if (!etTPH8.getText().toString().isEmpty()){
				if (!etTandanPanen8.getText().toString().isEmpty()){
					model.setPointer(281);
					saveData();
				}else{
					Toast.makeText(this, "Silakan masukan tandan panen"	 ,Toast.LENGTH_LONG).show();
				}
			}else{
				Toast.makeText(this, "Silakan masukan nomor TPH", Toast.LENGTH_LONG).show();
			}
			break;
		case R.id.btnClick9:
			if (!etTPH9.getText().toString().isEmpty()){
				if (!etTandanPanen9.getText().toString().isEmpty()){
					model.setPointer(321);
					saveData();
				}else{
					Toast.makeText(this, "Silakan masukan tandan panen"	 ,Toast.LENGTH_LONG).show();
				}
			}else{
				Toast.makeText(this, "Silakan masukan nomor TPH", Toast.LENGTH_LONG).show();
			}
			break;
		case R.id.btnClick10:
			if (!etTPH10.getText().toString().isEmpty()){
				if (!etTandanPanen10.getText().toString().isEmpty()){
					model.setPointer(361);
					saveData();
				}else{
					Toast.makeText(this, "Silakan masukan tandan panen"	 ,Toast.LENGTH_LONG).show();
				}
			}else{
				Toast.makeText(this, "Silakan masukan nomor TPH", Toast.LENGTH_LONG).show();
			}
			break;
		}
	}
	
	public void saveData(){
		nomorTPH[0]=etTPH1.getText().toString();
		nomorTPH[1]=etTPH2.getText().toString();
		nomorTPH[2]=etTPH3.getText().toString();
		nomorTPH[3]=etTPH4.getText().toString();
		nomorTPH[4]=etTPH5.getText().toString();
		nomorTPH[5]=etTPH6.getText().toString();
		nomorTPH[6]=etTPH7.getText().toString();
		nomorTPH[7]=etTPH8.getText().toString();
		nomorTPH[8]=etTPH9.getText().toString();
		nomorTPH[9]=etTPH10.getText().toString();
		tandanpanen[0]= etTandanPanen1.getText().toString();
		tandanpanen[1]= etTandanPanen2.getText().toString();
		tandanpanen[2]= etTandanPanen3.getText().toString();
		tandanpanen[3]= etTandanPanen4.getText().toString();
		tandanpanen[4]= etTandanPanen5.getText().toString();
		tandanpanen[5]= etTandanPanen6.getText().toString();
		tandanpanen[6]= etTandanPanen7.getText().toString();
		tandanpanen[7]= etTandanPanen8.getText().toString();
		tandanpanen[8]= etTandanPanen9.getText().toString();
		tandanpanen[9]= etTandanPanen10.getText().toString();
		permanen[0]="0";
		permanen[1]="0";
		permanen[2]="0";
		permanen[3]="0";
		permanen[4]="0";
		permanen[5]="0";
		permanen[6]="0";
		permanen[7]="0";
		permanen[8]="0";
		permanen[9]="0";
		if (cbPermanen1.isChecked()){
			permanen[0] = "-1";
		}
		if (cbPermanen2.isChecked()){
			permanen[1] = "-1";
		}
		if (cbPermanen3.isChecked()){
			permanen[2] = "-1";
		}
		if (cbPermanen4.isChecked()){
			permanen[3] = "-1";
		}
		if (cbPermanen5.isChecked()){
			permanen[4] = "-1";
		}
		if (cbPermanen6.isChecked()){
			permanen[5] = "-1";
		}
		if (cbPermanen7.isChecked()){
			permanen[6] = "-1";
		}
		if (cbPermanen8.isChecked()){
			permanen[7] = "-1";
		}
		if (cbPermanen9.isChecked()){
			permanen[8] = "-1";
		}
		if (cbPermanen10.isChecked()){
			permanen[9] = "-1";
		}
		try {
			model.saveTPH(nomorTPH, permanen, tandanpanen);
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
		Intent TPHdetail = new Intent(this,TPHDetails.class);
		TPHdetail.putExtra("object",model);
		startActivity(TPHdetail);
		finish();
	}
	
	private class readRecord extends AsyncTask<Void, Void, Void>{

		ProgressDialog progressBar;

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			progressBar = new ProgressDialog(TPHSelection.this);
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
					nomorTPH[i] = model.readNomorTPH(i + 1);
					permanen[i] = model.readPermanen(i + 1);
					tandanpanen[i] = model.readTandanPanen(i + 1);
					if (nomorTPH[i].equals("") && tandanpanen[i].equals("")) {
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
			try{
				etTPH1.setText(nomorTPH[0]);
				etTPH2.setText(nomorTPH[1]);
				etTPH3.setText(nomorTPH[2]);
				etTPH4.setText(nomorTPH[3]);
				etTPH5.setText(nomorTPH[4]);
				etTPH6.setText(nomorTPH[5]);
				etTPH7.setText(nomorTPH[6]);
				etTPH8.setText(nomorTPH[7]);
				etTPH9.setText(nomorTPH[8]);
				etTPH10.setText(nomorTPH[9]);
				etTandanPanen1.setText(tandanpanen[0]);
				etTandanPanen2.setText(tandanpanen[1]);
				etTandanPanen3.setText(tandanpanen[2]);
				etTandanPanen4.setText(tandanpanen[3]);
				etTandanPanen5.setText(tandanpanen[4]);
				etTandanPanen6.setText(tandanpanen[5]);
				etTandanPanen7.setText(tandanpanen[6]);
				etTandanPanen8.setText(tandanpanen[7]);
				etTandanPanen9.setText(tandanpanen[8]);
				etTandanPanen10.setText(tandanpanen[9]);
				cbPermanen1.setChecked(false);
				cbPermanen2.setChecked(false);
				cbPermanen3.setChecked(false);
				cbPermanen4.setChecked(false);
				cbPermanen5.setChecked(false);
				cbPermanen6.setChecked(false);
				cbPermanen7.setChecked(false);
				cbPermanen8.setChecked(false);
				cbPermanen9.setChecked(false);
				cbPermanen10.setChecked(false);
				if(permanen[0].equals("-1")){
					cbPermanen1.setChecked(true);
				}
				if(permanen[1].equals("-1")){
					cbPermanen2.setChecked(true);
				}
				if(permanen[2].equals("-1")){
					cbPermanen3.setChecked(true);
				}
				if(permanen[3].equals("-1")){
					cbPermanen4.setChecked(true);
				}
				if(permanen[4].equals("-1")){
					cbPermanen5.setChecked(true);
				}
				if(permanen[5].equals("-1")){
					cbPermanen6.setChecked(true);
				}
				if(permanen[6].equals("-1")){
					cbPermanen7.setChecked(true);
				}
				if(permanen[7].equals("-1")){
					cbPermanen8.setChecked(true);
				}
				if(permanen[8].equals("-1")){
					cbPermanen9.setChecked(true);
				}
				if(permanen[9].equals("-1")){
					cbPermanen10.setChecked(true);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		
	}

}
