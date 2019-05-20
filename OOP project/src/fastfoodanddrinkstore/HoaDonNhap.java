package fastfoodanddrinkstore;
import java.io.*;
import java.util.*;
public class HoaDonNhap 
{
	Scanner sc = new Scanner(System.in);
	private String ma;
	private String ngaynhap;
	private String thangnhap;
	private String namnhap;
	private String nv;
	private String mancc;
	private int tongchi;
			
	
	//GETTER SETTER;
	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
	}
	public String getNgaynhap() {
		return ngaynhap;
	}
	public void setNgaynhap(String ngaynhap) {
		this.ngaynhap = ngaynhap;
	}
	public String getThangnhap() {
		return thangnhap;
	}
	public void setThangnhap(String thangnhap) {
		this.thangnhap = thangnhap;
	}
	public String getNamnhap() {
		return namnhap;
	}
	public void setNamnhap(String namnhap) {
		this.namnhap = namnhap;
	}
	public String getNv() {
		return nv;
	}
	public void setNv(String nv) {
		this.nv = nv;
	}
	public int getTongchi() {
		return tongchi;
	}
	public void setTongchi(int tongchi) {
		this.tongchi = tongchi;
	}
	public String getMancc() {
		return mancc;
	}
	public void setMancc(String mancc) {
		this.mancc = mancc;
	}	
	//constructor;	
	public HoaDonNhap() {}	
	public HoaDonNhap(String ma, String ngaynhap, String thangnhap, String namnhap, String nv, String mancc, int tongchi) {
		this.ma = ma;
		this.ngaynhap = ngaynhap;
		this.thangnhap = thangnhap;
		this.namnhap = namnhap;
		this.nv = nv;
		this.tongchi = tongchi;
		this.mancc = mancc;
	}
	public HoaDonNhap(HoaDonNhap hd) {
		this(hd.ma,hd.ngaynhap,hd.thangnhap, hd.namnhap, hd.nv, hd.mancc, hd.tongchi);
	}		
	//nhap xuat
	public void nhap() throws Exception{
		//get all chitiethoadonnhap from file 
		DSChiTietHoaDonNhap cthdn = new DSChiTietHoaDonNhap();
		cthdn.docFile("src/chitiethoadonnhap.txt");
		//get all 'NCC' to compare
		DSNhaCungCap dsNcc = new DSNhaCungCap();
		dsNcc.docFile("src/nhacungcap.txt");
		//get all employee to compare
		DSNhanVien dsNv = new DSNhanVien();
		dsNv.docFile("src/nhanvien.txt");
		
		do {
			System.out.print("Nhap vao ma hoa don (5 ky tu): ");
			ma = sc.nextLine();
		}while(ma.length() != 5);
		
		System.out.println("- Nhap vao ngay nhap hang");
		do {
			System.out.print(" . Ngay: ");
			this.ngaynhap = sc.nextLine();
		}while(Integer.parseInt(ngaynhap) > 31 || Integer.parseInt(ngaynhap) < 0);
		
		do {
			System.out.print(" . Thang: ");
			this.thangnhap = sc.nextLine();
		}while( Integer.parseInt(thangnhap) > 12 || Integer.parseInt(thangnhap) < 0);
		
		do {
			System.out.print(" . Nam: ");
			this.namnhap = sc.nextLine();
		}while(Integer.parseInt(namnhap) < 2000);
		
		while(true) {
			do {
				System.out.print("Nhap ma nhan vien (5 ky tu): ");
				this.nv = sc.nextLine();
			}while(nv.length() != 5);
			if(dsNv.timKiem(nv) != -1) {
				break;
			}else {
				System.out.println("\n!!!Nhan vien khong ton tai, xin moi nhap lai!!!\n");
			}
		}
			
		while(true) {
			do {
				System.out.print("Nhap ma nha cung cap (5 ky tu): ");
				this.mancc = sc.nextLine();
			}while(mancc.length() != 5);
			if(dsNcc.timKiem(mancc) != -1) {
				break;
			}else {
				System.out.println("\n!!!Nha cung cap khong ton tai, xin moi nhap lai!!!\n");
			}
		}
		
		//Input chitiethoadonxuat when of each product
		int soluongSp;
		System.out.print("- Hoa don cua ban co bao nhieu san pham? ");
		soluongSp = sc.nextInt();
		sc.nextLine();
		System.out.println(" + Nhap vao thong tin cho tung san pham cua hoa don");
		cthdn.them(soluongSp, ma);
		cthdn.ghiFile("src/chitiethoadonnhap.txt");
		
		//get list of all chitiethoadonxuat to calculate totoal price
		cthdn.docFile("src/chitiethoadonnhap.txt");
		ChiTietHoaDonNhap [] chiTietHdxList = cthdn.getDs();
		//Calcute total price of input bill
		int tongTienHd = 0;
		for(int i = 0; i < cthdn.getSoluong(); i++) {
			if(chiTietHdxList[i].getMahd().equals(ma)){
				tongTienHd += chiTietHdxList[i].getThanhtien();
			}
		}
		tongchi = tongTienHd;

	}
	
	
	public void nhap(String mahd) throws Exception{
		//get all chitiethoadonnhap from file 
		DSChiTietHoaDonNhap cthdn = new DSChiTietHoaDonNhap();
		cthdn.docFile("src/chitiethoadonnhap.txt");
		//get all 'NCC' to compare
		DSNhaCungCap dsNcc = new DSNhaCungCap();
		dsNcc.docFile("src/nhacungcap.txt");
		//get all employee to compare
		DSNhanVien dsNv = new DSNhanVien();
		dsNv.docFile("src/nhanvien.txt");
		
		this.ma = mahd;
		
		System.out.println("- Nhap vao ngay nhap hang");
		do {
			System.out.print(" . Ngay: ");
			this.ngaynhap = sc.nextLine();
		}while(Integer.parseInt(ngaynhap) > 31 || Integer.parseInt(ngaynhap) < 0);
		
		do {
			System.out.print(" . Thang: ");
			this.thangnhap = sc.nextLine();
		}while( Integer.parseInt(thangnhap) > 12 || Integer.parseInt(thangnhap) < 0);
		
		do {
			System.out.print(" . Nam: ");
			this.namnhap = sc.nextLine();
		}while(Integer.parseInt(namnhap) < 2000);
		
		while(true) {
			do {
				System.out.print("- Nhap ma nhan vien (5 ky tu): ");
				this.nv = sc.nextLine();
			}while(nv.length() != 5);
			if(dsNv.timKiem(nv) != -1) {
				break;
			}else {
				System.out.println("\n!!!Nhan vien khong ton tai, xin moi nhap lai!!!\n");
			}
		}
			
		while(true) {
			do {
				System.out.print("- Nhap ma nha cung cap(5 ky tu): ");
				this.mancc = sc.nextLine();
			}while(mancc.length() != 5);
			if(dsNcc.timKiem(mancc) != -1) {
				break;
			}else {
				System.out.println("\n!!!Nha cung cap khong ton tai, xin moi nhap lai!!!\n");
			}
		}
		
		//Input chitiethoadonxuat when of each product
		int soluongSp;
		System.out.print("- Hoa don cua ban co bao nhieu san pham? ");
		soluongSp = sc.nextInt();
		sc.nextLine();
		System.out.println(" + Nhap vao thong tin cho tung san pham cua hoa don");
		cthdn.them(soluongSp, ma);
		cthdn.ghiFile("src/chitiethoadonnhap.txt");
		
		//get list of all chitiethoadonxuat to calculate totoal price
		cthdn.docFile("src/chitiethoadonnhap.txt");
		ChiTietHoaDonNhap [] chiTietHdxList = cthdn.getDs();
		//Calcute total price of input bill
		int tongTienHd = 0;
		for(int i = 0; i < cthdn.getSoluong(); i++) {
			if(chiTietHdxList[i].getMahd().equals(ma)){
				tongTienHd += chiTietHdxList[i].getThanhtien();
			}
		}
		tongchi = tongTienHd;

	}	
	public void xuat() {
		System.out.printf("| %-8s | %2s/%2s/%4s | %-8s | %-8s | %-10d |\n",this.ma,this.ngaynhap,this.thangnhap,this.namnhap, this.nv, this.mancc, this.tongchi);
		System.out.println("+----------+------------+----------+----------+------------+");
	}	
	public void ghiFile(String name) throws IOException{
		DataOutputStream fo = null;
		try {
			fo = new DataOutputStream(new FileOutputStream(name,Boolean.TRUE));
			fo.writeUTF(ma);
			fo.writeUTF(ngaynhap);
			fo.writeUTF(thangnhap);
			fo.writeUTF(namnhap);
			fo.writeUTF(nv);
			fo.writeUTF(mancc);
			fo.writeInt(tongchi);
		}catch(Exception e) {}
		finally {
			fo.close();
		}	
	}	
//	public void docFile(String name) throws IOException{
//		DataInputStream fi = null;
//		try {
//			fi = new DataInputStream(new FileInputStream(name));
//	
//			this.ma = fi.readUTF();;
//			this.ngaynhap = fi.readUTF();;
//			this.thangnhap = fi.readUTF();;
//			this.namnhap = fi.readUTF();;
//			this.nv = fi.readUTF();;
//			this.tongchi = fi.readInt();;
//			this.mancc = fi.readUTF();;
//		}catch(Exception e) {}
//		finally {
//			fi.close();
//		}
//	} 
//	namnhap.length() != 4 || Integer.parseInt(namnhap) >  Calendar.getInstance().get(Calendar.YEAR) || Integer.parseInt(namnhap) < 1000
}
