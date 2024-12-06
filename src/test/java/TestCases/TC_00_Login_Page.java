package TestCases;

import org.testng.annotations.Test;
import org.testng.Assert;

import PageObject.LoginPage;

public class TC_00_Login_Page extends TestBase {

	@Test (priority = 0)
	public void loginPageValidation()
	{
		
		
		LoginPage obj = new LoginPage(driver);
		String Logintxt = obj.txt_validation();
		Assert.assertEquals(Logintxt, "Login", " Text is not Matached ");
	}
	
}
