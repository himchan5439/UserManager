package windows;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import base.BaseFrame;
import base.BaseLable;
import jdbc.DbManager;

public class MainFrame extends BaseFrame{

	private JButton userAddB;
	private JButton userDelB;
	private JButton userUpdataB;
	private JButton logoutB;
	private JScrollPane userT;

	public MainFrame() {
		super.setFrame(700, 500, "유저관리 프로그램", null);
	}

	@Override
	public void setComp() {
		// TODO Auto-generated method stub
		Vector<Vector<String>> table = DbManager.db.getData("SELECT * FROM manager.user;");
		Vector<Vector<String>> colName = DbManager.db.getData("show columns from manager.user;");
		
		Vector<String> col = new Vector<String>();
		
		for(int i = 0; i < colName.size(); i++){
			col.add(colName.get(i).get(0)+"");
		}
		
		JTable user = new JTable(table, col);
		user.setEnabled(false);
		userT = new JScrollPane(user);
		
		userAddB = new JButton("유저추가");
		userDelB = new JButton("유저삭제");
		userUpdataB = new JButton("정보수정");
		logoutB = new JButton("로그아웃");
	}

	@Override
	public void setDigin() {
		
		top.setFlowLayout(1);
		top.add(new BaseLable("유저목록").setFont(40));
		
		center.add(userT);
		
		bottom.setFlowLayout(1);
		bottom.add(userAddB);
		bottom.add(userDelB);
		bottom.add(userUpdataB);
		bottom.add(logoutB);
	}

	@Override
	public void setEvent() {
		// TODO Auto-generated method stub
		userAddB.addActionListener(e -> {
			new UserAddFrame(this);
		});
		userDelB.addActionListener(e -> {
			new UserDelFrame(this);
		});
		userUpdataB.addActionListener(e -> {
			new UserUpdataFrame(this);
		});
	}

}
