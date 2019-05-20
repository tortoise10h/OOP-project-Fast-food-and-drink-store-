package fastfoodanddrinkstore;

import java.util.*;
import java.io.*;

public class DSKhachHang{
    KhachHang[] ds;
    int soLuongKh;
    Scanner in = new Scanner(System.in);
    /*==========CONSTRUCTOR==========*/
    public DSKhachHang() {
    	ds = new KhachHang[100];
    }
    public DSKhachHang(KhachHang[] ds, int soLuongKh) {
    	this.soLuongKh = soLuongKh;
    	this.ds = new KhachHang[this.soLuongKh];
    }
    public DSKhachHang(int soLuongKh) {
    	this.soLuongKh = soLuongKh;
    	ds = new KhachHang[this.soLuongKh];
    	for(int i = 0; i < soLuongKh; i++) {
    		ds[i] = new KhachHang();
    	}
    }
    public DSKhachHang(KhachHang[] ds) {
    	this.soLuongKh = ds.length;
    	this.ds = new KhachHang[this.soLuongKh];
    	for(int i = 0;i < this.soLuongKh; i++) {
    		this.ds[i] = new KhachHang();
    		this.ds[i] = ds[i];
    	}
    }
    /*==========GETTER & SETTER==========*/
    public KhachHang[] getDs() {
		return ds;
	}
	public void setDs(KhachHang[] ds) {
		this.ds = ds;
	}
	public int getSoLuongKh() {
		return soLuongKh;
	}
	public void setSoLuongKh(int soLuongKh) {
		this.soLuongKh = soLuongKh;
	}
    
    /*==========INPUT & OUTPUT==========*/
    public void nhap() 
    {
       System.out.print("Nhap so luong khach hang: ");
       soLuongKh = in.nextInt();
       ds = new KhachHang[soLuongKh];
        for(int i = 0; i < soLuongKh; i++) {
			ds[i] = new KhachHang();
			System.out.println("Nhap thong tin khach hang "+(i+1));
		    ds[i].nhap();
		    System.out.println("");
		}
    }
 
	public void xuat() 
    {
    	System.out.println("Danh sach khach hang: \n");
    	System.out.println("+-------+------------------------------+--------+------------+--------------------------------------------------------------------------------------------+");
    	System.out.println("| Ma kh |          Ho va ten           | Gtinh  |    sodt    |                                               Dia chi                                      |");
    	System.out.println("+-------+------------------------------+--------+------------+--------------------------------------------------------------------------------------------+");
		for(int i=0 ; i < soLuongKh; i++) {
			ds[i].xuat();			
		}
    }
    /*===========ADD==========*/
    //add new customer: use input
    public void them() 
    {   
        System.out.println("Nhap vao thong tin cua khach hang moi");
        KhachHang kh = new KhachHang();
        String makh;
        while(true) {
        	do{
    			System.out.print("- Nhap vao ma khach hang(5 ki tu): ");
    			makh = in.nextLine();
    		}while(makh.length()!=5);
            //check duplicate makh
            boolean isDuplicate = false;
            for(int i = 0; i < soLuongKh; i++) {
            	if(ds[i].getMaKh().equals(makh) == true) {
            		isDuplicate = true;
            	}
            }
            if(isDuplicate == false) {
            	break;
            }else {
            	System.out.println("!!!Ma khach hang bi trung, xin moi nhap lai!!!\n");
            }
        }
        
        kh.nhap(makh);
        //check id of new customer
    	ds = Arrays.copyOf(ds, soLuongKh + 1);
        soLuongKh += 1;
        ds[soLuongKh - 1] = new KhachHang();
        ds[soLuongKh - 1] = kh;
        System.out.println("\n!!!Them khach hang moi moi thanh cong!!!\n");
    }
    //add new customer: use given customer vairable
    public void them(KhachHang kh) {
    	ds = Arrays.copyOf(ds, soLuongKh + 1);
    	soLuongKh += 1;
        ds[soLuongKh - 1] = kh;
    }
    //add new customers : use input
    public void them(int soLuongKh) {
    	System.out.println("Nhap vao thong tin cua cac khach hang moi");
    	int oldLength = this.soLuongKh;
    	this.soLuongKh += soLuongKh;
    	ds = Arrays.copyOf(ds, this.soLuongKh);
    	for(int i= oldLength; i < this.soLuongKh; i++) {
    		System.out.println("\nThem vao khach hang thu " + (i-oldLength+1) + " : ");
            KhachHang kh = new KhachHang();
            String makh;
            while(true) {
            	do{
        			System.out.print("- Nhap ma khach hang(5 ki tu): ");
        			makh = in.nextLine();
        		}while(makh.length()!=5);
                //check duplicate makh
                boolean isDuplicate = false;
                for(int j = 0; j < i; j++) {
                	if(ds[j].getMaKh().equals(makh) == true) {
                		isDuplicate = true;
                	}
                }
                if(isDuplicate == false) {
                	break;
                }else {
                	System.out.println("\n!!!Ma khach hang bi trung, xin moi nhap lai!!!\n");
                }
            }
            
            kh.nhap(makh);
        	ds[i] = new KhachHang();
        	ds[i] = kh;
    	}
    	System.out.println("\n!!!Them thanh cong!!!\n");
    }
    /*===========SEARCH==========*/
    //Search with given maKh
    public int timKiem(String maKh) 
    {
        for(int i=0;i<soLuongKh;i++) 
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
			System.out.print("Nhap vao ma khach hang can tim kiem (5 so): ");
			maKh = in.nextLine();
			if(maKh.length() == 5) {
				break;
			}
		}
    	for(int i = 0; i < soLuongKh; i++) {
    		if(maKh.equals(ds[i].getMaKh()) == true) {
    			return i;
    		}
    	}
    	return -1;
    }
    //Search with name: given name
    public void timTheoTen(String ten) {
    	ten = ten.toLowerCase();
    	boolean check = false;
    	System.out.println("+-------+------------------------------+--------+------------+--------------------------------------------------------------------------------------------+");
    	System.out.println("| Ma kh |          Ho va ten           | Gtinh  |    sodt    |                                               Dia chi                                      |");
    	System.out.println("+-------+------------------------------+--------+------------+--------------------------------------------------------------------------------------------+");
    	for(int i = 0; i < soLuongKh; i++) {
    		String temp = ds[i].getTenKh().toLowerCase();
    		if(temp.indexOf(ten) > -1) {
    			ds[i].xuat();
    			check = true;
    		}
    	}
    	if(check == false) {
    		System.out.println("Ten cua khach hang ban can tim kiem khong co trong danh sach!!!");
    	}
    }
    //Search with name: input name
    public void timTheoTen() {
    	System.out.println("Nhap vao ten ma ban can tim kiem: ");
    	String ten = in.nextLine();
    	ten = ten.toLowerCase();
    	boolean check =  false;
    	System.out.println("+-------+------------------------------+--------+------------+--------------------------------------------------------------------------------------------+");
    	System.out.println("| Ma kh |          Ho va ten           | Gtinh  |    sodt    |                                               Dia chi                                      |");
    	System.out.println("+-------+------------------------------+--------+------------+--------------------------------------------------------------------------------------------+");
    	for(int i = 0; i < soLuongKh; i++) {
    		String temp = ds[i].getTenKh().toLowerCase();
    		if(temp.indexOf(ten) > -1) {
    			ds[i].xuat();
    			check = true;
    		}
    	}
    	if(check == false) {
    		System.out.println("Ten cua khach hang ban can tim kiem khong co trong danh sach!!!");
    	}
    }
    //Search with last name: given last name
    public void timTheoHo(String ho) {
    	ho = ho.toLowerCase();
    	boolean check =  false;
    	for(int i = 0; i < soLuongKh; i++) {
    		String temp = ds[i].getHoKh().toLowerCase();
    		if(temp.indexOf(ho) > -1) {
    			ds[i].xuat();
    			check = true;
    		}
    	}
    	if(check == false) {
    		System.out.println("Ho cua khach hang ban can tim kiem khong co trong danh sach!!!!");
    	}
    }
    //Search with last name: input last name
    public void timTheoHo() {
    	System.out.println("Nhap vao ho cua khach hang ban can tim kiem: ");
    	String ho = in.nextLine();
    	ho = ho.toLowerCase();
    	boolean check =  false;
    	System.out.println("+-------+------------------------------+--------+------------+--------------------------------------------------------------------------------------------+");
    	System.out.println("| Ma kh |          Ho va ten           | Gtinh  |    sodt    |                                               Dia chi                                      |");
    	System.out.println("+-------+------------------------------+--------+------------+--------------------------------------------------------------------------------------------+");
    	for(int i = 0; i < soLuongKh; i++) {
    		String temp = ds[i].getHoKh().toLowerCase();
    		if(temp.indexOf(ho) > -1) {
    			ds[i].xuat();
    			check = true;
    		}
    	}
    	if(check == false) {
    		System.out.println("Ho cua khach hang ban can tim kiem khong co trong danh sach!!!!");
    	}
    }
    /*==========ADJUST===========*/
    //Adjust with given maKh
    public void sua(String maKh) {
    	int pos = timKiem(maKh);
    	if(pos == -1) {
    		System.out.println("\n!!!Khong tim thay khach hang!!!\n");
    	}else {
    		System.out.println("Moi ban nhap lai thong tin moi cua khach hang nay:");
        	KhachHang kh = new KhachHang();
        	String makh;
        	while(true) {
            	do{
        			System.out.print("- Nhap ma khach hang(5 ki tu): ");
        			makh = in.nextLine();
        		}while(makh.length()!=5);
                boolean isDuplicate = false;
                for(int i = 0; i < soLuongKh; i++) {
                	if(ds[i].getMaKh().equals(makh) == true && i != pos) {
                		isDuplicate = true;
                	}
                }
                if(isDuplicate == false) {
                	break;
                }else {
                	System.out.println("\n!!!Ma khach hang bi trung, xin moi nhap lai!!!\n");
                }
            }
        	kh.nhap(makh);
        	ds[pos] = new KhachHang(kh);
    	}
    }
    // Adjust with input makh
    public void sua() {
    	String maKh;
    	while(true) {
			System.out.print("Nhap vao ma cua khach hang can sua thong tin (5 so): ");
			maKh = in.nextLine();
			if(maKh.length() == 5) {
				break;
			}
		}
    	int pos = timKiem(maKh);
    	if(pos == -1) {
    		System.out.println("\n!!!Khong tim thay khach hang!!!\n");
    	}else {
    		System.out.println("Moi ban nhap lai thong tin moi cua khach hang nay:");
        	KhachHang kh = new KhachHang();
        	String makh;
        	while(true) {
            	do{
        			System.out.print("- Nhap ma khach hang(5 ki tu): ");
        			makh = in.nextLine();
        		}while(makh.length()!=5);
                boolean isDuplicate = false;
                for(int i = 0; i < soLuongKh; i++) {
                	if(ds[i].getMaKh().equals(makh) == true && i != pos) {
                		isDuplicate = true;
                	}
                }
                if(isDuplicate == false) {
                	break;
                }else {
                	System.out.println("\n!!!Ma khach hang, xin moi nhap lai!!!\n");
                }
            }
        	kh.nhap(makh);
        	ds[pos] = new KhachHang(kh);
    	}
    	
    }
    /*============DELETE===========*/
    //Delete 1 customer with given maKh
    public void xoa(String maKh) {
		int pos = timKiem(maKh);
		if(pos == -1) {
			System.out.println("\n!!!Khong tim thay khach hang de xoa!!!\n");
		}else {
			for(int i = pos; i < soLuongKh - 1; i++) {
				ds[i] = ds[i+1];
			}
			ds = Arrays.copyOf(ds, soLuongKh - 1);
			soLuongKh -= 1;
		}
	}
    //Delete 1 customer with input makh
    public void xoa() {
    	String maKh;
    	while(true) {
			System.out.print("Nhap vao ma khach hang can xoa (5 so): ");
			maKh = in.nextLine();
			if(maKh.length() == 5) {
				break;
			}
		}
    	int pos = timKiem(maKh);
    	if(pos == -1) {
			System.out.println("\n!!!Khong tim thay khach hang de xoa!!!\n");
		}else {
			for(int i = pos; i < soLuongKh - 1; i++) {
				ds[i] = ds[i+1];
			}
			ds = Arrays.copyOf(ds, soLuongKh - 1);
			soLuongKh -= 1;
			System.out.println("\n!!!Xoa thanh cong!!!\n");
		}
	}
    /*===========STATISTIC==========*/
    //Statistic by gender: given gender
    public void thongKe(String gioiTinh) {
    	boolean temp;
    	if(gioiTinh.equals("nam") == true) {
    		temp = true;
    	}else{
    		temp = false;
    	}
    	System.out.println("+-------+------------------------------+--------+------------+--------------------------------------------------------------------------------------------+");
    	System.out.println("| Ma kh |          Ho va ten           | Gtinh  |    sodt    |                                               Dia chi                                      |");
    	System.out.println("+-------+------------------------------+--------+------------+--------------------------------------------------------------------------------------------+");
    	for(int i = 0; i < ds.length; i++) {
    		if(ds[i].isGioiTinh() == temp) {
    			ds[i].xuat();
    		}
    	}
    }
    //Statistic by gender: input gender
    public void thongKe() {
    	String gioiTinh;
    	System.out.print("Nhap vao gioi tinh cua khach hang ma ban muon thong ke: ");
    	gioiTinh = in.nextLine();
    	boolean temp;
    	if(gioiTinh.equals("nam") == true) {
    		temp = true;
    	}else{
    		temp = false;
    	}
    	System.out.println("+-------+------------------------------+--------+------------+--------------------------------------------------------------------------------------------+");
    	System.out.println("| Ma kh |          Ho va ten           | Gtinh  |    sodt    |                                               Dia chi                                      |");
    	System.out.println("+-------+------------------------------+--------+------------+--------------------------------------------------------------------------------------------+");
    	for(int i = 0; i < soLuongKh; i++) {
    		if(ds[i].isGioiTinh() == temp) {
    			ds[i].xuat();
    		}
    	}
    }
    /*==========BUY==========*/
	public void muaHang() throws Exception{
		//get all product to show customer when they buy
		DSSanPham dsSp = new DSSanPham();
		dsSp.docFile("src/sanpham.txt");
		SanPham[] listSp = dsSp.getDs();
		
		//get 'dshoadonxuat' to create new 'hoadonxuat' after buy
		DSHoaDonXuat dsHdx = new DSHoaDonXuat();
		dsHdx.docFile("src/hoadonxuat.txt");
		
		//show product list for customer
		System.out.println("!!!Moi ban tham khao danh sach san pham truoc khi mua hang!!!\n");
		dsSp.xuat();
		System.out.println("");
		
		//create 2 arrays to store products and quantity of each product
		String[] sanPham;
		int[] sluong;
		
		//buy
		int sluongSanPham; //quanity of chitiethoadonxuat
		System.out.print("Ban muon mua bao nhieu san pham: ");
		sluongSanPham = in.nextInt();
		in.nextLine();
		
		sanPham = new String[sluongSanPham];
		sluong = new int[sluongSanPham];
		
		System.out.println("Moi ban chon san pham muon mua va so luong cua moi san pham");
		for(int i = 0; i < sluongSanPham; i++) {
			System.out.println("\n- San pham thu " + (i+1));
			//Handle masp input
			while(true) {
				do {
					System.out.print(" .Ma san pham (5 ki tu): ");
					sanPham[i] = in.nextLine();
				}while(sanPham[i].length()!=5);
				if(dsSp.timKiem(sanPham[i]) != -1) {
					break;
				}else {
					System.out.println("\n!!!San pham khong ton tai, xin moi nhap lai!!!\n");
				}
			}

			//Handle quantity input
			int pos = dsSp.timKiem(sanPham[i]);
			int oldQuantity = listSp[pos].getSoluongco();
			while(true) {
				do{
					System.out.print(" .So luong: ");
					sluong[i] = in.nextInt();
					in.nextLine();
				}while(sluong[i] <= 0);
				if(sluong[i] > oldQuantity) {
					System.out.println("\n!!!So luong ban can mua lon hon so luong hien co cua san pham!!!\n");
				}else {
					break;
				}
				
			}
			//reduce quanitty of product
			
			listSp[pos].setSoluongco(oldQuantity - sluong[i]);
		}
		
		System.out.println("Tien hanh xuat hoa don");
		dsHdx.them(sanPham,sluong,sluongSanPham);
		//save change
		dsHdx.ghiFile("src/hoadonxuat.txt");
		dsSp.ghiFile("src/sanpham.txt");
		System.out.println("\n!!!Mua hang thanh cong!!!\n");
	}
    /*=========READ & WRITE FILE=========*/
    public void ghiFile(String fileName)throws IOException {
    	DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName));
    	try {
    		for(int i = 0; i < soLuongKh; i++) {
    			ds[i].ghiFile(fileName);
    		}
    	}catch(IOException e) {}
    	finally {
    		out.close();
    	}
    }
    public void docFile(String fileName)throws IOException{
    	DataInputStream inp = new DataInputStream(new FileInputStream(fileName));
    	int i = 0;
    	try {
    		while(true) {
    			String maKh = inp.readUTF();
    			String tenKh = inp.readUTF();
    			String hoKh = inp.readUTF();
    			boolean gioiTinh = inp.readBoolean();
    			String diaChi = inp.readUTF();
    			String soDt = inp.readUTF();
    			ds[i] = new KhachHang(maKh,tenKh,hoKh,gioiTinh,diaChi,soDt);
    			i++;
    		}
    	}catch(EOFException e) {}
    	finally {
    		this.soLuongKh = i;
    		inp.close();
    	}
    }
}
