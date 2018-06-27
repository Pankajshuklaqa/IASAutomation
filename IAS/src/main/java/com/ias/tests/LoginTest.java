package com.ias.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.ias.pom.LoginPageFactory;
import com.ias.setup.Driver;
import com.ias.util.Prop;

public class LoginTest {

	@Test
	public static void testingLoginFunctionality() throws IOException {

		String browserType= Prop.getConfigValue("browser").toString();
		/*
		 * LoginPage login = new LoginPage(driver);
		 * login.enterUserName(Utility.fetchPropertyValue("username"));
		 * login.enterPassword(Utility.fetchPropertyValue("password"));
		 * login.clickSignIn();
		 */
		WebDriver driver=Driver.getDriver(browserType);
		driver.get(Prop.getTestData("applicationURL").toString());
		LoginPageFactory loginPage = new LoginPageFactory(driver);
	    loginPage.login(Prop.getTestData("username"),Prop.getTestData("password"));
				
		Assert.assertEquals(driver.getCurrentUrl(),Prop.getTestData("successfulSignIn"));
	}
}
