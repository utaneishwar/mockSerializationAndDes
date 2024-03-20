package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ScenarioOutlineCredentialPage 
{
	WebDriver driver;

	private @FindBy(xpath = "(//*[@name='email'])[1]")
	WebElement username;

	private @FindBy(xpath = "//*[@name='password']")
	WebElement password;
	private @FindBy(xpath = "//*[text()='Login']")
	WebElement loginbutton;

	private @FindBy(xpath = "//*[@class='fa fa-lock']")
	WebElement logoutbutton;
//
//	public ScenarioOutlineCredentialPage (WebDriver driver)
//	{
//		this.driver =driver;
//		PageFactory.initElements(driver, this);
//	}
	
	
	public ScenarioOutlineCredentialPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	public void username(String user)
	{
		username.click();
		username.sendKeys(user);
	}
	public void password(String pass)
	{
		password.click();
		password.sendKeys(pass);
	}
	public void login()
	{
		loginbutton.click();

	}

	public WebElement logout()
	{
		return logoutbutton;
	}
	public void checkout()
	{
		logoutbutton.click();     
	}
}
