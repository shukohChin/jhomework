package ex1.ex1_15;

public class SimpleLookup implements NewLookup {
	private String[] names;

	public void setNames(String[] names){
		this.names = names;
	}

	public Object find(String name) {
		// TODO 自動生成されたメソッド・スタブ
		for(int i = 0; i < names.length; i++) {
			if(names[i].equals(name))
				return name;
		}
		return null;
	}
	public void add(Object obj) {
	// TODO 自動生成されたメソッド・スタブ

	}
	public void remove(String obj) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
