package Draw;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class DrawAccuracymainClass {

	/**
	 * @param args
	 * @throws Exception 
	 */
	//public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	public void DrawAccuracyDisplay() throws Exception{
		JFrame frame=new JFrame("TFDS动态检车员标注故障准确率");
		frame.setLayout(new GridLayout(2,2,10,10));	
		//frame.add(new DrawAccuracyTotal().getChartPanel());
		frame.add(new DrawAccuracyTime().getChartPanel());
		frame.add(new DrawAccuracyPerson().getChartPanel());
		frame.setBounds(50, 50, 800, 600);
		frame.setVisible(true);
	}

}
