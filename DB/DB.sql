-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: eoes
-- ------------------------------------------------------
-- Server version	5.6.28-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `allergycategories`
--

DROP TABLE IF EXISTS `allergycategories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `allergycategories` (
  `AC_Id` int(11) NOT NULL,
  `AC_Name` varchar(50) NOT NULL,
  `AC_Description` longtext,
  PRIMARY KEY (`AC_Id`),
  UNIQUE KEY `AC_Id_UNIQUE` (`AC_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `allergycategories`
--

LOCK TABLES `allergycategories` WRITE;
/*!40000 ALTER TABLE `allergycategories` DISABLE KEYS */;
INSERT INTO `allergycategories` VALUES (9010,'Soy','A member of the legume family, soy is a common ingredient in infant formulas and many other processed foods. In young children, soy is one of the most common food allergens. Typically, allergic reactions first appear in infants and children under 3, and most of them outgrow the allergy by age 10.'),(16956,'Wheat','Wheat allergies, like hay fever and other allergies, develop when the body’s immune system becomes sensitized and overreacts to something in the environment — in this case, wheat — that typically causes no problem in most people.'),(29518,'Milk','Between 2 and 3 percent of children younger than 3 are allergic to milk. Although experts once believed that the vast majority of them would outgrow this allergy by the time they turned 3, recent studies contradict this theory. In one study, fewer than 20 percent of children had outgrown their allergy by age 4. Still, about 80 percent of children are likely to outgrow their milk allergy before they are 16.'),(34898,'Soy','A member of the legume family, soy is a common ingredient in infant formulas and many other processed foods. In young children, soy is one of the most common food allergens. Typically, allergic reactions first appear in infants and children under 3, and most of them outgrow the allergy by age 10.'),(39032,'Peanut','Many schools have declared that they are “nut-free,” meaning that the onetime staple of kids’ lunchboxes — a peanut butter and jelly sandwich — is nowhere to be found on school grounds these days. That’s because peanuts can cause a life-threatening reaction in some people. Peanuts are one of the food allergens most commonly associated with anaphylaxis, a sudden and potentially deadly condition that requires immediate attention and treatment.'),(46979,'Sellfish','Shellfish is among the most common food allergens. It is also one of the most dangerous, sending more food-allergic people to hospital emergency rooms than any other.'),(47455,'Corn','A corn allergy can be difficult to diagnose using standard skin or blood tests because it is difficult to differentiate from allergies to grass pollens and to other seeds and grain. A food elimination diet, in which specific items are removed from a person’s diet for a period of time to see if symptoms improve, is one way to determine whether a corn allergy is present.'),(48534,'Wheat','Wheat allergies, like hay fever and other allergies, develop when the body’s immune system becomes sensitized and overreacts to something in the environment — in this case, wheat — that typically causes no problem in most people.'),(51888,'Meat','A meat allergy can develop any time in life. If you are allergic to one type of meat, it is possible you also are allergic to other meats, as well as to poultry, such as chicken, turkey and duck.'),(54875,'Milk','Between 2 and 3 percent of children younger than 3 are allergic to milk. Although experts once believed that the vast majority of them would outgrow this allergy by the time they turned 3, recent studies contradict this theory. In one study, fewer than 20 percent of children had outgrown their allergy by age 4. Still, about 80 percent of children are likely to outgrow their milk allergy before they are 16.'),(56751,'Sellfish','Shellfish is among the most common food allergens. It is also one of the most dangerous, sending more food-allergic people to hospital emergency rooms than any other.'),(61716,'Corn','A corn allergy can be difficult to diagnose using standard skin or blood tests because it is difficult to differentiate from allergies to grass pollens and to other seeds and grain. A food elimination diet, in which specific items are removed from a person’s diet for a period of time to see if symptoms improve, is one way to determine whether a corn allergy is present.'),(71652,'Peanut','Many schools have declared that they are “nut-free,” meaning that the onetime staple of kids’ lunchboxes — a peanut butter and jelly sandwich — is nowhere to be found on school grounds these days. That’s because peanuts can cause a life-threatening reaction in some people. Peanuts are one of the food allergens most commonly associated with anaphylaxis, a sudden and potentially deadly condition that requires immediate attention and treatment.'),(88290,'Meat','A meat allergy can develop any time in life. If you are allergic to one type of meat, it is possible you also are allergic to other meats, as well as to poultry, such as chicken, turkey and duck.');
/*!40000 ALTER TABLE `allergycategories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `images`
--

DROP TABLE IF EXISTS `images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `images` (
  `Img_Id` int(11) NOT NULL,
  `Img_Path` varchar(200) NOT NULL,
  `Img_Name` varchar(50) NOT NULL,
  PRIMARY KEY (`Img_Id`),
  UNIQUE KEY `Img_Id_UNIQUE` (`Img_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `images`
--

LOCK TABLES `images` WRITE;
/*!40000 ALTER TABLE `images` DISABLE KEYS */;
INSERT INTO `images` VALUES (8241,'/images','Pizzaiolo-01.jpg'),(11852,'/images','SneakyDees-03.jpg'),(16854,'/images','SneakyDees-01.jpg'),(17722,'/images','pizza-rustica-02.jpg'),(25170,'/images','Almond Butterfly-01.jpg'),(30682,'/images','SneakyDees-02.jpg'),(32308,'/images','pizza-rustica-01.jpg'),(47606,'/images','Pizzaiolo-02.jpg'),(57533,'/images','Almond Butterfly-03.jpg'),(62808,'/images','Almond Butterfly-02.jpg'),(63264,'/images','Poutinis House Of Poutine-02.jpg'),(77528,'/images','Poutinis House Of Poutine-03.png'),(79263,'/images','Poutinis House Of Poutine-01.jpg'),(80685,'/images','pizza-rustica-03.jpg');
/*!40000 ALTER TABLE `images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imgbridge`
--

DROP TABLE IF EXISTS `imgbridge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `imgbridge` (
  `Category` varchar(30) NOT NULL,
  `Img_Id` int(11) NOT NULL,
  `Refer_Id` int(11) NOT NULL,
  PRIMARY KEY (`Category`,`Img_Id`,`Refer_Id`),
  KEY `ImgToBridge_idx` (`Img_Id`),
  KEY `TablesToBridge_idx` (`Refer_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imgbridge`
--

LOCK TABLES `imgbridge` WRITE;
/*!40000 ALTER TABLE `imgbridge` DISABLE KEYS */;
INSERT INTO `imgbridge` VALUES ('1',8241,21927),('1',11852,8082),('1',16854,8082),('1',17722,78362),('1',25170,39958),('1',30682,8082),('1',32308,78362),('1',47606,21927),('1',57533,39958),('1',62808,39958),('1',63264,24475),('1',77528,24475),('1',79263,24475),('1',80685,78362);
/*!40000 ALTER TABLE `imgbridge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locationcategories`
--

DROP TABLE IF EXISTS `locationcategories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `locationcategories` (
  `LC_Id` int(11) NOT NULL,
  `LC_Name` varchar(50) NOT NULL,
  `LC_Depth` varchar(10) NOT NULL,
  `LC_Description` longtext,
  PRIMARY KEY (`LC_Id`),
  UNIQUE KEY `LC_Id_UNIQUE` (`LC_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locationcategories`
--

LOCK TABLES `locationcategories` WRITE;
/*!40000 ALTER TABLE `locationcategories` DISABLE KEYS */;
INSERT INTO `locationcategories` VALUES (3371,'Thunder Bay','108','Thunder Bay'),(7427,'Midland','104','Midland'),(14271,'Windsor','101','Windsor'),(14570,'Kuujjuaq','208','Kuujjuaq'),(18848,'Saguenay','205','Saguenay'),(20182,'Quebec','200','Quebec'),(20647,'Ottawa','105','Ottawa'),(22482,'Churchill','310','Churchill'),(23652,'Gatineau','201','Gatineau'),(26867,'Portage La Prairie','306','Portage La Prairie'),(31616,'Quebec City','203','Quebec City'),(34717,'Winnipeg','302','Winnipeg is the capital of Manitoba'),(42422,'Sudbury','206','Sudbury'),(55420,'Moosonee','110','Moosonee'),(56227,'Dauphin','304','Dauphin'),(56714,'Montreal','202','Montreal'),(58150,'Inukjuak','209','Inukjuak'),(64567,'Matagami','207','Matagami'),(64769,'Morden','301','Morden'),(65162,'Toronto','103','Toronto'),(66044,'Manitoba','300','Manitoba'),(66848,'Emo','107','Emo'),(68275,'Pierson','303','Pierson'),(73957,'Thompson','309','Thompson'),(75309,'Steinbach','305','Steinbach'),(75794,'Niagara Falls','102','Niagara Falls'),(76939,'Sherbrooke','204','Sherbrooke'),(79957,'Sudbury','106','Sudbury'),(85305,'Kenora','109','Kenora'),(85435,'The Pas','308','The Pas'),(87406,'Brandon','307','Brandon'),(88186,'Ontario','100','Ontario');
/*!40000 ALTER TABLE `locationcategories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu` (
  `Menu_Id` int(11) NOT NULL,
  `Menu_Name` varchar(45) NOT NULL,
  `Menu_Price` double DEFAULT '0',
  `Menu_Description` longtext,
  `AC_Id` int(11) DEFAULT NULL,
  `Res_Id` int(11) DEFAULT NULL,
  `MainImg_Path` varchar(200) DEFAULT NULL,
  `MainImg_Name` varchar(50) DEFAULT NULL,
  `Is_Special` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`Menu_Id`),
  UNIQUE KEY `Menu_Id_UNIQUE` (`Menu_Id`),
  KEY `RestaurantsId_idx` (`Res_Id`),
  KEY `AllergyId_idx` (`AC_Id`),
  CONSTRAINT `AllergyId` FOREIGN KEY (`AC_Id`) REFERENCES `allergycategories` (`AC_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `RestaurantsId` FOREIGN KEY (`Res_Id`) REFERENCES `restaurants` (`Res_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (300,'Wild Mushroom',14.5,'A blend of field, oyster & Portobello mushrooms, basil pesto cream sauce, bruschetta tomatoes,seasoned mozzarella & gorgonzola cheese.Available in Whole Wheat and Gluten-Free. Vegan Daiya Mozzarella & Pepper Jack Cheddar available.',46979,24475,'/images/menu','wild_mushroom.jpeg',0),(4861,'Veggie Nachos',17,'Crisp corn tortilla chips covered with salsa roja, melted cheese, tomatoes, onions, mixed peppers, jalapenos, lettuce & sour cream.',39032,21927,'/images/menu','veggie_nachos.jpeg',0),(8561,'Wild Mushroom',15,'A blend of field, oyster & Portobello mushrooms, basil pesto cream sauce, bruschetta tomatoes,seasoned mozzarella & gorgonzola cheese.Available in Whole Wheat and Gluten-Free. Vegan Daiya Mozzarella & Pepper Jack Cheddar available.',56751,44338,'/images/menu','wild_mushroom.jpeg',0),(9967,'Pepes Pocket',7,'Frijoles, ground beef, onions & mild mixed peppers.',54875,41096,'/images/menu','pepes.jpeg',1),(19457,'Cactus in the Valley',23,'Crisp corn tortilla chips covered in salsa mole, melted cheese, rice, beans, sauteed peppers & onions (Sneaky style sauce), topped with pico de gallo, guacamole & sour cream (choice of steak, chicken or veggie).',29518,21927,'/images/menu','cactus.jpeg',1),(49647,'Veggie Tofu Wrap',10,'2Guacamole, onions, tofu, cucumbers, tomato, lettuce & roja salsa.',48534,39958,'/images/menu','tofu_wrap.jpeg',1),(53972,'Avocado Spring Rolls',8,'Pico de gallo, jalapenos & avocado.',9010,8082,'/images/menu','avocado.jpeg',0),(54934,'Burrito Grande',14,'In a huge flour tortilla stuffed with frijoles covered with salsa mole & melted cheese, and filled with your choice of beef, chicken, pulled pork, fish or vegetables served with ensalada and mexican rice.',46979,24475,'/images/menu','burrito_grande.jpeg',1),(72128,'FRAGOLA SALAD',13,'Fresh strawberries & candied pecans, mixed greens, crumbled goat cheese & cherry tomatoes, with creamy poppy seed dressing. Try it with seasoned grilled chicken $4.',56751,47387,'/images/menu','fragola_salad.jpeg',0),(79089,'Guadalajara',14,'2 enchiladas & 1 taco served with rice, frijoles & ensalada.',47455,39958,'/images/menu','guadlajara.jpeg',0),(79891,'Californian',15,'Sun-dried tomato pesto sauce, black olives, broccoli, Daiya mozzarella, baked & topped with fresh arugula, sliced tomato, avocado, red pepper,mushrooms.',51888,41096,'/images/menu','californian.jpeg',0),(90474,'Corona de Tofu',13,'Tossed salad with grilled, marinated tofu & celery seed vinaigrette in a crisp flour tortilla bowl.',16956,8082,'/images/menu','corona.jpeg',0);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurantcategories`
--

DROP TABLE IF EXISTS `restaurantcategories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restaurantcategories` (
  `RC_Id` int(11) NOT NULL,
  `RC_Name` varchar(45) NOT NULL,
  `RC_Description` longtext,
  PRIMARY KEY (`RC_Id`),
  UNIQUE KEY `RC_Id_UNIQUE` (`RC_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurantcategories`
--

LOCK TABLES `restaurantcategories` WRITE;
/*!40000 ALTER TABLE `restaurantcategories` DISABLE KEYS */;
INSERT INTO `restaurantcategories` VALUES (9242,'Fast Food','Fast food restaurants emphasize speed of service. Operations range from small-scale street vendors with food carts to multi-billion dollar corporations like McDonalds and Pizza Hut.'),(16598,'Family Style','Family style restaurants are a type of casual dining restaurants where food is often served on platters and the diners serve themselves.'),(69537,'Bakery','A bakery is an establishment that produces and sells flour-based food baked in an oven such as bread, cookies, cakes, pastries, and pies.[1] Some retail bakeries are also cafés, serving coffee and tea to customers who wish to consume the baked goods on the premises');
/*!40000 ALTER TABLE `restaurantcategories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurants`
--

DROP TABLE IF EXISTS `restaurants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restaurants` (
  `Res_Id` int(11) NOT NULL,
  `Res_Name` varchar(100) NOT NULL,
  `Res_Description` longtext,
  `LC_Id` int(11) NOT NULL,
  `RC_Id` int(11) NOT NULL,
  `MainImg_Path` varchar(200) DEFAULT NULL,
  `MainImg_Name` varchar(50) DEFAULT NULL,
  `Res_Manager_Id` varchar(45) DEFAULT NULL,
  `Location_Embed` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`Res_Id`),
  UNIQUE KEY `Res_Id_UNIQUE` (`Res_Id`),
  KEY `LocalCategory_idx` (`LC_Id`),
  KEY `ResCategory_idx` (`RC_Id`),
  KEY `Manager_idx` (`Res_Manager_Id`),
  CONSTRAINT `LocalCategory` FOREIGN KEY (`LC_Id`) REFERENCES `locationcategories` (`LC_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Manager` FOREIGN KEY (`Res_Manager_Id`) REFERENCES `users` (`User_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ResCategory` FOREIGN KEY (`RC_Id`) REFERENCES `restaurantcategories` (`RC_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurants`
--

LOCK TABLES `restaurants` WRITE;
/*!40000 ALTER TABLE `restaurants` DISABLE KEYS */;
INSERT INTO `restaurants` VALUES (8082,'SneakyDees Restaurant and Concert Venue','The infamous Sneaky-Dees concert venue is also well known for its Tex-Mex and pub-style favorites. The kitchen is open late with a reasonably priced menu and offers a festive atmosphere for all to sit and chat or dance the night away. The entire menu is peanut and tree nut-free, aside from the desserts, which are not made in their kitchen. There are many gluten-free options on the menu and they have a dedicated vegan fryer. All food is made to order and they are happy to make modifications to suit your dietary restrictions.',65162,9242,'/images','sneaky.jpg','Manager','<iframe src=\'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d11544.698198798727!2d-79.41823473022463!3d43.66533949999998!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x882b3493e5c2a6cb%3A0x9da808d57162072!2sLee&#39;s+Palace!5e0!3m2!1sen!2sca!4v1460345779580\' frameborder=\'0\' style=\'border:0\' allowfullscreen></iframe>'),(21927,'Pizzaiolo','This specialty pizza chain makes gluten-free pizza dough fresh daily, and has been called the Best Gluten-Free Pizza in Canada. They have a number of gluten-free toppings, and the option to use vegan, soy-free Daiya cheese so that every pizza they make maintains the mouthwatering flavour of traditional Italian pizza. All Pizzaiolo locations are 100 per cent nut free.',75794,69537,'/images','pizzaiolo.jpg','Manager','<iframe src=\'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d184618.3059603746!2d-79.5692430896163!3d43.69680998535692!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x89d4d29c6536eb0d%3A0xa52e792ea2d38d32!2sPizzaiolo!5e0!3m2!1sen!2sca!4v1460346352705\' frameborder=\'0\' style=\'border:0\' allowfullscreen></iframe>'),(24475,'Poutini’s House Of Poutine','Poutini’s House of Poutine is a popular place to grab a late night poutine in Queen West. Although it’s not a full-service restaurant, there are counters in the restaurant where you can enjoy your meal. The kitchen is free of peanuts and tree nuts. Their potatoes are hand cut, in-house that day and cooked in a dedicated fryer in vegetable oil. They have practices in place to reduce the risk of cross-contact for their vegan and gluten-free gravy and cheese. The vegan gravy is made in completely separate pots from the other gravies, and are washed and stored in separate areas. They also serve Daiya vegan, gluten-free cheese which is stored on a separate shelf away from any dairy. All dishes are made to order, and can make modifications to their dishes to accommodate food allergies and intolerances.',65162,69537,'/images','poutinis.jpg','Manager','<iframe src=\'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2887.228520726559!2d-79.4253527843059!3d43.643413661081084!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x882b350029b4b059%3A0x8d52ae0e8af2aaa8!2sPoutini%E2%80%99s+House+of+Poutine!5e0!3m2!1sen!2sca!4v1460345912080\' frameborder=\'0\' style=\'border:0\' allowfullscreen></iframe>'),(39958,'Almond Butterfly','Located in downtown Toronto’s vibrant Harbord Street village, just South of Bloor (two blocks west of Spadina), Almond Butterfly is a 100% gluten-free bake shop and espresso bar. You can find us at 100A Harbord Street. Click here for directions.HOMEMADE, FRESH BAKED GOODS & TREATS From fresh-baked muffins, biscuits, and bagels... to our mouth-watering cupcakes, brownies, & cookies- we’ve got you covered.Toasted breakfast egg sandwiches, bagels (we make the bagels fresh right here every morning), and grilled lunch sandwiches that will definitely hit the spot. In the Annex? Come by the shop to enjoy a scrumptious, grilled turkey & pesto sandwich... or perhaps a melt-in-your-mouth ham & cheddar melt, hot off the grill? All gluten-free, of course. :) DINE-IN, TAKEOUT, OR DELIVERY!',65162,9242,'/images','almond.jpg','Manager','<iframe src=\'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2886.2875407305887!2d-79.4056475843055!3d43.662989359815256!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4cc9175f71d85973%3A0x873731e3af7f7304!2sAlmond+Butterfly!5e0!3m2!1sen!2sca!4v1460344980868\' frameborder=\'0\' style=\'border:0\' allowfullscreen></iframe>'),(41096,'The Keg','The Keg’s juicy steaks and traditional Canadian cuisine are a great option for a fancy (but not too fancy) dinner out. They have a comprehensive allergy guide posted online and offer a wide variety of gluten-free menu options. All food is made to order, and the kitchen staff is more than willing to customize meals to suit food allergies and intolerances. There are many Keg locations with varying atmospheres across Toronto. The Keg Mansion on Jarvis Street is a prominent downtown heritage building and is a particularly interesting location to visit, especially if you enjoy ghost stories.',31616,16598,'/images','keg.jpg','Manager','<iframe src=\'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d23097.81525466065!2d-79.44067367234008!3d43.64344724176396!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x882b34de95cee365%3A0x90296b1e54202677!2sThe+Keg+Steakhouse+%2B+Bar+-+King+Street+West!5e0!3m2!1sen!2sca!4v1460346052767\' frameborder=\'0\' style=\'border:0\' allowfullscreen></iframe>'),(44338,'Loving Hut Toronto','The Loving Hut serves healthy, delicious foods with a variety of tastes, such as Vietnamese and Chinese dishes that are organic, vegan, non-GMO, peanut/nut free and contain no MSG. Their menu is also filled with many gluten-free options. Dishes are made to order and the staff is happy to make customizations to suit your tastes or dietary restrictions.',65162,69537,'/images','loving_hut.jpg','Manager','<iframe src=\'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2887.0208204832775!2d-79.3986662843058!3d43.64773516080168!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x882b34db9ea6a681%3A0x8fa8860eb85a1486!2sLoving+Hut!5e0!3m2!1sen!2sca!4v1460345615279\' frameborder=\'0\' style=\'border:0\' allowfullscreen></iframe>'),(47387,'Famoso Pizza','This fast-casual pizzeria serves authentic Neapolitan pizza in a warm and lively atmosphere. The Toronto Annex location came highly recommended by a family that lives with multiple food allergies which include soy, peanuts, tree nuts, eggs, seeds and most legumes. Restaurant staff is highly knowledgeable on practices that minimize cross-contact risks, and they are able to customize dishes to suit many dietary restrictions. Famoso has a comprehensive allergy menu posted online.',20182,9242,'/images','famoso.jpg','Manager','<iframe src=\'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d46154.99584610814!2d-79.46417936764425!3d43.69626516197885!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x882b34969919e3e9%3A0x1577b045db327f86!2sFamoso+Neapolitan+Pizzeria!5e0!3m2!1sen!2sca!4v1460346130258\' frameborder=\'0\' style=\'border:0\' allowfullscreen></iframe>'),(65405,'FEAST - Fabulous Eats for the Allergic & Sensitive Types','While FEAST is technically not a restaurant, this allergy-friendly fine food store has an in-house kitchen that serves hot pocket pies, mini vegan pizzas, salads, donuts and other sweet and savoury goodies for take-out. Every ingredient has been verified with the manufacturer to be free from gluten and all of the top eight allergens: wheat, nuts, peanuts, fish, shellfish, dairy, egg and soy. The kitchen is also free from mustard, sesame and sulphites. The take-out counter items are pre-prepared so customization is not possible, but full ingredient lists are posted so you know exactly what you will be consuming.',65162,16598,'/images','feast.jpg','Manager','<iframe src=\'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2887.1273944993204!2d-79.41363988450247!3d43.645517779121626!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x882b34e30853268b%3A0x2de25fc745c3f2cb!2s881+Queen+St+W%2C+Toronto%2C+ON+M6J+1G5!5e0!3m2!1sen!2sca!4v1460334138133\' frameborder=\'0\' style=\'border:0\' allowfullscreen></iframe>'),(75347,'Moxie’s Grill & Bar','Our restaurants and menus are inspired by the communities we are part of; from the team we hire to the food we make, it’s an expression of the neighbourhoods we inhabit across this country. From coast to coast we focus on quality food made with fresh ingredients served in a stylish, comfortable and casual environment -- whether you’re looking to dine out in Vancouver, around West Edmonton Mall, or Downtown Toronto.',88186,69537,'/images','moxie.jpg','Manager','<iframe src=\'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d184619.3078382181!2d-79.56924280367457!3d43.696484578448214!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x882b2d6212951701%3A0x11398d2c9de16b4a!2sMoxie&#39;s+Grill+%26+Bar!5e0!3m2!1sen!2sca!4v1460346274409\' frameborder=\'0\' style=\'border:0\' allowfullscreen></iframe>'),(78362,'Pizza Rustica','Pizza Rustica is a casual contemporary restaurant that serves gourmet pizza, pasta, paninis, salads and more. They’re more than willing to customize dishes to suit dietary restrictions, with many vegan and gluten-free main course and dessert options available, including gluten-free pizza crusts that don’t contain egg, and vegan Daiya cheese. Their basil pesto sauce is made in-house and does not contain any tree nuts. Peanuts are used as garnish on some salads, but they have practices in place to contain them and prevent cross-contact in the kitchen.',7427,69537,'/images','rustica.jpg','Manager','<iframe src=\'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2887.1533775734943!2d-79.39385928430589!3d43.644977160979955!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x882b34d0cce921c9%3A0x85d1aa963e1504ba!2sPizza+Rustica+Boutique!5e0!3m2!1sen!2sca!4v1460346467377\' frameborder=\'0\' style=\'border:0\' allowfullscreen></iframe>'),(90851,'Swiss Chalet','Most Canadians are very familiar with Swiss Chalet’s rotisserie chicken and comfort foods. They have an interactive allergy guide available online that can help people with allergies to the top 10 common food allergens make informed decisions quickly and easily. Full ingredient lists are not accessible online, but would be available in the restaurant.',56714,16598,'/images','swiss_chalet.jpg','Manager','<iframe src=\'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d184617.3040851438!2d-79.56924337555643!3d43.69713538948287!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x89d4d1a46b5d5011%3A0x2d85fa656c5c8450!2sSwiss+Chalet+Rotisserie+%26+Grill!5e0!3m2!1sen!2sca!4v1460346415625\' frameborder=\'0\' style=\'border:0\' allowfullscreen></iframe>');
/*!40000 ALTER TABLE `restaurants` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reviews`
--

DROP TABLE IF EXISTS `reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reviews` (
  `RV_Id` int(11) NOT NULL,
  `RV_Title` varchar(200) NOT NULL,
  `RV_Content` longtext NOT NULL,
  `User_Id` varchar(50) DEFAULT NULL,
  `Res_Id` int(11) DEFAULT NULL,
  `MainImg_Path` varchar(200) DEFAULT NULL,
  `MainImg_Name` varchar(50) DEFAULT NULL,
  `Rate` int(11) DEFAULT '0',
  PRIMARY KEY (`RV_Id`),
  UNIQUE KEY `RV_Id_UNIQUE` (`RV_Id`),
  KEY `UserId_idx` (`User_Id`),
  KEY `RestuarantsID_idx` (`Res_Id`),
  CONSTRAINT `RestuarantsID` FOREIGN KEY (`Res_Id`) REFERENCES `restaurants` (`Res_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `UserId` FOREIGN KEY (`User_Id`) REFERENCES `users` (`User_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reviews`
--

LOCK TABLES `reviews` WRITE;
/*!40000 ALTER TABLE `reviews` DISABLE KEYS */;
INSERT INTO `reviews` VALUES (23421,'so-so','their service was bad!!','zxcv',39958,'','',5),(234411,'so-so12345','their service was bad!!','zxcv',44338,'','',5),(369745,'so-so12345','their service was bad!!','zxcv',21927,'','',5),(12105578,'asdfsadfsaf','\nssadfsdfsdf','test',39958,'','',5),(14020438,'aa','aa','test',39958,'','',5),(14731601,'so-so12345','their service was bad!!','zxcv',39958,'','',5),(15895583,'dsafasdfdasf','dsafsadfsdaf\n\n\ndfadsfsdafsdf','zxcv',21927,'','',3),(16386674,'so-so12345','their service was bad!!','zxcv',39958,'','',5),(17896865,'so-so12345','their service was bad!!','zxcv',39958,'','',5),(20219259,'Great food','test','zxcv',24475,'','',4),(24409531,'best food!!!','test','roy',39958,'','',5),(24764755,'so-so12345','their service was bad!!','zxcv',39958,'','',5),(25343368,'test222','test222','roy',39958,'','',5),(28348176,'best food!!!','best restaurant ever!!','zxcv',24475,'','',5),(28369790,'so-so12345','their service was bad!!','zxcv',41096,'','',5),(30149806,'so-so12345','their service was bad!!','zxcv',21927,'','',5),(30228175,'modal test','tesafdsfs','zxcv',41096,'','',2),(31263371,'so-so12345','their service was bad!!','zxcv',39958,'','',5),(32417095,'test222','test222','roy',39958,'','',5),(33007194,'best food!!!','best','zxcv',24475,'','',5),(33789628,'so-so12345','their service was bad!!','zxcv',39958,'','',5),(34525690,'aa','aa','test',39958,'','',5),(35092111,'so-so12345','their service was bad!!','zxcv',39958,'','',5),(37441929,'test222','test222','roy',39958,'','',5),(38941533,'testtest','testtest','test',39958,'','',5),(41004068,'sadfdsf','sdfsdf','test',39958,'','',5),(45291956,'so-so12345','their service was bad!!','zxcv',39958,'','',5),(46766035,'so-so12345','their service was bad!!','zxcv',21927,'','',5),(47755374,'so-so12345','their service was bad!!','zxcv',39958,'','',5),(48281036,'insert with modal','sdafsfda\r\n\r\nsdfsdfsdf','zxcv',41096,'','',5),(51760982,'best food!!!','best restaurant ever!!','zxcv',39958,'','',5),(56786416,'Great restaurant','good','beymig12',39958,'','',5),(57723616,'so-so12345','their service was bad!!','zxcv',41096,'','',5),(58792552,'so-so12345','their service was bad!!','zxcv',41096,'','',5),(60211056,'drefr','edee','test',39958,'','',5),(67098447,'test222','test222','roy',39958,'','',5),(71354637,'Modal insert','essdf','test',44338,'','',5),(72640546,'best food!!!','test','roy',41096,'','',5),(73345136,'best restraunt','best service and best food!!','zxcv',39958,'','',5),(74313180,'testa','sfsdfsf','zxcv',21927,'','',5),(76381793,'so-so12345','their service was bad!!','zxcv',39958,'','',5),(78585471,'testtest','testtest','test',39958,'','',5),(82470745,'so-so12345','their service was bad!!','zxcv',39958,'','',5),(83545821,'test222','test222','roy',39958,'','',5),(86986107,'Insert test','asdfdsaf\n\nsdf\nsdafsdfdsf','test',39958,'','',5),(90487879,'so-so12345','their service was bad!!','zxcv',39958,'','',5),(91605732,'aaaaaaaa','aaaa','test',39958,'','',5),(96608443,'testtest','testtest','test',39958,'','',5),(96976893,'test222','test222','roy',39958,'','',5),(97890272,'awefawe','awegawegweg','zxcv',24475,'','',5);
/*!40000 ALTER TABLE `reviews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usercategories`
--

DROP TABLE IF EXISTS `usercategories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usercategories` (
  `UC_Id` int(11) NOT NULL,
  `UC_Name` varchar(50) NOT NULL,
  `UC_Description` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`UC_Id`),
  UNIQUE KEY `UC_Id_UNIQUE` (`UC_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usercategories`
--

LOCK TABLES `usercategories` WRITE;
/*!40000 ALTER TABLE `usercategories` DISABLE KEYS */;
INSERT INTO `usercategories` VALUES (1,'Restaurant Manager','The person who can manage the information for restaurant'),(2,'Personal User','Common user'),(3,'Black list','The person who is not allowed to access');
/*!40000 ALTER TABLE `usercategories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `User_Id` varchar(50) NOT NULL,
  `User_FirstName` varchar(50) NOT NULL,
  `User_LastName` varchar(50) NOT NULL,
  `User_Pwd` varchar(50) NOT NULL,
  `User_Email` varchar(50) DEFAULT NULL,
  `UC_Id` int(11) DEFAULT NULL,
  PRIMARY KEY (`User_Id`),
  UNIQUE KEY `User_Id_UNIQUE` (`User_Id`),
  KEY `UserCategory_idx` (`UC_Id`),
  CONSTRAINT `UserCategory` FOREIGN KEY (`UC_Id`) REFERENCES `usercategories` (`UC_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('asdf','Roy','Kim','1234','Roy@hotmail.com',2),('beymig','Beymig','Munoz','password','beymig@gmail.c0m',2),('beymig12','Beymig','Munoz','password','beymig@gmail.com',2),('Manager','John','Doe','1234','John@test.com',1),('qwer','Marry','Lu','1234','Marry@gamil.com',2),('roy','Roy','Kim','test','',2),('test','Jihee','Seo','1234','iloy1004ca@gmail.com',2),('test1','KwangSik(Roy)','Kim','test','roykim0311@gmail.com',2),('zxcv','Joanna','Seo','1234','Joanna@gmail.com',2);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'eoes'
--
/*!50003 DROP FUNCTION IF EXISTS `getAllergyMenu` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `getAllergyMenu`(rId INT, aId INT) RETURNS varchar(2000) CHARSET utf8
BEGIN
     
     
	DECLARE p_result    varchar(2000);

	SELECT GROUP_CONCAT(m.menu_name SEPARATOR ', ') into p_result
	FROM allergycategories a join menu m on a.ac_id = m.ac_id 
    WHERE m.res_id = rId and m.ac_id = aId
	GROUP BY ac_name;
    
    RETURN p_result;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `AllergyResList` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `AllergyResList`(
IN keyword varchar(200))
BEGIN

	Select ac_name, r.Res_Id, r.Res_Name, r.Res_Description, r.MainImg_Path, r.MainImg_Name, eoes.getAllergyMenu(r.Res_Id, a.ac_id), Count(rv.rv_id) as Total_review , Round(AVG(rv.Rate),1) as Rate
	From restaurants r join menu m on r.Res_id = m.Res_id
	left join allergycategories a on a.ac_id = m.ac_id
    left Join reviews rv On r.Res_Id = rv.Res_Id
    WHERE r.Res_Name like CONCAT('%', keyword ,'%') or a.AC_Name like CONCAT('%', keyword ,'%') or r.Res_Description like CONCAT('%', keyword ,'%')
	group by ac_name, r.Res_Id
	order by ac_name; 

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `DeleteReview` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `DeleteReview`(IN rvId int,
                                 IN userId varchar(50))
BEGIN
	DELETE FROM reviews
    WHERE RV_Id = rvId and User_Id = userId;
    
    select row_count();

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `DetailImages` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `DetailImages`(IN refer_Id int, IN cate_Id int)
BEGIN
	
    Select 0 into @x;
    
	Select I.Img_Path, I.Img_Name, (@x:=@x+1) as rowNo
	From images I
	Left Join imgbridge IB on I.Img_Id = IB.Img_Id
    Where IB.Category = cate_id and IB.Refer_Id = refer_Id;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `InsertReview` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertReview`(IN Res_Id int,
                                 IN rv_Id int,
                                 IN title varchar(200),
                                 IN content longtext,
                                 IN userId varchar(50),
                                 IN imgPath varchar(200),
                                 IN imgName varchar(50),
                                 IN rate int)
BEGIN

	insert into Reviews (RV_ID, RV_Title, RV_Content, User_Id, Res_Id, MainImg_Path, MainImg_Name, Rate)
				values (rv_Id, title, content, userId, Res_Id, imgPath, imgName, rate);

	select row_count();
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `LocationResList` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `LocationResList`(
IN keyword varchar(200))
BEGIN

	Select LC_Name, r.Res_Id, r.Res_Name, r.Res_Description, r.MainImg_Path, r.MainImg_Name, Count(rv.rv_id) as Total_review , Round(AVG(rv.Rate),1) as Rate
	From restaurants r Join locationcategories l on r.LC_Id = l.LC_Id	
    left Join reviews rv On r.Res_Id = rv.Res_Id
    WHERE r.Res_Name like CONCAT('%', keyword ,'%') or l.LC_Name like CONCAT('%', keyword ,'%') or r.Res_Description like CONCAT('%', keyword ,'%')
	group by LC_Name, r.Res_Id
	order by LC_Name desc, rate desc;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `LoginUser` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `LoginUser`(IN userId varchar(50),
							  IN pwd varchar(50))
BEGIN

	select User_FirstName, User_LastName, User_Email, UC_Id
	From users
    Where User_Id = userId and User_Pwd = pwd;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `menuList` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `menuList`(
IN resId INT, 
IN isSpecial BOOL)
BEGIN

	IF isSpecial THEN
		select m.Menu_Name, m.Menu_Price, m.Menu_Description, a.AC_Name, m.MainImg_Path, m.MainImg_Name 
		from menu m join allergycategories a on m.AC_Id = a.AC_Id
		where m.Res_Id = resId
        and m.Is_special = 1;
	ELSE
		select m.Menu_Name, m.Menu_Price, m.Menu_Description, a.AC_Name, m.MainImg_Path, m.MainImg_Name 
		from menu m join allergycategories a on m.AC_Id = a.AC_Id 
		where m.Res_Id = resId;        
    END IF;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `PopularResList` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `PopularResList`()
BEGIN
	select restaurants.Res_Id, restaurants.Res_Name, restaurants.Res_Description, restaurants.MainImg_Path, restaurants.MainImg_Name, Count(reviews.rv_id) as Total_review ,Round(AVG(reviews.Rate),1) as Rate
    From restaurants
    left Join reviews
    On restaurants.Res_Id = reviews.Res_Id
    GROUP BY restaurants.Res_Id
    Order By Rate DESC
    LIMIT 6;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ResDetails` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ResDetails`(IN Res_Id int)
BEGIN

    select Res.Res_Name, Res.Res_Description, LC.LC_Name as LocationName, RC.RC_Name as ResCategory, 
        (select LC_Name from locationcategories where LC_Depth = CONCAT_WS('',substring(LC.LC_Depth,1,1),'00')) as Province,
        Res.Res_Manager_Id as ManagerName, Res.Location_Embed
	From restaurants Res
    left Join locationcategories LC on Res.LC_Id = LC.LC_Id
    left Join restaurantcategories RC on Res.RC_Id = RC.RC_Id
    where Res.Res_Id = Res_Id;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ResList` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ResList`()
BEGIN
	select restaurants.Res_Id, restaurants.Res_Name, restaurants.Res_Description, restaurants.MainImg_Path, restaurants.MainImg_Name, Count(reviews.rv_id) as Total_review ,Round(AVG(reviews.Rate),1) as Rate
    From restaurants
    left Join reviews
    On restaurants.Res_Id = reviews.Res_Id
    GROUP BY restaurants.Res_Id
    Order By Rate DESC;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ReviewDetail` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ReviewDetail`(IN RV_Id int)
BEGIN

	SELECT RV_Id, RV_Title, RV_Content, User_Id, Res_Id, Rate
    FROM reviews
    WHERE RV_Id = RV_Id;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ReviewList` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ReviewList`(IN Res_Id int, IN isTop bool)
BEGIN

	if isTop Then
		select R.RV_Id, R.RV_Title, R.RV_Content, U.User_Id, CONCAT_WS(' ', U.User_FirstName, U.User_LastName) AS userFullName,
			R.MainImg_Path, R.MainImg_Name, R.Rate
		From reviews R
		Left Join users U on R.User_Id = U.User_Id
		Where R.Res_Id = Res_Id
		Order By R.Rate Desc
        limit 3;
	Else
		select R.RV_Id, R.RV_Title, R.RV_Content, U.User_Id, CONCAT_WS(' ', U.User_FirstName, U.User_LastName) AS userFullName,
			R.MainImg_Path, R.MainImg_Name, R.Rate
		From reviews R
		Left Join users U on R.User_Id = U.User_Id
		Where R.Res_Id = Res_Id
		Order By R.Rate Desc
        LIMIT 18446744073709551615 OFFSET 3;
    
    End iF;
	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `searchList` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `searchList`(
IN keyword varchar(200))
BEGIN

	select restaurants.Res_Id, restaurants.Res_Name, restaurants.Res_Description, restaurants.MainImg_Path, restaurants.MainImg_Name, Count(reviews.rv_id) as Total_review , Round(AVG(reviews.Rate),1) as Rate, locationcategories.LC_Name
    From restaurants
    Inner Join locationcategories on restaurants.LC_Id = locationcategories.LC_Id
    left Join reviews On restaurants.Res_Id = reviews.Res_Id
    WHERE restaurants.Res_Name like CONCAT('%', keyword ,'%') or locationcategories.LC_Name like CONCAT('%', keyword ,'%') or restaurants.Res_Description like CONCAT('%', keyword ,'%')
    GROUP BY restaurants.Res_Id
    Order By Rate DESC
    limit 6;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `SignupUser` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `SignupUser`(IN userId varchar(50),
								IN fName varchar(50),
                                IN lName varchar(50),
                                IN pwd varchar(50),
                                IN email varchar(50),
                                IN role int)
BEGIN

	insert into users (User_Id, User_FirstName, User_LastName, User_Pwd, User_Email, UC_Id)
				values(userId, fName, lName, pwd, email, role);

	select row_count();
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `SingupUser` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `SingupUser`(IN userId varchar(50),
								IN fName varchar(50),
                                IN lName varchar(50),
                                IN pwd varchar(50),
                                IN email varchar(50),
                                IN role int)
BEGIN

	insert into users (User_Id, User_FirstName, User_LastName, User_Pwd, User_Email, UC_Id)
				values(userId, fName, lName, pwd, email, role);

	select row_count();
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `UpdateReview` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `UpdateReview`(IN resId int,
                                 IN rvId int,
                                 IN title varchar(200),
                                 IN content longtext,
                                 IN userId varchar(50),
                                 IN imgPath varchar(200),
                                 IN imgName varchar(50),
                                 IN rate int)
BEGIN

	Update Reviews set RV_Title = title,
					   RV_Content = content,
                       MainImg_Path = imgPath,
                       MainImg_Name = imgName,
                       Rate = rate
					Where (RV_ID = rvId and Res_Id = resId and User_Id = userId);

	select row_count();

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `UserDetail` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `UserDetail`(IN userId varchar(50))
BEGIN

	select User_Id, User_Pwd, User_FirstName, User_LastName, User_Email, UC_Id
	From users
    Where User_Id = userId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-13 13:16:02
