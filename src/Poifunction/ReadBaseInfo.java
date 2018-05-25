package Poifunction;



public class ReadBaseInfo {

}
	/*public static void main(String[] args) throws Exception{
		String filepath = "/Users/feikuang/eclipse-workspace/Railway/doc/8.xlsx";
		ExcelBaseinfo excelReader = new ExcelBaseinfo(filepath);  
		Map<Integer, Map<Integer,Object>> map = excelReader.readExcelContent();
		FindfaultInfo findfaultInfo = new FindfaultInfo();
		FindfaultHandle findfaultHandle = new FindfaultHandle();
		TimeFormat timeFormat = new TimeFormat();
		for(int i=2; i<=map.size(); i++) {
			findfaultInfo.setTime(excelReader.readSheetTitle());
			findfaultInfo.setDate(map.get(i).get(1).toString());
			findfaultInfo.setCar_type(map.get(i).get(2).toString());
			findfaultInfo.setFault_name(map.get(i).get(3).toString());
			findfaultInfo.setFault_type(map.get(i).get(4).toString());
			findfaultInfo.setTeam(map.get(i).get(5).toString());
			findfaultInfo.setName(map.get(i).get(6).toString());
			findfaultInfo.setMoney(map.get(i).get(7).toString());
			
			findfaultHandle.addFindfaultInfo(findfaultInfo);
		}
	}
}
	
	/*public static void main(String[] args) throws Exception{
		String filepath = "/Users/feikuang/eclipse-workspace/Railway/doc/8.xlsx";
		ExcelBaseinfo excelReader = new ExcelBaseinfo(filepath);  
		Map<Integer, Map<Integer,Object>> map = excelReader.readExcelContent();
		ImportInfo bs = new ImportInfo();
		ImportHandle importHandle = new ImportHandle();
		TimeFormat timeFormat = new TimeFormat();
		for(int i=1; i<=map.size(); i++) {
			bs.setOperation(map.get(i).get(1).toString());
			bs.setWorkshop(map.get(i).get(2).toString());
			bs.setEntry_time(timeFormat.timeformat(map.get(i).get(3).toString()));
			bs.setDetection_station(map.get(i).get(4).toString());
			bs.setTeam(map.get(i).get(5).toString());
			bs.setDate(timeFormat.timeformat(map.get(i).get(6).toString()));
			bs.setArrival_time(timeFormat.timeformat(map.get(i).get(6).toString()));
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
			bs.setSheet(excelReader.readSheetTitle());
			
			importHandle.addImportinfo(bs);
		}
			
			
		}
		
	}
	/*public static void main(String[] args) throws Exception {  
		String filepath = "/Users/feikuang/eclipse-workspace/Railway/doc/9.xlsx";
		ExcelBaseinfo excelReader = new ExcelBaseinfo(filepath);  
		Map<Integer, Map<Integer,Object>> map = excelReader.readExcelContent();
		AccuracyInfo dBaccuracy = new AccuracyInfo();
		AccuracyHandle accuracyHandle = new AccuracyHandle();
		//System.out.println(excelReader.readExcelTitle().toString());
		System.out.println("xxx");
		for (int i = 2; i <= map.size(); i++) { 
			System.out.println(map.get(i).get(1));		
		}
		
	}
	
	/**
	 * public static void main(String[] args) {  
       try {  
    		 String filepath;	
        	if (System.getProperties().getProperty("os.name").equals("Mac OS X")) {
        		 filepath = "/Users/feikuang/eclipse-workspace/Railway/doc/6.xlsx";
        	}else {
        		filepath = "/data/home/feikuang/workspace/Railway/doc/6.xlsx";
			}
        	ExcelBaseinfo excelReader = new ExcelBaseinfo(filepath);  
        	System.out.println(excelReader.readExcelTitle());
        	Baseinfo bs = new Baseinfo();
            handleDB db = new handleDB();
            Map<Integer, Map<Integer,Object>> map = excelReader.readExcelContent();
            /*Workload workload = new Workload();
            WorkloadDB workloadDB = new WorkloadDB();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");	          
            Map<Integer, Map<Integer,Object>> map = excelReader.readExcelContent();
           
           for (int i = 2; i <= map.size()-1; i++) { 
        	   workload.setTime(excelReader.readExcelTitle());
        	   workload.setTeam(map.get(i).get(1).toString());
        	   workload.setName(map.get(i).get(2).toString());
        	   workload.setNum(map.get(i).get(3).toString());
        	   workloadDB.addWorkload(workload);
        
                //Date birthday = df.parse(formatDate);
              // System.out.println(birthday);
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
       
            
        }catch (Exception e) {  
            e.printStackTrace();  
        }  
    }
	  
	  */
	
	
//}
