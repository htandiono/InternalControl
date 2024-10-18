package com.ic;

import java.text.ParseException;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class Modul4 extends Activity implements OnItemSelectedListener, OnClickListener {

	private Model model;
	private EditText etOther, etDosage;
	private TextView tvOther;
	private Spinner estate, division, region, pt, pupuk;
	private String companyID, regionID, estateID, divisionID, pupukID,pupukOther,AreaAplikasi,Dosage;
	private ArrayList<String> listestate, listdivisi, listregion, listpt,
			listpupuk;
	private Button btnAplikasi, btnSupervisi;
	private RadioGroup rgAreaAplikasi;
	private boolean otherPupuk;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_modul4);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		Intent modul1 = getIntent();
		model = (Model) modul1.getSerializableExtra("object");
		estate = (Spinner) findViewById(R.id.spEstate);
		division = (Spinner) findViewById(R.id.spDivisi);
		region = (Spinner) findViewById(R.id.spRegion);
		pt = (Spinner) findViewById(R.id.spPT);
		pupuk = (Spinner) findViewById(R.id.spJenisPupuk);
		rgAreaAplikasi = (RadioGroup) findViewById(R.id.rgAreaAplikasi);
		tvOther = (TextView) findViewById(R.id.tvOther);
		etOther = (EditText)findViewById(R.id.etOther);
		etDosage = (EditText)findViewById(R.id.etDosage);
		btnAplikasi = (Button) findViewById(R.id.btnAplikasi);
		btnSupervisi = (Button) findViewById(R.id.btnSupervisi);
		listregion = new ArrayList<String>();
		listregion.add("Sumatera");
		listregion.add("Kalimantan");
		region.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_dropdown_item, listregion));
		estate.setOnItemSelectedListener(this);
		division.setOnItemSelectedListener(this);
		region.setOnItemSelectedListener(this);
		pt.setOnItemSelectedListener(this);
		listpupuk = new ArrayList<String>();
		listpupuk.add("Copper Sulphate (CuS04)");
		listpupuk.add("Dried Decanter Solid (DDS)");
		listpupuk.add("Boiler Ash");
		listpupuk.add("Borate (HGFB)");
		listpupuk.add("Kieserite");
		listpupuk.add("MOP");
		listpupuk.add("RP");
		listpupuk.add("Urea");
		listpupuk.add("Dolomite");
		listpupuk.add("ZnSO4");
		listpupuk.add("Peat Kay/Hikay");
		listpupuk.add("NPK");
		listpupuk.add("NPK Biru");
		listpupuk.add("Lainnya");
		pupuk.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_dropdown_item, listpupuk));
		otherPupuk = false;
		pupuk.setOnItemSelectedListener(this);
		btnAplikasi.setOnClickListener(this);
		btnSupervisi.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_modul4, menu);
		return true;
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.spRegion:
			listpt = new ArrayList<String>();
			if (region.getItemAtPosition(arg2).toString().equals("Sumatera")) {
				regionID = "1";
				listpt.add("Musim Mas");
				listpt.add("Berkat Sawit Sejati");
				listpt.add("Siringo - Ringo");
				listpt.add("Agrowiratama - Padang");
				pt.setAdapter(new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_dropdown_item, listpt));
			} else if (region.getItemAtPosition(arg2).toString()
					.equals("Kalimantan")) {
				regionID = "2";
				listpt.add("Maju Aneka Sawit");
				listpt.add("Unggul Lestari");
				listpt.add("Globalindo Alam Perkasa");
				listpt.add("Sukajadi Sawit Mekar");
				pt.setAdapter(new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_dropdown_item, listpt));
			}
			break;
		case R.id.spPT:
			listestate = new ArrayList<String>();
			if (pt.getItemAtPosition(arg2).toString().equals("Musim Mas")) {
				companyID = "1";
				listestate.add("1");
				listestate.add("2");
				listestate.add("3");
				listestate.add("4");
				listestate.add("5");
				listestate.add("6");
				estate.setAdapter(new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_dropdown_item,
						listestate));
			} else if (pt.getItemAtPosition(arg2).toString()
					.equals("Berkat Sawit Sejati")) {
				companyID = "2";
				listestate.add("Sei Berau");
				listestate.add("Sei Tungkal");
				estate.setAdapter(new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_dropdown_item,
						listestate));
			} else if (pt.getItemAtPosition(arg2).toString()
					.equals("Siringo - Ringo")) {
				companyID = "3";
				listestate.add("Siringo - Ringo");
				estate.setAdapter(new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_dropdown_item,
						listestate));
			} else if (pt.getItemAtPosition(arg2).toString()
					.equals("Agrowitama - Padang")) {
				companyID = "4";
				listestate.add("Sei Aur");
				estate.setAdapter(new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_dropdown_item,
						listestate));
			} else if (pt.getItemAtPosition(arg2).toString()
					.equals("Maju Aneka Sawit")) {
				companyID = "5";
				listestate.add("Tanah Mas");
				listestate.add("Sari Mas 1");
				listestate.add("Bakung Mas");
				estate.setAdapter(new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_dropdown_item,
						listestate));
			} else if (pt.getItemAtPosition(arg2).toString()
					.equals("Unggul Lestari")) {
				companyID = "6";
				listestate.add("Unggul1");
				listestate.add("Unggul2");
				estate.setAdapter(new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_dropdown_item,
						listestate));
			} else if (pt.getItemAtPosition(arg2).toString()
					.equals("Globalindo Alam Perkasa")) {
				companyID = "7";
				listestate.add("Alam Sahara");
				listestate.add("Alam Tani");
				estate.setAdapter(new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_dropdown_item,
						listestate));
			} else if (pt.getItemAtPosition(arg2)
					.equals("Sukajadi Sawit Mekar")) {
				companyID = "8";
				listestate.add("Bukit Limas");
				listestate.add("Bukit Linang");
				listestate.add("Sebabi");
				listestate.add("Seranau");
				estate.setAdapter(new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_dropdown_item,
						listestate));
			}
		case R.id.spEstate:
			listdivisi = new ArrayList<String>();
			if (estate.getItemAtPosition(estate.getSelectedItemPosition())
					.toString().equalsIgnoreCase("1")) {
				estateID = "1";
				listdivisi.add("A");
				listdivisi.add("B");
				listdivisi.add("C");
				listdivisi.add("D");
				listdivisi.add("E");
				listdivisi.add("F");
				listdivisi.add("G");
				listdivisi.add("H");
				listdivisi.add("I");
				division.setAdapter(new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_dropdown_item,
						listdivisi));
			} else if (estate
					.getItemAtPosition(estate.getSelectedItemPosition())
					.toString().equalsIgnoreCase("2")) {
				estateID = "2";
				listdivisi.add("A");
				listdivisi.add("B");
				listdivisi.add("C");
				listdivisi.add("D");
				listdivisi.add("E");
				listdivisi.add("F");
				division.setAdapter(new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_dropdown_item,
						listdivisi));
			} else if (estate
					.getItemAtPosition(estate.getSelectedItemPosition())
					.toString().equalsIgnoreCase("3")) {
				estateID = "3";
				listdivisi.add("A");
				listdivisi.add("B");
				listdivisi.add("C");
				listdivisi.add("D");
				listdivisi.add("E");
				listdivisi.add("F");
				listdivisi.add("G");
				listdivisi.add("H");
				division.setAdapter(new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_dropdown_item,
						listdivisi));
			} else if (estate
					.getItemAtPosition(estate.getSelectedItemPosition())
					.toString().equalsIgnoreCase("4")) {
				estateID = "4";
				listdivisi.add("A");
				listdivisi.add("B");
				listdivisi.add("C");
				listdivisi.add("D");
				listdivisi.add("E");
				listdivisi.add("F");
				listdivisi.add("G");
				listdivisi.add("H");
				division.setAdapter(new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_dropdown_item,
						listdivisi));
			} else if (estate
					.getItemAtPosition(estate.getSelectedItemPosition())
					.toString().equalsIgnoreCase("5")) {
				estateID = "5";
				listdivisi.add("A");
				listdivisi.add("B");
				listdivisi.add("C");
				listdivisi.add("D");
				listdivisi.add("E");
				listdivisi.add("F");
				listdivisi.add("G");
				division.setAdapter(new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_dropdown_item,
						listdivisi));
			} else if (estate
					.getItemAtPosition(estate.getSelectedItemPosition())
					.toString().equalsIgnoreCase("6")) {
				estateID = "6";
				listdivisi.add("A");
				listdivisi.add("B");
				listdivisi.add("C");
				listdivisi.add("D");
				listdivisi.add("E");
				listdivisi.add("F");
				listdivisi.add("G");
				division.setAdapter(new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_dropdown_item,
						listdivisi));
			} else if (estate
					.getItemAtPosition(estate.getSelectedItemPosition())
					.toString().equalsIgnoreCase("Sei Berau")) {
				estateID = "7";
				listdivisi.add("A");
				listdivisi.add("B");
				listdivisi.add("C");
				listdivisi.add("D");
				listdivisi.add("E");
				listdivisi.add("F");
				listdivisi.add("G");
				listdivisi.add("H");
				listdivisi.add("I");
				listdivisi.add("J");
				listdivisi.add("K");
				division.setAdapter(new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_dropdown_item,
						listdivisi));
			} else if (estate
					.getItemAtPosition(estate.getSelectedItemPosition())
					.toString().equalsIgnoreCase("Sei Tungkal")) {
				estateID = "8";
				listdivisi.add("A");
				listdivisi.add("B");
				listdivisi.add("C");
				listdivisi.add("D");
				listdivisi.add("E");
				listdivisi.add("F");
				listdivisi.add("G");
				listdivisi.add("H");
				listdivisi.add("I");
				listdivisi.add("J");
				division.setAdapter(new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_dropdown_item,
						listdivisi));
			} else if (estate
					.getItemAtPosition(estate.getSelectedItemPosition())
					.toString().equalsIgnoreCase("Siringo-Ringo")) {
				estateID = "9";
				listdivisi.add("A");
				listdivisi.add("B");
				listdivisi.add("C");
				division.setAdapter(new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_dropdown_item,
						listdivisi));
			} else if (estate
					.getItemAtPosition(estate.getSelectedItemPosition())
					.toString().equalsIgnoreCase("Sei Alur")) {
				estateID = "10";
				listdivisi.add("A");
				listdivisi.add("B");
				listdivisi.add("C");
				listdivisi.add("D");
				listdivisi.add("E");
				listdivisi.add("F");
				listdivisi.add("G");
				listdivisi.add("H");
				listdivisi.add("I");
				listdivisi.add("J");
				division.setAdapter(new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_dropdown_item,
						listdivisi));
			} else if (estate
					.getItemAtPosition(estate.getSelectedItemPosition())
					.toString().equalsIgnoreCase("Tanah Mas")) {
				estateID = "11";
				listdivisi.add("A");
				listdivisi.add("B");
				listdivisi.add("C");
				listdivisi.add("D");
				listdivisi.add("E");
				listdivisi.add("F");
				listdivisi.add("G");
				listdivisi.add("H");
				listdivisi.add("I");
				listdivisi.add("J");
				listdivisi.add("K");
				listdivisi.add("L");
				division.setAdapter(new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_dropdown_item,
						listdivisi));
			} else if (estate
					.getItemAtPosition(estate.getSelectedItemPosition())
					.toString().equalsIgnoreCase("Sari Mas 1")) {
				estateID = "12";
				listdivisi.add("A");
				listdivisi.add("B");
				listdivisi.add("C");
				listdivisi.add("D");
				division.setAdapter(new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_dropdown_item,
						listdivisi));
			} else if (estate
					.getItemAtPosition(estate.getSelectedItemPosition())
					.toString().equalsIgnoreCase("Bakung Mas")) {
				estateID = "13";
				listdivisi.add("A");
				listdivisi.add("B");
				listdivisi.add("C");
				listdivisi.add("D");
				listdivisi.add("E");
				listdivisi.add("F");
				listdivisi.add("G");
				listdivisi.add("H");
				division.setAdapter(new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_dropdown_item,
						listdivisi));
			} else if (estate
					.getItemAtPosition(estate.getSelectedItemPosition())
					.toString().equalsIgnoreCase("Unggul1")) {
				estateID = "14";
				listdivisi.add("A");
				listdivisi.add("B");
				listdivisi.add("C");
				listdivisi.add("D");
				listdivisi.add("E");
				listdivisi.add("F");
				listdivisi.add("G");
				listdivisi.add("H");
				listdivisi.add("I");
				division.setAdapter(new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_dropdown_item,
						listdivisi));
			} else if (estate
					.getItemAtPosition(estate.getSelectedItemPosition())
					.toString().equalsIgnoreCase("Unggul2")) {
				estateID = "15";
				listdivisi.add("A");
				listdivisi.add("B");
				listdivisi.add("C");
				listdivisi.add("D");
				listdivisi.add("E");
				listdivisi.add("F");
				listdivisi.add("G");
				listdivisi.add("H");
				listdivisi.add("I");
				listdivisi.add("J");
				division.setAdapter(new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_dropdown_item,
						listdivisi));
			} else if (estate
					.getItemAtPosition(estate.getSelectedItemPosition())
					.toString().equalsIgnoreCase("Alam Sahara")) {
				estateID = "16";
				listdivisi.add("A");
				listdivisi.add("B");
				listdivisi.add("C");
				listdivisi.add("D");
				listdivisi.add("E");
				listdivisi.add("F");
				division.setAdapter(new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_dropdown_item,
						listdivisi));
			} else if (estate
					.getItemAtPosition(estate.getSelectedItemPosition())
					.toString().equalsIgnoreCase("Alam Tani")) {
				estateID = "17";
				listdivisi.add("A");
				listdivisi.add("B");
				listdivisi.add("C");
				listdivisi.add("D");
				listdivisi.add("E");
				listdivisi.add("F");
				listdivisi.add("G");
				division.setAdapter(new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_dropdown_item,
						listdivisi));
			} else if (estate
					.getItemAtPosition(estate.getSelectedItemPosition())
					.toString().equalsIgnoreCase("Bukit Limas")) {
				estateID = "18";
				listdivisi.add("A");
				listdivisi.add("B");
				listdivisi.add("C");
				listdivisi.add("D");
				listdivisi.add("E");
				listdivisi.add("F");
				division.setAdapter(new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_dropdown_item,
						listdivisi));
			} else if (estate
					.getItemAtPosition(estate.getSelectedItemPosition())
					.toString().equalsIgnoreCase("Bukit Linang")) {
				estateID = "19";
				listdivisi.add("A");
				listdivisi.add("B");
				listdivisi.add("C");
				listdivisi.add("D");
				listdivisi.add("E");
				listdivisi.add("F");
				division.setAdapter(new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_dropdown_item,
						listdivisi));
			} else if (estate
					.getItemAtPosition(estate.getSelectedItemPosition())
					.toString().equalsIgnoreCase("Sebabi")) {
				estateID = "20";
				listdivisi.add("A");
				listdivisi.add("B");
				listdivisi.add("C");
				listdivisi.add("D");
				listdivisi.add("E");
				listdivisi.add("F");
				listdivisi.add("G");
				listdivisi.add("H");
				division.setAdapter(new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_dropdown_item,
						listdivisi));
			} else if (estate
					.getItemAtPosition(estate.getSelectedItemPosition())
					.toString().equalsIgnoreCase("Seranau")) {
				estateID = "21";
				listdivisi.add("A");
				listdivisi.add("B");
				listdivisi.add("C");
				listdivisi.add("D");
				listdivisi.add("E");
				listdivisi.add("F");
				division.setAdapter(new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_dropdown_item,
						listdivisi));

			}
			break;
		case R.id.spJenisPupuk:
			if (pupuk.getItemAtPosition(arg2).toString().equalsIgnoreCase("Copper Sulphate (CuSO4)")) {
				pupukID = "CuSO4" ;
			}else if (pupuk.getItemAtPosition(arg2).toString().equalsIgnoreCase("Decanter Solid (DDS)")) {
				pupukID = "DDS" ;
			}else if (pupuk.getItemAtPosition(arg2).toString().equalsIgnoreCase("Boiler Ash")) {
				pupukID = "BoilerAsh" ;
			}else if (pupuk.getItemAtPosition(arg2).toString().equalsIgnoreCase("Borate (HGFB)")) {
				pupukID = "HGFB" ;
			}else if (pupuk.getItemAtPosition(arg2).toString().equalsIgnoreCase("Kieserite")) {
				pupukID = "KIE" ;
			}else if (pupuk.getItemAtPosition(arg2).toString().equalsIgnoreCase("MOP")) {
				pupukID = "MOP" ;
			}else if (pupuk.getItemAtPosition(arg2).toString().equalsIgnoreCase("RP")) {
				pupukID = "RP" ;
			}else if (pupuk.getItemAtPosition(arg2).toString().equalsIgnoreCase("Urea")) {
				pupukID = "Urea" ;
			}else if (pupuk.getItemAtPosition(arg2).toString().equalsIgnoreCase("Dolomite")) {
				pupukID = "DOL" ;
			}else if (pupuk.getItemAtPosition(arg2).toString().equalsIgnoreCase("ZnSO4")) {
				pupukID = "ZnSO4" ;
			}else if (pupuk.getItemAtPosition(arg2).toString().equalsIgnoreCase("Peat Kay/Hikay")) {
				pupukID = "PK" ;
			}else if (pupuk.getItemAtPosition(arg2).toString().equalsIgnoreCase("NPK")) {
				pupukID = "NPK" ;
			}else if (pupuk.getItemAtPosition(arg2).toString().equalsIgnoreCase("NPK Biru")) {
				pupukID = "BNPK" ;
			}else if (pupuk.getItemAtPosition(arg2).toString().equalsIgnoreCase("Lainnya")) {
				 pupukID ="OTHER";
				 otherPupuk = true;
			}
				 
			break;
		}
		if (otherPupuk){
			tvOther.setVisibility(View.VISIBLE);
			 etOther.setVisibility(View.VISIBLE);
		}else{
			tvOther.setVisibility(View.GONE);
			 etOther.setVisibility(View.GONE);
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}
	
	private void saveData(){
		int divisionclass = 0;
		if (division.getItemAtPosition(division.getSelectedItemPosition())
				.toString().equalsIgnoreCase("A")) {
			divisionclass = 1;
		} else if (division
				.getItemAtPosition(division.getSelectedItemPosition())
				.toString().equalsIgnoreCase("B")) {
			divisionclass = 2;
		} else if (division
				.getItemAtPosition(division.getSelectedItemPosition())
				.toString().equalsIgnoreCase("C")) {
			divisionclass = 3;
		} else if (division
				.getItemAtPosition(division.getSelectedItemPosition())
				.toString().equalsIgnoreCase("D")) {
			divisionclass = 4;
		} else if (division
				.getItemAtPosition(division.getSelectedItemPosition())
				.toString().equalsIgnoreCase("E")) {
			divisionclass = 5;
		} else if (division
				.getItemAtPosition(division.getSelectedItemPosition())
				.toString().equalsIgnoreCase("F")) {
			divisionclass = 6;
		} else if (division
				.getItemAtPosition(division.getSelectedItemPosition())
				.toString().equalsIgnoreCase("G")) {
			divisionclass = 7;
		} else if (division
				.getItemAtPosition(division.getSelectedItemPosition())
				.toString().equalsIgnoreCase("H")) {
			divisionclass = 8;
		} else if (division
				.getItemAtPosition(division.getSelectedItemPosition())
				.toString().equalsIgnoreCase("I")) {
			divisionclass = 9;
		} else if (division
				.getItemAtPosition(division.getSelectedItemPosition())
				.toString().equalsIgnoreCase("J")) {
			divisionclass = 10;
		} else if (division
				.getItemAtPosition(division.getSelectedItemPosition())
				.toString().equalsIgnoreCase("K")) {
			divisionclass = 11;
		} else if (division
				.getItemAtPosition(division.getSelectedItemPosition())
				.toString().equalsIgnoreCase("L")) {
			divisionclass = 12;
		}
		divisionID = "";
		if (estateID.equalsIgnoreCase("1")) {
			switch (divisionclass) {
			case 1:
				divisionID = "1";
				break;
			case 2:
				divisionID = "2";
				break;
			case 3:
				divisionID = "3";
				break;
			case 4:
				divisionID = "4";
				break;
			case 5:
				divisionID = "5";
				break;
			case 6:
				divisionID = "6";
				break;
			case 7:
				divisionID = "7";
				break;
			case 8:
				divisionID = "8";
				break;
			case 9:
				divisionID = "162";
				break;
			}
		} else if (estateID.equalsIgnoreCase("2")) {
			switch (divisionclass) {
			case 1:
				divisionID = "9";
				break;
			case 2:
				divisionID = "10";
				break;
			case 3:
				divisionID = "11";
				break;
			case 4:
				divisionID = "12";
				break;
			case 5:
				divisionID = "13";
				break;
			case 6:
				divisionID = "14";
				break;
			}
		} else if (estateID.equalsIgnoreCase("3")) {
			switch (divisionclass) {
			case 1:
				divisionID = "15";
				break;
			case 2:
				divisionID = "16";
				break;
			case 3:
				divisionID = "17";
				break;
			case 4:
				divisionID = "18";
				break;
			case 5:
				divisionID = "19";
				break;
			case 6:
				divisionID = "20";
				break;
			case 7:
				divisionID = "21";
				break;
			case 8:
				divisionID = "22";
				break;
			}
		} else if (estateID.equalsIgnoreCase("4")) {
			switch (divisionclass) {
			case 1:
				divisionID = "23";
				break;
			case 2:
				divisionID = "24";
				break;
			case 3:
				divisionID = "25";
				break;
			case 4:
				divisionID = "26";
				break;
			case 5:
				divisionID = "27";
				break;
			case 6:
				divisionID = "28";
				break;
			case 7:
				divisionID = "29";
				break;
			case 8:
				divisionID = "30";
				break;
			}
		} else if (estateID.equalsIgnoreCase("5")) {
			switch (divisionclass) {
			case 1:
				divisionID = "31";
				break;
			case 2:
				divisionID = "32";
				break;
			case 3:
				divisionID = "33";
				break;
			case 4:
				divisionID = "34";
				break;
			case 5:
				divisionID = "35";
				break;
			case 6:
				divisionID = "36";
				break;
			case 7:
				divisionID = "37";
				break;
			}
		} else if (estateID.equalsIgnoreCase("6")) {
			switch (divisionclass) {
			case 1:
				divisionID = "38";
				break;
			case 2:
				divisionID = "39";
				break;
			case 3:
				divisionID = "40";
				break;
			case 4:
				divisionID = "41";
				break;
			case 5:
				divisionID = "42";
				break;
			case 6:
				divisionID = "43";
				break;
			case 7:
				divisionID = "44";
				break;
			}
		} else if (estateID.equalsIgnoreCase("7")) {
			switch (divisionclass) {
			case 1:
				divisionID = "45";
				break;
			case 2:
				divisionID = "46";
				break;
			case 3:
				divisionID = "47";
				break;
			case 4:
				divisionID = "48";
				break;
			case 5:
				divisionID = "49";
				break;
			case 6:
				divisionID = "50";
				break;
			case 7:
				divisionID = "51";
				break;
			case 8:
				divisionID = "52";
				break;
			case 9:
				divisionID = "53";
				break;
			case 10:
				divisionID = "54";
				break;
			case 11:
				divisionID = "55";
				break;
			}
		} else if (estateID.equalsIgnoreCase("8")) {
			switch (divisionclass) {
			case 1:
				divisionID = "56";
				break;
			case 2:
				divisionID = "57";
				break;
			case 3:
				divisionID = "58";
				break;
			case 4:
				divisionID = "59";
				break;
			case 5:
				divisionID = "60";
				break;
			case 6:
				divisionID = "61";
				break;
			case 7:
				divisionID = "62";
				break;
			case 8:
				divisionID = "63";
				break;
			case 9:
				divisionID = "64";
				break;
			case 10:
				divisionID = "65";
				break;
			}
		} else if (estateID.equalsIgnoreCase("9")) {
			switch (divisionclass) {
			case 1:
				divisionID = "66";
				break;
			case 2:
				divisionID = "67";
				break;
			case 3:
				divisionID = "68";
				break;
			}
		} else if (estateID.equalsIgnoreCase("10")) {
			switch (divisionclass) {
			case 1:
				divisionID = "69";
				break;
			case 2:
				divisionID = "70";
				break;
			case 3:
				divisionID = "71";
				break;
			case 4:
				divisionID = "72";
				break;
			case 5:
				divisionID = "73";
				break;
			case 6:
				divisionID = "74";
				break;
			case 7:
				divisionID = "75";
				break;
			case 8:
				divisionID = "76";
				break;
			case 9:
				divisionID = "77";
				break;
			case 10:
				divisionID = "78";
				break;
			}
		} else if (estateID.equalsIgnoreCase("11")) {
			switch (divisionclass) {
			case 1:
				divisionID = "79";
				break;
			case 2:
				divisionID = "80";
				break;
			case 3:
				divisionID = "81";
				break;
			case 4:
				divisionID = "82";
				break;
			case 5:
				divisionID = "83";
				break;
			case 6:
				divisionID = "84";
				break;
			case 7:
				divisionID = "85";
				break;
			case 8:
				divisionID = "86";
				break;
			case 9:
				divisionID = "87";
				break;
			case 10:
				divisionID = "88";
				break;
			case 11:
				divisionID = "89";
				break;
			case 12:
				divisionID = "90";
				break;
			}
		} else if (estateID.equalsIgnoreCase("12")) {
			switch (divisionclass) {
			case 1:
				divisionID = "91";
				break;
			case 2:
				divisionID = "92";
				break;
			case 3:
				divisionID = "93";
				break;
			case 4:
				divisionID = "94";
				break;
			}
		} else if (estateID.equalsIgnoreCase("13")) {
			switch (divisionclass) {
			case 1:
				divisionID = "95";
				break;
			case 2:
				divisionID = "96";
				break;
			case 3:
				divisionID = "97";
				break;
			case 4:
				divisionID = "98";
				break;
			case 5:
				divisionID = "99";
				break;
			case 6:
				divisionID = "100";
				break;
			case 7:
				divisionID = "101";
				break;
			case 8:
				divisionID = "102";
				break;
			}
		} else if (estateID.equalsIgnoreCase("14")) {
			switch (divisionclass) {
			case 1:
				divisionID = "103";
				break;
			case 2:
				divisionID = "104";
				break;
			case 3:
				divisionID = "105";
				break;
			case 4:
				divisionID = "106";
				break;
			case 5:
				divisionID = "107";
				break;
			case 6:
				divisionID = "108";
				break;
			case 7:
				divisionID = "109";
				break;
			case 8:
				divisionID = "110";
				break;
			case 9:
				divisionID = "111";
				break;
			}
		} else if (estateID.equalsIgnoreCase("15")) {
			switch (divisionclass) {
			case 1:
				divisionID = "112";
				break;
			case 2:
				divisionID = "113";
				break;
			case 3:
				divisionID = "114";
				break;
			case 4:
				divisionID = "115";
				break;
			case 5:
				divisionID = "116";
				break;
			case 6:
				divisionID = "117";
				break;
			case 7:
				divisionID = "118";
				break;
			case 8:
				divisionID = "119";
				break;
			case 9:
				divisionID = "120";
				break;
			case 10:
				divisionID = "121";
				break;
			}
		} else if (estateID.equalsIgnoreCase("16")) {
			switch (divisionclass) {
			case 1:
				divisionID = "122";
				break;
			case 2:
				divisionID = "123";
				break;
			case 3:
				divisionID = "124";
				break;
			case 4:
				divisionID = "125";
				break;
			case 5:
				divisionID = "126";
				break;
			case 6:
				divisionID = "127";
				break;
			}
		} else if (estateID.equalsIgnoreCase("17")) {
			switch (divisionclass) {
			case 1:
				divisionID = "128";
				break;
			case 2:
				divisionID = "129";
				break;
			case 3:
				divisionID = "130";
				break;
			case 4:
				divisionID = "131";
				break;
			case 5:
				divisionID = "132";
				break;
			case 6:
				divisionID = "133";
				break;
			case 7:
				divisionID = "134";
				break;
			}
		} else if (estateID.equalsIgnoreCase("18")) {
			switch (divisionclass) {
			case 1:
				divisionID = "136";
				break;
			case 2:
				divisionID = "137";
				break;
			case 3:
				divisionID = "138";
				break;
			case 4:
				divisionID = "139";
				break;
			case 5:
				divisionID = "140";
				break;
			case 6:
				divisionID = "141";
				break;
			}
		} else if (estateID.equalsIgnoreCase("19")) {
			switch (divisionclass) {
			case 1:
				divisionID = "142";
				break;
			case 2:
				divisionID = "143";
				break;
			case 3:
				divisionID = "144";
				break;
			case 4:
				divisionID = "145";
				break;
			case 5:
				divisionID = "146";
				break;
			case 6:
				divisionID = "147";
				break;
			}
		} else if (estateID.equalsIgnoreCase("20")) {
			switch (divisionclass) {
			case 1:
				divisionID = "148";
				break;
			case 2:
				divisionID = "149";
				break;
			case 3:
				divisionID = "150";
				break;
			case 4:
				divisionID = "151";
				break;
			case 5:
				divisionID = "152";
				break;
			case 6:
				divisionID = "153";
				break;
			case 7:
				divisionID = "154";
				break;
			case 8:
				divisionID = "155";
				break;
			}
		} else if (estateID.equalsIgnoreCase("21")) {
			switch (divisionclass) {
			case 1:
				divisionID = "156";
				break;
			case 2:
				divisionID = "157";
				break;
			case 3:
				divisionID = "158";
				break;
			case 4:
				divisionID = "159";
				break;
			case 5:
				divisionID = "160";
				break;
			case 6:
				divisionID = "161";
				break;
			}
		}
		pupukOther = "";
		if (otherPupuk){
			pupukOther = etOther.getText().toString();
		}
		AreaAplikasi = null;
		RadioButton rbAreaAplikasi = (RadioButton) findViewById(rgAreaAplikasi.getCheckedRadioButtonId());
		if(rbAreaAplikasi.getId() == R.id.rbareaaplikasiA){
			AreaAplikasi = "0";
		}else if(rbAreaAplikasi.getId() == R.id.rbareaaplikasiB){
			AreaAplikasi = "1";
		}
		
		Dosage = "0";
		if (!etDosage.getText().toString().isEmpty()){
			Dosage = etDosage.getText().toString();
		}
		//save file code
		model.setRegion(regionID);
		model.setCompany(companyID);
		model.setEstate(estateID);
		model.setDivision(divisionID);
		model.setJenisPupuk(pupukID);
		model.setJenisPupukLain(pupukOther);
		model.setArealAplikasi(AreaAplikasi);
		model.setDosisPerPokok(Dosage);
		try {
			model.setFormNo("FRT");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.btnAplikasi:
			saveData();
			Intent i = new Intent(this,AplikasiPemupukan.class);
			i.putExtra("object", model);
			startActivity(i);
			finish();
			break;
		case R.id.btnSupervisi:
			saveData();
			Intent j = new Intent(this,SpvRcm.class);
			j.putExtra("object", model);
			startActivity(j);
			finish();
			break;
		}
	}

}
