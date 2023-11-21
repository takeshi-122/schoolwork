package generisc;

public class S_Main {

	public static void main(String[] args) {
		StrongBox<String> sb = new StrongBox<>(KeyType.FINGER);

		sb.put("開いた");

		for(int i = 0; i < 20; i++) {
			//System.out.println(sb.getCount());
			//sb.get();
			System.out.println(sb.get().orElse("開かない"));
		}


		//System.out.println(sb.get().orElse("開かない"));

	}

}
