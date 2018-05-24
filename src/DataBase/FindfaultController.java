package DataBase;
import java.util.List;
import java.util.Map;


public class FindfaultController {

	//添加
	public void add(FindfaultInfo findfaultInfo) throws Exception{
		FindfaultHandle hDb = new FindfaultHandle();
		hDb.addFindfaultInfo(findfaultInfo);
	}
	
	//修改
	public void  update(FindfaultInfo findfaultInfo) throws Exception{
		FindfaultHandle hDb = new FindfaultHandle();
		hDb.updateFindfaultInfo(findfaultInfo);
	}
	
	//删除
	public void del(Integer id) throws Exception {
		FindfaultHandle hDb = new FindfaultHandle();
		hDb.delteFindfaultInfo(id);
	}
	
	//查询所有信息
	public List<FindfaultInfo> query() throws Exception{
		FindfaultHandle hDb = new FindfaultHandle();
		return hDb.query();
	}
	
	//查询单个信息（根据id）
	public FindfaultInfo get(Integer id) throws Exception{
		FindfaultHandle hDb = new FindfaultHandle();
		return hDb.get(id);
	}
	
	//查询单个信息（根据姓名等信息）
	public List<FindfaultInfo> get(List<Map<String, Object>> params) throws Exception{
		FindfaultHandle hDb = new FindfaultHandle();
		return hDb.get(params);
	}

}
