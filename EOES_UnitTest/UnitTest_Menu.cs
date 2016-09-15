using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Data;
using EOES_ClassLib;

namespace EOES_UnitTest
{
    [TestClass]
    public class UnitTest_Menu
    {
        [TestMethod]
        public void MenuListTest()
        {
            //arrange
            Menus m = new Menus();

            //act
            DataSet ds = m.MenuList("21927", "1");

            //assert
            DataRow[] dr = ds.Tables[0].Select("[Menu_Name] = 'Cactus in the Valley'");
            Assert.AreEqual(1, dr.Length);
        }
        
    }
}
