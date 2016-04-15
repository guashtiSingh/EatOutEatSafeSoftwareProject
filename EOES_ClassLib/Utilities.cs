using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EOES_ClassLib
{
    public static class Utilities
    {
        public static string GenerateID()
        {
            Random rd = new Random();

            return Convert.ToString(rd.Next(10000000, 100000000));
        }

        public static string RenderTextBr(string text)
        {
            return text.Replace("\r", "<br/>").Replace("\n", "<br/>");
        }
    }
}
