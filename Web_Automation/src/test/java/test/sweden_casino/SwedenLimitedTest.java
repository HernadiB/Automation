package test.sweden_casino;

import automationBase.AutomationBase;
import automationBase.AutomationThreadLocalFactory;
import automationBase.AutomationUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import webTDK.common.ThreadLocalBaseFactory;

public class SwedenLimitedTest {
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
    public void pafTest(){

        System.out.println("--------------- 888 Sweden Limited Casino ---------------");

        // Paf oldal megnyitása
        ui.swedenLimitedLandingPage.openSwedenLimitedLandingPage();

        driver.get("https://www.888casino.se/spelautomater/");

        ui.swedenLimitedLandingPage.clickToFilterButton();

        ui.swedenLimitedLandingPage.clickToGameManufacturerFilterButton();

        ui.swedenLimitedLandingPage.printManufacturerNamesAndGameNumbers();

    }

    @AfterMethod(alwaysRun = true)
    public void after(){
        driver.quit();
        ThreadLocalBaseFactory.removeThreadLocalVariables();
    }
}
