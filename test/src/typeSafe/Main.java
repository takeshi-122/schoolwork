package typeSafe;

public class Main {

	public static void main(String[] args) {
		String str = "bow";
		int num = new java.util.Random().nextInt(10)+1;
		//型を指定することで実行前にエラーチェックが出来る
		//予期しないデータが入ることを抑制する
		prints(str, num);
	}

	//第一引数の文字列を第二引数の回数分だけ表示する
	public static void prints(String s, int num) {
		System.out.println(num);
		for(int i = 0; i < (Integer)num; i++) {
			System.out.print(s);
		}

	}

}
