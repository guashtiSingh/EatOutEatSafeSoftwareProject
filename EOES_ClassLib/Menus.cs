using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using MySql.Data.MySqlClient;

namespace EOES_ClassLib
{
    public class Menus
    {
        dbCon con = new dbCon();
        Dictionary<string, string> Param = new Dictionary<string, string>();

        public Menus()
        {
            //
            // TODO: Add constructor logic here
            //
        }

        public DataSet MenuList(string resId, string isSpecial)
        {
            Param.Clear();
            Param.Add("resId", resId);
            Param.Add("isSpecial", isSpecial);
            return con.SelectProcWithParam("menuList", Param);
        }
    }
}
