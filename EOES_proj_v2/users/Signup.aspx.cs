using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using EOES_ClassLib;

public partial class users_Signup : System.Web.UI.Page
{
    Authorization auth = new Authorization();
    UserDetail user = new UserDetail();
    bool isSuccess = false;

    protected void Page_Load(object sender, EventArgs e)
    {
        
    }

    protected void btnSubmit_Click(object sender, EventArgs e)
    {
        string userId = txtUId.Text;
        string fName = txtFname.Text;
        string lName = txtLname.Text;
        string pwd = txtPwd.Text;
        string email = txtEmail.Text;
        string role = "2";

        isSuccess = auth.insertUser(userId, fName, lName, pwd, email, role);

        if(isSuccess)
        {
            user = auth.userDetail(userId);

            HttpCookie myCookie = new HttpCookie("userInfo");
            myCookie["userId"] = user.UserId;
            myCookie["userName"] = user.FirstName + " " + user.LastName;
            myCookie["role"] = "" + user.UcID;

            Response.Redirect("/Default.aspx");
        }
        else
        {
            Response.Write("<script>alert('No insert');</script>");
        }
        
    }
}