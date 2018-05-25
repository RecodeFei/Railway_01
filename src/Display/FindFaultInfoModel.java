package Display;

import java.util.List;

import javax.swing.table.AbstractTableModel;
import DataBase.FindfaultHandle;
import DataBase.FindfaultInfo;


@SuppressWarnings("serial")
public class FindFaultInfoModel extends AbstractTableModel{
	public FindFaultInfoModel() throws Exception{} 
    String[] columnNames = new String[] {"id","日期","发现日期","车型车号","故障名称","审核情况","奖励金额(元)","班组","发现人"};
    
    FindfaultHandle findfaultHandle = new FindfaultHandle();
	List<FindfaultInfo> findfaultInfos = findfaultHandle.query();
	
	
    // 返回一共有多少行
    public int getRowCount() {
        // TODO Auto-generated method stub
        return findfaultInfos.size();
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
        FindfaultInfo findfaultInfo = findfaultInfos.get(rowIndex);
        if (0 == columnIndex)
        	return findfaultInfo.getId();
        if (1 == columnIndex)
        	return findfaultInfo.getTime();
        if (2 == columnIndex)
        	return findfaultInfo.getDate();
        if (3 == columnIndex)
        	return findfaultInfo.getCar_type();
        if (4 == columnIndex)
        	return findfaultInfo.getFault_name();
        if (5 == columnIndex)
        	return findfaultInfo.getFault_type();
        if (6 == columnIndex)
        	return findfaultInfo.getMoney();
        if (7 == columnIndex)
        	return findfaultInfo.getTeam();
        if (8 == columnIndex)
        	return findfaultInfo.getName();
      
        
        return null;
    }
 
}
