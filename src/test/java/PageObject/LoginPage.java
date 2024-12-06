package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends PageObjectBase {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "username")
	WebElement userName;

	@FindBy(name = "password")
	WebElement Password;

	@FindBy(xpath = "//*[@type=\"submit\"]")
	WebElement loginbtn;

	@FindBy(xpath = "//*[text()=\"Login\"]")
	WebElement txt;
	
	@FindBy(xpath="//*[text()=\"Invalid credentials\"]")
	WebElement Invalidtxt;
	
	@FindBy(xpath="//h6[text()='Dashboard']")
	WebElement dashboardtxt;
	

	public String txt_validation() {
		try {
			String loginTxt = txt.getText();
			return loginTxt;
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	

	public void enter_username(String uname) {
		userName.sendKeys(uname);
	}

	public void enter_password(String pwd) {
		Password.sendKeys(pwd);
	}

	public void click_login() {
		loginbtn.click();
	}
	
	public String invalid_txt() {
		try {
			String loginTxt = Invalidtxt.getText();
			return loginTxt;
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String dashboard_txt() {
		try {
			String DashText = dashboardtxt.getText();
			return DashText;
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	


}
