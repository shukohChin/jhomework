package gui1_3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Date;

public class DrawPanel extends Panel implements ActionListener, MouseListener, MouseMotionListener {
	private Font font;
	private int fontSize;
	private Color charColor, bgColor;
	private MouseEvent start;
	String time = String.format("%1$tH:%1$tM:%1$tS", new Date());
	FontMetrics L01;

	DigitalClock owner;

	PropertyMenu ppm = new PropertyMenu(this);
	Transfer transfer = new Transfer();

	Image imgBuf;
	Graphics gBuf;

	DrawPanel(DigitalClock owner) {
		this.owner = owner;
		add(ppm);
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		repaint();
	}

	public void paint(Graphics g){
		super.paint(g);

		time = String.format("%1$tH:%1$tM:%1$tS", new Date());

		imgBuf = createImage(getWidth(), getHeight());
		gBuf = imgBuf.getGraphics();

		gBuf.setFont(font);
		gBuf.setColor(charColor);

        L01 = gBuf.getFontMetrics();

        gBuf.drawString(time, (getWidth() - L01.stringWidth(time)) / 2,
                (getHeight() + L01.getAscent() - L01.getDescent()) / 2);

        g.drawImage(imgBuf, 0, 0, this);
	}

	public void update(Graphics g) {
		paint(g);
	}

	public void setFont(Font font){
		this.font = font;
	}

	public void setCharColor(Color color){
		this.charColor = color;
	}

	public void setBgColor(Color color){
		this.bgColor = color;
	}

	public void setFontSize(int size) {
		this.fontSize = size;
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
		start = e;
	}

	public void mouseReleased(MouseEvent e) {
		if (e.isPopupTrigger())
			ppm.show(e.getComponent(), e.getX(), e.getY());
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}


	public void mouseDragged(MouseEvent e) {

		owner.setLocation((int)e.getLocationOnScreen().getX() - start.getX(),
				(int)e.getLocationOnScreen().getY() - start.getY());

	}

	public void mouseMoved(MouseEvent e) {
	}
}
