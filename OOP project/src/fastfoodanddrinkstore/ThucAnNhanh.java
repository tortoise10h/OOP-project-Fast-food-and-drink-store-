package fastfoodanddrinkstore;

import java.util.*;
import java.lang.*;
import java.io.*;
public class ThucAnNhanh extends SanPham{
	Scanner in = new Scanner(System.in);
	private String nguyenLieuChinh;
	private String xuatxu;
	//Constructor
	public ThucAnNhanh() {}
	public ThucAnNhanh(String masp, String tensp, String loai, int gia, int soluongco, String nguyenLieuChinh, String xuatxu) {
		super(masp,tensp,loai,gia,soluongco);
		this.nguyenLieuChinh = nguyenLieuChinh;
		this.xuatxu = xuatxu;
	}
	public ThucAnNhanh(ThucAnNhanh ff) { //ff means fast food
		super((SanPham) ff);
		nguyenLieuChinh = ff.nguyenLieuChinh;
		xuatxu = ff.xuatxu;
	}
	//Getter & Setter
	public String getNguyenLieuChinh() {
		return nguyenLieuChinh;
	}
	public void setNguyenLieuChinh(String nguyenLieuChinh) {
		this.nguyenLieuChinh = nguyenLieuChinh;
	}
	public String getXuatxu() {
		return xuatxu;
	}
	public void setXuatxu(String xuatxu) {
		this.xuatxu = xuatxu;
	}
	//Input & Output
	@Override public void nhap() {
		super.nhap();
		//Enter nguyenLieuChinh
		while(true) {
			System.out.print("- Nhap vao nguyen lieu chinh cua mon an: ");
			nguyenLieuChinh = in.nextLine();
			if(nguyenLieuChinh.equals(" ") == false && nguyenLieuChinh.equals("") == false && nguyenLieuChinh.equals(null) == false) {
				break;
			}
		}
		
		//Enter xuatxu
		while(true) {
			System.out.print("- Nhap vao xuat xu cua san pham: ");
			xuatxu = in.nextLine();
			if(xuatxu.equals(" ") == false && xuatxu.equals("") == false && xuatxu.equals(null) == false) {
				break;
			}
		}
	}
	@Override public void nhap(String masp) {
		super.nhap(masp);
		//Enter nguyenLieuChinh
		while(true) {
			System.out.print("- Nhap vao nguyen lieu chinh cua mon an: ");
			nguyenLieuChinh = in.nextLine();
			if(nguyenLieuChinh.equals(" ") == false && nguyenLieuChinh.equals("") == false && nguyenLieuChinh.equals(null) == false) {
				break;
			}
		}
		
		//Enter xuatxu
		while(true) {
			System.out.print("- Nhap vao xuat xu cua san pham: ");
			xuatxu = in.nextLine();
			if(xuatxu.equals(" ") == false && xuatxu.equals("") == false && xuatxu.equals(null) == false) {
				break;
			}
		}
	}
	@Override public void xuat() {
		//Handle nguyenLieuChinh
		String nguyenLieuTam = nguyenLieuChinh;
		for(int i = 0; i < 30-nguyenLieuChinh.length();i++) {
			nguyenLieuTam += " ";
		}
		
		//Handle xuatxu
		String xuatxuTam = xuatxu;
		for(int i = 0; i < 10-xuatxu.length();i++) {
			xuatxuTam += " ";
		}
		super.xuat();
		System.out.println(nguyenLieuTam + " | " + xuatxuTam + " |");
		System.out.println("+-------+-------------------------------------+-----------------+---------+--------+--------------------------------+------------+");
	}
	@Override public void writeFile(String fileName)throws IOException{
		DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName, Boolean.TRUE));
		try {
			super.writeFile(fileName);
			out.writeUTF(nguyenLieuChinh);
			out.writeUTF(xuatxu);
		}catch(IOException e) {
			
		}
		finally {
			out.close();
		}
	}
}
