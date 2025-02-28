package test.sweden_casino.with_vpn;

import automationBase.AutomationBase;
import automationBase.AutomationThreadLocalFactory;
import automationBase.AutomationUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.TestBase;
import webTDK.common.ThreadLocalBaseFactory;
import webTDK.common.helpers.wait.WaitHelpers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JallaTest extends TestBase {
    @Test(groups = {"automation", "job"})
    public void jallaTest(){

        System.out.println("--------------- Jalla! CASINO ---------------");

        ui.jallaLandingPage.openJallaCasinoPage();

        this.driver.navigate().to("https://www.jallacasino.se/casino/slots");



        System.out.println(ui.jallaLandingPage.countGameProviderElements());
    }
}
