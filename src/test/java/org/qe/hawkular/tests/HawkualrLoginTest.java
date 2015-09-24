package org.qe.hawkular.tests;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.qe.hawkular.driver.HawkularSeleniumLocalWebDriver;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.element.HawkularLoginPageConstants;
import org.qe.hawkular.element.HawkularManagementConsolePageConstants;
import org.qe.hawkular.element.HawkularRegistrationPageConstants;
import org.qe.hawkular.page.HawkularLoginPage;
import org.qe.hawkular.page.HawkularRegistrationPage;
import org.qe.hawkular.util.HawkularDataProvider;
import org.qe.hawkular.util.HawkularUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.saucelabs.testng.SauceOnDemandTestListener;

public class HawkualrLoginTest extends HawkularSeleniumLocalWebDriver {

	@BeforeSuite
	public void prepareUser() throws MalformedURLException {
		WebDriver driver = createLocalDriver();
		HawkularRegistrationPage registration = new HawkularRegistrationPage(
				driver);
		driver.get(HawkularSeleniumWebDriver.hawkularUrl);
		System.out.println(driver.getTitle());
		registration.registerUserIfDoesNotExist(HawkularRegistrationPageConstants.username, HawkularRegistrationPageConstants.password, HawkularRegistrationPageConstants.confirmPassword, HawkularRegistrationPageConstants.firstName, HawkularRegistrationPageConstants.lastName, HawkularRegistrationPageConstants.email);

	}

	@Test
	public void hawkularLoginTest()
			throws Exception {
		WebDriver driver = createLocalDriver();

		driver.get(HawkularSeleniumWebDriver.hawkularUrl);
		System.out.println(driver.getTitle());

		HawkularLoginPage loginPage = new HawkularLoginPage(driver);

		loginPage.verifyLoginTitle();

		loginPage = new HawkularLoginPage(driver);
		loginPage.loginAs(HawkularRegistrationPageConstants.username,
				HawkularRegistrationPageConstants.password);

		driver.findElement(HawkularManagementConsolePageConstants.consoleImageAltLocator);
		loginPage.logout();
		driver.quit();
	}

	@Test
	public void hawkularLoginEmptyFieldsTest()
			throws Exception {
		WebDriver driver = createLocalDriver();

		driver.get(HawkularSeleniumWebDriver.hawkularUrl);
		System.out.println(driver.getTitle());

		HawkularLoginPage loginPage = new HawkularLoginPage(driver);

		loginPage.verifyLoginTitle();

		loginPage = new HawkularLoginPage(driver);
		loginPage.loginAs("",
				"");

		loginPage.verifyInvalidUsernameOrPassword();
		driver.quit();
	}

	@Test
	public void hawkularLoginInvalidPasswordTest()
			throws Exception {
		WebDriver driver = createLocalDriver();

		driver.get(HawkularSeleniumWebDriver.hawkularUrl);
		System.out.println(driver.getTitle());

		HawkularLoginPage loginPage = new HawkularLoginPage(driver);

		loginPage.verifyLoginTitle();

		loginPage = new HawkularLoginPage(driver);
		loginPage.loginAs(HawkularRegistrationPageConstants.username,
				HawkularRegistrationPageConstants.wrongPassword);

		loginPage.verifyInvalidUsernameOrPassword();
		driver.quit();
	}

	@Test
	public void hawkularLogoutTest()
			throws Exception {
		WebDriver driver = createLocalDriver();

		driver.get(HawkularSeleniumWebDriver.hawkularUrl);
		System.out.println(driver.getTitle());

		HawkularLoginPage loginPage = new HawkularLoginPage(driver);

		loginPage.verifyLoginTitle();

		loginPage.loginAs(HawkularRegistrationPageConstants.username,
				HawkularRegistrationPageConstants.password);
		loginPage.logout();
		driver.quit();
	}

}
