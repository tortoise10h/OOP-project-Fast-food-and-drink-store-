package fastfoodanddrinkstore;

import java.util.*;
import java.io.*;
public class DSHoaDonNhap {
	private HoaDonNhap[] ds;
    private int soluongHd;
    Scanner in = new Scanner(System.in);
    /*==========GETTER & SETTER=========*/
    public HoaDonNhap[] getDs() {
		return ds;
	}
	public void setDs(HoaDonNhap[] ds) {
		this.ds = ds;
	}
	public int getSoluongHd() {
		return soluongHd;
	}
	public void setSoluongHd(int soluongHd) {
		this.soluongHd = soluongHd;
	}
    /*=========CONSTRUCTOR=========*/
    public DSHoaDonNhap() {
    	soluongHd = 0;
    	ds = new HoaDonNhap[100];
    }
	public DSHoaDonNhap(HoaDonNhap[] ds, int soluongHd) 
    {
    	this.soluongHd = soluongHd;
    	this.ds = new HoaDonNhap[this.soluongHd];
    }
    public DSHoaDonNhap(int soluongHd) 
    {
    	this.soluongHd = soluongHd;
    	ds = new HoaDonNhap[this.soluongHd];
    	for(int i = 0; i < soluongHd; i++) {
    		ds[i] = new HoaDonNhap();
    	}
    }
    public DSHoaDonNhap(HoaDonNhap[] ds) 
    {
    	soluongHd = ds.length;
    	this.ds = new HoaDonNhap[soluongHd];
    	for(int i = 0;i < soluongHd; i++) {
    		this.ds[i] = new HoaDonNhap();
    		this.ds[i] = ds[i];
    	}
    }
    /*==========INPUT & OUTPUT==========*/
    public void nhap() throws Exception
    {
       System.out.print("Nhap so luong hoa don nhap: ");
       soluongHd = in.nextInt();
       in.nextLine();
       ds = new HoaDonNhap[soluongHd];
        for(int i = 0; i < soluongHd; i++) {
			ds[i] = new HoaDonNhap();
			System.out.println("Nhap thong tin cua hoa don xuat "+(i+1) +" : ");
		    ds[i].nhap();
		    System.out.println("");
		}
    }
    public void xuat() 
    {
    	System.out.println("+----------+------------+----------+----------+------------+");
    	System.out.println("|Ma Hoa Don| Ngay Nhap  | Ma Nvien |  Ma NCC  |  Tong Chi  |");
    	System.out.println("+----------+------------+----------+----------+------------+");
		for(int i=0 ; i < soluongHd; i++) {
			ds[i].xuat();
		}
    }
    /*==========ADD==========*/
    public void them() throws Exception
    {   
    	System.out.println("Nhap vao thong tin cua hoa don moi: ");
        HoaDonNhap hd = new HoaDonNhap();
        String mahd;
        while(true) {
        	do{
    			System.out.print("- Nhap ma hoa don(5 ky tu): ");
    			mahd = in.nextLine();
    		}while(mahd.length()!=5);
            //check duplicate mahd
            boolean isDuplicate = false;
            for(int i = 0; i < soluongHd; i++) {
            	if(ds[i].getMa().equals(mahd) == true) {
            		isDuplicate = true;
            	}
            }
            if(isDuplicate == false) {
            	break;
            }else {
            	System.out.println("Ma hoa don bi trung, xin moi nhap lai!!!\n");
            }
        }
        
        hd.nhap(mahd);
        //check id of new "hoa don xuat"
    	ds = Arrays.copyOf(ds, soluongHd + 1);
        soluongHd += 1;
        ds[soluongHd - 1] = new HoaDonNhap();
        ds[soluongHd - 1] = hd;
        System.out.println("\n!!Them thanh cong!!!\n");
    }

    
    public void them(int soluongHd) throws Exception{
    	System.out.println("Nhap vao thong tin cua cac hoa don moi: ");
    	int oldLength = this.soluongHd;
    	this.soluongHd += soluongHd;
    	ds = Arrays.copyOf(ds, this.soluongHd);
    	for(int i= oldLength; i < this.soluongHd; i++) {
    		System.out.println("\n# Nhap vao hoa don thu " + (i-oldLength+1));
            HoaDonNhap hd = new HoaDonNhap();
            String mahd;
            while(true) {
            	do{
        			System.out.print("- Nhap ma hoa don(5 ki tu): ");
        			mahd = in.nextLine();
        		}while(mahd.length()!=5);
                //check duplicate mahd
                boolean isDuplicate = false;
                for(int j = 0; j < i; j++) {
                	if(ds[j].getMa().equals(mahd) == true) {
                		isDuplicate = true;
                	}
                }
                if(isDuplicate == false) {
                	break;
                }else {
                	System.out.println("Ma hoa don bi trung, xin moi nhap lai!!!\n");
                }
            }
            
            hd.nhap(mahd);
        	ds[i] = new HoaDonNhap();
        	ds[i] = hd;
    	}
    	System.out.println("\n!!Them thanh cong!!!\n");
    }
    /*==========SEARCH=========*/
    public int timKiem(String ma) 
    {
        for(int i=0;i<soluongHd;i++) 
        {
            if(ma.equals(ds[i].getMa()) == true) 
            	return i;
        }
        return -1;
    }
    public int timKiem() {
    	String ma;
    	while(true) {
			System.out.print("Nhap vao ma hoa don xuat can tim kiem (5 so): ");
			ma = in.nextLine();
			if(ma.length() == 5) {
				break;
			}
		}
    	for(int i = 0; i < soluongHd; i++) {
    		if(ma.equals(ds[i].getMa()) == true) {
    			return i;
    		}
    	}
    	return -1;
    }
    public void timTheoNv(String manv) {
    	manv = manv.toLowerCase();
    	boolean check = false;
    	System.out.println("+----------+------------+----------+----------+------------+");
    	System.out.println("|Ma Hoa Don| Ngay Nhap  | Ma Nvien |  Ma NCC  |  Tong Chi  |");
    	System.out.println("+----------+------------+----------+----------+------------+");
    	for(int i = 0; i < soluongHd; i++) {
    		if(ds[i].getNv().equals(manv) == true) {
    			ds[i].xuat();
    			check = true;
    		}
    	}
    	if(check == false) {
    		System.out.println("Khong tim thay nhan vien ban can tim trong danh sach hoa don xuat!!!");
    	}
    }
    public void timTheoNv() {
    	System.out.println("Nhap vao ma nhan vien ma ban can tim kiem: ");
    	String manv = in.nextLine();
    	manv = manv.toLowerCase();
    	boolean check =  false;
    	System.out.println("+----------+------------+----------+----------+------------+");
    	System.out.println("|Ma Hoa Don| Ngay Nhap  | Ma Nvien |  Ma NCC  |  Tong Chi  |");
    	System.out.println("+----------+------------+----------+----------+------------+");
    	for(int i = 0; i < soluongHd; i++) {
    		if(ds[i].getNv().equals(manv) == true) {
    			ds[i].xuat();
    			check = true;
    		}
    	}
    	if(check == false) {
    		System.out.println("Khong tim thay nhan vien ban can tim kiem theo hoa don xuat!!!");
    	}
    }
    /*==========ADJUST==========*/
    public void sua(String ma) throws Exception{
    	//get chitietHoaDonNhap
    	DSChiTietHoaDonNhap cthdx = new DSChiTietHoaDonNhap();
    	cthdx.docFile("src/chitiethoadonnhap.txt");
    	
    	int pos = timKiem(ma);	//position of bill that need to fix
    	
    	if(pos == -1) {
    		System.out.println("\n!!!Khong tim thay hoa don can sua!!!\n");
    	}else {
    		cthdx.xoa(ma);
        	cthdx.ghiFile("src/chitiethoadonnhap.txt");
        	
    		System.out.println("Moi ban nhap lai thong tin moi cua hoa don nay:");
        	//use temporary variable type HoaDonNhap to check id of new 'hoa don xuat'
        	HoaDonNhap hdxTemp = new HoaDonNhap();
        	String mahd;
        	while(true) {
            	do{
        			System.out.print("- Nhap ma hoa don(5 ki tu): ");
        			mahd = in.nextLine();
        		}while(mahd.length()!=5);
                //check duplicate mahd
                boolean isDuplicate = false;
                for(int i = 0; i < soluongHd; i++) {
                	if(ds[i].getMa().equals(mahd) == true && i != pos) {
                		isDuplicate = true;
                	}
                }
                if(isDuplicate == false) {
                	break;
                }else {
                	System.out.println("Ma hoa don bi trung, xin moi nhap lai!!!\n");
                }
            }
        	hdxTemp.nhap(mahd);
        	ds[pos] = new HoaDonNhap(hdxTemp);
        	System.out.println("\n!!Sua thanh cong!!!\n");
    	}
    }
    public void sua() throws Exception {
    	//get chitietHoaDonNhap
    	DSChiTietHoaDonNhap cthdx = new DSChiTietHoaDonNhap();
    	cthdx.docFile("src/chitiethoadonnhap.txt");
    	
    	String ma;
    	while(true) {
			System.out.print("Nhap vao ma cua hoa don can sua thong tin (5 so): ");
			ma = in.nextLine();
			if(ma.length() == 5) {
				break;
			}
		}
    	int pos = timKiem(ma);	//position of bill that need to fix
    	if(pos == -1) {
    		System.out.println("\n!!!Khong tim thay hoa don can sua!!!\n");
    	}else {
    		cthdx.xoa(ma);
        	cthdx.ghiFile("src/chitiethoadonnhap.txt");
        	
    		System.out.println("Moi ban nhap lai thong tin moi cua hoa don nay:");
        	//use temporary variable type HoaDonNhap to check id of new 'hoa don xuat'
        	HoaDonNhap hdxTemp = new HoaDonNhap();
        	String mahd;
        	while(true) {
            	do{
        			System.out.print("- Nhap ma hoa don(5 ki tu): ");
        			mahd = in.nextLine();
        		}while(mahd.length()!=5);
                //check duplicate mahd
                boolean isDuplicate = false;
                for(int i = 0; i < soluongHd; i++) {
                	if(ds[i].getMa().equals(mahd) == true && i != pos) {
                		isDuplicate = true;
                	}
                }
                if(isDuplicate == false) {
                	break;
                }else {
                	System.out.println("Ma hoa don bi trung, xin moi nhap lai!!!\n");
                }
            }
        	hdxTemp.nhap(mahd);
        	ds[pos] = new HoaDonNhap(hdxTemp);
        	System.out.println("\n!!Sua thanh cong!!!\n");
    	}
    	
    }
    /*===========DELETE=========*/
    public void xoa(String ma) throws Exception{
    	//get chitietHoaDonNhap
    	DSChiTietHoaDonNhap cthdx = new DSChiTietHoaDonNhap();
    	cthdx.docFile("src/chitiethoadonnhap.txt");
    	
		int pos = timKiem(ma);
		if(pos == -1) {
			System.out.println("\n!!!Khong tim thay hoa don can xoa!!!\n");
		}else {
			for(int i = pos; i < soluongHd - 1; i++) {
				ds[i] = ds[i+1];
			}
			ds = Arrays.copyOf(ds, soluongHd - 1);
			soluongHd -= 1;
			cthdx.xoa(ma);
			cthdx.ghiFile("src/chitiethoadonnhap.txt");
			System.out.println("\n!!Xoa thanh cong!!!\n");
		}
	}
    public void xoa() throws Exception{
    	//get chitietHoaDonNhap
    	DSChiTietHoaDonNhap cthdx = new DSChiTietHoaDonNhap();
    	cthdx.docFile("src/chitiethoadonnhap.txt");
    	
    	String ma;
    	while(true) {
			System.out.print("Nhap vao ma cua hoa don xuat can xoa (5 ky tu): ");
			ma = in.nextLine();
			if(ma.length() == 5) {
				break;
			}
		}
    	int pos = timKiem(ma);
    	if(pos == -1) {
			System.out.println("\n!!!Khong tim thay hoa don can xoa!!!\n");
		}else {
			for(int i = pos; i < soluongHd - 1; i++) {
				ds[i] = ds[i+1];
			}
			ds = Arrays.copyOf(ds, soluongHd - 1);
			soluongHd -= 1;
			cthdx.xoa(ma);
			cthdx.ghiFile("src/chitiethoadonnhap.txt");
			System.out.println("\n!!Xoa thanh cong!!!\n");
		}
	}
    /*==========STATISTIC==========*/
    //statistic from price
    public void thongKeTuGia(int gia) {
    	boolean check = false;
    	System.out.println("+----------+------------+----------+----------+------------+");
    	System.out.println("|Ma Hoa Don| Ngay Nhap  | Ma Nvien |  Ma NCC  |  Tong Chi  |");
    	System.out.println("+----------+------------+----------+----------+------------+");
    	for(int i = 0; i < soluongHd; i++) {
    		if(ds[i].getTongchi() >= gia) {
    			check = true;
    			ds[i].xuat();
    		}
    	}
    	
    	if(check == true) {
    		System.out.println("Khong co hoa don nao tu khoang gia nay!!!");
    	}
    }

    public void thongKeTuGia() {
    	int gia;
    	boolean check = false;
    	System.out.print("Nhap vao gia tien toi thieu cua moi hoa don de thong ke!!!!");
    	gia = in.nextInt();
    	System.out.println("+----------+------------+----------+------------+----------+");
    	System.out.println("|Ma Hoa Don| Ngay Nhap  | Ma Nvien |   Ma NCC   | Tong Chi |");
    	System.out.println("+----------+------------+----------+------------+----------+");
    	for(int i = 0; i < soluongHd; i++) {
    		if(ds[i].getTongchi() >= gia) {
    			check = true;
    			ds[i].xuat();
    		}
    	}
    }
    //statistic by employee
    public void thongKeTheoNvien() {
    	boolean check = false;
    	System.out.print("Nhap vao ma nhan vien de thong ke hoa don dua tren nhan vien do: ");
    	String manv = in.nextLine();
    	System.out.println("+----------+------------+----------+----------+------------+");
    	System.out.println("|Ma Hoa Don| Ngay Nhap  | Ma Nvien |  Ma NCC  |  Tong Chi  |");
    	System.out.println("+----------+------------+----------+----------+------------+");
    	for(int i = 0; i < soluongHd; i++) {
    		if(ds[i].getNv().equals(manv) == true) {
    			check = true;
    			ds[i].xuat();
    		}
    	}
    	
    	if(check == false) {
    		System.out.println("Khong co hoa don nao duoc xuat tu nhan vien nay!!!");
    	}
    }
    public void thongKeTheoNvien(String manv) {
    	boolean check = false;
    	System.out.println("+----------+------------+----------+----------+------------+");
    	System.out.println("|Ma Hoa Don| Ngay Nhap  | Ma Nvien |  Ma NCC  |  Tong Chi  |");
    	System.out.println("+----------+------------+----------+----------+------------+");
    	for(int i = 0; i < soluongHd; i++) {
    		if(ds[i].getNv().equals(manv) == true) {
    			check = true;
    			ds[i].xuat();
    		}
    	}
    	
    	if(check == false) {
    		System.out.println("Khong co hoa don nao duoc xuat tu nhan vien nay!!!");
    	}
    }
    //statistic by ncc
    public void thongKeTheoNcc() {
    	boolean check = false;
    	System.out.print("Nhap vao ma nha cung cap de thong ke hoa don da nhap tu nha cung cap do: ");
    	String mancc = in.nextLine();
    	System.out.println("+----------+------------+----------+----------+------------+");
    	System.out.println("|Ma Hoa Don| Ngay Nhap  | Ma Nvien |  Ma NCC  |  Tong Chi  |");
    	System.out.println("+----------+------------+----------+----------+------------+");
    	for(int i = 0; i < soluongHd; i++) {
    		if(ds[i].getMancc().equals(mancc) == true) {
    			check = true;
    			ds[i].xuat();
    		}
    	}
    	
    	if(check == false) {
    		System.out.println("Nha cung cap nay khong co hoa don nao!!!");
    	}
    }
    public void thongKeTheoNcc(String makh) {
    	boolean check = false;
    	System.out.println("+----------+------------+----------+----------+------------+");
    	System.out.println("|Ma Hoa Don| Ngay Nhap  | Ma Nvien |  Ma NCC  |  Tong Chi  |");
    	System.out.println("+----------+------------+----------+----------+------------+");
    	for(int i = 0; i < soluongHd; i++) {
    		if(ds[i].getMancc().equals(makh) == true) {
    			check = true;
    			ds[i].xuat();
    		}
    	}
    	
    	if(check == false) {
    		System.out.println("Nha cung cap nay khong co hoa don nao!!!");
    	}
    }
    /*==========READ & WRITE FILE=========*/
    //read file
    public void docFile(String fileName)throws IOException{
    	DataInputStream inp = new DataInputStream(new FileInputStream(fileName));
    	int i = 0;
    	try {
    		while(true) {
    			String ma = inp.readUTF();
    			String ngaynhap = inp.readUTF();
    			String thangnhap = inp.readUTF();
    			String namnhap = inp.readUTF();
    			String nv = inp.readUTF();
    			String mancc = inp.readUTF();
    			int tongchi = inp.readInt();
    			ds[i] = new HoaDonNhap(ma,ngaynhap,thangnhap,namnhap,nv,mancc,tongchi);
        		i++;
    		}
    	}catch(EOFException e) {}
    	finally {
    		this.soluongHd = i;
    		inp.close();
    	}
    }
    //write file
    public void ghiFile(String fileName)throws IOException{
    	DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName));
    	try {
    		for(int i = 0; i < soluongHd; i++) {
    			ds[i].ghiFile(fileName);
    		}
    	}catch(IOException e) {}
    	finally {
    		out.close();
    	}
    }
}
