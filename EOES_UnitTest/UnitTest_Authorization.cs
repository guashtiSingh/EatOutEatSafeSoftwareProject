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
            UserDetail ud = au.userDetail("1");

            //assert (will complete after user authorization developed.)
            UserDetail e_ud = new UserDetail();
            e_ud.FirstName = "";
            e_ud.LastName = "";
            e_ud.Email = "";
            e_ud.Password = "";
            e_ud.UserId = "";
            e_ud.UcID = 0;

            Assert.AreEqual(e_ud, ud);
        }
    }
}
