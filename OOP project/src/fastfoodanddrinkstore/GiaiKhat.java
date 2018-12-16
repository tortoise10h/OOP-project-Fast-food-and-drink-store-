package fastfoodanddrinkstore;

import java.util.*;
import java.lang.*;
import java.io.*;
public class GiaiKhat extends SanPham{
	Scanner in = new Scanner(System.in);
	private String huongvi;
	private String size;
	//Constructor
	public GiaiKhat() {}
	public GiaiKhat(String masp, String tensp, String loai, int gia, int soluongco, String huongvi, String size) {
		super(masp, tensp, loai, gia, soluongco);
		this.huongvi = huongvi;
		this.size = size;
	}
	public GiaiKhat(GiaiKhat gk) {
		super((SanPham) gk);
		huongvi =  gk.huongvi;
		size = gk.size;
	}
	//Getter and Setter
	public String getHuongvi() {
		return huongvi;
	}
	public void setHuongvi(String huongvi) {
		this.huongvi = huongvi;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	//Input and Output
	@Override public void nhap() {
		//Call nhap() function from supclass
		super.nhap();
		
		//Enter flavor
		System.out.print("- Nhap vao huong vi cua mon giai khat: ");
		huongvi = in.nextLine();
		
		//Enter size
		while(true) {
			System.out.print("- Nhap vao size cua mon giai khat: (size hien co: S,M,L & XL) ");
			size = in.nextLine();
			String temp = size.toLowerCase();
			if(temp.equals("s") == true || temp.equals("m") == true || temp.equals("l") == true || temp.equals("xl") == true) {
				break;
			}
		}
		
	}
	@Override public void nhap(String masp) {
		//Call nhap() function from supclass
		super.nhap(masp);
		
		//Enter flavor
		System.out.print("- Nhap vao huong vi cua mon giai khat: ");
		huongvi = in.nextLine();
		
		//Enter size
		while(true) {
			System.out.print("- Nhap vao size cua mon giai khat: (size hien co: S,M,L & XL) ");
			size = in.nextLine();
			String temp = size.toLowerCase();
			if(temp.equals("s") == true || temp.equals("m") == true || temp.equals("l") == true || temp.equals("xl") == true) {
				break;
			}
		}
		
	}
	@Override public void xuat() {
		RemoveRedundantSpace rp = new RemoveRedundantSpace();
		//Handle flavor
		String huongviTam = huongvi;
		for(int i = 0; i < 30-huongvi.length(); i++) {
			huongviTam += " ";
		}
		
		//Handle size
		size = size.toUpperCase();
		size = rp.removeSpace(size);
		if(size.equals("XL") == true) {
			size += "        ";
		}else {
			size += "         ";
		}
		super.xuat();
		System.out.println(huongviTam + " | " + size + " |");
		System.out.println("+-------+-------------------------------------+-----------------+---------+--------+--------------------------------+------------+");
	}
	@Override public void writeFile(String fileName)throws IOException{
		DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName, Boolean.TRUE));
		try {
			super.writeFile(fileName);
			out.writeUTF(huongvi);
			out.writeUTF(size);
		}catch(IOException e) {
			
		}
		finally {
			out.close();
		}
	}
}
