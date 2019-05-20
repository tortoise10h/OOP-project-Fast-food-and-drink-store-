package fastfoodanddrinkstore;

import java.io.*;
import java.util.*;

interface IDSKhuyenMai{
	public void nhap()throws Exception;
	public void xuat();
	public void docFile(String fileName) throws IOException;
	public void ghiFile(String fileName) throws IOException;
}

public class DSKhuyenMai implements IDSKhuyenMai{
	
	Scanner sc = new Scanner(System.in);
	private int soluong;
	private KhuyenMai[] ds;
	
	/*==========GETTER SETTER===========*/
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public KhuyenMai[] getDs() {
		return ds;
	}
	public void setDs(KhuyenMai[] ds) {
		this.ds = ds;
	}
	
	/*============CONSTRUCTOR==========*/
	public DSKhuyenMai() {	
		ds = new KhuyenMai[100];
	}
	public DSKhuyenMai(int soluong, KhuyenMai[] ds) {
		this.soluong = soluong;
		this.ds = ds;
	}
	public DSKhuyenMai(DSKhuyenMai ds) {
		this(ds.soluong, ds.ds);
	}
	public DSKhuyenMai(int n) {
		soluong = n;
		ds = new KhuyenMai[n];
	}
	/*===========INPUT & OUTPUT===========*/
	//nhap 
	public void nhap() throws Exception{
		do{
			System.out.print("Nhap so luong:");
			soluong = sc.nextInt();
			sc.nextLine();
		}while(soluong <= 0);
		ds = new KhuyenMai[soluong];
		System.out.println("Nhap danh sach khuyen mai:");
		for(int i=0 ;i < soluong; i++) {
			System.out.println("Khuyen mai " + (i+1));
			ds[i] = new KhuyenMai();
			ds[i].nhap();
		}
	}
	
	//xuat
	public void xuat() {
		System.out.println("Danh sach khuyen mai: ");
		System.out.println("+-------+--------------------------------------------------------------+------------+------------+");
		System.out.println("| ma km |                  Mo ta chuong trinh khuyen mai               | Ngay Bdau  | Ngay Kthuc |");
		System.out.println("+-------+--------------------------------------------------------------+------------+------------+");
		for(int i=0;i<soluong; i++) {
			ds[i].xuat();
		}
	}
	
	//them khuyen mai
	public void them() throws Exception{
		System.out.println("Nhap vao thong tin cua chuong trinh khuyen mai moi ");
        KhuyenMai km = new KhuyenMai();
        String makm;
        while(true) {
        	do{
    			System.out.print("- Nhap ma khuyen mai (5 ki tu): ");
    			makm = sc.nextLine();
    		}while(makm.length()!=5);
            //check duplicate makm
            boolean isDuplicate = false;
            for(int i = 0; i < soluong; i++) {
            	if(ds[i].getMakm().equals(makm) == true) {
            		isDuplicate = true;
            	}
            }
            if(isDuplicate == false) {
            	break;
            }else {
            	System.out.println("\n!!!Ma khuyen mai bi trung, xin moi nhap lai!!!\n");
            }
        }
        
        km.nhap(makm);
        
    	ds = Arrays.copyOf(ds, soluong + 1);
        soluong += 1;
        ds[soluong - 1] = new KhuyenMai();
        ds[soluong - 1] = km;
        System.out.println("\n!!!Them chuong trinh khuyen mai moi thanh cong!!!\n");
	}
	
	public void them(KhuyenMai km) {
		ds = Arrays.copyOf(ds, soluong + 1);
		ds[soluong] = new KhuyenMai(km);
		soluong += 1;
	}
	
	//them nhieu khuyen mai
	public void them(int soluong) throws Exception{
		System.out.println("Nhap vao thong tin cua cac chuong trinh khuyen mai moi");
    	int oldLength = this.soluong;
    	this.soluong += soluong;
    	ds = Arrays.copyOf(ds, this.soluong);
    	for(int i= oldLength; i < this.soluong; i++) {
    		System.out.println("\n* Them vao chuong trinh khuyen mai thu " + (i-oldLength+1));
            KhuyenMai km = new KhuyenMai();
            String makm;
            while(true) {
            	do{
        			System.out.print("- Nhap ma khuyen mai (5 ki tu): ");
        			makm = sc.nextLine();
        		}while(makm.length()!=5);
                //check duplicate makm
                boolean isDuplicate = false;
                for(int j = 0; j < i; j++) {
                	if(ds[j].getMakm().equals(makm) == true) {
                		isDuplicate = true;
                	}
                }
                if(isDuplicate == false) {
                	break;
                }else {
                	System.out.println("Ma khuyen mai bi trung, xin moi nhap lai!!!\n");
                }
            }
            
            km.nhap(makm);
        	ds[i] = new KhuyenMai(km);
    	}
    	System.out.println("\n!!!Them thanh cong!!!\n");
	}
	/*==========SEARCH==========*/
	//tim khuyen mai
	public int tim() {
		String Tma = "";
		System.out.print("Nhap vao ma cua dot khuyen mai can tim: ");
		Tma = sc.nextLine();
		return tim(Tma);
	}
	
	public int tim(String ma) {
		for(int i=0;i<soluong; i++) {
			if(ds[i].getMakm().equals(ma) == true)
				return i;
		}
		return -1;
	}
	
	/*===========DELETE==========*/
	//Xoa khuyen mai
	public void xoa() throws Exception{
		String Tma = "";
		System.out.print("Nhap ma cua chuong trinh khuyen mai can xoa: ");
		Tma = sc.nextLine();
		xoa(Tma);
	}
			
	public void xoa(String ma) throws Exception{
		//when delete khuyenmai we will delete all thongtinkhuyenmai which have same makm too
		//get thongtinkhuyenmai to delete 
    	DSThongTinKhuyenMai ttkm = new DSThongTinKhuyenMai();
    	ttkm.docFile("src/thongtinkhuyenmai.txt");
    	
		int pos = tim(ma);
		if(pos == -1) {
			System.out.println("\n!!!Khong tim thay chuong trinh khuyen mai can xoa!!!\n");
		}else {
			for(int i = pos; i < soluong - 1; i++) {
				ds[i] = ds[i+1];
			}
			ds = Arrays.copyOf(ds, soluong - 1);
			soluong -= 1;
			ttkm.xoa(ma);
			ttkm.ghiFile("src/thongtinkhuyenmai.txt");
			System.out.println("\n!!!Xoa thanh cong!!!\n");
		}
	}
	
	/*==========ADJUST=========*/
	//sua khuyen mai
	public void sua(String makm) throws Exception{
		//get thongtinkhuyenmai
    	DSThongTinKhuyenMai ttkm = new DSThongTinKhuyenMai();
    	ttkm.docFile("src/thongtinkhuyenmai.txt");
    	
    	int pos = tim(makm);	//position of khuyenmai that need to fix
    	
    	if(pos == -1) {
    		System.out.println("\n!!!Khong tim thay san pham can sua!!!\n");
    	}else {
    		//delete all thongtinkhuyenmai because I was writen on file and will duplicate with new information
        	ttkm.xoa(makm);
        	ttkm.ghiFile("src/thongtinkhuyenmai.txt");
        	
    		System.out.println("Moi ban nhap lai thong tin moi cua chuong trinh khuyen mai nay:");
        	//use temporary variable type HoaDonXuat to check id of new 'khuyen mai'
        	KhuyenMai km = new KhuyenMai();
        	String newMakm;
        	while(true) {
            	do{
        			System.out.print("- Nhap ma khuyen mai (5 ki tu): ");
        			newMakm = sc.nextLine();
        		}while(newMakm.length()!=5);
                //check duplicate makm
                boolean isDuplicate = false;
                for(int i = 0; i < soluong; i++) {
                	if(ds[i].getMakm().equals(newMakm) == true && i != pos) {
                		isDuplicate = true;
                	}
                }
                if(isDuplicate == false) {
                	break;
                }else {
                	System.out.println("Ma khuyen mai bi trung, xin moi nhap lai!!!\n");
                }
            }
        	km.nhap(newMakm);
        	ds[pos] = new KhuyenMai(km);
        	System.out.println("\n!!!Sua thanh cong!!!\n");
    	}
	}	
	
	
	public void sua() throws Exception{
		System.out.println("Nhap ma cua chuong trinh khuyen mai can sua: ");
		String tem = sc.nextLine();
		sua(tem);
	}
	/*===========STATISTIC==========*/
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
	public boolean checkThongKe(String[] d1, String[] d2,int i) {
		String[] ds1 = ds[i].getNgbd().split("/");
		String[] ds2 = ds[i].getNgkt().split("/");
		if(sosanh(ds1,d1) && sosanh(ds2,d2)==false)
			return true;
		else return false;
	}
	
	//thong ke theo ngay thang
	public void thongke(String d1, String d2) {
		String[] inpNgBd = d1.split("/");	//user input sale start time
		String[] inpNgKt = d2.split("/");	//user input sale end time
		
		if(inpNgBd.length != 3 || inpNgKt.length != 3) {
			System.out.println("Khuyen mai khong ton tai.");
			return;
		}
		boolean check = false;
		System.out.println("+-------+--------------------------------------------------------------+------------+------------+");
		System.out.println("| ma km |                  Mo ta chuong trinh khuyen mai               | Ngay Bdau  | Ngay Kthuc |");
		System.out.println("+-------+--------------------------------------------------------------+------------+------------+");
		for(int i=0; i< soluong; i++ ) {
//			System.out.println(ds[i].getNgbd() + "  " + ds[i].getNgkt());
			//get each sale
			String[] dsNgBd = ds[i].getNgbd().split("/"); //given sale start time
			String[] dsNgKt = ds[i].getNgkt().split("/"); //given sale end time
			
			if(Integer.parseInt(inpNgBd[2]) >= Integer.parseInt(dsNgBd[2]) && Integer.parseInt(inpNgBd[2]) <= Integer.parseInt(dsNgKt[2]) && 
			   Integer.parseInt(inpNgBd[2]) <= Integer.parseInt(inpNgKt[2]) && Integer.parseInt(inpNgKt[2]) <= Integer.parseInt(dsNgKt[2])) {
				if(Integer.parseInt(inpNgBd[1]) >= Integer.parseInt(dsNgBd[1]) && Integer.parseInt(inpNgKt[1]) <= Integer.parseInt(dsNgKt[1])){
					if(Integer.parseInt(inpNgBd[0]) >= Integer.parseInt(dsNgBd[0]) && Integer.parseInt(inpNgKt[0]) <= Integer.parseInt(dsNgKt[0])) {
						check = true;
						ds[i].xuat();
					}
				}
			}
		}
		if(check == false) {
			System.out.println("\n!!!Khuyen mai khong ton tai!!!\n");
		}
	}
	
	public void thongKeTheoNgayThang() {
		String t1,t2;
		System.out.print("Nhap ngay bat dau (Theo dinh dang dd/mm/yyyy): ");
			t1 = sc.nextLine();
		System.out.print("Nhap ngay ket thuc (Theo dinh dang dd/mm/yyyy):  ");
			t2 = sc.nextLine();
		thongke(t1,t2);
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
				ds[i] = new KhuyenMai();
				ds[i].setMakm(fi.readUTF());
				ds[i].setMota(fi.readUTF());
				ds[i].setNgbd(fi.readUTF());
				ds[i].setNgkt(fi.readUTF());
				i += 1;
			}
		}catch(Exception e) {}
		finally {
			soluong = i;
			fi.close();
		}
	}
	
	
	
	//thong ke
//	public void abc(String t1, String t2) {
//		String[] inpNgBd = t1.split("/");
//		String[] inpNgKt = t2.split("/");
//		if(inpNgBd.length != 3 || inpNgKt.length != 3) {
//			System.out.println("Khuyen mai nay khong ton tai");
//		}
//		boolean check = false;
//		for(int i = 0; i < soluong; i++) {
//			String[] dsNgBd = ds[i].getNgbd().split("/");
//			String[] dsNgKt = ds[i].getNgkt().split("/");
//			if(Integer.parseInt(inpNgBd[2]) <= Integer.parseInt(dsNgBd[2]) && Integer.parseInt(inpNgBd[2]) <= Integer.parseInt(dsNgKt[2]) &&
//			  Integer.parseInt(inpNgBd[2]) <= Integer.parseInt(inpNgKt[2]) && Integer.parseInt(inpNgKt[2]) <= Integer.parseInt(dsNgKt[2])) {
//				if(Integer.parseInt(inpNgBd[1]) >= Integer.parseInt(dsNgBd[1]) && Integer.parseInt(inpNgKt[1]) <= Integer.parseInt(dsNgKt[1])) {
//					if(Integer.parseInt(inpNgBd[0]) >= Integer.parseInt(dsNgBd[0]) && Integer.parseInt(inpNgKt[0]) <= Integer.parseInt(dsNgKt[0])) {
//						check = true;
//						ds[i].xuat();
//					}
//				}
//			}
//		}
//		if(check == false) {
//			System.out.println("Khuyen mai nay khong ton tai");
//		}
//	}
//	public void abc() {
//		String t1;
//		String t2;
//		System.out.print("Nhap vao ngay bat dau (theo dinh dang dd/mm/yyyy): ");
//		t1 = sc.nextLine();
//		System.out.print("Nhap vao ngay ket thuc (theo dinh dang dd/mm/yyyy): ");
//		t2 = sc.nextLine();
//		abc(t1,t2);
//	}
	
	
	
	
}
