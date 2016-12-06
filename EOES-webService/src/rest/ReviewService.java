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

import conf.dbConnection;
import model.Review;
import model.User;
import conf.JSONGenerator;
 
@Path("/review")
public class ReviewService {
 
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
			
			cs = con.prepareCall("call ReviewList(?,?)");
			cs.setString("Res_Id", resId);
			cs.setString("isTop", "1");
			rs = cs.executeQuery();
			
			jg = new JSONGenerator();
			jsonArr = jg.transforJSON(rs);
			returnObj.put("reviews", jsonArr);	
			
				
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
	  @Path("/list/{resId}/{isTop}")
	  @Produces("application/json")
	  public Response getRvList(@PathParam("resId") String resId, @PathParam("isTop") String isTop) throws JSONException {
		
		JSONArray jsonArr = new JSONArray();
		JSONObject returnObj = new JSONObject();
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		
		try{
			dbConnection db = new dbConnection();
			con = db.getConnection();
			
			if(!(isTop.equals("1")||isTop.equals("0"))) isTop = "0";  
			
			cs = con.prepareCall("call ReviewList(?,?)");
			cs.setString("Res_Id", resId);
			cs.setString("isTop", isTop); //1:top reviews only, 0:all reviews
			
			rs = cs.executeQuery();
			jg = new JSONGenerator();
			jsonArr = jg.transforJSON(rs);
			returnObj.put("reviews", jsonArr);						
			
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
	  
	  @POST
	  @Path("/insert")
	  @Consumes(MediaType.APPLICATION_JSON)
	  @Produces("application/json")
	  public Response insertReview(Review review) throws JSONException {

		JSONObject returnObj = new JSONObject();
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		
		try{
			dbConnection db = new dbConnection();
			con = db.getConnection();
			
			cs = con.prepareCall("call InsertReview(?,?,?,?,?,?,?)");
			cs.setString("Res_Id", review.getResId());			
			cs.setString("title", review.getReviewTitle()); 
			cs.setString("content", review.getReviewContent()); 
			cs.setString("userId", review.getUserId()); 
			cs.setString("imgPath", review.getMainImgPath()); 
			cs.setString("imgName", review.getMainImgName()); 
			cs.setString("rate", review.getRate()); 
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
	  
	  @POST
	  @Path("/update")
	  @Consumes(MediaType.APPLICATION_JSON)
	  @Produces("application/json")
	  public Response updateReview(Review review) throws JSONException {

		JSONObject returnObj = new JSONObject();
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		
		try{
			dbConnection db = new dbConnection();
			con = db.getConnection();
			
			cs = con.prepareCall("call UpdateReview(?,?,?,?,?,?,?,?)");
			cs.setString("resId", review.getResId());	
			cs.setString("rvId", review.getReviewId());	
			cs.setString("title", review.getReviewTitle()); 
			cs.setString("content", review.getReviewContent()); 
			cs.setString("userId", review.getUserId()); 
			cs.setString("imgPath", review.getMainImgPath()); 
			cs.setString("imgName", review.getMainImgName()); 
			cs.setString("rate", review.getRate()); 
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
	  
	  @POST
	  @Path("/delete")
	  @Consumes(MediaType.APPLICATION_JSON)
	  @Produces("application/json")
	  public Response deleteReview(Review review) throws JSONException {

		JSONObject returnObj = new JSONObject();
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		
		try{
			dbConnection db = new dbConnection();
			con = db.getConnection();
			
			cs = con.prepareCall("call DeleteReview(?,?)");
			cs.setString("rvId", review.getReviewId());			
			cs.setString("userId", review.getUserId()); 
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
	  
	  public JSONObject getRvJsonList(String resId, String isTop) throws JSONException {
			
			JSONArray jsonArr = new JSONArray();
			JSONObject returnObj = new JSONObject();
			Connection con = null;
			CallableStatement cs = null;
			ResultSet rs = null;
			
			try{
				dbConnection db = new dbConnection();
				con = db.getConnection();
				
				if(!(isTop.equals("1")||isTop.equals("0"))) isTop = "0";  
				
				cs = con.prepareCall("call ReviewList(?,?)");
				cs.setString("Res_Id", resId);
				cs.setString("isTop", isTop); //1:top reviews only, 0:all reviews
				
				rs = cs.executeQuery();
				jg = new JSONGenerator();
				jsonArr = jg.transforJSON(rs);
				returnObj.put("reviews", jsonArr);						
				
			}catch(SQLException se){
				System.out.println(se.getMessage());			
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				if(cs != null) try{cs.close();}catch(Exception e){}
				if(con != null) try{con.close();}catch(Exception e){}
			}	
			
			return returnObj;	
			
		  } 
	  
}
