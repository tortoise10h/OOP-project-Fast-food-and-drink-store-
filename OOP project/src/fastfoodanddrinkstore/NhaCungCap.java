package fastfoodanddrinkstore;

import java.util.*;
import java.io.*;
public class NhaCungCap {
	Scanner in = new Scanner(System.in);
	private String mancc;
	private String tenncc;
	private String loaihang;
	//Constructor
	public NhaCungCap() {}
	public NhaCungCap(String mancc, String tenncc, String loaihang){
		this.mancc = mancc;
		this.tenncc = tenncc;
		this.loaihang = loaihang;
	}
	public NhaCungCap(NhaCungCap ncc){
		mancc = ncc.mancc;
		tenncc = ncc.tenncc;
		loaihang = ncc.loaihang;
	}
	//Getter & Setter
	public String getMancc() {
		return mancc;
	}
	public void setMancc(String mancc) {
		this.mancc = mancc;
	}
	public String getTenncc() {
		return tenncc;
	}
	public void setTenncc(String tenncc) {
		this.tenncc = tenncc;
	}
	public String getLoaihang() {
		return loaihang;
	}
	public void setLoaihang(String loaihang) {
		this.loaihang = loaihang;
	}
	//Input & Output
	public void nhap(){
		//for format string
		RemoveRedundantSpace rp = new RemoveRedundantSpace();
		//enter mancc
		while(true) {
			System.out.print("- Nhap vao ma cua nha cung cap (5 ky tu): ");
				mancc = in.nextLine();
				if(mancc.length() == 5) {
				break;
			}
		}
		
		//Enter tenncc
		while(true) {
			System.out.print("- Nhap vao ten cua nha cung cap: ");
			tenncc = in.nextLine();
			if(tenncc.equals(" ") == false && tenncc.equals("") == false && tenncc.equals(null) == false) {
				break;
			}
		}
		tenncc = rp.removeSpace(tenncc);		//remove all redundant space from user input
		
		//Enter loaihang
		while(true) {
			System.out.print("- Nhap vao mat hang cung cap: ");
			loaihang = in.nextLine();
			if(loaihang.equals(" ") == false && loaihang.equals("") == false && loaihang.equals(null) == false) {
				break;
			}
		}
		loaihang = rp.removeSpace(loaihang);		//remove all redundant space from user input
				
	}
	
	public void nhap(String mancc){
		//for format string
		RemoveRedundantSpace rp = new RemoveRedundantSpace();
		this.mancc = mancc;
		
		//Enter tenncc
		while(true) {
			System.out.print("- Nhap vao ten cua nha cung cap: ");
			tenncc = in.nextLine();
			if(tenncc.equals(" ") == false && tenncc.equals("") == false && tenncc.equals(null) == false) {
				break;
			}
		}
		tenncc = rp.removeSpace(tenncc);		//remove all redundant space from user input
		
		//Enter loaihang
		while(true) {
			System.out.print("- Nhap vao mat hang cung cap: ");
			loaihang = in.nextLine();
			if(loaihang.equals(" ") == false && loaihang.equals("") == false && loaihang.equals(null) == false) {
				break;
			}
		}
		loaihang = rp.removeSpace(loaihang);		//remove all redundant space from user input
				
	}
	
	public void xuat(){
		//format tenncc
		String tennccTemp = tenncc;
		tennccTemp = tennccTemp.toUpperCase();
		int tennccLength = tennccTemp.length();
		for(int i = 0; i < 40-tennccLength; i++) {
			tennccTemp += " ";
		}
		
		//format tenncc
		String loaihangTemp = loaihang;
		loaihangTemp = loaihangTemp.toUpperCase();
		int loaihangLength = loaihangTemp.length();
		for(int i = 0; i < 40-loaihangLength; i++) {
			loaihangTemp += " ";
		}
		
		System.out.println("| " + mancc + " | " + tennccTemp + " | " + loaihangTemp + " | ");
		System.out.println("+-------+------------------------------------------+------------------------------------------+");
	}
	
	/*===========WRITE FILE==========*/
	public void ghiFile(String fileName)throws IOException {
		DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName,Boolean.TRUE));
		try {
			out.writeUTF(mancc);
			out.writeUTF(tenncc);
			out.writeUTF(loaihang);
		}catch(IOException e) {
			
		}
		finally {
			out.close();
		}
	}
}
