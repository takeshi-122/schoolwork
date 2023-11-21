package Stream;

import java.util.Objects;

public class Hero implements Comparable<Hero>,Cloneable{
	private String name;
	private int hp;

	public Hero(String name) {
		this.name = name;
		this.hp = 10;
	}

	public String getName() { return this.name; }
	public void setName(String name) { this.name = name; }
	public int getHp() { return this.hp; }
	public void setHp(int hp) { this.hp = hp; }

	public boolean equals(Object o) {
		//早期リターン
		if(o == this) return true;//等値であれば等価
		if(o == null) return false;
		Hero h = (Hero) o;
		if(o instanceof Hero) {
			if(this.name.equals(h.name)){
				return true;
			}
		}

		/*if(this.name.trim().equals(h.name.trim())) {
			return true;
		}*/
		return false;
	}

	public int hashCode() {
		return Objects.hash(this.name);
	}

	public int compareTo(Hero h) {
		if(this.hp < h.getHp()) {
			return -1;
		}else if(this.hp > h.getHp()) {
			return 1;
		}else
		return 0;
	}

	public Hero clone() {
		Hero h = new Hero("");

		h.hp = this.hp;
		h.name = this.name;

		return h;
	}

	public String toString() {
		return "勇者の名前は：" + this.name;
	}

}
