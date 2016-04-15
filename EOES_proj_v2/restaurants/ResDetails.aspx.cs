using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using MySql.Data.MySqlClient;
using System.Web.Security;
using AjaxControlToolkit;
using EOES_ClassLib;

public partial class restaurants_ResDetails : System.Web.UI.Page
{
    string divClass;
    string imgClass;
    string Res_Id = "";
    protected int menuListCount = 0;

    Restaurants res = new Restaurants();
    Reviews rv = new Reviews();
    Menus m = new Menus();

    protected void Page_Load(object sender, EventArgs e)
    {
        //string Res_Id;

        Res_Id = Request.QueryString["ResId"];


        if (Res_Id == "" || Res_Id == null)
        {

        }
        else
        {
            //menu lists
            Repeater1.DataSource = m.MenuList(Res_Id, "0"); //All menus
            Repeater2.DataSource = m.MenuList(Res_Id, "1"); //Special menus
            Repeater1.DataBind();
            Repeater2.DataBind();

            //Restaruants detail information
            resDeatilView.DataSource = res.RestaurantDetail(Res_Id);
            resDeatilView.DataBind();

            imgListView.DataSource = res.ResImages(Res_Id, "1");
            imgListView.DataBind();

            getReview(Res_Id);

        }
    }

    protected string GetDivClass(int rowNo, string tag)
    {
        if (tag == "img")
            return SetDiv(rowNo);
        else
            return (rowNo == 1) ? "item active" : "item";
    }

    protected string SetDiv(int rowNo)
    {
        Dictionary<int, string> numbering = new Dictionary<int, string>();
        numbering.Add(1, "first");
        numbering.Add(2, "second");
        numbering.Add(3, "third");
        numbering.Add(4, "fourth");
        numbering.Add(5, "fifth");
        numbering.Add(6, "sixth");
        numbering.Add(7, "seventh");
        numbering.Add(8, "eighth");
        numbering.Add(9, "ninth");
        numbering.Add(10, "tenth");

        return numbering[rowNo];
    }


    protected void btnSubmit_Click(object sender, EventArgs e)
    {
        //Response.Write("<script>alert('Error! Please try again');</script>");

        HttpCookie myCookie = new HttpCookie("userInfo");
        myCookie["userId"] = "zxcv";

        //if (Convert.ToString(Request.Cookies["userInfo"]) != "")
        if ("zxcv" == "zxcv")
        {

            //string userID = Request.Cookies["userInfo"]["userId"];
            string userID = "zxcv";
            string title = reviewTitle.Text;
            string content = reviewContent.Text;
            string rate = reviewRate.SelectedValue.ToString();

            bool isSuccess = rv.InsertReview(Res_Id, title, content, userID, "", "", rate);

            if (isSuccess)
            {
                reviewTitle.Text = string.Empty;
                reviewContent.Text = string.Empty;

                upnelList.Update();
                getReview(Res_Id);
            }
            else { Response.Write("<script>alert('No insert');</script>"); }

        }
        else
        {
            Response.Write("<script>alert('No login');</script>");
        }
    }

    private void getReview(string ResId)
    {
        topReviews.DataSource = rv.GetReviews(ResId, "1");
        topReviews.DataBind();
        allReviews.DataSource = rv.GetReviews(ResId, "0");
        allReviews.DataBind();
    }
}