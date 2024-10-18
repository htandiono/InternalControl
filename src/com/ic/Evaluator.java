package com.ic;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class Evaluator extends Activity implements OnClickListener {

	private InstantAutoComplete namaevaluator;
	String[] Evaluator;
	private String evaluator;
	private Button enter, scan;
	private Model model;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_evaluator);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		namaevaluator = (InstantAutoComplete) findViewById(R.id.etEvaluator);
		Evaluator = getResources().getStringArray(R.array.Evaluator);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, Evaluator);
		namaevaluator.setAdapter(adapter);
		enter = (Button) findViewById(R.id.btnEnter);
		scan = (Button) findViewById(R.id.btnScan);
		scan.requestFocus();
		enter.setOnClickListener(this);
		scan.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_evaluator, menu);
		return true;
	}

	@SuppressLint("NewApi")
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.btnEnter: {
			evaluator = namaevaluator.getText().toString();
			model = new Model(evaluator);
			Intent i = new Intent(this, Mainmenu.class);
			i.putExtra("object", model);
			startActivity(i);
			finish();
			break;
		}
		case R.id.btnScan: {
			// instantiate ZXing integration class
			IntentIntegrator scanIntegrator = new IntentIntegrator(
					Evaluator.this);
			// start scanning
			scanIntegrator.initiateScan();
		}
		}
	}

	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		// retrieve result of scanning - instantiate ZXing object
		IntentResult scanningResult = IntentIntegrator.parseActivityResult(
				requestCode, resultCode, intent);
		// check we have a valid result
		if (scanningResult.getContents() != null) {
			// get content from Intent Result
			String scanContent = scanningResult.getContents();
			// pass the content to namaevaluator variable
			namaevaluator.setText(scanContent);
		} else {
			// scan canceled
			Toast.makeText(getApplicationContext(),
					"Ulangi scan barcode pada kartu identitas anda.",
					Toast.LENGTH_SHORT).show();
		}
	}
}
