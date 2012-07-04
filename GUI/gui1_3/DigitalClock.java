package gui1_3;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import javax.swing.Timer;

@SuppressWarnings("serial")
public class DigitalClock extends Window {

	/**
	 * @param args
	 */

	final static int C00 = 1000;

	DrawPanel panel = new DrawPanel(this);

	public static void main(String[] args) {
		DigitalClock dc = new DigitalClock("DigitalClock");
		dc.setVisible(true);
	}

	//コンストラクタ
	public DigitalClock(String title){
		super(new Frame());

		panel.setPreferredSize(new Dimension(235, 50));
		add(panel);
		panel.setFont(new Font("arial", Font.PLAIN, 50));
		new Timer(C00, panel).start();

		pack();

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

}
