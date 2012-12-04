package gui2_3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import com.sun.awt.AWTUtilities;

public class PropertyMenu extends JPopupMenu {

	DrawPanel owner;
	Transfer transfer = new Transfer();

	JMenu fontName = new JMenu("フォント");
	JMenu fontSize = new JMenu("フォントサイズ");
	JMenu charColor = new JMenu("文字色");
	JMenu bgColor = new JMenu("背景色");
	JMenuItem rarefact = new JMenuItem("半透明");
	JMenuItem exit = new JMenuItem("終了");

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
		this.add(rarefact);
		this.add(exit);
	}

	private void setMenus(){
		//add fontName
		for(int i = 0; i < fontName_item.length; i++){
			final JMenuItem item = new JMenuItem(fontName_item[i]);
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
			final JMenuItem item = new JMenuItem(fontSize_item[i]);
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
			final JMenuItem item = new JMenuItem(color_item[i]);
			charColor.add(item);
			item.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// TODO 自動生成されたメソッド・スタブ
					owner.setCharColor(toColor(e.getActionCommand()));
				}
			});
		}

		for(int i = 0; i < color_item.length; i++){
			final JMenuItem item = new JMenuItem(color_item[i]);
			bgColor.add(item);
			item.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// TODO 自動生成されたメソッド・スタブ
					Color bgColor = toColor(e.getActionCommand());
					owner.owner.setBackground(bgColor);
					transfer.setBgColor(bgColor);
				}
			});
		}

		rarefact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO 自動生成されたメソッド・スタブ
				AWTUtilities.setWindowOpacity(owner.owner, 0.6f);
			}
		});

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

}
