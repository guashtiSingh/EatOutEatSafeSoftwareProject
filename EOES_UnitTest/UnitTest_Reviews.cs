using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Data;
using EOES_ClassLib;

namespace EOES_UnitTest
{
    [TestClass]
    public class UnitTest_Reviews
    {
        [TestMethod]
        public void GetReviewsTest()
        {
            //arrange
            Reviews r = new Reviews();

            //act
            DataSet ds = r.GetReviews("39958", "1");

            //assert
            DataRow[] dr = ds.Tables[0].Select("[RV_Id] = '23421'");
            Assert.AreEqual(1, dr.Length);
        }

        [TestMethod]
        public void InsertReviewTest()
        {
            //arrange
            Reviews r = new Reviews();

            //act
            Boolean b = r.InsertReview("39958", "best restraunt", "best service and best food!!", "zxcv", "", "", "5");

            //assert
            Assert.AreEqual(true, b);
        }

        [TestMethod]
        public void UpdateReviewTest()
        {
            //arrange
            Reviews r = new Reviews();

            //act        
            Boolean b = r.UpdateReview("23421", "39958", "so-so", "their service was bad!!", "zxcv", "", "", "2");

            //assert
            Assert.AreEqual(true, b);
        }

    }
}
