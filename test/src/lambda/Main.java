package lambda;

import java.util.Date;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntToDoubleFunction;
import java.util.function.Supplier;

public class Main {
	//staticはインスタンス生成を必要としないメソッド
	public static int add(int x, int y) {
		return x + y;
	}

	public static void main(String[] args) {
		//							ラムダ式:実行と同時に関数を生成
		Function<String, Integer> func = (String s) -> { return s.length(); };
		//									引数 -> 戻り値

		int num = func.apply("Java");
		System.out.println("文字数：" + num);

		//引数無し（日付表示）
		Supplier<Date> sup = () -> { return new java.util.Date(); };
		System.out.println("今日の日時は:" + sup.get());

		//addメソッドを格納する関数オブジェクトを作成（int型を格納）
		IntBinaryOperator fun = Main::add;
		int c = fun.applyAsInt(1, 3);
		System.out.println(c);


		TryFunction<IntBinaryOperator> tf = (IntBinaryOperator ib, int a, int b) -> {
			int result = ib.applyAsInt(ib.applyAsInt(a, b), ib.applyAsInt(a, b));
			return result;
		};
		int r = tf.apply(fun, 12, 11);
		System.out.println(r);

		//省略記法
		//省略なしVer.
		IntToDoubleFunction normal = (int x) -> { return x * x * 3.14; };

		//代入時にラムダ式は「型名」を省略可能
		IntToDoubleFunction idf1 = (x) -> { return x * x * 3.14; };

		//引数が１つの場合「（）」を省略可能
		IntToDoubleFunction idf2 = x -> { return x * x * 3.14; };

		//処理内容が単一の場合「{return }」を省略可能
		IntToDoubleFunction idf3 = x -> x * x * 3.14;
	}

}
