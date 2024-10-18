package com.ic;

import android.annotation.SuppressLint;
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
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import jxl.write.WriteException;

@SuppressLint("NewApi")
public class Modul1 extends Activity implements OnClickListener,
        OnItemSelectedListener {
    private Model model;
    private EditText blockid, rotasipanen;
    private Spinner estate, division, region, pt;
    private String companyID, regionID, estateID, divisionID;
    private ArrayList<String> listestate, listdivisi, listregion, listpt;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul1);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Intent modul1 = getIntent();
        model = (Model) modul1.getSerializableExtra("object");
        estate = (Spinner) findViewById(R.id.spEstate);
        division = (Spinner) findViewById(R.id.spDivision);
        blockid = (EditText) findViewById(R.id.etBlockid);
        rotasipanen = (EditText) findViewById(R.id.etRotasi);
        region = (Spinner) findViewById(R.id.spRegion);
        pt = (Spinner) findViewById(R.id.spPT);
        next = (Button) findViewById(R.id.btnNext);
        next.setOnClickListener(this);
        listregion = new ArrayList<String>();
        listregion.add("Sumatera");
        listregion.add("Kalimantan");
        region.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, listregion));
        estate.setOnItemSelectedListener(this);
        division.setOnItemSelectedListener(this);
        region.setOnItemSelectedListener(this);
        pt.setOnItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_modul1, menu);
        return true;
    }

    @Override
    public void onClick(View arg0) {
        // TODO Auto-generated method stub
        switch (arg0.getId()) {
            case R.id.btnNext:
                int divisionclass = 0;
                if (division.getItemAtPosition(division.getSelectedItemPosition()).toString().equalsIgnoreCase("A") ||
                        division.getItemAtPosition(division.getSelectedItemPosition()).toString().equalsIgnoreCase("KSB1") ||
                        division.getItemAtPosition(division.getSelectedItemPosition()).toString().equalsIgnoreCase("GRC-F")) {
                    divisionclass = 1;
                } else if (division
                        .getItemAtPosition(division.getSelectedItemPosition()).toString().equalsIgnoreCase("B") ||
                        division.getItemAtPosition(division.getSelectedItemPosition()).toString().equalsIgnoreCase("KSB2") ||
                        division.getItemAtPosition(division.getSelectedItemPosition()).toString().equalsIgnoreCase("GRC-G")) {
                    divisionclass = 2;
                } else if (division
                        .getItemAtPosition(division.getSelectedItemPosition())
                        .toString().equalsIgnoreCase("C") || division.getItemAtPosition(division.getSelectedItemPosition())
                        .toString().equalsIgnoreCase("KSBAMB")) {
                    divisionclass = 3;
                } else if (division
                        .getItemAtPosition(division.getSelectedItemPosition())
                        .toString().equalsIgnoreCase("D") || division.getItemAtPosition(division.getSelectedItemPosition())
                        .toString().equalsIgnoreCase("KSDBS")) {
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
                } else if (estateID.equalsIgnoreCase("22")) {
                    switch (divisionclass) {
                        case 1:
                            divisionID = "163";
                            break;
                        case 2:
                            divisionID = "164";
                            break;
                        case 3:
                            divisionID = "165";
                            break;
                        case 4:
                            divisionID = "166";
                            break;
                    }
                } else if (estateID.equalsIgnoreCase("23")) {
                    switch (divisionclass) {
                        case 1:
                            divisionID = "167";
                            break;
                        case 2:
                            divisionID = "168";
                            break;
                    }
                } else if (estateID.equalsIgnoreCase("24")) {
                    switch (divisionclass) {
                        case 1:
                            divisionID = "170";
                            break;
                        case 2:
                            divisionID = "171";
                            break;
                        case 3:
                            divisionID = "172";
                            break;
                        case 4:
                            divisionID = "173";
                            break;
                        case 5:
                            divisionID = "174";
                            break;
                        case 6:
                            divisionID = "175";
                            break;
                    }
                } else if (estateID.equalsIgnoreCase("25")) {
                    switch (divisionclass) {
                        case 1:
                            divisionID = "176";
                            break;
                        case 2:
                            divisionID = "177";
                            break;
                        case 3:
                            divisionID = "178";
                            break;
                        case 4:
                            divisionID = "179";
                            break;
                        case 5:
                            divisionID = "180";
                            break;
                        case 6:
                            divisionID = "181";
                            break;
                        case 7:
                            divisionID = "169";
                            break;
                    }
                } else if (estateID.equalsIgnoreCase("26")) {
                    switch (divisionclass) {
                        case 1:
                            divisionID = "182";
                            break;
                        case 2:
                            divisionID = "183";
                            break;
                        case 3:
                            divisionID = "184";
                            break;
                        case 4:
                            divisionID = "185";
                            break;
                        case 5:
                            divisionID = "186";
                            break;
                        case 6:
                            divisionID = "187";
                            break;
                    }
                }
                if (!blockid.getText().toString().isEmpty()) {
                    model.setRegion(regionID);
                    model.setCompany(companyID);
                    model.setEstate(estateID);
                    model.setDivision(divisionID);
                    model.setBlockID(blockid.getText().toString());
                    if (rotasipanen.getText().toString().isEmpty())
                        model.setRotasiPanen("0");
                    else
                        model.setRotasiPanen(rotasipanen.getText().toString());
                    try {
                        model.setFormNo("FLD");
                    } catch (ParseException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    try {
                        model.savePanenInformation();
                    } catch (WriteException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    } catch (ParseException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    Intent ancak = new Intent(this, Ancak.class);
                    ancak.putExtra("object", model);
                    startActivity(ancak);
                    finish();
                } else {
                    Toast.makeText(this, "Please complete the form",
                            Toast.LENGTH_LONG).show();
                }
                break;
        }
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
                    listpt.add("Agrowiratama - Padang");
                    listpt.add("Guntung Idaman Nusa");
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
                    listestate.add("GRC");
                    estate.setAdapter(new ArrayAdapter<String>(this,
                            android.R.layout.simple_spinner_dropdown_item,
                            listestate));
                } else if (pt.getItemAtPosition(arg2).toString().equals("Berkat Sawit Sejati")) {
                    companyID = "2";
                    listestate.add("Sei Berau");
                    listestate.add("Sei Tungkal");
                    estate.setAdapter(new ArrayAdapter<String>(this,
                            android.R.layout.simple_spinner_dropdown_item, listestate));
                } else if (pt.getItemAtPosition(arg2).toString().equals("Agrowiratama - Padang")) {
                    companyID = "4";
                    listestate.add("Sei Aur");
                    listestate.add("KKPA");
                    estate.setAdapter(new ArrayAdapter<String>(this,
                            android.R.layout.simple_spinner_dropdown_item, listestate));
                } else if (pt.getItemAtPosition(arg2).toString().equals("Maju Aneka Sawit")) {
                    companyID = "5";
                    listestate.add("Tanah Mas");
                    listestate.add("Sari Mas 1");
                    listestate.add("Bakung Mas");
                    estate.setAdapter(new ArrayAdapter<String>(this,
                            android.R.layout.simple_spinner_dropdown_item, listestate));
                } else if (pt.getItemAtPosition(arg2).toString().equals("Unggul Lestari")) {
                    companyID = "6";
                    listestate.add("Unggul1");
                    listestate.add("Unggul2");
                    estate.setAdapter(new ArrayAdapter<String>(this,
                            android.R.layout.simple_spinner_dropdown_item, listestate));
                } else if (pt.getItemAtPosition(arg2).toString().equals(
                        "Globalindo Alam Perkasa")) {
                    companyID = "7";
                    listestate.add("Alam Sahara");
                    listestate.add("Alam Tani");
                    estate.setAdapter(new ArrayAdapter<String>(this,
                            android.R.layout.simple_spinner_dropdown_item, listestate));
                } else if (pt.getItemAtPosition(arg2)
                        .equals("Sukajadi Sawit Mekar")) {
                    companyID = "8";
                    listestate.add("Bukit Limas");
                    listestate.add("Bukit Linang");
                    listestate.add("Sebabi");
                    listestate.add("Seranau");
                    estate.setAdapter(new ArrayAdapter<String>(this,
                            android.R.layout.simple_spinner_dropdown_item, listestate));
                } else if (pt.getItemAtPosition(arg2)
                        .equals("Guntung Idaman Nusa")) {
                    companyID = "9";
                    listestate.add("Estate I");
                    listestate.add("Estate II");
                    listestate.add("Estate III");
                    estate.setAdapter(new ArrayAdapter<String>(this,
                            android.R.layout.simple_spinner_dropdown_item, listestate));
                }
            case R.id.spEstate:
                listdivisi = new ArrayList<String>();
                if (estate.getItemAtPosition(estate.getSelectedItemPosition()).toString().equalsIgnoreCase("1")) {
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
                } else if (estate.getItemAtPosition(estate.getSelectedItemPosition()).toString().equalsIgnoreCase("2")) {
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
                } else if (estate.getItemAtPosition(estate.getSelectedItemPosition()).toString().equalsIgnoreCase("3")) {
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
                } else if (estate.getItemAtPosition(estate.getSelectedItemPosition()).toString().equalsIgnoreCase("4")) {
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
                } else if (estate.getItemAtPosition(estate.getSelectedItemPosition()).toString().equalsIgnoreCase("5")) {
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
                } else if (estate.getItemAtPosition(estate.getSelectedItemPosition()).toString().equalsIgnoreCase("6")) {
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
                } else if (estate.getItemAtPosition(estate.getSelectedItemPosition()).toString().equalsIgnoreCase("Sei Berau")) {
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
                } else if (estate.getItemAtPosition(estate.getSelectedItemPosition()).toString().equalsIgnoreCase("Sei Tungkal")) {
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
                } else if (estate.getItemAtPosition(estate.getSelectedItemPosition()).toString().equalsIgnoreCase("Sei Aur")) {
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
                } else if (estate.getItemAtPosition(estate.getSelectedItemPosition()).toString().equalsIgnoreCase("Tanah Mas")) {
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
                } else if (estate.getItemAtPosition(estate.getSelectedItemPosition()).toString().equalsIgnoreCase("Sari Mas 1")) {
                    estateID = "12";
                    listdivisi.add("A");
                    listdivisi.add("B");
                    listdivisi.add("C");
                    listdivisi.add("D");
                    division.setAdapter(new ArrayAdapter<String>(this,
                            android.R.layout.simple_spinner_dropdown_item,
                            listdivisi));
                } else if (estate.getItemAtPosition(estate.getSelectedItemPosition()).toString().equalsIgnoreCase("Bakung Mas")) {
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
                } else if (estate.getItemAtPosition(estate.getSelectedItemPosition()).toString().equalsIgnoreCase("Unggul1")) {
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
                } else if (estate.getItemAtPosition(estate.getSelectedItemPosition()).toString().equalsIgnoreCase("Unggul2")) {
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
                } else if (estate.getItemAtPosition(estate.getSelectedItemPosition()).toString().equalsIgnoreCase("Alam Sahara")) {
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
                } else if (estate.getItemAtPosition(estate.getSelectedItemPosition()).toString().equalsIgnoreCase("Alam Tani")) {
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
                } else if (estate.getItemAtPosition(estate.getSelectedItemPosition()).toString().equalsIgnoreCase("Bukit Limas")) {
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
                } else if (estate.getItemAtPosition(estate.getSelectedItemPosition()).toString().equalsIgnoreCase("Bukit Linang")) {
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
                } else if (estate.getItemAtPosition(estate.getSelectedItemPosition()).toString().equalsIgnoreCase("Sebabi")) {
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
                } else if (estate.getItemAtPosition(estate.getSelectedItemPosition()).toString().equalsIgnoreCase("Seranau")) {
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

                } else if (estate.getItemAtPosition(estate.getSelectedItemPosition()).toString().equalsIgnoreCase("KKPA")) {
                    estateID = "22";
                    listdivisi.add("KSB1");
                    listdivisi.add("KSB2");
                    listdivisi.add("KSBAMB");
                    listdivisi.add("KSDBS");
                    division.setAdapter(new ArrayAdapter<String>(this,
                            android.R.layout.simple_spinner_dropdown_item,
                            listdivisi));
                } else if (estate.getItemAtPosition(estate.getSelectedItemPosition()).toString().equalsIgnoreCase("GRC")) {
                    estateID = "23";
                    listdivisi.add("GRC-F");
                    listdivisi.add("GRC-G");
                    division.setAdapter(new ArrayAdapter<String>(this,
                            android.R.layout.simple_spinner_dropdown_item,
                            listdivisi));
                } else if (estate.getItemAtPosition(estate.getSelectedItemPosition()).toString().equalsIgnoreCase("Estate I")) {
                    estateID = "24";
                    listdivisi.add("A");
                    listdivisi.add("B");
                    listdivisi.add("C");
                    listdivisi.add("D");
                    listdivisi.add("E");
                    listdivisi.add("F");
                    division.setAdapter(new ArrayAdapter<String>(this,
                            android.R.layout.simple_spinner_dropdown_item,
                            listdivisi));
                } else if (estate.getItemAtPosition(estate.getSelectedItemPosition()).toString().equalsIgnoreCase("Estate II")) {
                    estateID = "25";
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
                } else if (estate.getItemAtPosition(estate.getSelectedItemPosition()).toString().equalsIgnoreCase("Estate III")) {
                    estateID = "26";
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
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }
}