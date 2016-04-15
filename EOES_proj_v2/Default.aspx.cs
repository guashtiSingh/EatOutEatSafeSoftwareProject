using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Configuration;
using MySql.Data.MySqlClient;
using EOES_ClassLib;

public partial class _Default : System.Web.UI.Page
{
    protected string searchStr = String.Empty;
    protected string tempTitle = String.Empty;

    Restaurants res = new Restaurants();

    protected void Page_Load(object sender, EventArgs e)
    {

        searchDiv.Attributes["onclick"] = ClientScript.GetPostBackEventReference(this, "FillPageListView");

        searchStr = search.Text;

        FillPageListView();

    }

    private void FillPageListView()
    {
        if (searchStr != "")
        {
            Repeater1.DataSource = res.SearchList(searchStr);

        }
        else
        {
            Repeater1.DataSource = res.PopularResList();
        }

        Repeater2.DataSource = res.AllergyResList(searchStr);
        Repeater3.DataSource = res.LocationResList(searchStr);

        Repeater1.DataBind();
        Repeater2.DataBind();
        Repeater3.DataBind();
    }

    protected bool checkContentTitle(String val)
    {
        if (val == tempTitle)
        {
            return true;
        }
        else
        {
            tempTitle = val;
            return false;
        }

    }
}