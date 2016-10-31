package rest;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import conf.dbConnection;
import conf.JSONGenerator;
 
@Path("/menu")
public class MenuService {
 
	JSONGenerator jg = null;
	
	  @GET
	  @Path("/list/{resId}")
	  @Produces("application/json")
	  public Response ReviewService(@PathParam("resId") String resId) throws JSONException {
 
		JSONArray jsonArr = new JSONArray();
		JSONObject returnObj = new JSONObject();
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		
		try{
			dbConnection db = new dbConnection();
			con = db.getConnection();
			
			cs = con.prepareCall("call menuList(?,?)");
			cs.setString("resId", resId);
			cs.setString("isSpecial", "0"); // 1: special menu only, 0: all menus
			rs = cs.executeQuery();
			
			jg = new JSONGenerator();
			jsonArr = jg.imgTransforJSON(rs);
			returnObj.put("menus", jsonArr);	
			
				
		}catch(SQLException se){
			System.out.println(se.getMessage());			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			if(cs != null) try{cs.close();}catch(Exception e){}
			if(con != null) try{con.close();}catch(Exception e){}
		}
					
		return Response.status(200).entity(returnObj.toString()).build();
	  }
	  
	  @GET
	  @Path("/list/{resId}/{isSpecial}")
	  @Produces("application/json")
	  public Response getRvList(@PathParam("resId") String resId, @PathParam("isSpecial") String isSpecial) throws JSONException {
		
		JSONArray jsonArr = new JSONArray();
		JSONObject returnObj = new JSONObject();
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		
		try{
			dbConnection db = new dbConnection();
			con = db.getConnection();
			
			if(!(isSpecial.equals("1")||isSpecial.equals("0"))) isSpecial = "0";  
			
			cs = con.prepareCall("call menuList(?,?)");
			cs.setString("resId", resId);
			cs.setString("isSpecial", isSpecial); // 1: special menu only, 0: all menus
			
			rs = cs.executeQuery();
			jg = new JSONGenerator();
			jsonArr = jg.imgTransforJSON(rs);
			returnObj.put("menus", jsonArr);						
			
		}catch(SQLException se){
			System.out.println(se.getMessage());			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(cs != null) try{cs.close();}catch(Exception e){}
			if(con != null) try{con.close();}catch(Exception e){}
		}	
		
		return Response.status(200).entity(returnObj.toString()).build();	
		
	  } 
	  
}

