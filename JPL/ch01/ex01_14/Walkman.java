package ch01.ex01_14;

public class Walkman {
	private Plug plug;

	public Plug getPlug() {
		return plug;
	}

	public void setPlug(Plug plug) {
		this.plug = plug;
	}

	public void play(){
		System.out.println("Listening");
	}
}
