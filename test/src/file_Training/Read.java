package file_Training;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Read {

	public static void main(String[] args) throws FileNotFoundException {
		FileReader fr = new FileReader("test.txt");
		BufferedReader br = new BufferedReader(fr);

		try {
			br.lines().forEach(s -> System.out.println(s));
			System.out.println("読み込みが完了しました");
		} catch(Exception e) {
			System.out.println("読み込みが失敗しました");
		}finally {
			try {
				br.close();
			}catch(Exception e) {

			}
		}

	}

}
