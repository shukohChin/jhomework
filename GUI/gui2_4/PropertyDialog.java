package gui2_4;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

public class PropertyDialog extends JDialog implements ActionListener, ItemListener{

//	private static PropertyDialog propertyDialog = new PropertyDialog();
	Transfer transfer;

	JComboBox fontName = new JComboBox();
	JComboBox fontSize = new JComboBox();
	JComboBox charColor = new JComboBox();
	JComboBox bgColor = new JComboBox();

	JLabel fNameLabel = new JLabel("フォント:");
	JLabel fSizeLabel = new JLabel("フォントサイズ:");
	JLabel cColorLabel = new JLabel("文字色:");
	JLabel bColorLabel = new JLabel("背景色:");

	JButton b1 = new JButton("   OK   ");
	JButton cancel = new JButton(" Cancel ");

	String[] fontName_item = {"arial", "Times New Roman", "Dialog", "MonoSpaced", "SansSerif", "Serif"};
	String[] fontSize_item = {"10", "20", "30", "40", "50", "60", "70", "80", "90", "100"};
	String[] color_item = {"Black", "Blue", "Cyan", "Gray", "Green", "Yellow", "Pink", "Red", "White"};
	Icon[] icon_item = {new ImageIcon("resources/colors/Black.png"),
						new ImageIcon("resources/colors/Blue.png"),
						new ImageIcon("resources/colors/Cyan.png"),
						new ImageIcon("resources/colors/Gray.png"),
						new ImageIcon("resources/colors/Green.png"),
						new ImageIcon("resources/colors/Yellow.png"),
						new ImageIcon("resources/colors/Pink.png"),
						new ImageIcon("resources/colors/Red.png"),
						new ImageIcon("resources/colors/White.png")};
	int item_idx = 0;
	Color[] colors = {Color.BLACK, Color.blue,Color.cyan,Color.gray,Color.green,Color.yellow,Color.pink,Color.red,Color.white};

	public PropertyDialog(Frame owner, Transfer trans) {
		super(owner);
		this.transfer = trans;
		setModal(true);
		JPanel panel = new JPanel();
		GridBagLayout layout = new GridBagLayout();
		panel.setLayout(layout);
		add(panel);

		setChoices();

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.SOUTHEAST;
		layout.setConstraints(fNameLabel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.SOUTHWEST;
		layout.setConstraints(fontName, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.SOUTHEAST;
		layout.setConstraints(fSizeLabel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.SOUTHWEST;
		layout.setConstraints(fontSize, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.SOUTHEAST;
		layout.setConstraints(cColorLabel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.SOUTHWEST;
		layout.setConstraints(charColor, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.SOUTHEAST;
		layout.setConstraints(bColorLabel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.SOUTHWEST;
		layout.setConstraints(bgColor, gbc);

		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.SOUTHWEST;
		layout.setConstraints(b1, gbc);

		gbc.gridx = 2;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.SOUTHWEST;
		layout.setConstraints(cancel, gbc);

		panel.add(fNameLabel);
		fontName.setSelectedItem(transfer.getFont().getName());
		panel.add(fontName);
		panel.add(fSizeLabel);
		fontSize.setSelectedItem(String.valueOf(transfer.getFontSize()));
		panel.add(fontSize);
		panel.add(cColorLabel);

		System.out.println(transfer.colorToStr(transfer.getCharColor()));

		charColor.setSelectedItem(colorToEnum(transfer.getCharColor()));
		panel.add(charColor);
		panel.add(bColorLabel);
		bgColor.setSelectedItem(colorToEnum(transfer.getBgColor()));
		panel.add(bgColor);


		b1.addActionListener(this);
		cancel.addActionListener(this);
		panel.add(b1);
		panel.add(cancel);
		setTitle("プロパティダイアログ");
		setSize(280, 180);
		setResizable(false);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				fontName.setSelectedItem(transfer.getFont().getName());
				fontSize.setSelectedItem(String.valueOf(transfer.getFontSize()));
				charColor.setSelectedItem(colorToEnum(transfer.getCharColor()));
				bgColor.setSelectedItem(colorToEnum(transfer.getBgColor()));
			}
		});
	}

	private void setChoices(){
		//add fontName
		for(int i = 0; i < fontName_item.length; i++){
			fontName.addItem(fontName_item[i]);
		}
		fontName.addItemListener(this);

		//add fontSize
		for(int i = 0; i < fontSize_item.length; i++){
			fontSize.addItem(fontSize_item[i]);
		}
		fontSize.addItemListener(this);

		//add colors
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		MyCellRenderer renderer = new MyCellRenderer();
		for(ComboLabel c : ComboLabel.values()){
			model.addElement(c);
		}
		charColor.setModel(model);
	    charColor.setRenderer(renderer);
		charColor.addItemListener(this);

		DefaultComboBoxModel model2 = new DefaultComboBoxModel();
		MyCellRenderer renderer2 = new MyCellRenderer();
		for(ComboLabel c : ComboLabel.values()){
			model2.addElement(c);
		}
		bgColor.setModel(model2);
		bgColor.setRenderer(renderer2);
		bgColor.addItemListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		Object obj = e.getSource();
		if(obj == b1){
			transfer.setFont(new Font((String) fontName.getSelectedItem(), Font.BOLD, Integer.parseInt((String) fontSize.getSelectedItem())));
			transfer.setFontSize(Integer.parseInt((String) fontSize.getSelectedItem()));
			transfer.setCharColor(colors[charColor.getSelectedIndex()]);
			transfer.setBgColor(colors[bgColor.getSelectedIndex()]);
			transfer.setWidthAndHeight(Integer.parseInt((String) fontSize.getSelectedItem()));
			dispose();
		}else if(obj == cancel){
			dispose();
			fontName.setSelectedItem(transfer.getFont().getName());
			fontSize.setSelectedItem(String.valueOf(transfer.getFontSize()));
			charColor.setSelectedItem(colorToEnum(transfer.getCharColor()));
			bgColor.setSelectedItem(colorToEnum(transfer.getBgColor()));
		}
	}

	public void itemStateChanged(ItemEvent e) {
		// TODO 自動生成されたメソッド・スタブ
//		Object obj = e.getItemSelectable();
//		if(obj == fontName || obj == fontSize || obj == charColor || obj == bgColor){
//			setFont(new Font(fontName.getSelectedItem(), Font.PLAIN, 13));
//		}
	}

	enum ComboLabel{
		Black ("Black", new ImageIcon("resources/colors/Black.png")),
		Blue ("Blue", new ImageIcon("resources/colors/Blue.png")),
		Cyan ("Cyan", new ImageIcon("resources/colors/Cyan.png")),
		Gray ("Gray", new ImageIcon("resources/colors/Gray.png")),
		Green ("Green", new ImageIcon("resources/colors/Green.png")),
		Yellow ("Yellow", new ImageIcon("resources/colors/Yellow.png")),
		Pink ("Pink", new ImageIcon("resources/colors/Pink.png")),
		Red ("Red", new ImageIcon("resources/colors/Red.png")),
		White ("White", new ImageIcon("resources/colors/White.png"));

		private String text;
		private Icon icon;

		private ComboLabel(String text, Icon icon) {
			this.text = text;
			this.icon = icon;
		}

		public String getText() {
			return text;
		}

		public Icon getIcon() {
			return icon;
		}
	}

	public ComboLabel colorToEnum(Color color) {
		if(color == Color.BLACK) {
			return ComboLabel.Black;
		} else if(color == Color.BLUE) {
			return ComboLabel.Blue;
		} else if(color == Color.CYAN) {
			return ComboLabel.Cyan;
		} else if(color == Color.GRAY) {
			return ComboLabel.Gray;
		} else if(color == Color.GREEN) {
			return ComboLabel.Green;
		} else if(color == Color.YELLOW) {
			return ComboLabel.Yellow;
		} else if(color == Color.PINK) {
			return ComboLabel.Pink;
		} else if(color == Color.RED) {
			return ComboLabel.Red;
		} else if(color == Color.WHITE) {
			return ComboLabel.White;
		} else {
			return null;
		}
	}

	class MyCellRenderer extends JLabel implements ListCellRenderer{

		MyCellRenderer() {
			setOpaque(true);
		}

		public Component getListCellRendererComponent(JList list, Object value,
				int index, boolean isSelected, boolean cellHasFocus) {

			ComboLabel data = (ComboLabel) value;
			setText(data.getText());
			setIcon(data.getIcon());

			return this;
		}
	}
}
