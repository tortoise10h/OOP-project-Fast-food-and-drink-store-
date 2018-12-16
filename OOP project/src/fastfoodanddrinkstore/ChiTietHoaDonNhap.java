	package fastfoodanddrinkstore;

import java.util.*;
import java.io.*;

public class ChiTietHoaDonNhap {
	Scanner sc = new Scanner(System.in);
	private String mahd;
	private String masp;
	private int dongia;
	private int soluong;
	private int thanhtien;
	
	//Constructor;
	public ChiTietHoaDonNhap() {
		
	}
	public ChiTietHoaDonNhap(String mahd, String masp, int soluong)throws IOException {
		this.mahd = mahd;
		this.masp = masp;
		this.dongia = getDonGiaSp();
		this.soluong = soluong;
		this.thanhtien = (soluong * dongia) - ((soluong * dongia * 45) / 100 );
	}
	
	public ChiTietHoaDonNhap(ChiTietHoaDonNhap hd)throws IOException {
		this.mahd = hd.mahd;
		this.masp = hd.masp;
		this.dongia = getDonGiaSp();
		this.soluong = hd.soluong;
		this.thanhtien = (soluong * dongia) - ((soluong * dongia * 45) / 100 );
	}
	//GETTER SETTER
	public String getMahd() {
		return mahd;
	}
	public void setMahd(String mahd) {
		this.mahd = mahd;
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
		
		thanhtien = (soluong * dongia) - ((soluong * dongia * 45) / 100 );
	}
	public void nhap(String mahd)throws Exception {
		//get all products to check
		DSSanPham dsSp = new DSSanPham();
		dsSp.docFile("src/sanpham.txt");
		
		this.mahd = mahd;
		
		while(true) {
			do {
				System.out.print(" . Nhap ma san pham(5 ki tu): ");
				masp = sc.nextLine();
			}while(masp.length()!=5);
			if(dsSp.timKiem(masp) != -1) {
				break;
			}else {
				System.out.println("\n!!!San pham khong ton tai, moi nhap lai!!!\n");
			}
		}
		
		dongia = getDonGiaSp();
		
		do{
			System.out.print(" . Nhap so luong: ");
			soluong = sc.nextInt();
			sc.nextLine();
		}while(soluong <= 0);
		
		thanhtien = (soluong * dongia) - ((soluong * dongia * 45) / 100 );

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
