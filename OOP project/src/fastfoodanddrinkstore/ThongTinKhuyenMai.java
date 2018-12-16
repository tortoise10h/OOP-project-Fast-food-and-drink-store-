package fastfoodanddrinkstore;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ThongTinKhuyenMai {
	Scanner sc = new Scanner(System.in);
	private String makm;
	private String masp;
	private int percent;
	private String qua;
	
	/*==========CONSTRUCTOR==========*/
	public ThongTinKhuyenMai() {
		
	}
	public ThongTinKhuyenMai(String makm, String mota, String masp, int percent, String qua) {
		this.makm = makm;
		this.masp = masp;
		this.percent = percent;
		this.qua = qua;
	}
	public ThongTinKhuyenMai(ThongTinKhuyenMai in) {
		makm = in.makm;
		masp = in.masp;
		percent = in.percent;
		qua = in.qua;
	}
	
	/*==========GETTER & SETTER==========*/
	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}

	public String getQua() {
		return qua;
	}

	public void setQua(String qua) {
		this.qua = qua;
	}
	
	
	public String getMasp() {
		return masp;
	}
	public void setMasp(String masp) {
		this.masp = masp;
	}
	public String getMakm() {
		return makm;
	}
	public void setMakm(String makm) {
		this.makm = makm;
	}
	
	/*===========INPUT & OUTPUT==========*/
	public void nhap() throws Exception
	{
		//get all product to compare
		DSSanPham dsSp = new DSSanPham();
		dsSp.docFile("src/sanpham.txt");
		do {
			System.out.print("- Nhap vao ma khuyen mai(5 ky tu): ");
			makm = sc.nextLine();
		}while(makm.length() != 5);
		while(true) {
			do {
				System.out.print("- Nhap vao ma san pham(5 ky tu): ");
				masp = sc.nextLine();
			}while(masp.length() != 5);
			if(dsSp.timKiem(masp) != -1) {
				break;
			}else {
				System.out.println("\n!!!San pham khong ton tai!!!\n");
			}
		}
		do{
			System.out.print("- Nhap phan tram giam gia: ");
			this.setPercent(sc.nextInt());
		}while(percent < 0 || percent > 100);
		sc.nextLine();
		System.out.print("Nhap qua tang (neu khong co nhap 'khong'):");
		this.setQua(sc.nextLine());
	}
	
	public void nhap(String makm, String masp)
	{
		this.makm = makm;
		this.masp = masp;
		
		do{
			System.out.print("- Nhap phan tram giam gia: ");
			this.setPercent(sc.nextInt());
		}while(percent < 0 || percent > 100);
		sc.nextLine();
		System.out.print("Nhap qua tang (neu khong co nhap 'khong'):");
		this.setQua(sc.nextLine());
	}
	
	public void xuat()
	{
		System.out.printf("| %-8s | %-8s | %-4s | %-35s |\n",this.makm,this.masp, this.percent,this.qua);
		System.out.println("+----------+----------+------+-------------------------------------+");
	}
	
	//ghi file
	public void ghifile(String name) throws IOException {
		DataOutputStream fo = null;
		try {
			fo = new DataOutputStream(new FileOutputStream(name,Boolean.TRUE));
			fo.writeUTF(makm);
			fo.writeUTF(masp);
			fo.writeInt(percent);
			fo.writeUTF(qua);
		}catch(Exception e) {}
		finally {
			fo.close();
		}
	}
}
