package 프로젝트최종;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyPanel1 extends JPanel implements ActionListener {
	JTextField inputSpace = new JTextField();
	// 계산식 출력 화면
	JPanel buttonPanel = new JPanel();
	// 계산기 버튼
	String button_names[] = { "C", "÷", "×", "=", "1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "0"};
	// 버튼들의 배열
	JButton buttons[] = new JButton[button_names.length];
//	JMenuBar jmb = new JMenuBar();
//	JMenu jm = new JMenu("=");
//	JMenuItem it = new JMenuItem("표준용");
	private String num = "";
	private String prev_operation = "";
	private ArrayList<String> equation = new ArrayList<String>();

	public MyPanel1() {
		setSize(400,430);
		setLayout(null);

		add(inputSpace);
		inputSpace.setBounds(8, 30, 370, 70);
		inputSpace.setFont(new Font("Arial", Font.BOLD, 30));
		inputSpace.setBackground(Color.WHITE);
		inputSpace.setEditable(false);
		add(buttonPanel);
		buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));
		buttonPanel.setBounds(8, 110, 370, 235);

//		add(jmb);
//		jmb.setBounds(0, 0, 480, 20);
//		jmb.add(jm);
//		jm.add(it);

		for (int i = 0; i < button_names.length; i++) {
			buttons[i] = new JButton(button_names[i]);
			buttons[i].setFont(new Font("Arial", Font.BOLD, 20));
			if (button_names[i] == "C")
				buttons[i].setBackground(Color.RED);
			else if ((i >= 4 && i <= 6) || (i >= 8 && i <= 10) || (i >= 12 && i <= 14))
				buttons[i].setBackground(Color.BLACK);
			else
				buttons[i].setBackground(Color.GRAY);
			buttons[i].setForeground(Color.WHITE);
			// 테두리 없앱
			buttons[i].setBorderPainted(false);
			// 밑에서 만든 액션리스너를 버튼에 추가
			buttonPanel.add(buttons[i]);
			buttons[i].addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String operation = e.getActionCommand();
		if (operation.equals("C")) {
			inputSpace.setText("");
		} else if (operation.equals("=")) {
			String result = Double.toString(calculate(inputSpace.getText()));
			inputSpace.setText("" + result);
			num = "";
		} else if (operation.equals("+") || operation.equals("-") || operation.equals("×") || operation.equals("÷")) {
			if (inputSpace.getText().equals("") && operation.equals("-")) {
				inputSpace.setText(inputSpace.getText() + e.getActionCommand());
			} else if (!inputSpace.getText().equals("") && !prev_operation.equals("+") && !prev_operation.equals("-")
					&& !prev_operation.equals("×") && !prev_operation.equals("÷")) {
				inputSpace.setText(inputSpace.getText() + e.getActionCommand());
			}
		} else {
			inputSpace.setText(inputSpace.getText() + e.getActionCommand());
		}

		prev_operation = e.getActionCommand();
	}

	private void fullTextParsing(String inputText) {
		equation.clear();

		for (int i = 0; i < inputText.length(); i++) {
			char ch = inputText.charAt(i);

			if (ch == '-' || ch == '+' || ch == '×' || ch == '÷') {
				equation.add(num);
				num = "";
				equation.add(ch + "");
			} else {
				num = num + ch;
			}
		}
		equation.add(num);
		equation.remove("");
	}

	public double calculate(String inputText) {
		fullTextParsing(inputText);

		double prev = 0;
		double current = 0;
		String mode = "";

		for (int i = 0; i < equation.size(); i++) {
			String s = equation.get(i);

			if (s.equals("+")) {
				mode = "add";
			} else if (s.equals("-")) {
				mode = "sub";
			} else if (s.equals("×")) {
				mode = "mul";
			} else if (s.equals("÷")) {
				mode = "div";
			} else {
				if ((mode.equals("mul") || mode.equals("div")) && !s.equals("+") && !s.equals("-") && !s.equals("×") && !s.equals("÷")) {
					Double one = Double.parseDouble(equation.get(i - 2));
					Double two = Double.parseDouble(equation.get(i));
					Double result = 0.0;

					if (mode.equals("mul")) {
						result = one * two;
					} else if (mode.equals("div")) {
						result = one / two;
					}

					equation.add(i + 1, Double.toString(result));

					for (int j = 0; j < 3; j++) {
						equation.remove(i - 2);
					}

					i -= 2; // 결과값이 생긴 인덱스로 이동
				}
			}
		} // 곱셈 나눗셈을 먼저 계산한다

		for (String s : equation) {
			if (s.equals("+")) {
				mode = "add";
			} else if (s.equals("-")) {
				mode = "sub";
			} else {
				current = Double.parseDouble(s);
				if (mode.equals("add")) {
					prev += current;
				} else if (mode.equals("sub")) {
					prev -= current;
				} else {
					prev = current;
				}
			}
			prev = Math.round(prev * 100000) / 100000.0;
		}

		return prev;
	}



	public static void main(String[] args) {
		new MyPanel1();

	}

}