package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import objectRepo.AddNewCategoryPage;
import objectRepo.AddNewCoursePage;
import objectRepo.AddNewUserPage;
import objectRepo.CategoryPage;
import objectRepo.CourseListPage;
import objectRepo.HomePage;
import objectRepo.LoginPage;
import objectRepo.UserPage;

public class BaseClass {
	
	//@BeforeSuite
		//@BeforeTest
		
		protected PropertiesUtility property;
		protected ExcelUtility excel;
		protected JavaUtility jutil;
		protected WebDriverUtility web;
		protected WebDriver driver;
		
		public static WebDriver sdriver;
		public static JavaUtility sjutil;
		
		protected LoginPage login;
		protected HomePage home;
		protected UserPage users;
		protected CourseListPage course;
		protected CategoryPage category;
		protected AddNewUserPage addUser;
		protected AddNewCoursePage addCourse;
		protected AddNewCategoryPage addCategory;
		
		
		@BeforeClass
		public void classConfig() {
			property = new PropertiesUtility();
			excel = new ExcelUtility();
			jutil = new JavaUtility();
			web = new WebDriverUtility();
			
			
			property.propertiesIntit(IConstantPath.PROPERTIES_PATH);
			driver = web.launchAndMaximizeBrowser(property.readFromProperties("browser"));
			web.waitTillElementFound((Long.parseLong(property.readFromProperties("timeouts"))));
			
			sdriver = driver;
			sjutil = jutil;
			
		}
		@BeforeMethod
		public void methodConfig() {
			login = new LoginPage(driver);
			home = new HomePage(driver);
			users = new UserPage(driver);
			course = new CourseListPage(driver);
			category = new CategoryPage(driver);
			addUser = new AddNewUserPage(driver);
			addCategory = new AddNewCategoryPage(driver);
			addCourse = new AddNewCoursePage(driver);
			
			excel.excelIntit(IConstantPath.EXCEL_PATH);
			web.navigateToApp(property.readFromProperties("url"));
			Assert.assertEquals(login.getPageHeader(), "Login");
			
			login.loginToApp(property.readFromProperties("username"), property.readFromProperties("password"));
			
			Assert.assertEquals(home.getPageHeader(), "Home");
		}
		
	

}