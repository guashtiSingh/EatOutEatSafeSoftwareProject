using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using EOES_ClassLib;

public partial class login_Login : System.Web.UI.Page
{
    Authorization auth = new Authorization();
    UserDetail user = new UserDetail();

    protected void Page_Load(object sender, EventArgs e)
    {
        String userId = Request.Params["userId"];
        String pwd = Request.Params["pwd"];

        if (userId != "" && pwd != "")
        {
            Login(userId, pwd);
        }
        
    }

    protected void Login(String userId, String pwd)
    {

        if (userId == null || userId == "" || pwd == null || pwd == "")
        {
            Response.Write("Please enter required field");
        }
        else
        {
            user = auth.userLogin(userId, pwd);

            if (!(user.UserId == null || user.UserId == ""))
            {
                user = auth.userDetail(userId);

                HttpCookie myCookie = new HttpCookie("userInfo");
                myCookie["userId"] = user.UserId;
                myCookie["userfullName"] = user.FirstName + " " + user.LastName;
                myCookie["role"] = "" + user.UcID;

                myCookie.Expires = DateTime.Now.AddMinutes(30.0);
                Response.Cookies.Add(myCookie);

                Response.Write("success");
            }
            else
            {
                Response.Write("Fail to user login. Please enter correct User ID and Password.");
            }
        }
        Response.End();
    }
}