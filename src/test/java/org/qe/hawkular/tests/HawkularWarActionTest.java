package org.qe.hawkular.tests;

import org.openqa.selenium.WebDriver;
import org.qe.hawkular.driver.HawkularSeleniumLocalWebDriver;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.element.*;
import org.qe.hawkular.page.*;
import org.testng.annotations.Test;

public class HawkularWarActionTest extends HawkularSeleniumLocalWebDriver {

	public WebDriver hawkularLoginToDeployments() throws Exception {
		WebDriver driver = createLocalDriver();

		driver.get(HawkularSeleniumWebDriver.hawkularUrl);
		System.out.println(driver.getTitle());

		HawkularLoginPage loginPage = new HawkularLoginPage(driver);

		loginPage.verifyLoginTitle();

		loginPage = new HawkularLoginPage(driver);
		loginPage.loginAs(HawkularRegistrationPageConstants.username2,
				HawkularRegistrationPageConstants.password2);

		HawkularConsoleAddUrlPage clickAppServer = new HawkularConsoleAddUrlPage(
				driver);
		clickAppServer.navigateToAppServersMenu();

		HawkularAppServerPage selectAppServer = new HawkularAppServerPage(
				driver);

		selectAppServer.verifyLocalAppServerExists();
		selectAppServer.navigateToLocalAppServer();
		selectAppServer.navigateToDeploymentsTab();
		return driver;
	}

	public void verifyAndQuit(HawkularDepoymentActionPage test, WebDriver driver) {
		test.verfiySuccess();
		driver.quit();
	}

	@Test
	public void hawkularRedeployWarTest() throws Exception {
		WebDriver driver = hawkularLoginToDeployments();
		HawkularDepoymentActionPage testRedeploy = new HawkularDepoymentActionPage(
				driver);
		
		testRedeploy.clickWarAction();
		testRedeploy.clickToRedeployWar();
		
		verifyAndQuit(testRedeploy, driver);

	}

	@Test
	public void hawkularEnableWarTest() throws Exception {
		WebDriver driver = hawkularLoginToDeployments();
		HawkularDepoymentActionPage testEnableWar = new HawkularDepoymentActionPage(
				driver);
		
		testEnableWar.clickWarAction();
		testEnableWar.clickToEnableWar();
		
		verifyAndQuit(testEnableWar, driver);
	}

	@Test
	public void hawkularDisableWarTest() throws Exception {
		WebDriver driver = hawkularLoginToDeployments();
		HawkularDepoymentActionPage testDisableWar = new HawkularDepoymentActionPage(
				driver);
		
		testDisableWar.clickWarAction();
		testDisableWar.clickToDisableWar();
		
		verifyAndQuit(testDisableWar, driver);
	}

	@Test
	public void hawkularRemoveWarTest() throws Exception {
		WebDriver driver = hawkularLoginToDeployments();
		HawkularDepoymentActionPage testEnableWar = new HawkularDepoymentActionPage(
				driver);
		
		testEnableWar.clickWarAction();
		testEnableWar.clickToRemoveWar();
		
		verifyAndQuit(testEnableWar, driver);
	}

	@Test
	public void hawkularRemoveMultipleWars() throws Exception {
		WebDriver driver = hawkularLoginToDeployments();
		HawkularDepoymentActionPage testEnableWar = new HawkularDepoymentActionPage(
				driver);
		
		testEnableWar.clickAllWarsAction();
		testEnableWar.clickToRemoveWar();
		
		verifyAndQuit(testEnableWar, driver);
	}

	@Test
	public void hawkularEnableMultipleWarsTest() throws Exception {
		WebDriver driver = hawkularLoginToDeployments();
		HawkularDepoymentActionPage testEnableWar = new HawkularDepoymentActionPage(
				driver);
		
		testEnableWar.clickAllWarsAction();
		testEnableWar.clickToEnableWar();
		
		verifyAndQuit(testEnableWar, driver);
	}

	@Test
	public void hawkularDisableMultipleWarsTest() throws Exception {
		WebDriver driver = hawkularLoginToDeployments();
		HawkularDepoymentActionPage testDisableWar = new HawkularDepoymentActionPage(
				driver);

		testDisableWar.clickAllWarsAction();
		testDisableWar.clickToDisableWar();
		
		verifyAndQuit(testDisableWar, driver);
	}

	@Test
	public void hawkularRedeployMultipleWarsTest() throws Exception {
		WebDriver driver = hawkularLoginToDeployments();
		HawkularDepoymentActionPage testDisableWar = new HawkularDepoymentActionPage(
				driver);
		
		testDisableWar.clickAllWarsAction();
		testDisableWar.clickToRedeployWar();

		verifyAndQuit(testDisableWar, driver);
	}

}
