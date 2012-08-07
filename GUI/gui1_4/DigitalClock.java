package gui1_4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.prefs.Preferences;

import javax.swing.Timer;

@SuppressWarnings("serial")
public class DigitalClock extends Frame implements ActionListener {

	/**
	 * @param args
	 */
	//記憶用パラメータ
	Preferences prefs = Preferences.userNodeForPackage(this.getClass());

	final static int C00 = 1000;

	Transfer transfer = new Transfer();
	DrawPanel panel = new DrawPanel();
	PropertyDialog propertyDlog;
	MenuItem menuProperty, menuExit;

	public static void main(String[] args) {
		DigitalClock dc = new DigitalClock();
		dc.setVisible(true);
	}

	//コンストラクタ
	public DigitalClock(){
		//記憶する情報
		int oldX = Integer.parseInt(prefs.get("chinX", "0"));
		int oldY = Integer.parseInt(prefs.get("chinY", "0"));
		String oldFontName = prefs.get("chinFontName", "arial");
		int oldFontSize = Integer.parseInt(prefs.get("chinFontSize", "50"));
		String oldCharColor = prefs.get("chinCharColor", "Black");
		System.out.println(oldCharColor);
		String oldBgColor = prefs.get("chinBgColor", "White");

		transfer.setFont(new Font(oldFontName, Font.BOLD, oldFontSize));
		transfer.setFontSize(oldFontSize);
		transfer.setCharColor(transfer.toColor(oldCharColor));
		transfer.setBgColor(transfer.toColor(oldBgColor));
		transfer.setWidthAndHeight(oldFontSize);

		propertyDlog = new PropertyDialog(this, transfer);

		this.setLocation(oldX, oldY);

//		setPreferredSize(new Dimension(200, 120));
		setResizable(false);


		MenuBar menuBar = new MenuBar();
		setMenuBar(menuBar);

		Menu menuFile = new Menu("メニュー");
		menuFile.addActionListener(this);
		menuBar.add(menuFile);

		menuProperty = new MenuItem("プロパティ", new MenuShortcut('O'));
		menuProperty.addActionListener(this);
		menuFile.add(menuProperty);

		//[----]
		menuFile.addSeparator();
		//[EXIT]
		menuExit = new MenuItem("Exit");
		menuExit.addActionListener(this);
		menuFile.add(menuExit);

		panel.setPreferredSize(new Dimension(transfer.getWidth(), transfer.getHeight()));
		add(panel);
		panel.setFont(new Font(oldFontName, Font.BOLD, oldFontSize));
		panel.setCharColor(toColor(oldCharColor));
		panel.setBackground(toColor(oldBgColor));
		new Timer(C00, panel).start();

		pack();

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				prefs.put("chinX", String.valueOf(getX()));
				prefs.put("chinY", String.valueOf(getY()));
				System.exit(0);
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		Object obj = e.getSource();

		if(obj == menuProperty){
			propertyDlog.setVisible(true);

			transfer = propertyDlog.transfer;
			prefs.put("chinFontName", transfer.getFont().getName());
			prefs.put("chinFontSize", String.valueOf(transfer.getFontSize()));
			prefs.put("chinCharColor", transfer.colorToStr(transfer.getCharColor()));
			prefs.put("chinBgColor", transfer.colorToStr(transfer.getBgColor()));

			panel.setPreferredSize(new Dimension(transfer.getWidth(), transfer.getHeight()));
			panel.setFont(transfer.getFont());
			panel.setCharColor(transfer.getCharColor());
			panel.setBackground(transfer.getBgColor());
			panel.repaint();
			pack();
		}else if(obj == menuExit){
			prefs.put("chinX", String.valueOf(getX()));
			prefs.put("chinY", String.valueOf(getY()));
			System.exit(0);
		}
	}

	public Color toColor(String str) {
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
