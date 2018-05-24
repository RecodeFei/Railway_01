package DataBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Test;

public class WorkloadController {

	//添加
	public void add(WorkloadInfo Workload) throws Exception{
		WorkloadHandle hDb = new WorkloadHandle();
		hDb.addWorkload(Workload);
	}
	
	//修改
	public void  update(WorkloadInfo Workload) throws Exception{
		WorkloadHandle hDb = new WorkloadHandle();
		hDb.updateWorkload(Workload);
	}
	
	//删除
	public void del(Integer id) throws Exception {
		WorkloadHandle hDb = new WorkloadHandle();
		hDb.delteWorkload(id);
	}
	
	//查询所有信息
	public List<WorkloadInfo> query() throws Exception{
		WorkloadHandle hDb = new WorkloadHandle();
		return hDb.query();
	}
	
	//查询单个信息（根据id）
	public WorkloadInfo get(Integer id) throws Exception{
		WorkloadHandle hDb = new WorkloadHandle();
		return hDb.get(id);
	}
	
	//查询单个信息（根据姓名等信息）
	public List<WorkloadInfo> get(List<Map<String, Object>> params) throws Exception{
		WorkloadHandle hDb = new WorkloadHandle();
		return hDb.get(params);
	}

}
