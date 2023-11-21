package generisc;
					//						一度置き換えた型
					//↓generics（仮型引数）一度書き換えた型から入れ替えられない
public class pockett<E> {//<E extends Character>と定義するとCharacter型を継承しているクラスのみ使用可能
	//型を指定しない場合、Object型に自動で定義される
	//基本型の使用はNG
	//コンパイル時に型のチェックがされる
	private E date; //データ格納用変数

	public void put(E o) { this.date = o; }
	public E get() { return this.date; }

}
