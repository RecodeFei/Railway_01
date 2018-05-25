package Display;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
//import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class MainMenu extends JFrame {

	private JPanel contentPane;
	private JTextField txtt;
	@SuppressWarnings("unused")
	private JButton BaseInfoButton;

	/**
	 * Launch the application.
	 * @return 
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	public void MainMenuDisplay(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		BaseInfoButton = new JButton();
		
		txtt = new JTextField();
		txtt.setEnabled(false);
		txtt.setText("5T车间报表程序");
		txtt.setHorizontalAlignment(JTextField.CENTER);
		
		txtt.setColumns(10);
		
		JButton BaseInfoBtn = new JButton("人员基本信息");
		BaseInfoBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BaseInfoDisaply baseInfoDisplay = new BaseInfoDisaply();
				try {
					baseInfoDisplay.BaseinfoShow();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		JButton FindFaultBtn = new JButton("发现故障情况");
		FindFaultBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FindFaultInfoDisplay findFaultInfoDisplay = new FindFaultInfoDisplay();
				try {
					findFaultInfoDisplay.FindFaultInfoShow();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton WorkLoadBtn = new JButton("工作量表统计");
		WorkLoadBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				WorkLoadInfoDisplay workLoadInfoDisplay = new WorkLoadInfoDisplay();
				try {
					workLoadInfoDisplay.WorkLoadInfoShow();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton AccuracyBtn = new JButton("故障表准确率");
		AccuracyBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AccuracyInfoDisplay accuracyInfoDisplay = new AccuracyInfoDisplay();
				try {
					accuracyInfoDisplay.AccuracyInfoShow();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton ImportBtn = new JButton("漏检数据统计");
		ImportBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ImportInfoDisplay importInfoDisplay = new ImportInfoDisplay();
				try {
					importInfoDisplay.ImportInfoShow();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(WorkLoadBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(29)
							.addComponent(AccuracyBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(33)
							.addComponent(ImportBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(BaseInfoBtn, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
							.addGap(179)
							.addComponent(FindFaultBtn, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)))
					.addGap(0))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(110)
					.addComponent(txtt, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
					.addGap(113))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(txtt, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(45)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(BaseInfoBtn, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(FindFaultBtn, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(WorkLoadBtn, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addComponent(AccuracyBtn, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
						.addComponent(ImportBtn, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
					.addGap(61))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
