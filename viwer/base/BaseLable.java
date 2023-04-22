package base;

import java.awt.Font;

import javax.swing.JLabel;

public class BaseLable extends JLabel {
	public BaseLable(String text) {
		super(text);
		setFont(15);
	}

	public BaseLable setFont(int size) {
		// TODO Auto-generated method stub
		super.setFont(new Font("", Font.BOLD, size));
		
		return this;
	}
}
