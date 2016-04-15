using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using EOES_ClassLib;

namespace EOES_UnitTest
{
    [TestClass]
    public class UnitTest_TextRender
    {
        [TestMethod]
        public void Test_HighlightKeyWords()
        {
            //input params - text, keyword, css style, full match
            string text = "he method is rather simple. We set up a new BankAccount object with a beginning balance and then withdraw a valid amount. We use the Microsoft unit test framework for managed code AreEqual";
            string keyword = "BankAcc";
            string css = "yellow";
            bool isMatched = true;

            //act
            string actual = TextRender.HighlightKeyWords(text, keyword, css, isMatched);
            string expected = "he method is rather simple. We set up a new <span style=\"background-color:yellow\">BankAcc</span>ount object with a beginning balance and then withdraw a valid amount. We use the Microsoft unit test framework for managed code AreEqual";
            Assert.AreEqual(expected, actual, true, "HighlightKeyWords value is not equal from expected value.");

        }

        [TestMethod]
        public void Test_Truncate()
        {
            //input params
            string text = "The test result contains a message that describes the failure. For the AreEquals method, message displays you what was expected (the (Expected<XXX>parameter) and what was actually received (the Actual<YYY> parameter). We were expecting the balance to decline from the beginning balance, but instead it has increased by the amount of the withdrawal.A reexamination of the Debit code shows that the unit test has succeeded in finding a bug.The amount of the withdrawal is added to the account balance when it should be subtracted.";
            int length = 100;

            //act
            string actual = TextRender.Truncate(text, length);
            string expected = text.Substring(0,length) + "...";
            Assert.AreEqual(expected, actual, true, "Truncate return value is not equal from expected value.");
        }

        [TestMethod]
        public void Test_Stars()
        {
            //input params
            string text = "3";
            string expVal = "";

            for(int i=0; i< Convert.ToInt32(text); i++)
            {
                expVal = expVal + "<span class='glyphicon glyphicon-star'></span>";
            }

            for (int i = 0; i < 2; i++)
            {
                expVal = expVal + "<span class='glyphicon glyphicon-star-empty'></span>";
            }

            //act
            string actual = TextRender.Stars(text);
            string expected = expVal;
            Assert.AreEqual(expected, actual, true, "Stars return value is not equal from expected value.");
        }
    }
}
