package Draw;
import java.awt.Font;
import tools.FileReader;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;


import DataBase.FindfaultController;
import DataBase.FindfaultInfo;

public class DrawFindFaultPerson{
	ChartPanel frame1;
	static String [] lines =new FileReader("C:\tmp\findfault.txt","UTF-8").getLines();
	static String reg = "'";
	static String name = lines[0].replaceAll(reg,"");
	public  DrawFindFaultPerson() throws Exception{
		CategoryDataset dataset = getDataSet();
		
		
        JFreeChart chart = ChartFactory.createBarChart3D(
       		                name, // 图表标题
                            "日期", // 目录轴的显示标签
                            "数量", // 数值轴的显示标签
                            dataset, // 数据集
                            PlotOrientation.VERTICAL, // 图表方向：水平、垂直
                            true,           // 是否显示图例(对于简单的柱状图必须是false)
                            false,          // 是否生成工具
                            false           // 是否生成URL链接
                            );
        
        //从这里开始
        CategoryPlot plot=chart.getCategoryPlot();//获取图表区域对象
        CategoryAxis domainAxis=plot.getDomainAxis();         //水平底部列表
         domainAxis.setLabelFont(new Font("黑体",Font.BOLD,14));         //水平底部标题
         domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));  //垂直标题
         ValueAxis rangeAxis=plot.getRangeAxis();//获取柱状
         rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));
          chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
          chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体
          
          //到这里结束，虽然代码有点多，但只为一个目的，解决汉字乱码问题
          
         frame1=new ChartPanel(chart,true);        //这里也可以用chartFrame,可以直接生成一个独立的Frame
         
	}
	   private static CategoryDataset getDataSet() throws Exception {
           DefaultCategoryDataset dataset = new DefaultCategoryDataset();
           List<FindfaultInfo> findfaultInfos = new FindfaultController().query();
           int typeA = 0;
           int typeB = 0;
           int typeC = 0;
           int typeD = 0;
           int typeE = 0;
           for(int i=0; i<findfaultInfos.size(); i++) {
        	   //System.out.println(baseInfos.get(i).getEducation());
        	  if(findfaultInfos.get(i).getName().equals(name)){
        		  if(findfaultInfos.get(i).getFault_type().equals("A类故障")){
        			  typeA += 1;
        		  }
        		  if(findfaultInfos.get(i).getFault_type().equals("B类故障")){
        			  typeB += 1;
        		  }
        		  if(findfaultInfos.get(i).getFault_type().equals("C类故障")){
        			  typeC += 1;
        		  }
        		  if(findfaultInfos.get(i).getFault_type().equals("D类故障")){
        			  typeD += 1;
        		  }
        		  if(findfaultInfos.get(i).getFault_type().equals("E类故障")){
        			  typeE += 1;
        		  }
        	  }
           }
           dataset.addValue(typeA, "A类故障", "A类故障");
           dataset.addValue(typeB, "B类故障", "B类故障");
           dataset.addValue(typeC, "C类故障", "C类故障");
           dataset.addValue(typeD, "D类故障", "D类故障");
           dataset.addValue(typeE, "E类故障", "E类故障");
           
        	
           return dataset;
}
public ChartPanel getChartPanel(){
	return frame1;
	
}

}
