using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Data;
using EOES_ClassLib;

namespace EOES_UnitTest
{
    [TestClass]
    public class UnitTest_Restaurants
    {
        [TestMethod]
        public void SearchListTest()
        {
            //arrange
            Restaurants r = new Restaurants();

            //act
            DataSet ds = r.SearchList("Pizzaiolo");

            //assert
            DataRow[] dr = ds.Tables[0].Select("[Res_Id] = '21927'");
            Assert.AreEqual(1, dr.Length);
        }

        [TestMethod]
        public void PopularResListTest()
        {
            //arrange
            Restaurants r = new Restaurants();

            //act
            DataSet ds = r.PopularResList();

            //assert
            DataRow[] dr = ds.Tables[0].Select("[Total_review] = 14");
            Assert.AreEqual(1, dr.Length);
        }

        [TestMethod]
        public void RestaurantDetailTest()
        {
            //arrange
            Restaurants r = new Restaurants();

            //act
            DataSet ds = r.RestaurantDetail("41096");

            //assert
            DataRow[] dr = ds.Tables[0].Select("[Res_Name] = 'The Keg'");
            Assert.AreEqual(1, dr.Length);
        }

        [TestMethod]
        public void ResImagesTest()
        {
            //arrange
            Restaurants r = new Restaurants();

            //act
            DataSet ds = r.ResImages("8082", "1");

            //assert
            DataRow[] dr = ds.Tables[0].Select("[Img_Name] = 'SneakyDees-03.jpg'");
            Assert.AreEqual(1, dr.Length);
        }
    }
}
