package Draw;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class DrawFindFaultmainClass {

	public void DrawFindFaultDisplay() throws Exception{
	//public static void main(String args[]) throws Exception{
	JFrame frame=new JFrame("TFDS动态检车员发现故障情况");
	frame.setLayout(new GridLayout(2,2,10,10));
	frame.add(new DrawFindFaultTotal().getChartPanel()); 
	frame.add(new DrawFindFaultPerson().getChartPanel());
	frame.setBounds(50, 50, 800, 600);
	frame.setVisible(true);
	}
}
