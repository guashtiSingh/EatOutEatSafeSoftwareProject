using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using EOES_ClassLib;

namespace EOES_UnitTest
{
    [TestClass]
    public class UnitTest_Authorization
    {
        [TestMethod]
        public void userDetailTest()
        {
            //arrange
            Authorization au = new Authorization();

            //act
            UserDetail ud = au.userDetail("zxcv");

            //assert (will complete after user authorization developed.)
            UserDetail e_ud = new UserDetail();
            e_ud.FirstName = "Joanna";
            e_ud.LastName = "Seo";
            e_ud.Email = "Joanna@gmail.com";
            e_ud.Password = "1234";
            e_ud.UserId = "zxcv";
            e_ud.UcID = 2;

            Assert.AreEqual(e_ud, ud);
        }

        [TestMethod]
        public void userLoginTest()
        {
            //arrange
            Authorization au = new Authorization();

            //act
            UserDetail ud = au.userLogin("zxcv", "1234");

            //assert (will complete after user authorization developed.)
            UserDetail e_ud = new UserDetail();
            e_ud.FirstName = "Joanna";
            e_ud.LastName = "Seo";
            e_ud.Email = "Joanna@gmail.com";
            e_ud.Password = "1234";
            e_ud.UserId = "zxcv";
            e_ud.UcID = 2;

            Assert.AreEqual(e_ud, ud);
        }

        [TestMethod]
        public void insertUserTest()
        {
            //arrange
            Authorization au = new Authorization();

            //act
            bool isSuccess = au.insertUser("UnitTest", "Unit", "test", "1234", "unit@gmail.com", "2");

            Assert.AreEqual(isSuccess, true);
        }
    }
}
