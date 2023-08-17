package 프로젝트최종;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyPanel4 extends JPanel implements ActionListener {
	JLabel kg = new JLabel("kg");
	JLabel resultweight1 = new JLabel("mg : ");
	JLabel resultweight2 = new JLabel("g : ");
	JLabel resultweight3 = new JLabel("t : ");
	JLabel resultweight4 = new JLabel("lb : ");

	// 계산식 출력 화면
	JTextField inputSpace1 = new JTextField("");
	JTextField inputSpace2 = new JTextField();
	JTextField inputSpace3 = new JTextField();
	JTextField inputSpace4 = new JTextField();
	JTextField inputSpace5 = new JTextField();
	
	JButton b = new JButton("ok");

	JPanel buttonPanel = new JPanel();

	public MyPanel4() {
		
		setSize(300, 370);
		setLayout(null);

		Font f = new Font("Arial", Font.BOLD, 12);
		add(resultweight1);
		resultweight1.setFont(f);
		resultweight1.setBounds(10, 65, 50, 70);

		add(resultweight2);
		resultweight2.setFont(f);
		resultweight2.setBounds(155, 65, 50, 70);

		add(resultweight3);
		resultweight3.setFont(f);
		resultweight3.setBounds(10, 120, 50, 70);

		add(resultweight4);
		resultweight4.setFont(f);
		resultweight4.setBounds(155, 120, 50, 70);

		add(inputSpace1);
		inputSpace1.setBounds(8, 10, 270, 40);
		inputSpace1.setFont(new Font("Arial", Font.BOLD, 25));
		inputSpace1.setBackground(Color.WHITE);
		inputSpace1.setEditable(true);
		inputSpace1.setHorizontalAlignment(JLabel.RIGHT);

		add(kg);
		kg.setBounds(250, 55, 20, 20);
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
			double kg = Double.parseDouble(a);

			int mg = (int) (kg * 1000000);
			double g = kg * 1000;
			double t = kg / 1000;
			double lb = kg * 2.204623;

			String mg1 = Integer.toString(mg);
			String g1 = Double.toString(g);
			String t1 = Double.toString(t);
			String lb1 = Double.toString(lb);

			inputSpace2.setText(mg1);
			inputSpace3.setText(String.format("%.3f", g));
			inputSpace4.setText(t1);
			inputSpace5.setText(String.format("%.3f", lb));

		}
	}


	public static void main(String[] args) {
		new MyPanel4();
	}
}
