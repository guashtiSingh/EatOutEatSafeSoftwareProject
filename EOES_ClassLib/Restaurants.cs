using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using MySql.Data.MySqlClient;

namespace EOES_ClassLib
{
    public class Restaurants
    {
        dbCon con = new dbCon();
        Dictionary<string, string> Param = new Dictionary<string, string>();

        public Restaurants()
        {
            //
            // TODO: Add constructor logic here
            //
        }

        public DataSet SearchList(string searchStr)
        {
            Param.Clear();
            Param.Add("keyword", searchStr);
            return con.SelectProcWithParam("searchList", Param);
        }

        public DataSet PopularResList()
        {
            return con.SelectProc("PopularResList");
        }

        public DataSet AllergyResList(string searchStr)
        {
            Param.Clear();
            Param.Add("keyword", searchStr);
            return con.SelectProcWithParam("AllergyResList", Param);
        }

        public DataSet LocationResList(string searchStr)
        {
            Param.Clear();
            Param.Add("keyword", searchStr);
            return con.SelectProcWithParam("LocationResList", Param);
        }

        public DataSet RestaurantDetail(string resId)
        {
            Param.Clear();
            Param.Add("Res_Id", resId);

            return con.SelectProcWithParam("ResDetails", Param);
        }

        public DataSet ResImages(string resId, string cate)
        {
            Param.Clear();
            Param.Add("refer_Id", resId);
            Param.Add("cate_Id", cate);

            return con.SelectProcWithParam("DetailImages", Param);
        }
    }
}
