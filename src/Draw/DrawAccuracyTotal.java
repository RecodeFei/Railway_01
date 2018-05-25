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

public class DrawAccuracyTotal {
	ChartPanel frame1;
	public  DrawAccuracyTotal() throws Exception{
		CategoryDataset dataset = getDataSet();
        JFreeChart chart = ChartFactory.createBarChart3D(
       		                 "班组总平均准确率", // 图表标题
                            "班组", // 目录轴的显示标签
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
           String yiban = null;          
           int yibannum = 0;
           BigDecimal bsyiban = new BigDecimal(0);
           String erban = null;
           int erbannum = 0;
           BigDecimal bserban = new BigDecimal(0);
           String sanban = null;
           int sanbannum = 0;
           BigDecimal bssanban = new BigDecimal(0);
           String siban = null;
           int sibannum = 0;
           BigDecimal bssiban = new BigDecimal(0);
           for(int i=0; i<accuracyInfos.size(); i++) {
        	   //System.out.println(baseInfos.get(i).getEducation());
        	   if(accuracyInfos.get(i).getTeam().toString().equals("一班")) {
        		   	yiban = accuracyInfos.get(i).getAccuracy();       	
        			BigDecimal bs2 = new BigDecimal(yiban);
        			bsyiban = bsyiban.add(bs2);     			
        			yibannum = yibannum + 1;
        	   }
        	   if(accuracyInfos.get(i).getTeam().toString().equals("二班")) {
        		   	erban = accuracyInfos.get(i).getAccuracy();       	
       				BigDecimal bs2 = new BigDecimal(erban);
       				bserban = bserban.add(bs2);     			
       				erbannum = erbannum + 1;
        	   }
        	   if(accuracyInfos.get(i).getTeam().toString().equals("三班")) {
        		   	sanban = accuracyInfos.get(i).getAccuracy();       	
       				BigDecimal bs2 = new BigDecimal(sanban);
       				bssanban = bssanban.add(bs2);     			
       				sanbannum = sanbannum + 1;
        	   }
        	   if(accuracyInfos.get(i).getTeam().toString().equals("四班")) {
        		   	siban = accuracyInfos.get(i).getAccuracy();       	
       				BigDecimal bs2 = new BigDecimal(siban);
       				bssiban = bssiban.add(bs2);     			
       				sibannum = sibannum + 1;
        	   }
        	  
           }
           BigDecimal yibanBigDecimal = new BigDecimal(yibannum);
           BigDecimal erbanBigDecimal = new BigDecimal(erbannum);
           BigDecimal sanbanBigDecimal = new BigDecimal(sanbannum);
           BigDecimal sibanigDecimal = new BigDecimal(sibannum);
           
           dataset.addValue(bsyiban.divide(yibanBigDecimal, 5, RoundingMode.HALF_UP), "一班", "一班");
           dataset.addValue(bserban.divide(erbanBigDecimal, 5, RoundingMode.HALF_UP), "二班", "二班");
           dataset.addValue(bssanban.divide(sanbanBigDecimal, 5, RoundingMode.HALF_UP), "三班", "三班");
           dataset.addValue(bssiban.divide(sibanigDecimal, 5, RoundingMode.HALF_UP), "四班", "四班");
           
           return dataset;
}
public ChartPanel getChartPanel(){
	return frame1;
	
}
}
