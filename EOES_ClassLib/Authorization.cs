using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;

namespace EOES_ClassLib
{
    public struct UserDetail
    {
        private string firstName;
        private string lastName;
        private string email;
        private string password;
        private string userId;
        private int ucID;

        public string FirstName
        {
            get { return firstName; }
            set { firstName = value; }
        }

        public string LastName
        {
            get { return lastName; }
            set { lastName = value; }
        }

        public string Email
        {
            get { return email; }
            set { email = value; }
        }

        public string Password
        {
            get { return password; }
            set { password = value; }
        }

        public string UserId
        {
            get { return userId; }
            set { userId = value; }
        }

        public int UcID
        {
            get { return ucID; }
            set { ucID = value; }
        }
    }
    public class Authorization
    {
        dbCon con = new dbCon();
        Dictionary<string, string> Param = new Dictionary<string, string>();

        public Authorization()
        {
            //
            // TODO: Add constructor logic here
            //
        }

        public UserDetail userDetail(string userId)
        {
            Param.Clear();

            DataSet userDetailsDS;
            DataTable user;

            //Restaruants detail information
            Param.Add("userId", userId);
            userDetailsDS = con.SelectProcWithParam("UserDetail", Param);

            UserDetail details = new UserDetail();


            if (userDetailsDS.Tables[0].Rows.Count > 0)
            {
                user = userDetailsDS.Tables[0];

                details.FirstName = user.Rows[0]["User_FirstName"].ToString();
                details.LastName = user.Rows[0]["User_LastName"].ToString();
                details.Password = user.Rows[0]["User_Pwd"].ToString();
                details.Email = user.Rows[0]["User_Email"].ToString();
                details.UserId = user.Rows[0]["User_Id"].ToString();
                details.UcID = Convert.ToUInt16(user.Rows[0]["UC_Id"].ToString());
            }

            return details;
        }

        public UserDetail userLogin(string userId, string pwd)
        {
            DataSet userDetailsDS;
            DataTable user;
            UserDetail details = new UserDetail();

            Param.Clear();

            Param.Add("userId", userId);
            Param.Add("pwd", pwd);

            userDetailsDS = con.SelectProcWithParam("LoginUser", Param);

            if (userDetailsDS.Tables[0].Rows.Count > 0)
            {
                user = userDetailsDS.Tables[0];

                details.FirstName = user.Rows[0]["User_FirstName"].ToString();
                details.LastName = user.Rows[0]["User_LastName"].ToString();
                details.Password = pwd;
                details.Email = user.Rows[0]["User_Email"].ToString();
                details.UserId = userId;
                details.UcID = Convert.ToUInt16(user.Rows[0]["UC_Id"].ToString());

            }

            return details;

        }

        public bool insertUser(string userId, string fName, string lName, string pwd, string email, string role)
        {
            Param.Clear();

            Param.Add("userId", userId);
            Param.Add("fName", fName);
            Param.Add("lName", lName);
            Param.Add("pwd", pwd);
            Param.Add("email", email);
            Param.Add("role", role);

            DataSet ds = con.SelectProcWithParam("SingupUser", Param);
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
