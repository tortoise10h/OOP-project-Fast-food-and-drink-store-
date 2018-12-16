package fastfoodanddrinkstore;

import java.util.*;
import java.io.*;
public class DSHoaDonXuat {
	private HoaDonXuat[] ds;
    private int soluongHd;
    Scanner in = new Scanner(System.in);
    /*==========GETTER & SETTER=========*/
    public HoaDonXuat[] getDs() {
		return ds;
	}
	public void setDs(HoaDonXuat[] ds) {
		this.ds = ds;
	}
	public int getSoluongHd() {
		return soluongHd;
	}
	public void setSoluongHd(int soluongHd) {
		this.soluongHd = soluongHd;
	}
    /*=========CONSTRUCTOR=========*/
    public DSHoaDonXuat() {
    	soluongHd = 0;
    	ds = new HoaDonXuat[100];
    }
	public DSHoaDonXuat(HoaDonXuat[] ds, int soluongHd) 
    {
    	this.soluongHd = soluongHd;
    	this.ds = new HoaDonXuat[this.soluongHd];
    }
    public DSHoaDonXuat(int soluongHd) 
    {
    	this.soluongHd = soluongHd;
    	ds = new HoaDonXuat[this.soluongHd];
    	for(int i = 0; i < soluongHd; i++) {
    		ds[i] = new HoaDonXuat();
    	}
    }
    public DSHoaDonXuat(HoaDonXuat[] ds) 
    {
    	soluongHd = ds.length;
    	this.ds = new HoaDonXuat[soluongHd];
    	for(int i = 0;i < soluongHd; i++) {
    		this.ds[i] = new HoaDonXuat();
    		this.ds[i] = ds[i];
    	}
    }
    /*==========INPUT & OUTPUT==========*/
    public void nhap() throws Exception
    {
       System.out.print("Nhap so luong hoa don xuat: ");
       soluongHd = in.nextInt();
       in.nextLine();
       ds = new HoaDonXuat[soluongHd];
        for(int i = 0; i < soluongHd; i++) {
			ds[i] = new HoaDonXuat();
			System.out.println("Nhap thong tin cua hoa don xuat "+(i+1) +" : ");
		    ds[i].nhap();
		    System.out.println("");
		}
    }
    public void xuat() 
    {
    	System.out.println("+----------+------------+----------+------------+----------+----------+------------+");
    	System.out.println("|Ma Hoa Don| Ngay Xuat  | Ma Nvien | Tong Tien  | Ma Khang | Ma Kmai  | Tien Kmai  |");
    	System.out.println("+----------+------------+----------+------------+----------+----------+------------+");
		for(int i=0 ; i < soluongHd; i++) {
			ds[i].xuat();
		}
    }
    /*==========ADD==========*/
    public void them() throws Exception
    {   
    	System.out.println("Nhap vao thong tin cua hoa don xuat moi");
        HoaDonXuat hd = new HoaDonXuat();
        String mahd;
        while(true) {
        	do{
    			System.out.print("- Nhap ma hoa don(5 ki tu): ");
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
        ds[soluongHd - 1] = new HoaDonXuat();
        ds[soluongHd - 1] = hd;
        System.out.println("\n!!!Them hoa don xuat moi thanh cong!!!\n");
    }
    
    public void them(int soluongHd) throws Exception{
    	System.out.println("Nhap vao thong tin cua cac hoa don xuat moi: ");
    	int oldLength = this.soluongHd;
    	this.soluongHd += soluongHd;
    	ds = Arrays.copyOf(ds, this.soluongHd);
    	for(int i= oldLength; i < this.soluongHd; i++) {
    		System.out.println("\nNhap vao hoa don thu " + (i-oldLength+1));
            HoaDonXuat hd = new HoaDonXuat();
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
        	ds[i] = new HoaDonXuat();
        	ds[i] = hd;
    	}
    	System.out.println("\n!!!Them thanh cong!!!\n");
    }
    
    
    public void them(String[] listMasp, int[] sluong, int sluongSanPham) throws Exception{
    	System.out.println("Nhap vao thong tin cua hoa don xuat moi");
        HoaDonXuat hd = new HoaDonXuat();
        String mahd;
        while(true) {
        	do{
    			System.out.print("- Nhap ma hoa don(5 ki tu): ");
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
        
        hd.nhap(mahd, listMasp, sluong, sluongSanPham);
        //check id of new "hoa don xuat"
    	ds = Arrays.copyOf(ds, soluongHd + 1);
        soluongHd += 1;
        ds[soluongHd - 1] = new HoaDonXuat();
        ds[soluongHd - 1] = hd;
        System.out.println("\n!!!Them hoa don xuat moi thanh cong!!!");
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
    	System.out.println("+----------+------------+----------+------------+----------+----------+------------+");
    	System.out.println("|Ma Hoa Don| Ngay Xuat  | Ma Nvien | Tong Tien  | Ma Khang | Ma Kmai  | Tien Kmai  |");
    	System.out.println("+----------+------------+----------+------------+----------+----------+------------+");
    	for(int i = 0; i < soluongHd; i++) {
    		if(ds[i].getManv().equals(manv) == true) {
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
    	System.out.println("+----------+------------+----------+------------+----------+----------+------------+");
    	System.out.println("|Ma Hoa Don| Ngay Xuat  | Ma Nvien | Tong Tien  | Ma Khang | Ma Kmai  | Tien Kmai  |");
    	System.out.println("+----------+------------+----------+------------+----------+----------+------------+");
    	for(int i = 0; i < soluongHd; i++) {
    		if(ds[i].getManv().equals(manv) == true) {
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
    	//get chitiethoadonxuat
    	DSChiTietHoaDonXuat cthdx = new DSChiTietHoaDonXuat();
    	cthdx.docFile("src/chitiethoadonxuat.txt");
    	
    	int pos = timKiem(ma);	//position of bill that need to fix
    	
    	if(pos == -1) {
    		System.out.println("\n!!!Khong tim thay hoa don can sua!!!\n");
    	}else {
    		cthdx.xoa(ma);
        	cthdx.ghiFile("src/chitiethoadonxuat.txt");
        	
    		System.out.println("Moi ban nhap lai thong tin moi cua hoa don xuat nay:");
        	//use temporary variable type HoaDonXuat to check id of new 'hoa don xuat'
        	HoaDonXuat hdxTemp = new HoaDonXuat();
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
        	ds[pos] = new HoaDonXuat(hdxTemp);
        	System.out.println("\n!!!Sua thong tin thanh cong!!!\n");
    	}
    }
    public void sua() throws Exception {
    	//get chitiethoadonxuat
    	DSChiTietHoaDonXuat cthdx = new DSChiTietHoaDonXuat();
    	cthdx.docFile("src/chitiethoadonxuat.txt");
    	
    	String ma;
    	while(true) {
			System.out.print("Nhap vao ma cua hoa don xuat can sua thong tin (5 so): ");
			ma = in.nextLine();
			if(ma.length() == 5) {
				break;
			}
		}
    	sua(ma);
    }
    /*===========DELETE=========*/
    public void xoa(String ma) throws IOException{
    	//get chitiethoadonxuat
    	DSChiTietHoaDonXuat cthdx = new DSChiTietHoaDonXuat();
    	cthdx.docFile("src/chitiethoadonxuat.txt");
    	
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
			cthdx.ghiFile("src/chitiethoadonxuat.txt");
			System.out.println("\n!!!Xoa thanh cong!!!\n");
		}
	}
    public void xoa() throws IOException{
    	//get chitiethoadonxuat
    	DSChiTietHoaDonXuat cthdx = new DSChiTietHoaDonXuat();
    	cthdx.docFile("src/chitiethoadonxuat.txt");
    	
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
			cthdx.ghiFile("src/chitiethoadonxuat.txt");
			System.out.println("\n!!!Xoa thanh cong!!!\n");
		}
	}
    /*==========STATISTIC==========*/
    //statistic from price
    public void thongKeTuGia(int gia) {
    	boolean check = false;
    	System.out.println("+----------+------------+----------+------------+----------+----------+------------+");
    	System.out.println("|Ma Hoa Don| Ngay Xuat  | Ma Nvien | Tong Tien  | Ma Khang | Ma Kmai  | Tien Kmai  |");
    	System.out.println("+----------+------------+----------+------------+----------+----------+------------+");
    	for(int i = 0; i < soluongHd; i++) {
    		if(ds[i].getTongtien() >= gia) {
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
    	System.out.println("+----------+------------+----------+------------+----------+----------+------------+");
    	System.out.println("|Ma Hoa Don| Ngay Xuat  | Ma Nvien | Tong Tien  | Ma Khang | Ma Kmai  | Tien Kmai  |");
    	System.out.println("+----------+------------+----------+------------+----------+----------+------------+");
    	for(int i = 0; i < soluongHd; i++) {
    		if(ds[i].getTongtien() >= gia) {
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
    	System.out.println("+----------+------------+----------+------------+----------+----------+------------+");
    	System.out.println("|Ma Hoa Don| Ngay Xuat  | Ma Nvien | Tong Tien  | Ma Khang | Ma Kmai  | Tien Kmai  |");
    	System.out.println("+----------+------------+----------+------------+----------+----------+------------+");
    	for(int i = 0; i < soluongHd; i++) {
    		if(ds[i].getManv().equals(manv) == true) {
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
    	System.out.println("+----------+------------+----------+------------+----------+----------+------------+");
    	System.out.println("|Ma Hoa Don| Ngay Xuat  | Ma Nvien | Tong Tien  | Ma Khang | Ma Kmai  | Tien Kmai  |");
    	System.out.println("+----------+------------+----------+------------+----------+----------+------------+");
    	for(int i = 0; i < soluongHd; i++) {
    		if(ds[i].getManv().equals(manv) == true) {
    			check = true;
    			ds[i].xuat();
    		}
    	}
    	
    	if(check == false) {
    		System.out.println("Khong co hoa don nao duoc xuat tu nhan vien nay!!!");
    	}
    }
    //statistic by customer
    public void thongKeTheoKhachHang() {
    	boolean check = false;
    	System.out.print("Nhap vao ma khach de thong ke hoa don ma khach hang do da mua: ");
    	String makh = in.nextLine();
    	System.out.println("+----------+------------+----------+------------+----------+----------+------------+");
    	System.out.println("|Ma Hoa Don| Ngay Xuat  | Ma Nvien | Tong Tien  | Ma Khang | Ma Kmai  | Tien Kmai  |");
    	System.out.println("+----------+------------+----------+------------+----------+----------+------------+");
    	for(int i = 0; i < soluongHd; i++) {
    		if(ds[i].getMakh().equals(makh) == true) {
    			check = true;
    			ds[i].xuat();
    		}
    	}
    	
    	if(check == false) {
    		System.out.println("Khach hang nay khong co hoa don nao!!!");
    	}
    }
    public void thongKeTheoKhachHang(String makh) {
    	boolean check = false;
    	System.out.println("+----------+------------+----------+------------+----------+----------+------------+");
    	System.out.println("|Ma Hoa Don| Ngay Xuat  | Ma Nvien | Tong Tien  | Ma Khang | Ma Kmai  | Tien Kmai  |");
    	System.out.println("+----------+------------+----------+------------+----------+----------+------------+");
    	for(int i = 0; i < soluongHd; i++) {
    		if(ds[i].getMakh().equals(makh) == true) {
    			check = true;
    			ds[i].xuat();
    		}
    	}
    	
    	if(check == false) {
    		System.out.println("Khach hang nay khong co hoa don nao!!!");
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
    			String ngayxuat = inp.readUTF();
    			String thangxuat = inp.readUTF();
    			String namxuat = inp.readUTF();
    			String manv = inp.readUTF();
    			int tongtien = inp.readInt();
    			String makh = inp.readUTF();
    			String makm = inp.readUTF();
    			int	tienkm = inp.readInt();
    			ds[i] = new HoaDonXuat(ma,ngayxuat,thangxuat,namxuat,manv,makh,makm,tongtien,tienkm);
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
