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

public class DrawWorkLoadInfoTotal {
	ChartPanel frame1;
	public  DrawWorkLoadInfoTotal() throws Exception{
		CategoryDataset dataset = getDataSet();
        JFreeChart chart = ChartFactory.createBarChart3D(
       		                 "检车员工作量统计总量", // 图表标题
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
           int yiban = 0;
           int erban = 0;
           int sanban = 0;
           int siban = 0;
           for(int i=0; i<workloadInfos.size(); i++) {
        	   //System.out.println(baseInfos.get(i).getEducation());
        	   if(workloadInfos.get(i).getTeam().toString().equals("一班")) {
        		   yiban +=Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        	   }
        	   if(workloadInfos.get(i).getTeam().toString().equals("二班")) {
        		   erban += Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        	   }
        	   if(workloadInfos.get(i).getTeam().toString().equals("三班")) {
        		   sanban += Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        	   }
        	   if(workloadInfos.get(i).getTeam().toString().equals("四班")) {
        		   siban += Double.valueOf(workloadInfos.get(i).getNum().toString()).intValue();
        	   }
        	  
           }
           dataset.addValue(yiban, "一班", "一班");
           dataset.addValue(erban, "二班", "二班");
           dataset.addValue(sanban, "三班", "三班");
           dataset.addValue(siban, "四班", "四班");
           
           return dataset;
}
public ChartPanel getChartPanel(){
	return frame1;
	
}
}
