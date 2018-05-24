package Draw;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class DrawWorkLoadmainClass {
public void DrawWorkloadDisplay() throws Exception{
	//public static void main(String args[]) throws Exception{
	JFrame frame=new JFrame("检车员工作量");
	frame.setLayout(new GridLayout(2,2,10,10));
	frame.add(new DrawWorkLoadInfoTotal().getChartPanel()); 
	frame.add(new DrawWorkLoadTeam().getChartPanel());
	frame.add(new DrawWorkLoadTime().getChartPanel());
	frame.add(new DrawWorkLoadPerson().getChartPanel());
	frame.setBounds(50, 50, 800, 600);
	frame.setVisible(true);
}
}
