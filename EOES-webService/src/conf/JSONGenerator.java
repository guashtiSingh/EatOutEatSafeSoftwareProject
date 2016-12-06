package conf;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

//import org.json.JSONArray;
//import org.json.JSONObject;

public class JSONGenerator {

	final String IMG_PREFIX = "http://ec2-54-218-26-177.us-west-2.compute.amazonaws.com";
	
	public JSONArray transforJSON(ResultSet rs){
		JSONArray jsonArr = new JSONArray();
		JSONObject jsonObject;
		
		try{
			while(rs.next()){
				
				ResultSetMetaData rm = rs.getMetaData();
				int colCount = rs.getMetaData().getColumnCount();
				
				jsonObject = new JSONObject();
				
				for(int i =1; i<=colCount; i++)
				{
					jsonObject.put(rm.getColumnLabel(i), rs.getString(rm.getColumnLabel(i)));
				}
				
				jsonArr.put(jsonObject);
			}
		}catch(SQLException se){
			System.out.println(se.getMessage());			
		}catch(Exception e){
			e.printStackTrace();
		}
		
			return jsonArr;
	}
	
	public JSONArray imgTransforJSON(ResultSet rs){
		JSONArray jsonArr = new JSONArray();
		JSONObject jsonObject;
		String imgPath = "";
		
		try{
			while(rs.next()){
				
				ResultSetMetaData rm = rs.getMetaData();
				int colCount = rs.getMetaData().getColumnCount();
				
				jsonObject = new JSONObject();
				
				for(int i =1; i<=colCount; i++)
				{
					if(rm.getColumnLabel(i).equals("Img_Path") || rm.getColumnLabel(i).equals("MainImg_Path")) {
						imgPath = IMG_PREFIX + rs.getString(rm.getColumnLabel(i)) + "/"; 
						System.out.println("before: " + imgPath);
						jsonObject.put(rm.getColumnLabel(i), imgPath.toString());
						System.out.println("after: " + jsonObject.get(rm.getColumnLabel((i))));
						
					}else{
						jsonObject.put(rm.getColumnLabel(i), rs.getString(rm.getColumnLabel(i)));
					}
					
				}
				
				jsonArr.put(jsonObject);
			}
		}catch(SQLException se){
			System.out.println(se.getMessage());			
		}catch(Exception e){
			e.printStackTrace();
		}
		
			return jsonArr;
	}
	
}