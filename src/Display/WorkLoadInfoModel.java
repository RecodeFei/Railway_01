package Display;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import tools.testDB;
import DataBase.BaseHandle;
import DataBase.BaseInfo;
import DataBase.WorkloadHandle;
import DataBase.WorkloadInfo;


public class WorkLoadInfoModel extends AbstractTableModel{
	public WorkLoadInfoModel() throws Exception{} 
    String[] columnNames = new String[] {"id","日期","班次","检车员","总量数"};
    
    WorkloadHandle dbControllerqueryall = new WorkloadHandle();
	List<WorkloadInfo> workloadInfos = dbControllerqueryall.query();
	
	
	
    // 返回一共有多少行
    public int getRowCount() {
        // TODO Auto-generated method stub
        return workloadInfos.size();
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
        WorkloadInfo workloadInfo = workloadInfos.get(rowIndex);
        if (0 == columnIndex)
        	return workloadInfo.getId();
        if (1 == columnIndex)
            return workloadInfo.getTime();
        if (2 == columnIndex)
            return workloadInfo.getTeam();
        if (3 == columnIndex)
        	return workloadInfo.getName();
        if (4 == columnIndex)
        	return workloadInfo.getNum();
        
        return null;
    }
 
}
