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

import DataBase.BaseController;
import DataBase.BaseInfo;
import Draw.DrawBaseInfomainClass;

public class BaseInfoDisaply {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public void BaseinfoShow() throws Exception {
		// TODO Auto-generated method stub
		 int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		 int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		 int windowsWedth = 700;
		 int windowsHeight = 400;
		final JFrame f = new JFrame("5T车间人员基本信息");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(new BorderLayout());
		
        final BaseInfoModel baseInfoModel = new BaseInfoModel();
        final JTable t = new JTable(baseInfoModel);
        JPanel p = new JPanel();
        JLabel lName = new JLabel("关键字");
        final JTextField tfName = new JTextField("");
        JButton QueryBaseInfoBtn = new JButton("查询");
        JButton DrawBaseInforBtn = new JButton("图显");
        tfName.setPreferredSize(new Dimension(400, 30));
        QueryBaseInfoBtn.setPreferredSize(new Dimension(100,30));
        DrawBaseInforBtn.setPreferredSize(new Dimension(100, 30));
        
        p.add(lName);
        p.add(tfName);
        p.add(QueryBaseInfoBtn);
        p.add(DrawBaseInforBtn);
        
        DrawBaseInforBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					new DrawBaseInfomainClass().DrawBaseDisplay();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
        
        QueryBaseInfoBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String QueryBaseInfoText = tfName.getText();
				if (QueryBaseInfoText.length() == 0) {
					try {
						List<BaseInfo> baseInfos = new BaseController().query();
						baseInfoModel.baseinfos = baseInfos;
						t.updateUI();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					List<Map<String, Object>> params=new ArrayList<Map<String,Object>>();
					Map<String, Object> param=new HashMap<String, Object>();
					param.put("name", "name");
					param.put("rela", "=");//以键值对的方式上传参数
					param.put("value", tfName.getText().toString());//注意加上单引号，因为这个变量是字符串的形式
					params.add(param);
					
					BaseController dbControllerByname = new BaseController();
					List<BaseInfo> list = null;
					try {
						list = dbControllerByname.get(params);
						baseInfoModel.baseinfos = list;
						t.updateUI();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		
				}
				}
				
		});
        
        t.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane sp = new JScrollPane(t);
        f.add(p, BorderLayout.NORTH);
        f.add(sp, BorderLayout.CENTER);
        t.getColumnModel().getColumn(0).setPreferredWidth(20);
        f.setBounds((-width) / 2,
                (-height) / 2, windowsWedth, windowsHeight);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        f.setVisible(true);

	}
}
