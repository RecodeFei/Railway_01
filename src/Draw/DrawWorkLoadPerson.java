package Draw;
import java.awt.Font;
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
import org.jfree.data.statistics.HistogramBin;

import DataBase.BaseController;
import DataBase.BaseInfo;
import DataBase.WorkloadController;
import DataBase.WorkloadInfo;
import Display.WorkLoadInfoDisplay;

public class DrawWorkLoadPerson{
	ChartPanel frame1;
	String person;
	public  DrawWorkLoadPerson() throws Exception{
		CategoryDataset dataset = getDataSet();
		WorkLoadInfoDisplay workLoadInfoDisplay = new WorkLoadInfoDisplay();
		
        JFreeChart chart = ChartFactory.createBarChart3D(
       		                 "个人", // 图表标题
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
           List<WorkloadInfo> workloadInfos = new WorkloadController().query();
           int person76=0;
           int person77=0;
           int person78=0;
           int person79=0;
           int person710=0;
           int person711=0;
           int person712=0;
           int person81=0;
           int person82=0;
           int person83=0;
           for(int i=0; i<workloadInfos.size(); i++) {
        	   //System.out.println(baseInfos.get(i).getEducation());
        	   if( workloadInfos.get(i).getTime().toString().equals("2017年6月")) {
        		   if(workloadInfos.get(i).getName().toString().equals("杨刚")) {
        			   person76 =Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        	   }
        	   if( workloadInfos.get(i).getTime().toString().equals("2017年7月")) {
        		   if(workloadInfos.get(i).getName().toString().equals("杨刚")) {
        			   person77 =Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        	   }
        	   if( workloadInfos.get(i).getTime().toString().equals("2017年8月")) {
        		   if(workloadInfos.get(i).getName().toString().equals("杨刚")) {
        			   person78 =Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        	   }
        	   if( workloadInfos.get(i).getTime().toString().equals("2017年9月")) {
        		   if(workloadInfos.get(i).getName().toString().equals("杨刚")) {
        			   person79 =Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        	   }
        	   if( workloadInfos.get(i).getTime().toString().equals("2017年10月")) {
        		   if(workloadInfos.get(i).getName().toString().equals("杨刚")) {
        			   person710 =Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        	   }
        	   if( workloadInfos.get(i).getTime().toString().equals("2017年11月")) {
        		   if(workloadInfos.get(i).getName().toString().equals("杨刚")) {
        			   person711 =Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        	   }
        	   if( workloadInfos.get(i).getTime().toString().equals("2017年12月")) {
        		   if(workloadInfos.get(i).getName().toString().equals("杨刚")) {
        			   person712 =Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        	   }
        	   if( workloadInfos.get(i).getTime().toString().equals("2018年1月")) {
        		   if(workloadInfos.get(i).getName().toString().equals("杨刚")) {
        			   person81 =Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        	   }
        	   if( workloadInfos.get(i).getTime().toString().equals("2018年2月")) {
        		   if(workloadInfos.get(i).getName().toString().equals("杨刚")) {
        			   person82 =Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        	   }
        	   if( workloadInfos.get(i).getTime().toString().equals("2018年3月")) {
        		   if(workloadInfos.get(i).getName().toString().equals("杨刚")) {
        			   person83 =Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        	   }
        	   
        	   
        	  
           }
           	dataset.addValue(person76, "2017年6月", "2017年6月");
           	dataset.addValue(person77, "2017年7月", "2017年7月");
           	dataset.addValue(person78, "2017年8月", "2017年8月");
           	dataset.addValue(person79, "2017年9月", "2017年9月");
           	dataset.addValue(person710, "2017年10月", "2017年10月");
           	dataset.addValue(person711, "2017年11月", "2017年11月");
           	dataset.addValue(person712, "2017年12月", "2017年12月");
           	dataset.addValue(person81, "2018年1月", "2018年1月");
           	dataset.addValue(person82, "2018年2月", "2018年2月");
           	dataset.addValue(person83, "2018年3月", "2018年3月");
           
           return dataset;
}
public ChartPanel getChartPanel(){
	return frame1;
	
}

}
