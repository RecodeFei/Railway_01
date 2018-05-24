package Display;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import tools.testDB;
//序号	班组	姓名	性别	出生年月	年龄	文化程度	参加工作时间	技术职称	职务	政治面貌	技能等级	技术资格	取证时间	第一次复审时间	第二次复审时间	第三次复审时间	技术资格	取证时间	第一次复审时间	第二次复审时间	第三次复审时间		
import DataBase.BaseHandle;
import DataBase.BaseInfo;


public class BaseInfoModel extends AbstractTableModel{
	public BaseInfoModel() throws Exception{} 
    String[] columnNames = new String[] {"id","班组","姓名", "性别", "出生年月","年龄","文化程度","参加工作时间", "技术职称", "职务",
    									"政治面貌","技能等级","技术资格","取证时间","第一次复审时间","第二次复审时间",
    									"第三次复审时间","技术资格","取证时间","第一次复审时间","第二次复审时间","第三次复审时间"};
    
    BaseHandle dbControllerqueryall = new BaseHandle();
	List<BaseInfo> baseinfos = dbControllerqueryall.query();
	
	
	
    // 返回一共有多少行
    public int getRowCount() {
        // TODO Auto-generated method stub
        return baseinfos.size();
    }
 
    // 返回一共有多少列
    public int getColumnCount() {
        // TODO Auto-generated method stub
        return columnNames.length;
    }
 
    // 获取每一列的名称
    public String getColumnName(int columnIndex) {
        // TODO Auto-generated method stub
        return columnNames[columnIndex];
    }
    
    // 单元格是否可以修改
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

 
    // 每一个单元格里的值
    public Object getValueAt(int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub
        BaseInfo baseinfo = baseinfos.get(rowIndex);
        if (0 == columnIndex)
        	return baseinfo.getId();
        if (1 == columnIndex)
            return baseinfo.getTeam();
        if (2 == columnIndex)
            return baseinfo.getName();
        if (3 == columnIndex)
            return baseinfo.getSex();
        if (4 == columnIndex)
            return baseinfo.getBorn();
        if (5 == columnIndex)
        	return baseinfo.getAge();
        if (6 == columnIndex)
        	return baseinfo.getEducation();
        if (7 == columnIndex)
        	return baseinfo.getWork_time();
        if (8 == columnIndex)
        	return baseinfo.getTechnical_title();
        if (9 == columnIndex)
        	return baseinfo.getPost();
        if (10 == columnIndex) 
        	return baseinfo.getPolitical_outlook();
        if (11 == columnIndex)
        	return baseinfo.getSkill_level();
        if (12 == columnIndex)
        	return baseinfo.getTechnical_qualification_one();
        if (13 == columnIndex)
        	return baseinfo.getForensics_time_one();
        if (14 == columnIndex)
        	return baseinfo.getFirst_review_time_one();
        if (15 == columnIndex)
        	return baseinfo.getSecond_review_time_one();
        if (16 == columnIndex)
        	return baseinfo.getThird_review_time_one();
        if (17 == columnIndex)
        	return baseinfo.getTechnical_qualification_two();
        if (18 == columnIndex)
        	return baseinfo.getForensics_time_two();
        if (19 == columnIndex)
        	return baseinfo.getFirst_review_time_two();
        if (20 == columnIndex)
        	return baseinfo.getSecond_review_time_two();
        if (21 == columnIndex)
        	return baseinfo.getThird_review_time_two();
        return null;
    }
 
}