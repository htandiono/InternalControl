package com.ic;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.text.ParseException;

import jxl.read.biff.BiffException;

public class Mainmenu extends Activity implements OnClickListener {

    private Button newFile, loadFile, mainMenu;
    private Model model;
    private String filepath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Intent modul1 = getIntent();
        model = (Model) modul1.getSerializableExtra("object");
        newFile = (Button) findViewById(R.id.btnNewFile);
        loadFile = (Button) findViewById(R.id.btnLoadFile);
        mainMenu = (Button) findViewById(R.id.btnMainMenu);
        newFile.setOnClickListener(this);
        loadFile.setOnClickListener(this);
        mainMenu.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_menu, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.btnNewFile:
                Intent newfile = new Intent(this, Modul.class);
                newfile.putExtra("object", model);
                startActivity(newfile);
                break;
            case R.id.btnLoadFile:
                Intent loadfile = new Intent(this, FileDialog.class);
                loadfile.putExtra(FileDialog.START_PATH, Environment
                        .getExternalStorageDirectory().getAbsolutePath());
                startActivityForResult(loadfile, 0);
                break;
            case R.id.btnMainMenu:
                finish();
                break;
        }
    }

    @Override
    public synchronized void onActivityResult(int requestCode, int resultCode,
                                              Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == 0) {
                filepath = data.getStringExtra(FileDialog.RESULT_PATH);
                String filename = filename(filepath);
                int code = filename.indexOf("-");
                String modulcode = filename.substring(0, code);
                if (!modulcode.equals("FLD") || !modulcode.equals("MTP")
                        || !modulcode.equals("TPH") || !modulcode.equals("FRT")) {
                    boolean openfile = false;
                    try {
                        if (modulcode.equals("FLD")) {
                            openfile = model.openFile(filepath);
                        } else if (modulcode.equals("MTP")) {
                            openfile = model.openFileMTP(filepath);
                        } else if (modulcode.equals("TPH")) {
                            openfile = model.openFileTPH(filepath);
                        } else if (modulcode.equals("FRT")) {
                            openfile = model.openFileFRT(filepath);
                        }

                    } catch (BiffException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (ParseException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    if (openfile) {
                        if (modulcode.equals("FLD")) {
                            Intent ancak = new Intent(this, Ancak.class);
                            ancak.putExtra("object", model);
                            startActivity(ancak);
                        } else if (modulcode.equals("MTP")) {
                            Intent ancak = new Intent(this, TPH.class);
                            ancak.putExtra("object", model);
                            startActivity(ancak);
                        } else if (modulcode.equals("TPH")) {
                            Intent buah = new Intent(this, TPHSelection.class);
                            buah.putExtra("object", model);
                            startActivity(buah);
                        } else if (modulcode.equals("FRT")) {
                            Intent pupuk = new Intent(this, Karyawan.class);
                            pupuk.putExtra("object", model);
                            startActivity(pupuk);
                        }
                    }
                } else {
                    Toast.makeText(this, "File not supported", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    public String filename(String path) {
        int dot = path.lastIndexOf(".");
        int sep = path.lastIndexOf("/");
        return path.substring(sep + 1, dot);
    }
}
