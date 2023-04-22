package base;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public abstract class BaseFrame extends JFrame implements BaseInterfase{

	private BaseFrame bacFrame;
	
	public BasePanel center;
	public BasePanel top;
	public BasePanel bottom;
	public BasePanel left;
	public BasePanel right;

	public BaseFrame setFrame(int w, int h, String title, BaseFrame bacFrame) {
		this.bacFrame  = bacFrame;
		
		super.setTitle(title);
		super.setSize(w, h);
		
		center = new BasePanel();
		top = new BasePanel();
		bottom = new BasePanel();
		left = new BasePanel();
		right = new BasePanel();
		
		setComp();
		setDigin();
		setEvent();
		
		super.add(center, BorderLayout.CENTER);
		super.add(top, BorderLayout.NORTH);
		super.add(bottom, BorderLayout.SOUTH);
		super.add(left, BorderLayout.WEST);
		super.add(right, BorderLayout.EAST);
		
		super.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				System.out.println(getSize());
				close();
			}
		});
		
		super.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		super.setLocationRelativeTo(null);
		
		super.setVisible(true);
		
		return this;
	}
	
	public void close() {
		// TODO Auto-generated method stub
		if(this.bacFrame == null) {			
			System.exit(0);
		}
	}

}
