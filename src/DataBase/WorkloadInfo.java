package DataBase;

public class WorkloadInfo {

	/*
	 * 基础类
	 * owner:luyuan.zhong

	 */
	public Integer id;
	
	public String time;
	
	public String team;
	
	public String name;
	
	public String num;
	
	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
	
	public String getTime(){
		return time;
	}
	
	public void setTime(String time){
		this.time = time;
	}
	
	public String getTeam(){
		return team;
	}
	
	public void setTeam(String team){
		this.team = team;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getNum(){
		return num;
	}
	
	public void setNum(String num){
		this.num = num;
	}
}
