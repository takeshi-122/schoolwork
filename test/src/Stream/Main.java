package Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<Hero> list = new ArrayList<>();

		for(int i = 0; i < 20; i++) {
			list.add(new Hero("ヨシヒコ" + (i+1)));
		}

		//Heroのうち1人のHPを0にする
		int ran = new java.util.Random().nextInt(20);
		list.get(ran).setHp(0);

		//Heroのうち1人でもHP:0がいたらtrueを格納する
		//stream()メソッドで全要素検索
		boolean isKO = list.stream().anyMatch(h -> h.getHp() == 0);

		//StreamAPIの初期化（インスタンス生成）
		//Stream<Hero> st = list.stream();初期化できない、都度生成が必要

		//繰り返し処理
		list.stream().forEach(h ->{
			System.out.println("勇者の名前:" + h.getName());
		});

		//最初の要素を取得 findFirst()
		Optional<Hero> op = list.stream().findFirst();//Optional null安全性、findFirst()先頭の要素を返す
		if(op.isPresent()) {//isPresent()値の有無を確認
			System.out.println("最初の要素の名前は:" + op.get().getName());
		}

		//最大値(HP)を格納している要素を取得
		list.get(ran).setHp(50);
		Optional<Hero> op2 = list.stream().max((x, y) -> x.getHp() - y.getHp());
		System.out.println("HPが一番高いのは" + op2.get().getName());

		//勇者の名前を格納したリストを作成
		//①listから取得する（新規インスタンス生成しない）
		//②HPが5の勇者からのみ取得する
		//③3人に限定する
		List<String> list2 = new ArrayList<>();
		for(int i = 0; i < 5; i++) {
			ran = new Random().nextInt(20);
			list.get(ran).setHp(5);
		}

		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getHp() == 5) {
				list2.add(list.get(i).getName());
			}
			if(list2.size() == 3) {
				break;
			}
		}
								//streamAPI filterで対象制限          limit限界値 mapで代入する値指定  streamからListに変換
		List<String> list3 = list.stream().filter(h -> h.getHp() == 5).limit(3).map(h -> h.getName()).collect(Collectors.toList());
		for(String s : list3) {
			System.out.println(s);
		}
		System.out.println(list3);


		for(String s: list2) {
			System.out.println(s);
		}

		/*for(Hero h: list) {
			if(h.getHp() == 0) {
				isKO = true;
				break;
			}
		}*/

		if(isKO) {
			System.out.println("HP:0の勇者がいます");
		}

		System.out.println(list2);

	}

}
