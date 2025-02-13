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
import webTDK.common.ThreadLocalBaseFactory;

import java.util.ArrayList;
import java.util.List;

public class AtgTest {
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

        System.out.println("--------------- AB Trav and Galopp ---------------");

        // Paf oldal megnyitása
        ui.atgLandingPage.openAtgCasinoPage();

        driver.get("https://www.atg.se/casino/spelautomater");

        ui.atgLandingPage.clickToAcceptAllCookiesButton();

        ui.atgLandingPage.printManufacturerNamesAndGameNumbers();
    }

    @AfterMethod(alwaysRun = true)
    public void after(){
        driver.quit();
        ThreadLocalBaseFactory.removeThreadLocalVariables();
    }
}
