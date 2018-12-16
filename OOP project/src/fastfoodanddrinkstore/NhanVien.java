package fastfoodanddrinkstore;

import java.util.*;
import java.io.*;
public class NhanVien {
	Scanner in = new Scanner(System.in);
	private String maNv;
	private String hoNv;
	private String tenNv;
	private String ngaySinh;
	private String thangSinh;
	private String namSinh;
	private boolean gioiTinh;
	private int calam;
	private int luong;
	//Constructor
	public NhanVien() {}
	public NhanVien(String maNv, String hoNv, String tenNv, String ngaySinh, String thangSinh, String namSinh,  boolean gioiTinh, int calam, int luong) {
		this.maNv = maNv;
		this.hoNv = hoNv;
		this.tenNv = tenNv;
		this.ngaySinh = ngaySinh;
		this.thangSinh = thangSinh;
		this.namSinh = namSinh;
		this.calam = calam;
		this.luong = luong;
		this.gioiTinh = gioiTinh;
	}
	public NhanVien(NhanVien nv) {
		maNv = nv.maNv;
		hoNv = nv.hoNv;
		tenNv = nv.tenNv;
		ngaySinh = nv.ngaySinh;
		thangSinh = nv.thangSinh;
		namSinh = nv.namSinh;
		calam = nv.calam;
		luong = nv.luong;
		gioiTinh = nv.gioiTinh;
	}
	//Getter & Setter
	public String getMaNv() {
		return maNv;
	}
	public void setMaNv(String maNv) {
		this.maNv = maNv;
	}
	public String getHoNv() {
		return hoNv;
	}
	public void setHoNv(String hoNv) {
		this.hoNv = hoNv;
	}
	public String getTenNv() {
		return tenNv;
	}
	public void setTenNv(String tenNv) {
		this.tenNv = tenNv;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public int getCalam() {
		return calam;
	}
	public void setCalam(int calam) {
		this.calam = calam;
	}
	public int getLuong() {
		return luong;
	}
	public void setLuong(int luong) {
		this.luong = luong;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getThangSinh() {
		return thangSinh;
	}
	public void setThangSinh(String thangSinh) {
		this.thangSinh = thangSinh;
	}
	public String getNamSinh() {
		return namSinh;
	}
	public void setNamSinh(String namSinh) {
		this.namSinh = namSinh;
	}
	//Input & Output
	public void nhap()
    {
		RemoveRedundantSpace rp = new RemoveRedundantSpace();
    	//Enter maNv
        while(true) {
			System.out.print("- Nhap vao ma nhan vien (5 so): ");
			maNv = in.nextLine();
			if(maNv.length() == 5) {
				break;
			}
		}
        
        //Enter hoNv
		while(true) {
			System.out.print("- Nhap vao ho va chu lot cua nhan vien: ");
			hoNv = in.nextLine();
			if(hoNv.equals(" ") == false && hoNv.equals("") == false && hoNv.equals(null) == false) {
				break;
			}
		}
		hoNv = rp.removeSpace(hoNv);		//remove all redundant space from user input
		
		//Enter tenKh
		while(true) {
			System.out.print("- Nhap vao ten cua nhan vien: ");
			tenNv = in.nextLine();
			if(tenNv.equals(" ") == false && tenNv.equals("") == false && tenNv.equals(null) == false) {
				break;
			}
		}
		tenNv = rp.removeSpace(tenNv);	 //remove all redundant space from user input
		
		//Enter gender
		String genderText;
		while(true) {
			System.out.print("- Nhap vao gioi tinh cua nhan vien (nam hoac nu): ");
			genderText = in.nextLine();
			if(genderText.equals("nam") == true || genderText.equals("nu") == true) {
				break;
			}
		}
		if(genderText.equals("nam") == true) {
			gioiTinh = true;
		}else {
			gioiTinh = false;
		}
		
		//Enter ngay sinh
		do {
			System.out.print("- Nhap vao ngay sinh cua nhan vien: ");
			ngaySinh = in.nextLine();
		}while(ngaySinh.length() != 2);
		
		do {
			System.out.print("- Nhap vao thang sinh cua nhan vien: ");
			thangSinh = in.nextLine();
		}while(thangSinh.length() != 2);
		
		do {
			System.out.print("- Nhap vao nam sinh cua nhan vien: ");
			namSinh = in.nextLine();
		}while(namSinh.length() != 4);
		
		//Enter ca lam
		while(true) {
			System.out.print("- Nhap vao ca lam cua nhan vien (ca 1, ca 2 va ca 3): ");
			calam = in.nextInt();
			in.nextLine();
			if(calam == 1 || calam == 2 || calam == 3) {
				break;
			}
		}
		
		//Enter luong
		while(true) {
			System.out.print("- Nhap vao luong cua nhan vien: ");
			luong = in.nextInt();
			in.nextLine();
			if(luong > 0) {
				break;
			}
		}
    }
	
	
	public void nhap(String manv)
    {
		RemoveRedundantSpace rp = new RemoveRedundantSpace();
    	//Enter maNv
       this.maNv = manv;
        
        //Enter hoNv
		while(true) {
			System.out.print("- Nhap vao ho va chu lot cua nhan vien: ");
			hoNv = in.nextLine();
			if(hoNv.equals(" ") == false && hoNv.equals("") == false && hoNv.equals(null) == false) {
				break;
			}
		}
		hoNv = rp.removeSpace(hoNv);		//remove all redundant space from user input
		
		//Enter tenKh
		while(true) {
			System.out.print("- Nhap vao ten cua nhan vien: ");
			tenNv = in.nextLine();
			if(tenNv.equals(" ") == false && tenNv.equals("") == false && tenNv.equals(null) == false) {
				break;
			}
		}
		tenNv = rp.removeSpace(tenNv);	 //remove all redundant space from user input
		
		//Enter gender
		String genderText;
		while(true) {
			System.out.print("- Nhap vao gioi tinh cua nhan vien (nam hoac nu): ");
			genderText = in.nextLine();
			if(genderText.equals("nam") == true || genderText.equals("nu") == true) {
				break;
			}
		}
		if(genderText.equals("nam") == true) {
			gioiTinh = true;
		}else {
			gioiTinh = false;
		}
		
		//Enter ngay sinh
		System.out.println("- Nhap vao ngay sinh cua nhan vien");
		do {
			System.out.print(" . Nhap vao ngay sinh: ");
			ngaySinh = in.nextLine();
		}while(ngaySinh.length() != 2);
		
		do {
			System.out.print(" . Nhap vao thang sinh: ");
			thangSinh = in.nextLine();
		}while(thangSinh.length() != 2);
		
		do {
			System.out.print(" . Nhap vao nam sinh: ");
			namSinh = in.nextLine();
		}while(namSinh.length() != 4);
		
		//Enter ca lam
		while(true) {
			System.out.print("- Nhap vao ca lam cua nhan vien (ca 1, ca 2 va ca 3): ");
			calam = in.nextInt();
			in.nextLine();
			if(calam == 1 || calam == 2 || calam == 3) {
				break;
			}
		}
		
		//Enter luong
		while(true) {
			System.out.print("- Nhap vao luong cua nhan vien: ");
			luong = in.nextInt();
			in.nextLine();
			if(luong > 0) {
				break;
			}
		}
    }
	
	public void xuat()
    {
		//handle name output
		String hoTen = hoNv + " " + tenNv;
		hoTen = hoTen.toUpperCase();
		int nameLength = hoTen.length();
		for(int i = 0; i < 28-nameLength; i++) {
			hoTen += " ";
		}
		
		//handle gender output
		String genderText;
		if(gioiTinh == true) {
			genderText = "nam   ";
		}else {
			genderText = "nu    ";
		}
		
		//Handle luong
		String luongTam = String.format("%d", luong);
		int luongLength = luongTam.length();
		for(int i = 0; i < 9-luongLength; i++) {
			luongTam += " ";
		}
		//output row
		System.out.println("| " + maNv + " | " + hoTen + " | " + ngaySinh + "/" + thangSinh + "/" + namSinh + " | " + genderText + " | " + calam + " | " + luongTam + " |");
		System.out.println("+-------+------------------------------+------------+--------+---+-----------+");
    }
	/*==========WRITE FILE===========*/
	public void ghiFile(String fileName)throws IOException {
		DataOutputStream out = null;
		try {
			out =  new DataOutputStream(new FileOutputStream(fileName, Boolean.TRUE));
			out.writeUTF(maNv);
			out.writeUTF(hoNv);
			out.writeUTF(tenNv);
			out.writeUTF(ngaySinh);
			out.writeUTF(thangSinh);
			out.writeUTF(namSinh);
			out.writeBoolean(gioiTinh);
			out.writeInt(calam);
			out.writeInt(luong);
		}catch(IOException e) {}
		finally {
			out.close();
		}
	}
}
