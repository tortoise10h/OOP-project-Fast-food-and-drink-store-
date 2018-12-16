/*
x * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfoodanddrinkstore;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author Admin
 */
public class TheoDoiKhachHang 
{
    Scanner in = new Scanner(System.in);
	private String maKh;
	private String ngaybatdaumua;
        private String ngayMua;
	private String thangMua;
	private String namMua;
	private int tongtienchi;
	//Constructor
	public TheoDoiKhachHang() {
	}
	public TheoDoiKhachHang(String maKh, String ngaybatdaumua, String ngayMua, String thangMua, String namMua, int tongtienchi) 
        {
		this.maKh = maKh;
		this.ngaybatdaumua = ngaybatdaumua;
                this.ngayMua = ngayMua;
                this.thangMua = thangMua;
                this.namMua = namMua;
		this.tongtienchi = tongtienchi;
	}
	public TheoDoiKhachHang(TheoDoiKhachHang kt) 
        {
		maKh = kt.maKh;
		ngaybatdaumua = kt.ngaybatdaumua;
                ngayMua = kt.ngayMua;
                thangMua = kt.thangMua;
                namMua = kt.namMua;
		tongtienchi = kt.tongtienchi;
	}
	//Getter & Setter
	public String getMaKh() {
		return maKh;
	}
	public void setMaKh(String maKh) {
		this.maKh = maKh;
	}
        public String getNgaybatdaumua() {
		return ngaybatdaumua;
	}
	public void setNgaybatdaumua(String ngaybatdaumua) {
		this.ngaybatdaumua = ngaybatdaumua;
	}
        public String getngayMua() {
		return ngayMua;
	}
	public void setngayMua(String ngayMua) {
		this.ngayMua = ngayMua;
	}
        public String getthangMua() {
		return thangMua;
	}
	public void setthangMua(String thangMua) {
		this.thangMua = thangMua;
	}
        public String getnamMua() {
		return namMua;
	}
	public void setnamMua(String namMua) {
		this.namMua = namMua;
	}
        public int getTongtienchi() {
		return tongtienchi;
	}
	public void setTongtienchi(int tongtienchi) {
		this.tongtienchi = tongtienchi;
	}
        public void nhap() {
		Scanner sc = new Scanner(System.in);
		
		do{
			System.out.print("Nhap ma khach hang(5 so): ");
			this.setMaKh(sc.nextLine());
		}while(maKh.length()!=5);
                
                do {
			System.out.print("Nhap vao ngay bat dau mua: ");
			ngayMua = in.nextLine();
		}while(ngayMua.length() != 2);
		
		do {
			System.out.print("Nhap vao thang bat dau mua: ");
			thangMua = in.nextLine();
		}while(thangMua.length() != 2);
		
		do {
			System.out.print("Nhap vao nam bat dau mua: ");
			namMua = in.nextLine();
		}while(namMua.length() != 4);
		
		System.out.print("Nhap tong tien chi: ");
		this.setTongtienchi(sc.nextInt());
		sc.nextLine();
		//sc.close();
	}
	public void xuat()
	{       
                String tongtienchiTemp = String.format("%d", tongtienchi);
		int tongtienchiLength = tongtienchiTemp.length();
		for(int i = 0; i < 9-tongtienchiLength; i++) {
			tongtienchiTemp += " ";
		}
		//output row
		System.out.println(maKh + " | " + ngayMua + "/" + thangMua + "/" + namMua +  " | " + tongtienchi);
                System.out.println("+-------+------------------------------+------------+--------+---+-----------+");
        }
        /*==========WRITE FILE===========*/
	public void ghiFile(String fileName)throws IOException {
		DataOutputStream out = null;
		try {
			out =  new DataOutputStream(new FileOutputStream(fileName, Boolean.TRUE));
			out.writeUTF(maKh);
			out.writeUTF(ngayMua);
			out.writeUTF(thangMua);
			out.writeUTF(namMua);
			out.writeInt(tongtienchi);
		}catch(IOException e) {}
		finally {
			out.close();
		}
        }
}
