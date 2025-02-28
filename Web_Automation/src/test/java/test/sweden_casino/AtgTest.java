package test.sweden_casino;

import automationBase.AutomationBase;
import automationBase.AutomationThreadLocalFactory;
import automationBase.AutomationUI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.TestBase;
import webTDK.common.ThreadLocalBaseFactory;

import java.util.ArrayList;
import java.util.List;

public class AtgTest extends TestBase {
    @Test(groups = {"automation", "job"})
    public void atgTest(){

        System.out.println("--------------- AB Trav and Galopp ---------------");

        // Paf oldal megnyitása
        ui.atgLandingPage.openAtgCasinoPage();

        driver.get("https://www.atg.se/casino/spelautomater");

        ui.atgLandingPage.clickToAcceptAllCookiesButton();

        ui.atgLandingPage.printManufacturerNamesAndGameNumbers();
    }
}
