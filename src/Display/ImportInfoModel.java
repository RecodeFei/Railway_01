package Display;

import java.util.List;

import javax.swing.table.AbstractTableModel;
import DataBase.ImportHandle;
import DataBase.ImportInfo;


@SuppressWarnings("serial")
public class ImportInfoModel extends AbstractTableModel{
	public ImportInfoModel() throws Exception{} 
    String[] columnNames = new String[] {"id","时间","操作","车间","录入时间","探测站","班次","日期","到达时间",
    									"是否关键","车次","编组辆数","位数","车型车号","故障名称","故障类型",
    									"漏检工位","责任人","抽查部门","抽查人","备注","复验部门","复验人",
    									"复验车型车号","复验故障名称","复验故障类型","复验时间"	,"操作"};
    
    ImportHandle dbControllerqueryall = new ImportHandle();
	List<ImportInfo> ImportInfos = dbControllerqueryall.query();
	
	
	
    // 返回一共有多少行
    public int getRowCount() {
        // TODO Auto-generated method stub
        return ImportInfos.size();
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
	
	
	
	
	
	
	public String operation2;
	
	public String sheet;
	
    // 每一个单元格里的值
    public Object getValueAt(int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub
        ImportInfo importInfo = ImportInfos.get(rowIndex);
        if (0 == columnIndex)
        	return importInfo.getId();
        if (1 == columnIndex)
        	return importInfo.getTime();
        if (2 == columnIndex)
        	return importInfo.getOperation();
        if (3 == columnIndex)
        	return importInfo.getWorkshop();
        if (4 == columnIndex)
        	return importInfo.getEntry_time();
        if (5 == columnIndex)
        	return importInfo.getDetection_station();
        if (6 == columnIndex)
        	return importInfo.getTeam();
        if (7 == columnIndex)
        	return importInfo.getDate();
        if (8 == columnIndex)
        	return importInfo.getArrival_time();
        if (9 == columnIndex)
        	return importInfo.getCrux();
        if (10 == columnIndex)
        	return importInfo.getTrain_number();
        if (11 == columnIndex)
        	return importInfo.getMarshalling_number();
        if (12 == columnIndex)
        	return importInfo.getDigit();
        if (13 == columnIndex)
        	return importInfo.getCar_number();
        if (14 == columnIndex)
        	return importInfo.getFault_name();
        if (15 == columnIndex)
        	return importInfo.getFault_type();
        if (16 == columnIndex)
        	return importInfo.getLeak_detection_station();
        if (17 == columnIndex)
        	return importInfo.getLeader();
        if (18 == columnIndex)
        	return importInfo.getSpot_inspection_department();
        if (19 == columnIndex)
        	return importInfo.getSpot_checker();
        if (20 == columnIndex)
        	return importInfo.getTip();
        if (21 == columnIndex)
        	return importInfo.getReinspection_department();
        if (22 == columnIndex)
        	return importInfo.getReinspector();
        if (23 == columnIndex)
        	return importInfo.getReinspection_vehicle_number();
        if (24 == columnIndex)
        	return importInfo.getReinspection_fault_name();
        if (25 == columnIndex)
        	return importInfo.getReinspection_fault_type();
        if (26 == columnIndex)
        	return importInfo.getReinspection_time();
        if (27 == columnIndex)
        	return importInfo.getOperation2();
        return null;
    }
 
}
