package fastfoodanddrinkstore;
import java.util.*;
import java.io.*;

public class KhachHang{
	Scanner in = new Scanner(System.in);
    private String maKh;
    private String tenKh;
    private String hoKh;
    private boolean gioiTinh;
    private String diaChi;
    private String soDt;
   
    /*==========CONSTRUCTOR==========*/
    public KhachHang() {}
    public KhachHang(String maKh, String tenKh, String hoKh, boolean gioiTinh, String diaChi, String soDt) {
    	this.maKh = maKh;
    	this.tenKh = tenKh;
    	this.hoKh = hoKh;
    	this.gioiTinh = gioiTinh;
    	this.diaChi = diaChi;
    	this.soDt = soDt;
    }
    public KhachHang(KhachHang kh) {
    	maKh = kh.maKh;
    	tenKh = kh.tenKh;
    	hoKh = kh.hoKh;
    	gioiTinh = kh.gioiTinh;
    	diaChi = kh.diaChi;
    	soDt = kh.soDt;
    }
    /*==========GETTER & SETTER==========*/
    public String getMaKh() {
		return maKh;
	}
	public void setMaKh(String maKh) {
		this.maKh = maKh;
	}
	public String getTenKh() {
		return tenKh;
	}
	public void setTenKh(String tenKh) {
		this.tenKh = tenKh;
	}
	public String getHoKh() {
		return hoKh;
	}
	public void setHoKh(String hoKh) {
		this.hoKh = hoKh;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSoDt() {
		return soDt;
	}
	public void setSoDt(String soDt) {
		this.soDt = soDt;
	}
    /*=========INPUT & OUTPUT==========*/
    public void nhap()
    {
    	RemoveRedundantSpace rp = new RemoveRedundantSpace();
    	//Enter maKh
        while(true) {
			System.out.print("- Nhap vao ma khach hang (5 so): ");
			maKh = in.nextLine();
			if(maKh.length() == 5) {
				break;
			}
		}
        
        //Enter hoKh
		while(true) {
			System.out.print("- Nhap vao ho va chu lot cua khach hang: ");
			hoKh = in.nextLine();
			if(hoKh.equals(" ") == false && hoKh.equals("") == false && hoKh.equals(null) == false) {
				break;
			}
		}
		hoKh = rp.removeSpace(hoKh);		//remove all redundant space from user input
		
		//Enter tenKh
		while(true) {
			System.out.print("- Nhap vao ten cua khach hang: ");
			tenKh = in.nextLine();
			if(tenKh.equals(" ") == false && tenKh.equals("") == false && tenKh.equals(null) == false) {
				break;
			}
		}
		tenKh = rp.removeSpace(tenKh);	 //remove all redundant space from user input
		
		//Enter gender
		String genderText;
		while(true) {
			System.out.print("- Nhap vao gioi tinh cua khach hang (nam hoac nu): ");
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
		//Enter phone number
		do {
			System.out.print("- Nhap vao so dien thoai cua khach hang: ");
			soDt = in.nextLine();
		}while(soDt.length() != 10);
		
		//Enter address
		while(true) {
			System.out.print("- Nhap vao dia chi cua khach hang: ");
			diaChi = in.nextLine();
			if(diaChi.equals(" ") == false && diaChi.equals("") == false && diaChi.equals(null) == false) {
				break;
			}
		}
    }
    
    public void nhap(String makh)
    {
    	RemoveRedundantSpace rp = new RemoveRedundantSpace();
    	//Enter maKh
        this.maKh = makh;
        
        //Enter hoKh
		while(true) {
			System.out.print("- Nhap vao ho va chu lot cua khach hang: ");
			hoKh = in.nextLine();
			if(hoKh.equals(" ") == false && hoKh.equals("") == false && hoKh.equals(null) == false) {
				break;
			}
		}
		hoKh = rp.removeSpace(hoKh);		//remove all redundant space from user input
		
		//Enter tenKh
		while(true) {
			System.out.print("- Nhap vao ten cua khach hang: ");
			tenKh = in.nextLine();
			if(tenKh.equals(" ") == false && tenKh.equals("") == false && tenKh.equals(null) == false) {
				break;
			}
		}
		tenKh = rp.removeSpace(tenKh);	 //remove all redundant space from user input
		
		//Enter gender
		String genderText;
		while(true) {
			System.out.print("- Nhap vao gioi tinh cua khach hang (nam hoac nu): ");
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
		//Enter phone number
		do {
			System.out.print("- Nhap vao so dien thoai cua khach hang: ");
			soDt = in.nextLine();
		}while(soDt.length() != 10);
		
		//Enter address
		while(true) {
			System.out.print("- Nhap vao dia chi cua khach hang: ");
			diaChi = in.nextLine();
			if(diaChi.equals(" ") == false && diaChi.equals("") == false && diaChi.equals(null) == false) {
				break;
			}
		}
    }
    
    
	public void xuat()
    {
		//handle name output
		String hoTen = hoKh + " " + tenKh;
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
		
		//Handle address
		int addressLength = diaChi.length();
		String diaChiTam = diaChi;
		for(int i = 0; i < 90 - addressLength; i++) {
			diaChiTam += " ";
		}
		//output row
		System.out.println("| " + maKh + " | " + hoTen + " | " + genderText + " | "  + soDt + " | " + diaChiTam + " |");
		System.out.println("+-------+------------------------------+--------+------------+--------------------------------------------------------------------------------------------+");
		
    }
	
	
	/*==========WRITE FILE==========*/
	public void ghiFile(String fileName)throws IOException {
		DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName, Boolean.TRUE));
		try {
			out.writeUTF(maKh);
			out.writeUTF(tenKh);
			out.writeUTF(hoKh);
			out.writeBoolean(gioiTinh);
			out.writeUTF(diaChi);
			out.writeUTF(soDt);
		}catch(IOException e) {}
		finally {
			out.close();
		}
	}
}
