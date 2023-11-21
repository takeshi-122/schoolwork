package Stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadCount {
	
	public static void main(String[] args) throws IOException {
		//FileReader fr = new FileReader("input.txt");
		BufferedReader br = null;//new BufferedReader(fr);
		List<String> list = new ArrayList<>();
		//int i = 0;
		//char c = 0;
		//String s = null;
		
		try {
			br = new BufferedReader(new FileReader("input.txt"));
			String s = "";
			Map<String, Integer> map = new HashMap();
			
			while((s = br.readLine()) != null) {
				//空白を基準に文字列を分割
				String[] str = s.split(" ");
				for(String a: str) {
					//System.out.println(a);
					a = a.toLowerCase();
					
					if(!map.containsKey(a)) {
						map.put(a, 1);
					} else {
						map.replace(a, map.get(a)+1);
					}
				}
				//文字列を大小気にしないようにする
				//compareToIgnoreCase(str[]);
				
				//文字列が使われているかチェック
				
			}
			for(Map.Entry<String, Integer> ent: map.entrySet()) {
				System.out.println(ent.getKey() + ":" + ent.getValue());
			}
		} catch(Exception e) {
			System.out.println("読み込みに失敗しました：" + e.getMessage());
		} finally {
			try {
				br.close();
			} catch(Exception e) {

			}
		}
		//int i = fr.read();
		/*do {
			c = (char)fr.read();
			//System.out.print(i);
			//System.out.println(c);
			if(c == '.' || c == ' ' || c == '!') {
				list.add(s);
				//System.out.println(list.get(i));
				//i++;
				System.out.println(s);
				s = null;
				continue;
			}
			
			if(s == null) {
				s = String.valueOf(c);
			}else {
				//s = (String)c;
				s += c;
			}
			
		}while(c != '!');

		Map<String, Integer> map = new HashMap<>();

		int cnt = 1;

		for(int j = 0; j < list.size(); j++) {
			s = list.get(j);
			if(map.get(s) == null) {
				map.put(s,cnt);
			}else if(map.containsKey(s)) {
				int num = map.get(s) + 1;
				map.replace(s, num);
			}
		}
		
		for(Map.Entry<String, Integer> ent: map.entrySet()) {
			System.out.println(ent.getKey() + ":" + ent.getValue());
		}*/

	}

}
