package Display;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
import DataBase.FindfaultController;
import DataBase.FindfaultInfo;
import Draw.DrawFindFaultmainClass;

public class FindFaultInfoDisplay {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public void FindFaultInfoShow() throws Exception {
		// TODO Auto-generated method stub
		final JFrame f = new JFrame("5T车间人员发现故障情况");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(new BorderLayout());
        
        final FindFaultInfoModel findFaultInfoModel = new FindFaultInfoModel();
        final JTable t = new JTable(findFaultInfoModel);
        JPanel p = new JPanel();
        JLabel lName = new JLabel("关键字");
        final JTextField tfName = new JTextField("");
        JButton QueryFindFaultInfoBtn = new JButton("查询");
        JButton DrawFindFaultBtn = new JButton("图显");
        tfName.setPreferredSize(new Dimension(400, 30));
        QueryFindFaultInfoBtn.setPreferredSize(new Dimension(100,30));
        DrawFindFaultBtn.setPreferredSize(new Dimension(100, 30));
        
        p.add(lName);
        p.add(tfName);
        p.add(QueryFindFaultInfoBtn);
        p.add(DrawFindFaultBtn);
        
        DrawFindFaultBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					new DrawFindFaultmainClass().DrawFindFaultDisplay();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
        
        QueryFindFaultInfoBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String QueryFindFaultInfoText = tfName.getText();			
				new FileWriter().wirte("findfault.txt", QueryFindFaultInfoText);
				if (QueryFindFaultInfoText.length() == 0) {
					try {
						List<FindfaultInfo> findfaultInfos = new FindfaultController().query();
						findFaultInfoModel.findfaultInfos = findfaultInfos;
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
					
					FindfaultController findfaultController = new FindfaultController();
					List<FindfaultInfo> list = null;
					try {
						list = findfaultController.get(params);
						findFaultInfoModel.findfaultInfos = list;
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
 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);

	}
}

