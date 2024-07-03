package test;

import automationBase.AutomationBase;
import automationBase.AutomationThreadLocalFactory;
import automationBase.AutomationUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import webTDK.common.ThreadLocalBaseFactory;

import java.util.List;

public class VeraJohnTest {
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
    public void veraJohnTest(){

        System.out.println("--------------- Vera&John ---------------");

        // Vera&John oldal megnyitása
        ui.veraJohnLandingPage.openVeraJohnLandingPage();

        ui.veraJohnLandingPage.clickToGameManufacturer();
    }

    @AfterMethod(alwaysRun = true)
    public void after(){
        driver.quit();
        ThreadLocalBaseFactory.removeThreadLocalVariables();
    }
}
