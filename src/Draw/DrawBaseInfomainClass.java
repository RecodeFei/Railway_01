package Draw;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class DrawBaseInfomainClass {
public void DrawBaseDisplay() throws Exception{
	JFrame frame=new JFrame("人员基本情况");
	frame.setLayout(new GridLayout(2,2,10,10));
	frame.add(new DrawBaseInfoEdu().getChartPanel()); 
	frame.add(new DrawBaseinfoOutlook().getChartPanel());
	frame.add(new DrawBaseInfoSkill().getChartPanel());
	frame.setBounds(50, 50, 800, 600);
	frame.setVisible(true);
}
}
