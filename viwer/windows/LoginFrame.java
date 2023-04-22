package windows;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import base.BaseFrame;
import base.BaseLable;
import jdbc.DbManager;
import msg.MsgBox;
import user.UserInfo;

public class LoginFrame extends BaseFrame{

	private JTextField idTF;
	private JPasswordField pwTF;
	private JButton loginB;

	public LoginFrame() {
		super.setFrame(377, 222, "유저관리 프로그램", null);
	
	}

	@Override
	public void setComp() {
		// TODO Auto-generated method stub
		
		idTF = new JTextField();
		pwTF = new JPasswordField();
		
		loginB = new JButton("로그인");
		
	}

	@Override
	public void setDigin() {
		// TODO Auto-generated method stub
		top.setFlowLayout(1);
		top.add(new BaseLable("로그인").setFont(45));
		
		center.addChild();
		center.top.add(idTF);
		center.bottom.add(pwTF);
		center.setBorder(25, 20);
		
		left.addChild();
		left.top.add(new BaseLable("아이디  "));
		left.bottom.add(new BaseLable("비밀번호"));
		left.setBorder(25, 20);
		
		bottom.add(loginB);
	}

	@Override
	public void setEvent() {
		// TODO Auto-generated method stub
		loginB.addActionListener(e -> {
			String id = idTF.getText().trim();
			String pw = pwTF.getText().trim();
			
			if(id.equals("") || pw.equals("")) {
				MsgBox.error("빈칸이 있습니다.");
				return;
			}
			
			Vector<Vector<String>> userT = DbManager.db.getData(""
					+ "SELECT * FROM manager.user where id = ? and pw = ?;", id, pw);
			if(userT.size() != 0) {
				UserInfo.userNumber = userT.get(0).get(0);
				UserInfo.userId = userT.get(0).get(1);
				UserInfo.userName = userT.get(0).get(3);
				UserInfo.userPhone = userT.get(0).get(4);

				MsgBox.info(UserInfo.userName + " 님 안녕하세요.");
				
				this.dispose();
				new MainFrame();
				return;
			}
			
			MsgBox.error("일치하는 계정을 찾지 못했습니다.");
			idTF.setText("");
			pwTF.setText("");
			idTF.requestFocus();
		});
	}

}
