package base;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class BasePanel extends JPanel{
	public BasePanel center;
	public BasePanel top;
	public BasePanel bottom;
	public BasePanel left;
	public BasePanel right;

	public BasePanel() {
		super(new BorderLayout());
	}
	
	public BasePanel addChild() {
		center = new BasePanel();
		top = new BasePanel();
		bottom = new BasePanel();
		left = new BasePanel();
		right = new BasePanel();
		
		super.add(center, BorderLayout.CENTER);
		super.add(top, BorderLayout.NORTH);
		super.add(bottom, BorderLayout.SOUTH);
		super.add(left, BorderLayout.WEST);
		super.add(right, BorderLayout.EAST);
		
		return this;
	}
	
	public BasePanel setBorder(int top, int left, int bottom, int right) {
		
		super.setBorder(new EmptyBorder(top, left, bottom, right));
		
		return this;
	}

	public BasePanel setBorder(int hg, int vg) {
		
		super.setBorder(new EmptyBorder(hg, vg, hg, vg));
		
		return this;
	}

	public BasePanel setFlowLayout(int i) {
		// TODO Auto-generated method stub
		super.setLayout(new FlowLayout(i));
		return this;
	}
	
}
