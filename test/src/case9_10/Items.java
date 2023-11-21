package case9_10;

import java.sql.DriverManager;
import java.sql.*;

public class Items {

	public static void main(String[] args) {
		try {
			Class.forName("org.h2.Driver");
		} catch(Exception e) {
			throw new IllegalStateException("ロード失敗");
		}

		Connection con = null;

		String[] items = {"やくそう", "どくけしそう", "ばんのうやく", "ふっかつやく"};
		int[] prices = {5, 7, 20, 50};
		int[] weights = {2, 2, 5, 10};

		try {
			con = DriverManager.getConnection("jdbc:h2:D:\\iijimatakeshi\\test", "sa", "1");
			/*PreparedStatement ps = con.prepareStatement("DROP TABLE IF EXISTS ITEMS");ps.executeUpdate();
			ps = con.prepareStatement("CREATE TABLE ITEMS(NAME VARCHAR(255) PRIMARY KEY, PRICE INT, WEIGHT INT)");*/
			PreparedStatement ps = con.prepareStatement("DELETE FROM ITEMS");
			int r = ps.executeUpdate();

			if(r != 0) {
				System.out.println("成功");
			} else {
				System.out.println("失敗");
			}

			for(int i = 0; i < items.length; i++){
			ps = con.prepareStatement("INSERT INTO ITEMS VALUES(?, ?, ?);");

			ps.setString(1, items[i]);
			ps.setInt(2, prices[i]);
			ps.setInt(3, weights[i]);

			r = ps.executeUpdate();
			}

			if(r != 0) {
				System.out.println("成功");
			} else {
				System.out.println("失敗");
			}

			ps.close();
		} catch(Exception e) {
			e.getStackTrace();
		} finally {
			try {
				if(con != null) {
					con.close();
				}
			}catch(Exception e) {
				e.getStackTrace();
			}
		}
	}
}
