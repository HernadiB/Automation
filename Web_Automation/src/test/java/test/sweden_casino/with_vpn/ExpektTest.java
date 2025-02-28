package test.sweden_casino.with_vpn;

import automationBase.AutomationBase;
import automationBase.AutomationThreadLocalFactory;
import automationBase.AutomationUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.TestBase;
import webTDK.common.ThreadLocalBaseFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpektTest extends TestBase {

    @Test(groups = {"automation", "job"})
    public void expektTest(){

        System.out.println("--------------- Expekt ---------------");

        ui.expektLandingPage.openExpektCasinoPage();
        ui.expektLandingPage.clickToAcceptCookieButton();
        ui.expektLandingPage.clickToCasinoButton();
        ui.expektLandingPage.clickToSlotsFilterButton();
        ui.expektLandingPage.printGamesPerProdiver();

    }
}
