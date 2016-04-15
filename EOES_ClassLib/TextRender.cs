using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Text.RegularExpressions;

namespace EOES_ClassLib
{
    public static class TextRender
    {

        public static string HighlightKeyWords(this string text, string keywords, string cssClass, bool fullMatch)
        {
            var words = keywords.Split(new[] { ',' }, StringSplitOptions.RemoveEmptyEntries);

            foreach (string sKeyword in words)
            {
                try
                {
                    text = Regex.Replace(text, sKeyword, string.Format("<span style=\"background-color:{0}\">{1}</span>", cssClass, "$0"), RegexOptions.IgnoreCase);
                }
                catch
                {
                    //
                }
            }

            return text;

        }

        //Truncate text by max length
        public static string Truncate(this string text, int maxLength)
        {
            if (string.IsNullOrEmpty(text)) return text;

            return text.Length <= maxLength ? text : text.Substring(0, maxLength) + "...";
        }


        //html code for review stars
        public static string Stars(this string text)
        {
            string returnVal = "";

            if (text == "") text = "0.0";

            int fullStars = Convert.ToInt32(text.Substring(0, 1));
            int emptyStars = 5 - fullStars;

            for (int i = 0; i < fullStars; i++)
            {
                returnVal = returnVal + "<span class='glyphicon glyphicon-star'></span>";
            }

            for (int j = 0; j < emptyStars; j++)
            {
                returnVal = returnVal + "<span class='glyphicon glyphicon-star-empty'></span>";
            }

            return returnVal;
        }
    }
}
