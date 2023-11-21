package nullSafe;

import java.util.Optional;

public class Main {

	//decorateメソッド
	//目的：文字列の両端に文字を追加する（$たなか$）
	//第一引数：文字列（たなか）
	//第二引数：はさむ文字（$）
	//戻り値：Optional<String>　nullが格納される可能性があることを考慮した処理を呼び出し側に強制させる
	//処理：文字列がnull、もしくは文字数が0の場合nullを返す。
	//		正しい引数が設定された場合、文字列の両端にはさむ文字を追加する
	public static Optional<String> decorate(String s, char c) {
		if(s == null || s.length() == 0 ) {
			return Optional.ofNullable(null);
		}

		return Optional.ofNullable(c + s + c);
	}

	public static void main(String[] args) {
		//nullを代入しているか確認しながらインスタンス生成（newから始まらない）
		Optional<String> op1 = Optional.ofNullable("SKY-HI");
		//nullが代入されることを禁止する
		//Optional<String> op2 = Optional.of(null);
		//nullの格納をする
		Optional<String> op2 = Optional.ofNullable(null);

		//nullが格納されているかチェック（true:nullが格納されていない、false:nullが格納されている）
		System.out.println(op1.isPresent());
		System.out.println(op2.isPresent());

		//格納している内容を取得する（nullの場合、例外が発生する）
		System.out.println("勇者" + op1.get());
		//System.out.println("勇者" + op2.get());

		//格納している内容を取得する（nullの場合、引数と置き換える）
		System.out.println("勇者" + op1.orElse("ななし"));
		System.out.println("勇者" + op2.orElse("ななし"));

		Optional<String> op3 = decorate("a", '-');
		System.out.println(op3.orElse("nullが格納されている"));

	}

}
