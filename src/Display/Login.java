package Display;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
public class Login extends JFrame implements ActionListener {
	private JPanel jp=new JPanel();
	private JLabel[] jlArray={new JLabel("用户名"),
			new JLabel("密　码"),new JLabel("")};
	private JButton[] jbArray={new JButton("普通用户登陆"),
			new JButton("数据库登陆")};
	private JTextField jtxtName =new JTextField();
	private JPasswordField jtxtPassword= new JPasswordField();
public Login(){
		jp.setLayout(null);
		for(int i=0;i<2;i++){
			jlArray[i].setBounds(30, 20+i*50, 80, 26);
			jbArray[i].setBounds(15+i*150, 130, 120,26);
			jp.add(jlArray[i]);
			jp.add(jbArray[i]);
			jbArray[i].addActionListener(this);
		}
		jtxtName.setBounds(80,20,180,30);
		jp.add(jtxtName);
		jtxtName.addActionListener(this);
		jtxtPassword.setBounds(80,70,180,30);
		jp.add(jtxtPassword);
		jtxtPassword.setEchoChar('*');
		jtxtPassword.addActionListener(this);
		jlArray[2].setBounds(10, 180, 300, 30);
		jp.add(jlArray[2]);
		this.add(jp);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("登陆");
		this.setResizable(false);
		this.setBounds(100, 100, 300, 250);
		this.setVisible(true);
	}
public void actionPerformed(ActionEvent e){
	if(e.getSource()==jtxtName){
		jtxtPassword.requestFocus();
	}else if(e.getSource()==jbArray[1]){
		//数据库连接
		if(jtxtName.getText().equals("")&&String.valueOf(jtxtPassword.getPassword()).equals("")){
			jlArray[2].setText("请在登陆界面输入管理员账号");
		}
		if(jtxtName.getText().equals("root")&&String.valueOf(jtxtPassword.getPassword()).equals("root")){
			//跳转到数据库界面
			DBAdd dbAdd = new DBAdd();
			dbAdd.DBAddDisplay();
		}
		
	}else{
		if(jtxtName.getText().equals("luyuan")&&String.valueOf(jtxtPassword.getPassword()).equals("luyuan") || 
				jtxtName.getText().equals("root")&&String.valueOf(jtxtPassword.getPassword()).equals("root")){
			jlArray[2].setText("登陆成功");
			//跳转主界面
			MainMenu mainMenu = new MainMenu();
			mainMenu.MainMenuDisplay();
			this.dispose();
		}else{
			jlArray[2].setText("登陆错误");
			
			jtxtName.setText("");
			jtxtPassword.setText("");
			jtxtName.requestFocus();
		}
	}
}
public static void main(String[] args) {
	new Login();
}
}

