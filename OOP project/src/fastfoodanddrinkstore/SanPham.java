package fastfoodanddrinkstore;

import java.util.*;
import java.io.*;
public class SanPham{
	Scanner in = new Scanner(System.in);
	private String loai;
	private String tensp;
	private String masp;
	private int gia;
	private int soluongco;
	//Constructor
	public SanPham() {
	}
	public SanPham(String masp, String tensp, String loai, int gia, int soluongco) {
		this.masp = masp;
		this.tensp = tensp;
		this.loai = loai;
		this.gia = gia;
		this.soluongco = soluongco;
	}
	public SanPham(SanPham sp) {
		masp = sp.masp;
		tensp = sp.tensp;
		loai = sp.loai;
		gia = sp.gia;
		soluongco = sp.soluongco;
	}
	//Getter & Setter
	public String getLoai() {
		return loai;
	}
	public void setLoai(String loai) {
		this.loai = loai;
	}
	public String getTensp() {
		return tensp;
	}
	public void setTensp(String tensp) {
		this.tensp = tensp;
	}
	public String getMasp() {
		return masp;
	}
	public void setMasp(String masp) {
		this.masp = masp;
	}
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	public int getSoluongco() {
		return soluongco;
	}
	public void setSoluongco(int soluongco) {
		this.soluongco = soluongco;
	}
	//Remove redundant space in string
	public String removeRedundantSpace(String myStr) {
		String newStr = myStr.trim();
		int newStrLength = newStr.length();
		String cleanStr = "";
		for(int i = 0; i < newStrLength; i++) {
			if(newStr.substring(i, i+1).equals(" ") == false || newStr.substring(i,i+1).equals(" ") && newStr.substring(i+1,i+2).equals(" ") ==  false){
				cleanStr += newStr.substring(i,i+1);
			}
		}
		return cleanStr;
	}
	/*==========INPUT & OUTPUT========`*/
	public void nhap() {
		//Enter masp
		while(true) {
			System.out.print("- Nhap vao ma san pham (5 so): ");
				masp = in.nextLine();
				if(masp.length() == 5) {
				break;
			}
		}
		
		//Enter tensp
		while(true) {
			System.out.print("- Nhap vao ten cua san pham: ");
			tensp = in.nextLine();
			if(tensp.equals(" ") == false && tensp.equals("") == false && tensp.equals(null) == false) {
				break;
			}
		}
		tensp = removeRedundantSpace(tensp);		//remove all redundant space from user input
		
		//Enter loai
		while(true) {
			System.out.print("- Nhap vao loai cua san pham: ");
			loai = in.nextLine();
			if(loai.equals(" ") == false && loai.equals("") == false && loai.equals(null) == false) {
				break;
			}
		}
		loai = removeRedundantSpace(loai);		//remove all redundant space from user input
		
		//Enter gia
		while(true) {
			System.out.print("- Nhap vao gia cua san pham: ");
			gia = in.nextInt();
			if(gia >= 0) {
				break;
			}
		}
		
		//Enter soluongco
		while(true) {
			System.out.print("- Nhap vao so luong hien co cua san pham: ");
			soluongco = in.nextInt();
			if(soluongco >= 0) {
				break;
			}
		}
		in.nextLine();
		
	}
	
	
	public void nhap(String masp) {
		this.masp = masp;
		
		//Enter tensp
		while(true) {
			System.out.print("- Nhap vao ten cua san pham: ");
			tensp = in.nextLine();
			if(tensp.equals(" ") == false && tensp.equals("") == false && tensp.equals(null) == false) {
				break;
			}
		}
		tensp = removeRedundantSpace(tensp);		//remove all redundant space from user input
		
		//Enter loai
		while(true) {
			System.out.print("- Nhap vao loai cua san pham: ");
			loai = in.nextLine();
			if(loai.equals(" ") == false && loai.equals("") == false && loai.equals(null) == false) {
				break;
			}
		}
		loai = removeRedundantSpace(loai);		//remove all redundant space from user input
		
		//Enter gia
		while(true) {
			System.out.print("- Nhap vao gia cua san pham: ");
			gia = in.nextInt();
			if(gia >= 0) {
				break;
			}
		}
		
		//Enter soluongco
		while(true) {
			System.out.print("- Nhap vao so luong hien co cua san pham: ");
			soluongco = in.nextInt();
			if(soluongco >= 0) {
				break;
			}
		}
		in.nextLine();
		
	}
	
	
	public void xuat() {
		//handle tensp output
		String tenspTam = tensp;
		tenspTam = tenspTam.toUpperCase();
		for(int i = 0; i < 35-tensp.length(); i++) {
			tenspTam += " ";
		}
		
		//handle loai output
		String loaiTam = loai;
		loaiTam = loaiTam.toUpperCase();
		for(int i = 0; i < 15-loai.length(); i++) {
			loaiTam += " ";
		}
		
		//handle gia
		String giaTam = String.format("%d", gia);
		int giaTamLength = giaTam.length();
		for(int i = 0; i < 7-giaTamLength; i++) {
			giaTam += " ";
		}
		
		//handle soluongco
		String soluongcoTam = String.format("%d", soluongco);
		int soluongcoTamLength = soluongcoTam.length();
		for(int i = 0; i < 6-soluongcoTamLength; i++) {
			soluongcoTam += " ";
		}
		
		//print out product
		System.out.print("| " + masp + " | " + tenspTam + " | " + loaiTam + " | " + giaTam + " | " + soluongcoTam + " | ");
	}
	public void writeFile(String fileName)throws IOException {
		DataOutputStream out =  new DataOutputStream(new FileOutputStream(fileName, Boolean.TRUE));
		try {
			out.writeUTF(masp);
			out.writeUTF(tensp);
			out.writeUTF(loai);
			out.writeInt(gia);
			out.writeInt(soluongco);
		}catch(IOException e) {
		}
	}
}
