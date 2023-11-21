package dataBace;

import java.sql.*;

public class Main {

	public static void main(String[] args) {
		//事前準備（ドライバーの有効化）
		try {
			Class.forName("org.h2.Driver");
		} catch(Exception e) {
			throw new IllegalStateException("ロード失敗");
		}

		Connection con = null;

		try {
			//データベースの接続
			con = DriverManager.getConnection("jdbc:h2:D:\\iijimatakeshi\\test", "sa", "1");

			//データベース処理実装
			PreparedStatement ps = con.prepareStatement("DELETE FROM TEST");

			//更新処理実行
			int r = ps.executeUpdate();

			if(r != 0) {
				System.out.println("成功");
			} else {
				System.out.println("失敗");
			}

			int id = 1;
			int num = 1;
			int numW = 1;
			while(id <= 600) {
				if(id >=400 && id < 500) {
					ps = con.prepareStatement("INSERT INTO TEST VALUES(?, ?);");
					ps.setInt(1, id);
					ps.setString(2, "狼男" + numW);
					r = ps.executeUpdate();
					id++;numW++;
					continue;
				}
				for(int i = 0; i < 3; i++) {
					ps = con.prepareStatement("INSERT INTO TEST VALUES(?, ?);");
					switch(i) {
					case 0:
						ps.setInt(1, id);
						ps.setString(2, "スライム" + num);
						break;
					case 1:
						ps.setInt(1, id);
						ps.setString(2, "スケルトン" + num);
						break;
					case 2:
						ps.setInt(1, id);
						ps.setString(2, "ゾンビ" + num);
						break;
					}
					r = ps.executeUpdate();
					id++;
				}
				num++;
			}

			if(r != 0) {
				System.out.println("成功");
			} else {
				System.out.println("失敗");
			}

			/*for(int i = 400; i < 500; i++) {
				ps = con.prepareStatement("UPDATE TEST SET NAME=? WHERE ID=?;");
				ps.setInt(2, i);
				ps.setString(1, "狼男" + numW);
				numW++;r = ps.executeUpdate();
			}

			if(r != 0) {
				System.out.println("成功");
			} else {
				System.out.println("失敗");
			}*/
			
			//検索処理実装
			//指示をセット
			ps = con.prepareStatement("SELECT * FROM TEST WHERE ID <= 10");
			
			//結果受け取り
			ResultSet rs = ps.executeQuery();
			
			//次の行を参照※初期値は先頭
			while(rs.next()/*戻り値boolean*/){
			
			System.out.println("ID:" + rs.getInt(1) + " 名称:" + rs.getString(2));
			}
			
			ps.close();
			//データベース処理終了
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(con != null) {
					con.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

}
