package file_controll;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BuffelingFilter {

	public static void main(String[] args) throws IOException {
		//書き込み処理
		FileReader fr = new FileReader("read.dat");
		//バッファリングフィルター
		//RAMにデータを貯めて、まとめて書き込み処理を行なうことで回数を減らす
		BufferedReader br = new BufferedReader(fr);

		/*String line = null;

		line = br.readLine();

		while(line != null) {
			System.out.println(line);
			line = br.readLine();
		}*/
		//16~23行目までの処理を1行にしたもの
		br.lines().forEach(s -> System.out.println(s));
	}
}
