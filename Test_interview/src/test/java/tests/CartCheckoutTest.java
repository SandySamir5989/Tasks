package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import jxl.read.biff.BiffException;
import pages.CartCheckout;
import pages.LoginPage;
import utilities.ExcelReader;

public class CartCheckoutTest extends TestBase
{
	LoginPage LoginObject ;


	@DataProvider(name = "data")
	public Object[][] data() throws IOException, BiffException {
		Object[][] data = new Object[1][2];
		ExcelReader xl = new ExcelReader("Sheet1", "CartCheckoutTestTestCase");
		Object[][] data1 = xl.getTestdata();
		for (int i = 0; i < data1.length; i++) {
			for (int j = 0; j < data1[i].length; j++) {
				data[0][j] = data1[i][j];
			}
		}
		return data;
	}

	@Test(dataProvider = "data", priority = 1, alwaysRun = true)
	public void TestLogin(String userName,String loginPassword)
	{ 
		LoginObject= new LoginPage(driver) ;
		LoginObject.siginForFirstTime(userName,loginPassword);
	}


	LoginPage loginObject;
	CartCheckout CartCheckoutObject ; 

	//@Test(priority = 1 , alwaysRun = true)
	//public void loginforcheckout() {
	//	loginObject =new LoginPage(driver);
	//	loginObject.siginForFirstTime(email,password);
	//}

	@Test(priority = 2)
	public void searchBlouses() {
		CartCheckoutObject =new CartCheckout(driver);
		CartCheckoutObject.searchBlousesProduct();
	}

	@Test(dependsOnMethods = "searchBlouses")
	public void SelectResultedProduct() throws InterruptedException {
		CartCheckoutObject.openpagedetails();
	}

	@Test (dependsOnMethods = "SelectResultedProduct")
	public void checkProceedCheckOutsuccessfully() throws InterruptedException {
		CartCheckoutObject.proceedCheckout();
		Assert.assertTrue(CartCheckoutObject.orderconfirmtxt.getText().equals("Your order on My Store is complete."));
		Thread.sleep(3000);
	}

}