package Ex16_07;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Gui extends JFrame implements ActionListener, FocusListener{
	//Interpreter
	Interpretor interpretor = new Interpretor();
	Object obj = null;
	StringBuilder showMessage = new StringBuilder();

	private JLabel label_className;
	private JLabel label_constPara;
	private JLabel label_fieldName;
	private JLabel label_fieldVal;
	private JLabel label_methodName;
	private JLabel label_methodPara;
	private JLabel label_showArea;

	private JTextField text_className;
	private JTextField text_constPara;
	private JTextField text_fieldName;
	private JTextField text_fieldVal;
	private JTextField text_methodName;
	private JTextField text_methodPara;

	private JButton button_OK;
	private JButton button_instance;
	private JButton button_setField;
	private JButton button_invokeMethod;

	private JTextArea listTextArea;
	private JTextArea textArea;

	private GridBagLayout layout;
	private GridBagConstraints constraints;

	private static String example = "eg:型,値,型,値";

	public Gui(){
		super("GUI");
		setSize(new Dimension(800, 500));
		setLocationRelativeTo(null);
	    setResizable(false);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    //set layout
	    layout = new GridBagLayout();
	    setLayout(layout);
	    constraints = new GridBagConstraints();

	    //generate components
	    label_className = new JLabel("クラス名:");
	    label_constPara = new JLabel("コンストラクタ:");
		label_fieldName = new JLabel("フィールド名:");
		label_fieldVal = new JLabel("型値:");
		label_methodName = new JLabel("メソッド名:");
		label_methodPara = new JLabel("引数:");
		label_showArea = new JLabel("表示エリア↓↓↓↓↓");

		text_className = new JTextField(20);
		text_constPara = new JTextField(example, 20);
		text_fieldName = new JTextField(7);
		text_fieldVal = new JTextField(example, 9);
		text_methodName = new JTextField(7);
		text_methodPara = new JTextField(example, 9);
		text_fieldVal.setForeground(Color.LIGHT_GRAY);
		text_constPara.setForeground(Color.LIGHT_GRAY);
		text_methodPara.setForeground(Color.LIGHT_GRAY);
		text_fieldVal.addFocusListener(this);
		text_constPara.addFocusListener(this);
		text_methodPara.addFocusListener(this);

		button_OK = new JButton(" OK ");
		button_instance = new JButton("生成");
		button_setField = new JButton("設定");
		button_invokeMethod = new JButton("呼出");
		button_OK.addActionListener(this);
		button_instance.addActionListener(this);
		button_setField.addActionListener(this);
		button_invokeMethod.addActionListener(this);

		listTextArea = new JTextArea(15, 20);
		textArea = new JTextArea(5, 32);

		constraints.insets = new Insets(5, 3, 5, 3);
		constraints.anchor = GridBagConstraints.NORTHWEST;
		addComp(label_className, 0, 0, 1, 1);
		addComp(label_constPara, 0, 1, 1, 1);
		addComp(label_fieldName, 0, 2, 1, 1);
		addComp(label_methodName, 0, 3, 1, 1);

		addComp(text_className, 1, 0, 3, 1);
		addComp(text_constPara, 1, 1, 3, 1);
		addComp(text_fieldName, 1, 2, 1, 1);
		addComp(text_methodName, 1, 3, 1, 1);

		addComp(label_fieldVal, 2, 2, 1, 1);
		addComp(label_methodPara, 2, 3, 1, 1);

		addComp(text_fieldVal, 3, 2, 1, 1);
		addComp(text_methodPara, 3, 3, 1, 1);

		addComp(button_OK, 4, 0, 1, 1);
		addComp(button_instance, 4, 1, 1, 1);
		addComp(button_setField, 4, 2, 1, 1);
		addComp(button_invokeMethod, 4, 3, 1, 1);

		JScrollPane scrollPane = new JScrollPane(listTextArea);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(330, 400));

		JScrollPane scrollPane2 = new JScrollPane(textArea);
		scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane2.setPreferredSize(new Dimension(380, 205));


		addComp(scrollPane, 5, 0, 1, 6);
		addComp(label_showArea, 0, 4, 5, 1);
		addComp(scrollPane2, 0, 5, 5, 1);

		setVisible(true);
	}

	private void addComp(Component com, int x, int y, int width, int height) {
		constraints.gridx = x;
		constraints.gridy = y;
		constraints.gridheight = height;
		constraints.gridwidth = width;
		layout.setConstraints(com, constraints);
		add(com);
	}

	public static void main(String[] args){
		Gui gui = new Gui();
	}

	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		Object evt = e.getSource();

		//表示するメッセージ
		String className = text_className.getText();
		if(evt == button_OK){
			listTextArea.setText(interpretor.getAllMembers(className));
		}else if(evt == button_instance){
			String constParaText = text_constPara.getText();
			String trimConst = constParaText.trim();
			if (trimConst.equals("") || (constParaText.equals(example))
					|| (constParaText == null)) {
				try {
					obj = interpretor.createInstanceWithoutArgs(className);
					showMessage.append(obj.getClass() + "のインスタンスが生成された！\n");
				} catch (Throwable e2) {
					showMessage.append(e2 + "\n");
					textArea.setText(showMessage.toString());
				}
			} else {
				String strs[] = constParaText.split(",");
				if(strs.length % 2 != 0)
					return;
				Class<?>[] classType = null;
				classType = Format.getClassTypes(strs);
				Object[] args = null;
				try {
					args = Format.getArgs(strs);
				} catch (Throwable e1) {
					showMessage.append(e1 + "\n");
					textArea.setText(showMessage.toString());
				}
				try {
					obj = interpretor.createInstanceWithArgs(className, classType, args);
					showMessage.append(obj.getClass() + "の引数付きインスタンスが生成された！\n");
				} catch (Throwable e1) {
					showMessage.append(e1 + "\n");
					textArea.setText(showMessage.toString());
				}
			}
			textArea.setText(showMessage.toString());
		}else if(evt == button_setField){
			String fieldName = text_fieldName.getText();
			String fieldVal = text_fieldVal.getText();
			String strs[] = fieldVal.split(",");
			if(strs.length % 2 != 0)
				return;
			Object[] args = null;
			try {
				args = Format.getArgs(strs);
			} catch (Throwable e2) {
				showMessage.append(e2 + "\n");
				textArea.setText(showMessage.toString());
			}
			try {
				interpretor.setField(obj, fieldName, args[0]);
			} catch (Throwable e2) {
				showMessage.append(e2 + "\n");
				textArea.setText(showMessage.toString());
				return;
			}
			Object result = null;
			String resultStr = null;
			try {
				result = interpretor.getField(obj, fieldName);
				resultStr = result.toString();
			} catch (Throwable e1) {
				showMessage.append(e1 + "\n");
				textArea.setText(showMessage.toString());
				return;
			}
			showMessage.append("フィールド " + fieldName + " の値は："
					+ resultStr + "\n");
			textArea.setText(showMessage.toString());
		}else if(evt == button_invokeMethod){
			Object result = null;
			String methodName = text_methodName.getText();
			String methodPara = text_methodPara.getText();
			String trimConst = methodPara.trim();
			if(trimConst.equals("") || methodPara.equals(example) || (methodPara == null)){
				try {
					result = interpretor.invokeWithoutArgs(obj, methodName);
					showMessage.append(methodName + "()が呼び出された！\n" + "result: " + result + "\n");
				} catch (Throwable e1) {
					showMessage.append(e1 + "\n");
					textArea.setText(showMessage.toString());
				}

			}else{
				String strs[] = methodPara.split(",");
				if(strs.length % 2 != 0)
					return;
				Class<?>[] classType = null;
				classType = Format.getClassTypes(strs);
				Object[] args = null;
				try {
					args = Format.getArgs(strs);
				} catch (Throwable e2) {
					showMessage.append(e2 + "\n");
					textArea.setText(showMessage.toString());
				}
				try {
					result = interpretor.invoke(obj, methodName, classType, args);
					showMessage.append(methodName + "()が呼び出された！\n" + "result: " + result + "\n");
				} catch (Throwable e1) {
					showMessage.append(e1 + "\n");
					textArea.setText(showMessage.toString());
				}
				//showMessage.append(result.toString() + "が呼び出された！\n");
			}
			textArea.setText(showMessage.toString());
		}
	}

	public void focusGained(FocusEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		Object fEvt = e.getSource();
		if(fEvt == text_constPara){
			if(text_constPara.getText().equals(example))
				text_constPara.setText("");
			text_constPara.setForeground(Color.BLACK);
		}else if(fEvt == text_methodPara){
			if(text_methodPara.getText().equals(example))
				text_methodPara.setText("");
			text_methodPara.setForeground(Color.BLACK);
		}else if(fEvt == text_fieldVal){
			if(text_fieldVal.getText().equals(example))
				text_fieldVal.setText("");
			text_fieldVal.setForeground(Color.BLACK);
		}
	}

	public void focusLost(FocusEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}
}
