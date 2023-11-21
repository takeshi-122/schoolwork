package traning3;

public class FuncList {
	public static boolean isodd(int x) { return (x % 2 == 1); }
	public String passCheck(int point, String name) {
		return name + "さんは" + (point>65? "合格": "不合格");
	}

}
