package Display;

import java.text.SimpleDateFormat;
import java.util.Map;

import DataBase.AccuracyHandle;
import DataBase.AccuracyInfo;
import DataBase.BaseHandle;
import DataBase.BaseInfo;
import DataBase.FindfaultHandle;
import DataBase.FindfaultInfo;
import DataBase.ImportHandle;
import DataBase.ImportInfo;
import DataBase.WorkloadHandle;
import DataBase.WorkloadInfo;
import tools.ExcelBaseinfo;
import tools.TimeFormat;

public class DBAddModel {

	/**
	 * @param args
	 * @throws Exception 
	 */


	public void AddBaseInfoToDb(String filePath) throws Exception {
		// TODO Auto-generated method stub	
       	ExcelBaseinfo excelReader = new ExcelBaseinfo(filePath);  
       	BaseInfo bs = new BaseInfo();
        BaseHandle db = new BaseHandle();
           Map<Integer, Map<Integer,Object>> map = excelReader.readExcelContent();
           for (int i = 2; i <= map.size()-1; i++) { 
               bs.setTeam(map.get(i).get(1).toString());
               bs.setName(map.get(i).get(2).toString());
               bs.setSex(map.get(i).get(3).toString()); 
	           bs.setBorn(new TimeFormat().timeformat(map.get(i).get(4).toString()));
               bs.setAge(map.get(i).get(5).toString());
               bs.setEducation(map.get(i).get(6).toString());
               bs.setWork_time(new TimeFormat().timeformat(map.get(i).get(7).toString()));
               bs.setTechnical_title(map.get(i).get(8).toString());
               bs.setPost(map.get(i).get(9).toString());
               bs.setPolitical_outlook(map.get(i).get(10).toString());
               bs.setSkill_level(map.get(i).get(11).toString());
               bs.setTechnical_qualification_one(map.get(i).get(12).toString());
               bs.setForensics_time_one(new TimeFormat().timeformat(map.get(i).get(13).toString()));
               bs.setFirst_review_time_one(new TimeFormat().timeformat(map.get(i).get(14).toString()));          
               bs.setSecond_review_time_one(new TimeFormat().timeformat(map.get(i).get(15).toString()));
               bs.setThird_review_time_one(new TimeFormat().timeformat(map.get(i).get(16).toString()));
               bs.setTechnical_qualification_two(map.get(i).get(17).toString());
               bs.setForensics_time_two(new TimeFormat().timeformat(map.get(i).get(18).toString()));
               bs.setFirst_review_time_two(new TimeFormat().timeformat(map.get(i).get(19).toString()));
               bs.setSecond_review_time_two(new TimeFormat().timeformat(map.get(i).get(20).toString()));
               bs.setThird_review_time_two(new TimeFormat().timeformat(map.get(i).get(21).toString()));     
               
               db.addBaseInfo(bs);              
           }       
	}

	public void AddWorkloadToDb(String filePath) throws Exception {
		// TODO Auto-generated method stub
    	ExcelBaseinfo excelReader = new ExcelBaseinfo(filePath);  
        Map<Integer, Map<Integer,Object>> map = excelReader.readExcelContent();
        WorkloadInfo workload = new WorkloadInfo();
        WorkloadHandle workloadDB = new WorkloadHandle();   
       for (int i = 1; i <= map.size(); i++) { 
    	   workload.setTime(excelReader.readSheetTitle());
    	   workload.setTeam(map.get(i).get(1).toString());
    	   workload.setName(map.get(i).get(2).toString());
    	   workload.setNum(map.get(i).get(3).toString());
    	   workloadDB.addWorkload(workload);
    	   
	}
}

	public void AddFindFaultToDb(String filePath) throws Exception {
		// TODO Auto-generated method stub
		ExcelBaseinfo excelReader = new ExcelBaseinfo(filePath);  
		Map<Integer, Map<Integer,Object>> map = excelReader.readExcelContent();
		FindfaultInfo findfaultInfo = new FindfaultInfo();
		FindfaultHandle findfaultHandle = new FindfaultHandle();
		for(int i=1; i<=map.size(); i++) {
			findfaultInfo.setTime(excelReader.readSheetTitle());
			findfaultInfo.setDate(new TimeFormat().timeformat(map.get(i).get(1).toString()));
			findfaultInfo.setCar_type(map.get(i).get(2).toString());
			findfaultInfo.setFault_name(map.get(i).get(3).toString());
			findfaultInfo.setFault_type(map.get(i).get(4).toString());
			findfaultInfo.setMoney(map.get(i).get(5).toString());
			findfaultInfo.setTeam(map.get(i).get(6).toString());
			findfaultInfo.setName(map.get(i).get(7).toString());
			
			findfaultHandle.addFindfaultInfo(findfaultInfo);
			

			
	
			
	}
}

	public void AddAccuracyToDb(String filePath) throws Exception {
		// TODO Auto-generated method stub
		ExcelBaseinfo excelReader = new ExcelBaseinfo(filePath);  
		Map<Integer, Map<Integer,Object>> map = excelReader.readExcelContent();
		AccuracyInfo accuracyInfo = new AccuracyInfo();
		AccuracyHandle accuracyHandle = new AccuracyHandle();
		for (int i = 1; i <= map.size(); i++) { 
			accuracyInfo.setTime(excelReader.readSheetTitle());
			accuracyInfo.setTeam(map.get(i).get(1).toString());
			accuracyInfo.setName(map.get(i).get(2).toString());
			accuracyInfo.setAccuracy(map.get(i).get(3).toString());
			
			accuracyHandle.addDBaccuracy(accuracyInfo);
		}
	}

	public void addImportToDb(String filePath) throws Exception {
		// TODO Auto-generated method stub
		ExcelBaseinfo excelReader = new ExcelBaseinfo(filePath);  
		Map<Integer, Map<Integer,Object>> map = excelReader.readExcelContent();
		ImportInfo bs = new ImportInfo();
		ImportHandle importHandle = new ImportHandle();
		TimeFormat timeFormat = new TimeFormat();
		for(int i=1; i<=map.size(); i++) {
			bs.setTime(excelReader.readSheetTitle());
			bs.setOperation(map.get(i).get(1).toString());
			bs.setWorkshop(map.get(i).get(2).toString());
			bs.setEntry_time(timeFormat.timeformat(map.get(i).get(3).toString()));
			bs.setDetection_station(map.get(i).get(4).toString());
			bs.setTeam(map.get(i).get(5).toString());
			bs.setDate(timeFormat.timeformat(map.get(i).get(6).toString()));
			bs.setArrival_time(timeFormat.timeformatAnther(map.get(i).get(7).toString()));
			bs.setCrux(map.get(i).get(8).toString());
			bs.setTrain_number(map.get(i).get(9).toString());
			bs.setMarshalling_number(map.get(i).get(10).toString());
			bs.setDigit(map.get(i).get(11).toString());
			bs.setCar_number(map.get(i).get(12).toString());
			bs.setFault_name(map.get(i).get(13).toString());
			bs.setFault_type(map.get(i).get(14).toString());
			bs.setLeak_detection_station(map.get(i).get(15).toString());
			bs.setLeader(map.get(i).get(16).toString());
			bs.setSpot_inspection_department(map.get(i).get(17).toString());
			bs.setSpot_checker(map.get(i).get(18).toString());
			bs.setTip(map.get(i).get(19).toString());
			bs.setReinspection_department(map.get(i).get(20).toString());
			bs.setReinspector(map.get(i).get(21).toString());
			bs.setReinspection_vehicle_number(map.get(i).get(22).toString());
			bs.setReinspection_fault_name(map.get(i).get(23).toString());
			bs.setReinspection_fault_type(map.get(i).get(24).toString());
			bs.setReinspection_time(timeFormat.timeformat(map.get(i).get(25).toString()));
			bs.setOperation2(map.get(i).get(26).toString());
					
			importHandle.addImportinfo(bs);

	}
	}
}
