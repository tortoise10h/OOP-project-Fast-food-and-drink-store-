package fastfoodanddrinkstore;

import java.util.*;
import java.io.*;

public class DSChiTietHoaDonNhap {
	Scanner in = new Scanner(System.in);
	private int soluong;
	private ChiTietHoaDonNhap[] ds;
	/*===========GETTER & SETTER==========*/
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public ChiTietHoaDonNhap[] getDs() {
		return ds;
	}
	public void setDs(ChiTietHoaDonNhap[] ds) {
		this.ds = ds;
	}
	/*==========CONSTRUCTOR==========*/
	public DSChiTietHoaDonNhap () 
	{
		soluong = 0;
		ds = new ChiTietHoaDonNhap[100];
	}
	
	
	public DSChiTietHoaDonNhap(int number) {
		
		this.soluong = number;
		ds = new ChiTietHoaDonNhap[soluong];
	}
	public DSChiTietHoaDonNhap(ChiTietHoaDonNhap[] ds) {
		this.soluong = ds.length;
		
	}
	public DSChiTietHoaDonNhap(int soluong, ChiTietHoaDonNhap[] ds) {
		this.soluong = soluong;
		this.ds = ds;
	}
	/*==========INPUT & OUTPUT===========*/
	public void nhap() throws IOException 
	{
		System.out.print("Nhap so luong cua chi tiet hoa don nhap: ");
		this.soluong = in.nextInt();
		ds = new ChiTietHoaDonNhap[soluong];
		for(int i = 0; i < this.soluong; i++) 
		{			
			System.out.println("Chi tiet hoa don " + (i+1));			
			this.ds[i] = new ChiTietHoaDonNhap();
			this.ds[i].nhap();
		}
	}
	public void nhap(String mahd) throws Exception
	{
		System.out.print("Nhap so luong cua chi tiet hoa don nhap: ");
		this.soluong = in.nextInt();
		ds = new ChiTietHoaDonNhap[soluong];
		for(int i = 0; i < this.soluong; i++) 
		{			
			System.out.println("Chi tiet hoa don " + (i+1));			
			this.ds[i] = new ChiTietHoaDonNhap();
			this.ds[i].nhap(mahd);
		}
	}
	public void xuat() 
	{		
		System.out.println("Thong tin chi tiet hoa don");
		System.out.println("+----------+----------+------------+------------+-------+");
		System.out.printf("| %-8s | %-8s | %-10s | %-10s | %-5s|\n","Ma Hd","Ma Sp","Don Gia","Thanh Tien","Sluong");
		System.out.println("+----------+----------+------------+------------+-------+");
		for(int i = 0; i < this.soluong; i++){
			this.ds[i].xuat();
		}
	}
	/*==========ADD==========*/
	public void them() throws IOException
	{
		System.out.println("Them vao hoa don nhap moi");
		while(true) {
			ChiTietHoaDonNhap tem = new ChiTietHoaDonNhap();
			tem.nhap();
			if(tim(tem.getMahd(),tem.getMasp()) == -1) {
				them(tem);
				break;
			}else {
				System.out.println("Ma bi trung xin moi nhap lai thong tin!!!");
			}
		}
		
	}
	public void them(ChiTietHoaDonNhap tem) throws IOException{
		ds = Arrays.copyOf(ds,soluong +1);
		this.ds[this.soluong] = new ChiTietHoaDonNhap(tem);
		this.soluong++;		
		System.out.println("Da them thanh cong!");
		System.out.println("--------------------------------------------------------------------------------------------------");
	}
	public void them(int x)throws Exception {
		for(int i=0;i<x;i++) {
			System.out.println("Them chi tiet hoa don " + (i+1));
			them();
		}
	}
	public void them(int sl, String mahd)throws Exception{
		int oldLength = this.soluong;
    	this.soluong += sl;
    	ds = Arrays.copyOf(ds, this.soluong);
    	for(int i= oldLength; i < this.soluong; i++) {
    		System.out.println("\n* Nhap thong tin cho san pham nhap thu " + (i-oldLength+1));
    		while(true) {
    			ChiTietHoaDonNhap tem = new ChiTietHoaDonNhap();
    			tem.nhap(mahd);
        		boolean isDuplicate = false;
        		for(int j = 0; j < i; j++) {
        			if(ds[j].getMahd().toLowerCase().equals(tem.getMahd().toLowerCase()) == true && ds[j].getMasp().toLowerCase().equals(tem.getMasp().toLowerCase()) == true) {
        				isDuplicate = true;
        				break;
        			}
        		}
        		
        		if(isDuplicate == false) {
        			ds[i] = new ChiTietHoaDonNhap();
        			ds[i] = tem;
        			break;
        		}else {
        			System.out.println("Ma bi trung xin moi nhap lai");
        		}
    		}
    	}
	}
	/*==========SEARCH=========*/
	public int tim() {
		String mahd;
		String masp;
		System.out.println("- Nhap vao ma hoa don va ma san pham de tim dung chi tiet san pham");
		System.out.print(" . Nhap ma hoa don: ");
		mahd = in.nextLine();
		System.out.print(" . Nhap ma san pham: ");
		masp = in.nextLine();
		return tim(mahd,masp);
	}
	
	public int tim(String mahd, String masp) {
		for(int i=0;i<soluong; i++) {
			if(ds[i].getMahd().equals(mahd) == true && ds[i].getMasp().equals(masp) == true)
				return i;
		}
		return -1;
	}
	
	/*==========ADJUST==========*/
	public void sua(int x) throws IOException{
		if(x == -1) return;
		while(true) {
			ChiTietHoaDonNhap hdx = new ChiTietHoaDonNhap();
			hdx.nhap();
			if(tim(hdx.getMahd(),hdx.getMasp()) == -1 || tim(hdx.getMahd(),hdx.getMasp()) == x) {
				ds[x] = new ChiTietHoaDonNhap(hdx);
				break;
			}else {
				System.out.println("!!!!!!!!Hoa don sua co ma bi trung voi hoa don truoc do, vui long nhap lai!!!!!!!!");
			}
			
		}
	}	

	public void sua(String mahd, String masp) throws Exception{
		sua(tim(mahd,masp));
	}
	public void sua() throws Exception{
		String mahd;
		String masp;
		System.out.println("Nhap vao ma hoa don va ma san pham de tim dung chi tiet hoa don xuat can sua");
		System.out.println("Nhap ma hoa don: ");
		mahd = in.nextLine();
		System.out.println("Nhap ma san pham: ");
		masp = in.nextLine();
		sua(tim(mahd,masp));
	}
	/*==========DELETE=========*/
	public void xoa() 
	{	
		System.out.println("Xoa hoa don\n");	
		System.out.println("- Nhap ma hoa don va ma san pham de xoa chinh xac chi tiet hoa don: ");
		System.out.print(" . Nhap ma hoa don: ");
		String mahd = in.nextLine();
		System.out.print(" . Nhap ma san pham: ");
		String masp = in.nextLine();
		int vt = this.tim(mahd,masp);		
		if (vt == -1) 
		{
			
			System.out.println("Hoa don khong ton tai! Xoa that bai!");
			System.out.println("---------------------------------------------------------------------------------");
			return;
		}	
		for(int i = vt; i < this.soluong - 1; i++)
			this.ds[i] = this.ds[i+1];		
		this.soluong--;		
		System.out.println("Xoa thanh cong!");
		System.out.println("---------------------------------------------------------------------------------");
	}
	public void xoa(int x) {
		if(x==-1 || x >= soluong) return;
		for(int i = x; i < this.soluong - 1; i++)
			this.ds[i] = this.ds[i+1];
		ds = Arrays.copyOf(ds, soluong  -1 );
		soluong -= 1;
	}
	public void xoa(String mahd, String masp) {
		xoa(tim(mahd,masp));
	}
	public void xoa(String mahd) {
		for(int j = 0; j < soluong; j++) {
			for(int i = 0; i < soluong; i++) {
				if(ds[i].getMahd().equals(mahd) == true) {
					xoa(i);
					break;
				}
			}
		}
	}
	public void title() {
		System.out.println("+----------+----------+------------+------------+-------+");
		System.out.printf("| %-8s | %-8s | %-10s | %-10s | %-5s|\n","Ma Hd","Ma Sp","Don Gia","Thanh Tien","Sluong");
		System.out.println("+----------+----------+------------+------------+-------+");
		
	}
	/*==========STATISTIC==========*/
	//thong ke theo ma san pham ma chi tiet oa dons
	public void thongke() {
		System.out.println("Ban muon thong ke theo ma san pham hay ma hoa don?");
		System.out.println("1: Ma san pham");
		System.out.println("2: Ma hoa don");
		String masp = "";
		String mahd = "";
		int check;
		do {
			check = in.nextInt();
			in.nextLine();
		}while(check != 1 && check != 2);
		if(check == 1) {
			System.out.print("Nhap vao ma san phan: ");
			masp = in.nextLine();
		}else {
			System.out.print("Nhap vao ma hoa don: ");
			mahd = in.nextLine();
		}
		title();
		boolean isEmpty = true;
		for(int i=0;i<soluong ;i++) {
			//print all row which match masp
			if(check == 1) {
				if(ds[i].getMasp().equals(masp)) {
					isEmpty = false;
					ds[i].xuat();
				}
			}else {	//print all row which match mahd
				if(ds[i].getMahd().equals(mahd)) {
					isEmpty = false;
					ds[i].xuat();
				}
			}
		}
		if(isEmpty) {
			System.out.println("Chi tiet hoa don xuat khong ton tai. ");
		}
	}
	//thong ke theo don gia
	public void thongKeTheoDonGia(int from, int to) {
		boolean check = true;
		title();
		for(int i=0;i<soluong ;i++) {
			if(ds[i].getDongia() >= from && ds[i].getDongia() <= to) {
				check = false;
				ds[i].xuat();
			}				
		}
		if(check) System.out.println("Chi tiet hoa don khong ton tai. ");
	}
	public void thongKeTheoDonGia() {
		System.out.print("Don gia tu: ");
		int from = in.nextInt();
		System.out.print("Den: ");
		int to = in.nextInt();
		thongKeTheoDonGia(from,to);
	}
	//
	//thong ke theo so luong
	public void thongKeTheoSoLuong(int from, int to) {
		boolean check = true;
		title();
		for(int i=0;i<soluong ;i++) {
			if(ds[i].getSoluong() >= from && ds[i].getSoluong() <= to) {
				check = false;
				ds[i].xuat();
			}				
		}
		if(check) System.out.println("Chi tiet hoa don khong ton tai. ");
	}
	public void thongKeTheoSoLuong() {
		System.out.print("So luong tu: ");
		int from = in.nextInt();
		System.out.print("Den: ");
		int to = in.nextInt();
		thongKeTheoSoLuong(from, to);
	}
	
	//thong ke theo thanh tien
	public void thongKeTheoThanhTien(int from, int to) {
		boolean check = true;
		title();
		for(int i=0;i<soluong ;i++) {
			if(ds[i].getThanhtien() >= from && ds[i].getThanhtien() <= to) {
				check = false;
				ds[i].xuat();
			}				
		}
		if(check) System.out.println("Chi tiet hoa don khong ton tai. ");
	}
	public void thongKeTheoThanhTien() {
		System.out.print("Thanh tien tu: ");
		int from = in.nextInt();
		System.out.print("Den: ");
		int to = in.nextInt();
		thongKeTheoThanhTien(from, to);
	}
	
	//doc va ghi file
	public void ghiFile(String name) throws IOException{
		DataOutputStream fo = null;
		try {
			fo = new DataOutputStream(new FileOutputStream(name));
			for(int i=0; i<soluong; i++)
			{
				ds[i].ghiFile(name);
			}
		}catch(Exception e) {}
		finally {
			fo.close();
		}
	}
	public void docFile(String name) throws IOException{
		DataInputStream fi = null;
		int i = 0;
		try {
			fi = new DataInputStream(new FileInputStream(name));
			while(true) {
				ds[i] = new ChiTietHoaDonNhap();
				ds[i].setMahd(fi.readUTF());
				ds[i].setMasp(fi.readUTF());
				ds[i].setDongia(fi.readInt());
				ds[i].setSoluong(fi.readInt());
				ds[i].setThanhtien(fi.readInt());
				i += 1;
			}
		}catch(Exception e) {}
		finally {
			this.soluong = i;
			fi.close();
		}
	}
	public int tinhTienTheoMahd(String mahd) throws IOException{
		int tongtien = 0;
		for(int i = 0; i < soluong; i++) {
			if(ds[i].getMahd().equals(mahd) == true) {
				tongtien += (ds[i].getDongia() * ds[i].getSoluong());
			}
		}
		return tongtien;
	}
	
}
