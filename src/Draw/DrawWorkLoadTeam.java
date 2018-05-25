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

public class DrawWorkLoadTeam {
	ChartPanel frame1;
	public  DrawWorkLoadTeam() throws Exception{
		CategoryDataset dataset = getDataSet();
        JFreeChart chart = ChartFactory.createBarChart3D(
       		                 "班组工作量统计", // 图表标题
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
	   @SuppressWarnings("unused")
	private static CategoryDataset getDataSet() throws Exception {
           DefaultCategoryDataset dataset = new DefaultCategoryDataset();
           List<WorkloadInfo> workloadInfos = new WorkloadController().query();
           int yiban76 = 0;
           int yiban77 =0;
           int yiban78 =0;
           int yiban79 = 0;
           int yiban710 = 0;
           int yiban711 = 0;
           int yiban712 = 0;
           int yiban81  = 0;
           int yiban82 = 0;
           int yiban83 = 0;
           
           int erban76 = 0;
           int erban77 =0;
           int erban78 =0;
           int erban79 = 0;
           int erban710 = 0;
           int erban711 = 0;
           int erban712 = 0;
           int erban81  = 0;
           int erban82 = 0;
           int erban83 = 0;
           
           int sanban76 = 0;
           int sanban77 =0;
           int sanban78 =0;
           int sanban79 = 0;
           int sanban710 = 0;
           int sanban711 = 0;
           int sanban712 = 0;
           int sanban81  = 0;
           int sanban82 = 0;
           int sanban83 = 0;
           
           int siban76 =0;
           int siban77 =0;
           int siban78 =0;
           int siban79 = 0;
           int siban710 = 0;
           int siban711 = 0;
           int siban712 = 0;
           int siban81  = 0;
           int siban82 = 0;
           int siban83 = 0;
           
           for(int i=0; i<workloadInfos.size(); i++) {
        	   //System.out.println(baseInfos.get(i).getEducation());
        	   if(workloadInfos.get(i).getTime().toString().equals("2017年6月")) {
        		   if(workloadInfos.get(i).getTeam().toString().equals("一班")) {
        			   yiban76 += Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        		   if(workloadInfos.get(i).getTeam().toString().equals("二班")) {
        			    erban76 += Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        		   if(workloadInfos.get(i).getTeam().toString().equals("三班")) {
        			   sanban76 += Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        		   if(workloadInfos.get(i).getTeam().toString().equals("四班")) {
        			   siban76 += Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        		   
        	   }
        	   
        	   if(workloadInfos.get(i).getTime().toString().equals("2017年7月")) {
        		   if(workloadInfos.get(i).getTeam().toString().equals("一班")) {
        			   yiban77 += Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        		   if(workloadInfos.get(i).getTeam().toString().equals("二班")) {
        			    erban77 += Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        		   if(workloadInfos.get(i).getTeam().toString().equals("三班")) {
        			   sanban77 += Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        		   if(workloadInfos.get(i).getTeam().toString().equals("四班")) {
        			   siban77 += Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        		   
        	   }
        	   
        	   if(workloadInfos.get(i).getTime().toString().equals("2017年8月")) {
        		   if(workloadInfos.get(i).getTeam().toString().equals("一班")) {
        			   yiban78 += Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        		   if(workloadInfos.get(i).getTeam().toString().equals("二班")) {
        			    erban78 += Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        		   if(workloadInfos.get(i).getTeam().toString().equals("三班")) {
        			   sanban78 += Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        		   if(workloadInfos.get(i).getTeam().toString().equals("四班")) {
        			   siban78 += Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        		   
        	   }
        	   
        	   if(workloadInfos.get(i).getTime().toString().equals("2017年9月")) {
        		   if(workloadInfos.get(i).getTeam().toString().equals("一班")) {
        			   yiban79 += Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        		   if(workloadInfos.get(i).getTeam().toString().equals("二班")) {
        			    erban79 += Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        		   if(workloadInfos.get(i).getTeam().toString().equals("三班")) {
        			   sanban79 += Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        		   if(workloadInfos.get(i).getTeam().toString().equals("四班")) {
        			   siban79 += Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        		   
        	   }
        	   
        	   if(workloadInfos.get(i).getTime().toString().equals("2017年10月")) {
        		   if(workloadInfos.get(i).getTeam().toString().equals("一班")) {
        			   yiban710 += Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        		   if(workloadInfos.get(i).getTeam().toString().equals("二班")) {
        			    erban710 += Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        		   if(workloadInfos.get(i).getTeam().toString().equals("三班")) {
        			   sanban710 += Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        		   if(workloadInfos.get(i).getTeam().toString().equals("四班")) {
        			   siban710 += Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        		   
        	   }
        	   
        	   if(workloadInfos.get(i).getTime().toString().equals("2017年11月")) {
        		   if(workloadInfos.get(i).getTeam().toString().equals("一班")) {
        			   yiban711 += Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        		   if(workloadInfos.get(i).getTeam().toString().equals("二班")) {
        			    erban711 += Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        		   if(workloadInfos.get(i).getTeam().toString().equals("三班")) {
        			   sanban711 += Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        		   if(workloadInfos.get(i).getTeam().toString().equals("四班")) {
        			   siban711 += Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        		   
        	   }
        	   
        	   if(workloadInfos.get(i).getTime().toString().equals("2017年12月")) {
        		   if(workloadInfos.get(i).getTeam().toString().equals("一班")) {
        			   yiban712 += Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        		   if(workloadInfos.get(i).getTeam().toString().equals("二班")) {
        			    erban712 += Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        		   if(workloadInfos.get(i).getTeam().toString().equals("三班")) {
        			   sanban712 += Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        		   if(workloadInfos.get(i).getTeam().toString().equals("四班")) {
        			   siban712 += Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        		   
        	   }
        	   
        	   if(workloadInfos.get(i).getTime().toString().equals("2018年1月")) {
        		   if(workloadInfos.get(i).getTeam().toString().equals("一班")) {
        			   yiban81 += Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        		   if(workloadInfos.get(i).getTeam().toString().equals("二班")) {
        			    erban81 += Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        		   if(workloadInfos.get(i).getTeam().toString().equals("三班")) {
        			   sanban81 += Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        		   if(workloadInfos.get(i).getTeam().toString().equals("四班")) {
        			   siban81 += Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        		   
        	   }
        	   
        	   if(workloadInfos.get(i).getTime().toString().equals("2018年2月")) {
        		   if(workloadInfos.get(i).getTeam().toString().equals("一班")) {
        			   yiban82 += Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        		   if(workloadInfos.get(i).getTeam().toString().equals("二班")) {
        			    erban82 += Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        		   if(workloadInfos.get(i).getTeam().toString().equals("三班")) {
        			   sanban82 += Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        		   if(workloadInfos.get(i).getTeam().toString().equals("四班")) {
        			   siban82 += Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        		   
        	   }
        	   
        	   if(workloadInfos.get(i).getTime().toString().equals("2018年3月")) {
        		   if(workloadInfos.get(i).getTeam().toString().equals("一班")) {
        			   yiban83 += Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        		   if(workloadInfos.get(i).getTeam().toString().equals("二班")) {
        			    erban83 += Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        		   if(workloadInfos.get(i).getTeam().toString().equals("三班")) {
        			   sanban83 += Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        		   if(workloadInfos.get(i).getTeam().toString().equals("四班")) {
        			   siban83 += Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        		   }
        		   
        	   }
        	   	
        	   
        	  
           }
           dataset.addValue(yiban76, "一班", "2017年6月");
           dataset.addValue(erban76, "二班", "2017年6月");
           dataset.addValue(sanban76, "三班", "2017年6月");
           dataset.addValue(sanban76, "四班", "2017年6月");
           
           dataset.addValue(yiban77, "一班", "2017年7月");
           dataset.addValue(erban77, "二班", "2017年7月");
           dataset.addValue(sanban77, "三班", "2017年7月");
           dataset.addValue(sanban77, "四班", "2017年7月");
           
           dataset.addValue(yiban78, "一班", "2017年8月");
           dataset.addValue(erban78, "二班", "2017年8月");
           dataset.addValue(sanban78, "三班", "2017年8月");
           dataset.addValue(sanban78, "四班", "2017年8月");
           
           dataset.addValue(yiban79, "一班", "2017年9月");
           dataset.addValue(erban79, "二班", "2017年9月");
           dataset.addValue(sanban79, "三班", "2017年9月");
           dataset.addValue(sanban79, "四班", "2017年9月");
           
           dataset.addValue(yiban710, "一班", "2017年10月");
           dataset.addValue(erban710, "二班", "2017年10月");
           dataset.addValue(sanban710, "三班", "2017年10月");
           dataset.addValue(sanban710, "四班", "2017年10月");
           
           dataset.addValue(yiban711, "一班", "2017年11月");
           dataset.addValue(erban711, "二班", "2017年11月");
           dataset.addValue(sanban711, "三班", "2017年11月");
           dataset.addValue(sanban711, "四班", "2017年11月");
           
           dataset.addValue(yiban712, "一班", "2017年12月");
           dataset.addValue(erban712, "二班", "2017年12月");
           dataset.addValue(sanban712, "三班", "2017年12月");
           dataset.addValue(sanban712, "四班", "2017年12月");
           
           dataset.addValue(yiban81, "一班", "2018年1月");
           dataset.addValue(erban81, "二班", "2018年1月");
           dataset.addValue(sanban81, "三班", "2018年1月");
           dataset.addValue(sanban81, "四班", "2018年1月");
           
           dataset.addValue(yiban82, "一班", "2018年2月");
           dataset.addValue(erban82, "二班", "2018年2月");
           dataset.addValue(sanban82, "三班", "2018年2月");
           dataset.addValue(sanban82, "四班", "2018年2月");
           
           dataset.addValue(yiban83, "一班", "2018年3月");
           dataset.addValue(erban83, "二班", "2018年3月");
           dataset.addValue(sanban83, "三班", "2018年3月");
           dataset.addValue(sanban83, "四班", "2018年3月");
           
           return dataset;
}
public ChartPanel getChartPanel(){
	return frame1;
	
}
}
