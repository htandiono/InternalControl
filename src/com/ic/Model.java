package com.ic;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Environment;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Observable;

import jxl.Cell;
import jxl.CellView;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Model extends Observable implements Serializable {
	/**
     *
     */
	private static final long serialVersionUID = 1L;
	private String namaevaluator;
	private String region;
	private String company;
	private String estate;
	private String division;
	private String blockID;
	private Calendar cal;
	private Date date;
	private String rotasipanen;
	private String formNo;
	private int pokok;
	private String[] nomorAncak;
	private String[] nomorJalur;
	private String[] namaAncak;
	private String[] mataAngin;
	private String[] cekAncak;
	private String[] nomorTPH;
	private String[] permanen;
	private String[] tandanpanen;
	private int pokokpointer;
	private boolean next, visited, loadfile;
	private int tphindex;
	private int tandan;
	private int buah;
	private String JenisPupuk;
	private String JenisPupukLain;
	private String ArealAplikasi;
	private String ArealAplikasiLain;
	private String DosisPerPokok;
	private String KarungPecah;
	private String PanenSaatPemupukan;
	private String JumlahPenabur;
	private String JatahPenabur;
	private String JumlahKarung;
	private String SelisihBerat;
	private String WaktuMulai;
	private String WaktuIstirahat;
	private String WaktuSelesai;
	private String JumlahTidakAplikasi;
	private String AlasanTidakAplikasi;
	private String SudahAplikasi1;
	private String SudahAplikasi2;
	private String SudahAplikasi3;
	private String SudahAplikasi4;
	private String SudahAplikasi5;
	private String SudahAplikasi6;
	private String SudahAplikasi7;
	private String SudahAplikasi8;
	private String SudahAplikasi9;
	private String SudahAplikasi10;
	private String KarungKosong;
	private String KarungKosongLain;
	private String KarungDikembalikanKeGudang;
	private String MandorJumlah;
	private String MandorFT;
	private String MandorPT;
	private String AslapJumlah;
	private String AslapFT;
	private String AslapPT;
	private String AskepJumlah;
	private String AskepFT;
	private String AskepPT;
	private String ManagerJumlah;
	private String ManagerFT;
	private String ManagerPT;
	private String Mandor1;
	private String Mandor2;
	private String Mandor3;
	private String Mandor4;
	private String Mandor5;
	private String Mandor6;
	private String Mandor7;
	private String Mandor8;
	private String Mandor9;
	private String Mandor10;
	private String Aslap1;
	private String Aslap2;
	private String Aslap3;
	private String Aslap4;
	private String Aslap5;
	private String Aslap6;
	private String Aslap7;
	private String Aslap8;
	private String Aslap9;
	private String Aslap10;
	private String Rekomendasi;
	private String AlasanBeda;
	private int karyawancounter;
	private int frtpokok;

	Model(String namaevaluator) {
		this.namaevaluator = namaevaluator;
		this.region = null;
		this.company = null;
		this.estate = null;
		this.division = null;
		this.blockID = null;
		this.formNo = null;
		this.cal = Calendar.getInstance();
		this.date = cal.getTime();
		this.pokok = 1;
		this.namaAncak = new String[10];
		this.nomorAncak = new String[10];
		this.mataAngin = new String[10];
		this.nomorTPH = new String[10];
		this.permanen = new String[10];
		this.tandanpanen = new String[10];
		this.pokokpointer = 1;
		this.next = true;
		this.visited = false;
		this.loadfile = false;
		this.tphindex = 1;
		this.tandan = 1;
		this.buah = 1;
		this.JenisPupuk = "";
		this.JenisPupukLain = "";
		this.ArealAplikasi = "";
		this.ArealAplikasiLain = "";
		this.DosisPerPokok = "";
		this.KarungPecah = "";
		this.PanenSaatPemupukan = "";
		this.JumlahPenabur = "";
		this.JatahPenabur = "";
		this.JumlahKarung = "";
		this.SelisihBerat = "";
		this.WaktuMulai = "";
		this.WaktuIstirahat = "";
		this.WaktuSelesai = "";
		this.JumlahTidakAplikasi = "";
		this.AlasanTidakAplikasi = "";
		this.SudahAplikasi1 = "";
		this.SudahAplikasi2 = "";
		this.SudahAplikasi3 = "";
		this.SudahAplikasi4 = "";
		this.SudahAplikasi5 = "";
		this.SudahAplikasi6 = "";
		this.SudahAplikasi7 = "";
		this.SudahAplikasi8 = "";
		this.SudahAplikasi9 = "";
		this.SudahAplikasi10 = "";
		this.KarungKosong = "";
		this.KarungKosongLain = "";
		this.KarungDikembalikanKeGudang = "";
		this.MandorJumlah = "";
		this.MandorFT = "";
		this.MandorPT = "";
		this.AslapJumlah = "";
		this.AslapFT = "";
		this.AslapPT = "";
		this.AskepJumlah = "";
		this.AskepFT = "";
		this.AskepPT = "";
		this.ManagerJumlah = "";
		this.ManagerFT = "";
		this.ManagerPT = "";
		this.Mandor1 = "";
		this.Mandor2 = "";
		this.Mandor3 = "";
		this.Mandor4 = "";
		this.Mandor5 = "";
		this.Mandor6 = "";
		this.Mandor7 = "";
		this.Mandor8 = "";
		this.Mandor9 = "";
		this.Mandor10 = "";
		this.Aslap1 = "";
		this.Aslap2 = "";
		this.Aslap3 = "";
		this.Aslap4 = "";
		this.Aslap5 = "";
		this.Aslap6 = "";
		this.Aslap7 = "";
		this.Aslap8 = "";
		this.Aslap9 = "";
		this.Aslap10 = "";
		this.Rekomendasi = "";
		this.AlasanBeda = "";
		this.karyawancounter = 1;
		this.frtpokok = 1;
	}

	public String getEvaluator() {
		return namaevaluator;
	}

	@SuppressLint("NewApi")
	public boolean setEvaluator(String namaevaluator) {
		if (!namaevaluator.isEmpty()) {
			this.namaevaluator = namaevaluator;
			return true;
		}
		return false;
	}

	public String getNamaevaluator() {
		return namaevaluator;
	}

	public String getRegion() {
		return region;
	}

	public boolean setRegion(String region) {
		this.region = region;
		return true;
	}

	public String getCompany() {
		return company;
	}

	public boolean setCompany(String company) {
		this.company = company;
		return true;
	}

	public String getEstate() {
		return estate;
	}

	public boolean setEstate(String estate) {
		this.estate = estate;
		return true;
	}

	public String getDivision() {
		return division;
	}

	public boolean setDivision(String division) {
		this.division = division;
		return true;
	}

	public String getBlockID() {
		return blockID;
	}

	public boolean setBlockID(String blockID) {
		this.blockID = blockID;
		return true;
	}

	public String getRotasiPanen() {
		return rotasipanen;
	}

	public boolean setRotasiPanen(String rotasipanen) {
		this.rotasipanen = rotasipanen;
		return true;
	}

	@SuppressLint("SimpleDateFormat")
	public String getTanggal() throws ParseException {
		String formateddate = new SimpleDateFormat("dd/MM/yy").format(date);
		return formateddate;
	}

	@SuppressLint("SimpleDateFormat")
	public boolean setTanggal(String tanggal) throws ParseException {
		date = new SimpleDateFormat("dd/MM/yy").parse(tanggal);
		return true;
	}

	@SuppressLint("SimpleDateFormat")
	public boolean setFormNo(String header) throws ParseException {
		String formateddate = new SimpleDateFormat("yyMMdd").format(date);
		if (header.equals("FRT")) {
			formNo = header + "-" + formateddate + "-" + estate + "-"
					+ namaevaluator;
			return true;
		} else {
			formNo = header + "-" + formateddate + "-" + estate + "-" + blockID
					+ "-" + namaevaluator;
			return true;
		}
	}

	public boolean setFormNo(boolean edit, String formNo) {
		this.formNo = formNo;
		return true;
	}

	public String getFormNo() {
		return formNo;
	}

	public void savePanenInformation() throws IOException, WriteException,
			ParseException {
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		WorkbookSettings wbSettings = new WorkbookSettings();
		wbSettings.setLocale(new Locale("en", "EN"));
		WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
		WritableSheet sheet = workbook.createSheet("PanenInformation", 0);
		WritableCellFormat times;
		WritableCellFormat timesBold;
		WritableFont times10pt = new WritableFont(WritableFont.TIMES, 12);
		times = new WritableCellFormat(times10pt);
		times.setWrap(false);
		WritableFont times10ptBold = new WritableFont(WritableFont.TIMES, 14,
				WritableFont.BOLD);
		timesBold = new WritableCellFormat(times10ptBold);
		timesBold.setWrap(false);
		CellView cv = new CellView();
		cv.setFormat(timesBold);
		cv.setFormat(times);
		cv.setAutosize(true);
		List<String> header = new ArrayList<String>();
		header.add("FormNo");
		header.add("Region");
		header.add("Company");
		header.add("Estate");
		header.add("Division");
		header.add("BlockID");
		header.add("Tanggal");
		header.add("RotasiPanen");
		header.add("Evaluator");
		for (int i = 0; i < header.size(); i++) {
			Label label = new Label(i, 0, header.get(i), timesBold);
			sheet.addCell(label);
		}
		List<String> content = new ArrayList<String>();
		content.add(getFormNo());
		content.add(getRegion());
		content.add(getCompany());
		content.add(getEstate());
		content.add(getDivision());
		content.add(getBlockID());
		content.add(getTanggal());
		content.add(getRotasiPanen());
		content.add(getNamaevaluator());
		for (int i = 0; i < content.size(); i++) {
			Label label = new Label(i, 1, content.get(i), times);
			sheet.addCell(label);
		}
		workbook.write();
		workbook.close();
	}

	public void saveFRTMain() throws IOException, WriteException,
			ParseException {
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory + dirName);
			file = new File(dir, formNo + ".xls");
		}
		WorkbookSettings wbSettings = new WorkbookSettings();
		wbSettings.setLocale(new Locale("en", "EN"));
		WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
		WritableSheet sheet = workbook.createSheet("FRTMain", 0);
		WritableCellFormat times;
		WritableCellFormat timesBold;
		WritableFont times10pt = new WritableFont(WritableFont.TIMES, 12);
		times = new WritableCellFormat(times10pt);
		times.setWrap(false);
		WritableFont times10ptBold = new WritableFont(WritableFont.TIMES, 14,
				WritableFont.BOLD);
		timesBold = new WritableCellFormat(times10ptBold);
		timesBold.setWrap(false);
		CellView cv = new CellView();
		cv.setFormat(timesBold);
		cv.setFormat(times);
		cv.setAutosize(true);
		List<String> header = new ArrayList<String>();
		header.add("FormNo");
		header.add("Region");
		header.add("Company");
		header.add("Estate");
		header.add("Divisi");
		header.add("JenisPupuk");
		header.add("JenisPupukLain");
		header.add("ArealAplikasi");
		header.add("ArealAplikasiLain");
		header.add("DosisPerPokok");
		header.add("KarungPecah");
		header.add("PanenSaatPemupukan");
		header.add("JumlahPenabur");
		header.add("JatahPenabur");
		header.add("JumlahKarung");
		header.add("SelisihBerat");
		header.add("WaktuMulai");
		header.add("WaktuIstirahat");
		header.add("WaktuSelesai");
		header.add("JumlahTidakAplikasi");
		header.add("AlasanTidakAplikasi");
		header.add("SudahAplikasi1");
		header.add("SudahAplikasi2");
		header.add("SudahAplikasi3");
		header.add("SudahAplikasi4");
		header.add("SudahAplikasi5");
		header.add("SudahAplikasi6");
		header.add("SudahAplikasi7");
		header.add("SudahAplikasi8");
		header.add("SudahAplikasi9");
		header.add("SudahAplikasi10");
		header.add("KarungKosong");
		header.add("KarungKosongLain");
		header.add("KarungDikembalikanKeGudang");
		header.add("MandorJumlah");
		header.add("MandorFT");
		header.add("MandorPT");
		header.add("AslapJumlah");
		header.add("AslapFT");
		header.add("AslapPT");
		header.add("AskepJumlah");
		header.add("AskepFT");
		header.add("AskepPT");
		header.add("ManagerJumlah");
		header.add("ManagerFT");
		header.add("ManagerPT");
		header.add("Mandor1");
		header.add("Mandor2");
		header.add("Mandor3");
		header.add("Mandor4");
		header.add("Mandor5");
		header.add("Mandor6");
		header.add("Mandor7");
		header.add("Mandor8");
		header.add("Mandor9");
		header.add("Mandor10");
		header.add("Aslap1");
		header.add("Aslap2");
		header.add("Aslap3");
		header.add("Aslap4");
		header.add("Aslap5");
		header.add("Aslap6");
		header.add("Aslap7");
		header.add("Aslap8");
		header.add("Aslap9");
		header.add("Aslap10");
		header.add("Rekomendasi");
		header.add("AlasanBeda");
		for (int i = 0; i < header.size(); i++) {
			Label label = new Label(i, 0, header.get(i), timesBold);
			sheet.addCell(label);
		}
		List<String> content = new ArrayList<String>();
		content.add(getFormNo());
		content.add(getRegion());
		content.add(getCompany());
		content.add(getEstate());
		content.add(getDivision());
		content.add(getJenisPupuk());
		content.add(getJenisPupukLain());
		content.add(getArealAplikasi());
		content.add(getArealAplikasiLain());
		content.add(getDosisPerPokok());
		content.add(getKarungPecah());
		content.add(getPanenSaatPemupukan());
		content.add(getJumlahPenabur());
		content.add(getJatahPenabur());
		content.add(getJumlahKarung());
		content.add(getSelisihBerat());
		content.add(getWaktuMulai());
		content.add(getWaktuIstirahat());
		content.add(getWaktuSelesai());
		content.add(getJumlahTidakAplikasi());
		content.add(getAlasanTidakAplikasi());
		content.add(getSudahAplikasi1());
		content.add(getSudahAplikasi2());
		content.add(getSudahAplikasi3());
		content.add(getSudahAplikasi4());
		content.add(getSudahAplikasi5());
		content.add(getSudahAplikasi6());
		content.add(getSudahAplikasi7());
		content.add(getSudahAplikasi8());
		content.add(getSudahAplikasi9());
		content.add(getSudahAplikasi10());
		content.add(getKarungKosong());
		content.add(getKarungKosongLain());
		content.add(getKarungDikembalikanKeGudang());
		content.add(getMandorJumlah());
		content.add(getMandorFT());
		content.add(getMandorPT());
		content.add(getAslapJumlah());
		content.add(getAslapFT());
		content.add(getAslapPT());
		content.add(getAskepJumlah());
		content.add(getAskepFT());
		content.add(getAskepPT());
		content.add(getManagerJumlah());
		content.add(getManagerFT());
		content.add(getManagerPT());
		content.add(getMandor1());
		content.add(getMandor2());
		content.add(getMandor3());
		content.add(getMandor4());
		content.add(getMandor5());
		content.add(getMandor6());
		content.add(getMandor7());
		content.add(getMandor8());
		content.add(getMandor9());
		content.add(getMandor10());
		content.add(getAslap1());
		content.add(getAslap2());
		content.add(getAslap3());
		content.add(getAslap4());
		content.add(getAslap5());
		content.add(getAslap6());
		content.add(getAslap7());
		content.add(getAslap8());
		content.add(getAslap9());
		content.add(getAslap10());
		content.add(getRekomendasi());
		content.add(getAlasanBeda());
		for (int i = 0; i < content.size(); i++) {
			Label label = new Label(i, 1, content.get(i), times);
			sheet.addCell(label);
		}
		workbook.write();
		workbook.close();
	}

	public void saveMPTHInformation() throws IOException, WriteException,
			ParseException {
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		WorkbookSettings wbSettings = new WorkbookSettings();
		wbSettings.setLocale(new Locale("en", "EN"));
		WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
		WritableSheet sheet = workbook.createSheet("MPTHInformation", 0);
		WritableCellFormat times;
		WritableCellFormat timesBold;
		WritableFont times10pt = new WritableFont(WritableFont.TIMES, 12);
		times = new WritableCellFormat(times10pt);
		times.setWrap(false);
		WritableFont times10ptBold = new WritableFont(WritableFont.TIMES, 14,
				WritableFont.BOLD);
		timesBold = new WritableCellFormat(times10ptBold);
		timesBold.setWrap(false);
		CellView cv = new CellView();
		cv.setFormat(timesBold);
		cv.setFormat(times);
		cv.setAutosize(true);
		List<String> header = new ArrayList<String>();
		header.add("FormNo");
		header.add("Region");
		header.add("Company");
		header.add("Estate");
		header.add("Division");
		header.add("BlockID");
		header.add("Tanggal");
		header.add("Evaluator");
		for (int i = 0; i < header.size(); i++) {
			Label label = new Label(i, 0, header.get(i), timesBold);
			sheet.addCell(label);
		}
		List<String> content = new ArrayList<String>();
		content.add(getFormNo());
		content.add(getRegion());
		content.add(getCompany());
		content.add(getEstate());
		content.add(getDivision());
		content.add(getBlockID());
		content.add(getTanggal());
		content.add(getNamaevaluator());
		for (int i = 0; i < content.size(); i++) {
			Label label = new Label(i, 1, content.get(i), times);
			sheet.addCell(label);
		}
		workbook.write();
		workbook.close();
	}

	public void saveTPHInformation() throws IOException, WriteException,
			ParseException {
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		WorkbookSettings wbSettings = new WorkbookSettings();
		wbSettings.setLocale(new Locale("en", "EN"));
		WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
		WritableSheet sheet = workbook.createSheet("TPHInformation", 0);
		WritableCellFormat times;
		WritableCellFormat timesBold;
		WritableFont times10pt = new WritableFont(WritableFont.TIMES, 12);
		times = new WritableCellFormat(times10pt);
		times.setWrap(false);
		WritableFont times10ptBold = new WritableFont(WritableFont.TIMES, 14,
				WritableFont.BOLD);
		timesBold = new WritableCellFormat(times10ptBold);
		timesBold.setWrap(false);
		CellView cv = new CellView();
		cv.setFormat(timesBold);
		cv.setFormat(times);
		cv.setAutosize(true);
		List<String> header = new ArrayList<String>();
		header.add("FormNo");
		header.add("Region");
		header.add("Company");
		header.add("Estate");
		header.add("Division");
		header.add("BlockID");
		header.add("Tanggal");
		header.add("RotasiPanen");
		header.add("Evaluator");
		for (int i = 0; i < header.size(); i++) {
			Label label = new Label(i, 0, header.get(i), timesBold);
			sheet.addCell(label);
		}
		List<String> content = new ArrayList<String>();
		content.add(getFormNo());
		content.add(getRegion());
		content.add(getCompany());
		content.add(getEstate());
		content.add(getDivision());
		content.add(getBlockID());
		content.add(getTanggal());
		content.add(getRotasiPanen());
		content.add(getNamaevaluator());
		for (int i = 0; i < content.size(); i++) {
			Label label = new Label(i, 1, content.get(i), times);
			sheet.addCell(label);
		}
		workbook.write();
		workbook.close();
	}

	public String getPokok() {
		return "" + pokok;
	}

	public boolean storePokok(String NoPokok, String Ancak, String Abnormality,
			String NoB, String BM, String LFB, String Pruning, String CPirW,
			String CPirR, String CPirO, String CPirT, String CFS, String WOPSPir,
			String WOPSFS, String WOPSPP, String CRA_R, String BSPir,
			String BBMPir, String BBKPir, String BSPel, String BBMPel,
			String BBKPel, String BSPP, String BBMPP, String BBKPP,
			String BSTTA, String BBTTA, String BSTTS, String BBTTS,
			String BSTTK, String BBTTK, String BSTTO, String BBTTO,
			String BSTTP, String BBTTP, String BSTTT, String BBTTT,
			String BSTDH, String BBTDH, String BSTDS, String BBTDS,
			String BSTDK, String BBTDK, String BSTDO, String BBTDO,
			String BSTDP, String BBTDP, String BSTDT, String BBTDT,
            String TPH, String TPHweeds, String TPHraking, String TPHalas,
            String BSTPH, String BBMTPH, String BBKTPH,
            String segarTPH, String busukTPH, String restanTPH,
			String Foto1, String Foto2, String Time, String TimeU,
			String extraNote, String cekAbnormalitas, String cekNoB,
			String cekBM, String cekLFB, String cekPruning, String cekCPir,
			String cekFS, String cekWOPS, String cekAkses, String cekBr,
			String cekTT, String cekTD, String cekTPH) throws BiffException, WriteException,
			IOException {
		createHeader();
		if (NoPokok.equals("1") && !visited && !loadfile) {
			reserveRows();
			visited = true;
		}
		String CekNo = formNo + "." + Ancak;
		String PID = CekNo + "." + pokok;
		List<String> content = new ArrayList<String>();
		content.add(PID);
		content.add(CekNo);
		content.add(NoPokok);
		content.add(Abnormality);
		content.add(NoB);
		content.add(BM);
		content.add(LFB);
		content.add(Pruning);
		content.add(CPirW);
		content.add(CPirR);
		content.add(CPirO);
		content.add(CPirT);
		content.add(CFS);
		content.add(WOPSPir);
		content.add(WOPSFS);
		content.add(WOPSPP);
		content.add(CRA_R);
		content.add(BSPir);
		content.add(BBMPir);
		content.add(BBKPir);
		content.add(BSPel);
		content.add(BBMPel);
		content.add(BBKPel);
		content.add(BSPP);
		content.add(BBMPP);
		content.add(BBKPP);
		content.add(BSTTA);
		content.add(BBTTA);
		content.add(BSTTS);
		content.add(BBTTS);
		content.add(BSTTK);
		content.add(BBTTK);
		content.add(BSTTO);
		content.add(BBTTO);
		content.add(BSTTP);
		content.add(BBTTP);
		content.add(BSTTT);
		content.add(BBTTT);
		content.add(BSTDH);
		content.add(BBTDH);
		content.add(BSTDS);
		content.add(BBTDS);
		content.add(BSTDK);
		content.add(BBTDK);
		content.add(BSTDO);
		content.add(BBTDO);
		content.add(BSTDP);
		content.add(BBTDP);
		content.add(BSTDT);
		content.add(BBTDT);
        content.add(TPH);
        content.add(TPHweeds);
        content.add(TPHraking);
        content.add(TPHalas);
        content.add(BSTPH);
        content.add(BBMTPH);
        content.add(BBKTPH);
        content.add(segarTPH);
        content.add(busukTPH);
        content.add(restanTPH);
		content.add(extraNote);
		content.add(cekAbnormalitas);
		content.add(cekNoB);
		content.add(cekBM);
		content.add(cekLFB);
		content.add(cekPruning);
		content.add(cekCPir);
		content.add(cekFS);
		content.add(cekWOPS);
		content.add(cekAkses);
		content.add(cekBr);
		content.add(cekTT);
		content.add(cekTD);
        content.add(cekTPH);
		content.add(Foto1);
		content.add(Foto2);
		content.add(Time);
		content.add(TimeU);
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		Workbook workbook = Workbook.getWorkbook(file);
		String[] Sheets = workbook.getSheetNames();
		boolean headerFound = false;
		for (int i = 0; i < Sheets.length; i++) {
			if (Sheets[i].equalsIgnoreCase("PanenDetails"))
				headerFound = true;
		}
		if (headerFound) {
			WritableWorkbook edit = Workbook.createWorkbook(file, workbook);
			WritableSheet sheet = edit.getSheet(2);
			WritableCellFormat times = null;
			WritableCellFormat timesBold = null;
			WritableFont times10pt = new WritableFont(WritableFont.TIMES, 12);
			times = new WritableCellFormat(times10pt);
			times.setWrap(false);
			WritableFont times10ptBold = new WritableFont(WritableFont.TIMES,
					14, WritableFont.BOLD);
			timesBold = new WritableCellFormat(times10ptBold);
			timesBold.setWrap(false);
			CellView cv = new CellView();
			cv.setFormat(timesBold);
			cv.setFormat(times);
			cv.setAutosize(true);
			for (int i = 0; i < content.size(); i++) {
				Label label = new Label(i, (pokokpointer + pokok) - 1,
						content.get(i), times);
				sheet.addCell(label);
			}
			edit.write();
			edit.close();
			workbook.close();
		}
		if (next) {
			pokok++;
		} else {
			pokok--;
		}
		setChanged();
		notifyObservers();
		return true;
	}

	public boolean nextPokok() {
		next = true;
		return true;
	}

	public boolean prevPokok() {
		next = false;
		return true;
	}

	public boolean reserveRows() throws IOException, BiffException,
			WriteException {
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		Workbook workbook = Workbook.getWorkbook(file);
		WritableWorkbook edit = Workbook.createWorkbook(file, workbook);
		WritableSheet sheet = edit.getSheet(2);
		WritableCellFormat times = null;
		WritableCellFormat timesBold = null;
		WritableFont times10pt = new WritableFont(WritableFont.TIMES, 12);
		times = new WritableCellFormat(times10pt);
		times.setWrap(false);
		WritableFont times10ptBold = new WritableFont(WritableFont.TIMES, 14,
				WritableFont.BOLD);
		timesBold = new WritableCellFormat(times10ptBold);
		timesBold.setWrap(false);
		CellView cv = new CellView();
		cv.setFormat(timesBold);
		cv.setFormat(times);
		cv.setAutosize(true);
		for (int i = 0; i < 43; i++) {
			for (int j = 0; j < 40; j++) {
				Label label = new Label(i, (pokokpointer + j), "", timesBold);
				sheet.addCell(label);
			}
		}
		edit.write();
		edit.close();
		workbook.close();
		return true;
	}

	public boolean createHeader() throws BiffException, IOException,
			WriteException {
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		Workbook workbook = Workbook.getWorkbook(file);
		String[] Sheets = workbook.getSheetNames();
		boolean headerFound = false;
		for (int i = 0; i < Sheets.length; i++) {
			if (Sheets[i].equalsIgnoreCase("PanenDetails"))
				headerFound = true;
		}
		if (!headerFound) {
			WritableWorkbook edit = Workbook.createWorkbook(file, workbook);
			WritableSheet sheet = edit.createSheet("PanenDetails", 2);
			WritableCellFormat times = null;
			WritableCellFormat timesBold = null;
			WritableFont times10pt = new WritableFont(WritableFont.TIMES, 12);
			times = new WritableCellFormat(times10pt);
			times.setWrap(false);
			WritableFont times10ptBold = new WritableFont(WritableFont.TIMES,
					14, WritableFont.BOLD);
			timesBold = new WritableCellFormat(times10ptBold);
			timesBold.setWrap(false);
			CellView cv = new CellView();
			cv.setFormat(timesBold);
			cv.setFormat(times);
			cv.setAutosize(true);
			List<String> header = new ArrayList<String>();
			header.add("PID");
			header.add("CekNo");
			header.add("PalmNo");
			header.add("Abnormality");
			header.add("NoB");
			header.add("BM");
			header.add("LFB");
			header.add("Pruning");
			header.add("CPirW");
			header.add("CPirR");
			header.add("CPirO");
			header.add("CPirT");
			header.add("CFS");
			header.add("WOPSPir");
			header.add("WOPSFS");
			header.add("WOPSPP");
			header.add("CRA_R");
			header.add("BSPir");
			header.add("BBMPir");
			header.add("BBKPir");
			header.add("BSPel");
			header.add("BBMPel");
			header.add("BBKPel");
			header.add("BSPP");
			header.add("BBMPP");
			header.add("BBKPP");
			header.add("BSTTA");
			header.add("BBTTA");
			header.add("BSTTS");
			header.add("BBTTS");
			header.add("BSTTK");
			header.add("BBTTK");
			header.add("BSTTO");
			header.add("BBTTO");
			header.add("BSTTP");
			header.add("BBTTP");
			header.add("BSTTT");
			header.add("BBTTT");
			header.add("BSTDH");
			header.add("BBTDH");
			header.add("BSTDS");
			header.add("BBTDS");
			header.add("BSTDK");
			header.add("BBTDK");
			header.add("BSTDO");
			header.add("BBTDO");
			header.add("BSTDP");
			header.add("BBTDP");
			header.add("BSTDT");
			header.add("BBTDT");
            header.add("TPH");
            header.add("TPHweeds");
            header.add("TPHraking");
            header.add("TPHalas");
            header.add("BSTPH");
            header.add("BBMTPH");
            header.add("BBKTPH");
            header.add("segarTPH");
            header.add("busukTPH");
            header.add("restanTPH");
			header.add("ExtraNote");
			header.add("CekAbnormalitas");
			header.add("CekNoB");
			header.add("CekBM");
			header.add("CekLFB");
			header.add("CekPruning");
			header.add("CekCPir");
			header.add("CekFS");
			header.add("CekWOPS");
			header.add("CekAkses");
			header.add("CekBr");
			header.add("CekTT");
			header.add("CekTD");
            header.add("CekTPH");
			header.add("Foto1");
			header.add("Foto2");
			header.add("Time");
			header.add("TimeU");
			for (int i = 0; i < header.size(); i++) {
				Label label = new Label(i, 0, header.get(i), timesBold);
				sheet.addCell(label);
			}
			edit.write();
			edit.close();
			workbook.close();
		}
		return true;
	}

	public String[] getNamaAncak() {
		return namaAncak;
	}

	public String[] getNomorJalur() {
		return nomorJalur;
	}

	public String[] getNomorAncak() {
		return nomorAncak;
	}

	public String[] getMataAngin() {
		return mataAngin;
	}

	public String[] getNomorTPH() {
		return nomorTPH;
	}

	public String[] getPermanen() {
		return permanen;
	}

	public String[] getTandanPanen() {
		return tandanpanen;
	}

	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	public boolean saveAncak(String[] nomorAncak, String[] nomorJalur,
			String[] namaAncak, String[] mataAngin, String[] cekAncak)
			throws IOException, BiffException, WriteException {
		this.nomorAncak = nomorAncak;
		this.nomorJalur = nomorJalur;
		this.namaAncak = namaAncak;
		this.mataAngin = mataAngin;
		this.cekAncak = cekAncak;
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		WorkbookSettings wbSettings = new WorkbookSettings();
		try {
			wbSettings.setLocale(new Locale("en", "EN"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Workbook copy = Workbook.getWorkbook(file);
		WritableWorkbook workbook = Workbook.createWorkbook(file, copy);
		String[] listSheets = workbook.getSheetNames();
		boolean sheetsFound = false;
		for (int i = 0; i < listSheets.length; i++) {
			if (listSheets[i].equalsIgnoreCase("PanenAncak")) {
				sheetsFound = true;
			}
		}
		WritableSheet sheet = null;
		if (sheetsFound) {
			sheet = workbook.getSheet(1);
		} else {
			sheet = workbook.createSheet("PanenAncak", 1);
		}
		WritableCellFormat times;
		WritableCellFormat timesBold;
		WritableFont times10pt = new WritableFont(WritableFont.TIMES, 12);
		times = new WritableCellFormat(times10pt);
		times.setWrap(false);
		WritableFont times10ptBold = new WritableFont(WritableFont.TIMES, 14,
				WritableFont.BOLD);
		timesBold = new WritableCellFormat(times10ptBold);
		timesBold.setWrap(false);
		CellView cv = new CellView();
		cv.setFormat(timesBold);
		cv.setFormat(times);
		cv.setAutosize(true);
		List<String> header = new ArrayList<String>();
		header.add("CekNo");
		header.add("FormNo");
		header.add("AncakNo");
		header.add("NomorJalur");
		header.add("NamaAncak");
		header.add("N_FU");
		header.add("R_FU");
		header.add("MataAngin");
		header.add("CekAncak");
		for (int i = 0; i < header.size(); i++) {
			Label label = new Label(i, 0, header.get(i), timesBold);
			sheet.addCell(label);
		}
		for (int i = 0; i < 10; i++) {
			if (!nomorAncak[i].isEmpty()) {
				String ancakNo = nomorAncak[i];
				String JalurNo = nomorJalur[i];
				String cekNo = getFormNo() + "." + nomorAncak[i];
				String N_FU = "0";
				String R_FU = "0";
				String namaancakk = namaAncak[i];
				String mataangin = mataAngin[i];
				String cekancak = cekAncak[i];
				List<String> content = new ArrayList<String>();
				content.add(cekNo);
				content.add(getFormNo());
				content.add(ancakNo);
				content.add(JalurNo);
				content.add(namaancakk);
				content.add(N_FU);
				content.add(R_FU);
				content.add(mataangin);
				content.add(cekancak);
				for (int j = 0; j < content.size(); j++) {
					Label label = new Label(j, (i + 1), content.get(j), times);
					sheet.addCell(label);
				}
			}
		}
		workbook.write();
		workbook.close();
		return true;
	}

	public boolean saveTPH(String[] nomorTPH, String[] permanen,
			String[] tandanpanen) throws IOException, BiffException,
			WriteException {
		this.nomorTPH = nomorTPH;
		this.permanen = permanen;
		this.tandanpanen = tandanpanen;
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		WorkbookSettings wbSettings = new WorkbookSettings();
		try {
			wbSettings.setLocale(new Locale("en", "EN"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Workbook copy = Workbook.getWorkbook(file);
		WritableWorkbook workbook = Workbook.createWorkbook(file, copy);
		String[] listSheets = workbook.getSheetNames();
		boolean sheetsFound = false;
		for (int i = 0; i < listSheets.length; i++) {
			if (listSheets[i].equalsIgnoreCase("TPHDetails")) {
				sheetsFound = true;
			}
		}
		WritableSheet sheet = null;
		if (sheetsFound) {
			sheet = workbook.getSheet(1);
		} else {
			sheet = workbook.createSheet("TPHDetails", 1);
		}
		WritableCellFormat times;
		WritableCellFormat timesBold;
		WritableFont times10pt = new WritableFont(WritableFont.TIMES, 12);
		times = new WritableCellFormat(times10pt);
		times.setWrap(false);
		WritableFont times10ptBold = new WritableFont(WritableFont.TIMES, 14,
				WritableFont.BOLD);
		timesBold = new WritableCellFormat(times10ptBold);
		timesBold.setWrap(false);
		CellView cv = new CellView();
		cv.setFormat(timesBold);
		cv.setFormat(times);
		cv.setAutosize(true);
		List<String> header = new ArrayList<String>();
		header.add("CekNo");
		header.add("FormNo");
		header.add("TPHNo");
		header.add("TPHP");
		header.add("nTandan");
		header.add("aSize");
		header.add("aAlas");
		header.add("aClean");
		header.add("bCode1");
		header.add("bCode2");
		header.add("bNoBW1");
		header.add("bNoBW2");
		header.add("bNoBC1");
		header.add("bNoBC2");
		header.add("cMentah");
		header.add("cMengkal");
		header.add("cMasak");
		header.add("cTM");
		header.add("cBJK");
		header.add("dPA");
		header.add("dPB");
		header.add("dPC");
		header.add("dLS");
		header.add("dKast");
		header.add("dPTV");
		header.add("dRestan");
		header.add("dFRatDmg");
		header.add("dORatDmg");
		header.add("eNoFLS");
		header.add("eLFS1");
		header.add("eLFS2");
		header.add("eLFS3");
		header.add("eLFS4");
		header.add("eLFS5");
		header.add("eLFS6");
		header.add("fDirt");
		header.add("gFLf");
		header.add("gRLF");
		header.add("Cek");
		header.add("Photo1");
		header.add("Photo2");
		header.add("Time");
		for (int i = 0; i < header.size(); i++) {
			Label label = new Label(i, 0, header.get(i), timesBold);
			sheet.addCell(label);
		}
		for (int i = 0; i < 10; i++) {
			if (!nomorTPH[i].isEmpty()) {
				String cekNo = getFormNo() + "." + nomorTPH[i];
				List<String> content = new ArrayList<String>();
				content.add(cekNo);
				content.add(getFormNo());
				content.add(nomorTPH[i]);
				content.add(permanen[i]);
				content.add(tandanpanen[i]);
				for (int j = 0; j < content.size(); j++) {
					Label label = new Label(j, (i + 1), content.get(j), times);
					sheet.addCell(label);
				}
			}
		}
		workbook.write();
		workbook.close();
		return true;
	}

	public String readNomorAncak(int index) throws BiffException, IOException {
		String result = "";
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		Workbook workbook = Workbook.getWorkbook(file);
		String[] Sheets = workbook.getSheetNames();
		boolean ancakFound = false;
		for (int i = 0; i < Sheets.length; i++) {
			if (Sheets[i].equalsIgnoreCase("panenancak"))
				ancakFound = true;
		}
		if (ancakFound) {
			Sheet sheet = workbook.getSheet(1);
			if (index < sheet.getRows()) {
				Cell nomorancak = sheet.getCell(2, index);
				result = nomorancak.getContents();
			} else
				result = "";
		}
		workbook.close();
		return result;
	}

	public String readNomorJalur(int index) throws BiffException, IOException {
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		Workbook workbook = Workbook.getWorkbook(file);
		String[] Sheets = workbook.getSheetNames();
		boolean ancakFound = false;
		for (int i = 0; i < Sheets.length; i++) {
			if (Sheets[i].equalsIgnoreCase("PanenAncak"))
				ancakFound = true;
		}
		if (ancakFound) {
			Sheet sheet = workbook.getSheet(1);
			if (index < sheet.getRows()) {
				Cell nomorancak = sheet.getCell(3, index);
				return nomorancak.getContents();
			}
		}
		return "";
	}

	public String readKodeKaryawan(int index) throws BiffException, IOException {
		String result = "";
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		Workbook workbook = Workbook.getWorkbook(file);
		String[] Sheets = workbook.getSheetNames();
		boolean ancakFound = false;
		for (int i = 0; i < Sheets.length; i++) {
			if (Sheets[i].equalsIgnoreCase("FRTKaryawan"))
				ancakFound = true;
		}
		if (ancakFound) {
			Sheet sheet = workbook.getSheet(1);
			if (index < sheet.getRows()) {
				Cell nomorancak = sheet.getCell(2, index);
				result = nomorancak.getContents();
			} else
				result = "";
		}
		workbook.close();
		return result;
	}

	public String readJenisKaryawan(int index) throws BiffException,
			IOException {
		String result = "";
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		Workbook workbook = Workbook.getWorkbook(file);
		String[] Sheets = workbook.getSheetNames();
		boolean ancakFound = false;
		for (int i = 0; i < Sheets.length; i++) {
			if (Sheets[i].equalsIgnoreCase("FRTKaryawan"))
				ancakFound = true;
		}
		if (ancakFound) {
			Sheet sheet = workbook.getSheet(1);
			if (index < sheet.getRows()) {
				Cell nomorancak = sheet.getCell(3, index);
				result = nomorancak.getContents();
			} else
				result = "";
		}
		workbook.close();
		return result;
	}

	public String readNomorTPH(int index) throws BiffException, IOException {
		String result = "";
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		Workbook workbook = Workbook.getWorkbook(file);
		String[] Sheets = workbook.getSheetNames();
		boolean ancakFound = false;
		for (int i = 0; i < Sheets.length; i++) {
			if (Sheets[i].equalsIgnoreCase("TPHDetails"))
				ancakFound = true;
		}
		if (ancakFound) {
			Sheet sheet = workbook.getSheet(1);
			if (index < sheet.getRows()) {
				Cell nomorancak = sheet.getCell(2, index);
				result = nomorancak.getContents();
			} else
				result = "";
		}
		workbook.close();
		return result;
	}

	public String readPermanen(int index) throws BiffException, IOException {
		String result = "";
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		Workbook workbook = Workbook.getWorkbook(file);
		String[] Sheets = workbook.getSheetNames();
		boolean ancakFound = false;
		for (int i = 0; i < Sheets.length; i++) {
			if (Sheets[i].equalsIgnoreCase("TPHDetails"))
				ancakFound = true;
		}
		if (ancakFound) {
			Sheet sheet = workbook.getSheet(1);
			if (index < sheet.getRows()) {
				Cell nomorancak = sheet.getCell(3, index);
				result = nomorancak.getContents();
			} else
				result = "";
		}
		workbook.close();
		return result;
	}

	public String readTandanPanen(int index) throws BiffException, IOException {
		String result = "";
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		Workbook workbook = Workbook.getWorkbook(file);
		String[] Sheets = workbook.getSheetNames();
		boolean ancakFound = false;
		for (int i = 0; i < Sheets.length; i++) {
			if (Sheets[i].equalsIgnoreCase("TPHDetails"))
				ancakFound = true;
		}
		if (ancakFound) {
			Sheet sheet = workbook.getSheet(1);
			if (index < sheet.getRows()) {
				Cell nomorancak = sheet.getCell(4, index);
				result = nomorancak.getContents();
			} else
				result = "";
		}
		workbook.close();
		return result;
	}

	public String readNamaAncak(int index) throws BiffException, IOException {
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		Workbook workbook = Workbook.getWorkbook(file);
		String[] Sheets = workbook.getSheetNames();
		boolean ancakFound = false;
		for (int i = 0; i < Sheets.length; i++) {
			if (Sheets[i].equalsIgnoreCase("PanenAncak"))
				ancakFound = true;
		}
		if (ancakFound) {
			Sheet sheet = workbook.getSheet(1);
			if (index < sheet.getRows()) {
				Cell nomorancak = sheet.getCell(4, index);
				return nomorancak.getContents();
			}
		}
		return "";
	}

	public String readMataAngin(int index) throws BiffException, IOException {
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		Workbook workbook = Workbook.getWorkbook(file);
		String[] Sheets = workbook.getSheetNames();
		boolean ancakFound = false;
		for (int i = 0; i < Sheets.length; i++) {
			if (Sheets[i].equalsIgnoreCase("PanenAncak"))
				ancakFound = true;
		}
		if (ancakFound) {
			Sheet sheet = workbook.getSheet(1);
			if (index < sheet.getRows()) {
				Cell nomorancak = sheet.getCell(7, index);
				return nomorancak.getContents();
			}
		}
		return "";
	}

	public String readCekAncak(int index) throws BiffException, IOException {
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		Workbook workbook = Workbook.getWorkbook(file);
		String[] Sheets = workbook.getSheetNames();
		boolean ancakFound = false;
		for (int i = 0; i < Sheets.length; i++) {
			if (Sheets[i].equalsIgnoreCase("PanenAncak"))
				ancakFound = true;
		}
		if (ancakFound) {
			Sheet sheet = workbook.getSheet(1);
			if (index < sheet.getRows()) {
				Cell nomorancak = sheet.getCell(8, index);
				return nomorancak.getContents();
			}
		}
		return "";
	}

	public boolean setPointer(int ancak) {
		pokokpointer = ancak;
		visited = false;
		return true;
	}

	public int getPointer() {
		return pokokpointer;
	}

	public boolean readPokok(int index) throws BiffException, IOException {
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		Workbook workbook = Workbook.getWorkbook(file);
		String[] Sheets = workbook.getSheetNames();
		boolean pokokFound = false;
		for (int i = 0; i < Sheets.length; i++) {
			if (Sheets[i].equalsIgnoreCase("PanenDetails"))
				pokokFound = true;
		}
		if (pokokFound) {
			Sheet sheet = workbook.getSheet(2);
			if (sheet.getRows() < index + pokokpointer) {
				return false;
			}
			Cell pokok = sheet.getCell(0, (index + pokokpointer) - 1);
			return pokok.getContents() != "";
		}
		return false;
	}

	public ArrayList<String> readPokokDetail(int index) throws BiffException,
			IOException {
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		Workbook workbook = Workbook.getWorkbook(file);
		Sheet sheet = workbook.getSheet(2);
		ArrayList<String> result = new ArrayList<String>();
		for (int z = 0; z < 74; z++) {
			Cell pokok = sheet.getCell(z + 3, (index + pokokpointer) - 1);
			result.add(pokok.getContents());
		}
		return result;
	}

	public boolean saveFollowUp(Integer index, String followUp)
			throws BiffException, IOException, WriteException {
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		WorkbookSettings wbSettings = new WorkbookSettings();
		try {
			wbSettings.setLocale(new Locale("en", "EN"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Workbook copy = Workbook.getWorkbook(file);
		WritableWorkbook workbook = Workbook.createWorkbook(file, copy);
		WritableSheet sheet = workbook.getSheet(1);
		WritableCellFormat times;
		WritableCellFormat timesBold;
		WritableFont times10pt = new WritableFont(WritableFont.TIMES, 12);
		times = new WritableCellFormat(times10pt);
		times.setWrap(false);
		WritableFont times10ptBold = new WritableFont(WritableFont.TIMES, 14,
				WritableFont.BOLD);
		timesBold = new WritableCellFormat(times10ptBold);
		timesBold.setWrap(false);
		CellView cv = new CellView();
		cv.setFormat(timesBold);
		cv.setFormat(times);
		cv.setAutosize(true);
		// Label extranote = new Label(7, index + 1, ExtraNote, times);
		// sheet.addCell(extranote);
		Label FU = new Label(5, index + 1, followUp, times);
		sheet.addCell(FU);
		workbook.write();
		workbook.close();
		return true;
	}

	public boolean setPokok(int pokok) {
		this.pokok = pokok;
		return true;
	}

	public boolean openFile(String url) throws BiffException, IOException,
			ParseException {
		loadfile = true;
		File file = new File(url);
		Workbook workbook = Workbook.getWorkbook(file);
		Sheet sheet = workbook.getSheet(0);
		Cell region = sheet.getCell(1, 1);
		setRegion(region.getContents());
		Cell company = sheet.getCell(2, 1);
		setCompany(company.getContents());
		Cell estate = sheet.getCell(3, 1);
		setEstate(estate.getContents());
		Cell division = sheet.getCell(4, 1);
		setDivision(division.getContents());
		Cell blockid = sheet.getCell(5, 1);
		setBlockID(blockid.getContents());
		Cell tanggal = sheet.getCell(6, 1);
		setTanggal(tanggal.getContents());
		Cell rotasi = sheet.getCell(7, 1);
		setRotasiPanen(rotasi.getContents());
		setEvaluator(getNamaevaluator());
		Cell formNo = sheet.getCell(0, 1);
		setFormNo(true, formNo.getContents());
		return true;
	}

	public boolean openFileMTP(String url) throws BiffException, IOException,
			ParseException {
		loadfile = true;
		File file = new File(url);
		Workbook workbook = Workbook.getWorkbook(file);
		Sheet sheet = workbook.getSheet(0);
		Cell region = sheet.getCell(1, 1);
		setRegion(region.getContents());
		Cell company = sheet.getCell(2, 1);
		setCompany(company.getContents());
		Cell estate = sheet.getCell(3, 1);
		setEstate(estate.getContents());
		Cell division = sheet.getCell(4, 1);
		setDivision(division.getContents());
		Cell blockid = sheet.getCell(5, 1);
		setBlockID(blockid.getContents());
		Cell tanggal = sheet.getCell(6, 1);
		setTanggal(tanggal.getContents());
		setEvaluator(getNamaevaluator());
		Cell formNo = sheet.getCell(0, 1);
		setFormNo(true, formNo.getContents());
		return true;
	}

	public boolean openFileTPH(String url) throws BiffException, IOException,
			ParseException {
		loadfile = true;
		File file = new File(url);
		Workbook workbook = Workbook.getWorkbook(file);
		Sheet sheet = workbook.getSheet(0);
		Cell region = sheet.getCell(1, 1);
		setRegion(region.getContents());
		Cell company = sheet.getCell(2, 1);
		setCompany(company.getContents());
		Cell estate = sheet.getCell(3, 1);
		setEstate(estate.getContents());
		Cell division = sheet.getCell(4, 1);
		setDivision(division.getContents());
		Cell blockid = sheet.getCell(5, 1);
		setBlockID(blockid.getContents());
		Cell tanggal = sheet.getCell(6, 1);
		setTanggal(tanggal.getContents());
		Cell rotasi = sheet.getCell(7, 1);
		setRotasiPanen(rotasi.getContents());
		setEvaluator(getNamaevaluator());
		Cell formNo = sheet.getCell(0, 1);
		setFormNo(true, formNo.getContents());
		return true;
	}

	public boolean openFileFRT(String url) throws BiffException, IOException,
			ParseException {
		loadfile = true;
		File file = new File(url);
		Workbook workbook = Workbook.getWorkbook(file);
		Sheet sheet = workbook.getSheet(0);
		Cell region = sheet.getCell(1, 1);
		setRegion(region.getContents());
		Cell company = sheet.getCell(2, 1);
		setCompany(company.getContents());
		Cell estate = sheet.getCell(3, 1);
		setEstate(estate.getContents());
		Cell division = sheet.getCell(4, 1);
		setDivision(division.getContents());
		setEvaluator(getNamaevaluator());
		Cell formNo = sheet.getCell(0, 1);
		setFormNo(true, formNo.getContents());
		return true;
	}

	public int getTphIndex() {
		return tphindex;
	}

	public boolean storeTPH(String TPH, String TandanTinggal,
			String brondolsegar, String brondolbusuk, String Foto1,
			String Foto2, String Time, String cek)
			throws RowsExceededException, BiffException, WriteException,
			IOException {
		createTPHHeader();
		if (TPH.equals("1") && !visited && !loadfile) {
			reserveTPHRows();
			visited = true;
		}
		String CekNo = formNo + "." + TPH;
		List<String> content = new ArrayList<String>();
		content.add(CekNo);
		content.add(getFormNo());
		content.add(TPH);
		content.add(TandanTinggal);
		content.add(brondolsegar);
		content.add(brondolbusuk);
		content.add(cek);
		content.add(Foto1);
		content.add(Foto2);
		content.add(Time);
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		Workbook workbook = Workbook.getWorkbook(file);
		String[] Sheets = workbook.getSheetNames();
		boolean headerFound = false;
		for (int i = 0; i < Sheets.length; i++) {
			if (Sheets[i].equalsIgnoreCase("MTPHDetails"))
				headerFound = true;
		}
		if (headerFound) {
			WritableWorkbook edit = Workbook.createWorkbook(file, workbook);
			WritableSheet sheet = edit.getSheet(1);
			WritableCellFormat times = null;
			WritableCellFormat timesBold = null;
			WritableFont times10pt = new WritableFont(WritableFont.TIMES, 12);
			times = new WritableCellFormat(times10pt);
			times.setWrap(false);
			WritableFont times10ptBold = new WritableFont(WritableFont.TIMES,
					14, WritableFont.BOLD);
			timesBold = new WritableCellFormat(times10ptBold);
			timesBold.setWrap(false);
			CellView cv = new CellView();
			cv.setFormat(timesBold);
			cv.setFormat(times);
			cv.setAutosize(true);
			for (int i = 0; i < content.size(); i++) {
				Label label = new Label(i, tphindex, content.get(i), times);
				sheet.addCell(label);
			}
			edit.write();
			edit.close();
			workbook.close();
		}
		if (next) {
			tphindex++;
		} else {
			tphindex--;
		}
		setChanged();
		notifyObservers();
		return true;
	}

	public boolean storeFRTKary(String EmpCode, String EmpType, String BlockID,
			String JalurNo, String Alas, String Tercecer, String WarnaMangkuk,
			String DosisMangkuk, String PasarTengah, String SarungTanganAda,
			String SarungTanganLayak, String MaskerAda, String MaskerLayak,
			String SepatuAPAda, String SepatuAPLayak, String LenganPanjangAda,
			String LenganPanjangLayak, String ApronAda, String ApronLayak,
			String BeratEmber1, String JumlahPokok1, String BeratEmber2,
			String JumlahPokok2, String BeratEmber3, String JumlahPokok3,
			String BeratEmber4, String JumlahPokok4)
			throws RowsExceededException, BiffException, WriteException,
			IOException {
		createFRTKaryHeader();
		if (!visited && !loadfile) {
			reserveFRTKaryRows();
			visited = true;
		}
		String CekNo = getFormNo() + "-" + EmpCode;
		List<String> content = new ArrayList<String>();
		content.add(CekNo);
		content.add(getFormNo());
		content.add(EmpCode);
		content.add(EmpType);
		content.add(BlockID);
		content.add(JalurNo);
		content.add(Alas);
		content.add(Tercecer);
		content.add(WarnaMangkuk);
		content.add(DosisMangkuk);
		content.add(PasarTengah);
		content.add(SarungTanganAda);
		content.add(SarungTanganLayak);
		content.add(MaskerAda);
		content.add(MaskerLayak);
		content.add(SepatuAPAda);
		content.add(SepatuAPLayak);
		content.add(LenganPanjangAda);
		content.add(LenganPanjangLayak);
		content.add(ApronAda);
		content.add(ApronLayak);
		content.add(BeratEmber1);
		content.add(JumlahPokok1);
		content.add(BeratEmber2);
		content.add(JumlahPokok2);
		content.add(BeratEmber3);
		content.add(JumlahPokok3);
		content.add(BeratEmber4);
		content.add(JumlahPokok4);
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		Workbook workbook = Workbook.getWorkbook(file);
		String[] Sheets = workbook.getSheetNames();
		boolean headerFound = false;
		for (int i = 0; i < Sheets.length; i++) {
			if (Sheets[i].equalsIgnoreCase("FRTKaryawan"))
				headerFound = true;
		}
		if (headerFound) {
			WritableWorkbook edit = Workbook.createWorkbook(file, workbook);
			WritableSheet sheet = edit.getSheet(1);
			WritableCellFormat times = null;
			WritableCellFormat timesBold = null;
			WritableFont times10pt = new WritableFont(WritableFont.TIMES, 12);
			times = new WritableCellFormat(times10pt);
			times.setWrap(false);
			WritableFont times10ptBold = new WritableFont(WritableFont.TIMES,
					14, WritableFont.BOLD);
			timesBold = new WritableCellFormat(times10ptBold);
			timesBold.setWrap(false);
			CellView cv = new CellView();
			cv.setFormat(timesBold);
			cv.setFormat(times);
			cv.setAutosize(true);
			for (int i = 0; i < content.size(); i++) {
				Label label = new Label(i, karyawancounter, content.get(i),
						times);
				sheet.addCell(label);
			}
			edit.write();
			edit.close();
			workbook.close();
		}
		return true;
	}

	public boolean reserveFRTKaryRows() throws IOException, BiffException,
			WriteException {
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		Workbook workbook = Workbook.getWorkbook(file);
		WritableWorkbook edit = Workbook.createWorkbook(file, workbook);
		WritableSheet sheet = edit.getSheet(1);
		WritableCellFormat times = null;
		WritableCellFormat timesBold = null;
		WritableFont times10pt = new WritableFont(WritableFont.TIMES, 12);
		times = new WritableCellFormat(times10pt);
		times.setWrap(false);
		WritableFont times10ptBold = new WritableFont(WritableFont.TIMES, 14,
				WritableFont.BOLD);
		timesBold = new WritableCellFormat(times10ptBold);
		timesBold.setWrap(false);
		CellView cv = new CellView();
		cv.setFormat(timesBold);
		cv.setFormat(times);
		cv.setAutosize(true);
		for (int i = 0; i < 7; i++) {
			for (int j = 1; j <= 10; j++) {
				Label label = new Label(i, j, "", timesBold);
				sheet.addCell(label);
			}
		}
		edit.write();
		edit.close();
		workbook.close();
		return true;
	}

	public boolean createFRTKaryHeader() throws BiffException, IOException,
			RowsExceededException, WriteException {
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		Workbook workbook = Workbook.getWorkbook(file);
		String[] Sheets = workbook.getSheetNames();
		boolean headerFound = false;
		for (int i = 0; i < Sheets.length; i++) {
			if (Sheets[i].equalsIgnoreCase("FRTKaryawan"))
				headerFound = true;
		}
		if (!headerFound) {
			WritableWorkbook edit = Workbook.createWorkbook(file, workbook);
			WritableSheet sheet = edit.createSheet("FRTKaryawan", 1);
			WritableCellFormat times = null;
			WritableCellFormat timesBold = null;
			WritableFont times10pt = new WritableFont(WritableFont.TIMES, 12);
			times = new WritableCellFormat(times10pt);
			times.setWrap(false);
			WritableFont times10ptBold = new WritableFont(WritableFont.TIMES,
					14, WritableFont.BOLD);
			timesBold = new WritableCellFormat(times10ptBold);
			timesBold.setWrap(false);
			CellView cv = new CellView();
			cv.setFormat(timesBold);
			cv.setFormat(times);
			cv.setAutosize(true);
			List<String> header = new ArrayList<String>();
			header.add("CekNo");
			header.add("FormNo");
			header.add("EmpCode");
			header.add("EmpType");
			header.add("BlockID");
			header.add("JalurNo");
			header.add("Alas");
			header.add("Tercecer");
			header.add("WarnaMangkuk");
			header.add("DosisMangkuk");
			header.add("PasarTengah");
			header.add("SarungTanganAda");
			header.add("SarungTanganLayak");
			header.add("MaskerAda");
			header.add("MaskerLayak");
			header.add("SepatuAPAda");
			header.add("SepatuAPLayak");
			header.add("LenganPanjangAda");
			header.add("LenganPanjangLayak");
			header.add("ApronAda");
			header.add("ApronAdaLayak");
			header.add("BeratEmber1");
			header.add("JumlahPokok1");
			header.add("BeratEmber2");
			header.add("JumlahPokok2");
			header.add("BeratEmber3");
			header.add("JumlahPokok3");
			header.add("BeratEmber4");
			header.add("JumlahPokok4");
			for (int i = 0; i < header.size(); i++) {
				Label label = new Label(i, 0, header.get(i), timesBold);
				sheet.addCell(label);
			}
			edit.write();
			edit.close();
			workbook.close();
		}
		return true;
	}

	public boolean storeFRTSesudah(String EmpCode, String Abnormality,
			String TercecerDiPP, String CPirW, String CPirR, String CPirO,
			String CPP, String TaburanPir, String TaburanLeft,
			String TaburanTop, String TaburanBot, String Areal,
			String KondisiPupuk, String Time) throws RowsExceededException,
			BiffException, WriteException, IOException {
		createFRTSesudahHeader();
		if (!visited && !loadfile) {
			reserveFRTSesudahRows();
			visited = true;
		}
		String cekNo = getFormNo() + "-" + EmpCode;
		String PID = cekNo + "-" + frtpokok;
		List<String> content = new ArrayList<String>();
		content.add(PID);
		content.add(cekNo);
		content.add("" + frtpokok);
		content.add(Abnormality);
		content.add(TercecerDiPP);
		content.add(CPirW);
		content.add(CPirR);
		content.add(CPirO);
		content.add(CPP);
		content.add(TaburanPir);
		content.add(TaburanLeft);
		content.add(TaburanTop);
		content.add(TaburanBot);
		content.add(Areal);
		content.add(KondisiPupuk);
		content.add(Time);
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		Workbook workbook = Workbook.getWorkbook(file);
		String[] Sheets = workbook.getSheetNames();
		boolean headerFound = false;
		for (int i = 0; i < Sheets.length; i++) {
			if (Sheets[i].equalsIgnoreCase("FRTSemasa"))
				headerFound = true;
		}
		if (headerFound) {
			WritableWorkbook edit = Workbook.createWorkbook(file, workbook);
			WritableSheet sheet = edit.getSheet(3);
			WritableCellFormat times = null;
			WritableCellFormat timesBold = null;
			WritableFont times10pt = new WritableFont(WritableFont.TIMES, 12);
			times = new WritableCellFormat(times10pt);
			times.setWrap(false);
			WritableFont times10ptBold = new WritableFont(WritableFont.TIMES,
					14, WritableFont.BOLD);
			timesBold = new WritableCellFormat(times10ptBold);
			timesBold.setWrap(false);
			CellView cv = new CellView();
			cv.setFormat(timesBold);
			cv.setFormat(times);
			cv.setAutosize(true);
			for (int i = 0; i < content.size(); i++) {
				Label label = new Label(i, ((karyawancounter - 1) * 30)
						+ frtpokok, content.get(i), times);
				sheet.addCell(label);
			}
			edit.write();
			edit.close();
			workbook.close();
			if (next) {
				frtpokok++;
			} else {
				frtpokok--;
			}
			setChanged();
			notifyObservers();
		}
		return true;
	}

	public boolean reserveFRTSesudahRows() throws IOException, BiffException,
			WriteException {
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		Workbook workbook = Workbook.getWorkbook(file);
		WritableWorkbook edit = Workbook.createWorkbook(file, workbook);
		WritableSheet sheet = edit.getSheet(3);
		WritableCellFormat times = null;
		WritableCellFormat timesBold = null;
		WritableFont times10pt = new WritableFont(WritableFont.TIMES, 12);
		times = new WritableCellFormat(times10pt);
		times.setWrap(false);
		WritableFont times10ptBold = new WritableFont(WritableFont.TIMES, 14,
				WritableFont.BOLD);
		timesBold = new WritableCellFormat(times10ptBold);
		timesBold.setWrap(false);
		CellView cv = new CellView();
		cv.setFormat(timesBold);
		cv.setFormat(times);
		cv.setAutosize(true);
		for (int i = 0; i < 7; i++) {
			for (int j = 1; j <= 30; j++) {
				Label label = new Label(i, (karyawancounter - 1) * 30 + j, "",
						timesBold);
				sheet.addCell(label);
			}
		}
		edit.write();
		edit.close();
		workbook.close();
		return true;
	}

	public boolean createFRTSesudahHeader() throws BiffException, IOException,
			RowsExceededException, WriteException {
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		Workbook workbook = Workbook.getWorkbook(file);
		String[] Sheets = workbook.getSheetNames();
		boolean headerFound = false;
		for (int i = 0; i < Sheets.length; i++) {
			if (Sheets[i].equalsIgnoreCase("FRTSesudah"))
				headerFound = true;
		}
		if (!headerFound) {
			WritableWorkbook edit = Workbook.createWorkbook(file, workbook);
			WritableSheet sheet = edit.createSheet("FRTSesudah", 3);
			WritableCellFormat times = null;
			WritableCellFormat timesBold = null;
			WritableFont times10pt = new WritableFont(WritableFont.TIMES, 12);
			times = new WritableCellFormat(times10pt);
			times.setWrap(false);
			WritableFont times10ptBold = new WritableFont(WritableFont.TIMES,
					14, WritableFont.BOLD);
			timesBold = new WritableCellFormat(times10ptBold);
			timesBold.setWrap(false);
			CellView cv = new CellView();
			cv.setFormat(timesBold);
			cv.setFormat(times);
			cv.setAutosize(true);
			List<String> header = new ArrayList<String>();
			header.add("PID");
			header.add("CekNo");
			header.add("Pokok");
			header.add("Abnormality");
			header.add("TercecerDiPP");
			header.add("CPirW");
			header.add("CPirR");
			header.add("CPirO");
			header.add("CPP");
			header.add("TaburanPir");
			header.add("TaburanLeft");
			header.add("TaburanTop");
			header.add("TaburanBot");
			header.add("Areal");
			header.add("KondisiPupuk");
			header.add("Time");
			for (int i = 0; i < header.size(); i++) {
				Label label = new Label(i, 0, header.get(i), timesBold);
				sheet.addCell(label);
			}
			edit.write();
			edit.close();
			workbook.close();
		}
		return true;
	}

	public boolean storeFRTSemasa(String EmpCode, String Abnormality,
			String TercecerDiPP, String CPirW, String CPirR, String CPirO,
			String CPP, String TaburanPir, String TaburanLeft,
			String TaburanTop, String TaburanBot, String Areal,
			String KondisiPupuk, String Time) throws RowsExceededException,
			BiffException, WriteException, IOException {
		createFRTSemasaHeader();
		if (!visited && !loadfile) {
			reserveFRTSemasaRows();
			visited = true;
		}
		String cekNo = getFormNo() + "-" + EmpCode;
		String PID = cekNo + "-" + frtpokok;
		List<String> content = new ArrayList<String>();
		content.add(PID);
		content.add(cekNo);
		content.add("" + frtpokok);
		content.add(Abnormality);
		content.add(TercecerDiPP);
		content.add(CPirW);
		content.add(CPirR);
		content.add(CPirO);
		content.add(CPP);
		content.add(TaburanPir);
		content.add(TaburanLeft);
		content.add(TaburanTop);
		content.add(TaburanBot);
		content.add(Areal);
		content.add(KondisiPupuk);
		content.add(Time);
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		Workbook workbook = Workbook.getWorkbook(file);
		String[] Sheets = workbook.getSheetNames();
		boolean headerFound = false;
		for (int i = 0; i < Sheets.length; i++) {
			if (Sheets[i].equalsIgnoreCase("FRTSemasa"))
				headerFound = true;
		}
		if (headerFound) {
			WritableWorkbook edit = Workbook.createWorkbook(file, workbook);
			WritableSheet sheet = edit.getSheet(2);
			WritableCellFormat times = null;
			WritableCellFormat timesBold = null;
			WritableFont times10pt = new WritableFont(WritableFont.TIMES, 12);
			times = new WritableCellFormat(times10pt);
			times.setWrap(false);
			WritableFont times10ptBold = new WritableFont(WritableFont.TIMES,
					14, WritableFont.BOLD);
			timesBold = new WritableCellFormat(times10ptBold);
			timesBold.setWrap(false);
			CellView cv = new CellView();
			cv.setFormat(timesBold);
			cv.setFormat(times);
			cv.setAutosize(true);
			for (int i = 0; i < content.size(); i++) {
				Label label = new Label(i, ((karyawancounter - 1) * 30)
						+ frtpokok, content.get(i), times);
				sheet.addCell(label);
			}
			edit.write();
			edit.close();
			workbook.close();
			if (next) {
				frtpokok++;
			} else {
				frtpokok--;
			}
			setChanged();
			notifyObservers();
		}
		return true;
	}

	public boolean reserveFRTSemasaRows() throws IOException, BiffException,
			WriteException {
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		Workbook workbook = Workbook.getWorkbook(file);
		WritableWorkbook edit = Workbook.createWorkbook(file, workbook);
		WritableSheet sheet = edit.getSheet(2);
		WritableCellFormat times = null;
		WritableCellFormat timesBold = null;
		WritableFont times10pt = new WritableFont(WritableFont.TIMES, 12);
		times = new WritableCellFormat(times10pt);
		times.setWrap(false);
		WritableFont times10ptBold = new WritableFont(WritableFont.TIMES, 14,
				WritableFont.BOLD);
		timesBold = new WritableCellFormat(times10ptBold);
		timesBold.setWrap(false);
		CellView cv = new CellView();
		cv.setFormat(timesBold);
		cv.setFormat(times);
		cv.setAutosize(true);
		for (int i = 0; i < 7; i++) {
			for (int j = 1; j <= 30; j++) {
				Label label = new Label(i, (karyawancounter - 1) * 30 + j, "",
						timesBold);
				sheet.addCell(label);
			}
		}
		edit.write();
		edit.close();
		workbook.close();
		return true;
	}

	public boolean createFRTSemasaHeader() throws BiffException, IOException,
			RowsExceededException, WriteException {
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		Workbook workbook = Workbook.getWorkbook(file);
		String[] Sheets = workbook.getSheetNames();
		boolean headerFound = false;
		for (int i = 0; i < Sheets.length; i++) {
			if (Sheets[i].equalsIgnoreCase("FRTSemasa"))
				headerFound = true;
		}
		if (!headerFound) {
			WritableWorkbook edit = Workbook.createWorkbook(file, workbook);
			WritableSheet sheet = edit.createSheet("FRTSemasa", 2);
			WritableCellFormat times = null;
			WritableCellFormat timesBold = null;
			WritableFont times10pt = new WritableFont(WritableFont.TIMES, 12);
			times = new WritableCellFormat(times10pt);
			times.setWrap(false);
			WritableFont times10ptBold = new WritableFont(WritableFont.TIMES,
					14, WritableFont.BOLD);
			timesBold = new WritableCellFormat(times10ptBold);
			timesBold.setWrap(false);
			CellView cv = new CellView();
			cv.setFormat(timesBold);
			cv.setFormat(times);
			cv.setAutosize(true);
			List<String> header = new ArrayList<String>();
			header.add("PID");
			header.add("CekNo");
			header.add("Pokok");
			header.add("Abnormality");
			header.add("TercecerDiPP");
			header.add("CPirW");
			header.add("CPirR");
			header.add("CPirO");
			header.add("CPP");
			header.add("TaburanPir");
			header.add("TaburanLeft");
			header.add("TaburanTop");
			header.add("TaburanBot");
			header.add("Areal");
			header.add("KondisiPupuk");
			header.add("Time");
			for (int i = 0; i < header.size(); i++) {
				Label label = new Label(i, 0, header.get(i), timesBold);
				sheet.addCell(label);
			}
			edit.write();
			edit.close();
			workbook.close();
		}
		return true;
	}

	public boolean reserveTPHRows() throws IOException, BiffException,
			WriteException {
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		Workbook workbook = Workbook.getWorkbook(file);
		WritableWorkbook edit = Workbook.createWorkbook(file, workbook);
		WritableSheet sheet = edit.getSheet(1);
		WritableCellFormat times = null;
		WritableCellFormat timesBold = null;
		WritableFont times10pt = new WritableFont(WritableFont.TIMES, 12);
		times = new WritableCellFormat(times10pt);
		times.setWrap(false);
		WritableFont times10ptBold = new WritableFont(WritableFont.TIMES, 14,
				WritableFont.BOLD);
		timesBold = new WritableCellFormat(times10ptBold);
		timesBold.setWrap(false);
		CellView cv = new CellView();
		cv.setFormat(timesBold);
		cv.setFormat(times);
		cv.setAutosize(true);
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 40; j++) {
				Label label = new Label(i, (tphindex + j), "", timesBold);
				sheet.addCell(label);
			}
		}
		edit.write();
		edit.close();
		workbook.close();
		return true;
	}

	public boolean createTPHHeader() throws BiffException, IOException,
			RowsExceededException, WriteException {
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		Workbook workbook = Workbook.getWorkbook(file);
		String[] Sheets = workbook.getSheetNames();
		boolean headerFound = false;
		for (int i = 0; i < Sheets.length; i++) {
			if (Sheets[i].equalsIgnoreCase("MTPHDetails"))
				headerFound = true;
		}
		if (!headerFound) {
			WritableWorkbook edit = Workbook.createWorkbook(file, workbook);
			WritableSheet sheet = edit.createSheet("MTPHDetails", 1);
			WritableCellFormat times = null;
			WritableCellFormat timesBold = null;
			WritableFont times10pt = new WritableFont(WritableFont.TIMES, 12);
			times = new WritableCellFormat(times10pt);
			times.setWrap(false);
			WritableFont times10ptBold = new WritableFont(WritableFont.TIMES,
					14, WritableFont.BOLD);
			timesBold = new WritableCellFormat(times10ptBold);
			timesBold.setWrap(false);
			CellView cv = new CellView();
			cv.setFormat(timesBold);
			cv.setFormat(times);
			cv.setAutosize(true);
			List<String> header = new ArrayList<String>();
			header.add("CekNo");
			header.add("FormNo");
			header.add("TPHNo");
			header.add("FB");
			header.add("FBr");
			header.add("RBr");
			header.add("Cek");
			header.add("Foto1");
			header.add("Foto2");
			header.add("Time");
			for (int i = 0; i < header.size(); i++) {
				Label label = new Label(i, 0, header.get(i), timesBold);
				sheet.addCell(label);
			}
			edit.write();
			edit.close();
			workbook.close();
		}
		return true;
	}

	public boolean nextTPH() {
		next = true;
		return true;
	}

	public boolean prevTPH() {
		next = false;
		return true;
	}

	public boolean nextFRT() {
		next = true;
		return true;
	}

	public boolean prevFRT() {
		next = false;
		return true;
	}

	public boolean readTPH(int index) throws BiffException, IOException {
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		Workbook workbook = Workbook.getWorkbook(file);
		String[] Sheets = workbook.getSheetNames();
		boolean pokokFound = false;
		for (int i = 0; i < Sheets.length; i++) {
			if (Sheets[i].equalsIgnoreCase("MTPHDetails"))
				pokokFound = true;
		}
		if (pokokFound) {
			Sheet sheet = workbook.getSheet(1);
			if (sheet.getRows() < index + 1) {
				return false;
			}
			Cell pokok = sheet.getCell(0, index);
			return pokok.getContents() != "";
		}
		return false;
	}

	public ArrayList<String> readTPHDetail(int index) throws BiffException,
			IOException {
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		Workbook workbook = Workbook.getWorkbook(file);
		Sheet sheet = workbook.getSheet(1);
		ArrayList<String> result = new ArrayList<String>();
		for (int z = 0; z < 7; z++) {
			Cell pokok = sheet.getCell(z + 2, index);
			result.add(pokok.getContents());
		}
		return result;
	}

	public String readTPHprev(int index) throws BiffException, IOException {
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		Workbook workbook = Workbook.getWorkbook(file);
		try {
			Sheet sheet = workbook.getSheet(1);
			if (index != 1) {
				Cell pokok = sheet.getCell(2, index - 1);
				return pokok.getContents();
			}
		} catch (Exception e) {

		}

		return "";
	}

	public String readTPHnext(int index) throws BiffException, IOException {
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		Workbook workbook = Workbook.getWorkbook(file);
		try {
			Sheet sheet = workbook.getSheet(1);
			Cell pokok = sheet.getCell(2, index + 1);
			if (!pokok.getContents().isEmpty()) {
				return pokok.getContents();
			}
		} catch (Exception e) {

		}

		return "";

	}

	public boolean setTandan(int Tandan) {
		this.tandan = Tandan;
		return true;
	}

	public int getTandan() {
		return tandan;
	}

	public boolean storeTPHH(String TPH, String UkuranTPH, String Alas,
			String Bersih, String KodePermanen1, String KodePermanen2,
			String Tulis1, String Tulis2, String Hitung1, String Hitung2,
			String Mentah, String Mengkal, String Masak, String Terlalu,
			String Busuk, String Less50, String $50to75, String More75,
			String TangkaiPanjang, String Kastrasi, String Potongan,
			String Restan, String Baru, String Lama, String JumlahTumpukan,
			String BeratTumpukan1, String BeratTumpukan2,
			String BeratTumpukan3, String BeratTumpukan4,
			String BeratTumpukan5, String BeratTumpukan6, String Sampah,
			String BerondolKgSegar, String BerondolKgBusuk, String Cek,
			String Photo1, String Photo2, String Time)
			throws RowsExceededException, BiffException, WriteException,
			IOException {
		int index = (pokokpointer - 1) / 40;
		List<String> content = new ArrayList<String>();
		content.add(UkuranTPH);
		content.add(Alas);
		content.add(Bersih);
		content.add(KodePermanen1);
		content.add(KodePermanen2);
		content.add(Tulis1);
		content.add(Tulis2);
		content.add(Hitung1);
		content.add(Hitung2);
		content.add(Mentah);
		content.add(Mengkal);
		content.add(Masak);
		content.add(Terlalu);
		content.add(Busuk);
		content.add(Less50);
		content.add($50to75);
		content.add(More75);
		content.add(TangkaiPanjang);
		content.add(Kastrasi);
		content.add(Potongan);
		content.add(Restan);
		content.add(Baru);
		content.add(Lama);
		content.add(JumlahTumpukan);
		content.add(BeratTumpukan1);
		content.add(BeratTumpukan2);
		content.add(BeratTumpukan3);
		content.add(BeratTumpukan4);
		content.add(BeratTumpukan5);
		content.add(BeratTumpukan6);
		content.add(Sampah);
		content.add(BerondolKgSegar);
		content.add(BerondolKgBusuk);
		content.add(Cek);
		content.add(Photo1);
		content.add(Photo2);
		content.add(Time);
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		Workbook workbook = Workbook.getWorkbook(file);
		String[] Sheets = workbook.getSheetNames();
		boolean headerFound = false;
		for (int i = 0; i < Sheets.length; i++) {
			if (Sheets[i].equalsIgnoreCase("TPHDetails"))
				headerFound = true;
		}
		if (headerFound) {
			WritableWorkbook edit = Workbook.createWorkbook(file, workbook);
			WritableSheet sheet = edit.getSheet(1);
			WritableCellFormat times = null;
			WritableCellFormat timesBold = null;
			WritableFont times10pt = new WritableFont(WritableFont.TIMES, 12);
			times = new WritableCellFormat(times10pt);
			times.setWrap(false);
			WritableFont times10ptBold = new WritableFont(WritableFont.TIMES,
					14, WritableFont.BOLD);
			timesBold = new WritableCellFormat(times10ptBold);
			timesBold.setWrap(false);
			CellView cv = new CellView();
			cv.setFormat(timesBold);
			cv.setFormat(times);
			cv.setAutosize(true);
			for (int i = 0; i < content.size(); i++) {
				Label label = new Label(i + 5, index + 1, content.get(i), times);
				sheet.addCell(label);
			}
			edit.write();
			edit.close();
			workbook.close();
		}
		return true;
	}

	public boolean readMTPH() throws BiffException, IOException {
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		Workbook workbook = Workbook.getWorkbook(file);
		String[] Sheets = workbook.getSheetNames();
		boolean pokokFound = false;
		for (int i = 0; i < Sheets.length; i++) {
			if (Sheets[i].equalsIgnoreCase("TPHDetails"))
				pokokFound = true;
		}
		if (pokokFound) {
			Sheet sheet = workbook.getSheet(1);
			if (sheet.getRows() < (((pokokpointer - 1) / 40) + 2)) {
				return false;
			}
			int pointer = ((pokokpointer - 1) / 40) + 1;
			Cell pokok = sheet.getCell(5, pointer);
			return pokok.getContents() != "";
		}
		return false;
	}

	public ArrayList<String> readMPTHDetail() throws BiffException, IOException {
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		Workbook workbook = Workbook.getWorkbook(file);
		Sheet sheet = workbook.getSheet(1);
		ArrayList<String> result = new ArrayList<String>();
		for (int z = 0; z < 36; z++) {
			int pointer = ((pokokpointer - 1) / 40) + 1;
			Cell pokok = sheet.getCell(z + 5, pointer);
			result.add(pokok.getContents());
		}
		return result;
	}

	public boolean setBuah(int buah) {
		this.buah = buah;
		return true;
	}

	public int getBuah() {
		return buah;
	}

	public boolean storeMTPH(String BeratBuah, String JenisBuah, String cek,
			String Time) throws RowsExceededException, BiffException,
			WriteException, IOException {
		createMTPHHeader();
		if (buah == 1 && !visited && !loadfile) {
			reserveMTPHRows();
			visited = true;
		}
		int index = (pokokpointer - 1) / 40;
		String CekNo = formNo + "." + nomorTPH[index] + "." + buah;
		List<String> content = new ArrayList<String>();
		content.add(CekNo);
		content.add("" + buah);
		content.add(BeratBuah);
		content.add(JenisBuah);
		content.add(cek);
		content.add(Time);
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		Workbook workbook = Workbook.getWorkbook(file);
		String[] Sheets = workbook.getSheetNames();
		boolean headerFound = false;
		for (int i = 0; i < Sheets.length; i++) {
			if (Sheets[i].equalsIgnoreCase("TPHFruit"))
				headerFound = true;
		}
		if (headerFound) {
			WritableWorkbook edit = Workbook.createWorkbook(file, workbook);
			WritableSheet sheet = edit.getSheet(2);
			WritableCellFormat times = null;
			WritableCellFormat timesBold = null;
			WritableFont times10pt = new WritableFont(WritableFont.TIMES, 12);
			times = new WritableCellFormat(times10pt);
			times.setWrap(false);
			WritableFont times10ptBold = new WritableFont(WritableFont.TIMES,
					14, WritableFont.BOLD);
			timesBold = new WritableCellFormat(times10ptBold);
			timesBold.setWrap(false);
			CellView cv = new CellView();
			cv.setFormat(timesBold);
			cv.setFormat(times);
			cv.setAutosize(true);
			for (int i = 0; i < content.size(); i++) {
				Label label = new Label(i, (pokokpointer + buah) - 1,
						content.get(i), times);
				sheet.addCell(label);
			}
			edit.write();
			edit.close();
			workbook.close();
		}
		if (next) {
			buah++;
		} else {
			buah--;
		}
		setChanged();
		notifyObservers();
		return true;
	}

	public boolean reserveMTPHRows() throws IOException, BiffException,
			WriteException {
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		Workbook workbook = Workbook.getWorkbook(file);
		WritableWorkbook edit = Workbook.createWorkbook(file, workbook);
		WritableSheet sheet = edit.getSheet(2);
		WritableCellFormat times = null;
		WritableCellFormat timesBold = null;
		WritableFont times10pt = new WritableFont(WritableFont.TIMES, 12);
		times = new WritableCellFormat(times10pt);
		times.setWrap(false);
		WritableFont times10ptBold = new WritableFont(WritableFont.TIMES, 14,
				WritableFont.BOLD);
		timesBold = new WritableCellFormat(times10ptBold);
		timesBold.setWrap(false);
		CellView cv = new CellView();
		cv.setFormat(timesBold);
		cv.setFormat(times);
		cv.setAutosize(true);
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 40; j++) {
				Label label = new Label(i, (pokokpointer + j), "", timesBold);
				sheet.addCell(label);
			}
		}
		edit.write();
		edit.close();
		workbook.close();
		return true;
	}

	public boolean createMTPHHeader() throws BiffException, IOException,
			RowsExceededException, WriteException {
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		Workbook workbook = Workbook.getWorkbook(file);
		String[] Sheets = workbook.getSheetNames();
		boolean headerFound = false;
		for (int i = 0; i < Sheets.length; i++) {
			if (Sheets[i].equalsIgnoreCase("TPHFruit"))
				headerFound = true;
		}
		if (!headerFound) {
			WritableWorkbook edit = Workbook.createWorkbook(file, workbook);
			WritableSheet sheet = edit.createSheet("TPHFruit", 2);
			WritableCellFormat times = null;
			WritableCellFormat timesBold = null;
			WritableFont times10pt = new WritableFont(WritableFont.TIMES, 12);
			times = new WritableCellFormat(times10pt);
			times.setWrap(false);
			WritableFont times10ptBold = new WritableFont(WritableFont.TIMES,
					14, WritableFont.BOLD);
			timesBold = new WritableCellFormat(times10ptBold);
			timesBold.setWrap(false);
			CellView cv = new CellView();
			cv.setFormat(timesBold);
			cv.setFormat(times);
			cv.setAutosize(true);
			List<String> header = new ArrayList<String>();
			header.add("CekNo");
			header.add("BunchNo");
			header.add("BWt");
			header.add("FT");
			header.add("Cek");
			header.add("Time");
			for (int i = 0; i < header.size(); i++) {
				Label label = new Label(i, 0, header.get(i), timesBold);
				sheet.addCell(label);
			}
			edit.write();
			edit.close();
			workbook.close();
		}
		return true;
	}

	public boolean readMTPH(int index) throws BiffException, IOException {
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		Workbook workbook = Workbook.getWorkbook(file);
		String[] Sheets = workbook.getSheetNames();
		boolean pokokFound = false;
		for (int i = 0; i < Sheets.length; i++) {
			if (Sheets[i].equalsIgnoreCase("TPHFruit"))
				pokokFound = true;
		}
		if (pokokFound) {
			Sheet sheet = workbook.getSheet(2);
			if (sheet.getRows() < index + pokokpointer) {
				return false;
			}
			Cell pokok = sheet.getCell(0, (index + pokokpointer) - 1);
			return pokok.getContents() != "";
		}
		return false;
	}

	public ArrayList<String> readMTPHDetail(int index) throws BiffException,
			IOException {
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		Workbook workbook = Workbook.getWorkbook(file);
		Sheet sheet = workbook.getSheet(2);
		ArrayList<String> result = new ArrayList<String>();
		for (int z = 0; z < 3; z++) {
			Cell pokok = sheet.getCell(z + 2, (index + pokokpointer) - 1);
			result.add(pokok.getContents());
		}
		return result;
	}

	/**
	 * @return the jenisPupuk
	 */
	public String getJenisPupuk() {
		return JenisPupuk;
	}

	/**
	 * @param jenisPupuk
	 *            the jenisPupuk to set
	 */
	public void setJenisPupuk(String jenisPupuk) {
		JenisPupuk = jenisPupuk;
	}

	/**
	 * @return the jenisPupukLain
	 */
	public String getJenisPupukLain() {
		return JenisPupukLain;
	}

	/**
	 * @param jenisPupukLain
	 *            the jenisPupukLain to set
	 */
	public void setJenisPupukLain(String jenisPupukLain) {
		JenisPupukLain = jenisPupukLain;
	}

	public String getArealAplikasi() {
		return ArealAplikasi;
	}

	public void setArealAplikasi(String arealAplikasi) {
		ArealAplikasi = arealAplikasi;
	}

	public String getArealAplikasiLain() {
		return ArealAplikasiLain;
	}

	public void setArealAplikasiLain(String arealAplikasiLain) {
		ArealAplikasiLain = arealAplikasiLain;
	}

	public String getDosisPerPokok() {
		return DosisPerPokok;
	}

	public void setDosisPerPokok(String dosisPerPokok) {
		DosisPerPokok = dosisPerPokok;
	}

	public String getKarungPecah() {
		return KarungPecah;
	}

	public void setKarungPecah(String karungPecah) {
		KarungPecah = karungPecah;
	}

	public String getPanenSaatPemupukan() {
		return PanenSaatPemupukan;
	}

	public void setPanenSaatPemupukan(String panenSaatPemupukan) {
		PanenSaatPemupukan = panenSaatPemupukan;
	}

	public String getJumlahPenabur() {
		return JumlahPenabur;
	}

	public void setJumlahPenabur(String jumlahPenabur) {
		JumlahPenabur = jumlahPenabur;
	}

	public String getJatahPenabur() {
		return JatahPenabur;
	}

	public void setJatahPenabur(String jatahPenabur) {
		JatahPenabur = jatahPenabur;
	}

	public String getJumlahKarung() {
		return JumlahKarung;
	}

	public void setJumlahKarung(String jumlahKarung) {
		JumlahKarung = jumlahKarung;
	}

	public String getSelisihBerat() {
		return SelisihBerat;
	}

	public void setSelisihBerat(String selisihBerat) {
		SelisihBerat = selisihBerat;
	}

	public String getWaktuMulai() {
		return WaktuMulai;
	}

	public void setWaktuMulai(String waktuMulai) {
		WaktuMulai = waktuMulai;
	}

	public String getWaktuIstirahat() {
		return WaktuIstirahat;
	}

	public void setWaktuIstirahat(String waktuIstirahat) {
		WaktuIstirahat = waktuIstirahat;
	}

	public String getWaktuSelesai() {
		return WaktuSelesai;
	}

	public void setWaktuSelesai(String waktuSelesai) {
		WaktuSelesai = waktuSelesai;
	}

	public String getJumlahTidakAplikasi() {
		return JumlahTidakAplikasi;
	}

	public void setJumlahTidakAplikasi(String jumlahTidakAplikasi) {
		JumlahTidakAplikasi = jumlahTidakAplikasi;
	}

	public String getAlasanTidakAplikasi() {
		return AlasanTidakAplikasi;
	}

	public void setAlasanTidakAplikasi(String alasanTidakAplikasi) {
		AlasanTidakAplikasi = alasanTidakAplikasi;
	}

	public String getSudahAplikasi1() {
		return SudahAplikasi1;
	}

	public void setSudahAplikasi1(String sudahAplikasi1) {
		SudahAplikasi1 = sudahAplikasi1;
	}

	public String getSudahAplikasi2() {
		return SudahAplikasi2;
	}

	public void setSudahAplikasi2(String sudahAplikasi2) {
		SudahAplikasi2 = sudahAplikasi2;
	}

	public String getSudahAplikasi3() {
		return SudahAplikasi3;
	}

	public void setSudahAplikasi3(String sudahAplikasi3) {
		SudahAplikasi3 = sudahAplikasi3;
	}

	public String getSudahAplikasi4() {
		return SudahAplikasi4;
	}

	public void setSudahAplikasi4(String sudahAplikasi4) {
		SudahAplikasi4 = sudahAplikasi4;
	}

	public String getSudahAplikasi5() {
		return SudahAplikasi5;
	}

	public void setSudahAplikasi5(String sudahAplikasi5) {
		SudahAplikasi5 = sudahAplikasi5;
	}

	public String getSudahAplikasi6() {
		return SudahAplikasi6;
	}

	public void setSudahAplikasi6(String sudahAplikasi6) {
		SudahAplikasi6 = sudahAplikasi6;
	}

	public String getSudahAplikasi7() {
		return SudahAplikasi7;
	}

	public void setSudahAplikasi7(String sudahAplikasi7) {
		SudahAplikasi7 = sudahAplikasi7;
	}

	public String getSudahAplikasi8() {
		return SudahAplikasi8;
	}

	public void setSudahAplikasi8(String sudahAplikasi8) {
		SudahAplikasi8 = sudahAplikasi8;
	}

	public String getSudahAplikasi9() {
		return SudahAplikasi9;
	}

	public void setSudahAplikasi9(String sudahAplikasi9) {
		SudahAplikasi9 = sudahAplikasi9;
	}

	public String getSudahAplikasi10() {
		return SudahAplikasi10;
	}

	public void setSudahAplikasi10(String sudahAplikasi10) {
		SudahAplikasi10 = sudahAplikasi10;
	}

	public String getKarungKosong() {
		return KarungKosong;
	}

	public void setKarungKosong(String karungKosong) {
		KarungKosong = karungKosong;
	}

	public String getKarungKosongLain() {
		return KarungKosongLain;
	}

	public void setKarungKosongLain(String karungKosongLain) {
		KarungKosongLain = karungKosongLain;
	}

	public String getKarungDikembalikanKeGudang() {
		return KarungDikembalikanKeGudang;
	}

	public void setKarungDikembalikanKeGudang(String karungDikembalikanKeGudang) {
		KarungDikembalikanKeGudang = karungDikembalikanKeGudang;
	}

	public String getMandorJumlah() {
		return MandorJumlah;
	}

	public void setMandorJumlah(String mandorJumlah) {
		MandorJumlah = mandorJumlah;
	}

	public String getMandorFT() {
		return MandorFT;
	}

	public void setMandorFT(String mandorFT) {
		MandorFT = mandorFT;
	}

	public String getMandorPT() {
		return MandorPT;
	}

	public void setMandorPT(String mandorPT) {
		MandorPT = mandorPT;
	}

	public String getAslapJumlah() {
		return AslapJumlah;
	}

	public void setAslapJumlah(String aslapJumlah) {
		AslapJumlah = aslapJumlah;
	}

	public String getAslapFT() {
		return AslapFT;
	}

	public void setAslapFT(String aslapFT) {
		AslapFT = aslapFT;
	}

	public String getAslapPT() {
		return AslapPT;
	}

	public void setAslapPT(String aslapPT) {
		AslapPT = aslapPT;
	}

	public String getAskepJumlah() {
		return AskepJumlah;
	}

	public void setAskepJumlah(String askepJumlah) {
		AskepJumlah = askepJumlah;
	}

	public String getAskepFT() {
		return AskepFT;
	}

	public void setAskepFT(String askepFT) {
		AskepFT = askepFT;
	}

	public String getAskepPT() {
		return AskepPT;
	}

	public void setAskepPT(String askepPT) {
		AskepPT = askepPT;
	}

	public String getManagerJumlah() {
		return ManagerJumlah;
	}

	public void setManagerJumlah(String managerJumlah) {
		ManagerJumlah = managerJumlah;
	}

	public String getManagerFT() {
		return ManagerFT;
	}

	public void setManagerFT(String managerFT) {
		ManagerFT = managerFT;
	}

	public String getMandor1() {
		return Mandor1;
	}

	public void setMandor1(String mandor1) {
		Mandor1 = mandor1;
	}

	public String getMandor2() {
		return Mandor2;
	}

	public void setMandor2(String mandor2) {
		Mandor2 = mandor2;
	}

	public String getMandor3() {
		return Mandor3;
	}

	public void setMandor3(String mandor3) {
		Mandor3 = mandor3;
	}

	public String getMandor4() {
		return Mandor4;
	}

	public void setMandor4(String mandor4) {
		Mandor4 = mandor4;
	}

	public String getMandor5() {
		return Mandor5;
	}

	public void setMandor5(String mandor5) {
		Mandor5 = mandor5;
	}

	public String getMandor6() {
		return Mandor6;
	}

	public void setMandor6(String mandor6) {
		Mandor6 = mandor6;
	}

	public String getMandor7() {
		return Mandor7;
	}

	public void setMandor7(String mandor7) {
		Mandor7 = mandor7;
	}

	public String getMandor8() {
		return Mandor8;
	}

	public void setMandor8(String mandor8) {
		Mandor8 = mandor8;
	}

	public String getMandor9() {
		return Mandor9;
	}

	public void setMandor9(String mandor9) {
		Mandor9 = mandor9;
	}

	public String getMandor10() {
		return Mandor10;
	}

	public void setMandor10(String mandor10) {
		Mandor10 = mandor10;
	}

	public String getAslap1() {
		return Aslap1;
	}

	public void setAslap1(String aslap1) {
		Aslap1 = aslap1;
	}

	public String getAslap2() {
		return Aslap2;
	}

	public void setAslap2(String aslap2) {
		Aslap2 = aslap2;
	}

	public String getAslap3() {
		return Aslap3;
	}

	public void setAslap3(String aslap3) {
		Aslap3 = aslap3;
	}

	public String getAslap4() {
		return Aslap4;
	}

	public void setAslap4(String aslap4) {
		Aslap4 = aslap4;
	}

	public String getAslap5() {
		return Aslap5;
	}

	public void setAslap5(String aslap5) {
		Aslap5 = aslap5;
	}

	public String getAslap6() {
		return Aslap6;
	}

	public void setAslap6(String aslap6) {
		Aslap6 = aslap6;
	}

	public String getAslap7() {
		return Aslap7;
	}

	public void setAslap7(String aslap7) {
		Aslap7 = aslap7;
	}

	public String getAslap8() {
		return Aslap8;
	}

	public void setAslap8(String aslap8) {
		Aslap8 = aslap8;
	}

	public String getAslap9() {
		return Aslap9;
	}

	public void setAslap9(String aslap9) {
		Aslap9 = aslap9;
	}

	public String getAslap10() {
		return Aslap10;
	}

	public void setAslap10(String aslap10) {
		Aslap10 = aslap10;
	}

	public String getRekomendasi() {
		return Rekomendasi;
	}

	public void setRekomendasi(String rekomendasi) {
		Rekomendasi = rekomendasi;
	}

	public String getAlasanBeda() {
		return AlasanBeda;
	}

	public void setAlasanBeda(String alasanBeda) {
		AlasanBeda = alasanBeda;
	}

	public void setNomorAncak(String[] nomorAncak) {
		this.nomorAncak = nomorAncak;
	}

	public void setNomorTPH(String[] nomorTPH) {
		this.nomorTPH = nomorTPH;
	}

	public String getManagerPT() {
		return ManagerPT;
	}

	public void setManagerPT(String managerPT) {
		ManagerPT = managerPT;
	}

	public int getKaryawancounter() {
		return karyawancounter;
	}

	public void setKaryawancounter(int karyawancounter) {
		this.karyawancounter = karyawancounter;
	}

	public int getFrtpokok() {
		return frtpokok;
	}

	public void setFrtpokok(int frtpokok) {
		this.frtpokok = frtpokok;
	}

	public boolean readFRTKaryawanNo() throws BiffException, IOException {
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		Workbook workbook = Workbook.getWorkbook(file);
		String[] Sheets = workbook.getSheetNames();
		boolean pokokFound = false;
		for (int i = 0; i < Sheets.length; i++) {
			if (Sheets[i].equalsIgnoreCase("FRTKaryawan"))
				pokokFound = true;
		}
		if (pokokFound) {
			Sheet sheet = workbook.getSheet(1);
			if (sheet.getRows() < karyawancounter + 1) {
				return false;
			}
			Cell pokok = sheet.getCell(0, karyawancounter);
			return pokok.getContents() != "";
		}
		return false;
	}

	public ArrayList<String> readFRTKaryawan() throws BiffException,
			IOException {
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		Workbook workbook = Workbook.getWorkbook(file);
		Sheet sheet = workbook.getSheet(1);
		ArrayList<String> result = new ArrayList<String>();
		for (int z = 0; z < 27; z++) {
			Cell pokok = sheet.getCell(z + 2, karyawancounter);
			result.add(pokok.getContents());
		}
		return result;
	}

	public boolean readFRTPupukSemasa() throws BiffException, IOException {
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		Workbook workbook = Workbook.getWorkbook(file);
		String[] Sheets = workbook.getSheetNames();
		boolean pokokFound = false;
		for (int i = 0; i < Sheets.length; i++) {
			if (Sheets[i].equalsIgnoreCase("FRTSemasa"))
				pokokFound = true;
		}
		if (pokokFound) {
			Sheet sheet = workbook.getSheet(2);
			if (sheet.getRows() < ((karyawancounter - 1) * 30) + frtpokok + 1) {
				return false;
			}
			Cell pokok = sheet.getCell(0, ((karyawancounter - 1) * 30)
					+ frtpokok);
			return pokok.getContents() != "";
		}
		return false;
	}

	public ArrayList<String> readFRTPupukSemasaDetail() throws BiffException,
			IOException {
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		Workbook workbook = Workbook.getWorkbook(file);
		Sheet sheet = workbook.getSheet(2);
		ArrayList<String> result = new ArrayList<String>();
		for (int z = 0; z < 12; z++) {
			Cell pokok = sheet.getCell(z + 3, ((karyawancounter - 1) * 30)
					+ frtpokok);
			result.add(pokok.getContents());
		}
		return result;
	}

	public String readFRTKaryawanType() throws BiffException, IOException {
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		Workbook workbook = Workbook.getWorkbook(file);
		String[] Sheets = workbook.getSheetNames();
		boolean pokokFound = false;
		for (int i = 0; i < Sheets.length; i++) {
			if (Sheets[i].equalsIgnoreCase("FRTKaryawan"))
				pokokFound = true;
		}
		if (pokokFound) {
			Sheet sheet = workbook.getSheet(1);
			Cell pokok = sheet.getCell(2, karyawancounter);
			return pokok.getContents();
		}
		return null;
	}

	public boolean readFRTPupukSesudah() throws BiffException, IOException {
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		Workbook workbook = Workbook.getWorkbook(file);
		String[] Sheets = workbook.getSheetNames();
		boolean pokokFound = false;
		for (int i = 0; i < Sheets.length; i++) {
			if (Sheets[i].equalsIgnoreCase("FRTSesudah"))
				pokokFound = true;
		}
		if (pokokFound) {
			Sheet sheet = workbook.getSheet(3);
			if (sheet.getRows() < ((karyawancounter - 1) * 30) + frtpokok + 1) {
				return false;
			}
			Cell pokok = sheet.getCell(0, ((karyawancounter - 1) * 30)
					+ frtpokok);
			return pokok.getContents() != "";
		}
		return false;
	}

	public ArrayList<String> readFRTPupukSesudahDetail() throws BiffException,
			IOException {
		String dirName = "/InternalControl/";
		File file;
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + dirName);
			dir.mkdirs();
			file = new File(dir, formNo + ".xls");
		} else {
			File phoneMemory = Environment.getRootDirectory();
			File dir = new File(phoneMemory.getAbsolutePath() + dirName);
			file = new File(dir, formNo + ".xls");
		}
		Workbook workbook = Workbook.getWorkbook(file);
		Sheet sheet = workbook.getSheet(3);
		ArrayList<String> result = new ArrayList<String>();
		for (int z = 0; z < 12; z++) {
			Cell pokok = sheet.getCell(z + 3, ((karyawancounter - 1) * 30)
					+ frtpokok);
			result.add(pokok.getContents());
		}
		return result;
	}

	public String[] getCekAncak() {
		return cekAncak;
	}
}