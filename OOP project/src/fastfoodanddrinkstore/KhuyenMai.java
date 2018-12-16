package fastfoodanddrinkstore;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class KhuyenMai {
	Scanner sc = new Scanner(System.in);
	private String makm;
	private String mota;
	private String ngbd;
	private String ngkt;
	
	//GETTER SETTER
	public String getMakm() {
		return makm;
	}

	public void setMakm(String makm) {
		this.makm = makm;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getNgbd() {
		return ngbd;
	}

	public void setNgbd(String ngbd) {
		this.ngbd = ngbd;
	}

	public String getNgkt() {
		return ngkt;
	}

	public void setNgkt(String ngkt) {
		this.ngkt = ngkt;
	}

	
	//Constructor
	public KhuyenMai(String makm, String mota, String ngbd, String ngkt) {
		this.makm = makm;
		this.mota = mota;
		this.ngbd = ngbd;
		this.ngkt = ngkt;
	}
	public KhuyenMai(){
		
	}
	public KhuyenMai(KhuyenMai km) {
		this(km.makm, km.mota, km.ngbd, km.ngkt);
	}
	
	//nhap
	public void nhap() throws Exception
	{
		//get all thong tin khuyen mai from file
		DSThongTinKhuyenMai ttkm = new DSThongTinKhuyenMai();
		ttkm.docFile("src/thongtinkhuyenmai.txt");
		
		do {
			System.out.print("- Nhap ma khuyen mai(5 ki tu):");
			this.setMakm(sc.nextLine());
		}while(makm.length()!=5);
		
		System.out.print("- Nhap mo ta:");
		this.setMota(sc.nextLine());
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		df.setLenient(false);
		boolean flag = true;
		do {
			System.out.print("- Nhap ngay bat dau (dd/MM/yyyy):");
			this.setNgbd(sc.nextLine());
			try {
				flag = true;
				df.parse(ngbd);
				
			}catch(ParseException  e) {
				flag  = false;
			}
		}while(flag == false);
		
		flag = true;
		
		do {
			System.out.print("- Nhap ngay ket thuc (dd/MM/yyyy):");
			this.setNgkt(sc.nextLine());
			try {
				flag = true;
				df.parse(ngkt);
				
			}catch(ParseException  e) {
				flag  = false;
			}
		}while(flag == false);
		
		//Input thongtinkhuyenmai of khuyenmai
		int sluongTtkm;
		System.out.print("- Co bao nhieu san pham duoc khuyen mai trong chuong trinh khuyen mai nay: ");
		sluongTtkm = sc.nextInt();
		sc.nextLine();
		System.out.println("+ Nhap vao thong tin khuyen mai cho tung san pham duoc khuyen mai: ");
		ttkm.them(sluongTtkm, makm);
		ttkm.ghiFile("src/thongtinkhuyenmai.txt");
	}
	
	public void nhap(String makm) throws Exception
	{
		//get all thong tin khuyen mai from file
		DSThongTinKhuyenMai ttkm = new DSThongTinKhuyenMai();
		ttkm.docFile("src/thongtinkhuyenmai.txt");
		
		this.makm = makm;
		
		System.out.print("- Nhap mo ta:");
		this.setMota(sc.nextLine());
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		df.setLenient(false);
		boolean flag = true;
		do {
			System.out.print("- Nhap ngay bat dau (dd/MM/yyyy):");
			this.setNgbd(sc.nextLine());
			try {
				flag = true;
				df.parse(ngbd);
				
			}catch(ParseException  e) {
				flag  = false;
			}
		}while(flag == false);
		
		flag = true;
		
		do {
			System.out.print("- Nhap ngay ket thuc (dd/MM/yyyy):");
			this.setNgkt(sc.nextLine());
			try {
				flag = true;
				df.parse(ngkt);
				
			}catch(ParseException  e) {
				flag  = false;
			}
		}while(flag == false);
		
		//Input thongtinkhuyenmai of khuyenmai
		int sluongTtkm;
		System.out.print("- Co bao nhieu san pham duoc khuyen mai trong chuong trinh khuyen mai nay: ");
		sluongTtkm = sc.nextInt();
		sc.nextLine();
		System.out.println(" + Nhap vao thong tin khuyen mai cho tung san pham duoc khuyen mai: ");
		ttkm.them(sluongTtkm, makm);
		ttkm.ghiFile("src/thongtinkhuyenmai.txt");
	}
	
	//xuat
	public void xuat()
	{
		System.out.printf("| %-5s | %-60s | %-10s | %-10s |\n", this.makm,this.mota,this.ngbd,this.ngkt);
		System.out.println("+-------+--------------------------------------------------------------+------------+------------+");
	}
	/*==========WRITE FILE==========*/
	public void ghifile(String name) throws IOException {
		DataOutputStream fo = null;
		try {
			fo = new DataOutputStream(new FileOutputStream(name,true));
			fo.writeUTF(makm);
			fo.writeUTF(mota);
			fo.writeUTF(ngbd);
			fo.writeUTF(ngkt);
		}catch(Exception e) {}
		finally {
			fo.close();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
