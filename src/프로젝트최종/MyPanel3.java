package 프로젝트최종;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyPanel3 extends JPanel implements ActionListener {
	JLabel cm = new JLabel("cm");
	JLabel resultlength1 = new JLabel("mm : ");
	JLabel resultlength2 = new JLabel("m : ");
	JLabel resultlength3 = new JLabel("km : ");
	JLabel resultlength4 = new JLabel("in : ");

	// 계산식 출력 화면
	JTextField inputSpace1 = new JTextField("");
	JTextField inputSpace2 = new JTextField();
	JTextField inputSpace3 = new JTextField();
	JTextField inputSpace4 = new JTextField();
	JTextField inputSpace5 = new JTextField();

	JButton b = new JButton("ok");

	JPanel buttonPanel = new JPanel();
	public MyPanel3() {
		
		// 계산기 버튼
		
		setSize(300, 370);
		setLayout(null);

		Font f = new Font("Arial", Font.BOLD, 12);
			
			add(resultlength1);
			resultlength1.setFont(f);
			resultlength1.setBounds(10, 70, 50, 70);

			add(resultlength2);
			resultlength2.setFont(f);
			resultlength2.setBounds(155, 70, 50, 70);

			add(resultlength3);
			resultlength3.setFont(f);
			resultlength3.setBounds(10, 120, 50, 70);

			add(resultlength4);
			resultlength4.setFont(f);
			resultlength4.setBounds(155, 120, 50, 70);

			add(inputSpace1);
			inputSpace1.setBounds(8, 10, 270, 40);
			inputSpace1.setFont(new Font("Arial", Font.BOLD, 25));
			inputSpace1.setBackground(Color.WHITE);
			inputSpace1.setEditable(true);
			inputSpace1.setHorizontalAlignment(JLabel.RIGHT);
			
			add(cm);
			cm.setBounds(250, 55, 20, 10);
			inputSpace1.setFont(new Font("Arial", Font.BOLD, 25));

			add(inputSpace2);
			inputSpace2.setBounds(45, 85, 95, 40);
			inputSpace2.setFont(new Font("Arial", Font.BOLD, 12));
			inputSpace2.setBackground(Color.WHITE);
			inputSpace2.setEditable(false);

			add(inputSpace3);
			inputSpace3.setBounds(180, 85, 95, 40);
			inputSpace3.setFont(new Font("Arial", Font.BOLD, 12));
			inputSpace3.setBackground(Color.WHITE);
			inputSpace3.setEditable(false);

			add(inputSpace4);
			inputSpace4.setBounds(45, 135, 95, 40);
			inputSpace4.setFont(new Font("Arial", Font.BOLD, 12));
			inputSpace4.setBackground(Color.WHITE);
			inputSpace4.setEditable(false);

			add(inputSpace5);
			inputSpace5.setBounds(180, 135, 95, 40);
			inputSpace5.setFont(new Font("Arial", Font.BOLD, 12));
			inputSpace5.setBackground(Color.WHITE);
			inputSpace5.setEditable(false);

			add(b);
			b.setBounds(115, 220, 60, 30);
			
			b.addActionListener(this);
		}
	
		

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == b) {

				String a = inputSpace1.getText();
				double cm = Double.parseDouble(a);

				double mm = cm * 10;
				double m = cm / 100;
				double km = cm / 100000;
				double in = cm / 2.54;

				String mm1 = Double.toString(mm);
				String m1 = Double.toString(m);
				String km1 = Double.toString(km);
				String in1 = Double.toString(in);

				inputSpace2.setText(mm1);
				inputSpace3.setText(m1);
				inputSpace4.setText(String.format("%.5f", km));
				inputSpace5.setText(String.format("%.3f", in));

			}
		}



	public static void main(String[] args) {
		new MyPanel3();

	}

}