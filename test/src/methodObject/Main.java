package methodObject;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
	/*第一級オブジェクト
	 * ・変数に代入可能
	 * ・実行中に生成出来る
	 * ・引数として使用可能
	 */

	//メソッドは関数の一部

	//文字数を出力するメソッド
	public static Integer len(String s) {
		return s.length();
	}

	public static void main(String[] args) {
		//関数を変数に格納（格納するのは参照）
		Function<String, Integer> func = Main::len;
		//       ↑第一引数...戻り値     ↑クラス名::メソッド

		//戻り値のない関数格納（表示）
		Consumer<String> cons = System.out::println;
		cons.accept("特級オブジェクト");

		//引数のない関数格納（改行）
		Supplier<String> supp = System::lineSeparator;
		cons.accept("1行目" + supp.get() + "2行目");

		//引数２つ（システム情報表示）
		BiFunction<String, String, String> bFunc = System::getProperty;
		cons.accept(bFunc.apply("user.name", "キーが正しくありません"));

		//関数インターフェースを作成することで柔軟に対応できる

		//格納用変数
		int length = 0;

		length = func.apply("特級オブジェクト");
		//文字数を出力
		System.out.println(length);
	}

}
