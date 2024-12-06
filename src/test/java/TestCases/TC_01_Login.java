package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import PageObject.LoginPage;
import Utilities.GenerateRandomString;
import Utilities.ReadXML;

public class TC_01_Login extends TestBase{

	public GenerateRandomString randomString = new GenerateRandomString();
	ReadXML obj1 = new ReadXML();
	
	@Test(priority = 0)
	public void login_test() throws InterruptedException
	{

		String RandomName = randomString.random_string();
		
		LoginPage obj = new LoginPage(driver);
		Thread.sleep(2000);
		obj.enter_username(RandomName);	
		Thread.sleep(2000);
		obj.enter_password(RandomName);
		Thread.sleep(2000);
		obj.click_login();
		Thread.sleep(2000);
		String InvalidText = obj.invalid_txt();
		Assert.assertEquals(InvalidText, "Invalid credentials", " Text is Not Matched ");
	}
	
	@Test(priority = 1)
	public void wrongCreds() throws IOException, InterruptedException
	{
		Thread.sleep(2000);
	
		LoginPage obj = new LoginPage(driver);
		obj.enter_username(obj1.read_excel_data("Creds", 1, 0));
		Thread.sleep(2000);
		obj.enter_password(obj1.read_excel_data("Creds", 1, 1));
		Thread.sleep(2000);
		obj.click_login();
		Thread.sleep(2000);
		String InvalidText = obj.invalid_txt();
		Assert.assertEquals(InvalidText, "Invalid credentials", " Text is Not Matched ");
	}
	
	@Test(priority = 2)
	public void correctCreds() throws IOException, InterruptedException
	{
		Thread.sleep(2000);
		LoginPage obj = new LoginPage(driver);
		obj.enter_username(obj1.read_excel_data("Creds", 2, 0));
		Thread.sleep(2000);
		obj.enter_password(obj1.read_excel_data("Creds", 2, 1));
		Thread.sleep(2000);
		obj.click_login();
		Thread.sleep(2000);
		String DashboardTxt = obj.dashboard_txt();
		Assert.assertEquals(DashboardTxt, "Dashboard", " Text is Not Matched ");
	}
	
	
}
