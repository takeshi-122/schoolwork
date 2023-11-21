package case9_10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.*;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		/*System.out.println("1円以上のアイテム一覧表を表示します");
		ArrayList<Item> items = ItemsDAO.findByMinimumPrice(1);
		for(Item item : items) {
			System.out.printf('%10s%4d%4d', item.getName(), item.getPrice(), item.getWeight());*/

		try {
			Class.forName("org.h2.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection con = null;
		int r = 1;
		ResultSet rs;
		try {
			con = DriverManager.getConnection("jdbc:h2:D:\\iijimatakeshi\\test", "sa", "1");
			PreparedStatement ps;
			boolean b = true;
			while(b) {
				switch(menuSelect()) {
				case 1:
					ps = con.prepareStatement("INSERT INTO ITEMS VALUES(?, ?, ?)");
					System.out.println("アイテムの名称を入力してください");ps.setString(1, sc.next());
					System.out.println("アイテムの値段を入力してください");ps.setInt(2, sc.nextInt());
					System.out.println("アイテムの重さを入力してください");ps.setInt(3, sc.nextInt());
					r = ps.executeUpdate();
					ps.close();continue;
				case 2:
					ps = con.prepareStatement("SELECT * FROM ITEMS");
					rs = ps.executeQuery();
					while(rs.next()) {
						System.out.println("NAME:" + rs.getString(1) + " PRICE:" + rs.getInt(2) + " WEIGHT:" + rs.getInt(3));
					}
					ps.close();continue;
				case 3:
					System.out.println("検索するアイテムの名称を入力してください");
					ps = con.prepareStatement("SELECT * FROM ITEMS WHERE NAME=?");
					//String s = sc.next();
					ps.setString(1, sc.next());
					rs = ps.executeQuery();
					System.out.println("NAME:" + rs.getString(1) + " PRICE:" + rs.getInt(2) + " WEIGHT:" + rs.getInt(3));
					ps.close();continue;
				case 4:
					System.out.println("処理を終了します");
					break;
				default:
					System.out.println("選択した数字はメニューにありません");
					continue;
				}
				b = false;
			}
			if(r != 1){
				System.out.println("失敗");
			}
			/*
			ps = con.prepareStatement("SELECT * FROM ITEMS");
			rs = ps.executeQuery();
			int num = 1;
			while(rs.next()) {
				String name = rs.getString(1);
				int price = rs.getInt(2);
				int weight = rs.getInt(3);

				Item item = new Item(name, price, weight);

				num++;
			}
			ps.close();*/

			//ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static int menuSelect() {
		int r;
		System.out.println("操作メニューを数字で選択してください");
		System.out.println("１：データの挿入\n２：データの一覧表示\n３：データ検索\n４：処理終了");
		r = sc.nextInt();
		return r;
	}

}
