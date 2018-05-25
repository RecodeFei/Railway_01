package Draw;
import java.awt.Font;
import java.math.BigDecimal;

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


import DataBase.AccuracyController;
import DataBase.AccuracyInfo;

public class DrawAccuracyPerson{
	ChartPanel frame1;
	static String [] lines =new FileReader("/home/feikuang/workspace/tmp/accuracy.txt","UTF-8").getLines();
	static String reg = "'";
	static String name = lines[0].replaceAll(reg,"");
	public  DrawAccuracyPerson() throws Exception{
		CategoryDataset dataset = getDataSet();
		
		
        JFreeChart chart = ChartFactory.createBarChart3D(
       		                name, // 图表标题
                            "日期", // 目录轴的显示标签
                            "准确率", // 数值轴的显示标签
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
           List<AccuracyInfo> accuracyInfos = new AccuracyController().query();
       	   BigDecimal date77bigDecimal = new BigDecimal(0); 
       	   BigDecimal date78bigDecimal = new BigDecimal(0); 
       	   BigDecimal date79bigDecimal = new BigDecimal(0); 
       	   BigDecimal date710bigDecimal = new BigDecimal(0); 
       	   BigDecimal date711bigDecimal = new BigDecimal(0); 
       	   BigDecimal date712bigDecimal = new BigDecimal(0); 
       	   BigDecimal date81bigDecimal = new BigDecimal(0); 
       	   BigDecimal date82bigDecimal = new BigDecimal(0); 
    		
           for(int i=0; i<accuracyInfos.size(); i++) {

        	   if( accuracyInfos.get(i).getTime().toString().equals("2017年7月")) {
        		   if(accuracyInfos.get(i).getName().toString().equals(name)) {
        			   	String date77 = accuracyInfos.get(i).getAccuracy();       	
              			BigDecimal bs2 = new BigDecimal(date77);
              			date77bigDecimal = date77bigDecimal.add(bs2);      		
        		   }
        	   }
        	   if( accuracyInfos.get(i).getTime().toString().equals("2017年8月")) {
        		   if(accuracyInfos.get(i).getName().toString().equals(name)) {
       			   	String date78 = accuracyInfos.get(i).getAccuracy();       	
          			BigDecimal bs2 = new BigDecimal(date78);
          			date78bigDecimal = date78bigDecimal.add(bs2); 
        		   }
        	   }
        	   if( accuracyInfos.get(i).getTime().toString().equals("2017年9月")) {
        		   if(accuracyInfos.get(i).getName().toString().equals(name)) {
       			   	String date79 = accuracyInfos.get(i).getAccuracy();       	
          			BigDecimal bs2 = new BigDecimal(date79);
          			date79bigDecimal = date79bigDecimal.add(bs2); 
        		   }
        	   }
        	   if( accuracyInfos.get(i).getTime().toString().equals("2017年10月")) {
        		   if(accuracyInfos.get(i).getName().toString().equals(name)) {
       			   	String date710 = accuracyInfos.get(i).getAccuracy();       	
          			BigDecimal bs2 = new BigDecimal(date710);
          			date710bigDecimal = date710bigDecimal.add(bs2); 
        		   }
        	   }
        	   if( accuracyInfos.get(i).getTime().toString().equals("2017年11月")) {
        		   if(accuracyInfos.get(i).getName().toString().equals(name)) {
       			   	String date711 = accuracyInfos.get(i).getAccuracy();       	
          			BigDecimal bs2 = new BigDecimal(date711);
          			date711bigDecimal = date711bigDecimal.add(bs2); 
        		   }
        	   }
        	   if( accuracyInfos.get(i).getTime().toString().equals("2017年12月")) {
        		   if(accuracyInfos.get(i).getName().toString().equals(name)) {
       			   	String date712 = accuracyInfos.get(i).getAccuracy();       	
          			BigDecimal bs2 = new BigDecimal(date712);
          			date712bigDecimal = date712bigDecimal.add(bs2); 
        		   }
        	   }
        	   if( accuracyInfos.get(i).getTime().toString().equals("2018年1月")) {
        		   if(accuracyInfos.get(i).getName().toString().equals(name)) {
       			   	String date81 = accuracyInfos.get(i).getAccuracy();       	
          			BigDecimal bs2 = new BigDecimal(date81);
          			date81bigDecimal = date81bigDecimal.add(bs2); 
        		   }
        	   }
        	   if( accuracyInfos.get(i).getTime().toString().equals("2018年2月")) {
        		   if(accuracyInfos.get(i).getName().toString().equals(name)) {
       			   	String date82 = accuracyInfos.get(i).getAccuracy();       	
          			BigDecimal bs2 = new BigDecimal(date82);
          			date82bigDecimal = date82bigDecimal.add(bs2); 
        		   }
        	   }
        	   
        	   
        	  
           }
           	dataset.addValue(date77bigDecimal, "2017年7月", "2017年7月");
           	dataset.addValue(date78bigDecimal, "2017年8月", "2017年8月");
           	dataset.addValue(date79bigDecimal, "2017年9月", "2017年9月");
           	dataset.addValue(date710bigDecimal, "2017年10月", "2017年10月");
           	dataset.addValue(date711bigDecimal, "2017年11月", "2017年11月");
           	dataset.addValue(date712bigDecimal, "2017年12月", "2017年12月");
           	dataset.addValue(date81bigDecimal, "2018年1月", "2018年1月");
           	dataset.addValue(date82bigDecimal, "2018年2月", "2018年2月");
           
           return dataset;
}
public ChartPanel getChartPanel(){
	return frame1;
	
}

}
