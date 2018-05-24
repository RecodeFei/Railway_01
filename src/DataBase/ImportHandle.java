package DataBase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ImportHandle {
	
	/**
	 * 查询全部数据
	 * @param bi
	 * @throws Exception
	 */
	public List query() throws SQLException{
		ArrayList<ImportInfo> ImportinfoList = new ArrayList<ImportInfo>();
		//获取数据库连接
		Connection conn = DBUtil.getConnection();
		
		StringBuilder sb = new StringBuilder();
		sb.append("select id,time,operation,workshop,entry_time,detection_station,team,date,arrival_time,crux,train_number,marshalling_number,digit,car_number,fault_name,fault_type,leak_detection_station,leader,spot_inspection_department,spot_checker,tip,reinspection_department,reinspector,reinspection_vehicle_number,reinspection_fault_name,reinspection_fault_type,reinspection_time,operation2 from railway_import");
		//通过数据库的连接操作数据库，实现增删改查
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		
		ResultSet rs = ptmt.executeQuery();
		ImportInfo Workload = null;
		
		while (rs.next()){
			ImportInfo importinfo  = new ImportInfo();
			importinfo.setId(rs.getInt("id"));
			importinfo.setTime(rs.getString("time"));
			importinfo.setOperation(rs.getString("operation"));
			importinfo.setWorkshop(rs.getString("workshop"));
			importinfo.setEntry_time(rs.getString("entry_time"));
			importinfo.setDetection_station(rs.getString("detection_station"));
			importinfo.setTeam(rs.getString("team"));
			importinfo.setDate(rs.getString("date"));
			importinfo.setArrival_time(rs.getString("arrival_time"));
			importinfo.setCrux(rs.getString("crux"));
			importinfo.setTrain_number(rs.getString("train_number"));
			importinfo.setMarshalling_number(rs.getString("marshalling_number"));
			importinfo.setDigit(rs.getString("digit"));
			importinfo.setCar_number(rs.getString("car_number"));
			importinfo.setFault_name(rs.getString("fault_name"));
			importinfo.setFault_type(rs.getString("fault_type"));
			importinfo.setLeak_detection_station(rs.getString("leak_detection_station"));
			importinfo.setLeader(rs.getString("leader"));
			importinfo.setSpot_inspection_department(rs.getString("spot_inspection_department"));
			importinfo.setSpot_checker(rs.getString("spot_checker"));
			importinfo.setTip(rs.getString("tip"));
			importinfo.setReinspection_department(rs.getString("reinspection_department"));
			importinfo.setReinspector(rs.getString("reinspector"));
			importinfo.setReinspection_vehicle_number(rs.getString("reinspection_vehicle_number"));
			importinfo.setReinspection_fault_name(rs.getString("reinspection_fault_name"));
			importinfo.setReinspection_fault_type(rs.getString("reinspection_fault_type"));
			importinfo.setReinspection_time(rs.getString("reinspection_time"));
			importinfo.setOperation2(rs.getString("operation2"));
			
			
			
			ImportinfoList.add(importinfo);
		}
		return ImportinfoList;
	}
	
	/***
	 * 添加数据
	 * @param importinfo
	 * @throws Exception
	 */
	
	@SuppressWarnings("deprecation")
	public void addImportinfo(ImportInfo importinfo) throws Exception{
		//获取数据库连接
		Connection conn = DBUtil.getConnection();
		
		String sql = "insert into railway_import(time,operation,workshop,entry_time,detection_station,team,date,arrival_time,crux,train_number,marshalling_number,digit,car_number,fault_name,fault_type,leak_detection_station,leader,spot_inspection_department,spot_checker,tip,reinspection_department,reinspector,reinspection_vehicle_number,reinspection_fault_name,reinspection_fault_type,reinspection_time,operation2)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		//String sql = "insert into railway(team,name,sex)value(?,?,?)";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, importinfo.getTime());
		ptmt.setString(2, importinfo.getOperation());
		ptmt.setString(3, importinfo.getWorkshop());
		ptmt.setString(4, importinfo.getEntry_time());
		ptmt.setString(5, importinfo.getDetection_station());
		ptmt.setString(6, importinfo.getTeam());
		ptmt.setString(7, importinfo.getDate());
		ptmt.setString(8, importinfo.getArrival_time());
		ptmt.setString(9, importinfo.getCrux());
		ptmt.setString(10, importinfo.getTrain_number());
		ptmt.setString(11, importinfo.getMarshalling_number());
		ptmt.setString(12, importinfo.getDigit());
		ptmt.setString(13, importinfo.getCar_number());
		ptmt.setString(14, importinfo.getFault_name());
		ptmt.setString(15, importinfo.getFault_type());
		ptmt.setString(16, importinfo.getLeak_detection_station());
		ptmt.setString(17, importinfo.getLeader());
		ptmt.setString(18, importinfo.getSpot_inspection_department());
		ptmt.setString(19, importinfo.getSpot_checker());
		ptmt.setString(20, importinfo.getTip());
		ptmt.setString(21, importinfo.getReinspection_department());
		ptmt.setString(22, importinfo.getReinspector());
		ptmt.setString(23, importinfo.getReinspection_vehicle_number());
		ptmt.setString(24, importinfo.getReinspection_fault_name());
		ptmt.setString(25, importinfo.getReinspection_fault_type());
		ptmt.setString(26,importinfo.getReinspection_time());
		ptmt.setString(27, importinfo.getOperation2());
		
	
		ptmt.execute();
	}
	
	/***
	 * 更新数据
	 * @param Workload
	 * @throws SQLException
	 */
	
	public void updateImport(ImportInfo importinfo) throws SQLException{
		Connection con = DBUtil.getConnection();//拿到数据库连接
		String sql="" +
				"update railway_import "+
				"set time=?,operation=?,workshop=?,entry_time=?,detection_station=?,team,date=?,arrival_time=?,"
				+ "crux,train_number=?,marshalling_number=?,digit=?,car_number=?,fault_name=?,fault_typ=?,"
				+ "leak_detection_station=?,leader=?,spot_inspection_department=?,spot_checker=?,"
				+ "tip=?,reinspection_department=?,reinspector=?,reinspection_vehicle_number=?,"
				+ "reinspection_fault_name=?,reinspection_fault_type=?,reinspection_time=?,operation2=? "+
				"where id=?";//参数用?表示，相当于占位符;
		/*String sql="" +
				"update railway "+
				"set team=?,name=?,sex=?) "+
				"where id=?";//参数用?表示，相当于占位符;*/
		//预编译sql语句
		System.out.println(sql.toString());
		PreparedStatement ptmt = con.prepareStatement(sql);
		//先对应SQL语句，给sql语句传递参数
		ptmt.setString(1, importinfo.getTime());
		ptmt.setString(2, importinfo.getOperation());
		ptmt.setString(3, importinfo.getWorkshop());
		ptmt.setString(4, importinfo.getEntry_time());
		ptmt.setString(5, importinfo.getDetection_station());
		ptmt.setString(6, importinfo.getTeam());
		ptmt.setString(7, importinfo.getDate());
		ptmt.setString(8, importinfo.getArrival_time());
		ptmt.setString(9, importinfo.getCrux());
		ptmt.setString(10, importinfo.getTrain_number());
		ptmt.setString(11, importinfo.getMarshalling_number());
		ptmt.setString(12, importinfo.getDigit());
		ptmt.setString(13, importinfo.getCar_number());
		ptmt.setString(14, importinfo.getFault_name());
		ptmt.setString(15, importinfo.getFault_type());
		ptmt.setString(16, importinfo.getLeak_detection_station());
		ptmt.setString(17, importinfo.getLeader());
		ptmt.setString(18, importinfo.getSpot_inspection_department());
		ptmt.setString(19, importinfo.getSpot_checker());
		ptmt.setString(20, importinfo.getTip());
		ptmt.setString(21, importinfo.getReinspection_department());
		ptmt.setString(22, importinfo.getReinspector());
		ptmt.setString(23, importinfo.getReinspection_vehicle_number());
		ptmt.setString(24, importinfo.getReinspection_fault_name());
		ptmt.setString(25, importinfo.getReinspection_fault_type());
		ptmt.setString(26,importinfo.getReinspection_time());
		ptmt.setString(27, importinfo.getOperation2());
		
		ptmt.setInt(28, importinfo.getId());
		
		ptmt.execute();
		
	}
	
	/***
	 * 删除数据
	 * @throws SQLException 
	 */
	
	public void delteImport(Integer id) throws SQLException{
		Connection con = DBUtil.getConnection();//拿到数据连接
		String sql = "" +
					"delete from railway_import " +
				    "where id=?";
		//预编译语句
		PreparedStatement ptmt = con.prepareStatement(sql);
		//传递参数
		ptmt.setInt(1, id);
		
		ptmt.execute();
	}
	
	
	/**
	 * 查询单个（根据ID去查询）
	 * @return
	 */
	
	public ImportInfo get(Integer id) throws SQLException{
		ImportInfo bs = null;
		Connection con = DBUtil.getConnection();
		String sql=""+
				"select * from railway_import "+
				"where id=?";
		PreparedStatement ptmt = con.prepareStatement(sql);
		ptmt.setInt(1, id);
		//执行语句
		/*psmt.execute();//execute()方法是执行更改数据库操作
		（包括新增、修改、删除）;executeQuery()是执行查询操作
		*/
		ResultSet rs = ptmt.executeQuery();//返回一个结果集
		//遍历结果集
		while(rs.next()){

			bs = new ImportInfo();
			bs.setId(rs.getInt("id"));
			bs.setTime(rs.getString("time"));
			bs.setOperation(rs.getString("operation"));
			bs.setWorkshop(rs.getString("workshop"));
			bs.setEntry_time(rs.getString("entry_time"));
			bs.setDetection_station(rs.getString("detection_station"));
			bs.setTeam(rs.getString("team"));
			bs.setDate(rs.getString("date"));
			bs.setArrival_time(rs.getString("arrival_time"));
			bs.setCrux(rs.getString("crux"));
			bs.setTrain_number(rs.getString("train_number"));
			bs.setMarshalling_number(rs.getString("marshalling_number"));
			bs.setDigit(rs.getString("digit"));
			bs.setCar_number(rs.getString("car_number"));
			bs.setFault_name(rs.getString("fault_name"));
			bs.setFault_type(rs.getString("fault_type"));
			bs.setLeak_detection_station(rs.getString("leak_detection_station"));
			bs.setLeader(rs.getString("leader"));
			bs.setSpot_inspection_department(rs.getString("spot_inspection_department"));
			bs.setSpot_checker(rs.getString("spot_checker"));
			bs.setTip(rs.getString("tip"));
			bs.setReinspection_department(rs.getString("reinspection_department"));
			bs.setReinspector(rs.getString("reinspector"));
			bs.setReinspection_vehicle_number(rs.getString("reinspection_vehicle_number"));
			bs.setReinspection_fault_name(rs.getString("reinspection_fault_name"));
			bs.setReinspection_fault_type(rs.getString("reinspection_fault_type"));
			bs.setReinspection_time(rs.getString("reinspection_time"));
			bs.setOperation2(rs.getString("operation2"));
			
			
			
			
		}
		return bs;
		
	}
	
	/**
	 * 根据姓名等查询
	 */
	
	public List<ImportInfo> get(List<Map<String, Object>> params) throws SQLException{
		List<ImportInfo> result = new ArrayList<ImportInfo>();
		Connection con = DBUtil.getConnection();
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append("select * from railway_import where 1=1 ");//注意where 1=1 的小技巧
		//sBuffer.append("where name like ? and skill_level like ?");
		if(params !=null && params.size()>0){//先判断集合是否为空
//遍历集合
			for(int i=0;i<params.size();i++){
				Map<String, Object> map=params.get(i);
				sBuffer.append("and "+map.get("name")+" " +map.get("rela")+" "+map.get("value")+" ");//查询什么？关系是什么？以及值是什么，我们都可以通过参数传进来。
			}    
		}
		PreparedStatement ptmt = con.prepareStatement(sBuffer.toString());
		System.out.println(sBuffer.toString());
		ResultSet rs = ptmt.executeQuery();
		ImportInfo bs = null;
		//遍历结果集
		while(rs.next()){
			bs = new ImportInfo();
			bs.setId(rs.getInt("id"));
			bs.setTime(rs.getString("time"));
			bs.setOperation(rs.getString("operation"));
			bs.setWorkshop(rs.getString("workshop"));
			bs.setEntry_time(rs.getString("entry_time"));
			bs.setDetection_station(rs.getString("detection_station"));
			bs.setTeam(rs.getString("team"));
			bs.setDate(rs.getString("date"));
			bs.setArrival_time(rs.getString("arrival_time"));
			bs.setCrux(rs.getString("crux"));
			bs.setTrain_number(rs.getString("train_number"));
			bs.setMarshalling_number(rs.getString("marshalling_number"));
			bs.setDigit(rs.getString("digit"));
			bs.setCar_number(rs.getString("car_number"));
			bs.setFault_name(rs.getString("fault_name"));
			bs.setFault_type(rs.getString("fault_type"));
			bs.setLeak_detection_station(rs.getString("leak_detection_station"));
			bs.setLeader(rs.getString("leader"));
			bs.setSpot_inspection_department(rs.getString("spot_inspection_department"));
			bs.setSpot_checker(rs.getString("spot_checker"));
			bs.setTip(rs.getString("tip"));
			bs.setReinspection_department(rs.getString("reinspection_department"));
			bs.setReinspector(rs.getString("reinspector"));
			bs.setReinspection_vehicle_number(rs.getString("reinspection_vehicle_number"));
			bs.setReinspection_fault_name(rs.getString("reinspection_fault_name"));
			bs.setReinspection_fault_type(rs.getString("reinspection_fault_type"));
			bs.setReinspection_time(rs.getString("reinspection_time"));
			bs.setOperation2(rs.getString("operation2"));
			
			
			result.add(bs);//将结果封装到对象中
		}
		return result;
	}

}
