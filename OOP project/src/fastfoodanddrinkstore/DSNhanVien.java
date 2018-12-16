package fastfoodanddrinkstore;

import java.util.*;
import java.io.*;
public class DSNhanVien {
	Scanner in = new Scanner(System.in);
	private int soLuongNv;
	private NhanVien[] ds;
	//Constructor
    public DSNhanVien() {
    	ds = new NhanVien[100];
    }
    public DSNhanVien(NhanVien[] ds, int soLuongNv) {
    	this.soLuongNv = soLuongNv;
    	this.ds = new NhanVien[this.soLuongNv];
    }
    public DSNhanVien(int soLuongNv) {
    	this.soLuongNv = soLuongNv;
    	this.ds = new NhanVien[this.soLuongNv];
    	for(int i = 0; i < soLuongNv; i++) {
    		ds[i] = new NhanVien();
    	}
    }
    public DSNhanVien(NhanVien[] ds) {
    	this.soLuongNv = ds.length;
    	this.ds = new NhanVien[this.soLuongNv];
    	for(int i = 0;i < soLuongNv; i++) {
    		this.ds[i] = new NhanVien();
    		this.ds[i] = ds[i];
    	}
    }
    /*==========GETTER & SETTER=========*/
    public int getSoLuongNv() {
		return soLuongNv;
	}
	public void setSoLuongNv(int soLuongNv) {
		this.soLuongNv = soLuongNv;
	}
	public NhanVien[] getDs() {
		return ds;
	}
	public void setDs(NhanVien[] ds) {
		this.ds = ds;
	}
    
    
    //Input & Output
    public void nhap() 
    {
       System.out.print("Nhap so luong nhan vien: ");
       soLuongNv = in.nextInt();
       ds = new NhanVien[soLuongNv];
        for(int i = 0; i < soLuongNv; i++) {
			ds[i] = new NhanVien();
			System.out.println("Nhap thong tin cua nhan vien "+(i+1));
		    ds[i].nhap();
		    System.out.println("");
		}
    }
    
	public void xuat() 
    {	System.out.println("Danh sach nhan vien: \n");
    	System.out.println("+-------+------------------------------+------------+--------+---+-----------+");
    	System.out.println("| Ma nv |          Ho va ten           | Ngay sinh  | Gtinh  |Ca | Luong     |");
    	System.out.println("+-------+------------------------------+------------+--------+---+-----------+");
		for(int i=0 ; i < soLuongNv; i++) {
			ds[i].xuat();
		}
		System.out.println("\n\n");
    }
    //add new employee: use input
    public void them() 
    {   
    	System.out.println("Nhap vao thong tin cua nhan vien moi: ");
    	NhanVien nv = new NhanVien();
        String manv;
        while(true) {
        	do{
    			System.out.print("- Nhap vao ma nhan vien (5 ki tu): ");
    			manv = in.nextLine();
    		}while(manv.length()!=5);
            //check duplicate manv
            boolean isDuplicate = false;
            for(int i = 0; i < soLuongNv; i++) {
            	if(ds[i].getMaNv().equals(manv) == true) {
            		isDuplicate = true;
            	}
            }
            if(isDuplicate == false) {
            	break;
            }else {
            	System.out.println("!!!Ma nhan vien bi trung, xin moi nhap lai!!!\n");
            }
        }
        
        nv.nhap(manv);
        //check id of new employee
    	ds = Arrays.copyOf(ds, soLuongNv + 1);
        soLuongNv += 1;
        ds[soLuongNv - 1] = new NhanVien();
        ds[soLuongNv - 1] = nv;
        System.out.println("\n!!!Them nhan vien moi moi thanh cong!!!\n");
    }
    //add new employee: use given customer vairable
    public void them(NhanVien nv) {
    	ds = Arrays.copyOf(ds, ds.length + 1);
        ds[ds.length - 1] = nv;
    }
    //add new employees : use input
    public void them(int soLuongNv) {
    	System.out.println("Nhap vao thong tin cua cac nhan vien moi");
    	int oldLength = this.soLuongNv;
    	this.soLuongNv += soLuongNv;
    	ds = Arrays.copyOf(ds, this.soLuongNv);
    	for(int i= oldLength; i < this.soLuongNv; i++) {
    		System.out.println("Nhap vao nhan vien thu " + (i-oldLength-1));
            NhanVien nv = new NhanVien();
            String manv;
            while(true) {
            	do{
        			System.out.print("- Nhap ma nhan vien (5 ki tu): ");
        			manv = in.nextLine();
        		}while(manv.length()!=5);
                //check duplicate manv
                boolean isDuplicate = false;
                for(int j = 0; j < i; j++) {
                	if(ds[j].getMaNv().equals(manv) == true) {
                		isDuplicate = true;
                	}
                }
                if(isDuplicate == false) {
                	break;
                }else {
                	System.out.println("\n!!!Ma nhan vien bi trung, xin moi nhap lai!!!\n");
                }
            }
            
            nv.nhap(manv);
        	ds[i] = new NhanVien();
        	ds[i] = nv;
    	}
    	System.out.println("\n!!!Them thanh cong!!!\n");
    }
    //Search with given maNv
    public int timKiem(String maNv) 
    {
        for(int i=0;i<soLuongNv;i++) 
        {
            if(maNv.equals(ds[i].getMaNv()) == true) 
            	return i;
        }
        return -1;
    }
    //Search with input maNv
    public int timKiem() {
    	String maKh;
    	while(true) {
			System.out.print("Nhap vao ma nhan vien can tim kiem (5 so): ");
			maKh = in.nextLine();
			if(maKh.length() == 5) {
				break;
			}
		}
    	for(int i = 0; i < soLuongNv; i++) {
    		if(maKh.equals(ds[i].getMaNv()) == true) {
    			return i;
    		}
    	}
    	return -1;
    }
    //Search with name: given name
    public void timTheoTen(String ten) {
    	ten = ten.toLowerCase();
    	boolean check = false;
    	System.out.println("+-------+------------------------------+------------+--------+---+-----------+");
    	System.out.println("| Ma nv |          Ho va ten           | Ngay sinh  | Gtinh  |Ca | Luong     |");
    	System.out.println("+-------+------------------------------+------------+--------+---+-----------+");
    	for(int i = 0; i < soLuongNv; i++) {
    		String temp = ds[i].getTenNv().toLowerCase();
    		if(temp.indexOf(ten) > -1) {
    			ds[i].xuat();
    			check = true;
    		}
    	}
    	if(check == false) {
    		System.out.println("Ten cua nhan vien ban can tim kiem khong co trong danh sach!!!");
    	}
    }
    //Search with name: input name
    public void timTheoTen() {
    	System.out.print("Nhap vao ten nhan vien ma ban can tim kiem: ");
    	String ten = in.nextLine();
    	ten = ten.toLowerCase();
    	boolean check =  false;
    	System.out.println("+-------+------------------------------+------------+--------+---+-----------+");
    	System.out.println("| Ma nv |          Ho va ten           | Ngay sinh  | Gtinh  |Ca | Luong     |");
    	System.out.println("+-------+------------------------------+------------+--------+---+-----------+");
    	for(int i = 0; i < soLuongNv; i++) {
    		String temp = ds[i].getTenNv().toLowerCase();
    		if(temp.indexOf(ten) > -1) {
    			ds[i].xuat();
    			check = true;
    		}
    	}
    	if(check == false) {
    		System.out.println("Ten cua nhan vien ban can tim kiem khong co trong danh sach!!!");
    	}
    }
    //Search with last name: given last name
    public void timTheoHo(String ho) {
    	ho = ho.toLowerCase();
    	boolean check =  false;
    	System.out.println("+-------+------------------------------+------------+--------+---+-----------+");
    	System.out.println("| Ma nv |          Ho va ten           | Ngay sinh  | Gtinh  |Ca | Luong     |");
    	System.out.println("+-------+------------------------------+------------+--------+---+-----------+");
    	for(int i = 0; i < soLuongNv; i++) {
    		String temp = ds[i].getHoNv().toLowerCase();
    		if(temp.indexOf(ho) > -1) {
    			ds[i].xuat();
    			check = true;
    		}
    	}
    	if(check == false) {
    		System.out.println("Ho cua nhan vien ban can tim kiem khong co trong danh sach!!!!");
    	}
    }
    //Search with last name: input last name
    public void timTheoHo() {
    	System.out.println("Nhap vao ho cua nhan vien ban can tim kiem: ");
    	String ho = in.nextLine();
    	ho = ho.toLowerCase();
    	boolean check =  false;
    	System.out.println("+-------+------------------------------+------------+--------+---+-----------+");
    	System.out.println("| Ma nv |          Ho va ten           | Ngay sinh  | Gtinh  |Ca | Luong     |");
    	System.out.println("+-------+------------------------------+------------+--------+---+-----------+");
    	for(int i = 0; i < soLuongNv; i++) {
    		String temp = ds[i].getHoNv().toLowerCase();
    		if(temp.indexOf(ho) > -1) {
    			ds[i].xuat();
    			check = true;
    		}
    	}
    	if(check == false) {
    		System.out.println("Ho cua nhan vien ban can tim kiem khong co trong danh sach!!!!");
    	}
    }
    //Adjust with given maKh
    public void sua(String maNv) {
    	int pos = timKiem(maNv);
    	if(pos == -1) {
    		System.out.println("\n!!!Khong tim thay nhan vien can chinh sua thong tin!!!\n");
    	}else {
    		System.out.println("Moi ban nhap lai thong tin moi cua nhan vien nay");
        	NhanVien nv = new NhanVien();
        	String manv;
        	while(true) {
            	do{
        			System.out.print("- Nhap ma nhan vien (5 ki tu): ");
        			manv = in.nextLine();
        		}while(manv.length()!=5);
                boolean isDuplicate = false;
                for(int i = 0; i < soLuongNv; i++) {
                	if(ds[i].getMaNv().equals(manv) == true && i != pos) {
                		isDuplicate = true;
                	}
                }
                if(isDuplicate == false) {
                	break;
                }else {
                	System.out.println("\n!!!Ma nhan vien, xin moi nhap lai!!!\n");
                }
            }
        	nv.nhap(manv);
        	ds[pos] = new NhanVien(nv);
        	System.out.println("\n!!!Sua thong tin thanh cong!!!\n");
    	}
    }
    // Adjust with input makh
    public void sua() {
    	String maNv;
    	while(true) {
			System.out.print("Nhap vao nhan vien can sua thong tin (5 so): ");
			maNv = in.nextLine();
			if(maNv.length() == 5) {
				break;
			}
		}
    	sua(maNv);
    }
    //Delete 1 employee with given maKh
    public void xoa(String maNv) {
		int pos = timKiem(maNv);
		if(pos == -1) {
			System.out.println("\n!!!Khong tim thay nhan vien can xoa!!!\n");
		}else {
			for(int i = pos; i < soLuongNv - 1; i++) {
				ds[i] = ds[i+1];
			}
			ds = Arrays.copyOf(ds, soLuongNv - 1);
			soLuongNv -= 1;
		}
	}
    //Delete 1 employee with input makh
    public void xoa() {
    	String maNv;
    	while(true) {
			System.out.print("Nhap vao ma nhan vien can xoa (5 so): ");
			maNv = in.nextLine();
			if(maNv.length() == 5) {
				break;
			}
		}
    	int pos = timKiem(maNv);
		if(pos == -1) {
			System.out.println("\n!!!Khong tim thay nhan vien can xoa!!!\n");
		}else {
			for(int i = pos; i < soLuongNv - 1; i++) {
				ds[i] = ds[i+1];
			}
			ds = Arrays.copyOf(ds, soLuongNv - 1);
			soLuongNv -= 1;
			System.out.println("\n!!!Xoa thanh cong!!!\n");
		}
	}
    //Statistic by gender: given gender
    public void thongKeGioiTinh(String gioiTinh) {
    	boolean temp;
    	if(gioiTinh.equals("nam") == true) {
    		temp = true;
    	}else{
    		temp = false;
    	}
    	for(int i = 0; i < soLuongNv; i++) {
    		if(ds[i].isGioiTinh() == temp) {
    			ds[i].xuat();
    			System.out.println("");
    		}
    	}
    }
    //Statistic by gender: input gender
    public void thongKeGioiTinh() {
    	String gioiTinh;
    	System.out.print("Nhap vao gioi tinh nhan vien ma ban muon thong ke: ");
    	gioiTinh = in.nextLine();
    	boolean temp;
    	if(gioiTinh.equals("nam") == true) {
    		temp = true;
    	}else{
    		temp = false;
    	}
    	System.out.println("+-------+------------------------------+------------+--------+---+-----------+");
    	System.out.println("| Ma nv |          Ho va ten           | Ngay sinh  | Gtinh  |Ca | Luong     |");
    	System.out.println("+-------+------------------------------+------------+--------+---+-----------+");
    	for(int i = 0; i < soLuongNv; i++) {
    		if(ds[i].isGioiTinh() == temp) {
    			ds[i].xuat();
    		}
    	}
    }
    //Statistic by birthyear: given year
    public void thongKeNamSinh(int year) {
		int yearNum;
		int cnt = 0;
		System.out.println("Danh sach cac nhan vien sinh nam " + year + " : ");
		System.out.println("+-------+------------------------------+------------+--------+---+-----------+");
    	System.out.println("| Ma nv |          Ho va ten           | Ngay sinh  | Gtinh  |Ca | Luong     |");
    	System.out.println("+-------+------------------------------+------------+--------+---+-----------+");
		for(int i = 0; i < soLuongNv; i++) {
			yearNum = Integer.parseInt(ds[i].getNgaySinh().substring(4, 8));
			if(yearNum == year) {
				cnt++;
				ds[i].xuat();
			}
		}
		System.out.println("Tong so nha vien sinh nam " + year + " la: " + cnt);
	}
    //Statistic by birthyear: input
    public void thongKeNamSinh() {
    	int year;
    	System.out.print("Nhap nam sinh cua nhan vien ma ban muon thong ke: ");
    	year = in.nextInt();
		int yearNum;
		int cnt = 0;
		System.out.println("Danh sach cac nhan vien sinh nam " + year + " : ");
		System.out.println("+-------+------------------------------+------------+--------+---+-----------+");
    	System.out.println("| Ma nv |          Ho va ten           | Ngay sinh  | Gtinh  |Ca | Luong     |");
    	System.out.println("+-------+------------------------------+------------+--------+---+-----------+");
		for(int i = 0; i < soLuongNv; i++) {
			yearNum = Integer.parseInt(ds[i].getNamSinh());
			if(yearNum == year) {
				cnt++;
				ds[i].xuat();
			}
		}
		System.out.println("Tong so nha vien sinh nam " + year + " la: " + cnt);
	}
    public void thongKeCaLam(int calam) {
		int cnt = 0;
		System.out.println("Danh sach cac nhan vien lam ca " + calam + " : ");
		System.out.println("+-------+------------------------------+------------+--------+---+-----------+");
    	System.out.println("| Ma nv |          Ho va ten           | Ngay sinh  | Gtinh  |Ca | Luong     |");
    	System.out.println("+-------+------------------------------+------------+--------+---+-----------+");
		for(int i = 0; i < soLuongNv; i++) {
			if(ds[i].getCalam() == calam) {
				cnt++;
				ds[i].xuat();
			}
		}
		System.out.println("Tong so nhan vien lam ca " + calam + " la: " + cnt);
    }
    public void thongKeCaLam() {
    	int calam;
    	do {
    		System.out.print("Nhap vao ca lam cua nhan vien (ca 1, 2 va 3): ");
    		calam = in.nextInt();
    		in.nextLine();
    	}while(calam != 1 && calam != 2 && calam != 3);
		int cnt = 0;
		System.out.println("Danh sach cac nhan vien lam ca " + calam + " : ");
		System.out.println("+-------+------------------------------+------------+--------+---+-----------+");
    	System.out.println("| Ma nv |          Ho va ten           | Ngay sinh  | Gtinh  |Ca | Luong     |");
    	System.out.println("+-------+------------------------------+------------+--------+---+-----------+");
		for(int i = 0; i < soLuongNv; i++) {
			if(ds[i].getCalam() == calam) {
				cnt++;
				ds[i].xuat();
			}
		}
		System.out.println("Tong so nhan vien lam ca " + calam + " la: " + cnt);
    }
    /*==========READ & WRITE FILE==========*/
    //write file
    public void ghiFile(String fileName)throws IOException{
    	DataOutputStream out = null;
    	try {
    		out = new DataOutputStream(new FileOutputStream(fileName));
    		for(int i = 0; i < soLuongNv; i++) {
    			ds[i].ghiFile(fileName);
    		}
    	}catch(IOException e) {}
    	finally {
    		out.close();
    	}
    }
    //read file
    public void docFile(String fileName)throws IOException {
    	DataInputStream inp = null;
    	int i = 0;
    	try {
    		inp = new DataInputStream(new FileInputStream(fileName));
    		while(true) {
    			ds[i] = new NhanVien();
    			ds[i].setMaNv(inp.readUTF());
    			ds[i].setHoNv(inp.readUTF());
    			ds[i].setTenNv(inp.readUTF());
    			ds[i].setNgaySinh(inp.readUTF());
    			ds[i].setThangSinh(inp.readUTF());
    			ds[i].setNamSinh(inp.readUTF());
    			ds[i].setGioiTinh(inp.readBoolean());
    			ds[i].setCalam(inp.readInt());
    			ds[i].setLuong(inp.readInt());
    			i++;
    		}
    	}catch(EOFException e) {}
    	finally {
    		this.soLuongNv = i;
    		inp.close();
    	}
    }
}
