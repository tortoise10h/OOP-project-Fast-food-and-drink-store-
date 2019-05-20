package fastfoodanddrinkstore;

import java.util.*;
import java.io.*;

public class ChiTietHoaDonXuat {
	Scanner sc = new Scanner(System.in);
	private String mahd;
	private String masp;
	private int dongia;
	private int soluong;
	private int thanhtien;
	private String makm;
	
	//Constructor;
	public ChiTietHoaDonXuat() {
		
	}
	public ChiTietHoaDonXuat(String mahd, String masp, int soluong, String makm)throws IOException {
		this.mahd = mahd;
		this.masp = masp;
		this.dongia = getDonGiaSp();
		this.soluong = soluong;
		this.makm = makm;
		this.thanhtien = (soluong * dongia) - ((soluong * dongia * getPtramGiamGia()) / 100);
	}
	
	public ChiTietHoaDonXuat(ChiTietHoaDonXuat hd)throws IOException {
		this.mahd = hd.mahd;
		this.masp = hd.masp;
		this.dongia = getDonGiaSp();
		this.soluong = hd.soluong;
		this.makm = hd.makm;
		this.thanhtien = (hd.soluong * hd.dongia) - (hd.soluong * hd.dongia * getPtramGiamGia()) / 100;
	}
	//GETTER SETTER
	public String getMahd() {
		return mahd;
	}
	public void setMahd(String mahd) {
		this.mahd = mahd;
	}
	public String getMakm() {
		return makm;
	}
	public void setMakm(String makm) {
		this.makm = makm;
	}
	
	public String getMasp() {
		return masp;
	}
	public void setMasp(String masp) {
		this.masp = masp;
	}


	public int getDongia() {
		return dongia;
	}


	public void setDongia(int dongia) {
		this.dongia = dongia;
	}


	public int getThanhtien() {
		return thanhtien;
	}


	public void setThanhtien(int thanhtien) {
		this.thanhtien = thanhtien;
	}


	public int getSoluong() {
		return soluong;
	}


	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	//tinh tong tien sau giam gia (neu co)
	public int getPtramGiamGia() throws IOException{
		//lay danh sach thong tin khuyen mai
		DSThongTinKhuyenMai ttkm = new DSThongTinKhuyenMai();
		ttkm.docFile("src/thongtinkhuyenmai.txt");
		ThongTinKhuyenMai[] ttkmList = ttkm.getDs();
		
		//lay phan tram khuyen mai tu cac thong tin khuyen mai
		int ptramKhuyenMai;
		if(ttkm.tim(makm, masp) == -1) {
			ptramKhuyenMai = 0;
		}else {
			ptramKhuyenMai = ttkmList[ttkm.tim(makm, masp)].getPercent();
		}
		return ptramKhuyenMai;
	}
	//get don gia cua san pham tu ma san pham
	public int getDonGiaSp() throws IOException{
		//get danh sach cac san pham
		DSSanPham sp = new DSSanPham();
		sp.docFile("src/sanpham.txt");
		SanPham[] spList = sp.getDs();
		
		//get don gia tu masp
		int dongiaSp = spList[sp.timKiem(masp)].getGia();
	
		return dongiaSp;
	}
	/*==========INPUT & OUTPUT==========*/
	public void nhap() throws IOException{
		
		do {
			System.out.print("- Nhap ma hoa don(5 ki tu): ");
			this.setMahd(sc.nextLine());
		}while(mahd.length()!=5);
		
		do {
			System.out.print("- Nhap ma san pham(5 ki tu): ");
			this.setMasp(sc.nextLine());
		}while(masp.length()!=5);
		
		dongia = getDonGiaSp();
		
		do{
			System.out.print("- Nhap so luong: ");
			this.setSoluong(sc.nextInt());
		}while(soluong <= 0);
		
		do {
			System.out.print("- Nhap ma khuyen mai(5 ki tu): ");
			makm = sc.nextLine();
		}while(makm.length()!=5);
		
		thanhtien = (soluong * dongia) - (soluong * dongia * getPtramGiamGia()) / 100;
	}
	public void nhap(String mahd, String makm)throws IOException {
		//get all product to check input
		DSSanPham dsSp = new DSSanPham();
		dsSp.docFile("src/sanpham.txt");
		SanPham[] listSp = dsSp.getDs();
		
		this.mahd = mahd;
		this.makm = makm;
		
		while(true) {
			do {
				System.out.print(" . Nhap ma san pham(5 ki tu): ");
				masp = sc.nextLine();
			}while(masp.length()!=5);
			if(dsSp.timKiem(masp) != -1) {
				break;
			}else {
				System.out.println("\n!!!San pham khong ton tai, xin moi nhap lai!!!\n");
			}
		}
		
		dongia = getDonGiaSp();
		
		//handle quantity input
		//check quantity input
		int pos = dsSp.timKiem(masp);
		int oldQuantity = listSp[pos].getSoluongco();		//save old quantity to calculate new quantity after user input
		
		while(true) {
			do{
				System.out.print(" . Nhap so luong: ");
				soluong = sc.nextInt();
				sc.nextLine();
			}while(soluong <= 0);
			if(soluong > oldQuantity) {
				System.out.println("\n!!!So luong ban can mua lon hon so luong hien co cua san pham!!!\n");
			}else {
				break;
			}
			
		}
		
		//reduce quanitty of product
		
		listSp[pos].setSoluongco(oldQuantity - soluong);
		
		thanhtien = (soluong * dongia) - ((soluong * dongia * getPtramGiamGia()) / 100);
		
		dsSp.ghiFile("src/sanpham.txt");

	}
	
	
	public void xuat() {
		System.out.printf("| %-8s | %-8s | %-10d | %-10d | %-5d |\n", this.mahd, this.masp, this.dongia,  this.thanhtien, this.soluong);
		System.out.println("+----------+----------+------------+------------+-------+");
	}
	/*==========WRITE FILE==========*/
	public void ghiFile(String fileName) throws IOException{
		DataOutputStream out = null;
		try {
			out = new DataOutputStream(new FileOutputStream(fileName, Boolean.TRUE));
			out.writeUTF(mahd);
			out.writeUTF(masp);
			out.writeInt(dongia);
			out.writeInt(soluong);
			out.writeInt(thanhtien);
		}catch(IOException e) {}
		finally {
			out.close();
		}
	}
	
	
	
	
}
