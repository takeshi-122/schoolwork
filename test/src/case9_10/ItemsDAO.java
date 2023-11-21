package case9_10;

import java.sql.*;
import java.util.ArrayList;

public class ItemsDAO {
	//引数以下の価格のItemを返すメソッド
	public static ArrayList<Item> findByMinimumPrice(int i) {
		try {
			//ドライバのロード
			Class.forName("org.h2.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:h2:D:\\\\iijimatakeshi\\\\test\", \"sa\", \"1");
			PreparedStatement ps = con.prepareStatement("SELECT * FROM ITEMS WHERE PRICE >= ?");
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			//Item格納するArrayListwo作成
			ArrayList<Item> items = new ArrayList<>();
			while(rs.next()) { //結果表の全行を準備
				Item item = new Item();
				item.setName(rs.getString("NAME"));
				item.setPrice(rs.getInt("PRICE"));
				item.setWeight(rs.getInt("WEIGHT"));
				items.add(item);
			}
			rs.close();
			ps.close();
			return items;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
