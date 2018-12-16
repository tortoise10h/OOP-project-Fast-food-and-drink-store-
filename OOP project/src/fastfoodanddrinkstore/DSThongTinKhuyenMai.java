package fastfoodanddrinkstore;

import java.io.*;
import java.util.*;
interface IDSThongTinKhuyenMai{
	public void nhap()throws Exception;
	public void xuat();
	public void docFile(String fileName) throws IOException;
	public void ghiFile(String fileName) throws IOException;
}
public class DSThongTinKhuyenMai implements IDSThongTinKhuyenMai{
	Scanner sc=  new Scanner(System.in);
	private int soluong;
	private ThongTinKhuyenMai[] ds;
	
	/*==========GETTER SETTER==========*/
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public ThongTinKhuyenMai[] getDs() {
		return ds;
	}
	public void setDs(ThongTinKhuyenMai[] ds) {
		this.ds = ds;
	}
	
	//constructor
	public DSThongTinKhuyenMai() {
		ds = new ThongTinKhuyenMai[100];
	}
	public DSThongTinKhuyenMai(int soluong, ThongTinKhuyenMai[] ds) {
		this.soluong = soluong;
		this.ds = ds;
	}
	public DSThongTinKhuyenMai(DSThongTinKhuyenMai ds) {
		this(ds.soluong, ds.ds);
	}
	
	/*==========INPUT & OUTPUT=========*/
	public void nhap() throws Exception{
		do{
			System.out.print("Nhap so luong:");
			soluong = sc.nextInt();
		}while(soluong <= 0);
		ds = new ThongTinKhuyenMai[soluong];
		System.out.println("Nhap danh sach thong tin khuyen mai:");
		for(int i=0 ;i < soluong; i++) {
			System.out.println("Thong tin khuyen mai " + (i+1));
			ds[i] = new ThongTinKhuyenMai();
			ds[i].nhap();
		}
	}
	
	public void xuat() {
		System.out.println("Danh sach thong tin khuyen mai");
		System.out.println("+----------+----------+------+-------------------------------------+");
		System.out.println("|   Ma km  |   Masp   |%Giam |               Qua tang              |");
		System.out.println("+----------+----------+------+-------------------------------------+");
		for(int i=0;i<soluong; i++) {
			ds[i].xuat();
		}
	}
	public void xuat(int i) {
		ds[i].xuat();
	}
	
	/*==========ADD==========*/
	public void them()throws Exception{
		while(true) {
			ThongTinKhuyenMai ttTemp = new ThongTinKhuyenMai();
			System.out.println("Nhap vao thong tin cua thong tin khuyen mai moi: ");
			ttTemp.nhap();
			if(tim(ttTemp.getMakm(),ttTemp.getMasp()) == -1) {
				ds = Arrays.copyOf(ds,soluong + 1);
				ds[soluong] = new ThongTinKhuyenMai();
				ds[soluong] = ttTemp;
				soluong += 1;
				break;
			}else {
				System.out.println("Thong tin khuyen mai moi co ma san pham va ma khuyen mai trung voi thong tin khuyen mai truoc do, xin moi nhap lai!!!");
			}
			
		}
	}
	public void them(ThongTinKhuyenMai km) {
		ds = Arrays.copyOf(ds, soluong + 1);
		ds[soluong] = new ThongTinKhuyenMai(km);
		soluong += 1;
	}
	//them nhieu khuyen mai
	public void them(int sl, String makm) throws Exception {
		//get all product to compare
		DSSanPham dsSp = new DSSanPham();
		dsSp.docFile("src/sanpham.txt");
		
		System.out.println("Nhap vao thong tin cua cac thong tin khuyen mai");
    	int oldLength = this.soluong;
    	this.soluong += sl;
    	ds = Arrays.copyOf(ds, this.soluong);
    	for(int i= oldLength; i < this.soluong; i++) {
    		System.out.println("\n# Nhap vao thong tin khuyen mai thu " + (i-oldLength+1));
    		ThongTinKhuyenMai kmTemp = new ThongTinKhuyenMai();
    		String masp;
    		while(true) {
    			while(true) {
    				do {
            			System.out.print("- Nhap vao ma san pham(5 ky tu): ");
            			masp = sc.nextLine();
            		}while(masp.length() != 5);
    				if(dsSp.timKiem(masp) != -1) {
    					break;
    				}else {
    					System.out.println("\n!!!San pham nay khong ton tai, xin moi nhap lai!!!\n");
    				}
    			}
    			//check duplicate masp
                boolean isDuplicate = false;
                for(int j = 0; j < i; j++) {
                	if(ds[j].getMasp().equals(masp) == true && ds[j].getMakm().equals(makm) == true) {
                		isDuplicate = true;
                	}
                }
                if(isDuplicate == false) {
                	break;
                }else {
                	System.out.println("\n!!!Thong tin khuyen mai bi trung, xin moi nhap lai!!!\n");
                }
    		}
    		kmTemp.nhap(makm, masp);
    		ds[i] = new ThongTinKhuyenMai(kmTemp);
    	}
	}
		
	/*==========SEARCH=========*/
	//tim bang ma khuyen mai va ma san pham hoac qua tang
	public int tim(String makm, String masp) {
		for(int i=0;i<soluong; i++) {
			if(ds[i].getMakm().toLowerCase().equals(makm.toLowerCase()) == true && ds[i].getMasp().toLowerCase().equals(masp.toLowerCase()) == true) 
				return i;
		}
		return -1;
	}
	public int tim() {
		String temKm;
		String temSp;
		System.out.println("- Nhap vao ma khuyen mai va ma san pham de tim chinh xac thong tin khuyen mai ban can");
		do {
			System.out.print(" . Nhap ma khuyen mai cua thong tin khuyen mai can tim: ");
			sc.nextLine();
			temKm = sc.nextLine();
		}while(temKm.length() != 5);
		do {
			System.out.print(" . Nhap ma san pham cua thong tin khuyen mai can tim: ");
			sc.nextLine();
			temSp = sc.nextLine();
		}while(temKm.length() != 5);
		return tim(temKm, temSp);
	}
	
	//tim bang phan tram qua tang
	public int tim(int x) {
		for(int i=0;i<soluong;i++) {
			if(ds[i].getPercent() == x)
				return i;
		}
		return -1;
	}
	
	/*==========DELETE=========*/
	public void xoa(int x) {
		for(int i=x;i<soluong-1;i++)
			ds[i]=ds[i+1];
		ds = Arrays.copyOf(ds,soluong-1);
		soluong += -1;
	}
	public void xoa() {
		String temKm;
		String temSp;
		System.out.println("- Nhap vao ma khuyen mai va ma san pham cua thong tin khuyen mai can xoa: ");
		do {
			System.out.println(" . Nhap ma km cua thong tin khuyen mai can xoa(5 ki tu): ");
			temKm = sc.nextLine();
		}while(temKm.length() != 5);
		do {
			System.out.println(" . Nhap ma km cua thong tin khuyen mai can xoa(5 ki tu): ");
			temSp = sc.nextLine();
		}while(temSp.length() != 5);
		
		xoa(temKm, temSp);
	}
	//xoa bang ma khuyen mai hoac ma san pham
	public void xoa(String makm, String masp) {
		while(tim(makm, masp) != -1)
			xoa(tim(makm,masp));
	}
	//xoa cac thong tin khuyen mai co cung ma khuyen mai
	public void xoa(String makm) {
		for(int j = 0; j < soluong; j++) {
			for(int i = 0; i < soluong; i++) {
				if(ds[i].getMakm().equals(makm) == true) {
					xoa(i);
					break;
				}
			}
		}
	}
	//sua thong tin
	public void sua(int x) throws Exception{
		ThongTinKhuyenMai km = new ThongTinKhuyenMai();
		while(true) {
			System.out.println("Nhap vao thong tin can chinh sua: ");
			km.nhap();
			if(tim(km.getMakm(),km.getMasp()) == -1 || tim(km.getMakm(),km.getMasp()) == x) {
				ds[x] = new ThongTinKhuyenMai(km);
				break;
			}else {
				System.out.println("Ma bi trung, xin moi nhap lai thong tin!!!");
			}
		}
	}	
	
	public void sua(String makm, String masp)throws Exception {
		sua(tim(makm,masp));
	}
	public void sua() throws Exception{
		String temKm;
		String temSp;
		do {
			System.out.println("Nhap ma km cua thong tin khuyen mai can sua(5 ki tu): ");
			temKm = sc.nextLine();
		}while(temKm.length() != 5);
		do {
			System.out.println("Nhap ma km cua thong tin khuyen mai can sua(5 ki tu): ");
			temSp = sc.nextLine();
		}while(temSp.length() != 5);
		sua(tim(temKm,temSp));
	}
	
	
	//thong ke
	public void thongke(String ma, int category) {
		//category is variable for check statistic by makm or masp
		boolean check = true;
		System.out.println("+----------+----------+------+-------------------------------------+");
		System.out.println("|   Ma km  |   Masp   |%Giam |               Qua tang              |");
		System.out.println("+----------+----------+------+-------------------------------------+");
		for(int i = 0; i < soluong; i++) {
			if(category == 1) {
				if(ds[i].getMakm().equals(ma) == true) {
					check = false;
					ds[i].xuat();
				}
			}else {
				if(ds[i].getMasp().equals(ma) == true) {
					check = false;
					ds[i].xuat();
				}
			}
		}
		if(check) System.out.println("\n!!!Thong tin khuyen mai khong ton tai!!!\n");
	}
	public void thongke() {
		String tem;
		int check;
		do {
			System.out.println("Chon muc ma ban muon thong ke: ");
			System.out.println(" 1. Thong ke theo ma khuyen mai");
			System.out.println(" 2. Thong ke theo ma san pham");
			check = sc.nextInt();
			sc.nextLine();
		}while(check != 1 && check != 2);
		do {
			if(check == 1) {
				System.out.print("Nhap vao ma khuyen mai (5 ky tu): ");
			}else {
				System.out.print("Nhap vao ma san pham (5 ky tu): ");
			}
			tem = sc.nextLine();
		}while(tem.length() != 5);
		thongke(tem,check);
	}
	
	public boolean sosanh(String[] d1, String d2[]) {
		if(d1[2].compareTo(d2[2]) > 0) return true;
		else if(d1[2].compareTo(d2[2]) < 0) return false;
		else {
			if(d1[1].compareTo(d2[1]) > 0) return true;
			else if(d1[1].compareTo(d2[1]) < 0) return false;
			else {
				if(d1[0].compareTo(d2[0]) > 0) return true;
				else if(d1[0].compareTo(d2[0]) < 0) return false;
				else return true;
			}
		}
	}
	
	
	
	
	//thong ke theo qua tang co hay khong
	public void thongkeTheoQuaTang() {
		System.out.println("+----------+----------+------+-------------------------------------+");
		System.out.println("|   Ma km  |   Masp   |%Giam |               Qua tang              |");
		System.out.println("+----------+----------+------+-------------------------------------+");
		for(int i=0;i<soluong;i++)
			if(ds[i].getQua().equals("khong") == false)
				ds[i].xuat();
	}
	
	//thong ke theo phan tram
	public void thongKeTheoPhanTram(int d1, int d2) {
		System.out.println("+----------+----------+------+-------------------------------------+");
		System.out.println("|   Ma km  |   Masp   |%Giam |               Qua tang              |");
		System.out.println("+----------+----------+------+-------------------------------------+");
		for(int i=0;i<soluong;i++)
			if(ds[i].getPercent() >= d1 && ds[i].getPercent() <= d2)
				ds[i].xuat();
	}
	
	public void thongKeTheoPhanTram() {
		System.out.print("Pham tram giam gia tu: ");
		int from = sc.nextInt();
		System.out.print("Den: ");
		int to = sc.nextInt();
		thongKeTheoPhanTram(from, to);
	}
	//Doc file ghi file
	public void ghiFile(String name) throws IOException{
		DataOutputStream fo = null;
		try {
			fo = new DataOutputStream(new FileOutputStream(name));
			for(int i=0;i<soluong; i++) {
				ds[i].ghifile(name);
			}
			
		}catch(Exception e) {}
		
		finally {
			fo.close();
		}
		
	}
	
	public void docFile(String name) throws IOException{
		DataInputStream fi =null;
		int i=0;
		try {
			fi = new DataInputStream(new FileInputStream(name));
			while(true) {
				ds[i] = new ThongTinKhuyenMai();
				ds[i].setMakm(fi.readUTF());
				ds[i].setMasp(fi.readUTF());
				ds[i].setPercent(fi.readInt());
				ds[i].setQua(fi.readUTF());
				i += 1;
			}
		}catch(Exception e) {}
		finally {
			this.soluong = i;
			fi.close();
		}
	}
		
		
}