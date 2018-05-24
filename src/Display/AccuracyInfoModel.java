package Display;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import DataBase.AccuracyHandle;
import DataBase.AccuracyInfo;





public class AccuracyInfoModel extends AbstractTableModel{
	public AccuracyInfoModel() throws Exception{} 
    String[] columnNames = new String[] {"id","日期","班组","检车员","准确率"};
    
    AccuracyHandle accuracyHandle = new AccuracyHandle();
	List<AccuracyInfo> accuracyInfos = accuracyHandle.query();
	
	
	
    // 返回一共有多少行
    public int getRowCount() {
        // TODO Auto-generated method stub
        return accuracyInfos.size();
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
        AccuracyInfo accuracyInfo = accuracyInfos.get(rowIndex);
        if (0 == columnIndex)
        	return accuracyInfo.getId();
        if (1 == columnIndex)
        	return accuracyInfo.getTime();
        if (2 == columnIndex)
        	return accuracyInfo.getTeam();
        if (3 == columnIndex)
        	return accuracyInfo.getName();
        if (4 == columnIndex)
        	return accuracyInfo.getAccuracy();
        return null;
    }
 
}
