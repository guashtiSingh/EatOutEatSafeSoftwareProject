using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using MySql.Data.MySqlClient;

namespace EOES_ClassLib
{
    public class Reviews
    {
        dbCon con = new dbCon();
        Dictionary<string, string> Param = new Dictionary<string, string>();

        public Reviews()
        {
            //
            // TODO: Add constructor logic here
            //
        }

        public DataSet GetReviews(string resId, string isTop)
        {
            Param.Clear();
            Param.Add("Res_Id", resId);
            Param.Add("isTop", isTop);

            return con.SelectProcWithParam("ReviewList", Param);
        }

        public bool InsertReview(string resId, string title, string content, string userId, string imgPath, string imgName, string rate)
        {
            Param.Clear();

            string rvId = Utilities.GenerateID();

            Param.Add("Res_Id", resId);
            Param.Add("rv_Id", rvId);
            Param.Add("title", title);
            Param.Add("content", content);
            Param.Add("userId", userId);
            Param.Add("imgPath", imgPath);
            Param.Add("imgName", imgName);
            Param.Add("rate", rate);

            DataSet ds = con.SelectProcWithParam("InsertReview", Param);
            DataTable dt = ds.Tables[0];

            if (dt.Rows[0][0].ToString() == "1")
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public bool UpdateReview(string rvId, string resId, string title, string content, string userId, string imgPath, string imgName, string rate)
        {
            Param.Clear();

            Param.Add("Res_Id", resId);
            Param.Add("rv_Id", rvId);
            Param.Add("title", title);
            Param.Add("content", content);
            Param.Add("userId", userId);
            Param.Add("imgPath", imgPath);
            Param.Add("imgName", imgName);
            Param.Add("rate", rate);

            DataSet ds = con.SelectProcWithParam("UpdateReview", Param);
            DataTable dt = ds.Tables[0];

            if (dt.Rows[0][0].ToString() == "1")
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
}
