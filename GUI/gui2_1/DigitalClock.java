package gui2_1;

import gui1_2.DrawPanel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.Timer;

public class DigitalClock extends JFrame implements ActionListener {
	final static int C00 = 1000;
	DrawPanel panel = new DrawPanel();

	public DigitalClock(){
		panel.setPreferredSize(new Dimension(200, 50));
		add(panel);
		panel.setFont(new Font("arial", Font.BOLD, 50));
		new Timer(C00, panel).start();

		pack();

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		repaint();
	}


	public static void main(String[] args) {
		DigitalClock dc = new DigitalClock();
		dc.setVisible(true);
	}

}
