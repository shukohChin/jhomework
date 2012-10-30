package gui2_2;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.prefs.Preferences;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.Timer;

public class DigitalClock extends JFrame implements ActionListener {
	//記憶用パラメータ
	Preferences prefs = Preferences.userNodeForPackage(this.getClass());

	final static int C00 = 1000;

	Transfer transfer = new Transfer();
	DrawPanel panel = new DrawPanel();
	PropertyDialog propertyDlog;
	JMenuItem menuProperty;

	JMenuItem menuExit;

	public DigitalClock(){
		//記憶する情報
		int oldX = Integer.parseInt(prefs.get("chinX2", "0"));
		int oldY = Integer.parseInt(prefs.get("chinY2", "0"));
		String oldFontName = prefs.get("chinFontName2", "arial");
		int oldFontSize = Integer.parseInt(prefs.get("chinFontSize2", "50"));
		String oldCharColor = prefs.get("chinCharColor2", "Black");
		String oldBgColor = prefs.get("chinBgColor2", "White");
		System.out.println(oldBgColor);

		transfer.setFont(new Font(oldFontName, Font.BOLD, oldFontSize));
		transfer.setFontSize(oldFontSize);
		transfer.setCharColor(transfer.toColor(oldCharColor));
		transfer.setBgColor(transfer.toColor(oldBgColor));
		transfer.setWidthAndHeight(oldFontSize);

		propertyDlog = new PropertyDialog(this, transfer);

		this.setLocation(oldX, oldY);

		setResizable(false);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuFile = new JMenu("メニュー");
		menuFile.addActionListener(this);
		menuBar.add(menuFile);

		menuProperty = new JMenuItem("プロパティ");
		menuProperty.addActionListener(this);
		menuFile.add(menuProperty);

		//[----]
		menuFile.addSeparator();
		//[EXIT]
		menuExit = new JMenuItem("Exit");
		menuExit.addActionListener(this);
		menuFile.add(menuExit);

		panel.setPreferredSize(new Dimension(transfer.getWidth(), transfer.getHeight()));
		add(panel);
		panel.setFont(new Font(oldFontName, Font.BOLD, oldFontSize));
		panel.setCharColor(toColor(oldCharColor));
		setBackground(toColor(oldBgColor));
		new Timer(C00, panel).start();

		pack();

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				prefs.put("chinX2", String.valueOf(getX()));
				prefs.put("chinY2", String.valueOf(getY()));
				System.exit(0);
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
			prefs.put("chinFontName2", transfer.getFont().getName());
			prefs.put("chinFontSize2", String.valueOf(transfer.getFontSize()));
			prefs.put("chinCharColor2", transfer.colorToStr(transfer.getCharColor()));
			prefs.put("chinBgColor2", transfer.colorToStr(transfer.getBgColor()));

			panel.setPreferredSize(new Dimension(transfer.getWidth(), transfer.getHeight()));
			panel.setFont(transfer.getFont());
			panel.setCharColor(transfer.getCharColor());
			setBackground(transfer.getBgColor());
			panel.repaint();
			pack();
		}else if(obj == menuExit){
			prefs.put("chinX2", String.valueOf(getX()));
			prefs.put("chinY2", String.valueOf(getY()));
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


	public static void main(String[] args) {
		DigitalClock dc = new DigitalClock();
		dc.setVisible(true);
	}

}
