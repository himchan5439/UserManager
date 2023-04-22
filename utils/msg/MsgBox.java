package msg;

import javax.swing.JOptionPane;

public class MsgBox {
	public static void error(String text) {
		JOptionPane.showMessageDialog(null, text, "오류", JOptionPane.ERROR_MESSAGE);
	}
	public static void info(String text) {
		JOptionPane.showMessageDialog(null, text, "정보", JOptionPane.INFORMATION_MESSAGE);
	}
}
