package test.sweden_casino;

import automationBase.AutomationBase;
import automationBase.AutomationThreadLocalFactory;
import automationBase.AutomationUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.TestBase;
import webTDK.common.ThreadLocalBaseFactory;

public class SwedenLimitedTest extends TestBase {
    @Test(groups = {"automation", "job"})
    public void swedenLimitedTest(){

        System.out.println("--------------- 888 Sweden Limited Casino ---------------");

        // Paf oldal megnyitása
        ui.swedenLimitedLandingPage.openSwedenLimitedLandingPage();

        driver.get("https://www.888casino.se/spelautomater/");

        ui.swedenLimitedLandingPage.clickToFilterButton();

        ui.swedenLimitedLandingPage.clickToGameManufacturerFilterButton();

        ui.swedenLimitedLandingPage.printManufacturerNamesAndGameNumbers();

    }
}
