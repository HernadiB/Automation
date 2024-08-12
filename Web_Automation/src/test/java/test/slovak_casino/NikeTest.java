package test.slovak_casino;

import automationBase.AutomationBase;
import automationBase.AutomationThreadLocalFactory;
import automationBase.AutomationUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import webTDK.common.ThreadLocalBaseFactory;

public class NikeTest {
    private AutomationUI ui;
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod(alwaysRun = true)
    public void before(){
        AutomationBase.initProps();
        AutomationBase.setDriver();
        this.ui = AutomationThreadLocalFactory.getUi();
        this.driver = AutomationThreadLocalFactory.getConnectionInfo().getDriver();
    }

    @Test(groups = {"automation", "job"})
    public void nikeTest(){

        System.out.println("--------------- Niké ---------------");

        ui.nikeLandingPage.openNikeLandingPage();

        ui.nikeLandingPage.clickToAcceptCookieButton();

        ui.nikeLandingPage.getGamesPerProvider();
    }

    @AfterMethod(alwaysRun = true)
    public void after(){
        //driver.quit();
        ThreadLocalBaseFactory.removeThreadLocalVariables();
    }
}
