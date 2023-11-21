package file_Training;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadSum {

	public static void main(String[] args) throws IOException {
		//FileReader fr = new FileReader("inputNum.txt");
		BufferedReader br = null;//new BufferedReader(fr);
		int num = 0;
		String s = null;

		/*while(num < 6) {
			System.out.println(br.readLine());
			num++;
		}*/
		//s = br.readLine();

		try {
			br = new BufferedReader(new FileReader("inputNum.txt"));
			do {
				//System.out.println(num);
				s = br.readLine();
				if(s == null) {
					System.out.println("合計は" + num + "です");
					break;
				}
				num += Integer.parseInt(s);
			} while(!s.equals(null));

		} catch(Exception e) {
			System.out.println("読み込みに失敗しました");
		} finally {
			try {
				br.close();
			} catch(Exception e) {

			}
		}
	}

}
