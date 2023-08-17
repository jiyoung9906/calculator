package 프로젝트최종;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

class Main extends javax.swing.JFrame implements ActionListener{
	MyPanel1 p1 = new MyPanel1();
	MyPanel2 p2 = new MyPanel2();
	MyPanel3 p3 = new MyPanel3();
	MyPanel4 p4 = new MyPanel4();
	MyPanel5 p5 = new MyPanel5();
	
	JMenuBar menubar = new JMenuBar();
	
	JMenu menu1 = new JMenu("메뉴");
	
	JMenuItem item1 = new JMenuItem("표준계산기");
	JMenuItem item2 = new JMenuItem("공학용계산기");
	JMenuItem item3 = new JMenuItem("길이계산기");
	JMenuItem item4 = new JMenuItem("무게계산기");
	JMenuItem item5 = new JMenuItem("날짜계산기");
	
	String path = "C:\\Users\\jy\\Desktop\\웹앱개발\\프로젝트최종\\icon1.jpg";
	ImageIcon icon = new ImageIcon(path);
	JLabel img = new JLabel(icon); // 레이블에 이미지 넣음
	
	public Main() {
		setSize(400,425);
		setLocation(550,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		setJMenuBar(menubar); // 1)프레임에 메뉴바 추가
		                        
		menubar.add(menu1);   // 2)메뉴바에 메뉴 추가
		
		menu1.add(item1);  // 3)메뉴에 메뉴아이템 추가
		menu1.add(item2);  // ※ 만약 순서를 달리할 경우, 처음부터 메뉴바가 보이지 않음
		menu1.add(item3);
		menu1.add(item4);
		menu1.add(item5);
		
		
		
		img.setIcon(icon);
		add(img); img.setBounds(100,150,100,100);
		
		
		menu1.addActionListener(this);
		item1.addActionListener(this);
		item2.addActionListener(this);
		item3.addActionListener(this);		
		item4.addActionListener(this);	
		item5.addActionListener(this);	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem a = (JMenuItem)e.getSource(); 
		menuchange(a);
	}
	public void menuchange(JMenuItem a) {
		if ( a == item1 ) {
			// 안보여지고 있는데 Visible속성을 바꾸려할 대 발생할 예외를 방지하기 위함
			// .isVisible() -> 현재 표시된 상태이면 true, 아니면 false
			if( p2.isVisible() ) p2.setVisible(false);
			if( p3.isVisible() ) p3.setVisible(false);
			if(p4.isVisible()) p4.setVisible(false);
			if(p5.isVisible()) p5.setVisible(false);
			
			
			this.add(p1, BorderLayout.CENTER);
					// 컨테이너나 컴포넌트의 길이를 리턴
			this.setSize(p1.getWidth(),p1.getHeight());
			p1.setVisible(true);
			img.setVisible(false);
			
		}
		if ( a == item2 ) {
			if( p1.isVisible() ) p1.setVisible(false);
			if( p3.isVisible() ) p3.setVisible(false);	
			if(p4.isVisible()) p4.setVisible(false);
			if(p5.isVisible()) p5.setVisible(false);
			
			this.add(p2, BorderLayout.CENTER);
			this.setSize(p2.getWidth(),p2.getHeight());
			p2.setVisible(true);
			img.setVisible(false);
		}
		if ( a == item3 ) {
			if( p1.isVisible() ) p1.setVisible(false);
			if( p2.isVisible() ) p2.setVisible(false);	
			if(p4.isVisible()) p4.setVisible(false);
			if(p5.isVisible()) p5.setVisible(false);
					
			this.add(p3, BorderLayout.CENTER);
			this.setSize(p3.getWidth(),p3.getHeight());
			p3.setVisible(true);
			img.setVisible(false);
		
			
		}
	
		if ( a == item4 ) {
			if( p1.isVisible() ) p1.setVisible(false);
			if( p2.isVisible() ) p2.setVisible(false);	
			if(p3.isVisible()) p3.setVisible(false);
			if(p5.isVisible()) p5.setVisible(false);
					
			this.add(p4, BorderLayout.CENTER);
			this.setSize(p4.getWidth(),p4.getHeight());
			p4.setVisible(true);
			img.setVisible(false);
		}
		
		if ( a == item5 ) {
			if( p1.isVisible() ) p1.setVisible(false);
			if( p2.isVisible() ) p2.setVisible(false);	
			if(p3.isVisible()) p3.setVisible(false);
			if(p4.isVisible()) p4.setVisible(false);
					
			this.add(p5, BorderLayout.CENTER);
			this.setSize(p5.getWidth(),p5.getHeight());
			p5.setVisible(true);
			img.setVisible(false);
		}
	}

	public static void main(String[] args) {
		new Main(); 
	}

}

