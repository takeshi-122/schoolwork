package file_controll;

import java.io.FileReader;
import java.io.IOException;

public class Read {

	public static void main(String[] args) throws IOException{
		//読み込み準備
		FileReader fr = new FileReader("writetest.dat");
		//読み込み
		int i = fr.read();
		while(i != -1) {
			//復号
			i = i >> 1;
			char c = (char)i;
			System.out.print(c);
			i = fr.read();
		}

		//読み込み終了
		fr.close();

	}

}
