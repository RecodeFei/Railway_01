package Display;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import tools.FileWriter;
import DataBase.AccuracyController;
import DataBase.AccuracyInfo;
import DataBase.WorkloadController;
import DataBase.WorkloadInfo;
import Draw.DrawAccuracymainClass;
import Draw.DrawWorkLoadmainClass;

public class AccuracyInfoDisplay {
	String text;
	/**
	 * @param args
	 * @throws Exception 
	 */
	JTextField tfName = new JTextField("");
	public void AccuracyInfoShow() throws Exception {
		// TODO Auto-generated method stub
		final JFrame f = new JFrame("5T车间人员准确率");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(new BorderLayout());
		 int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		 int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		 int windowsWedth = 700;
		 int windowsHeight = 400;
        
        final AccuracyInfoModel accuracyInfoModel = new AccuracyInfoModel();
        final JTable t = new JTable(accuracyInfoModel);
        JPanel p = new JPanel();
        
        JLabel lName = new JLabel("关键字");
        JButton QueryAccuracyBtn = new JButton("查询");
        JButton DrawAccuracyInfoBtn = new JButton("图显");
        tfName.setPreferredSize(new Dimension(400, 30));
        QueryAccuracyBtn.setPreferredSize(new Dimension(100,30));
        DrawAccuracyInfoBtn.setPreferredSize(new Dimension(100, 30));
        
        p.add(lName);
        p.add(tfName);
        p.add(QueryAccuracyBtn);
        p.add(DrawAccuracyInfoBtn);
        
        
        DrawAccuracyInfoBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					new DrawAccuracymainClass().DrawAccuracyDisplay();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
        
        QueryAccuracyBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String QueryAccuracyInfoText = tfName.getText();
				
				if (QueryAccuracyInfoText.length() == 0) {
					try {
						new FileWriter().wirte("fccuracy.txt", "''");
						List<AccuracyInfo> accuracyInfos = new AccuracyController().query();
						accuracyInfoModel.accuracyInfos = accuracyInfos;
						t.updateUI();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}else {
					new FileWriter().wirte("fccuracy.txt", QueryAccuracyInfoText);
					List<Map<String, Object>> params=new ArrayList<Map<String,Object>>();
					Map<String, Object> param=new HashMap<String, Object>();
					param.put("name", "name");
					param.put("rela", "=");//以键值对的方式上传参数
					param.put("value", tfName.getText().toString());//注意加上单引号，因为这个变量是字符串的形式
					params.add(param);
					
					AccuracyController dbControllerByname = new AccuracyController();
					List<AccuracyInfo> list = null;
					try {
						list = dbControllerByname.get(params);
						accuracyInfoModel.accuracyInfos= list;
						t.updateUI();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		
				}
				}
				
		});
        
        //t.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane sp = new JScrollPane(t);
        f.add(p, BorderLayout.NORTH);
        f.add(sp, BorderLayout.CENTER);
        t.getColumnModel().getColumn(0).setPreferredWidth(20);
        f.setBounds((width -windowsWedth) / 2,
                (height - windowsHeight) / 2, windowsWedth, windowsHeight);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 
        f.setVisible(true);

	}

}

