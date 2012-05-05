package gui1;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import javax.swing.Timer;

@SuppressWarnings("serial")
public class DigitalClock extends Frame implements ActionListener {

	/**
	 * @param args
	 */

	final static int C00 = 1000;

	public static void main(String[] args) {

		DigitalClock dc = new DigitalClock();

		dc.setVisible(true);
	}


	public DigitalClock(){

		setPreferredSize(new Dimension(640, 480));
		pack();

		new Timer(C00, this).start();

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void paint(Graphics g){
		super.paint(g);



		String time = String.format("%1$tI:%1$tM:%1$tS", new Date());

        FontMetrics L01 = g.getFontMetrics();

        g.drawString(time, (getWidth() - L01.stringWidth(time)) / 2,
                (getHeight() + L01.getAscent() - L01.getDescent()) / 2);
	}


	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		repaint();
	}


}
