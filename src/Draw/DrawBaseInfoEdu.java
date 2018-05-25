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

import DataBase.BaseController;
import DataBase.BaseInfo;

public class DrawBaseInfoEdu {
	ChartPanel frame1;
	public  DrawBaseInfoEdu() throws Exception{
		CategoryDataset dataset = getDataSet();
        JFreeChart chart = ChartFactory.createBarChart3D(
       		                 "文化程度", // 图表标题
                            "文化程度", // 目录轴的显示标签
                            "人数", // 数值轴的显示标签
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
           List<BaseInfo> baseInfos = new BaseController().query();
           int dazhuan = 0;
           int zhongzhuan = 0;
           int daxue = 0;
           int gaozhong = 0;
           int jixiao = 0;
           for(int i=0; i<baseInfos.size(); i++) {
        	   //System.out.println(baseInfos.get(i).getEducation());
        	   if(baseInfos.get(i).getEducation().toString().equals("大专")) {
        		   dazhuan += 1;   		   
        	   }
        	   if(baseInfos.get(i).getEducation().toString().equals("中专")) {
        		   zhongzhuan += 1;
        	   }
        	   if(baseInfos.get(i).getEducation().toString().equals("大学")) {
        		   daxue += 1;
        	   }
        	   if(baseInfos.get(i).getEducation().toString().equals("高中")) {
        		   gaozhong += 1;
        	   }
        	   if(baseInfos.get(i).getEducation().toString().equals("技校")) {
        		   jixiao += 1;
        	   }
           }
           dataset.addValue(dazhuan, "大专", "大专");
           dataset.addValue(zhongzhuan, "中专", "中专");
           dataset.addValue(daxue, "大学", "大学");
           dataset.addValue(gaozhong, "高中", "高中");
           dataset.addValue(jixiao, "技校", "技校");
           
           return dataset;
}
public ChartPanel getChartPanel(){
	return frame1;
	
}
}
