package base;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

	protected WebDriver driver; 
    public static  JavascriptExecutor js;
    public static WebDriverWait wait ;
    		
	public PageBase (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public static void clickButton(WebElement button) {
		System.out.println("Clicked on Button [" + button.getText() + "] Successfully");
		button.click();
	}
	
	
	public static void setElementText (WebElement settxtElement , String txt) {
		System.out.println("Type ["+ txt +"] Successfully");
		settxtElement.clear();
		settxtElement.sendKeys(txt);
	}
	
	public static void scrolldown(String distance) {
		js.executeScript(distance);
		
	}
	public static void waiting(WebElement button) {
		wait.until(ExpectedConditions.elementToBeClickable(button));
	}
	

}