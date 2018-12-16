package fastfoodanddrinkstore;

import fastfoodanddrinkstore.DSSanPham;
import java.util.*;
import java.io.*;
public class Menu {
	public static void mainMenu() throws Exception{
		while(true) {
			Scanner in = new Scanner(System.in);
			int mainMenuIndex;
			System.out.println("+--------------------------------------+");
			System.out.println("|              MENU CHINH              |");
			System.out.println("+======================================+");
			System.out.println("| 1.  Quan ly san pham                 |");
			System.out.println("| 2.  Quan ly khach hang               |");
			System.out.println("| 3.  Quan ly nhan vien                |");
			System.out.println("| 4.  Quan ly hoa don nhap             |");
			System.out.println("| 5.  Quan ly chi tiet hoa don nhap    |");
			System.out.println("| 6.  Quan ly hoa don xuat             |");
			System.out.println("| 7.  Quan ly chi tiet hoa don xuat    |");
			System.out.println("| 8.  Quan ly nha cung cap             |");
			System.out.println("| 9.  Quan ly chuong trinh khuyen mai  |");
			System.out.println("| 10. Quan ly thong tin khuyen mai     |");
			System.out.println("|-1.  Thoat                            |");
			System.out.println("+--------------------------------------+");
			mainMenuIndex = in.nextInt();
			if(mainMenuIndex == -1) {
				System.out.println("\n!!!KET THUC CHUONG TRINH, CAM ON VA HEN GAP LAI!!!\n");
				break;
			}
			switch(mainMenuIndex) {
				
				case 1:{
					menuSanPham();
					break;
				}
				case 2:{
					menuKhachHang();
					break;
				}
				case 3:{
					menuNhanVien();
					break;
				}
				case 4:{
					menuHoaDonNhap();
					break;
				}
				case 5:{
					menuChiTietHoaDonNhap();
					break;
				}
				case 6:{
					menuHoaDonXuat();
					break;
				}
				case 7:{
					menuChiTietHoaDonXuat();
					break;
				}
				case 8:{
					menuNhaCungCap();
					break;
				}
				case 9:{
					menuKhuyenMai();
					break;
				}
				case 10:{
					menuThongTinKhuyenMai();
					break;
				}
				default: System.out.println("Muc ban chon khong co trong danh sach xin moi chon lai!!!");
			}
		}
		
	}
	/*===========MENU SAN PHAM===========*/
	public static void menuSanPham() throws IOException {
		while(true) {
			Scanner in = new Scanner(System.in);
			int spMenuIndex;
			System.out.println("+--------------------------------------------+");
			System.out.println("|                 MENU SAN PHAM              |");
			System.out.println("+-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=+");
			System.out.println("| 1.  Xem danh sach san pham                 |");
			System.out.println("| 2.  Them mot san pham moi                  |");
			System.out.println("| 3.  Them nhieu san pham moi                |");
			System.out.println("| 4.  Xoa mot san pham theo ma               |");
			System.out.println("| 5.  Sua mot san pham theo ma               |");
			System.out.println("| 6.  Tim kiem san pham theo ma              |");
			System.out.println("| 7.  Tim kiem san pham theo ten             |");
			System.out.println("| 8.  Tim kiem san pham theo loai            |");
			System.out.println("| 9.  Thong ke san pham tu gia den gia       |");
			System.out.println("| 10. Thong ke san pham voi so luong co      |");
			System.out.println("| -1. Quay lai                               |");
			System.out.println("+--------------------------------------------+");
			spMenuIndex = in.nextInt();
			in.nextLine();
			if(spMenuIndex == -1) {
				break;
			}
			DSSanPham spList = new DSSanPham();
			String spTextFile = "src/sanpham.txt";
			spList.docFile(spTextFile);
			switch(spMenuIndex) {
				
				case 1:{
					spList.xuat();
					break;
				}
				case 2:{
					spList.them();
					spList.ghiFile(spTextFile);
					break;
				}
				case 3:{
					int slThem;
					System.out.print("Nhap vao so luong san pham can them moi: ");
					slThem = in.nextInt();
					spList.them(slThem);
					spList.ghiFile(spTextFile);
					break;
				}
				case 4:{
					spList.xoa();
					spList.ghiFile(spTextFile);
					break;
				}
				case 5:{
					spList.sua();
					spList.ghiFile(spTextFile);
					break;
				}
				case 6:{
					int pos = spList.timKiem();
					SanPham[] ds = spList.getDs();
					if(pos == -1) {
						System.out.println("!!!Khong tim thay san pham!!!\n");
					}else {
						System.out.println("+-------+-------------------------------------+-----------------+---------+--------+--------------------------------+------------+");
						System.out.println("| Ma sp |           Ten san pham              |      Loai       |   Gia   |  SL co |  Huong vi/ Nguyen lieu chinh   |  Size/XXu  |");
						System.out.println("+-------+-------------------------------------+-----------------+---------+--------+--------------------------------+------------+");
						ds[pos].xuat();
					}
					break;
				}
				case 7:{
					spList.timTheoTen();
					break;
				}
				case 8:{
					spList.timTheoLoai();
					break;
				}
				case 9:{
					spList.thongKeTuGiaDenGia();
					break;
				}
				case 10:{
					spList.thongKeSluongCo();
					break;
				}
				default: System.out.println("Muc ban chon khong co trong danh sach xin moi chon lai!!!");
			}
		}
		
	}
	/*==========MENU KHACH HANG==========*/
	public static void menuKhachHang() throws Exception {
		while(true) {
			Scanner in = new Scanner(System.in);
			int khMenuIndex;
			System.out.println("+--------------------------------------------+");
			System.out.println("|                MENU KHACH HANG             |");
			System.out.println("+-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=+");
			System.out.println("| 1. Xem danh sach khach hang                |");
			System.out.println("| 2. Them mot khach hang moi                 |");
			System.out.println("| 3. Them nhieu khach hang moi               |");
			System.out.println("| 4. Xoa mot khach hang theo ma              |");
			System.out.println("| 5. Sua mot khach hang theo ma              |");
			System.out.println("| 6. Tim kiem khach hang theo ma             |");
			System.out.println("| 7. Tim kiem khach hang theo ten            |");
			System.out.println("| 8. Tim kiem khach hang theo ho             |");
			System.out.println("| 9. Thong ke khach hang theo gioi tinh      |");
			System.out.println("| 10. Mua hang                               |");
			System.out.println("| -1. Quay lai                               |");
			System.out.println("+--------------------------------------------+");
			khMenuIndex = in.nextInt();
			in.nextLine();
			if(khMenuIndex == -1) {
				break;
			}
			DSKhachHang khList = new DSKhachHang();
			String khTextFile = "src/khachhang.txt";
			khList.docFile(khTextFile);
			switch(khMenuIndex) {
				
				case 1:{
					khList.xuat();
					break;
				}
				case 2:{
					khList.them();
					khList.ghiFile(khTextFile);
					break;
				}
				case 3:{
					int slThem;
					System.out.print("Nhap vao so luong khach hang can them moi: ");
					slThem = in.nextInt();
					khList.them(slThem);
					khList.ghiFile(khTextFile);
					break;
				}
				case 4:{
					khList.xoa();
					khList.ghiFile(khTextFile);
					break;
				}
				case 5:{
					khList.sua();
					khList.ghiFile(khTextFile);
					break;
				}
				case 6:{
					int pos = khList.timKiem();
					KhachHang[] ds = khList.getDs();
					if(pos == -1) {
						System.out.println("\n!!!Khong tim thay khach hang yeu cau!!!\n");
					}else {
						System.out.println("+-------+------------------------------+--------+------------+--------------------------------------------------------------------------------------------+");
				    	System.out.println("| Ma kh |          Ho va ten           | Gtinh  |    sodt    |                                               Dia chi                                      |");
				    	System.out.println("+-------+------------------------------+--------+------------+--------------------------------------------------------------------------------------------+");
				    	ds[pos].xuat();
					}
					break;
				}
				case 7:{
					khList.timTheoTen();
					break;
				}
				case 8:{
					khList.timTheoHo();
					break;
				}
				case 9:{
					khList.thongKe();;
					break;
				}
				case 10:{
					khList.muaHang();
					break;
				}
				default: System.out.println("Muc ban chon khong co trong danh sach xin moi chon lai!!!");
			}
		}
		
	}
	
	/*===========MENU NHAN VIEN==========*/
	public static void menuNhanVien() throws IOException {
		while(true) {
			Scanner in = new Scanner(System.in);
			int nvMenuIndex;
			System.out.println("+--------------------------------------------+");
			System.out.println("|                 MENU NHAN VIEN             |");
			System.out.println("+-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=+");
			System.out.println("| 1. Xem danh sach nhan vien                 |");
			System.out.println("| 2. Them mot nhan vien moi                  |");
			System.out.println("| 3. Them nhieu nhan vien moi                |");
			System.out.println("| 4. Xoa mot nhan vien theo ma               |");
			System.out.println("| 5. Sua mot nhan vien theo ma               |");
			System.out.println("| 6. Tim kiem nhan vien theo ma              |");
			System.out.println("| 7. Tim kiem nhan vien theo ten             |");
			System.out.println("| 8. Tim kiem nhan vien theo ho              |");
			System.out.println("| 9. Thong ke nhan vien theo gioi tinh       |");
			System.out.println("| 10. Thong ke nhan vien theo nam sinh       |");
			System.out.println("| 11. Thong ke nhan vien theo ca lam         |");
			System.out.println("| -1. Quay lai                               |");
			System.out.println("+--------------------------------------------+");
			nvMenuIndex = in.nextInt();
			in.nextLine();
			if(nvMenuIndex == -1) {
				break;
			}
			DSNhanVien nvList = new DSNhanVien();
			String nvTextFile = "src/nhanvien.txt";
			nvList.docFile(nvTextFile);
			switch(nvMenuIndex) {
				
				case 1:{
					nvList.xuat();
					break;
				}
				case 2:{
					nvList.them();
					nvList.ghiFile(nvTextFile);
					break;
				}
				case 3:{
					int slThem;
					System.out.print("Nhap vao so luong nhan vien can them moi: ");
					slThem = in.nextInt();
					in.nextLine();
					nvList.them(slThem);
					nvList.ghiFile(nvTextFile);
					break;
				}
				case 4:{
					nvList.xoa();
					nvList.ghiFile(nvTextFile);
					break;
				}
				case 5:{
					nvList.sua();
					nvList.ghiFile(nvTextFile);
					break;
				}
				case 6:{
					int pos = nvList.timKiem();
					NhanVien[] ds = nvList.getDs();
					if(pos == -1) {
						System.out.println("\n!!!Khong tim thay nhan vien yeu cau!!!\n");
					}else {
						System.out.println("+-------+------------------------------+------------+--------+---+-----------+");
				    	System.out.println("| Ma nv |          Ho va ten           | Ngay sinh  | Gtinh  |Ca | Luong     |");
				    	System.out.println("+-------+------------------------------+------------+--------+---+-----------+");
				    	ds[pos].xuat();
					}
					break;
				}
				case 7:{
					nvList.timTheoTen();
					break;
				}
				case 8:{
					nvList.timTheoHo();
					break;
				}
				case 9:{
					nvList.thongKeGioiTinh();
					break;
				}
				case 10:{
					nvList.thongKeNamSinh();
					break;
				}
				case 11:{
					nvList.thongKeCaLam();
					break;
				}
				default: System.out.println("Muc ban chon khong co trong danh sach xin moi chon lai!!!");
			}
		}
		
	}
	
	/*===============MENU HOA DON NHAP==========*/
	public static void menuHoaDonNhap()throws Exception {
		while(true) {
			Scanner in = new Scanner(System.in);
			int hdnMenuIndex;
			System.out.println("+-----------------------------------------------+");
			System.out.println("|               MENU HOA DON NHAP               |");
			System.out.println("+-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-+");
			System.out.println("| 1. Xem danh sach hoa don nhap                 |");
			System.out.println("| 2. Them mot hoa don nhap moi                  |");
			System.out.println("| 3. Them nhieu hoa don nhap moi                |");
			System.out.println("| 4. Xoa mot hoa don nhap                       |");
			System.out.println("| 5. Sua thong tin mot hoa don nhap             |");
			System.out.println("| 6. Tim kiem mot hoa don nhap theo ma          |");
			System.out.println("| 7. Thong ke hoa don nhap theo nhan vien nhap  |");
			System.out.println("| 8. Thong ke hoa don nhap theo nha cung cap    |");
			System.out.println("|-1. Quay lai                                   |");
			System.out.println("+-----------------------------------------------+");
			hdnMenuIndex = in.nextInt();
			in.nextLine();
			if(hdnMenuIndex == -1) {
				break;
			}
			DSHoaDonNhap hdnList = new DSHoaDonNhap();
			String hdnTextFile = "src/hoadonnhap.txt";
			hdnList.docFile(hdnTextFile);
			switch(hdnMenuIndex) {
				case 1:{
					hdnList.xuat();
					break;
				}
				case 2:{
					hdnList.them();
					hdnList.ghiFile(hdnTextFile);
					break;
				}
				case 3:{
					int sl;
					do {
						System.out.print("Nhap vao so luong hoa don nhap can them: ");
						sl = in.nextInt();
						in.nextLine();
					}while(sl < 1);
					hdnList.them(sl);
					hdnList.ghiFile(hdnTextFile);
					break;
				}
				case 4:{
					hdnList.xoa();
					hdnList.ghiFile(hdnTextFile);
					break;
				}
				case 5:{
					hdnList.sua();
					hdnList.ghiFile(hdnTextFile);
					break;
				}
				case 6:{
					int pos = hdnList.timKiem();
					HoaDonNhap[] ds = hdnList.getDs();
					if(pos == -1) {
						System.out.println("\n!!!Khong tim thay hoa don yeu cau!!!\n");
					}else {
						System.out.println("+----------+------------+----------+----------+------------+");
				    	System.out.println("|Ma Hoa Don| Ngay Nhap  | Ma Nvien |  Ma NCC  |  Tong Chi  |");
				    	System.out.println("+----------+------------+----------+----------+------------+");
						ds[pos].xuat();
					}
					break;
				}
				case 7:{
					hdnList.thongKeTheoNvien();
					break;
				}
				case 8:{
					hdnList.thongKeTheoNcc();
					break;
				}
				default: System.out.println("Muc ban chon khong co trong danh sach xin moi chon lai!!!");
			}
		}
	}
	
	/*==========MENU CHI TIET HOA DON NHAP==========*/
	public static void menuChiTietHoaDonNhap()throws Exception {
		while(true) {
			Scanner in = new Scanner(System.in);
			int cthdnMenuIndex;
			System.out.println("+-----------------------------------------------+");
			System.out.println("|           MENU CHI TIET HOA DON NHAP          |");
			System.out.println("+-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-+");
			System.out.println("| 1. Xem danh sach chi tiet hoa don             |");
			System.out.println("| 2. Tim kiem mot chi tiet hoa don              |");
			System.out.println("| 3. Thong ke theo ma hoa don / ma san pham     |");
			System.out.println("| 4. Thong ke theo don gia                      |");
			System.out.println("| 5. Thong ke theo so luong                     |");
			System.out.println("| 6. Thong ke theo thanh tien                   |");
			System.out.println("|-1. Quay lai                                   |");
			System.out.println("+-----------------------------------------------+");
			cthdnMenuIndex = in.nextInt();
			in.nextLine();
			if(cthdnMenuIndex == -1) {
				break;
			}
			DSChiTietHoaDonNhap cthdnList = new DSChiTietHoaDonNhap();
			String cthdnTextFile = "src/chitiethoadonnhap.txt";
			cthdnList.docFile(cthdnTextFile);
			switch(cthdnMenuIndex) {
				case 1:{
					cthdnList.xuat();
					break;
				}
				case 2:{
					int pos = cthdnList.tim();
					if(pos == -1) {
						System.out.println("Khong tim thay chi tiet hoa don!!!");
					}else {
						ChiTietHoaDonNhap[] cthdnDs = cthdnList.getDs();
						System.out.println("+----------+----------+------------+------------+-------+");
						System.out.printf("| %-8s | %-8s | %-10s | %-10s | %-5s|\n","Ma Hd","Ma Sp","Don Gia","Thanh Tien","Sluong");
						System.out.println("+----------+----------+------------+------------+-------+");
						cthdnDs[pos].xuat();
					}
					break;
				}
				case 3:{
					cthdnList.thongke();
					break;
				}
				case 4:{
					cthdnList.thongKeTheoDonGia();
					break;
				}
				case 5:{
					cthdnList.thongKeTheoSoLuong();
					break;
				}
				case 6:{
					cthdnList.thongKeTheoThanhTien();
					break;
				}
				default: System.out.println("Muc ban chon khong co trong danh sach xin moi chon lai!!!");
			}
		}
	}
	/*==========MENU KHUYEN MAI==========*/
	public static void menuKhuyenMai() throws Exception {
		while(true) {
			Scanner in = new Scanner(System.in);
			int kmMenuIndex;
			System.out.println("+--------------------------------------------+");
			System.out.println("|                MENU KHUYEN MAI             |");
			System.out.println("+-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=+");
			System.out.println("| 1. Xem danh sach khuyen mai                |");
			System.out.println("| 2. Them mot chuong trinh khuyen mai moi    |");
			System.out.println("| 3. Them nhieu chuong trinh khuyen mai moi  |");
			System.out.println("| 4. Xoa mot khuyen mai theo ma              |");
			System.out.println("| 5. Sua mot khuyen mai theo ma              |");
			System.out.println("| 6. Tim mot khuyen mai theo ma              |");
			System.out.println("| 7. Thong ke khuyen mai theo ngay           |");
			System.out.println("|-1. Quay lai                                |");
			System.out.println("+--------------------------------------------+");
			kmMenuIndex = in.nextInt();
			in.nextLine();
			if(kmMenuIndex == -1) {
				break;
			}
			DSKhuyenMai kmList = new DSKhuyenMai();
			String kmTextFile = "src/khuyenmai.txt";
			kmList.docFile(kmTextFile);
			switch(kmMenuIndex) {
				
				case 1:{
					kmList.xuat();
					break;
				}
				case 2:{
					kmList.them();
					kmList.ghiFile(kmTextFile);
					break;
				}
				case 3:{
					int slThem;
					System.out.print("Nhap vao so luong khuyen mai can them moi: ");
					slThem = in.nextInt();
					in.nextLine();
					kmList.them(slThem);
					kmList.ghiFile(kmTextFile);
					break;
				}
				case 4:{
					kmList.xoa();
					kmList.ghiFile(kmTextFile);
					break;
				}
				case 5:{
					kmList.sua();
					kmList.ghiFile(kmTextFile);
					break;
				}
				case 6:{
					int pos = kmList.tim();
					KhuyenMai[] ds = kmList.getDs();
					if(pos != -1) {
						System.out.println("+-------+--------------------------------------------------------------+------------+------------+");
						System.out.println("| ma km |                  Mo ta chuong trinh khuyen mai               + Ngay Bdau  | Ngay Kthuc |");
						System.out.println("+-------+--------------------------------------------------------------+------------+------------+");
						ds[pos].xuat();
					}else {
						System.out.println("\n!!!Khong tim thay chuong trinh khuyen mai!!!\n");
					}
					break;
				}
				case 7:{
					kmList.thongKeTheoNgayThang();
					break;
				}
				
				default: System.out.println("Muc ban chon khong co trong danh sach xin moi chon lai!!!");
			}
		}
		
	}
	
	/*==========MENU THONG TIN KHUYEN MAI==========*/
	public static void menuThongTinKhuyenMai() throws IOException {
		while(true) {
			Scanner in = new Scanner(System.in);
			int ttkmMenuIndex;
			System.out.println("+-------------------------------------------------+");
			System.out.println("|             MENU THONG TIN KHUYEN MAI           |");
			System.out.println("+-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-+");
			System.out.println("| 1. Xem danh sach thong tin khuyen mai           |");
			System.out.println("| 2. Tim kiem mot thong tin khuyen mai            |");
			System.out.println("| 3. Thong ke theo ma khuyen mai / ma san pham    |");
			System.out.println("| 4. Thong ke theo phan tram khuyen mai           |");
			System.out.println("| 5. Thong ke cac khuyen mai co qua               |");
			System.out.println("|-1. Quay lai                                     |");
			System.out.println("+-------------------------------------------------+");
			ttkmMenuIndex = in.nextInt();
			in.nextLine();
			if(ttkmMenuIndex == -1) {
				break;
			}
			DSThongTinKhuyenMai ttkmList = new DSThongTinKhuyenMai();
			String ttkmTextFile = "src/thongtinkhuyenmai.txt";
			ttkmList.docFile(ttkmTextFile);
			switch(ttkmMenuIndex) {
				case 1:{
					ttkmList.xuat();
					break;
				}
				case 2:{
					int pos = ttkmList.tim();
					ThongTinKhuyenMai[] ds = ttkmList.getDs();
					if(pos != -1) {
						System.out.println("+----------+----------+------+-------------------------------------+");
						System.out.println("|   Ma km  |   Masp   |%Giam |               Qua tang              |");
						System.out.println("+----------+----------+------+-------------------------------------+");
						ds[pos].xuat();
					}else {
						System.out.println("\n!!!Khong tim thay thong tin khuyen mai!!!\n");
					}
				}
				case 3:{
					ttkmList.thongke();
					break;
				}
				case 4:{
					ttkmList.thongKeTheoPhanTram();
					break;
				}
				case 5:{
					ttkmList.thongkeTheoQuaTang();
					break;
				}
				
				default: System.out.println("Muc ban chon khong co trong danh sach xin moi chon lai!!!");
			}
		}
		
	}
	
	/*===============MENU NHA CUNG CAP==========*/
	public static void menuNhaCungCap()throws IOException {
		while(true) {
			Scanner in = new Scanner(System.in);
			int nccMenuIndex;
			System.out.println("+--------------------------------------------+");
			System.out.println("|              MENU NHA CUNG CAP             |");
			System.out.println("+-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=+");
			System.out.println("| 1. Xem danh sach nha cung cap              |");
			System.out.println("| 2. Them mot nha cung cap moi               |");
			System.out.println("| 3. Them nhieu nha cung cap moi             |");
			System.out.println("| 4. Xoa mot nha cung cap                    |");
			System.out.println("| 5. Sua thong tin mot nha cung cap          |");
			System.out.println("| 6. Tim kiem mot nha cung cap theo ma       |");
			System.out.println("| 7. Tim kiem mot nha cung cap theo ten      |");
			System.out.println("|-1. Quay lai                                |");
			System.out.println("+--------------------------------------------+");
			nccMenuIndex = in.nextInt();
			in.nextLine();
			if(nccMenuIndex == -1) {
				break;
			}
			DSNhaCungCap nccList = new DSNhaCungCap();
			String nccTextFile = "src/nhacungcap.txt";
			nccList.docFile(nccTextFile);
			switch(nccMenuIndex) {
				case 1:{
					nccList.xuat();
					break;
				}
				case 2:{
					nccList.them();
					nccList.ghiFile(nccTextFile);
					break;
				}
				case 3:{
					int sl;
					do {
						System.out.print("Nhap vao so luong nha cung cap can them: ");
						sl = in.nextInt();
					}while(sl < 1);
					nccList.them(sl);
					nccList.ghiFile(nccTextFile);
					break;
				}
				case 4:{
					nccList.xoa();
					nccList.ghiFile(nccTextFile);
					break;
				}
				case 5:{
					nccList.sua();
					nccList.ghiFile(nccTextFile);
					break;
				}
				case 6:{
					int pos = nccList.timKiem();
					if(pos == -1) {
						System.out.println("\n!!!Khong tim thay nha cung cap yeu cau!!!");
					}else {
						NhaCungCap[] ds = nccList.getDs();
						System.out.println("+-------+------------------------------------------+------------------------------------------+");
				        System.out.println("| ma ncc|              Ten nha cung cap            |             Mat hang cung cap            |");
				        System.out.println("+-------+------------------------------------------+------------------------------------------+");
						ds[pos].xuat();
					}
					break;
				}
				case 7:{
					nccList.timTheoTen();
					break;
				}
				default: System.out.println("Muc ban chon khong co trong danh sach xin moi chon lai!!!");
			}
		}
	}
	
	
	/*===============MENU HOA DON XUAT==========*/
	public static void menuHoaDonXuat()throws Exception {
		while(true) {
			Scanner in = new Scanner(System.in);
			int hdxMenuIndex;
			System.out.println("+-----------------------------------------------+");
			System.out.println("|               MENU HOA DON XUAT               |");
			System.out.println("+-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-+");
			System.out.println("| 1. Xem danh sach hoa don xuat                 |");
			System.out.println("| 2. Them mot hoa don xuat moi                  |");
			System.out.println("| 3. Them nhieu hoa don xuat moi                |");
			System.out.println("| 4. Xoa mot hoa don xuat                       |");
			System.out.println("| 5. Sua thong tin mot hoa don xuat             |");
			System.out.println("| 6. Tim kiem mot hoa don xuat theo ma          |");
			System.out.println("| 7. Thong ke hoa don xuat theo nhan vien xuat  |");
			System.out.println("| 8. Thong ke hoa don xuat theo khach hang      |");
			System.out.println("|-1. Quay lai                                   |");
			System.out.println("+-----------------------------------------------+");
			hdxMenuIndex = in.nextInt();
			in.nextLine();
			if(hdxMenuIndex == -1) {
				break;
			}
			DSHoaDonXuat hdxList = new DSHoaDonXuat();
			String hdxTextFile = "src/hoadonxuat.txt";
			hdxList.docFile(hdxTextFile);
			switch(hdxMenuIndex) {
				case 1:{
					hdxList.xuat();
					break;
				}
				case 2:{
					hdxList.them();
					hdxList.ghiFile(hdxTextFile);
					break;
				}
				case 3:{
					int sl;
					do {
						System.out.print("Nhap vao so luong hoa don xuat can them: ");
						sl = in.nextInt();
					}while(sl < 1);
					hdxList.them(sl);
					hdxList.ghiFile(hdxTextFile);
					break;
				}
				case 4:{
					hdxList.xoa();
					hdxList.ghiFile(hdxTextFile);
					break;
				}
				case 5:{
					hdxList.sua();
					hdxList.ghiFile(hdxTextFile);
					break;
				}
				case 6:{
					int pos = hdxList.timKiem();
					HoaDonXuat[] ds = hdxList.getDs();
					if(pos == -1) {
						System.out.println("\n!!!Khong tim thay hoa don yeu cau!!!\n");
					}else {
						System.out.println("+----------+------------+----------+------------+----------+----------+------------+");
				    	System.out.println("|Ma Hoa Don| Ngay Xuat  | Ma Nvien | Tong Tien  | Ma Khang | Ma Kmai  | Tien Kmai  |");
				    	System.out.println("+----------+------------+----------+------------+----------+----------+------------+");
						ds[pos].xuat();
					}
					break;
				}
				case 7:{
					hdxList.thongKeTheoNvien();
					break;
				}
				case 8:{
					hdxList.thongKeTheoKhachHang();
					break;
				}
				default: System.out.println("Muc ban chon khong co trong danh sach xin moi chon lai!!!");
			}
		}
	}
	
	
	/*==========MENU CHI TIET HOA DON XUAT==========*/
	public static void menuChiTietHoaDonXuat()throws Exception {
		while(true) {
			Scanner in = new Scanner(System.in);
			int cthdxMenuIndex;
			System.out.println("+-----------------------------------------------+");
			System.out.println("|           MENU CHI TIET HOA DON XUAT          |");
			System.out.println("+-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-+");
			System.out.println("| 1. Xem danh sach chi tiet hoa don xuat        |");
			System.out.println("| 2. Tim kiem mot chi tiet hoa don xuat         |");
			System.out.println("| 3. Thong ke theo ma hoa don / ma san pham     |");
			System.out.println("| 4. Thong ke theo don gia                      |");
			System.out.println("| 5. Thong ke theo so luong                     |");
			System.out.println("| 6. Thong ke theo thanh tien                   |");
			System.out.println("|-1. Quay lai                                   |");
			System.out.println("+-----------------------------------------------+");
			cthdxMenuIndex = in.nextInt();
			in.nextLine();
			if(cthdxMenuIndex == -1) {
				break;
			}
			DSChiTietHoaDonXuat cthdxList = new DSChiTietHoaDonXuat();
			String cthdxTextFile = "src/chitiethoadonxuat.txt";
			cthdxList.docFile(cthdxTextFile);
			switch(cthdxMenuIndex) {
				case 1:{
					cthdxList.xuat();
					break;
				}
				case 2:{
					int pos = cthdxList.tim();
					if(pos == -1) {
						System.out.println("\n!!!Khong tim thay chi tiet hoa don xuat!!!\n");
					}else {
						ChiTietHoaDonXuat[] cthdxDs = cthdxList.getds();
						System.out.println("+----------+----------+------------+------------+-------+");
						System.out.printf("| %-8s | %-8s | %-10s | %-10s | %-5s|\n","Ma Hd","Ma Sp","Don Gia","Thanh Tien","Sluong");
						System.out.println("+----------+----------+------------+------------+-------+");
						cthdxDs[pos].xuat();
					}
					break;
				}
				case 3:{
					cthdxList.thongke();
					break;
				}
				case 4:{
					cthdxList.thongKeTheoDonGia();
					break;
				}
				case 5:{
					cthdxList.thongKeTheoSoLuong();
					break;
				}
				case 6:{
					cthdxList.thongKeTheoThanhTien();
					break;
				}
				default: System.out.println("Muc ban chon khong co trong danh sach xin moi chon lai!!!");
			}
		}
	}
}
