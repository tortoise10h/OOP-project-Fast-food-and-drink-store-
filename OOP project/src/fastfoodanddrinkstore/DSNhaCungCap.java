package fastfoodanddrinkstore;

import java.util.*;
import java.io.*;
interface IdanhSach{
	void nhap();
	void xuat();
	void docFile(String fileName) throws IOException;
	void ghiFile(String fileName) throws IOException;
}
public class DSNhaCungCap implements IdanhSach{
    NhaCungCap[] ds;
    int soLuongNCC;
    Scanner in = new Scanner(System.in);
    /*==========GETTER & SETTER==========*/
    public NhaCungCap[] getDs() {
		return ds;
	}
	public void setDs(NhaCungCap[] ds) {
		this.ds = ds;
	}
	public int getSoLuongNCC() {
		return soLuongNCC;
	}
	public void setSoLuongNCC(int soLuongNCC) {
		this.soLuongNCC = soLuongNCC;
	}
    
    /*=========CONSTRUCTOR=========*/
    public DSNhaCungCap() {
    	ds = new NhaCungCap[100];
    }
	public DSNhaCungCap(NhaCungCap[] ds, int soLuongNCC) 
    {
    	this.soLuongNCC = soLuongNCC;
    	this.ds = ds;
    }
    public DSNhaCungCap(int soLuongNCC) 
    {
    	this.soLuongNCC = soLuongNCC;
    	ds = new NhaCungCap[this.soLuongNCC];
    	for(int i = 0; i < soLuongNCC; i++) {
    		ds[i] = new NhaCungCap();
    	}
    }
    public DSNhaCungCap(NhaCungCap[] ds) 
    {
    	int dsLength = ds.length;
    	soLuongNCC = ds.length;
    	this.ds = new NhaCungCap[dsLength];
    	for(int i = 0;i < dsLength; i++) {
    		this.ds[i] = new NhaCungCap();
    		this.ds[i] = ds[i];
    	}
    }
    /*==========INPUT & OUTPUT==========*/
    public void nhap() 
    {
       System.out.print("Nhap so luong nha cung cap: ");
       soLuongNCC = in.nextInt();
       ds = new NhaCungCap[soLuongNCC];
        for(int i = 0; i < soLuongNCC; i++) {
			ds[i] = new NhaCungCap();
			System.out.println("Nhap thong tin nha cung cap "+(i+1));
		    ds[i].nhap();
		    System.out.println("");
		}
    }
    public void xuat() 
    {
    	System.out.println("+-------+------------------------------------------+------------------------------------------+");
        System.out.println("| ma ncc|              Ten nha cung cap            |             Mat hang cung cap            |");
        System.out.println("+-------+------------------------------------------+------------------------------------------+");
		for(int i=0 ; i < soLuongNCC; i++) {
			ds[i].xuat();
		}
    }
    public void xuat(int i) {
    	System.out.println("+-------+------------------------------------------+------------------------------------------+");
        System.out.println("| ma ncc|              Ten nha cung cap            |             Mat hang cung cap            |");
        System.out.println("+-------+------------------------------------------+------------------------------------------+");
        ds[i].xuat();
    }
    /*==========ADD==========*/
    public void them() 
    {   
    	System.out.println("Nhap vao thong tin cua nha cung cap moi");
        NhaCungCap ncc = new NhaCungCap();
        String mancc;
        while(true) {
        	do{
    			System.out.print("- Nhap vao ma nha cung cap(5 ki tu): ");
    			mancc = in.nextLine();
    		}while(mancc.length()!=5);
            //check duplicate mancc
            boolean isDuplicate = false;
            for(int i = 0; i < soLuongNCC; i++) {
            	if(ds[i].getMancc().equals(mancc) == true) {
            		isDuplicate = true;
            	}
            }
            if(isDuplicate == false) {
            	break;
            }else {
            	System.out.println("!!!Ma nha cung cap bi trung, xin moi nhap lai!!!\n");
            }
        }
        
        ncc.nhap(mancc);
        //check id of new customer
    	ds = Arrays.copyOf(ds, soLuongNCC + 1);
        soLuongNCC += 1;
        ds[soLuongNCC - 1] = new NhaCungCap();
        ds[soLuongNCC - 1] = ncc;
        System.out.println("\n!!!Them nha cung cap moi moi thanh cong!!!\n");
    }
    public void them(NhaCungCap kt) {
    	ds = Arrays.copyOf(ds, soLuongNCC + 1);
        soLuongNCC += 1;
        ds[soLuongNCC - 1] = new NhaCungCap();
        ds[soLuongNCC - 1] = kt;
    }
    public void them(int soLuongNCC) {
    	System.out.println("Nhap vao thong tin cua cac nha cung cap moi: ");
    	int oldLength = this.soLuongNCC;
    	this.soLuongNCC += soLuongNCC;
    	ds = Arrays.copyOf(ds, this.soLuongNCC);
    	for(int i= oldLength; i < this.soLuongNCC; i++) {
    		System.out.println("\nThem vao nha cung cap thu " + (i+1));
            NhaCungCap ncc = new NhaCungCap();
            String mancc;
            while(true) {
            	do{
        			System.out.print("- Nhap ma nha cung cap (5 ki tu): ");
        			mancc = in.nextLine();
        		}while(mancc.length()!=5);
                //check duplicate makh
                boolean isDuplicate = false;
                for(int j = 0; j < i; j++) {
                	if(ds[j].getMancc().equals(mancc) == true) {
                		isDuplicate = true;
                	}
                }
                if(isDuplicate == false) {
                	break;
                }else {
                	System.out.println("\n!!!Ma nha cung cap bi trung, xin moi nhap lai!!!\n");
                }
            }
            
            ncc.nhap(mancc);
        	ds[i] = new NhaCungCap();
        	ds[i] = ncc;
    	}
    	System.out.println("\n!!!Them thanh cong!!!\n");
    }
    /*==========SEARCH=========*/
    public int timKiem(String mancc) 
    {
        for(int i=0;i<soLuongNCC;i++) 
        {
            if(mancc.equals(ds[i].getMancc()) == true) 
            	return i;
        }
        return -1;
    }
    public int timKiem() {
    	String mancc;
    	while(true) {
			System.out.print("Nhap vao ma nha cung cap can tim kiem (5 so): ");
			mancc = in.nextLine();
			if(mancc.length() == 5) {
				break;
			}
		}
    	for(int i = 0; i < soLuongNCC; i++) {
    		if(mancc.equals(ds[i].getMancc()) == true) {
    			return i;
    		}
    	}
    	return -1;
    }
    public void timTheoTen(String tenncc) {
    	tenncc = tenncc.toLowerCase();
    	boolean check = false;
    	System.out.println("+-------+------------------------------------------+------------------------------------------+");
        System.out.println("| ma ncc|              Ten nha cung cap            |             Mat hang cung cap            |");
        System.out.println("+-------+------------------------------------------+------------------------------------------+");
    	for(int i = 0; i < ds.length; i++) {
    		String temp = ds[i].getTenncc().toLowerCase();
    		if(temp.indexOf(tenncc) > -1) {
    			ds[i].xuat();
    			System.out.println("");
    			check = true;
    		}
    	}
    	if(check == false) {
    		System.out.println("Ten cua nha cung cap ban can tim kiem khong co trong danh sach!!!");
    	}
    }
    public void timTheoTen() {
    	System.out.println("Nhap vao ten ma ban can tim kiem: ");
    	String tenncc = in.nextLine();
    	tenncc = tenncc.toLowerCase();
    	boolean check =  false;
    	System.out.println("+-------+------------------------------------------+------------------------------------------+");
        System.out.println("| ma ncc|              Ten nha cung cap            |             Mat hang cung cap            |");
        System.out.println("+-------+------------------------------------------+------------------------------------------+");
    	for(int i = 0; i < soLuongNCC; i++) {
    		String temp = ds[i].getTenncc().toLowerCase();
    		if(temp.indexOf(tenncc) > -1) {
    			ds[i].xuat();
    			System.out.println("");
    			check = true;
    		}
    	}
    	if(check == false) {
    		System.out.println("Ten cua nha cung cap ban can tim kiem khong co trong danh sach!!!");
    	}
    }
    /*==========ADJUST==========*/
    public void sua(String mancc) {
    	int pos = timKiem(mancc);
    	if(pos == -1) {
    		System.out.println("\n!!!Khong tim thay nha cung cap!!!\n");
    	}else {
    		System.out.println("Moi ban nhap lai thong tin moi cua nha cung cap nay:");
        	NhaCungCap ncc = new NhaCungCap();
        	String newMancc;
        	while(true) {
            	do{
        			System.out.print("- Nhap ma nha cung cap (5 ki tu): ");
        			newMancc = in.nextLine();
        		}while(newMancc.length()!=5);
                boolean isDuplicate = false;
                for(int i = 0; i < soLuongNCC; i++) {
                	if(ds[i].getMancc().equals(newMancc) == true && i != pos) {
                		isDuplicate = true;
                	}
                }
                if(isDuplicate == false) {
                	break;
                }else {
                	System.out.println("\n!!!Ma nha cung cap, xin moi nhap lai!!!\n");
                }
            }
        	ncc.nhap(mancc);
        	ds[pos] = new NhaCungCap(ncc);
        	System.out.println("\n!!!Sua thong tin nha cung cap thanh cong!!!\n");
    	}
    }
    public void sua() {
    	String mancc;
    	while(true) {
			System.out.print("Nhap vao ma nha cung cap can sua thong tin (5 so): ");
			mancc = in.nextLine();
			if(mancc.length() == 5) {
				break;
			}
		}
    	sua(mancc);
    }
    /*===========DELETE=========*/
    public void xoa(String mancc) {
		int pos = timKiem(mancc);
		if(pos == -1) {
			System.out.println("\n!!!Khong tim thay nha cung cap can xoa!!!\n");
		}else {
			for(int i = pos; i < soLuongNCC - 1; i++) {
				ds[i] = ds[i+1];
			}
			ds = Arrays.copyOf(ds, soLuongNCC - 1);
			soLuongNCC -= 1;
		}
	}
    public void xoa() {
    	String mancc;
    	while(true) {
			System.out.print("Nhap vao ma nha cung cap can xoa (5 ky tu): ");
			mancc = in.nextLine();
			if(mancc.length() == 5) {
				break;
			}
		}
    	int pos = timKiem(mancc);
    	if(pos == -1) {
			System.out.println("\n!!!Khong tim thay nha cung cap can xoa!!!\n");
		}else {
			for(int i = pos; i < soLuongNCC - 1; i++) {
				ds[i] = ds[i+1];
			}
			ds = Arrays.copyOf(ds, soLuongNCC - 1);
			soLuongNCC -= 1;
			System.out.println("\n!!!Xoa thanh cong!!!\n");
		}
	}
    /*==========READ & WRITE FILE=========*/
    //read file
    public void docFile(String fileName)throws IOException{
    	DataInputStream inp = new DataInputStream(new FileInputStream(fileName));
    	int i = 0;
    	try {
    		while(true) {
    			String mancc = inp.readUTF();
        		String tenncc = inp.readUTF();
        		String loaihang = inp.readUTF();
        		ds[i] = new NhaCungCap(mancc,tenncc,loaihang);
        		i++;
    		}
    	}catch(EOFException e) {}
    	finally {
    		this.soLuongNCC = i;
    		inp.close();
    	}
    }
    //write file
    public void ghiFile(String fileName)throws IOException{
    	DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName));
    	try {
    		for(int i = 0; i < soLuongNCC; i++) {
    			ds[i].ghiFile(fileName);
    		}
    	}catch(IOException e) {}
    	finally {
    		out.close();
    	}
    }
}
