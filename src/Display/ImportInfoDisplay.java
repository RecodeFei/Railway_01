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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import DataBase.BaseController;
import DataBase.ImportController;
import DataBase.ImportInfo;

public class ImportInfoDisplay {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public void ImportInfoShow() throws Exception {
		// TODO Auto-generated method stub
		final JFrame f = new JFrame("5T车间人员漏检情况");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(new BorderLayout());
        
        final ImportInfoModel ImportInfoModel = new ImportInfoModel();
        final JTable t = new JTable(ImportInfoModel);
        JPanel p = new JPanel();
        JLabel lName = new JLabel("关键字");
        final JTextField tfName = new JTextField("");
        JButton QueryImportInfoBtn = new JButton("查询");
        tfName.setPreferredSize(new Dimension(400, 30));
        QueryImportInfoBtn.setPreferredSize(new Dimension(100,30));
        
        p.add(lName);
        p.add(tfName);
        p.add(QueryImportInfoBtn);
        
        QueryImportInfoBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String QueryImportInfoText = tfName.getText();
				if (QueryImportInfoText.length() == 0) {
					JOptionPane.showMessageDialog(f, "关键字不能为空");//弹出对话框提示用户
					//名称输入框获取焦点
					tfName.grabFocus();
				}
				List<Map<String, Object>> params=new ArrayList<Map<String,Object>>();
				Map<String, Object> param=new HashMap<String, Object>();
				param.put("name", "name");
				param.put("rela", "=");//以键值对的方式上传参数
				param.put("value", tfName.getText().toString());//注意加上单引号，因为这个变量是字符串的形式
				params.add(param);
				
				ImportController dbControllerByname = new ImportController();
				List<ImportInfo> list = null;
				try {
					list = dbControllerByname.get(params);
					ImportInfoModel.ImportInfos = list;
					t.updateUI();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}		
			}
		});
        
        t.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane sp = new JScrollPane(t);
        f.add(p, BorderLayout.NORTH);
        f.add(sp, BorderLayout.CENTER);
        t.getColumnModel().getColumn(0).setPreferredWidth(20);
 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);

	}
}

