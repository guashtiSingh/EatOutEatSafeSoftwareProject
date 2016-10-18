package conf;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONGenerator {

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
	
}
