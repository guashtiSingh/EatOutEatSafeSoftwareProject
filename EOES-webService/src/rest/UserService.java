package rest;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import conf.JSONGenerator;
import conf.dbConnection;
import model.User;

@Path("/user")
public class UserService {

	JSONGenerator jg = null;
	
	  @POST
	  @Path("/login")
	  @Consumes(MediaType.APPLICATION_JSON)
	  @Produces("application/json")
	  public Response UserLogin(User user) throws JSONException {

		JSONArray jsonArr = new JSONArray();
		JSONObject returnObj = new JSONObject();
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		
		try{
			dbConnection db = new dbConnection();
			con = db.getConnection();
			
			cs = con.prepareCall("call LoginUser(?,?)");
			cs.setString("userId", user.getUserId());
			cs.setString("pwd", user.getPassword()); 
			rs = cs.executeQuery();
			
			if(rs.next()){
				jg = new JSONGenerator();
				rs.beforeFirst(); 
				jsonArr = jg.transforJSON(rs);
				returnObj.put("resultMsg", "success");	
				returnObj.put("user", jsonArr);				
			}else{
				returnObj.put("resultMsg", "fail");	
				returnObj.put("user", "");	
			}
			
				
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
	  
	  @POST
	  @Path("/signup")
	  @Consumes(MediaType.APPLICATION_JSON)
	  @Produces("application/json")
	  public Response UserSignup(User user) throws JSONException {

		JSONObject returnObj = new JSONObject();
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		
		try{
			dbConnection db = new dbConnection();
			con = db.getConnection();
			
			cs = con.prepareCall("call SignupUser(?,?,?,?,?,?)");
			cs.setString("userId", user.getUserId());
			cs.setString("fName", user.getFirstName()); 
			cs.setString("lName", user.getLastName());
			cs.setString("pwd", user.getPassword()); 
			cs.setString("email", user.getEmail());
			cs.setString("role", "2"); //1:manager, 2:customer
						
			rs = cs.executeQuery();
			
			if(rs.next()){				
				returnObj.put("resultMsg", "success");						
			}else{
				returnObj.put("resultMsg", "fail");	
			}
				
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
}
