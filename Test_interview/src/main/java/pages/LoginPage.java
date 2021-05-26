package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "passwd")
	WebElement password;

	@FindBy(linkText  = "Sign in")
	WebElement signin;

	@FindBy(id = "SubmitLogin")
	WebElement signinbutton;

	public void siginForFirstTime(String emails, String passwd) {
		clickButton(signin);

		setElementText(email, emails);
		setElementText(password, passwd);
		clickButton(signinbutton);

	}

	public void userLogin(String emails, String passwd) {

		setElementText(email, emails);
		setElementText(password, passwd);
		clickButton(signinbutton);

	}

	public void loginClick() {
		
	}

}