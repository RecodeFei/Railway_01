package DataBase;

import java.util.List;
import java.util.Map;

public class AccuracyController {

	//添加
	public void add(AccuracyInfo accurracyinfo) throws Exception{
		AccuracyHandle accuracyHandle = new AccuracyHandle();
		accuracyHandle.addDBaccuracy(accurracyinfo);
	}
	
	//修改
	public void  update(AccuracyInfo accurracyinfo) throws Exception{
		AccuracyHandle accuracyHandle = new AccuracyHandle();
		accuracyHandle.updateDBaccuracy(accurracyinfo);
	}
	
	//删除
	public void del(Integer id) throws Exception {
		AccuracyHandle accuracyHandle = new AccuracyHandle();
		accuracyHandle.delteDBaccuracy(id);
	}
	
	//查询所有信息
	public List<AccuracyInfo> query() throws Exception{
		AccuracyHandle accuracyHandle = new AccuracyHandle();
		return accuracyHandle.query();
	}
	
	//查询单个信息（根据id）
	public AccuracyInfo get(Integer id) throws Exception{
		AccuracyHandle accuracyHandle = new AccuracyHandle();
		return accuracyHandle.get(id);
	}
	
	//查询单个信息（根据姓名等信息）
	public List<AccuracyInfo> get(List<Map<String, Object>> params) throws Exception{
		AccuracyHandle accuracyHandle = new AccuracyHandle();
		return accuracyHandle.get(params);
	}

}
