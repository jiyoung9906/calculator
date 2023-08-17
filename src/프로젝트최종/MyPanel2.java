package 프로젝트최종;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyPanel2 extends JPanel implements ActionListener {
	JTextField numField = new JTextField();
	JPanel panel = new JPanel();
	private double num1, num2;
	private String op, input;
	public String engibutton[] = { "C", "÷", "×", "=", "1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "0", "!",
			"log", "√", "^", }; // 공학용
	JButton buttons[] = new JButton[engibutton.length];

	public MyPanel2() {
		setSize(400,450);
		setLayout(null);
		
		add(numField);
		numField.setBounds(8, 30, 370, 70);
		numField.setFont(new Font("Arial", Font.BOLD, 30));
		numField.setBackground(Color.WHITE);
		numField.setEditable(false);

		add(panel);
		panel.setLayout(new GridLayout(5, 4, 10, 10));
		panel.setBounds(8, 110, 370, 235);

		setVisible(true);

		for (int i = 0; i < engibutton.length; i++) {
			buttons[i] = new JButton(engibutton[i]);
			buttons[i].setFont(new Font("Arial", Font.BOLD, 20));
			if (engibutton[i] == "C")
				buttons[i].setBackground(Color.RED);
			else if ((i >= 4 && i <= 6) || (i >= 8 && i <= 10) || (i >= 12 && i <= 14))
				buttons[i].setBackground(Color.BLACK);
			else
				buttons[i].setBackground(Color.GRAY);
			buttons[i].setForeground(Color.WHITE);
			// 테두리 없앱
			buttons[i].setBorderPainted(false);
			// 밑에서 만든 액션리스너를 버튼에 추가
			panel.add(buttons[i]);
			buttons[i].addActionListener(this);
		}
	}

	public void actionPerformed(ActionEvent e) {
		input = e.getActionCommand();
		switch (input) {
		case "+":
			op = "+";
			num1 = Double.parseDouble(numField.getText());
			numField.setText("");
			break;
		case "-":
			op = "-";
			num1 = Double.parseDouble(numField.getText());
			numField.setText("");
			break;
		case "×":
			op = "×";
			num1 = Double.parseDouble(numField.getText());
			numField.setText("");
			break;
		case "÷":
			op = "÷";
			num1 = Double.parseDouble(numField.getText());
			numField.setText("");
			break;
		case "=":
			num2 = Double.parseDouble(numField.getText());
			double result = calculate(num1, num2, op);
			numField.setText(Double.toString(result));
			break;
		case "C":
			numField.setText("");
			break;
		case "log":
			num1 = Double.parseDouble(numField.getText());
			double logResult = Math.log10(num1);
			numField.setText(Double.toString(logResult));
			break;
		case "√":
			num1 = Double.parseDouble(numField.getText());
			double sqrtResult = Math.sqrt(num1);
			numField.setText(Double.toString(sqrtResult));
			break;
		case "^":
			num1 = Double.parseDouble(numField.getText());
			double squareResult = Math.pow(num1, 2);
			numField.setText(Double.toString(squareResult));
			break;
		case "!":
			num1 = Double.parseDouble(numField.getText());
			double factResult = 1;
			for (int i = 1; i <= num1; i++) {
				factResult *= i;
			}
			numField.setText(Double.toString(factResult));
			break;
		default:
			numField.setText(numField.getText() + input);
		}
	}
	
//	 우선순위(priority) 계산 메소드
	private int priority(String op) {	
		switch (op) {
		case "×":
		case "÷":
			return 2;
		case "+":
		case "-":
			return 1;
		default:
			return 0;
		}
	}

	private double calculate(double num1, double num2, String op) {
		int priority = priority(op);
		switch (priority) {
		case 2:
			if (op.equals("×")) {
				return num1 * num2;
			} else {
				return num1 / num2;
			}
		case 1:
			if (op.equals("+")) {
				return num1 + num2;
			} else {
				return num1 - num2;
			}
		default:
			return 0;
		}
	}
	public static void main(String[] args) {
		new MyPanel2();
		
	}

}