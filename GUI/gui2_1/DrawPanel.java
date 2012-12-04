package gui2_1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JPanel;

public class DrawPanel extends JPanel implements ActionListener{
	private Font font;
	private Color charColor, bgColor;
	private String time;

	Image imgBuf;
	Graphics gBuf;

	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		repaint();
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);

		time = String.format("%1$tH:%1$tM:%1$tS", new Date());

		imgBuf = createImage(getWidth(), getHeight());
		gBuf = imgBuf.getGraphics();

		gBuf.setFont(font);
		gBuf.setColor(charColor);

        FontMetrics L01 = gBuf.getFontMetrics();

        gBuf.drawString(time, (getWidth() - L01.stringWidth(time)) / 2,
                (getHeight() + L01.getAscent() - L01.getDescent()) / 2);

        g.drawImage(imgBuf, 0, 0, this);
	}

}