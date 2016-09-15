using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using EOES_ClassLib;
using System.Web.Security;

public partial class MasterPage : System.Web.UI.MasterPage
{
    Authorization auth = new Authorization();
    UserDetail user = new UserDetail();

    HttpContext context = HttpContext.Current;
    public string userID;
    public string userfullName;
    public bool isAdmin;


    protected void Page_Load(object sender, EventArgs e)
    {
        if (!Page.IsPostBack)
        {
            if (Convert.ToString(Request.Cookies["userInfo"]) != "")
            {
                userID = Request.Cookies["userInfo"]["userId"];
                userfullName = Request.Cookies["userInfo"]["userfullName"];
                userName.Text = userfullName;
                this.MultiView1.ActiveViewIndex = 1;
            }
            else
            {
                this.MultiView1.ActiveViewIndex = 0;
            }
        }
    }

    protected void btnLogout_Click(object sender, EventArgs e)
    {

        string redPath = FormsAuthentication.GetRedirectUrl(context.User.Identity.Name, false);

        FormsAuthentication.SignOut();

        //delete cookie
        if (Request.Cookies["userInfo"] != null)
        {
            HttpCookie myCookie = new HttpCookie("userInfo");
            myCookie.Expires = DateTime.Now.AddDays(-1d);
            Response.Cookies.Add(myCookie);
        }

        Response.Redirect("/Default.aspx", false);
    }
}
