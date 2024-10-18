package com.ic;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Modul extends Activity implements OnClickListener {

	Model model;
	TextView tvWelcome;
	Button modul1;
	Button modul2;
	Button modul3;
	Button modul4;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_modul);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		Intent i = getIntent();
		model = (Model)i.getSerializableExtra("object");
		tvWelcome=(TextView)findViewById(R.id.tvWelcome);
		tvWelcome.setText("Welcome, "+model.getEvaluator());
		modul1 = (Button) findViewById(R.id.btnModul1);
		modul2 = (Button) findViewById(R.id.btnModul2);
		modul3 = (Button) findViewById(R.id.btnModul3);
		modul4 = (Button) findViewById(R.id.btnModul4);
		modul1.setOnClickListener(this);
		modul2.setOnClickListener(this);
		modul3.setOnClickListener(this);
		modul4.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_modul, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.btnModul1:
			Intent modul1 = new Intent(this,Modul1.class);
			modul1.putExtra("object", model);
			startActivity(modul1);
			break;
		case R.id.btnModul2:
			Intent modul2 = new Intent(this,Modul2.class);
			modul2.putExtra("object",model);
			startActivity(modul2);
			break;
		case R.id.btnModul3:
			Intent modul3 = new Intent(this,Modul3.class);
			modul3.putExtra("object",model);
			startActivity(modul3);
			break;
		case R.id.btnModul4:
			//modul4
			Intent modul4 = new Intent(this,Modul4.class);
			modul4.putExtra("object", model);
			startActivity(modul4);
			break;
		}
	}

}