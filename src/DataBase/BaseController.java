package DataBase;

import java.util.List;
import java.util.Map;


public class BaseController {

	//添加
	public void add(BaseInfo baseinfo) throws Exception{
		BaseHandle hDb = new BaseHandle();
		hDb.addBaseInfo(baseinfo);
	}
	
	//修改
	public void  update(BaseInfo baseinfo) throws Exception{
		BaseHandle hDb = new BaseHandle();
		hDb.updateBaseInfo(baseinfo);
	}
	
	//删除
	public void del(Integer id) throws Exception {
		BaseHandle hDb = new BaseHandle();
		hDb.delteBaseInfo(id);
	}
	
	//查询所有信息
	public List<BaseInfo> query() throws Exception{
		BaseHandle hDb = new BaseHandle();
		return hDb.query();
	}
	
	//查询单个信息（根据id）
	public BaseInfo get(Integer id) throws Exception{
		BaseHandle hDb = new BaseHandle();
		return hDb.get(id);
	}
	
	//查询单个信息（根据姓名等信息）
	public List<BaseInfo> get(List<Map<String, Object>> params) throws Exception{
		BaseHandle hDb = new BaseHandle();
		return hDb.get(params);
	}

}
