package tools;

import java.text.ParseException;	
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.poi.hssf.usermodel.examples.NewLinesInCells;

public class TimeFormat {
	public String timeformat(String realtime) throws ParseException{
	   String returnStrnig;
		if(realtime.equals("")){
		
			returnStrnig="";
	   }else {
		   SimpleDateFormat sdf1 = new SimpleDateFormat ("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
		   Date date=sdf1.parse(realtime);
		   SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		   String sDate=sdf.format(date);
		   returnStrnig=sDate;
	}
		return returnStrnig;

	   
	}
	
	public String timeformatAnther(String realtime) throws ParseException{
		   String returnStrnig;
			if(realtime.equals("")){
			
				returnStrnig="";
		   }else {
			   SimpleDateFormat sdf1 = new SimpleDateFormat ("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
			   Date date=sdf1.parse(realtime);
			   SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
			   String sDate=sdf.format(date);
			   returnStrnig=sDate;
		}
			return returnStrnig;

		   
		}

}
