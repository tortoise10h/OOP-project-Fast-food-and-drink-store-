package fastfoodanddrinkstore;

import java.util.*;
import java.io.*;
import java.lang.String;
interface IdanhSachSp{
	void nhap();
	void xuat();
	void docFile(String fileName) throws IOException;
	void ghiFile(String fileName) throws IOException;
}
public class DSSanPham implements IdanhSachSp{
	Scanner in = new Scanner(System.in);
	private int soluong;
	private SanPham[] ds;
	/*=====CONSTRUCTOR=====*/
	public DSSanPham() {
		ds = new SanPham[100];
	}
	public DSSanPham(int soluong, SanPham[] sp) {
		this.soluong = soluong;
		ds = new SanPham[soluong];
		for(int i = 0; i < soluong; i++) {
			ds[i] = new SanPham();
			ds[i] = sp[i];
		}
	}
	public DSSanPham(int soluong) {
		this.soluong = soluong;
		ds = new SanPham[soluong];
	}
	public DSSanPham(SanPham[] sp) {
		soluong =  sp.length;
		ds = new SanPham[soluong];
		for(int i = 0; i < soluong; i++) {
			ds[i] = new SanPham();
			ds[i] = sp[i];
		}
	}
	/*==========GETTER & SETTER==========*/
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public SanPham[] getDs() {
		return ds;
	}
	public void setDs(SanPham[] ds) {
		this.ds = ds;
	}
	/*=====INPUT & OUTPUT=====*/
	public void nhap() {
		System.out.print("Nhap vao so luong cua san pham: ");
		soluong = in.nextInt();
		in.nextLine();
		ds = new SanPham[soluong];
		System.out.println("Nhap vao danh sach san pham: ");
		for(int i = 0; i < soluong; i++) {
			while(true) {
				int check;
				System.out.println("Ban muon them vao: ");
				System.out.println(" 1. Thuc an nhanh");
				System.out.println(" 2. Giai khat");
				check = in.nextInt();
				if(check == 1) {
					ds[i] = new ThucAnNhanh();
					ds[i].nhap();
					break;
				}else if(check == 2) {
					ds[i] = new GiaiKhat();
					ds[i].nhap();
					break;
				}
			}
		}
	}
	public void xuat() {
		System.out.println("Danh sach san pham: ");
		System.out.println("\n");
		System.out.println("+-------+-------------------------------------+-----------------+---------+--------+--------------------------------+------------+");
		System.out.println("| Ma sp |           Ten san pham              |      Loai       |   Gia   |  SL co |  Huong vi/ Nguyen lieu chinh   |  Size/XXu  |");
		System.out.println("+-------+-------------------------------------+-----------------+---------+--------+--------------------------------+------------+");
		for(int i = 0; i < soluong; i++) {
			ds[i].xuat();
		}
	}
	/*=====ADD PRODUCT=====*/
	//add new product: given product
	public void them(SanPham sp) {
		ds = Arrays.copyOf(ds, soluong + 1);
		soluong += 1;
		ds[soluong - 1] = sp;
	}
	//add new product: input product
	public void them() {
		int check;
		SanPham sp;
		String masp;
		System.out.println("Them vao san pham moi: ");
		//pick kind of product
		do {
			System.out.println("Ban muon them vao: ");
			System.out.println(" 1. Thuc an nhanh");
			System.out.println(" 2. Giai khat");
			check = in.nextInt();
			in.nextLine();
		}while(check != 1 && check != 2);
		
		if(check == 1) {
			sp = new ThucAnNhanh();
			System.out.println("Nhap vao thong tin cua san pham");
			//this loop for check duplicate masp
			while(true) {
				do {
					System.out.print("- Nhap vao ma san pham (5 ky tu): ");
					masp = in.nextLine();
				}while(masp.length() != 5);
				//check duplicate masp
				boolean isDuplicate = false;
	            for(int i = 0; i < soluong; i++) {
	            	if(ds[i].getMasp().equals(masp) == true) {
	            		isDuplicate = true;
	            	}
	            }
	            if(isDuplicate == false) {
	            	break;
	            }else {
	            	System.out.println("\n!!!Ma san pham bi trung, xin moi nhap lai!!!\n");
	            }
			}
			sp.nhap(masp);
		}else{
			sp = new GiaiKhat();
			System.out.println("Nhap vao thong tin cua san pham");
			//this loop for check duplicate masp
			while(true) {
				do {
					System.out.print("- Nhap vao ma san pham (5 ky tu): ");
					masp = in.nextLine();
				}while(masp.length() != 5);
				//check duplicate masp
				boolean isDuplicate = false;
	            for(int i = 0; i < soluong; i++) {
	            	if(ds[i].getMasp().equals(masp) == true) {
	            		isDuplicate = true;
	            	}
	            }
	            if(isDuplicate == false) {
	            	break;
	            }else {
	            	System.out.println("\n!!!Ma san pham bi trung, xin moi nhap lai!!!\n");
	            }
			}
			sp.nhap(masp);
		}
		//add new product to array
		ds = Arrays.copyOf(ds, soluong + 1);
		soluong += 1;
		ds[soluong - 1] = sp;
		System.out.println("\n!!!Them thanh cong!!!\n");
	}
	//add new products
	public void them(int soluongSp) {
    	
    	System.out.println("Nhap vao thong tin cua cac san pham: ");
    	int oldLength = this.soluong;
    	this.soluong += soluongSp;
    	ds = Arrays.copyOf(ds, this.soluong);
    	for(int i= oldLength; i < this.soluong; i++) {
    		int check;
    		SanPham sp;
    		String masp;
    		System.out.println("Them vao san pham thu " + (i-oldLength+1) +" : ");
    		//pick kind of product
    		do {
    			System.out.println("Ban muon them vao: ");
    			System.out.println(" 1. Thuc an nhanh");
    			System.out.println(" 2. Giai khat");
    			check = in.nextInt();
    			in.nextLine();
    		}while(check != 1 && check != 2);
    		
    		if(check == 1) {
    			sp = new ThucAnNhanh();
    			System.out.println("Nhap vao thong tin cua san pham");
    			//this loop for check duplicate masp
    			while(true) {
    				do {
    					System.out.print("- Nhap vao ma san pham (5 ky tu): ");
    					masp = in.nextLine();
    				}while(masp.length() != 5);
    				//check duplicate masp
    				boolean isDuplicate = false;
    	            for(int j = 0; j < i; j++) {
    	            	if(ds[j].getMasp().equals(masp) == true) {
    	            		isDuplicate = true;
    	            	}
    	            }
    	            if(isDuplicate == false) {
    	            	break;
    	            }else {
    	            	System.out.println("\n!!!Ma san pham bi trung, xin moi nhap lai!!!\n");
    	            }
    			}
    			sp.nhap(masp);
    		}else{
    			sp = new GiaiKhat();
    			System.out.println("Nhap vao thong tin cua san pham");
    			//this loop for check duplicate masp
    			while(true) {
    				do {
    					System.out.print("- Nhap vao ma san pham (5 ky tu): ");
    					masp = in.nextLine();
    				}while(masp.length() != 5);
    				//check duplicate masp
    				boolean isDuplicate = false;
    				for(int j = 0; j < i; j++) {
    	            	if(ds[j].getMasp().equals(masp) == true) {
    	            		isDuplicate = true;
    	            	}
    	            }
    	            if(isDuplicate == false) {
    	            	break;
    	            }else {
    	            	System.out.println("\n!!!Ma san pham bi trung, xin moi nhap lai!!!\n");
    	            }
    			}
    			sp.nhap(masp);
    		}
    		//add new product to array
    		ds[i] = sp;
    	}
    	System.out.println("\n!!!Them thanh cong!!!\n");
    }
	/*=====SEARCH=====*/
	//search with given masp
	public int timKiem(String masp) 
    {
        for(int i=0;i<soluong;i++) 
        {
            if(masp.equals(ds[i].getMasp()) == true) 
            	return i;
        }
        return -1;
    }
    //Search with input maKh and return position
    public int timKiem() {
    	String masp;
    	while(true) {
			System.out.print("Nhap vao ma khach hang can tim kiem (5 so): ");
			masp = in.nextLine();
			if(masp.length() == 5) {
				break;
			}
		}
    	for(int i = 0; i < soluong; i++) {
    		if(masp.equals(ds[i].getMasp()) == true) {
    			return i;
    		}
    	}
    	return -1;
    	
    }
  //Search with name: given name
    public void timTheoTen(String ten) {
    	ten = ten.toLowerCase();
    	boolean check = false;
    	System.out.println("+-------+-------------------------------------+-----------------+---------+--------+--------------------------------+------------+");
		System.out.println("| Ma sp |           Ten san pham              |      Loai       |   Gia   |  SL co |  Huong vi/ Nguyen lieu chinh   |  Size/XXu  |");
		System.out.println("+-------+-------------------------------------+-----------------+---------+--------+--------------------------------+------------+");
    	for(int i = 0; i < soluong; i++) {
    		String temp = ds[i].getTensp().toLowerCase();
    		if(temp.indexOf(ten) > -1) {
    			ds[i].xuat();
    			check = true;
    		}
    	}
    	if(check == false) {
    		System.out.println("!!!!Ten cua nhan vien ban can tim kiem khong co trong danh sach!!!\n");
    	}
    }
    //Search with name: input name
    public void timTheoTen() {
    	System.out.println("Nhap vao ten ma ban can tim kiem: ");
    	String ten = in.nextLine();
    	ten = ten.toLowerCase();
    	boolean check =  false;
    	System.out.println("+-------+-------------------------------------+-----------------+---------+--------+--------------------------------+------------+");
		System.out.println("| Ma sp |           Ten san pham              |      Loai       |   Gia   |  SL co |  Huong vi/ Nguyen lieu chinh   |  Size/XXu  |");
		System.out.println("+-------+-------------------------------------+-----------------+---------+--------+--------------------------------+------------+");
    	for(int i = 0; i < soluong; i++) {
    		String temp = ds[i].getTensp().toLowerCase();
    		if(temp.indexOf(ten) > -1) {
    			ds[i].xuat();
    			System.out.println("");
    			check = true;
    		}
    	}
    	if(check == false) {
    		System.out.println("!!!Ten cua nhan vien ban can tim kiem khong co trong danh sach!!!\n");
    	}
    }
    //Search with loai: given loai
    public void timTheoLoai(String loai) {
    	loai = loai.toLowerCase();
    	boolean check =  false;
    	System.out.println("+-------+-------------------------------------+-----------------+---------+--------+--------------------------------+------------+");
		System.out.println("| Ma sp |           Ten san pham              |      Loai       |   Gia   |  SL co |  Huong vi/ Nguyen lieu chinh   |  Size/XXu  |");
		System.out.println("+-------+-------------------------------------+-----------------+---------+--------+--------------------------------+------------+");
    	for(int i = 0; i < soluong; i++) {
    		String temp = ds[i].getLoai().toLowerCase();
    		if(temp.indexOf(loai) > -1) {
    			ds[i].xuat();
    			check = true;
    		}
    	}
    	if(check == false) {
    		System.out.println("!!!!Loai san pham can tim khong co trong danh sach!!!!\n");
    	}
    }
    //Search with loai: input loai
    public void timTheoLoai() {
    	System.out.println("Nhap vao loai san phan ban can tim kiem: ");
    	String loai = in.nextLine();
    	loai = loai.toLowerCase();
    	boolean check =  false;
    	System.out.println("+-------+-------------------------------------+-----------------+---------+--------+--------------------------------+------------+");
		System.out.println("| Ma sp |           Ten san pham              |      Loai       |   Gia   |  SL co |  Huong vi/ Nguyen lieu chinh   |  Size/XXu  |");
		System.out.println("+-------+-------------------------------------+-----------------+---------+--------+--------------------------------+------------+");
    	for(int i = 0; i < soluong; i++) {
    		String temp = ds[i].getLoai().toLowerCase();
    		if(temp.indexOf(loai) > -1) {
    			ds[i].xuat();
    			check = true;
    		}
    	}
    	if(check == false) {
    		System.out.println("!!!!Loai san pham can tim khong co trong danh sach!!!!\n");
    	}
    }
    /*=====ADJUST=====*/
    //Adjust with given masp
    public void sua(String masp) {
    	int pos = timKiem(masp);
    	if(pos == -1) {
    		System.out.println("\n!!!Khong tim thay san pham can sua!!!\n");
    	}else {
    		int check;
    		SanPham sp;
    		String newMasp;
    		System.out.println("Chinh sua thong tin cua san pham vua chon: ");
    		//pick kind of product
    		do {
    			System.out.println("Ban muon sua san pham cu thanh san pham loai nao: ");
    			System.out.println(" 1. Thuc an nhanh");
    			System.out.println(" 2. Giai khat");
    			check = in.nextInt();
    			in.nextLine();
    		}while(check != 1 && check != 2);
    		
    		if(check == 1) {
    			sp = new ThucAnNhanh();
    			System.out.println("Nhap vao thong tin cua san pham");
    			//this loop for check duplicate masp
    			while(true) {
    				do {
    					System.out.print("- Nhap vao ma san pham (5 ky tu): ");
    					newMasp = in.nextLine();
    				}while(newMasp.length() != 5);
    				//check duplicate masp
    				boolean isDuplicate = false;
    	            for(int i = 0; i < soluong; i++) {
    	            	if(ds[i].getMasp().equals(newMasp) == true && i != pos) {
    	            		isDuplicate = true;
    	            	}
    	            }
    	            if(isDuplicate == false) {
    	            	break;
    	            }else {
    	            	System.out.println("\n!!!Ma san pham bi trung, xin moi nhap lai!!!\n");
    	            }
    			}
    			sp.nhap(masp);
    		}else{
    			sp = new GiaiKhat();
    			System.out.println("Nhap vao thong tin cua san pham");
    			//this loop for check duplicate masp
    			while(true) {
    				do {
    					System.out.print("- Nhap vao ma san pham (5 ky tu): ");
    					newMasp = in.nextLine();
    				}while(newMasp.length() != 5);
    				//check duplicate masp
    				boolean isDuplicate = false;
    	            for(int i = 0; i < soluong; i++) {
    	            	if(ds[i].getMasp().equals(newMasp) == true && i != pos) {
    	            		isDuplicate = true;
    	            	}
    	            }
    	            if(isDuplicate == false) {
    	            	break;
    	            }else {
    	            	System.out.println("\n!!!Ma san pham bi trung, xin moi nhap lai!!!\n");
    	            }
    			}
    			sp.nhap(masp);
    		}
    		
    		if(check == 1) {
    			ds[pos] =  new ThucAnNhanh();
    			ds[pos] = sp;
    		}else {
    			ds[pos] =  new GiaiKhat();
    			ds[pos] = sp;
    		}
    		System.out.println("\n!!!Chinh sua thong tin thanh cong!!!\n");
    	}
    }
    // Adjust with input masp
    public void sua() {
    	String masp;
    	while(true) {
			System.out.print("Nhap vao ma san pham can sua (5 so): ");
			masp = in.nextLine();
			if(masp.length() == 5) {
				break;
			}
		}
    	sua(masp);
    }
    /*=====DELETE=====*/
    //Delete 1 product with given masp
    public void xoa(String masp) {
		int pos = timKiem(masp);
		for(int i = pos; i < soluong - 1; i++) {
			ds[i] = ds[i+1];
		}
		ds = Arrays.copyOf(ds, soluong - 1);
		soluong -= 1;
	}
    //Delete 1 product with input masp
    public void xoa() {
    	String masp;
    	while(true) {
			System.out.print("Nhap vao ma san pham can xoa (5 so): ");
			masp = in.nextLine();
			if(masp.length() == 5) {
				break;
			}
		}
    	int pos = timKiem(masp);
		if(pos == -1) {
			System.out.println("\n!!!Khong tim thay san pham can xoa!!!\n");
		}else {
			for(int i = pos; i < soluong - 1; i++) {
				ds[i] = ds[i+1];
			}
			ds = Arrays.copyOf(ds, soluong - 1);
			soluong -= 1;
			System.out.println("!!!Xoa thanh cong!!!\n");
		}
	}
    /*==========STATISTIC==========*/
    //Statistic by category of products
    public void thongKeTheoLoai(){
    	String loai;
    	System.out.println("Nhap vao loai hang ma ban muon thong ke: ");
    	loai = in.nextLine();
    	boolean isEmpty = true;
    	System.out.println("Ket qua thong ke cua loai san pham '" + loai + "' la: \n");
    	System.out.println("+-------+-------------------------------------+-----------------+---------+--------+--------------------------------+------------+");
		System.out.println("| Ma sp |           Ten san pham              |      Loai       |   Gia   |  SL co |  Huong vi/ Nguyen lieu chinh   |  Size/XXu  |");
		System.out.println("+-------+-------------------------------------+-----------------+---------+--------+--------------------------------+------------+");
    	for(int i = 0; i < soluong; i++) {
    		if(ds[i].getLoai().indexOf(loai) > -1) {
    			isEmpty = false;
    			ds[i].xuat();
    		}
    	}
    	if(isEmpty == true) {
    		System.out.println("!!!Loai san pham ma ban can thong ke khong co trong danh sach san pham!!!\n");
    	}
    }
    public void thongKeTheoLoai(String loai){
    	boolean isEmpty = true;
    	System.out.println("Ket qua thong ke cua loai san pham '" + loai + "' la: \n");
    	System.out.println("+-------+-------------------------------------+-----------------+---------+--------+--------------------------------+------------+");
		System.out.println("| Ma sp |           Ten san pham              |      Loai       |   Gia   |  SL co |  Huong vi/ Nguyen lieu chinh   |  Size/XXu  |");
		System.out.println("+-------+-------------------------------------+-----------------+---------+--------+--------------------------------+------------+");
    	for(int i = 0; i < soluong; i++) {
    		if(ds[i].getLoai().indexOf(loai) > -1) {
    			isEmpty = false;
    			ds[i].xuat();
    		}
    	}
    	if(isEmpty == true) {
    		System.out.println("!!!Loai san pham ma ban can thong ke khong co trong danh sach san pham!!!\n");
    	}
    }
    //Statistic from price to price
    public void thongKeTuGiaDenGia() {
    	//variable to check a result empty or not
    	boolean isEmpty = true;
    	int giaTu;
    	int giaDen;
    	System.out.println("Thong ke san pham");
    	System.out.print(" .Tu gia: ");
    	giaTu = in.nextInt();
    	
    	System.out.print(" .Den gia: ");
    	giaDen = in.nextInt();
    	
    	System.out.println("Cac san pham co gia nam trong khoang" + giaTu + " va " + giaDen + " la: \n");
    	System.out.println("+-------+-------------------------------------+-----------------+---------+--------+--------------------------------+------------+");
		System.out.println("| Ma sp |           Ten san pham              |      Loai       |   Gia   |  SL co |  Huong vi/ Nguyen lieu chinh   |  Size/XXu  |");
		System.out.println("+-------+-------------------------------------+-----------------+---------+--------+--------------------------------+------------+");
    	in.nextLine();
    	//compare price of products in array with giaTu and giaDen
    	for(int i = 0; i < soluong; i++) {
    		if(ds[i].getGia() >= giaTu && ds[i].getGia() <= giaDen) {
    			isEmpty = false;
    			ds[i].xuat();
    		}
    	}
    	
    	if(isEmpty == true) {
    		System.out.println("!!!Khong co san pham nao trong khoang gia ban yeu cau!!!\n");
    	}
    	
    }
    public void thongKeTuGiaDenGia(int giaTu, int giaDen) {
    	//variable to check a result empty or not
    	boolean isEmpty = true;
    	//compare price of products in array with giaTu and giaDen
    	System.out.println("Cac san pham co gia nam trong khoang " + giaTu + " va " + giaDen + " la: \n");
    	System.out.println("+-------+-------------------------------------+-----------------+---------+--------+--------------------------------+------------+");
		System.out.println("| Ma sp |           Ten san pham              |      Loai       |   Gia   |  SL co |  Huong vi/ Nguyen lieu chinh   |  Size/XXu  |");
		System.out.println("+-------+-------------------------------------+-----------------+---------+--------+--------------------------------+------------+");
    	for(int i = 0; i < soluong; i++) {
    		if(ds[i].getGia() >= giaTu && ds[i].getGia() <= giaDen) {
    			isEmpty = false;
    			ds[i].xuat();
    		}
    	}
    	
    	if(isEmpty == true) {
    		System.out.println("Khong co san pham nao trong khoang gia ban yeu cau!!!");
    	}
    	
    }
    //Statistic by left quantity (soluongco)
    public void thongKeSluongCo() {
    	//variable to check a result empty or not
    	boolean isEmpty = true;
    	System.out.println("Nhap vao so luong co toi thieu cua san pham ma ban mong muon: ");
    	int slYeuCau;
    	slYeuCau = in.nextInt();
    	in.nextLine();
    	System.out.println("Cac san pham dap ung du so luong: \n\n");
    	System.out.println("+-------+-------------------------------------+-----------------+---------+--------+--------------------------------+------------+");
		System.out.println("| Ma sp |           Ten san pham              |      Loai       |   Gia   |  SL co |  Huong vi/ Nguyen lieu chinh   |  Size/XXu  |");
		System.out.println("+-------+-------------------------------------+-----------------+---------+--------+--------------------------------+------------+");
    	for(int i = 0; i < soluong; i++) {
    		if(ds[i].getSoluongco() >= slYeuCau) {
    			isEmpty = false;
    			ds[i].xuat();
    		}
    	}
    	
    	if(isEmpty == true) {
    		System.out.println("!!!Khong co san pham nao dap ung du so luong ma ban yeu cau!!!\n");
    	}
    }
    public void thongKeSluongCo(int slYeuCau) {
    	//variable to check a result empty or not
    	boolean isEmpty = true;
    	System.out.println("Cac san pham dap ung du so luong: \n\n");
    	System.out.println("+-------+-------------------------------------+-----------------+---------+--------+--------------------------------+------------+");
		System.out.println("| Ma sp |           Ten san pham              |      Loai       |   Gia   |  SL co |  Huong vi/ Nguyen lieu chinh   |  Size/XXu  |");
		System.out.println("+-------+-------------------------------------+-----------------+---------+--------+--------------------------------+------------+");
    	for(int i = 0; i < soluong; i++) {
    		if(ds[i].getSoluongco() >= slYeuCau) {
    			isEmpty = false;
    			ds[i].xuat();
    		}
    	}
    	
    	if(isEmpty == true) {
    		System.out.println("!!!Khong co san pham nao dap ung du so luong ma ban yeu cau!!!\n");
    	}
    }
    /*==========WRITE AND READ FILE=========*/
    //Write file
    public void ghiFile(String fileName)throws IOException {
    	DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName));
    	try {
    		for(int i = 0; i < soluong; i++) {
    			ds[i].writeFile(fileName);
    		}
    	}catch(IOException e) {
    		
    	}
    	finally {
    		out.close();
    	}
    }
    //Read file
    public void docFile(String fileName)throws IOException {
    	DataInputStream input = new DataInputStream(new FileInputStream(fileName));
    	int i = 0;
    	try {
    		while(true) {
    			String productId;
    			productId = input.readUTF();
    			String checkSp = productId.substring(0,1);
    			if(checkSp.equals("t") == true) {
    				String tensp = input.readUTF();
    				String loaisp = input.readUTF();
    				int gia = input.readInt();
    				int solco = input.readInt();
    				String nlc = input.readUTF();
    				String xx = input.readUTF();
    				ds[i] = new ThucAnNhanh(productId,tensp,loaisp,gia,solco,nlc,xx);
    			}else if(checkSp.equals("g") == true) {
    				String tensp = input.readUTF();
    				String loaisp = input.readUTF();
    				int gia = input.readInt();
    				int solco = input.readInt();
    				String hvi = input.readUTF();
    				String size = input.readUTF();
    				ds[i] = new GiaiKhat(productId,tensp,loaisp,gia,solco,hvi,size);
    			}
    			i++;
    		}
    		
    	}catch(EOFException e) {}
    	finally {
    		this.soluong = i;
    		input.close();
    	}
    }
}
  
