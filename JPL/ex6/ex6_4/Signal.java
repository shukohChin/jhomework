package ex6.ex6_4;

import java.awt.Color;

enum Signal {
	RED(Color.RED),
	GREEN(Color.GREEN),
	YELLOW(Color.YELLOW);

	Color color;
	Signal(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
}
