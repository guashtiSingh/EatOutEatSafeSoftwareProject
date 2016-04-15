using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using EOES_ClassLib;

namespace EOES_UnitTest
{
    [TestClass]
    public class UnitTest_Utilities
    {
        [TestMethod]
        public void RenderTextBr()
        {
            //input params
            string text = "The test result contains a message\r that describes the failure.\n For the AreEquals method, message displays you what was expected (the (Expected<XXX>parameter) and what was actually received (the Actual<YYY> parameter). We were expecting the balance to decline from the beginning balance, but instead it has increased by the amount of the withdrawal.A reexamination of the Debit code shows that the unit test has succeeded in finding a bug.The amount of the withdrawal is added to the account balance when it should be subtracted.";

            //act
            string actual = Utilities.RenderTextBr(text);
            string expected = text.Replace("\r", "<br/>").Replace("\n", "<br/>");
            Assert.AreEqual(expected, actual, true, "RenderTextBr return value is not equal from expected value.");

        }
    }
}
