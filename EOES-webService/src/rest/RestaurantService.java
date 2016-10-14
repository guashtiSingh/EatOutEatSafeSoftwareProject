package rest;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
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
 
@Path("/restaurant")
public class RestaurantService {
 
	  @GET
	  @Produces("application/json")
	  public Response RestaurantService() throws JSONException {
 
		JSONArray jsonArr = new JSONArray();
		JSONObject returnObj = new JSONObject();
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		
		try{
			dbConnection db = new dbConnection();
			con = db.getConnection();
			
			cs = con.prepareCall("call PopularResList()");
			rs = cs.executeQuery();
		
			JSONObject jsonObject;
			while(rs.next()){
				jsonObject = new JSONObject();
				jsonObject.put("Res_Id", rs.getString("Res_Id"));
				jsonObject.put("Res_Name", rs.getString("Res_Name"));
				jsonObject.put("Res_Description", rs.getString("Res_Description"));
				jsonObject.put("MainImg_Path", rs.getString("MainImg_Path"));
				jsonObject.put("MainImg_Name", rs.getString("MainImg_Name"));
				jsonObject.put("Total_review", rs.getString("Total_review"));
				jsonObject.put("Rate", rs.getString("Rate"));
				
				jsonArr.put(jsonObject);
			}
				
		}catch(SQLException se){
			System.out.println(se.getMessage());			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			if(cs != null) try{cs.close();}catch(Exception e){}
			if(con != null) try{con.close();}catch(Exception e){}
		}
	
		returnObj.put("restaurants", jsonArr);				
		return Response.status(200).entity(returnObj.toString()).build();
	  }
	  
	  
	  @GET
	  @Path("/list/{listDiv}")
	  @Produces("application/json")
	  public Response getResList(@PathParam("listDiv") String listDiv) throws JSONException {
		
		JSONArray jsonArr = new JSONArray();
		JSONObject returnObj = new JSONObject();
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		
		try{
			dbConnection db = new dbConnection();
			con = db.getConnection();
			
			switch (listDiv.toUpperCase())
			{
				case "P": //Popular Restaurants
					cs = con.prepareCall("call PopularResList()");
					break;
				default:
					cs = con.prepareCall("call PopularResList()");
					break;
			}
			
			rs = cs.executeQuery();
		
			JSONObject jsonObject;
			while(rs.next()){
				jsonObject = new JSONObject();
				jsonObject.put("Res_Id", rs.getString("Res_Id"));
				jsonObject.put("Res_Name", rs.getString("Res_Name"));
				jsonObject.put("Res_Description", rs.getString("Res_Description"));
				jsonObject.put("MainImg_Path", rs.getString("MainImg_Path"));
				jsonObject.put("MainImg_Name", rs.getString("MainImg_Name"));
				jsonObject.put("Total_review", rs.getString("Total_review"));
				jsonObject.put("Rate", rs.getString("Rate"));
				
				jsonArr.put(jsonObject);
			}
				
		}catch(SQLException se){
			System.out.println(se.getMessage());			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			if(cs != null) try{cs.close();}catch(Exception e){}
			if(con != null) try{con.close();}catch(Exception e){}
		}
		
		returnObj.put("restaurants", jsonArr);			
		return Response.status(200).entity(returnObj.toString()).build();
	  } 
	  
}