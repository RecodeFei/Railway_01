package DataBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Test;

public class ImportController {

	//添加
	public void add(ImportInfo importinfo) throws Exception{
		ImportHandle hDb = new ImportHandle();
		hDb.addImportinfo(importinfo);
	}
	
	//修改
	public void  update(ImportInfo importinfo) throws Exception{
		ImportHandle hDb = new ImportHandle();
		hDb.updateImport(importinfo);
	}
	
	//删除
	public void del(Integer id) throws Exception {
		ImportHandle hDb = new ImportHandle();
		hDb.delteImport(id);
	}
	
	//查询所有信息
	public List<ImportInfo> query() throws Exception{
		ImportHandle hDb = new ImportHandle();
		return hDb.query();
	}
	
	//查询单个信息（根据id）
	public ImportInfo get(Integer id) throws Exception{
		ImportHandle hDb = new ImportHandle();
		return hDb.get(id);
	}
	
	//查询单个信息（根据姓名等信息）
	public List<ImportInfo> get(List<Map<String, Object>> params) throws Exception{
		ImportHandle hDb = new ImportHandle();
		return hDb.get(params);
	}

}
