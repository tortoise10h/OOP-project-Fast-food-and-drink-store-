/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfoodanddrinkstore;
import java.util.*;
import java.io.*;
/**
 *
 * @author Admin
 */
public class DSTheoDoiKhachHang 
{
    Scanner in = new Scanner(System.in);
	private int soLuongKhTD;
	private TheoDoiKhachHang[] ds;
	//Constructor
    public DSTheoDoiKhachHang() {}
    public DSTheoDoiKhachHang(TheoDoiKhachHang[] ds, int soLuongKhTD) {
    	this.soLuongKhTD = soLuongKhTD;
    	this.ds = new TheoDoiKhachHang[this.soLuongKhTD];
    }
    public DSTheoDoiKhachHang(int soLuongKhTD) {
    	this.soLuongKhTD = soLuongKhTD;
    	ds = new TheoDoiKhachHang[this.soLuongKhTD];
    	for(int i = 0; i < soLuongKhTD; i++) {
    		ds[i] = new TheoDoiKhachHang();
    	}
    }
    public DSTheoDoiKhachHang(TheoDoiKhachHang[] ds) {
    	int dsLength = ds.length;
    	this.ds = new TheoDoiKhachHang[dsLength];
    	for(int i = 0;i < dsLength; i++) {
    		this.ds[i] = new TheoDoiKhachHang();
    		this.ds[i] = ds[i];
    	}
    }
    //Input & Output
    public void nhap() 
    {
       System.out.print("Nhap so luong khach hang can theo doi: ");
       soLuongKhTD = in.nextInt();
       ds = new TheoDoiKhachHang[soLuongKhTD];
        for(int i = 0; i < soLuongKhTD; i++) {
			ds[i] = new TheoDoiKhachHang();
			System.out.println("Nhap thong tin cua khach hang can theo doi "+(i+1));
		    ds[i].nhap();
		    System.out.println("");
		}
    }
    public void xuat() 
    {
        System.out.println("Danh sach khach hang can theo doi: \n");
    	System.out.println("+-------+------------------------------+------------+--------+---+-----------+");
    	System.out.println("| Ma kh |   Ngay bat dau mua   | Tong tien chi |");
    	System.out.println("+-------+------------------------------+------------+--------+---+-----------+");
		for(int i=0 ; i < soLuongKhTD; i++) {
			ds[i].xuat();
		}
//		System.out.println("\n\n");
//		for(int i=0 ; i < ds.length; i++) {
//			ds[i].xuat();
//		}
    }
    //add new employee: use input
    public void them() 
    {   while(true) {
        	System.out.println("Nhap vao thong tin cua khach hang can theo doi can them: ");
            TheoDoiKhachHang kt = new TheoDoiKhachHang();
            kt.nhap();
            
            //check id of new employee
            boolean isDuplicate = false;
            for(int i = 0; i < soLuongKhTD; i++) {
            	if(ds[i].getMaKh().toLowerCase().equals(kt.getMaKh())) {
            		isDuplicate = true;
            	}
            }
            
            if(isDuplicate == false) {
            	ds = Arrays.copyOf(ds, soLuongKhTD + 1);
            	soLuongKhTD += 1;
                ds[soLuongKhTD - 1] = new TheoDoiKhachHang();
                ds[soLuongKhTD - 1] = kt;
                break;
            }else {
            	System.out.println("Khach hang can theo doi vua them co ma trung voi khach hang can theo doi truoc do, xin moi nhap lai thong tin!!!");
            }
        }
    }
    //add new employee: use given customer vairable
    public void them(TheoDoiKhachHang kt) {
    	ds = Arrays.copyOf(ds, ds.length + 1);
        ds[ds.length - 1] = kt;
    }
    //add new employees : use input
    public void them(int soLuongKhTD) {
        System.out.println("Nhap vao thong tin cua cac khach hang can theo doi: ");
    	int oldLength = this.soLuongKhTD;
    	this.soLuongKhTD += soLuongKhTD;
    	ds = Arrays.copyOf(ds, this.soLuongKhTD);
    	for(int i= oldLength; i < this.soLuongKhTD; i++) {
    		ds[i] = new TheoDoiKhachHang();
    		ds[i].nhap();
    		System.out.println("");
    	}
    }
    //Search with given maKh
    public int timKiem(String maKh) 
    {
        for(int i=0;i<soLuongKhTD;i++) 
        {
            if(maKh.equals(ds[i].getMaKh()) == true) 
            	return i;
        }
        return -1;
    }
    //Search with input maKh
    public int timKiem() {
    	String maKh;
    	while(true) {
			System.out.print("Nhap vao ma khach hang can theo doi can tim kiem (5 so): ");
			maKh = in.nextLine();
			if(maKh.length() == 5) {
				break;
			}
		}
    	for(int i = 0; i < soLuongKhTD; i++) {
    		if(maKh.equals(ds[i].getMaKh()) == true) {
    			return i;
    		}
    	}
    	return -1;
    }
    //Adjust with given maKh
    public void sua(String maKh) {
    	int pos = timKiem(maKh);
    	while(true) {
    		System.out.println("Moi ban nhap lai thong tin moi cua khach hang can theo doi nay:");
        	//use temporary variable type KhachHang to check id of new employee
        	TheoDoiKhachHang khTemp = new TheoDoiKhachHang();
        	khTemp.nhap();
        	boolean isDuplicate = false;
        	//check duplicate
        	for(int i = 0; i < soLuongKhTD; i++) {
        		if(khTemp.getMaKh().equals(ds[i].getMaKh()) && i != pos) {
        			isDuplicate = true;
        		}
        	}
        	if(isDuplicate == false) {
        		ds[pos] = new TheoDoiKhachHang(khTemp);
        		System.out.println("Chinh sua thong tin thanh cong!!!");
        		break;
        	}else {
        		System.out.println("Ma cua khach hang can theo doi moi cua ban trung voi khach hang can theo doi truoc do, xin vui long nhap lai thong tin!!!");
        	}
    	}
    }
    // Adjust with input makh
    public void sua() {
    	String maKh;
    	while(true) {
			System.out.print("Nhap vao khach hang can theo doi can sua thong tin (5 so): ");
			maKh = in.nextLine();
			if(maKh.length() == 5) {
				break;
			}
		}
    	int pos = timKiem(maKh);
    	while(true) {
    		System.out.println("Moi ban nhap lai thong tin moi cua khach hang can theo doi nay:");
        	//use temporary variable type KhachHang to check id of new employee
        	TheoDoiKhachHang khTemp = new TheoDoiKhachHang();
        	khTemp.nhap();
        	boolean isDuplicate = false;
        	//check duplicate
        	for(int i = 0; i < soLuongKhTD; i++) {
        		if(khTemp.getMaKh().equals(ds[i].getMaKh()) && i != pos) {
        			isDuplicate = true;
        		}
        	}
        	if(isDuplicate == false) {
        		ds[pos] = new TheoDoiKhachHang(khTemp);
        		System.out.println("Chinh sua thong tin thanh cong!!!");
        		break;
        	}else {
        		System.out.println("Ma cua khach hang can theo doi moi cua ban trung voi mot khach hang can theo doi truoc do, xin vui long nhap lai thong tin!!!");
        	}
    	}
    }
    //Delete 1 employee with given maKh
    public void xoa(String maKh) {
		int pos = timKiem(maKh);
		for(int i = pos; i < soLuongKhTD - 1; i++) {
			ds[i] = ds[i+1];
		}
		ds = Arrays.copyOf(ds, soLuongKhTD - 1);
		soLuongKhTD -= 1;
	}
    //Delete 1 employee with input makh
    public void xoa() {
    	String maKh;
    	while(true) {
			System.out.print("Nhap vao ma khach hang can theo doi can xoa (5 so): ");
			maKh = in.nextLine();
			if(maKh.length() == 5) {
				break;
			}
		}
    	int pos = timKiem(maKh);
		for(int i = pos; i < soLuongKhTD - 1; i++) {
			ds[i] = ds[i+1];
		}
		ds = Arrays.copyOf(ds, soLuongKhTD - 1);
		soLuongKhTD -= 1;
	}
//    Thong ke
    public boolean sosanh(String[] d1, String d2[]) {
		if(d1[2].compareTo(d2[2]) > 0) return true;
		else if(d1[2].compareTo(d2[2]) < 0) return false;
		else {
			if(d1[1].compareTo(d2[1]) > 0) return true;
			else if(d1[1].compareTo(d2[1]) < 0) return false;
			else {
				if(d1[0].compareTo(d2[0]) > 0) return true;
				else if(d1[0].compareTo(d2[0]) < 0) return false;
				else return true;
			}
		}
	}
	public boolean checkThongKe(String[] d1, String[] d2,int i) {
		
		String[] ngay = new String[3];
		ngay[0] = ds[i].getngayMua();
		ngay[1] = ds[i].getthangMua();
		ngay[2] = ds[i].getnamMua();
		if(sosanh(ngay,d1) && sosanh(ngay,d2) == false)
			return true;
		else return false;
	}
	
	//thong ke theo ngay thang
	public void thongke(String d1, String d2) {
		String[] t1 = d1.split("/");
		String[] t2 = d2.split("/");
		if(t1.length != 3 || t2.length != 3) {
			System.out.println("Khong ton tai khach hang mua trong thoi gian do.");
			return;
		}
		boolean check = true;
		for(int i=0; i< this.soLuongKhTD; i++ )
			if(checkThongKe(t1, t2, i)) {
				ds[i].xuat();
				check = false;
			}
		
		if(check) System.out.println("Khong ton tai khach hang mua trong thoi gian do.");
	}
	
	public void thongKeTheoNgayThang() {
		Scanner sc = new Scanner(System.in);
		String t1,t2;
		System.out.print("Nhap ngay bat dau: ");
			t1 = sc.nextLine();
		System.out.print("Nhap ngay ket thuc:  ");
			t2 = sc.nextLine();
		thongke(t1,t2);
	}
    /*==========READ & WRITE FILE==========*/
    //write file
    public void ghiFile(String fileName)throws IOException{
    	DataOutputStream out = null;
    	try {
    		out = new DataOutputStream(new FileOutputStream(fileName));
    		for(int i = 0; i < soLuongKhTD; i++) {
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
    			ds[i] = new TheoDoiKhachHang();
    			ds[i].setMaKh(inp.readUTF());
    			ds[i].setngayMua(inp.readUTF());
    			ds[i].setthangMua(inp.readUTF());
    			ds[i].setnamMua(inp.readUTF());
    			ds[i].setTongtienchi(inp.readInt());
    			i++;
    		}
    	}catch(EOFException e) {}
    	finally {
    		this.soLuongKhTD = i;
    		inp.close();
    	}
    }
}
