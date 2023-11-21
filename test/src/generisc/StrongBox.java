package generisc;

import java.util.Optional;

public class StrongBox<E> {
	private E date;
	private KeyType keyType;
	private int count;
	private int lockNum;

	public int getCount() { return this.count; }

	public StrongBox(KeyType keyType) {
		this.keyType = keyType;
		/*if(KeyType.PADLOCK == keyType) {
			lockNum = 5;
		}else if(KeyType.BUTTON == keyType) {
			lockNum = 10;
		}else if(KeyType.DIAL == keyType) {
			lockNum = 15;
		}else {
			lockNum = 20;
		}*/
	}

	public void put(E o) {
		this.date = o;
	}

	public Optional<E> get() {
		E r;
		this.count++;
		switch(keyType) {
		case PADLOCK:
			r = checkCount(5);
			break;
		case BUTTON:
			r = checkCount(10);
			break;
		case DIAL:
			r = checkCount(15);
			break;
		case FINGER:
			r = checkCount(20);
			break;
		default:
			r = null;
			break;

		}
		/*System.out.println(count);
		if(lockNum == count) {
			return Optional.ofNullable(this.date);
		}
		return Optional.ofNullable(null);*/
		return Optional.ofNullable(r);
	}

	public E checkCount(int needNum) {
		E r;

		if(this.count != needNum) {
			r = null;
		}else
			r = this.date;

		return r;
	}

	public Optional<E> orElse(Optional<E> string) {
		// TODO 自動生成されたメソッド・スタブ
		if(this.get() == null) {
			return string;
		}
		return this.get();
	}


}
