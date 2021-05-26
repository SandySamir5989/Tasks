package pages;


import org.openqa.selenium.JavascriptExecutor;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PageBase;

public class CartCheckout extends PageBase{

	public CartCheckout(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor) driver;
		wait= new WebDriverWait(driver, 60);
	}
	
	@FindBy(linkText = "Women")
	WebElement WomenCategory;

	@FindBy(linkText = "Tops")
	WebElement top;

	@FindBy(linkText = "Blouses")
	public WebElement blouse;

	@FindBy(linkText = "Blouse")
	WebElement blousedetails;

	@FindBy(id="add_to_cart")
	WebElement addtocart;

	@FindBy(linkText ="Proceed to checkout")
	WebElement proceedtocheckout;

	@FindBy(id="cgv")
	WebElement agreeterm;

	@FindBy(xpath ="//button[@name='processAddress']")
	WebElement proceedcheckoutaddress;

	@FindBy(xpath ="//button[@name='processCarrier']")
	WebElement proceedcheckoutshipping;

	@FindBy(xpath ="//*[@class='bankwire']")
	WebElement bankwire;


	@FindBy(xpath ="//*[@class='button btn btn-default button-medium']")
	WebElement confirmmyorder;

	@FindBy(xpath ="//*[@class='cheque-indent']")
	public WebElement orderconfirmtxt;


	public void searchBlousesProduct () {
		clickButton(WomenCategory);
		clickButton(top);
		clickButton(blouse);
		scrolldown("scrollBy(0,800)");
	}

	public void openpagedetails() {

		clickButton(blousedetails);
	}

	public void proceedCheckout() {
		scrolldown("scrollBy(0,800)");
		waiting(addtocart);
		clickButton(addtocart);
		clickButton(proceedtocheckout);
		scrolldown("scrollBy(0,2000)");
		clickButton(proceedtocheckout);
		scrolldown("scrollBy(0,2000)");
		clickButton(proceedcheckoutaddress);
		scrolldown("scrollBy(0,1500)");
		clickButton(agreeterm);
		clickButton(proceedcheckoutshipping);
		scrolldown("scrollBy(0,800)");
		clickButton(bankwire);
		scrolldown("scrollBy(0,500)");
		clickButton(confirmmyorder);
		scrolldown("scrollBy(0,200)");
	}
	
	public void checkoutafterhistroyreorder() {
		scrolldown("scrollBy(0,2000)");
		clickButton(proceedtocheckout);
		scrolldown("scrollBy(0,2000)");
		clickButton(proceedcheckoutaddress);
		scrolldown("scrollBy(0,1500)");
		clickButton(agreeterm);
		clickButton(proceedcheckoutshipping);
		scrolldown("scrollBy(0,800)");
		clickButton(bankwire);
		scrolldown("scrollBy(0,500)");
		clickButton(confirmmyorder);
		scrolldown("scrollBy(0,200)");
	}
}