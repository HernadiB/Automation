package test.sweden_casino;

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
import test.TestBase;
import webTDK.common.ThreadLocalBaseFactory;

import java.util.List;

public class VeraJohnTest extends TestBase {
    @Test(groups = {"automation", "job"})
    public void veraJohnTest(){

        System.out.println("--------------- Vera&John ---------------");

        // Vera&John oldal megnyitása
        ui.veraJohnLandingPage.openVeraJohnLandingPage();

        ui.veraJohnLandingPage.clickToGameManufacturer();
    }
}
