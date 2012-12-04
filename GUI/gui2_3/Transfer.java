package gui2_3;

import java.awt.Color;
import java.awt.Font;

public class Transfer {
	private String fontName;
	private int fontSize;

	private int height;
	private int width;

	private Color bgColor;

	public Transfer() {
		this.fontName = "arial";
		this.fontSize = 50;
		this.height = 50;
		this.width = 200;
	}

	public String getFont() {
		return fontName;
	}
	public void setFont(String font) {
		this.fontName = font;
	}
	public int getFontSize() {
		return fontSize;
	}
	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public void setHeight(int fontSize) {
		this.height = fontSize;
	}

	public void setWidth(){
		this.width = (int) (this.height * 4.7);
	}

	public int getWidth() {
		return this.width;
	}
	public int getHeight() {
		return this.height;
	}

	public Color getBgColor() {
		return this.bgColor;
	}

	public void setBgColor(Color bgColor) {
		this.bgColor = bgColor;
	}
}
