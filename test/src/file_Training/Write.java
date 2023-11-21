package file_Training;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Write {

	public static void main(String[] args) throws IOException {
		//FileWriter fw = new FileWriter("test.txt");
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = null;

		System.out.println("文字を入力してください");
		String str = sc.nextLine();
		try {
			bw = new BufferedWriter(new FileWriter("test.txt"));
			bw.write(str);
			System.out.println("書き込みが完了しました");
		} catch(Exception e) {
			System.out.println("書き込みに失敗しました");
		}finally {
			try {
				bw.flush();
				bw.close();
			}catch(Exception e) {

			}
		}
	}

}
