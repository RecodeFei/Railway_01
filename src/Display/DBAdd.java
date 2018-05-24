package Display;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DBAdd extends JFrame {

	private JPanel contentPane;
	private JTextField baseinfoText;
	private JTextField workloadText;
	private JTextField findfaultText;
	private JTextField accuracyText;
	private JTextField importText;
	DBAddModel dbAddModel = new DBAddModel();

	/**
	 * Launch the application.
	 */
	public void DBAddDisplay() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DBAdd frame = new DBAdd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public String FilePath(){
		String filePath = null;
		JFileChooser fileChooser = new JFileChooser("/home/feikuang/workspace/Railway/doc");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int returnVal = fileChooser.showOpenDialog(fileChooser);
                        if(returnVal == JFileChooser.APPROVE_OPTION){       
           filePath = fileChooser.getSelectedFile().getAbsolutePath();//这个就是你选择的文件夹的路径
            
                        }
		return filePath;
	}

	/**
	 * Create the frame.
	 */
	public DBAdd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("检车员基本信息表");
		
		baseinfoText = new JTextField();
		baseinfoText.setEnabled(false);
		baseinfoText.setColumns(10);
		
		JLabel label = new JLabel("检车员工作量统计表");
		
		JLabel label_1 = new JLabel("检车员发现故障情况");
		
		JLabel label_2 = new JLabel("检车员标注故障准确率");
		
		JLabel label_3 = new JLabel("检车员漏检数据分析表");
		
		workloadText = new JTextField();
		workloadText.setEnabled(false);
		workloadText.setColumns(10);
		
		findfaultText = new JTextField();
		findfaultText.setEnabled(false);
		findfaultText.setColumns(10);
		
		accuracyText = new JTextField();
		accuracyText.setEnabled(false);
		accuracyText.setColumns(10);
		
		importText = new JTextField();
		importText.setEnabled(false);
		importText.setColumns(10);
		
		JButton workloadBtn = new JButton("添加");
		
		JButton findfaultBtn = new JButton("添加");
		
		JButton accuracyBtn = new JButton("添加");
		
		JButton importBtn = new JButton("添加");
		
		JButton baseinfoBtn = new JButton("添加");
		
		baseinfoBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		        baseinfoText.setText(FilePath());
			}
		});
		
		workloadBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		        workloadText.setText(FilePath());
			}
		});
		
		findfaultBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				findfaultText.setText(FilePath());
			}
		});
		
		accuracyBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				accuracyText.setText(FilePath());
			}
		});
		
		importBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				importText.setText(FilePath());
			}
		});
		
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if(!baseinfoText.getText().equals("")){
						dbAddModel.AddBaseInfoToDb(baseinfoText.getText());
					}
					if(!workloadText.getText().equals("")){
						dbAddModel.AddWorkloadToDb(workloadText.getText());
					}
					if(!findfaultText.getText().equals("")){
						dbAddModel.AddFindFaultToDb(findfaultText.getText());
					}
					if(!accuracyText.getText().equals("")){
						dbAddModel.AddAccuracyToDb(accuracyText.getText());
					}
					if(!importText.getText().equals("")){
						dbAddModel.addImportToDb(importText.getText());
					}			
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(importText, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(importBtn, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addGap(12))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(accuracyText, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(accuracyBtn, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addGap(12))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(findfaultText, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(findfaultBtn, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addGap(12))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(workloadText, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(workloadBtn, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(baseinfoText, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(baseinfoBtn, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)))
							.addGap(6))))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(311, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(baseinfoText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(baseinfoBtn))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(workloadText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(workloadBtn))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(findfaultText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(findfaultBtn))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(accuracyText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(accuracyBtn))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(importText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(importBtn))
					.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
					.addComponent(btnNewButton))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
