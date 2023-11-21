package encrypt;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class Main {

	public static void main(String[] args) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException{
		//文字ストリーム
		String msg = "にゃんこ大戦争";

		Reader r = new StringReader(msg);
		//System.out.println((char)r.read());
		//System.out.println((char)r.read());
		int i = r.read();
		while(i > 0) {
			System.out.print((char)i);
			i = r.read();
		}
		System.out.println();

		//バイトストリーム
		ByteArrayOutputStream bs = new ByteArrayOutputStream();
		bs.write(65);
		bs.write(66);

		//書き込んだ内容を取り出す
		byte[] data = bs.toByteArray();

		for(byte b : data) {
			System.out.println((char)b);
		}

		//ファイル書き込み用ストリーム
		FileOutputStream fo = new FileOutputStream("data.dat");
		//暗号化方法(インスタンス生成しないで呼び出す）
		Cipher c = Cipher.getInstance("DES");
		//鍵生成クラスのインスタンス呼び出し
		KeyGenerator kg = KeyGenerator.getInstance("DES");
		//鍵生成用クラスの初期化（.init)引数（暗号化のビット数）
		kg.init(56);//乱数を使用してを生成
		//秘密鍵の生成
		SecretKey sk = kg.generateKey();
		//暗号化クラスの初期化
		//ENCRYPT＿MODE：暗号化モード
		//第二引数：秘密鍵
		c.init(Cipher.ENCRYPT_MODE, sk);
		//暗号化処理
		CipherOutputStream co = new CipherOutputStream(fo,c);
		//書き込み処理
		fo.write(65);

		fo.close();
	}

}
