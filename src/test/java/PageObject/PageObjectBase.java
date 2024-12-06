package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjectBase {

	public WebDriver driver;

	public PageObjectBase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
