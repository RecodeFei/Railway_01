package Draw;
import java.awt.Font;
import java.math.BigDecimal;
import java.math.RoundingMode;
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

public class DrawAccuracyTime {
	ChartPanel frame1;
	public  DrawAccuracyTime() throws Exception{
		CategoryDataset dataset = getDataSet();
        JFreeChart chart = ChartFactory.createBarChart3D(
       		                 "月准确率", // 图表标题
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
           	String date77=null;
           	int date77num = 0;
           	BigDecimal date77bigDecimal = new BigDecimal(0);
           	
           	String date78=null;           	
           	int date78num = 0;
           	BigDecimal date78bigDecimal = new BigDecimal(0);
           	
           	String date79=null;
           	int date79num = 0;
           	BigDecimal date79bigDecimal = new BigDecimal(0);           	
           	
           	String date710=null;
           	int date710num = 0;
           	BigDecimal date710bigDecimal = new BigDecimal(0);
           	
           	String date711=null;
           	int date711num = 0;
           	BigDecimal date711bigDecimal = new BigDecimal(0);
           	
           	String date712=null;
           	int date712num = 0;
           	BigDecimal date712bigDecimal = new BigDecimal(0);
           	
           	String date81=null;
           	int date81num = 0;
           	BigDecimal date81bigDecimal = new BigDecimal(0);
           	
           	String date82=null;
           	int date82num = 0;
           	BigDecimal date82bigDecimal = new BigDecimal(0);


           for(int i=0; i<accuracyInfos.size(); i++) {
        	   //System.out.println(baseInfos.get(i).getEducation());
        	   if(accuracyInfos.get(i).getTime().toString().equals("2017年7月")) {
       		   	date77 = accuracyInfos.get(i).getAccuracy();       	
       			BigDecimal bs2 = new BigDecimal(date77);
       			date77bigDecimal = date77bigDecimal.add(bs2);     			
       			date77num = date77num + 1;
        	   }
        	   if(accuracyInfos.get(i).getTime().toString().equals("2017年8月")) {
          		   	date78 = accuracyInfos.get(i).getAccuracy();       	
           			BigDecimal bs2 = new BigDecimal(date78);
           			date78bigDecimal = date78bigDecimal.add(bs2);     			
           			date78num = date78num + 1;
        	   }
        	   if(accuracyInfos.get(i).getTime().toString().equals("2017年9月")) {
          		   	date79 = accuracyInfos.get(i).getAccuracy();       	
           			BigDecimal bs2 = new BigDecimal(date79);
           			date79bigDecimal = date79bigDecimal.add(bs2);     			
           			date79num = date79num + 1;
        	   }
        	   if(accuracyInfos.get(i).getTime().toString().equals("2017年10月")) {
          		   	date710 = accuracyInfos.get(i).getAccuracy();       	
           			BigDecimal bs2 = new BigDecimal(date710);
           			date710bigDecimal = date710bigDecimal.add(bs2);     			
           			date710num = date710num + 1;
        	   }
        	   if(accuracyInfos.get(i).getTime().toString().equals("2017年11月")) {
          		   	date711 = accuracyInfos.get(i).getAccuracy();       	
           			BigDecimal bs2 = new BigDecimal(date711);
           			date711bigDecimal = date711bigDecimal.add(bs2);     			
           			date711num = date711num + 1;
        	   }
        	   if(accuracyInfos.get(i).getTime().toString().equals("2017年12月")) {
          		   	date712 = accuracyInfos.get(i).getAccuracy();       	
           			BigDecimal bs2 = new BigDecimal(date712);
           			date712bigDecimal = date712bigDecimal.add(bs2);     			
           			date712num = date712num + 1;
        	   }
        	   if(accuracyInfos.get(i).getTime().toString().equals("2018年1月")) {
          		   	date81 = accuracyInfos.get(i).getAccuracy();       	
           			BigDecimal bs2 = new BigDecimal(date81);
           			date81bigDecimal = date81bigDecimal.add(bs2);     			
           			date81num = date81num + 1;
        	   }
        	   if(accuracyInfos.get(i).getTime().toString().equals("2018年2月")) {
          		   	date82 = accuracyInfos.get(i).getAccuracy();       	
           			BigDecimal bs2 = new BigDecimal(date82);
           			date82bigDecimal = date82bigDecimal.add(bs2);     			
           			date82num = date82num + 1;
        	   }
        	  
           }
           BigDecimal date77BigDecimal = new BigDecimal(date77num);
           BigDecimal date78BigDecimal = new BigDecimal(date78num);
           BigDecimal date79BigDecimal = new BigDecimal(date79num);
           BigDecimal date710BigDecimal = new BigDecimal(date710num);
           BigDecimal date711BigDecimal = new BigDecimal(date711num);
           BigDecimal date712BigDecimal = new BigDecimal(date712num);
           BigDecimal date81BigDecimal = new BigDecimal(date81num);
           BigDecimal date82BigDecimal = new BigDecimal(date82num);

           
           dataset.addValue(date77bigDecimal.divide(date77BigDecimal, 5, RoundingMode.HALF_UP), "2017年7月", "2017年7月");
           dataset.addValue(date78bigDecimal.divide(date78BigDecimal, 5, RoundingMode.HALF_UP), "2017年8月", "2017年8月");
           dataset.addValue(date79bigDecimal.divide(date79BigDecimal, 5, RoundingMode.HALF_UP), "2017年9月", "2017年9月");
           dataset.addValue(date710bigDecimal.divide(date710BigDecimal, 5, RoundingMode.HALF_UP), "2017年10月", "2017年10月");
           dataset.addValue(date711bigDecimal.divide(date711BigDecimal, 5, RoundingMode.HALF_UP), "2017年11月", "2017年11月");
           dataset.addValue(date712bigDecimal.divide(date712BigDecimal, 5, RoundingMode.HALF_UP), "2017年12月", "2017年12月");
           dataset.addValue(date81bigDecimal.divide(date81BigDecimal, 5, RoundingMode.HALF_UP), "2018年1月", "2018年1月");
           dataset.addValue(date82bigDecimal.divide(date82BigDecimal, 5, RoundingMode.HALF_UP), "2018年2月", "2018年2月");

           
           return dataset;
}
public ChartPanel getChartPanel(){
	return frame1;
	
}
}
