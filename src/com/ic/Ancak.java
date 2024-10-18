package com.ic;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.GestureDetector.OnGestureListener;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

import static android.widget.AdapterView.INVISIBLE;
import static android.widget.AdapterView.OnItemSelectedListener;
import static android.widget.AdapterView.VISIBLE;

@TargetApi(Build.VERSION_CODES.GINGERBREAD)
public class Ancak extends Activity implements OnGestureListener, OnItemSelectedListener {
    private Model model;
    private EditText etNoAncak1, etNoAncak2, etNoAncak3, etNoAncak4,
            etNoAncak5, etNoAncak6, etNoAncak7, etNoAncak8, etNoAncak9,
            etNoAncak10;
    private EditText etNoJalur1, etNoJalur2, etNoJalur3, etNoJalur4,
            etNoJalur5, etNoJalur6, etNoJalur7, etNoJalur8, etNoJalur9,
            etNoJalur10;
    private EditText etNamaAncak1, etNamaAncak2, etNamaAncak3, etNamaAncak4,
            etNamaAncak5, etNamaAncak6, etNamaAncak7, etNamaAncak8,
            etNamaAncak9, etNamaAncak10;
    private CheckBox cbCek1, cbCek2, cbCek3, cbCek4, cbCek5, cbCek6, cbCek7, cbCek8, cbCek9, cbCek10;
    private Spinner spMataAngin1, spMataAngin2, spMataAngin3, spMataAngin4, spMataAngin5, spMataAngin6, spMataAngin7, spMataAngin8, spMataAngin9, spMataAngin10;
    private String[] nomorAncak, nomorJalur, namaAncak, mataAngin, cekAncak;
    private String[] aMataAngin = {"--Pilih salah satu--", "U -> S", "S -> U", "T -> B", "B -> T"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ancak);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Intent ancak = getIntent();
        model = (Model) ancak.getSerializableExtra("object");
        etNoAncak1 = (EditText) findViewById(R.id.etNoAncak1);
        etNoAncak2 = (EditText) findViewById(R.id.etNoAncak2);
        etNoAncak3 = (EditText) findViewById(R.id.etNoAncak3);
        etNoAncak4 = (EditText) findViewById(R.id.etNoAncak4);
        etNoAncak5 = (EditText) findViewById(R.id.etNoAncak5);
        etNoAncak6 = (EditText) findViewById(R.id.etNoAncak6);
        etNoAncak7 = (EditText) findViewById(R.id.etNoAncak7);
        etNoAncak8 = (EditText) findViewById(R.id.etNoAncak8);
        etNoAncak9 = (EditText) findViewById(R.id.etNoAncak9);
        etNoAncak10 = (EditText) findViewById(R.id.etNoAncak10);
        etNoJalur1 = (EditText) findViewById(R.id.etNoJalur1);
        etNoJalur2 = (EditText) findViewById(R.id.etNoJalur2);
        etNoJalur3 = (EditText) findViewById(R.id.etNoJalur3);
        etNoJalur4 = (EditText) findViewById(R.id.etNoJalur4);
        etNoJalur5 = (EditText) findViewById(R.id.etNoJalur5);
        etNoJalur6 = (EditText) findViewById(R.id.etNoJalur6);
        etNoJalur7 = (EditText) findViewById(R.id.etNoJalur7);
        etNoJalur8 = (EditText) findViewById(R.id.etNoJalur8);
        etNoJalur9 = (EditText) findViewById(R.id.etNoJalur9);
        etNoJalur10 = (EditText) findViewById(R.id.etNoJalur10);
        etNamaAncak1 = (EditText) findViewById(R.id.etNamaAncak1);
        etNamaAncak2 = (EditText) findViewById(R.id.etNamaAncak2);
        etNamaAncak3 = (EditText) findViewById(R.id.etNamaAncak3);
        etNamaAncak4 = (EditText) findViewById(R.id.etNamaAncak4);
        etNamaAncak5 = (EditText) findViewById(R.id.etNamaAncak5);
        etNamaAncak6 = (EditText) findViewById(R.id.etNamaAncak6);
        etNamaAncak7 = (EditText) findViewById(R.id.etNamaAncak7);
        etNamaAncak8 = (EditText) findViewById(R.id.etNamaAncak8);
        etNamaAncak9 = (EditText) findViewById(R.id.etNamaAncak9);
        etNamaAncak10 = (EditText) findViewById(R.id.etNamaAncak10);
        spMataAngin1 = (Spinner) findViewById(R.id.spMataAngin1);
        spMataAngin2 = (Spinner) findViewById(R.id.spMataAngin2);
        spMataAngin3 = (Spinner) findViewById(R.id.spMataAngin3);
        spMataAngin4 = (Spinner) findViewById(R.id.spMataAngin4);
        spMataAngin5 = (Spinner) findViewById(R.id.spMataAngin5);
        spMataAngin6 = (Spinner) findViewById(R.id.spMataAngin6);
        spMataAngin7 = (Spinner) findViewById(R.id.spMataAngin7);
        spMataAngin8 = (Spinner) findViewById(R.id.spMataAngin8);
        spMataAngin9 = (Spinner) findViewById(R.id.spMataAngin9);
        spMataAngin10 = (Spinner) findViewById(R.id.spMataAngin10);
        cbCek1 = (CheckBox) findViewById(R.id.cbCek1);
        cbCek2 = (CheckBox) findViewById(R.id.cbCek2);
        cbCek3 = (CheckBox) findViewById(R.id.cbCek3);
        cbCek4 = (CheckBox) findViewById(R.id.cbCek4);
        cbCek5 = (CheckBox) findViewById(R.id.cbCek5);
        cbCek6 = (CheckBox) findViewById(R.id.cbCek6);
        cbCek7 = (CheckBox) findViewById(R.id.cbCek7);
        cbCek8 = (CheckBox) findViewById(R.id.cbCek8);
        cbCek9 = (CheckBox) findViewById(R.id.cbCek9);
        cbCek10 = (CheckBox) findViewById(R.id.cbCek10);
        Button swipe1 = (Button) findViewById(R.id.tvSwipe1);
        Button swipe2 = (Button) findViewById(R.id.tvSwipe2);
        Button swipe3 = (Button) findViewById(R.id.tvSwipe3);
        Button swipe4 = (Button) findViewById(R.id.tvSwipe4);
        Button swipe5 = (Button) findViewById(R.id.tvSwipe5);
        Button swipe6 = (Button) findViewById(R.id.tvSwipe6);
        Button swipe7 = (Button) findViewById(R.id.tvSwipe7);
        Button swipe8 = (Button) findViewById(R.id.tvSwipe8);
        Button swipe9 = (Button) findViewById(R.id.tvSwipe9);
        Button swipe10 = (Button) findViewById(R.id.tvSwipe10);
        if (model.getEvaluator().equals("Staff HO") || model.getEvaluator().equals("Leader")) {
            cbCek1.setVisibility(VISIBLE);
            cbCek2.setVisibility(VISIBLE);
            cbCek3.setVisibility(VISIBLE);
            cbCek4.setVisibility(VISIBLE);
            cbCek5.setVisibility(VISIBLE);
            cbCek6.setVisibility(VISIBLE);
            cbCek7.setVisibility(VISIBLE);
            cbCek8.setVisibility(VISIBLE);
            cbCek9.setVisibility(VISIBLE);
            cbCek10.setVisibility(VISIBLE);
        } else {
            cbCek1.setVisibility(INVISIBLE);
            cbCek1.setHeight(0);
            cbCek2.setVisibility(INVISIBLE);
            cbCek2.setHeight(0);
            cbCek3.setVisibility(INVISIBLE);
            cbCek3.setHeight(0);
            cbCek4.setVisibility(INVISIBLE);
            cbCek4.setHeight(0);
            cbCek5.setVisibility(INVISIBLE);
            cbCek5.setHeight(0);
            cbCek6.setVisibility(INVISIBLE);
            cbCek6.setHeight(0);
            cbCek7.setVisibility(INVISIBLE);
            cbCek7.setHeight(0);
            cbCek8.setVisibility(INVISIBLE);
            cbCek8.setHeight(0);
            cbCek9.setVisibility(INVISIBLE);
            cbCek9.setHeight(0);
            cbCek10.setVisibility(INVISIBLE);
            cbCek10.setHeight(0);
        }
        nomorAncak = new String[10];
        nomorJalur = new String[10];
        namaAncak = new String[10];
        mataAngin = new String[10];
        cekAncak = new String[10];
        spMataAngin1.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, aMataAngin));
        spMataAngin1.setOnItemSelectedListener(this);
        spMataAngin2.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, aMataAngin));
        spMataAngin2.setOnItemSelectedListener(this);
        spMataAngin3.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, aMataAngin));
        spMataAngin3.setOnItemSelectedListener(this);
        spMataAngin4.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, aMataAngin));
        spMataAngin4.setOnItemSelectedListener(this);
        spMataAngin5.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, aMataAngin));
        spMataAngin5.setOnItemSelectedListener(this);
        spMataAngin6.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, aMataAngin));
        spMataAngin6.setOnItemSelectedListener(this);
        spMataAngin7.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, aMataAngin));
        spMataAngin7.setOnItemSelectedListener(this);
        spMataAngin8.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, aMataAngin));
        spMataAngin8.setOnItemSelectedListener(this);
        spMataAngin9.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, aMataAngin));
        spMataAngin9.setOnItemSelectedListener(this);
        spMataAngin10.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, aMataAngin));
        spMataAngin10.setOnItemSelectedListener(this);


        swipe1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                if (!etNoAncak1.getText().toString().isEmpty()) {
                    if (spMataAngin1.getSelectedItemPosition() > 0) {
                        model.setPointer(1);
                        saveAncak();
                    } else {
                        Toast.makeText(Ancak.this,
                                "Anda belum memilih arah mata angin",
                                Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(Ancak.this,
                            "Silakan isi nomor ancak terlebih dahulu",
                            Toast.LENGTH_LONG).show();
                }

            }
        });

        swipe2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                if (!etNoAncak2.getText().toString().isEmpty()) {
                    if (spMataAngin2.getSelectedItemPosition() > 0) {
                        model.setPointer(41);
                        saveAncak();
                    } else {
                        Toast.makeText(Ancak.this,
                                "Anda belum memilih arah mata angin",
                                Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(Ancak.this,
                            "Silakan isi nomor ancak terlebih dahulu",
                            Toast.LENGTH_LONG).show();
                }

            }
        });

        swipe3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                if (!etNoAncak3.getText().toString().isEmpty()) {
                    if (spMataAngin3.getSelectedItemPosition() > 0) {
                        model.setPointer(81);
                        saveAncak();
                    } else {
                        Toast.makeText(Ancak.this,
                                "Anda belum memilih arah mata angin",
                                Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(Ancak.this,
                            "Silakan isi nomor ancak terlebih dahulu",
                            Toast.LENGTH_LONG).show();
                }

            }
        });

        swipe4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                if (!etNoAncak4.getText().toString().isEmpty()) {
                    if (spMataAngin4.getSelectedItemPosition() > 0) {
                        model.setPointer(121);
                        saveAncak();
                    } else {
                        Toast.makeText(Ancak.this,
                                "Anda belum memilih arah mata angin",
                                Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(Ancak.this,
                            "Silakan isi nomor ancak terlebih dahulu",
                            Toast.LENGTH_LONG).show();
                }

            }
        });

        swipe5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                if (!etNoAncak5.getText().toString().isEmpty()) {
                    if (spMataAngin5.getSelectedItemPosition() > 0) {
                        model.setPointer(161);
                        saveAncak();
                    } else {
                        Toast.makeText(Ancak.this,
                                "Anda belum memilih arah mata angin",
                                Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(Ancak.this,
                            "Silakan isi nomor ancak terlebih dahulu",
                            Toast.LENGTH_LONG).show();
                }

            }
        });

        swipe6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                if (!etNoAncak6.getText().toString().isEmpty()) {
                    if (spMataAngin6.getSelectedItemPosition() > 0) {
                        model.setPointer(201);
                        saveAncak();
                    } else {
                        Toast.makeText(Ancak.this,
                                "Anda belum memilih arah mata angin",
                                Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(Ancak.this,
                            "Silakan isi nomor ancak terlebih dahulu",
                            Toast.LENGTH_LONG).show();
                }

            }
        });

        swipe7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                if (!etNoAncak7.getText().toString().isEmpty()) {
                    if (spMataAngin7.getSelectedItemPosition() > 0) {
                        model.setPointer(241);
                        saveAncak();
                    } else {
                        Toast.makeText(Ancak.this,
                                "Anda belum memilih arah mata angin",
                                Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(Ancak.this,
                            "Silakan isi nomor ancak terlebih dahulu",
                            Toast.LENGTH_LONG).show();
                }

            }
        });

        swipe8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                if (!etNoAncak8.getText().toString().isEmpty()) {
                    if (spMataAngin8.getSelectedItemPosition() > 0) {
                        model.setPointer(281);
                        saveAncak();
                    } else {
                        Toast.makeText(Ancak.this,
                                "Anda belum memilih arah mata angin",
                                Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(Ancak.this,
                            "Silakan isi nomor ancak terlebih dahulu",
                            Toast.LENGTH_LONG).show();
                }

            }
        });

        swipe9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                if (!etNoAncak9.getText().toString().isEmpty()) {
                    if (spMataAngin9.getSelectedItemPosition() > 0) {
                        model.setPointer(321);
                        saveAncak();
                    } else {
                        Toast.makeText(Ancak.this,
                                "Anda belum memilih arah mata angin",
                                Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(Ancak.this,
                            "Silakan isi nomor ancak terlebih dahulu",
                            Toast.LENGTH_LONG).show();
                }

            }
        });

        swipe10.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                if (!etNoAncak10.getText().toString().isEmpty()) {
                    if (spMataAngin10.getSelectedItemPosition() > 0) {
                        model.setPointer(361);
                        saveAncak();
                    } else {
                        Toast.makeText(Ancak.this,
                                "Anda belum memilih arah mata angin",
                                Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(Ancak.this,
                            "Silakan isi nomor ancak terlebih dahulu",
                            Toast.LENGTH_LONG).show();
                }

            }
        });

        new readRecord().execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_ancak, menu);
        return true;
    }

    private void saveAncak() {
        nomorAncak[0] = etNoAncak1.getText().toString();
        nomorAncak[1] = etNoAncak2.getText().toString();
        nomorAncak[2] = etNoAncak3.getText().toString();
        nomorAncak[3] = etNoAncak4.getText().toString();
        nomorAncak[4] = etNoAncak5.getText().toString();
        nomorAncak[5] = etNoAncak6.getText().toString();
        nomorAncak[6] = etNoAncak7.getText().toString();
        nomorAncak[7] = etNoAncak8.getText().toString();
        nomorAncak[8] = etNoAncak9.getText().toString();
        nomorAncak[9] = etNoAncak10.getText().toString();
        nomorJalur[0] = etNoJalur1.getText().toString();
        nomorJalur[1] = etNoJalur2.getText().toString();
        nomorJalur[2] = etNoJalur3.getText().toString();
        nomorJalur[3] = etNoJalur4.getText().toString();
        nomorJalur[4] = etNoJalur5.getText().toString();
        nomorJalur[5] = etNoJalur6.getText().toString();
        nomorJalur[6] = etNoJalur7.getText().toString();
        nomorJalur[7] = etNoJalur8.getText().toString();
        nomorJalur[8] = etNoJalur9.getText().toString();
        nomorJalur[9] = etNoJalur10.getText().toString();
        namaAncak[0] = etNamaAncak1.getText().toString();
        namaAncak[1] = etNamaAncak2.getText().toString();
        namaAncak[2] = etNamaAncak3.getText().toString();
        namaAncak[3] = etNamaAncak4.getText().toString();
        namaAncak[4] = etNamaAncak5.getText().toString();
        namaAncak[5] = etNamaAncak6.getText().toString();
        namaAncak[6] = etNamaAncak7.getText().toString();
        namaAncak[7] = etNamaAncak8.getText().toString();
        namaAncak[8] = etNamaAncak9.getText().toString();
        namaAncak[9] = etNamaAncak10.getText().toString();

        if (cbCek1.isChecked())
            cekAncak[0] = "-1";
        else
            cekAncak[0] = "0";

        if (cbCek2.isChecked())
            cekAncak[1] = "-1";
        else
            cekAncak[1] = "0";

        if (cbCek3.isChecked())
            cekAncak[2] = "-1";
        else
            cekAncak[2] = "0";

        if (cbCek4.isChecked())
            cekAncak[3] = "-1";
        else
            cekAncak[3] = "0";

        if (cbCek5.isChecked())
            cekAncak[4] = "-1";
        else
            cekAncak[4] = "0";

        if (cbCek6.isChecked())
            cekAncak[5] = "-1";
        else
            cekAncak[5] = "0";

        if (cbCek7.isChecked())
            cekAncak[6] = "-1";
        else
            cekAncak[6] = "0";

        if (cbCek8.isChecked())
            cekAncak[7] = "-1";
        else
            cekAncak[7] = "0";

        if (cbCek9.isChecked())
            cekAncak[8] = "-1";
        else
            cekAncak[8] = "0";

        if (cbCek10.isChecked())
            cekAncak[9] = "-1";
        else
            cekAncak[9] = "0";

        try {
            model.saveAncak(nomorAncak, nomorJalur, namaAncak, mataAngin, cekAncak);
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
        Intent pokok = new Intent(this, Pokok.class);
        pokok.putExtra("object", model);
        startActivity(pokok);
        finish();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch(adapterView.getId()){
            case R.id.spMataAngin1:
                mataAngin[0] = (String) spMataAngin1.getItemAtPosition(i);
                break;
            case R.id.spMataAngin2:
                mataAngin[1] = (String) spMataAngin2.getItemAtPosition(i);
                break;
            case R.id.spMataAngin3:
                mataAngin[2] = (String) spMataAngin3.getItemAtPosition(i);
                break;
            case R.id.spMataAngin4:
                mataAngin[3] = (String) spMataAngin4.getItemAtPosition(i);
                break;
            case R.id.spMataAngin5:
                mataAngin[4] = (String) spMataAngin5.getItemAtPosition(i);
                break;
            case R.id.spMataAngin6:
                mataAngin[5] = (String) spMataAngin6.getItemAtPosition(i);
                break;
            case R.id.spMataAngin7:
                mataAngin[6] = (String) spMataAngin7.getItemAtPosition(i);
                break;
            case R.id.spMataAngin8:
                mataAngin[7] = (String) spMataAngin8.getItemAtPosition(i);
                break;
            case R.id.spMataAngin9:
                mataAngin[8] = (String) spMataAngin9.getItemAtPosition(i);
                break;
            case R.id.spMataAngin10:
                mataAngin[9] = (String) spMataAngin10.getItemAtPosition(i);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private class readRecord extends AsyncTask<Void, Void, Void> {
        ProgressDialog progressBar;

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();
            progressBar = new ProgressDialog(Ancak.this);
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
            outerloop:
            for (int i = 0; i < 10; i++) {
                try {
                    nomorAncak[i] = model.readNomorAncak(i + 1);
                    nomorJalur[i] = model.readNomorJalur(i + 1);
                    namaAncak[i] = model.readNamaAncak(i + 1);
                    mataAngin[i] = model.readMataAngin(i + 1);
                    cekAncak[i] = model.readCekAncak(i + 1);
                    if (nomorAncak[i].equals("") && namaAncak[i].equals("")) {
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

            ArrayAdapter myAdap;
            int spinnerPosition;

            etNoAncak1.setText(nomorAncak[0]);
            etNoJalur1.setText(nomorJalur[0]);
            etNamaAncak1.setText(namaAncak[0]);
            etNoAncak2.setText(nomorAncak[1]);
            etNoJalur2.setText(nomorJalur[1]);
            etNamaAncak2.setText(namaAncak[1]);
            etNoAncak3.setText(nomorAncak[2]);
            etNoJalur3.setText(nomorJalur[2]);
            etNamaAncak3.setText(namaAncak[2]);
            etNoAncak4.setText(nomorAncak[3]);
            etNoJalur4.setText(nomorJalur[3]);
            etNamaAncak4.setText(namaAncak[3]);
            etNoAncak5.setText(nomorAncak[4]);
            etNoJalur5.setText(nomorJalur[4]);
            etNamaAncak5.setText(namaAncak[4]);
            etNoAncak6.setText(nomorAncak[5]);
            etNoJalur6.setText(nomorJalur[5]);
            etNamaAncak6.setText(namaAncak[5]);
            etNoAncak7.setText(nomorAncak[6]);
            etNoJalur7.setText(nomorJalur[6]);
            etNamaAncak7.setText(namaAncak[6]);
            etNoAncak8.setText(nomorAncak[7]);
            etNoJalur8.setText(nomorJalur[7]);
            etNamaAncak8.setText(namaAncak[7]);
            etNoAncak9.setText(nomorAncak[8]);
            etNoJalur9.setText(nomorJalur[8]);
            etNamaAncak9.setText(namaAncak[8]);
            etNoAncak10.setText(nomorAncak[9]);
            etNoJalur10.setText(nomorJalur[9]);
            etNamaAncak10.setText(namaAncak[9]);

            myAdap = (ArrayAdapter) spMataAngin1.getAdapter();
            spinnerPosition = myAdap.getPosition(mataAngin[0]);
            spMataAngin1.setSelection(spinnerPosition);

            myAdap = (ArrayAdapter) spMataAngin2.getAdapter();
            spinnerPosition = myAdap.getPosition(mataAngin[1]);
            spMataAngin2.setSelection(spinnerPosition);

            myAdap = (ArrayAdapter) spMataAngin3.getAdapter();
            spinnerPosition = myAdap.getPosition(mataAngin[2]);
            spMataAngin3.setSelection(spinnerPosition);

            myAdap = (ArrayAdapter) spMataAngin4.getAdapter();
            spinnerPosition = myAdap.getPosition(mataAngin[3]);
            spMataAngin4.setSelection(spinnerPosition);

            myAdap = (ArrayAdapter) spMataAngin5.getAdapter();
            spinnerPosition = myAdap.getPosition(mataAngin[4]);
            spMataAngin5.setSelection(spinnerPosition);

            myAdap = (ArrayAdapter) spMataAngin6.getAdapter();
            spinnerPosition = myAdap.getPosition(mataAngin[5]);
            spMataAngin6.setSelection(spinnerPosition);

            myAdap = (ArrayAdapter) spMataAngin7.getAdapter();
            spinnerPosition = myAdap.getPosition(mataAngin[6]);
            spMataAngin7.setSelection(spinnerPosition);

            myAdap = (ArrayAdapter) spMataAngin8.getAdapter();
            spinnerPosition = myAdap.getPosition(mataAngin[7]);
            spMataAngin8.setSelection(spinnerPosition);

            myAdap = (ArrayAdapter) spMataAngin9.getAdapter();
            spinnerPosition = myAdap.getPosition(mataAngin[8]);
            spMataAngin9.setSelection(spinnerPosition);

            myAdap = (ArrayAdapter) spMataAngin10.getAdapter();
            spinnerPosition = myAdap.getPosition(mataAngin[9]);
            spMataAngin10.setSelection(spinnerPosition);

            //int cekSize = cekAncak.length;

            //Toast.makeText(Ancak.this, cekAncak[0] + " " + cekAncak[1] + " " + cekAncak[2] + " " + cekAncak[3] + " " + cekAncak[4] + " " + cekAncak[5] + " " + cekAncak[6] + " " + cekAncak[7] + " " + cekAncak[8] + " " + cekAncak[9], Toast.LENGTH_LONG).show();

            if (cekAncak[0] != null) {
                if (cekAncak[0].equals("-1"))
                    cbCek1.setChecked(true);
                else
                    cbCek1.setChecked(false);
            }

            if (cekAncak[1] != null) {
                if (cekAncak[1].equals("-1"))
                    cbCek2.setChecked(true);
                else
                    cbCek2.setChecked(false);
            }

            if (cekAncak[2] != null) {
                if (cekAncak[2].equals("-1"))
                    cbCek3.setChecked(true);
                else
                    cbCek3.setChecked(false);
            }

            if (cekAncak[3] != null) {
                if (cekAncak[3].equals("-1"))
                    cbCek4.setChecked(true);
                else
                    cbCek4.setChecked(false);
            }

            if (cekAncak[4] != null) {
                if (cekAncak[4].equals("-1"))
                    cbCek5.setChecked(true);
                else
                    cbCek5.setChecked(false);
            }

            if (cekAncak[5] != null) {
                if (cekAncak[5].equals("-1"))
                    cbCek6.setChecked(true);
                else
                    cbCek6.setChecked(false);
            }

            if (cekAncak[6] != null) {
                if (cekAncak[6].equals("-1"))
                    cbCek7.setChecked(true);
                else
                    cbCek7.setChecked(false);
            }

            if (cekAncak[7] != null) {
                if (cekAncak[7].equals("-1"))
                    cbCek8.setChecked(true);
                else
                    cbCek8.setChecked(false);
            }

            if (cekAncak[8] != null) {
                if (cekAncak[8].equals("-1"))
                    cbCek9.setChecked(true);
                else
                    cbCek9.setChecked(false);
            }

            if (cekAncak[9] != null) {
                if (cekAncak[9].equals("-1"))
                    cbCek10.setChecked(true);
                else
                    cbCek10.setChecked(false);
            }
        }
    }

    @Override
    public boolean onDown(MotionEvent e) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                           float velocityY) {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
                            float distanceY) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        // TODO Auto-generated method stub
        return false;
    }
}

