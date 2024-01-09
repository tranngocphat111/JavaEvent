package bai1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class giaiPTBacHai extends JFrame implements ActionListener{
	private JPanel Panel_top,Panel_bottom,Panel_Center;
	private JLabel header,content_a,content_b,content_c,content_result,content_option;
	private JTextField text_a,text_b,text_c,text_result;
	private JButton btGiai,btXoa,btThoat;
	public giaiPTBacHai() {
		super("^-^");
		Panel_top = new JPanel();
		add(Panel_top,BorderLayout.NORTH);
		header = new JLabel("GIẢI PHƯƠNG TRÌNH BẬC HAI");
		header.setFont(new Font("Arial", Font.BOLD, 20));
		Panel_top.add(header);
		Panel_top.setBackground(Color.cyan);
		
		
		add(Panel_Center = new  JPanel(), BorderLayout.CENTER);
		Panel_Center.setLayout(null);
		Panel_Center.add(content_a = new JLabel("Nhập a:"));
		Panel_Center.add(content_b = new JLabel("Nhập b:"));
		Panel_Center.add(content_c = new JLabel("Nhập c:"));
		Panel_Center.add(content_result = new JLabel("Kết quả:"));
		int x=40,y=50,w=100,h=20;
		content_a.setBounds(x, y, w, h);
		y+=50;
		content_b.setBounds(x, y, w, h);
		y+=50;
		content_c.setBounds(x, y, w, h);
		y+=50;
		content_result.setBounds(x, y, w, h);
		y+=50;
		
		x=110;y=50;w=300;h=20;
		
		Panel_Center.add(text_a = new JTextField());
		Panel_Center.add(text_b = new JTextField());
		Panel_Center.add(text_c = new JTextField());
		Panel_Center.add(text_result = new JTextField());
		
		text_a.setBounds(x, y, w, h);
		y+=50;
		text_b.setBounds(x, y, w, h);
		y+=50;
		text_c.setBounds(x, y, w, h);
		y+=50;
		text_result.setBounds(x, y, w, h);
		
		setSize(500,400);
		
		
		add(Panel_bottom = new JPanel(),BorderLayout.SOUTH);
		Panel_bottom.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		Panel_bottom.add(btGiai = new JButton("Giải"));
		Panel_bottom.add(btXoa = new JButton("Xóa"));
		Panel_bottom.add(btThoat = new JButton("Thoát"));
		btGiai.addActionListener(this);
		btXoa.addActionListener(this);
		btThoat.addActionListener(this);
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source.equals(btGiai)) {
			double a = Double.parseDouble(text_a.getText());
			double b = Double.parseDouble(text_b.getText());
			double c = Double.parseDouble(text_c.getText());
			double delta = b*b - 4*a*c;
			if(delta > 0) {
				double x = ((-b + Math.sqrt(delta))/(2*a)), y = ((-b - Math.sqrt(delta))/(2*a));
				text_result.setText("x = " + x + "   y = " + y);
			}else if(delta == 0) {
				double x = -b/2*a;
				text_result.setText("x=y= " + x);
			}else {
				text_result.setText("Vô nghiệm");
			}
			
				
		}else if (source.equals(btXoa)) {
			text_a.setText("");
			text_b.setText("");
			text_c.setText("");
			text_result.setText("");
		}else if(source.equals(btThoat)) {
			System.exit(0);
		}
		
	}
	
	public static void main(String[] args) {
		new giaiPTBacHai().setVisible(true);
	}
	
}
