package traning3;

import java.util.function.IntPredicate;

public class Main {

	public static void main(String[] args) {
		FuncList fl = new FuncList();
		/*func1 f1 = FuncList::isodd;
		func2 f2 = fl::passCheck;
		System.out.println(f1.apply(5));
		System.out.println(f2.apply(70, "ああああ"));*/

		//func1 f1 = x -> (x % 2 == 1);
		IntPredicate f1 = x -> (x % 2 == 1);
		func2 f2 = (point, name) -> name + "さんは" + (point > 65 ? "合格" : "不合格");
		System.out.println(f1.test(5));
		System.out.println(f2.apply(70, "ああああ"));
	}

}
