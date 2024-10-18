package com.ic;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
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

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class Pokok extends Activity implements OnClickListener, Observer {
    private Model model;
    private RadioGroup rgAbnormalitas, rgPasarPikul, rgBuahMatahari, rgPruning;
    private RadioButton rbAbnormalitas, rbPasarPikul, rbBuahMatahari,
            rbPruning;
    private EditText etAncak, etNamaAncak, etPokok, etTandanPanen, etBSPir,
            etBBMPir, etBBKPir, etBSPel, etBBMPel, etBBKPel, etBSPP, etBBMPP,
            etBBKPP, etBSTTA, etBBTTA, etBSTTS, etBBTTS, etBSTTK, etBBTTK,
            etBSTTO, etBBTTO, etBSTTP, etBBTTP, etBSTTT, etBBTTT,
            etBSTDH, etBBTDH, etBSTDS, etBBTDS, etBSTDK, etBBTDK,
            etBSTDO, etBBTDO, etBSTDP, etBBTDP, etBSTDT, etBBTDT,
            etWOPSPir, etWOPSPel, etBSTPH, etBBMTPH, etBBKTPH,
            etSegarTPH, etBusukTPH, etRestanTPH,
            etWOPSPP, etExtraNote, etWaktuLama;
    private TextView Time, PokokSkr;
    private CheckBox cbWeeds, cbRaking, cbObjek, cbUkuran, cbPelepah,
            cbPangkal, cbCekAbnormal, cbCekNoB, cbCekBM, cbCekLFB,
            cbCekPruning, cbCekCPir, cbCekFS, cbCekWOPS, cbCekAkses, cbCekBr,
            cbTPH, cbTPHweeds, cbTPHraking, cbTPHalas, cbCekTPH,
            cbCekTT, cbCekTD;
    private Button photo1, photo2;
    private Button btnNextPokok, btnPrevPokok, btnSaveAncak, btnExit;
    private Uri mImageCaptureUri;
    private String photo1path, photo2path, imageName;
    private int Ancak;
    private ScrollView test;
    private LinearLayout TPHcontent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokok);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Intent pokok = getIntent();
        model = (Model) pokok.getSerializableExtra("object");
        model.addObserver(this);
        test = (ScrollView) findViewById(R.id.scrollView1);
        rgAbnormalitas = (RadioGroup) findViewById(R.id.rgAbnormalitas);
        rgPasarPikul = (RadioGroup) findViewById(R.id.rgPasarPikul);
        rgBuahMatahari = (RadioGroup) findViewById(R.id.rgBungaMatahari);
        rgPruning = (RadioGroup) findViewById(R.id.rgPruning);
        etAncak = (EditText) findViewById(R.id.etAncak);
        etNamaAncak = (EditText) findViewById(R.id.etNamaAncak);
        etPokok = (EditText) findViewById(R.id.etPokok);
        etTandanPanen = (EditText) findViewById(R.id.etTandanPanen);
        etBSPir = (EditText) findViewById(R.id.etBSPir);
        etBBMPir = (EditText) findViewById(R.id.etBBMPir);
        etBBKPir = (EditText) findViewById(R.id.etBBKPir);
        etBSPel = (EditText) findViewById(R.id.etBSPel);
        etBBMPel = (EditText) findViewById(R.id.etBBMPel);
        etBBKPel = (EditText) findViewById(R.id.etBBKPel);
        etBSPP = (EditText) findViewById(R.id.etBSPP);
        etBBMPP = (EditText) findViewById(R.id.etBBMPP);
        etBBKPP = (EditText) findViewById(R.id.etBBKPP);
        etBSTTA = (EditText) findViewById(R.id.etBSTTA);
        etBBTTA = (EditText) findViewById(R.id.etBBTTA);
        etBSTTS = (EditText) findViewById(R.id.etBSTTS);
        etBBTTS = (EditText) findViewById(R.id.etBBTTS);
        etBSTTK = (EditText) findViewById(R.id.etBSTTK);
        etBBTTK = (EditText) findViewById(R.id.etBBTTK);
        etBSTTO = (EditText) findViewById(R.id.etBSTTO);
        etBBTTO = (EditText) findViewById(R.id.etBBTTO);
        etBSTTP = (EditText) findViewById(R.id.etBSTTP);
        etBBTTP = (EditText) findViewById(R.id.etBBTTP);
        etBSTTT = (EditText) findViewById(R.id.etBSTTT);
        etBBTTT = (EditText) findViewById(R.id.etBBTTT);
        etBSTDH = (EditText) findViewById(R.id.etBSTDH);
        etBBTDH = (EditText) findViewById(R.id.etBBTDH);
        etBSTDS = (EditText) findViewById(R.id.etBSTDS);
        etBBTDS = (EditText) findViewById(R.id.etBBTDS);
        etBSTDK = (EditText) findViewById(R.id.etBSTDK);
        etBBTDK = (EditText) findViewById(R.id.etBBTDK);
        etBSTDO = (EditText) findViewById(R.id.etBSTDO);
        etBBTDO = (EditText) findViewById(R.id.etBBTDO);
        etBSTDP = (EditText) findViewById(R.id.etBSTDP);
        etBBTDP = (EditText) findViewById(R.id.etBBTDP);
        etBSTDT = (EditText) findViewById(R.id.etBSTDT);
        etBBTDT = (EditText) findViewById(R.id.etBBTDT);
        etWOPSPir = (EditText) findViewById(R.id.etWOPSPir);
        etWOPSPel = (EditText) findViewById(R.id.etWOPSPel);
        etWOPSPP = (EditText) findViewById(R.id.etWOPSPP);
        etBSTPH = (EditText) findViewById(R.id.etBSTPH);
        etBBMTPH = (EditText) findViewById(R.id.etBBMTPH);
        etBBKTPH = (EditText) findViewById(R.id.etBBKTPH);
        etSegarTPH = (EditText) findViewById(R.id.etSegarTPH);
        etBusukTPH = (EditText) findViewById(R.id.etBusukTPH);
        etRestanTPH = (EditText) findViewById(R.id.etRestanTPH);
        cbWeeds = (CheckBox) findViewById(R.id.cbWeeds);
        cbRaking = (CheckBox) findViewById(R.id.cbRaking);
        cbObjek = (CheckBox) findViewById(R.id.cbObjek);
        cbUkuran = (CheckBox) findViewById(R.id.cbUkuran);
        cbPelepah = (CheckBox) findViewById(R.id.cbPelepah);
        cbPangkal = (CheckBox) findViewById(R.id.cbPangkal);
        etExtraNote = (EditText) findViewById(R.id.etExtraNote);
        cbCekAbnormal = (CheckBox) findViewById(R.id.cbCekAbnormal);
        cbCekNoB = (CheckBox) findViewById(R.id.cbCekNoB);
        cbCekBM = (CheckBox) findViewById(R.id.cbCekBM);
        cbCekLFB = (CheckBox) findViewById(R.id.cbCekLFB);
        cbCekPruning = (CheckBox) findViewById(R.id.cbCekPruning);
        cbCekCPir = (CheckBox) findViewById(R.id.cbCekCPir);
        cbCekFS = (CheckBox) findViewById(R.id.cbCekFS);
        cbCekWOPS = (CheckBox) findViewById(R.id.cbCekWOPS);
        cbCekAkses = (CheckBox) findViewById(R.id.cbCekAkses);
        cbCekBr = (CheckBox) findViewById(R.id.cbCekBr);
        cbCekTT = (CheckBox) findViewById(R.id.cbCekTT);
        cbCekTD = (CheckBox) findViewById(R.id.cbCekTD);
        cbTPH = (CheckBox) findViewById(R.id.cbTPH);
        cbTPHweeds = (CheckBox) findViewById(R.id.cbTPHweeds);
        cbTPHraking = (CheckBox) findViewById(R.id.cbTPHraking);
        cbTPHalas = (CheckBox) findViewById(R.id.cbTPHalas);
        cbCekTPH = (CheckBox) findViewById(R.id.cbCekTPH);
        TPHcontent = (LinearLayout) findViewById(R.id.TPHcontent);
        Time = (TextView) findViewById(R.id.tvTime);
        etWaktuLama = (EditText) findViewById(R.id.etWaktuLama);
        PokokSkr = (TextView) findViewById(R.id.tvPokokSekarang);
        photo1 = (Button) findViewById(R.id.btnPhoto1);
        photo2 = (Button) findViewById(R.id.btnPhoto2);
        btnNextPokok = (Button) findViewById(R.id.btnNext);
        btnPrevPokok = (Button) findViewById(R.id.btnPrevious);
        btnSaveAncak = (Button) findViewById(R.id.btnSaveAncak);
        btnExit = (Button) findViewById(R.id.btnExit);
        if (model.getEvaluator().equals("Staff HO") || model.getEvaluator().equals("Leader")) {
            cbCekAbnormal.setVisibility(VISIBLE);
            cbCekNoB.setVisibility(VISIBLE);
            cbCekBM.setVisibility(VISIBLE);
            cbCekLFB.setVisibility(VISIBLE);
            //cbCekPruning.setVisibility(VISIBLE);
            cbCekCPir.setVisibility(VISIBLE);
            cbCekFS.setVisibility(VISIBLE);
            cbCekWOPS.setVisibility(VISIBLE);
            cbCekAkses.setVisibility(VISIBLE);
            cbCekBr.setVisibility(VISIBLE);
            cbCekTT.setVisibility(VISIBLE);
            cbCekTD.setVisibility(VISIBLE);
            cbCekTPH.setVisibility(VISIBLE);
            etWaktuLama.setVisibility(GONE);
        } else {
            cbCekAbnormal.setVisibility(GONE);
            cbCekNoB.setVisibility(GONE);
            cbCekBM.setVisibility(GONE);
            cbCekLFB.setVisibility(GONE);
            cbCekPruning.setVisibility(GONE);
            cbCekCPir.setVisibility(GONE);
            cbCekFS.setVisibility(GONE);
            cbCekWOPS.setVisibility(GONE);
            cbCekAkses.setVisibility(GONE);
            cbCekBr.setVisibility(GONE);
            cbCekTT.setVisibility(GONE);
            cbCekTD.setVisibility(GONE);
            cbCekTPH.setVisibility(GONE);
            etWaktuLama.setVisibility(GONE);
        }
        model.setPokok(1);
        cbTPH.setOnClickListener(this);
        btnNextPokok.setOnClickListener(this);
        btnPrevPokok.setOnClickListener(this);
        btnSaveAncak.setOnClickListener(this);
        btnExit.setOnClickListener(this);
        photo1.setOnClickListener(this);
        photo2.setOnClickListener(this);
        etPokok.setText(model.getPokok());
        btnPrevPokok.setEnabled(false);
        new readRecord().execute();
        Thread myThread = null;
        Runnable runnable = new Time();
        myThread = new Thread(runnable);
        myThread.start();
        String[] noAncak = model.getNomorAncak();
        String[] namaAncak = model.getNamaAncak();
        switch (model.getPointer()) {
            case 1:
                etAncak.setText(noAncak[0]);
                etNamaAncak.setText(namaAncak[0]);
                Ancak = 0;
                break;
            case 41:
                etAncak.setText(noAncak[1]);
                etNamaAncak.setText(namaAncak[1]);
                Ancak = 1;
                break;
            case 81:
                etAncak.setText(noAncak[2]);
                etNamaAncak.setText(namaAncak[2]);
                Ancak = 2;
                break;
            case 121:
                etAncak.setText(noAncak[3]);
                etNamaAncak.setText(namaAncak[3]);
                Ancak = 3;
                break;
            case 161:
                etAncak.setText(noAncak[4]);
                etNamaAncak.setText(namaAncak[4]);
                Ancak = 4;
                break;
            case 201:
                etAncak.setText(noAncak[5]);
                etNamaAncak.setText(namaAncak[5]);
                Ancak = 5;
                break;
            case 241:
                etAncak.setText(noAncak[6]);
                etNamaAncak.setText(namaAncak[6]);
                Ancak = 6;
                break;
            case 281:
                etAncak.setText(noAncak[7]);
                etNamaAncak.setText(namaAncak[7]);
                Ancak = 7;
                break;
            case 321:
                etAncak.setText(noAncak[8]);
                etNamaAncak.setText(namaAncak[8]);
                Ancak = 8;
                break;
            case 361:
                etAncak.setText(noAncak[9]);
                etNamaAncak.setText(namaAncak[9]);
                Ancak = 9;
                break;
        }
        PokokSkr.setText("Sekarang pada pokok: " + model.getPokok());

        new readRecord().execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_ancak, menu);
        return true;
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        // TODO Auto-generated method stub
        etPokok.setText(model.getPokok());
        PokokSkr.setText("Sekarang pada pokok: " + model.getPokok());
        etTandanPanen.setText("");
        etBSPir.setText("");
        etBBMPir.setText("");
        etBBKPir.setText("");
        etBSPel.setText("");
        etBBMPel.setText("");
        etBBKPel.setText("");
        etBSPP.setText("");
        etBBMPP.setText("");
        etBBKPP.setText("");
        etBSTTA.setText("");
        etBBTTA.setText("");
        etBSTTS.setText("");
        etBBTTS.setText("");
        etBSTTK.setText("");
        etBBTTK.setText("");
        etBSTTO.setText("");
        etBBTTO.setText("");
        etBSTTP.setText("");
        etBBTTP.setText("");
        etBSTTT.setText("");
        etBBTTT.setText("");
        etBSTDH.setText("");
        etBBTDH.setText("");
        etBSTDS.setText("");
        etBBTDS.setText("");
        etBSTDK.setText("");
        etBBTDK.setText("");
        etBSTDO.setText("");
        etBBTDO.setText("");
        etBSTDP.setText("");
        etBBTDP.setText("");
        etBSTDT.setText("");
        etBBTDT.setText("");
        etWOPSPir.setText("");
        etWOPSPel.setText("");
        etWOPSPP.setText("");
        etBSTPH.setText("");
        etBBMTPH.setText("");
        etBBKTPH.setText("");
        etSegarTPH.setText("");
        etBusukTPH.setText("");
        etRestanTPH.setText("");
        rgAbnormalitas.check(R.id.rbabnormal);
        rgPasarPikul.check(R.id.rbAkses);
        rgBuahMatahari.check(R.id.rbBunga);
        rgPruning.check(R.id.rbPruning);
        cbWeeds.setChecked(false);
        cbRaking.setChecked(false);
        cbObjek.setChecked(false);
        cbUkuran.setChecked(false);
        cbPelepah.setChecked(false);
        cbPangkal.setChecked(false);
        cbTPHweeds.setChecked(false);
        cbTPHraking.setChecked(false);
        cbTPHalas.setChecked(false);
        etExtraNote.setText("");
        etWaktuLama.setText("");
        cbCekAbnormal.setChecked(false);
        cbCekBM.setChecked(false);
        cbCekLFB.setChecked(false);
        cbCekPruning.setChecked(false);
        cbCekCPir.setChecked(false);
        cbCekFS.setChecked(false);
        cbCekWOPS.setChecked(false);
        cbCekAkses.setChecked(false);
        cbCekBr.setChecked(false);
        cbCekTT.setChecked(false);
        cbCekTD.setChecked(false);
        cbCekTPH.setChecked(false);
        new readRecord().execute();
        if (etPokok.getText().toString().equals("1")) {
            btnPrevPokok.setEnabled(false);
        } else {
            btnPrevPokok.setEnabled(true);
        }
        if (etPokok.getText().toString().equals("40")) {
            btnNextPokok.setEnabled(false);
        } else {
            btnNextPokok.setEnabled(true);
        }

        if (cbTPH.isChecked()){
            TPHcontent.setVisibility(VISIBLE);
        } else {
            TPHcontent.setVisibility(GONE);
        }
    }

    public void takePhoto(int i) {
        Intent takePhoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        String dirName = "/InternalControl/photo";
        File file;
        if (android.os.Environment.getExternalStorageState().equals(
                android.os.Environment.MEDIA_MOUNTED)) {
            File sdCard = Environment.getExternalStorageDirectory();
            File dir = new File(sdCard.getAbsolutePath() + dirName);
            dir.mkdirs();
            file = new File(dir, imageName);
        } else {
            File phoneMemory = Environment.getRootDirectory();
            File dir = new File(phoneMemory.getAbsolutePath() + dirName);
            file = new File(dir, imageName);
        }
        mImageCaptureUri = Uri.fromFile(file);
        if (i == 1) {
            photo1path = mImageCaptureUri.getPath();
        } else {
            photo2path = mImageCaptureUri.getPath();
        }
        takePhoto.putExtra(android.provider.MediaStore.EXTRA_OUTPUT,
                mImageCaptureUri);
        startActivityForResult(takePhoto, 0);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onClick(View arg0) {
        // TODO Auto-generated method stub
        switch (arg0.getId()) {
            case R.id.cbTPH:
                if (cbTPH.isChecked()){
                    TPHcontent.setVisibility(VISIBLE);
                } else {
                    TPHcontent.setVisibility(GONE);
                }
                break;
            case R.id.btnPhoto1:
                imageName = model.getFormNo() + "." + etPokok.getText().toString()
                        + "." + "photo1.jpg";
                takePhoto(1);
                break;
            case R.id.btnPhoto2:
                imageName = model.getFormNo() + "." + etPokok.getText().toString()
                        + "." + "photo2.jpg";
                takePhoto(2);
                break;
            case R.id.btnPrevious:
                model.prevPokok();
                saveData();
                break;
            case R.id.btnNext:
                model.nextPokok();
                saveData();
                break;
            case R.id.btnSaveAncak:
                saveData();
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                alertDialog.setTitle("Save Ancak");
                LayoutInflater inflater = getLayoutInflater();
                View dialog = inflater.inflate(R.layout.alertdialog, null);
                // final EditText etExtraNote = (EditText)
                // dialog.findViewById(R.id.etExtraNote);
                final CheckBox cbFU = (CheckBox) dialog.findViewById(R.id.cbFU);
                alertDialog.setView(dialog);
                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        // TODO Auto-generated method stub
                        // String extraNote = etExtraNote.getText().toString();
                        String followUp = "0";
                        if (cbFU.isChecked()) {
                            followUp = "1";
                        }
                        try {
                            model.saveFollowUp(Ancak, followUp);
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
                        Intent ancak = new Intent(Pokok.this, Ancak.class);
                        ancak.putExtra("object", model);
                        startActivity(ancak);
                        finish();
                    }
                });
                alertDialog.show();

                break;
            case R.id.btnExit:
                saveData();
                AlertDialog alertDialog2 = new AlertDialog.Builder(this).create();
                alertDialog2.setTitle("Save Ancak");
                LayoutInflater inflater2 = getLayoutInflater();
                View dialog2 = inflater2.inflate(R.layout.alertdialog, null);
                // final EditText etExtraNote2 = (EditText)
                // dialog2.findViewById(R.id.etExtraNote);
                final CheckBox cbFU2 = (CheckBox) dialog2.findViewById(R.id.cbFU);
                alertDialog2.setView(dialog2);
                alertDialog2.setButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        // TODO Auto-generated method stub
                        // String extraNote = etExtraNote2.getText().toString();
                        String followUp = "0";
                        if (cbFU2.isChecked()) {
                            followUp = "1";
                        }
                        try {
                            model.saveFollowUp(Ancak, followUp);
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

                        finish();
                    }
                });
                alertDialog2.show();

                break;
        }
    }

    @SuppressLint("SimpleDateFormat")
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    private void saveData() {
        boolean error = false;
        String errormsg = "";
        int selectedid;
        selectedid = rgAbnormalitas.getCheckedRadioButtonId();
        rbAbnormalitas = (RadioButton) findViewById(selectedid);
        selectedid = rgPasarPikul.getCheckedRadioButtonId();
        rbPasarPikul = (RadioButton) findViewById(selectedid);
        selectedid = rgBuahMatahari.getCheckedRadioButtonId();
        rbBuahMatahari = (RadioButton) findViewById(selectedid);
        selectedid = rgPruning.getCheckedRadioButtonId();
        rbPruning = (RadioButton) findViewById(selectedid);
        String abnormalitas = null;
        if (rbAbnormalitas.getId() == R.id.rbabnormal) {
            abnormalitas = "";
        } else if (rbAbnormalitas.getId() == R.id.rbabnormalk) {
            abnormalitas = "k";
        } else if (rbAbnormalitas.getId() == R.id.rbabnormals) {
            abnormalitas = "s";
        } else if (rbAbnormalitas.getId() == R.id.rbabnormalt) {
            abnormalitas = "t";
        } else if (rbAbnormalitas.getId() == R.id.rbabnormalx) {
            abnormalitas = "x";
        } else if (rbAbnormalitas.getId() == R.id.rbabnormalb) {
            abnormalitas = "b";
        }
        String tandanPanen = null;
        if (!etTandanPanen.getText().toString().isEmpty()) {
            tandanPanen = etTandanPanen.getText().toString();
        } else {
            tandanPanen = "0";
        }

        String weeds = "0";
        String raking = "0";
        String objek = "0";
        String ukuran = "0";
        if (cbWeeds.isChecked()) {
            weeds = "1";
        }
        if (cbRaking.isChecked()) {
            raking = "1";
        }
        if (cbObjek.isChecked()) {
            objek = "1";
        }
        if (cbUkuran.isChecked()) {
            ukuran = "1";
        }
        String tumpukanPelepah = "0";
        if (cbPelepah.isChecked()) {
            tumpukanPelepah = "1";
        }
        String aksesJalan = null;
        if (rbPasarPikul.getId() == R.id.rbAkses) {
            aksesJalan = "";
        } else if (rbPasarPikul.getId() == R.id.rbAksesB) {
            aksesJalan = "b";
        } else if (rbPasarPikul.getId() == R.id.rbAksesO) {
            aksesJalan = "o";
        } else if (rbPasarPikul.getId() == R.id.rbAksesP) {
            aksesJalan = "p";
        } else if (rbPasarPikul.getId() == R.id.rbAksesT) {
            aksesJalan = "t";
        } else if (rbPasarPikul.getId() == R.id.rbAksesW) {
            aksesJalan = "w";
        }
        String buahMatahari = null;
        if (rbBuahMatahari.getId() == R.id.rbBunga) {
            buahMatahari = "";
        } else if (rbBuahMatahari.getId() == R.id.rbBungaD) {
            buahMatahari = "d";
        } else if (rbBuahMatahari.getId() == R.id.rbBungaK) {
            buahMatahari = "k";
        } else if (rbBuahMatahari.getId() == R.id.rbBungaL) {
            buahMatahari = "l";
        }
        String pangkalPelepah = "0";
        if (cbPangkal.isChecked()) {
            pangkalPelepah = "1";
        }
        String pruning = null;
        if (rbPruning.getId() == R.id.rbPruning) {
            pruning = "";
        } else if (rbPruning.getId() == R.id.rbPruningO) {
            pruning = "o";
        } else if (rbPruning.getId() == R.id.rbPruningU) {
            pruning = "u";
        }
        String BSPir = null;
        if (!etBSPir.getText().toString().isEmpty()) {
            BSPir = etBSPir.getText().toString();
        } else {
            BSPir = "0";
        }
        String BBMPir = null;
        if (!etBBMPir.getText().toString().isEmpty()) {
            BBMPir = etBBMPir.getText().toString();
        } else {
            BBMPir = "0";
        }
        String BBKPir = null;
        if (!etBBKPir.getText().toString().isEmpty()) {
            BBKPir = etBBKPir.getText().toString();
        } else {
            BBKPir = "0";
        }
        String BSPel = null;
        if (!etBSPel.getText().toString().isEmpty()) {
            BSPel = etBSPel.getText().toString();
        } else {
            BSPel = "0";
        }
        String BBMPel = null;
        if (!etBBMPel.getText().toString().isEmpty()) {
            BBMPel = etBBMPel.getText().toString();
        } else {
            BBMPel = "0";
        }
        String BBKPel = null;
        if (!etBBKPel.getText().toString().isEmpty()) {
            BBKPel = etBBKPel.getText().toString();
        } else {
            BBKPel = "0";
        }
        String BSPP = null;
        if (!etBSPP.getText().toString().isEmpty()) {
            BSPP = etBSPP.getText().toString();
        } else {
            BSPP = "0";
        }
        String BBMPP = null;
        if (!etBBMPP.getText().toString().isEmpty()) {
            BBMPP = etBBMPP.getText().toString();
        } else {
            BBMPP = "0";
        }
        String BBKPP = null;
        if (!etBBKPP.getText().toString().isEmpty()) {
            BBKPP = etBBKPP.getText().toString();
        } else {
            BBKPP = "0";
        }

        String BSTTA = null;
        if (!etBSTTA.getText().toString().isEmpty()) {
            BSTTA = etBSTTA.getText().toString();
        } else {
            BSTTA = "0";
        }
        String BBTTA = null;
        if (!etBBTTA.getText().toString().isEmpty()) {
            BBTTA = etBBTTA.getText().toString();
        } else {
            BBTTA = "0";
        }

        String BSTTS = null;
        if (!etBSTTS.getText().toString().isEmpty()) {
            BSTTS = etBSTTS.getText().toString();
        } else {
            BSTTS = "0";
        }
        String BBTTS = null;
        if (!etBBTTS.getText().toString().isEmpty()) {
            BBTTS = etBBTTS.getText().toString();
        } else {
            BBTTS = "0";
        }

        String BSTTK = null;
        if (!etBSTTK.getText().toString().isEmpty()) {
            BSTTK = etBSTTK.getText().toString();
        } else {
            BSTTK = "0";
        }
        String BBTTK = null;
        if (!etBBTTK.getText().toString().isEmpty()) {
            BBTTK = etBBTTK.getText().toString();
        } else {
            BBTTK = "0";
        }
        String BSTTO = null;
        if (!etBSTTO.getText().toString().isEmpty()) {
            BSTTO = etBSTTO.getText().toString();
        } else {
            BSTTO = "0";
        }
        String BBTTO = null;
        if (!etBBTTO.getText().toString().isEmpty()) {
            BBTTO = etBBTTO.getText().toString();
        } else {
            BBTTO = "0";
        }
        String BSTTP = null;
        if (!etBSTTP.getText().toString().isEmpty()) {
            BSTTP = etBSTTP.getText().toString();
        } else {
            BSTTP = "0";
        }
        String BBTTP = null;
        if (!etBBTTP.getText().toString().isEmpty()) {
            BBTTP = etBBTTP.getText().toString();
        } else {
            BBTTP = "0";
        }
        String BSTTT = null;
        if (!etBSTTT.getText().toString().isEmpty()) {
            BSTTT = etBSTTT.getText().toString();
        } else {
            BSTTT = "0";
        }
        String BBTTT = null;
        if (!etBBTTT.getText().toString().isEmpty()) {
            BBTTT = etBBTTT.getText().toString();
        } else {
            BBTTT = "0";
        }


        String BSTDH = null;
        if (!etBSTDH.getText().toString().isEmpty()) {
            BSTDH = etBSTDH.getText().toString();
        } else {
            BSTDH = "0";
        }
        String BBTDH = null;
        if (!etBBTDH.getText().toString().isEmpty()) {
            BBTDH = etBBTDH.getText().toString();
        } else {
            BBTDH = "0";
        }

        String BSTDS = null;
        if (!etBSTDS.getText().toString().isEmpty()) {
            BSTDS = etBSTDS.getText().toString();
        } else {
            BSTDS = "0";
        }
        String BBTDS = null;
        if (!etBBTDS.getText().toString().isEmpty()) {
            BBTDS = etBBTDS.getText().toString();
        } else {
            BBTDS = "0";
        }

        String BSTDK = null;
        if (!etBSTDK.getText().toString().isEmpty()) {
            BSTDK = etBSTDK.getText().toString();
        } else {
            BSTDK = "0";
        }
        String BBTDK = null;
        if (!etBBTDK.getText().toString().isEmpty()) {
            BBTDK = etBBTDK.getText().toString();
        } else {
            BBTDK = "0";
        }
        String BSTDO = null;
        if (!etBSTDO.getText().toString().isEmpty()) {
            BSTDO = etBSTDO.getText().toString();
        } else {
            BSTDO = "0";
        }
        String BBTDO = null;
        if (!etBBTDO.getText().toString().isEmpty()) {
            BBTDO = etBBTDO.getText().toString();
        } else {
            BBTDO = "0";
        }
        String BSTDP = null;
        if (!etBSTDP.getText().toString().isEmpty()) {
            BSTDP = etBSTDP.getText().toString();
        } else {
            BSTDP = "0";
        }
        String BBTDP = null;
        if (!etBBTDP.getText().toString().isEmpty()) {
            BBTDP = etBBTDP.getText().toString();
        } else {
            BBTDP = "0";
        }
        String BSTDT = null;
        if (!etBSTDT.getText().toString().isEmpty()) {
            BSTDT = etBSTDT.getText().toString();
        } else {
            BSTDT = "0";
        }
        String BBTDT = null;
        if (!etBBTDT.getText().toString().isEmpty()) {
            BBTDT = etBBTDT.getText().toString();
        } else {
            BBTDT = "0";
        }

        String WOPSPir = null;
        if (!etWOPSPir.getText().toString().isEmpty()) {
            WOPSPir = etWOPSPir.getText().toString();
        } else {
            WOPSPir = "0";
        }
        String WOPSPel = null;
        if (!etWOPSPel.getText().toString().isEmpty()) {
            WOPSPel = etWOPSPel.getText().toString();
        } else {
            WOPSPel = "0";
        }
        String WOPSPP = null;
        if (!etWOPSPP.getText().toString().isEmpty()) {
            WOPSPP = etWOPSPP.getText().toString();
        } else {
            WOPSPP = "0";
        }

        String TPH = "0";
        if (cbTPH.isChecked()){
            TPH = "1";
        }

        String TPHweeds = "0";
        if (cbTPHweeds.isChecked()){
            TPHweeds = "1";
        }

        String TPHraking = "0";
        if (cbTPHraking.isChecked()){
            TPHraking = "0";
        }

        String TPHalas = "0";
        if (cbTPHalas.isChecked()){
            TPHalas = "1";
        }

        String BSTPH = null;
        if (!etBSTPH.getText().toString().isEmpty()){
            BSTPH = etBSTPH.getText().toString();
        } else {
            BSTPH = "0";
        }

        String BBMTPH = null;
        if (!etBBMTPH.getText().toString().isEmpty()){
            BBMTPH = etBBMTPH.getText().toString();
        } else {
            BBMTPH = "0";
        }

        String BBKTPH = null;
        if (!etBBKTPH.getText().toString().isEmpty()){
            BBKTPH = etBBKTPH.getText().toString();
        } else {
            BBKTPH = "0";
        }

        String segarTPH = null;
        if (!etSegarTPH.getText().toString().isEmpty()){
            segarTPH = etSegarTPH.getText().toString();
        } else {
            segarTPH = "0";
        }

        String busukTPH = null;
        if (!etBusukTPH.getText().toString().isEmpty()){
            busukTPH = etBusukTPH.getText().toString();
        } else {
            busukTPH = "0";
        }

        String restanTPH = null;
        if (!etRestanTPH.getText().toString().isEmpty()){
            restanTPH = etRestanTPH.getText().toString();
        } else {
            restanTPH = "0";
        }

        String extraNote = etExtraNote.getText().toString();

        String cekAbnormal = "0";
        if (cbCekAbnormal.isChecked()) {
            cekAbnormal = "1";
        }

        String cekNoB = "0";
        if (cbCekNoB.isChecked()) {
            cekNoB = "1";
        }

        String cekBM = "0";
        if (cbCekBM.isChecked()) {
            cekBM = "1";
        }

        String cekLFB = "0";
        if (cbCekLFB.isChecked()) {
            cekLFB = "1";
        }

        String cekPruning = "0";
        if (cbCekPruning.isChecked()) {
            cekPruning = "1";
        }

        String cekCPir = "0";
        if (cbCekCPir.isChecked()) {
            cekCPir = "1";
        }

        String cekFS = "0";
        if (cbCekFS.isChecked()) {
            cekFS = "1";
        }

        String cekWOPS = "0";
        if (cbCekWOPS.isChecked()) {
            cekWOPS = "1";
        }

        String cekAkses = "0";
        if (cbCekAkses.isChecked()) {
            cekAkses = "1";
        }

        String cekBr = "0";
        if (cbCekBr.isChecked()) {
            cekBr = "1";
        }

        String cekTT = "0";
        if (cbCekTT.isChecked()) {
            cekTT = "1";
        }

        String cekTD = "0";
        if (cbCekTD.isChecked()) {
            cekTD = "1";
        }

        String cekTPH = "0";
        if (cbCekTPH.isChecked()) {
            cekTPH = "1";
        }

        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        String Time = null;
        if (!etWaktuLama.getText().toString().isEmpty()) {
            Time = etWaktuLama.getText().toString();
        } else {
            Time = new SimpleDateFormat("HH:mm:ss").format(date);
        }
        String TimeU = new SimpleDateFormat("HH:mm:ss").format(date);
        if (error) {
            Toast.makeText(this, errormsg, Toast.LENGTH_LONG).show();
        } else {
            try {
                model.storePokok(etPokok.getText().toString(), etAncak
                                .getText().toString(), abnormalitas, tandanPanen,
                        buahMatahari, pangkalPelepah, pruning, weeds, raking,
                        objek, ukuran, tumpukanPelepah, WOPSPir, WOPSPel,
                        WOPSPP, aksesJalan, BSPir, BBMPir, BBKPir, BSPel,
                        BBMPel, BBKPel, BSPP, BBMPP, BBKPP, BSTTA, BBTTA,
                        BSTTS, BBTTS, BSTTK, BBTTK, BSTTO, BBTTO, BSTTP, BBTTP,
                        BSTTT, BBTTT, BSTDH, BBTDH, BSTDS, BBTDS, BSTDK, BBTDK,
                        BSTDO, BBTDO, BSTDP, BBTDP, BSTDT, BBTDT, TPH, TPHweeds,
                        TPHraking, TPHalas, BSTPH, BBMTPH, BBKTPH, segarTPH,
                        busukTPH, restanTPH, photo1path,
                        photo2path, Time, TimeU, extraNote, cekAbnormal,
                        cekNoB, cekBM, cekLFB, cekPruning, cekCPir, cekFS,
                        cekWOPS, cekAkses, cekBr, cekTT, cekTD, cekTPH
                );
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

            test.fullScroll(View.FOCUS_UP);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        switch (requestCode) {
            case 0:
                if (resultCode == RESULT_OK) {
                    // photo1path = mImageCaptureUri1.getPath();
                } else {
                    Toast.makeText(this, "Canceled", Toast.LENGTH_SHORT).show();
                }
                break;
            case 1:
                if (resultCode == RESULT_OK) {
                    // photo2path = mImageCaptureUri2.getPath();
                } else {
                    Toast.makeText(this, "Canceled", Toast.LENGTH_SHORT).show();
                }
        }
    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            AlertDialog.Builder back = new AlertDialog.Builder(this);
            back.setTitle("Peringatan!");
            back.setMessage("Apa anda yakin untuk membatal input?");
            back.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    // TODO Auto-generated method stub
                    finish();
                }
            });
            back.setNegativeButton("Cancel",
                    new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                            // TODO Auto-generated method stub

                        }
                    }
            );
            back.show();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
    }

    public void setTandanPanen(String msg) {
        etTandanPanen.setText(msg);
    }

    public void setBSPel(String msg) {
        etBSPel.setText(msg);
    }

    public void setBBMPel(String msg) {
        etBBMPel.setText(msg);
    }

    public void setBBKPel(String msg) {
        etBBKPel.setText(msg);
    }

    public void setBSPir(String msg) {
        etBSPir.setText(msg);
    }

    public void setBBMPir(String msg) {
        etBBMPir.setText(msg);
    }

    public void setBBKPir(String msg) {
        etBBKPir.setText(msg);
    }

    public void setBSPP(String msg) {
        etBSPP.setText(msg);
    }

    public void setBBMPP(String msg) {
        etBBMPP.setText(msg);
    }

    public void setBBKPP(String msg) {
        etBBKPP.setText(msg);
    }

    public void setBSTTA(String msg) {
        etBSTTA.setText(msg);
    }

    public void setBBTTA(String msg) {
        etBBTTA.setText(msg);
    }

    public void setBSTTS(String msg) {
        etBSTTS.setText(msg);
    }

    public void setBBTTS(String msg) {
        etBBTTS.setText(msg);
    }

    public void setBSTTK(String msg) {
        etBSTTK.setText(msg);
    }

    public void setBBTTK(String msg) {
        etBBTTK.setText(msg);
    }

    public void setBSTTO(String msg) {
        etBSTTO.setText(msg);
    }

    public void setBBTTO(String msg) {
        etBBTTO.setText(msg);
    }

    public void setBSTTP(String msg) {
        etBSTTP.setText(msg);
    }

    public void setBBTTP(String msg) {
        etBBTTP.setText(msg);
    }

    public void setBSTTT(String msg) {
        etBSTTT.setText(msg);
    }

    public void setBBTTT(String msg) {
        etBBTTT.setText(msg);
    }

    public void setBSTDH(String msg) {
        etBSTDH.setText(msg);
    }

    public void setBBTDH(String msg) {
        etBBTDH.setText(msg);
    }

    public void setBSTDS(String msg) {
        etBSTDS.setText(msg);
    }

    public void setBBTDS(String msg) {
        etBBTDS.setText(msg);
    }

    public void setBSTDK(String msg) {
        etBSTDK.setText(msg);
    }

    public void setBBTDK(String msg) {
        etBBTDK.setText(msg);
    }

    public void setBSTDO(String msg) {
        etBSTDO.setText(msg);
    }

    public void setBBTDO(String msg) {
        etBBTDO.setText(msg);
    }

    public void setBSTDP(String msg) {
        etBSTDP.setText(msg);
    }

    public void setBBTDP(String msg) {
        etBBTDP.setText(msg);
    }

    public void setBSTDT(String msg) {
        etBSTDT.setText(msg);
    }

    public void setBBTDT(String msg) {
        etBBTDT.setText(msg);
    }

    public void setWOPSPir(String msg) {
        etWOPSPir.setText(msg);
    }

    public void setWOPSPel(String msg) {
        etWOPSPel.setText(msg);
    }

    public void setWOPSPP(String msg) {
        etWOPSPP.setText(msg);
    }

    public void setBSTPH (String msg){
        etBSTPH.setText(msg);
    }

    public void setBBMTPH (String msg){
        etBBMTPH.setText(msg);
    }

    public void setBBKTPH (String msg){
        etBBKTPH.setText(msg);
    }

    public void setSegarTPH (String msg){
        etSegarTPH.setText(msg);
    }

    public void setBusukTPH (String msg){
        etBusukTPH.setText(msg);
    }

    public void setRestanTPH (String msg){
        etRestanTPH.setText(msg);
    }

    public void setExtraNote(String msg) {
        etExtraNote.setText(msg);
    }

    public void setWaktuLama(String msg) {
        etWaktuLama.setText(msg);
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

    private class readRecord extends AsyncTask<Void, Void, Void> {
        ProgressDialog progressBar;
        boolean found;

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();
            progressBar = new ProgressDialog(Pokok.this);
            progressBar.setCancelable(false);
            progressBar.setMessage("Loading...");
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
                found = model.readPokok(Integer.parseInt(etPokok.getText()
                        .toString()));
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
                    result = model.readPokokDetail(Integer.parseInt(etPokok
                            .getText().toString()));
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
                String abnormalitas = result.get(0);
                if (abnormalitas.equals("")) {
                    rgAbnormalitas.check(R.id.rbabnormal);
                } else if (abnormalitas.equals("x")) {
                    rgAbnormalitas.check(R.id.rbabnormalx);
                } else if (abnormalitas.equals("t")) {
                    rgAbnormalitas.check(R.id.rbabnormalt);
                } else if (abnormalitas.equals("b")) {
                    rgAbnormalitas.check(R.id.rbabnormalb);
                } else if (abnormalitas.equals("s")) {
                    rgAbnormalitas.check(R.id.rbabnormals);
                } else if (abnormalitas.equals("k")) {
                    rgAbnormalitas.check(R.id.rbabnormalk);
                }
                setTandanPanen(result.get(1));
                String buahMatahari = result.get(2);
                if (buahMatahari.equals("")) {
                    rgBuahMatahari.check(R.id.rbBunga);
                } else if (buahMatahari.equals("d")) {
                    rgBuahMatahari.check(R.id.rbBungaD);
                } else if (buahMatahari.equals("l")) {
                    rgBuahMatahari.check(R.id.rbBungaL);
                } else if (buahMatahari.equals("k")) {
                    rgBuahMatahari.check(R.id.rbBungaK);
                }

                String pangkalPelepah = result.get(3);
                if (pangkalPelepah.equals("1")) {
                    cbPangkal.setChecked(true);
                } else {
                    cbPangkal.setChecked(false);
                }

                String pruning = result.get(4);
                if (pruning.equals("")) {
                    rgPruning.check(R.id.rbPruning);
                } else if (pruning.equals("u")) {
                    rgPruning.check(R.id.rbPruningU);
                } else if (pruning.equals("o")) {
                    rgPruning.check(R.id.rbPruningO);
                }
                String weeds = result.get(5);
                if (weeds.equals("1")) {
                    cbWeeds.setChecked(true);
                } else {
                    cbWeeds.setChecked(false);
                }
                String raking = result.get(6);
                if (raking.equals("1")) {
                    cbRaking.setChecked(true);
                } else {
                    cbRaking.setChecked(false);
                }
                String objek = result.get(7);
                if (objek.equals("1")) {
                    cbObjek.setChecked(true);
                } else {
                    cbObjek.setChecked(false);
                }
                String ukuran = result.get(8);
                if (ukuran.equals("1")) {
                    cbUkuran.setChecked(true);
                } else {
                    cbUkuran.setChecked(false);
                }
                String tumpukanpelepah = result.get(9);
                if (tumpukanpelepah.equals("1")) {
                    cbPelepah.setChecked(true);
                } else {
                    cbPelepah.setChecked(false);
                }
                setWOPSPir(result.get(10));
                setWOPSPel(result.get(11));
                setWOPSPP(result.get(12));
                String aksesjalan = result.get(13);
                if (aksesjalan.equals("")) {
                    rgPasarPikul.check(R.id.rbAkses);
                } else if (aksesjalan.equals("b")) {
                    rgPasarPikul.check(R.id.rbAksesB);
                } else if (aksesjalan.equals("o")) {
                    rgPasarPikul.check(R.id.rbAksesO);
                } else if (aksesjalan.equals("p")) {
                    rgPasarPikul.check(R.id.rbAksesP);
                } else if (aksesjalan.equals("t")) {
                    rgPasarPikul.check(R.id.rbAksesT);
                } else if (aksesjalan.equals("w")) {
                    rgPasarPikul.check(R.id.rbAksesW);
                }
                setBSPir(result.get(14));
                setBBMPir(result.get(15));
                setBBKPir(result.get(16));
                setBSPel(result.get(17));
                setBBMPel(result.get(18));
                setBBKPel(result.get(19));
                setBSPP(result.get(20));
                setBBMPP(result.get(21));
                setBBKPP(result.get(22));
                setBSTTA(result.get(23));
                setBBTTA(result.get(24));
                setBSTTS(result.get(25));
                setBBTTS(result.get(26));
                setBSTTK(result.get(27));
                setBBTTK(result.get(28));
                setBSTTO(result.get(29));
                setBBTTO(result.get(30));
                setBSTTP(result.get(31));
                setBBTTP(result.get(32));
                setBSTTT(result.get(33));
                setBBTTT(result.get(34));
                setBSTDH(result.get(35));
                setBBTDH(result.get(36));
                setBSTDS(result.get(37));
                setBBTDS(result.get(38));
                setBSTDK(result.get(39));
                setBBTDK(result.get(40));
                setBSTDO(result.get(41));
                setBBTDO(result.get(42));
                setBSTDP(result.get(43));
                setBBTDP(result.get(44));
                setBSTDT(result.get(45));
                setBBTDT(result.get(46));
                String TPH = result.get(47);
                if (TPH.equals("1")){
                    cbTPH.setChecked(true);
                } else {
                    cbTPH.setChecked(false);
                }
                String TPHweeds = result.get(48);
                if (TPHweeds.equals("1")){
                    cbTPHweeds.setChecked(true);
                } else {
                    cbTPHweeds.setChecked(false);
                }
                String TPHraking = result.get(49);
                if (TPHraking.equals("1")){
                    cbTPHraking.setChecked(true);
                } else {
                    cbTPHraking.setChecked(false);
                }
                String TPHalas = result.get(50);
                if (TPHalas.equals("1")){
                    cbTPHalas.setChecked(true);
                } else {
                    cbTPHalas.setChecked(false);
                }
                setBSTPH(result.get(51));
                setBBMTPH(result.get(52));
                setBBKTPH(result.get(53));
                setSegarTPH(result.get(54));
                setBusukTPH(result.get(55));
                setRestanTPH(result.get(56));
                setExtraNote(result.get(57));
                String cekAbnormal = result.get(58);
                if (cekAbnormal.equals("1")) {
                    cbCekAbnormal.setChecked(true);
                } else {
                    cbCekAbnormal.setChecked(false);
                }
                String cekNoB = result.get(59);
                if (cekNoB.equals("1")) {
                    cbCekNoB.setChecked(true);
                } else {
                    cbCekNoB.setChecked(false);
                }
                String cekBM = result.get(60);
                if (cekBM.equals("1")) {
                    cbCekBM.setChecked(true);
                } else {
                    cbCekBM.setChecked(false);
                }
                String cekLFB = result.get(61);
                if (cekLFB.equals("1")) {
                    cbCekLFB.setChecked(true);
                } else {
                    cbCekLFB.setChecked(false);
                }
                String cekPruning = result.get(62);
                if (cekPruning.equals("1")) {
                    cbCekPruning.setChecked(true);
                } else {
                    cbCekPruning.setChecked(false);
                }
                String cekCPir = result.get(63);
                if (cekCPir.equals("1")) {
                    cbCekCPir.setChecked(true);
                } else {
                    cbCekCPir.setChecked(false);
                }
                String cekFS = result.get(64);
                if (cekFS.equals("1")) {
                    cbCekFS.setChecked(true);
                } else {
                    cbCekFS.setChecked(false);
                }
                String cekWOPS = result.get(65);
                if (cekWOPS.equals("1")) {
                    cbCekWOPS.setChecked(true);
                } else {
                    cbCekWOPS.setChecked(false);
                }
                String cekAkses = result.get(66);
                if (cekAkses.equals("1")) {
                    cbCekAkses.setChecked(true);
                } else {
                    cbCekAkses.setChecked(false);
                }
                String cekBr = result.get(67);
                if (cekBr.equals("1")) {
                    cbCekBr.setChecked(true);
                } else {
                    cbCekBr.setChecked(false);
                }
                String cekTT = result.get(68);
                if (cekTT.equals("1")) {
                    cbCekTT.setChecked(true);
                } else {
                    cbCekTT.setChecked(false);
                }
                String cekTD = result.get(69);
                if (cekTD.equals("1")) {
                    cbCekTD.setChecked(true);
                } else {
                    cbCekTD.setChecked(false);
                }
                String cekTPH = result.get(70);
                if (cekTPH.equals("1")) {
                    cbCekTPH.setChecked(true);
                } else {
                    cbCekTPH.setChecked(false);
                }
                photo1path = result.get(71);
                photo2path = result.get(72);
                setWaktuLama(result.get(73));
            }
        }

    }

}
