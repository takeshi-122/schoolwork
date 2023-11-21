package algorithm;

import java.util.Random;
import java.util.Scanner;

public class array {

	public static void main(String[] args) {
		Random ra = new Random();
		Scanner sc = new Scanner(System.in);
		System.out.print("行数入力");
		int row = ra.nextInt(10)+1;
		System.out.println(row);
		//int row = sc.nextInt();
		System.out.print("列数入力");
		int col = ra.nextInt(10)+1;
		System.out.println(col);
		//int col = sc.nextInt();

		int[][] base = new int[row][col];
		int num = 1;

		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				base[i][j] = num;
				num++;
			}
		}
		outPut(base);

		int[][] deg1 = degRota(base);
		outPut(deg1);

		int[][] deg2 = degRota(deg1);
		outPut(deg2);

		int[][] deg3 = degRota(deg2);
		outPut(deg3);

		int[][] deg4 = reverce(deg3);
		outPut(deg4);

		int[][] deg5 = reverce(deg4);
		outPut(deg5);

		int[][] deg6 = reverce(deg5);
		outPut(deg6);
	}

	//努力課題
	//・メソッドの形にして、呼び出すたびに90度回転するようにする
	//・配列が3×3、4×4でも動くようにする
	//・表示するだけでなく、倒した

	public static int[][] degRota(int[][] array) {
		int[][] ret = new int[array[0].length][array.length];
		
		for(int i = 0; i < ret.length; i++) {
			//int rota = row-1;
			for(int j = 0; j < ret[0].length; j++) {
				ret[i][ret[0].length-1-j] = array[j][i];
				//rota--;
			}
		}

		return ret;
	}

	public static int[][] reverce(int[][] array) {
		int[][] ret = new int[array[0].length][array.length];

		//int rota = col-1;
		for(int i = 0; i < ret.length; i++) {
			for(int j = 0; j < ret[0].length; j++) {
				ret[i][j] = array[j][ret.length-1-i];
			}
			//rota--;
		}

		return ret;
	}

	public static void outPut(int[][] array) {
		for(int[] a: array) {
			for(int num: a) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
