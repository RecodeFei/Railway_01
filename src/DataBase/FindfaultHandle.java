package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public class FindfaultHandle {
	
	/**
	 * 查询全部数据
	 * @param bi
	 * @throws Exception
	 */
	public List<FindfaultInfo> query() throws SQLException{
		List<FindfaultInfo> FindfaultInfolist = new ArrayList<FindfaultInfo>();
		//获取数据库连接
		Connection conn = DBUtil.getConnection();
		
		StringBuilder sb = new StringBuilder();
		sb.append("select id,time,date,car_type,fault_name,fault_type,money,team,name from railway_findfault");
		//通过数据库的连接操作数据库，实现增删改查
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		
		ResultSet rs = ptmt.executeQuery();
		FindfaultInfo FindfaultInfo = null;
		
		while (rs.next()){
			FindfaultInfo = new FindfaultInfo();
			FindfaultInfo.setId(rs.getInt("id"));
			FindfaultInfo.setTime(rs.getString("time"));
			FindfaultInfo.setDate(rs.getString("date"));
			FindfaultInfo.setCar_type(rs.getString("car_type"));
			FindfaultInfo.setFault_name(rs.getString("fault_name"));
			FindfaultInfo.setFault_name(rs.getString("fault_type"));
			FindfaultInfo.setTeam(rs.getString("money"));
			FindfaultInfo.setName(rs.getString("team"));
			FindfaultInfo.setMoney(rs.getString("name"));
			FindfaultInfolist.add(FindfaultInfo);
		}
		return FindfaultInfolist;
	}
	
	/***
	 * 添加数据
	 * @param FindfaultInfo
	 * @throws Exception
	 */
	
	@SuppressWarnings("deprecation")
	public void addFindfaultInfo(FindfaultInfo FindfaultInfo) throws Exception{
		//获取数据库连接
		Connection conn = DBUtil.getConnection();
		
		String sql = "insert into railway_findfault(time,date,car_type,fault_name,fault_type,money,team,name)values(?,?,?,?,?,?,?,?)";
		//String sql = "insert into railway(team,name,sex)value(?,?,?)";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, FindfaultInfo.getTime());
		ptmt.setString(2, FindfaultInfo.getDate());
		ptmt.setString(3, FindfaultInfo.getCar_type());
		ptmt.setString(4, FindfaultInfo.getFault_name());
		ptmt.setString(5, FindfaultInfo.getFault_type());
		ptmt.setString(6, FindfaultInfo.getMoney());
		ptmt.setString(7, FindfaultInfo.getTeam());
		ptmt.setString(8, FindfaultInfo.getName());
	
		ptmt.execute();
	}
	
	/***
	 * 更新数据
	 * @param FindfaultInfo
	 * @throws SQLException
	 */
	
	public void updateFindfaultInfo(FindfaultInfo FindfaultInfo) throws SQLException{
		Connection con = DBUtil.getConnection();//拿到数据库连接
		String sql="" +
				"update railway_findfault "+
				"set time=?,date=?,car_type=?,fault_name=?,fault_type=?,money=?,team=?,name=? "+
				"where id=?";//参数用?表示，相当于占位符;
		/*String sql="" +
				"update railway "+
				"set team=?,name=?,sex=?) "+
				"where id=?";//参数用?表示，相当于占位符;*/
		//预编译sql语句
		System.out.println(sql.toString());
		PreparedStatement ptmt = con.prepareStatement(sql);
		//先对应SQL语句，给sql语句传递参数
		ptmt.setString(1, FindfaultInfo.getTime());
		ptmt.setString(2, FindfaultInfo.getDate());
		ptmt.setString(3, FindfaultInfo.getCar_type());
		ptmt.setString(4, FindfaultInfo.getFault_name());
		ptmt.setString(5, FindfaultInfo.getFault_type());
		ptmt.setString(6, FindfaultInfo.getMoney());
		ptmt.setString(7, FindfaultInfo.getTeam());
		ptmt.setString(8, FindfaultInfo.getName());
		
		ptmt.execute();
		
	}
	
	/***
	 * 删除数据
	 * @throws SQLException 
	 */
	
	public void delteFindfaultInfo(Integer id) throws SQLException{
		Connection con = DBUtil.getConnection();//拿到数据连接
		String sql = "" +
					"delete from railway_findfault " +
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
	
	public FindfaultInfo get(Integer id) throws SQLException{
		FindfaultInfo bs = null;
		Connection con = DBUtil.getConnection();
		String sql=""+
				"select * from railway_findfault "+
				"where id=?";
		PreparedStatement ptmt = con.prepareStatement(sql);
		ptmt.setInt(1, id);
		//执行语句
		/*psmt.execute();//execute()方法是执行更改数据库操作
		（包括新增、修改、删除）;executeQuery()是执行查询操作
		*/
		ResultSet rs = ptmt.executeQuery();//返回一个结果集
		//遍历结果集time,date,car_type,fault_name,fault_type,team,name,money
		while(rs.next()){
			bs = new FindfaultInfo();
			bs.setId(rs.getInt("id"));
			bs.setTime(rs.getString("time"));
			bs.setDate(rs.getString("date"));
			bs.setCar_type(rs.getString("car_type"));
			bs.setFault_name(rs.getString("fault_name"));
			bs.setFault_type(rs.getString("fault_type"));
			bs.setTeam(rs.getString("money"));
			bs.setName(rs.getString("team"));
			bs.setMoney(rs.getString("name"));
		}
		return bs;
		
	}
	
	/**
	 * 根据姓名等查询
	 */
	
	public List<FindfaultInfo> get(List<Map<String, Object>> params) throws SQLException{
		List<FindfaultInfo> result = new ArrayList<FindfaultInfo>();
		Connection con = DBUtil.getConnection();
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append("select * from railway_FindfaultInfo where 1=1 ");//注意where 1=1 的小技巧
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
		FindfaultInfo bs = null;
		//遍历结果集
		while(rs.next()){
			bs = new FindfaultInfo();
			bs.setId(rs.getInt("id"));
			bs.setTime(rs.getString("time"));
			bs.setDate(rs.getString("date"));
			bs.setCar_type(rs.getString("car_type"));
			bs.setFault_name(rs.getString("fault_name"));
			bs.setFault_type(rs.getString("fault_type"));
			bs.setTeam(rs.getString("money"));
			bs.setName(rs.getString("team"));
			bs.setMoney(rs.getString("money"));
			
			result.add(bs);//将结果封装到对象中
		}
		return result;
	}

}