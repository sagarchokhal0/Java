import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class CardLayoutDemo{
	JFrame frame;
	CardLayout cl;
	CardLayoutDemo(){
		frame = new JFrame("Card layout");
		cl = new CardLayout();

		JButton btn1 = new JButton("Button1");
		JButton btn2 = new JButton("Button2");
		JButton btn3 = new JButton("Button3");

		
		frame.setLayout(cl);

		frame.add(btn1);
		frame.add(btn2);
		frame.add(btn3);

		frame.setSize(500,500);
		frame.setVisible(true);
		btn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				cl.next(frame.getContentPane());
			}
		});
		btn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				cl.next(frame.getContentPane());
			}
		});
		btn3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				cl.next(frame.getContentPane());
			}
		});
	}
	public static void main(String[] args){
		new CardLayoutDemo();
	}
}