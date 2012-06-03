package gui2;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PropertyDialog extends Dialog implements ActionListener, ItemListener{

//	private static PropertyDialog propertyDialog = new PropertyDialog();

	Transfer transfer = new Transfer();

	Choice fontName = new Choice();
	Choice fontSize = new Choice();
	Choice charColor = new Choice();
	Choice bgColor = new Choice();

	Label fNameLabel = new Label("フォント:");
	Label fSizeLabel = new Label("フォントサイズ:");
	Label cColorLabel = new Label("文字色:");
	Label bColorLabel = new Label("背景色:");

	Button b1 = new Button("   OK   ");

	String[] fontName_item = {"arial", "Times New Roman", "Dialog", "MonoSpaced", "SansSerif", "Serif"};
	String[] fontSize_item = {"10", "20", "30", "40", "50", "60", "70", "80", "90", "100"};
	String[] color_item = {"Black", "Blue", "Cyan", "Gray", "Green", "Yellow", "Pink", "Red", "White"};
	int item_idx = 0;
	Color[] colors = {Color.BLACK, Color.blue,Color.cyan,Color.gray,Color.green,Color.yellow,Color.pink,Color.red,Color.white};

	public PropertyDialog(Frame owner) {
		super(owner);
		setModal(true);
		Panel panel = new Panel();
		GridBagLayout layout = new GridBagLayout();
		panel.setLayout(layout);
		add(panel);

		setChoices();

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weighty = 0.5d;
		gbc.anchor = GridBagConstraints.SOUTHWEST;
		layout.setConstraints(fNameLabel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weighty = 0.5d;
		gbc.anchor = GridBagConstraints.SOUTHWEST;
		layout.setConstraints(fontName, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.SOUTHWEST;
		layout.setConstraints(fSizeLabel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.SOUTHWEST;
		layout.setConstraints(fontSize, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.SOUTHWEST;
		layout.setConstraints(cColorLabel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.SOUTHWEST;
		layout.setConstraints(charColor, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.SOUTHWEST;
		layout.setConstraints(bColorLabel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.SOUTHWEST;
		layout.setConstraints(bgColor, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		gbc.weighty = 1.5d;
		gbc.anchor = GridBagConstraints.CENTER;
		layout.setConstraints(b1, gbc);

		panel.add(fNameLabel);
		panel.add(fontName);
		panel.add(fSizeLabel);
		panel.add(fontSize);
		panel.add(cColorLabel);
		panel.add(charColor);
		panel.add(bColorLabel);
		panel.add(bgColor);


		b1.addActionListener(this);
		panel.add(b1);
		setTitle("プロパティダイアログ");
		setSize(260, 220);
		setResizable(false);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}

	private void setChoices(){
		//add fontName
		for(int i = 0; i < fontName_item.length; i++){
			fontName.add(fontName_item[i]);
		}
		fontName.addItemListener(this);

		//add fontSize
		for(int i = 0; i < fontSize_item.length; i++){
			fontSize.add(fontSize_item[i]);
		}
		fontSize.addItemListener(this);

		//add colors
		for(int i = 0; i < color_item.length; i++){
			charColor.add(color_item[i]);
		}
		fontName.addItemListener(this);

		for(int i = 0; i < color_item.length; i++){
			bgColor.add(color_item[i]);
		}
		fontName.addItemListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		Object obj = e.getSource();
		if(obj == b1){
			transfer.setFont(new Font(fontName.getSelectedItem(), Font.BOLD, Integer.parseInt(fontSize.getSelectedItem())));
			transfer.setCharColor(colors[charColor.getSelectedIndex()]);
			transfer.setBgColor(colors[bgColor.getSelectedIndex()]);
			transfer.setWidthAndHeight(Integer.parseInt(fontSize.getSelectedItem()));
		}
		dispose();
	}

	public void itemStateChanged(ItemEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		Object obj = e.getItemSelectable();
		if(obj == fontName || obj == fontSize || obj == charColor || obj == bgColor){
			setFont(new Font(fontName.getSelectedItem(), Font.PLAIN, 13));
		}
	}

}
