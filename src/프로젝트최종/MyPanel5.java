package 프로젝트최종;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyPanel5 extends JPanel implements ActionListener {
	JLabel l = new JLabel("날짜 간 차이");
	JLabel l2 = new JLabel("시작일");
	JLabel l3 = new JLabel("종료일");
	JLabel l4 = new JLabel("차이");
	Font f = new Font("굴림체", Font.BOLD, 50);
	
	JTextField StartDate = new JTextField(20); // 기본생성자
	JTextField EndDate = new JTextField(20); // 행과 열을 지정하는 생성자
	JButton b = new JButton("ok");
	JTextField DayDifference = new JTextField(20);

	public MyPanel5() {

		setSize(300, 400);
		setLocation(200, 200);
		
		setLayout(null);

		add(l);
		l.setBounds(100, 0, 120, 30);
		add(l2);
		l2.setBounds(10, 40, 50, 30);
		add(StartDate);
		StartDate.setBounds(10, 80, 250, 30);
		add(l3);
		l3.setBounds(10, 120, 50, 30);
		add(EndDate);
		EndDate.setBounds(10, 160, 250, 30);
		add(b);
		b.setBounds(200, 200, 60, 40);
		add(l4);
		l4.setBounds(10, 240, 50, 30);
		add(DayDifference);
		DayDifference.setBounds(10, 280, 250, 30);
		DayDifference.setEditable(false);

		b.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b) {
			String startDay = StartDate.getText();
			String endDay = EndDate.getText();
			StringTokenizer st1 = new StringTokenizer(startDay, "/ -");
			StringTokenizer st2 = new StringTokenizer(endDay, "/ -");

			Calendar start = Calendar.getInstance();
			Calendar end = Calendar.getInstance();

			String Syear = st1.nextToken();
			String Smonth = st1.nextToken();
			String Sday = st1.nextToken();
			int y = Integer.parseInt(Syear);
			int m = Integer.parseInt(Smonth);
			int d = Integer.parseInt(Sday);
			start.set(y, m - 1, d);

			String Eyear = st2.nextToken();
			String Emonth = st2.nextToken();
			String Eday = st2.nextToken();
			int y2 = Integer.parseInt(Eyear);
			int m2 = Integer.parseInt(Emonth);
			int d2 = Integer.parseInt(Eday);
			end.set(y2, m2 - 1, d2);

			long day = (end.getTimeInMillis() - start.getTimeInMillis()) / 1000 / 60 / 60 / 24;

			if (day == 0)
				DayDifference.setText("동일한 날짜");
			else if (day < 0)
				DayDifference.setText("잘못된 입력");
			else
				DayDifference.setText(day + " 일차이");
		}

	}

	public static void main(String[] args) {
		new MyPanel5();

	}

}
