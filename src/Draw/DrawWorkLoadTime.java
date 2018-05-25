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

import DataBase.WorkloadController;
import DataBase.WorkloadInfo;

public class DrawWorkLoadTime {
	ChartPanel frame1;
	public  DrawWorkLoadTime() throws Exception{
		CategoryDataset dataset = getDataSet();
        JFreeChart chart = ChartFactory.createBarChart3D(
       		                 "月工作量", // 图表标题
                            "班组", // 目录轴的显示标签
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
           	int date76 =0;
           	int date77=0;
           	int date78=0;
           	int date79=0;
           	int date710=0;
           	int date711=0;
           	int date712=0;
           	int date81=0;
           	int date82=0;
           	int date83=0;
           for(int i=0; i<workloadInfos.size(); i++) {
        	   //System.out.println(baseInfos.get(i).getEducation());
        	   if(workloadInfos.get(i).getTime().toString().equals("2017年6月")) {
        		   date76 +=Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        	   }
        	   if(workloadInfos.get(i).getTime().toString().equals("2017年7月")) {
        		   date77 +=Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        	   }
        	   if(workloadInfos.get(i).getTime().toString().equals("2017年8月")) {
        		   date78 +=Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        	   }
        	   if(workloadInfos.get(i).getTime().toString().equals("2017年9月")) {
        		   date79 +=Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        	   }
        	   if(workloadInfos.get(i).getTime().toString().equals("2017年10月")) {
        		   date710 +=Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        	   }
        	   if(workloadInfos.get(i).getTime().toString().equals("2017年11月")) {
        		   date711 +=Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        	   }
        	   if(workloadInfos.get(i).getTime().toString().equals("2017年12月")) {
        		   date712 +=Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        	   }
        	   if(workloadInfos.get(i).getTime().toString().equals("2018年1月")) {
        		   date81 +=Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        	   }
        	   if(workloadInfos.get(i).getTime().toString().equals("2018年2月")) {
        		   date82 +=Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        	   }
        	   if(workloadInfos.get(i).getTime().toString().equals("2018年3月")) {
        		   date83 +=Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        	   }
        	  
           }
           
           dataset.addValue(date76, "2017年6月", "2017年6月");
           dataset.addValue(date77, "2017年7月", "2017年7月");
           dataset.addValue(date78, "2017年8月", "2017年8月");
           dataset.addValue(date79, "2017年9月", "2017年9月");
           dataset.addValue(date710, "2017年10月", "2017年10月");
           dataset.addValue(date711, "2017年11月", "2017年11月");
           dataset.addValue(date712, "2017年12月", "2017年12月");
           dataset.addValue(date81, "2018年1月", "2018年1月");
           dataset.addValue(date82, "2018年2月", "2018年2月");
           dataset.addValue(date83, "2018年3月", "2018年3月");

           
           return dataset;
}
public ChartPanel getChartPanel(){
	return frame1;
	
}
}
