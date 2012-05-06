package ex6.ex6_5;

import java.awt.Color;

/** 共通の処理ができれば、定数固有のメソッドを使用しない */
enum Signal {
	RED {
		Color getColor() { return Color.RED;}
	},
	GREEN {
		Color getColor() { return Color.GREEN;}
	},
	YELLOW {
		Color getColor() { return Color.YELLOW;}
	};

	abstract Color getColor();
}
