package fastfoodanddrinkstore;

import java.sql.Date;
import java.util.*;
import java.io.*;

public class HoaDonXuat {
	Scanner sc = new Scanner(System.in);
	private String	ma;
	private String	ngayxuat;
	private String thangxuat;
	private String namxuat;
	private String	manv;
	private String	makh;
	private String	makm;
	private int tongtien;
	private int	tienkm;
	
	/*==========GETTER SETTER==========*/
	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
	}
	public String getngayxuat() {
		return ngayxuat;
	}
	public void setngayxuat(String ngayxuat) {
		this.ngayxuat = ngayxuat;
	}
	public String getManv() {
		return manv;
	}
	public void setManv(String manv) {
		this.manv = manv;
	}
	public int getTongtien() {
		return tongtien;
	}
	public void setTongtien(int tongtien) {
		this.tongtien = tongtien;
	}
	public String getMakh() {
		return makh;
	}
	public void setMakh(String makh) {
		this.makh = makh;
	}
	public String getMakm() {
		return makm;
	}
	public void setMakm(String makm) {
		this.makm = makm;
	}
	public int getTienkm() {
		return tienkm;
	}
	public void setTienkm(int tienkm) {
		this.tienkm = tienkm;
	}
	
	public String getThangxuat() {
		return thangxuat;
	}
	public void setThangxuat(String thangxuat) {
		this.thangxuat = thangxuat;
	}
	public String getNamxuat() {
		return namxuat;
	}
	public void setNamxuat(String namxuat) {
		this.namxuat = namxuat;
	}
	/*==========CONSTRUCTOR==========*/
	public HoaDonXuat() {
		
	}
	public HoaDonXuat(String ma, String ngayxuat, String thangxuat, String namxuat, String manv, String makh, String makm, int tongtien,
			int tienkm) {
		this.ma = ma;
		this.ngayxuat = ngayxuat;
		this.thangxuat = thangxuat;
		this.namxuat = namxuat;
		this.manv = manv;
		this.tongtien = tongtien;
		this.makh = makh;
		this.makm = makm;
		this.tienkm = tienkm;
	}
	public HoaDonXuat(HoaDonXuat hd) throws IOException{
		 this(hd.ma, hd.ngayxuat, hd.thangxuat, hd.namxuat, hd.manv, hd.makh, hd.makm, hd.tongtien, hd.tienkm);
	}
	
	/*=========INPUT & OUTPUT==========*/
	public void nhap() throws Exception {
		//get all chitiethoadonxuat from file 
		DSChiTietHoaDonXuat cthdx = new DSChiTietHoaDonXuat();
		cthdx.docFile("src/chitiethoadonxuat.txt");

		do{
			System.out.print("- Nhap ma hoa don(5 ki tu): ");
			ma = sc.nextLine();
		}while(ma.length()!=5);
		
		
		
		do {
			System.out.print("- Nhap ngay xuat:");
			ngayxuat = sc.nextLine();
		}while(Integer.parseInt(ngayxuat) < 1 && Integer.parseInt(ngayxuat) > 31);
		
		do {
			System.out.print("- Nhap thang xuat:");
			thangxuat = sc.nextLine();
		}while(Integer.parseInt(thangxuat) < 1 && Integer.parseInt(thangxuat) > 12);
		
		do {
			System.out.print("- Nhap nam xuat:");
			namxuat = sc.nextLine();
		}while(Integer.parseInt(namxuat) < 1);
		
		do {
			System.out.print("- Nhap ma nhan vien(5 ki tu): ");
			manv = sc.nextLine();
		}while(manv.length()!=5);
		
		do {
			System.out.print("- Nhap ma khach hang(5 ki tu): ");
			makh = sc.nextLine();
		}while(makh.length()!=5);
		
		do {
			System.out.print("- Nhap ma khuyen mai: ");
			makm = sc.nextLine();
		}while(makh.length()!=5);
		
		//Input chitiethoadonxuat for each product
		int soluongSp;
		System.out.print("- Hoa don cua ban co bao nhieu san pham? ");
		soluongSp = sc.nextInt();
		sc.nextLine();
		System.out.println(" + Nhap vao thong tin cho tung san pham cua hoa don");
		cthdx.them(soluongSp, ma, makm);
		cthdx.ghiFile("src/chitiethoadonxuat.txt");
		
		//get list of all chitiethoadonxuat to calculate totoal price
		cthdx.docFile("src/chitiethoadonxuat.txt");
		ChiTietHoaDonXuat [] chiTietHdxList = cthdx.getds();
		//Calcute total price of input bill
		int tongTienHd = 0;
		for(int i = 0; i < cthdx.getSoluong(); i++) {
			if(chiTietHdxList[i].getMahd().equals(ma)){
				tongTienHd += chiTietHdxList[i].getThanhtien();
			}
		}
		tongtien = tongTienHd;
		
		//calculate sale price 
		int giaCu = cthdx.tinhTienTheoMahd(ma);
		tienkm = giaCu - tongTienHd;
	}
	
	public void nhap(String mahd, String[] listMasp, int[] sluong, int sluongSanPham)throws Exception{ 
		
		//get all chitiethoadonxuat from file 
		DSChiTietHoaDonXuat cthdx = new DSChiTietHoaDonXuat();
		cthdx.docFile("src/chitiethoadonxuat.txt");
		//get all customer to check
		DSKhachHang dsKh = new DSKhachHang();
		dsKh.docFile("src/khachhang.txt");
		//get all employee to check
		DSNhanVien dsNv = new DSNhanVien();
		dsNv.docFile("src/nhanvien.txt");
		//get all "khuyenmai" to check
		DSKhuyenMai dsKm = new DSKhuyenMai();
		dsKm.docFile("src/khuyenmai.txt");
		
		
		this.ma = mahd;
		
		do {
			System.out.print("- Nhap ngay xuat:");
			ngayxuat = sc.nextLine();
		}while(Integer.parseInt(ngayxuat) < 1 && Integer.parseInt(ngayxuat) > 31);
		
		do {
			System.out.print("- Nhap thang xuat:");
			thangxuat = sc.nextLine();
		}while(Integer.parseInt(thangxuat) < 1 && Integer.parseInt(thangxuat) > 12);
		
		do {
			System.out.print("- Nhap nam xuat:");
			namxuat = sc.nextLine();
		}while(Integer.parseInt(namxuat) < 1);
		
		while(true) {
			do {
				System.out.print("- Nhap ma nhan vien(5 ki tu): ");
				manv = sc.nextLine();
			}while(manv.length()!=5);
			if(dsNv.timKiem(manv) != -1) {
				break;
			}else {
				System.out.println("\n!!!Nhan vien nay khong ton tai, xin moi nhap lai!!!\n");
			}
		}
		
		while(true) {
			do {
				System.out.print("- Nhap ma khach hang(5 ki tu): ");
				makh = sc.nextLine();
			}while(makh.length()!=5);
			if(dsKh.timKiem(makh) != -1) {
				break;
			}else {
				System.out.println("\n!!!Khach hang nay khong ton tai, xin moi nhap lai!!!\n");
			}
		}
		
		while(true) {
			do {
				System.out.print("- Nhap ma khuyen mai (neu khong co xin nhap 'khong'): ");
				makm = sc.nextLine();
			}while(makh.length()!=5);
			if(dsKm.tim(makm) == -1 && makm.equals("khong") == false) {
				System.out.println("\n!!!Ma khuyen mai nay khong ton tai, xin moi nhap lai!!!\n");
			}else {
				break;
			}
		}
		
		//Input chitiethoadonxuat when of each product
		cthdx.them(sluongSanPham,mahd,makm,listMasp,sluong);
		cthdx.ghiFile("src/chitiethoadonxuat.txt");
		
		//get list of all chitiethoadonxuat to calculate totoal price
		cthdx.docFile("src/chitiethoadonxuat.txt");
		ChiTietHoaDonXuat [] chiTietHdxList = cthdx.getds();
		//Calcute total price of input bill
		int tongTienHd = 0;
		for(int i = 0; i < cthdx.getSoluong(); i++) {
			if(chiTietHdxList[i].getMahd().equals(ma)){
				tongTienHd += chiTietHdxList[i].getThanhtien();
			}
		}
		tongtien = tongTienHd;
		
		//calculate sale price 
		int giaCu = cthdx.tinhTienTheoMahd(ma);
		tienkm = giaCu - tongTienHd;
	}
	
	public void nhap(String mahd) throws Exception {
		//get all chitiethoadonxuat from file 
		DSChiTietHoaDonXuat cthdx = new DSChiTietHoaDonXuat();
		cthdx.docFile("src/chitiethoadonxuat.txt");
		//get all customer to check
		DSKhachHang dsKh = new DSKhachHang();
		dsKh.docFile("src/khachhang.txt");
		//get all employee to check
		DSNhanVien dsNv = new DSNhanVien();
		dsNv.docFile("src/nhanvien.txt");
		//get all "khuyenmai" to check
		DSKhuyenMai dsKm = new DSKhuyenMai();
		dsKm.docFile("src/khuyenmai.txt");
		
		
		this.ma = mahd;
		
		do {
			System.out.print("- Nhap ngay xuat:");
			ngayxuat = sc.nextLine();
		}while(Integer.parseInt(ngayxuat) < 1 && Integer.parseInt(ngayxuat) > 31);
		
		do {
			System.out.print("- Nhap thang xuat:");
			thangxuat = sc.nextLine();
		}while(Integer.parseInt(thangxuat) < 1 && Integer.parseInt(thangxuat) > 12);
		
		do {
			System.out.print("- Nhap nam xuat:");
			namxuat = sc.nextLine();
		}while(Integer.parseInt(namxuat) < 1);
		
		while(true) {
			do {
				System.out.print("- Nhap ma nhan vien(5 ki tu): ");
				manv = sc.nextLine();
			}while(manv.length()!=5);
			if(dsNv.timKiem(manv) != -1) {
				break;
			}else {
				System.out.println("\n!!!Nhan vien nay khong ton tai, xin moi nhap lai!!!\n");
			}
		}
		
		while(true) {
			do {
				System.out.print("- Nhap ma khach hang(5 ki tu): ");
				makh = sc.nextLine();
			}while(makh.length()!=5);
			if(dsKh.timKiem(makh) != -1) {
				break;
			}else {
				System.out.println("\n!!!Khach hang nay khong ton tai, xin moi nhap lai!!!\n");
			}
		}
		
		while(true) {
			do {
				System.out.print("- Nhap ma khuyen mai (neu khong co xin nhap 'khong'): ");
				makm = sc.nextLine();
			}while(makh.length()!=5);
			if(dsKm.tim(makm) == -1 && makm.equals("khong") == false) {
				System.out.println("\n!!!Ma khuyen mai nay khong ton tai, xin moi nhap lai!!!\n");
			}else {
				break;
			}
		}
		
		//Input chitiethoadonxuat when of each product
		int soluongSp;
		System.out.print("- Hoa don cua ban co bao nhieu san pham? ");
		soluongSp = sc.nextInt();
		sc.nextLine();
		System.out.println(" + Nhap vao thong tin cho tung san pham cua hoa don");
		cthdx.them(soluongSp, ma, makm);
		cthdx.ghiFile("src/chitiethoadonxuat.txt");
		
		//get list of all chitiethoadonxuat to calculate totoal price
		cthdx.docFile("src/chitiethoadonxuat.txt");
		ChiTietHoaDonXuat [] chiTietHdxList = cthdx.getds();
		//Calcute total price of input bill
		int tongTienHd = 0;
		for(int i = 0; i < cthdx.getSoluong(); i++) {
			if(chiTietHdxList[i].getMahd().equals(ma)){
				tongTienHd += chiTietHdxList[i].getThanhtien();
			}
		}
		tongtien = tongTienHd;
		
		//calculate sale price 
		int giaCu = cthdx.tinhTienTheoMahd(ma);
		tienkm = giaCu - tongTienHd;
	}
	
	
	public void xuat()
	{
		System.out.printf("| %-8s | %2s/%2s/%4s | %-8s | %-10d | %-8s | %-8s | %-10d |\n",this.ma, this.ngayxuat, this.thangxuat, this.namxuat, this.manv, this.tongtien, this.makh, this.makm, this.tienkm);
		System.out.println("+----------+------------+----------+------------+----------+----------+------------+");
	}
	/*==========WRITE FILE===========*/
	public void ghiFile(String fileName)throws IOException {
		DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName,Boolean.TRUE));
		try {
			out.writeUTF(ma);
			out.writeUTF(ngayxuat);
			out.writeUTF(thangxuat);
			out.writeUTF(namxuat);
			out.writeUTF(manv);
			out.writeInt(tongtien);
			out.writeUTF(makh);
			out.writeUTF(makm);
			out.writeInt(tienkm);
		}catch(IOException e) {}
		finally {
			out.close();
		}
	}
}
