package bai2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class songuyento extends JFrame implements ActionListener {
	private JTextField text1;
	private JButton generate;
	private JTextArea Jlist;

	public songuyento() {
		super("Prime");
		setSize(350, 300);
		add(text1 = new JTextField(20));
		setLayout(null);
		text1.setBounds(40, 20, 150, 20);
		text1.setToolTipText("Nhập số nguyên tố cần hiển thị.");

		add(generate = new JButton("generate"));
		generate.setBounds(210, 20, 100, 20);
		JScrollPane jScro;
		add(jScro = new JScrollPane(Jlist = new JTextArea()));
		jScro.setBounds(40, 50, 270, 180);
		Jlist.setEditable(false);
		Jlist.setToolTipText("Danh sách các số nguyên tố");
		generate.addActionListener(this);

	}

	public boolean ktrasonguyento(int x) {
		for (int i = 2; i < x; i++) {
			if (x % i == 0) {
				return false;
			}
		}
		return true;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		try {
			if (Integer.parseInt(text1.getText()) > 0) {
				if (source.equals(generate)) {
					int count = 0;
					String kq="";
					for (int i = 2; i < 100000; i++) {
						if (ktrasonguyento(i)) {
							if (count < Integer.parseInt(text1.getText())) {
								kq += i + "\n";
							}
							count++;
						}
					}
					Jlist.setText(kq);
				}
			}else {
				JOptionPane.showMessageDialog(null, "Nhập số nguyên dương");
			}
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Sai dữ liệu");
		}

	}

	public static void main(String[] args) {
		new songuyento().setVisible(true);
	}

}
