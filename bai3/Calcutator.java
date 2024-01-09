package bai3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Calcutator extends JFrame implements ActionListener{
	private JPanel Panel_North, Panel_South,Panel_West, Panel_Center,Panel_Cal;
	private JLabel Header, center_a,center_b,center_result;
	private JButton btGiai,btXoa,btThoat;
	private JRadioButton Ra_Cong, Ra_Tru,Ra_Nhan,Ra_Chia;
	private JTextField text_a, text_b,text_result;
	
	public Calcutator() {
		// PANEL NORTH
		super("Cộng - Trừ - Nhân - Chia");
		add(Panel_North = new JPanel(),BorderLayout.NORTH);
		Panel_North.add(Header = new JLabel("Cộng Trừ Nhân Chia"));
		Header.setFont(new Font("Arial", Font.BOLD, 25));
		Header.setForeground(Color.blue);
		
		
		// PANEL WEST
		add(Panel_West = new JPanel(),BorderLayout.WEST);
		Panel_West.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));		
		Box box_West = new Box(BoxLayout.Y_AXIS);
		
		box_West.add(btGiai = new JButton(" Giải "));
		box_West.add(Box.createVerticalStrut(10)); 
		btGiai.setBounds(20,20,100,30);
		box_West.add(btXoa = new JButton(" Xóa  "));
		btXoa.setBounds(20,20,100,30);
		box_West.add(Box.createVerticalStrut(10)); 
		box_West.add(btThoat = new JButton("Thoát"));
		box_West.add(Box.createVerticalStrut(10)); 
		btXoa.setBounds(20,20,100,30);
		Panel_West.add(box_West);
		Panel_West.setBackground(Color.gray);
		
		
		// PANEL CENTER
		Box box_center_a = new Box(BoxLayout.X_AXIS);
		Box box_center_b = new Box(BoxLayout.X_AXIS);
		Box box_center_result = new Box(BoxLayout.X_AXIS);
		add(Panel_Center = new JPanel());
		Panel_Center.setBorder(BorderFactory.createTitledBorder("Tính toán"));
		
		
		box_center_a.add(center_a = new JLabel("Nhập a:"));
		box_center_a.add(Box.createHorizontalStrut(10));
		box_center_a.add(text_a = new JTextField(25));
		
		box_center_b.add(center_b = new JLabel("Nhập b:"));
		box_center_b.add(Box.createHorizontalStrut(10));
		box_center_b.add(text_b = new JTextField(25));
		
		Panel_Center.add(box_center_a);
		Panel_Center.add(box_center_b);
		
		//PANEL CENTER CALCULATOR
		Box box_center_Cong_tru = new Box (BoxLayout.Y_AXIS);
		Box box_center_Nhan_Chia = new Box (BoxLayout.Y_AXIS);
		
		box_center_Cong_tru.add(Ra_Cong = new JRadioButton("Cộng"));
		box_center_Cong_tru.add(Box.createHorizontalStrut(30));
		box_center_Cong_tru.add(Ra_Tru = new JRadioButton("Trừ"));
		
		box_center_Nhan_Chia.add(Ra_Nhan = new JRadioButton("Nhân"));
		box_center_Nhan_Chia.add(Box.createHorizontalStrut(30));
		box_center_Nhan_Chia.add(Ra_Chia = new JRadioButton("Chia"));
		
		Panel_Cal = new JPanel();
		Panel_Cal.setBorder(BorderFactory.createTitledBorder("Phép toán"));
		Panel_Cal.add(box_center_Cong_tru);
		Panel_Cal.add(box_center_Nhan_Chia);
		ButtonGroup gr = new ButtonGroup();
		gr.add(Ra_Cong);
		gr.add(Ra_Tru);
		gr.add(Ra_Nhan);
		gr.add(Ra_Chia);
		
		Panel_Center.add(Panel_Cal);
		
		
		// PANEL CENTER RESULT
		box_center_result.add(center_result = new JLabel("Kết quả:")); 
		box_center_result.add(Box.createHorizontalStrut(10));
		box_center_result.add(text_result = new JTextField(25));
		text_result.setEditable(false);
		Panel_Center.add(box_center_result);
		
		// PANEL SOUTH
		add(Panel_South = new JPanel(), BorderLayout.SOUTH);
		Panel_South.add(new JLabel("   "));
		Panel_South.setBackground(Color.pink);
			
		
		
		btGiai.addActionListener(this);
		btXoa.addActionListener(this);
		btThoat.addActionListener(this);
		setResizable(false);
		setSize(500,350);
		
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source.equals(btGiai)) {
			if(Ra_Cong.isSelected()) {
				double a = Double.parseDouble(text_a.getText());
				double b = Double.parseDouble(text_b.getText());
				double result = a + b;
				text_result.setText(Double.toString(result)
						
						);
			}else if(Ra_Tru.isSelected()){
				double a = Double.parseDouble(text_a.getText());
				double b = Double.parseDouble(text_b.getText());
				double result = a - b;
				text_result.setText(Double.toString(result));
			}else  if(Ra_Nhan.isSelected()){
				double a = Double.parseDouble(text_a.getText());
				double b = Double.parseDouble(text_b.getText());
				double result = a * b;
				text_result.setText(Double.toString(result));
			}else if(Ra_Chia.isSelected()) {
				double a = Double.parseDouble(text_a.getText());
				double b = Double.parseDouble(text_b.getText());
				double result = a/b;
				text_result.setText(Double.toString(result));
			}
		}else if(source.equals(btXoa)) {
			text_a.setText("");
			text_b.setText("");
			text_result.setText("");
		}else if(source.equals(btThoat)) {
			System.exit(0);
		}
		
	}
	public static void main(String[] args) {
		new Calcutator().setVisible(true);
	}
}
