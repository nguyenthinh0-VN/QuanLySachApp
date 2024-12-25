package app;

import java.io.PrintWriter;
import java.util.Scanner;

import controller.InDSSachControl;
import controller.ThemMoiSachControl;
import dao.InDSSDAOFile;
import dao.ThemSachMoiDAOFile;
import ui.*;

public class AppQLS {

	public static void main(String[] args) {
		//sử dụng Class MenuCUI
				PrintWriter pWriterRemote = new PrintWriter(System.out, true);
				Scanner scannerRemote = new Scanner(System.in);
				ValidCUI.init(pWriterRemote, scannerRemote);
				InDSSachCUI inDSSachCUIRemote = new InDSSachCUI(pWriterRemote);
				//DAO
				
				ThemSachMoiDAOFile themSachMoiDAOFile = new 
						ThemSachMoiDAOFile("Sach.txt");
				
				
				ThongBaoThemSachCUI tbThemSachCUIRemote = 
						new ThongBaoThemSachCUI(pWriterRemote);

				InDSSDAOFile inDSSVDAOFileRemote = new InDSSDAOFile("Sach.txt");


				
				//Control
				ThemMoiSachControl themMoiSachControlRemote = new ThemMoiSachControl(themSachMoiDAOFile);
				themMoiSachControlRemote.setThemSachDAOFile(themSachMoiDAOFile);;
				themMoiSachControlRemote.setTbThemSachCUI(tbThemSachCUIRemote);

					//InDSSachControl
					InDSSachControl inDSSachControlRemote = new InDSSachControl(inDSSVDAOFileRemote, inDSSachCUIRemote);
					inDSSachControlRemote.set(inDSSVDAOFileRemote);


				//CUI
				ThemSachInputCUI themMoiSachCUIRemote = new 
						ThemSachInputCUI(pWriterRemote, scannerRemote,themMoiSachControlRemote);


				MenuCUI menuCUIRemote = new MenuCUI(pWriterRemote, 
						scannerRemote, themMoiSachCUIRemote);

					menuCUIRemote.setInDSSachControl(inDSSachControlRemote);
				
				//gửi thông điệp
				menuCUIRemote.controlLoop();
				

	}

}
