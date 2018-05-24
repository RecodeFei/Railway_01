package DataBase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class WorkloadHandle {
	
	/**
	 * 查询全部数据
	 * @param bi
	 * @throws Exception
	 */
	public List<WorkloadInfo> query() throws SQLException{
		List<WorkloadInfo> Workloadlist = new ArrayList<WorkloadInfo>();
		//获取数据库连接
		Connection conn = DBUtil.getConnection();
		
		StringBuilder sb = new StringBuilder();
		sb.append("select id,time,team,name,num from railway_workload");
		//通过数据库的连接操作数据库，实现增删改查
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		
		ResultSet rs = ptmt.executeQuery();
		WorkloadInfo Workload = null;
		
		while (rs.next()){
			Workload = new WorkloadInfo();
			Workload.setId(rs.getInt("id"));
			Workload.setTime(rs.getString("time"));
			Workload.setTeam(rs.getString("team"));
			Workload.setName(rs.getString("name"));
			Workload.setNum(rs.getString("num"));
			Workloadlist.add(Workload);
		}
		return Workloadlist;
	}
	
	/***
	 * 添加数据
	 * @param Workload
	 * @throws Exception
	 */
	
	@SuppressWarnings("deprecation")
	public void addWorkload(WorkloadInfo Workload) throws Exception{
		//获取数据库连接
		Connection conn = DBUtil.getConnection();
		
		String sql = "insert into railway_workload(time,team,name,num)values(?,?,?,?)";
		//String sql = "insert into railway(team,name,sex)value(?,?,?)";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, Workload.getTime());
		ptmt.setString(2, Workload.getTeam());
		ptmt.setString(3, Workload.getName());
		ptmt.setString(4, Workload.getNum());
	
		ptmt.execute();
	}
	
	/***
	 * 更新数据
	 * @param Workload
	 * @throws SQLException
	 */
	
	public void updateWorkload(WorkloadInfo Workload) throws SQLException{
		Connection con = DBUtil.getConnection();//拿到数据库连接
		String sql="" +
				"update railway_workload "+
				"set time=?,team=?,name=?,num=? "+
				"where id=?";//参数用?表示，相当于占位符;
		/*String sql="" +
				"update railway "+
				"set team=?,name=?,sex=?) "+
				"where id=?";//参数用?表示，相当于占位符;*/
		//预编译sql语句
		System.out.println(sql.toString());
		PreparedStatement ptmt = con.prepareStatement(sql);
		//先对应SQL语句，给sql语句传递参数
		ptmt.setString(1, Workload.getTime());
		ptmt.setString(2, Workload.getTeam());
		ptmt.setString(3, Workload.getName());
		ptmt.setString(4, Workload.getNum());
		ptmt.setInt(5, Workload.getId());
		
		ptmt.execute();
		
	}
	
	/***
	 * 删除数据
	 * @throws SQLException 
	 */
	
	public void delteWorkload(Integer id) throws SQLException{
		Connection con = DBUtil.getConnection();//拿到数据连接
		String sql = "" +
					"delete from railway_workload " +
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
	
	public WorkloadInfo get(Integer id) throws SQLException{
		WorkloadInfo bs = null;
		Connection con = DBUtil.getConnection();
		String sql=""+
				"select * from railway_workload "+
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
			bs = new WorkloadInfo();
			bs.setId(rs.getInt("id"));
			bs.setTime(rs.getString("time"));
			bs.setTeam(rs.getString("team"));
			bs.setName(rs.getString("name"));
			bs.setNum(rs.getString("num"));
		}
		return bs;
		
	}
	
	/**
	 * 根据姓名等查询
	 */
	
	public List<WorkloadInfo> get(List<Map<String, Object>> params) throws SQLException{
		List<WorkloadInfo> result = new ArrayList<WorkloadInfo>();
		Connection con = DBUtil.getConnection();
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append("select * from railway_workload where 1=1 ");//注意where 1=1 的小技巧
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
		WorkloadInfo bs = null;
		//遍历结果集
		while(rs.next()){
			bs = new WorkloadInfo();
			bs.setId(rs.getInt("id"));
			bs.setTime(rs.getString("time"));
			bs.setTeam(rs.getString("team"));
			bs.setName(rs.getString("name"));
			bs.setNum(rs.getString("num"));
			
			result.add(bs);//将结果封装到对象中
		}
		return result;
	}

}