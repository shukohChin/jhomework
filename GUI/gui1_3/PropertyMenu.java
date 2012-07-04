package gui1_3;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PropertyMenu extends PopupMenu {

	DrawPanel owner;
	Transfer transfer = new Transfer();

	Menu fontName = new Menu("フォント");
	Menu fontSize = new Menu("フォントサイズ");
	Menu charColor = new Menu("文字色");
	Menu bgColor = new Menu("背景色");
	MenuItem exit = new MenuItem("終了");

	String[] fontName_item = {"arial", "Century", "Dialog", "MonoSpaced", "SansSerif", "Serif", "Times New Roman"};
	String[] fontSize_item = {"30", "40", "50", "60", "70", "80", "90", "100", "110", "120"};
	String[] color_item = {"Black", "Blue", "Cyan", "Gray", "Green", "Yellow", "Pink", "Red", "White"};

	public PropertyMenu(DrawPanel owner) {
		this.owner = owner;
		setMenus();
		this.add(fontName);
		this.add(fontSize);
		this.add(charColor);
		this.add(bgColor);
		this.add(exit);
	}

	private void setMenus(){
		//add fontName
		for(int i = 0; i < fontName_item.length; i++){
			final MenuItem item = new MenuItem(fontName_item[i]);
			fontName.add(item);
			item.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// TODO 自動生成されたメソッド・スタブ
					String fName = e.getActionCommand();
					transfer.setFont(fName);
					owner.setFont(new Font(transfer.getFont(), Font.PLAIN, transfer.getFontSize()));
				}
			});
		}

		//add fontSize
		for(int i = 0; i < fontSize_item.length; i++){
			final MenuItem item = new MenuItem(fontSize_item[i]);
			fontSize.add(item);
			item.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// TODO 自動生成されたメソッド・スタブ
					int fontSize = Integer.parseInt(e.getActionCommand());
					transfer.setFontSize(fontSize);
					transfer.setHeight(fontSize);
					transfer.setWidth();
					owner.setPreferredSize(new Dimension(transfer.getWidth(), transfer.getHeight()));
					owner.setFont(new Font(transfer.getFont(), Font.PLAIN, transfer.getFontSize()));
					owner.owner.pack();
				}
			});
		}

		//add colors
		for(int i = 0; i < color_item.length; i++){
			final MenuItem item = new MenuItem(color_item[i]);
			charColor.add(item);
			item.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// TODO 自動生成されたメソッド・スタブ
					owner.setCharColor(toColor(e.getActionCommand()));
				}
			});
		}

		for(int i = 0; i < color_item.length; i++){
			final MenuItem item = new MenuItem(color_item[i]);
			bgColor.add(item);
			item.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// TODO 自動生成されたメソッド・スタブ
					owner.setBackground(toColor(e.getActionCommand()));
				}
			});
		}

		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO 自動生成されたメソッド・スタブ
				System.exit(0);
			}
		});

	}


	private Color toColor(String str) {

		if(str.equals("Black")) {

			return Color.black;

		} else if(str.equals("Blue")) {

			return Color.blue;

		} else if(str.equals("Cyan")) {

			return Color.cyan;

		} else if(str.equals("Gray")) {

			return Color.gray;

		} else if(str.equals("Green")) {

			return Color.green;

		} else if(str.equals("Yellow")) {

			return Color.yellow;

		} else if(str.equals("Pink")) {

			return Color.pink;

		} else if(str.equals("Red")) {

			return Color.red;

		} else if(str.equals("White")) {

			return Color.white;

		} else {
			return null;
		}


	}

//	public void actionPerformed(ActionEvent e) {
//
//		if(e.getActionCommand().equals())
//
//		// TODO 自動生成されたメソッド・スタブ
//		transfer.setFont(new Font(fontName.getSelectedItem(), Font.BOLD, Integer.parseInt(fontSize.getSelectedItem())));
//		transfer.setCharColor(colors[charColor.getSelectedIndex()]);
//		transfer.setBgColor(colors[bgColor.getSelectedIndex()]);
//		transfer.setWidthAndHeight(Integer.parseInt(fontSize.getSelectedItem()));
//		}
//		dispose();
//	}
}
