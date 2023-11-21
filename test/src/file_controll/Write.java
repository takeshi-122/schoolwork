package file_controll;

import java.io.FileWriter;
import java.io.IOException;

public class Write {
	public static void main(String[] args) {
		FileWriter fw = null;

		try {
			//書き込み準備
			fw = new FileWriter("writetest.dat", true);
			//暗号化
			int rock = 80;
			rock = rock << 1;
			//書き込み（依頼）
			fw.write(rock);
			//今すぐ書き込ませる
			fw.flush();
		} catch (Exception e){
			System.out.println(e.getMessage());
		} finally {//必ず読み込む
			if(fw != null) {
				//処理終了
				try {
					fw.close();
				} catch (IOException e) {
					;
				}
			}
		}



	}


}
