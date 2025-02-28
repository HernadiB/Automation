package test.slovak_casino;

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

public class NikeTest extends TestBase {
    @Test(groups = {"automation", "job"})
    public void nikeTest(){

        System.out.println("--------------- Niké ---------------");

        ui.nikeLandingPage.openNikeLandingPage();

        ui.nikeLandingPage.clickToAcceptCookieButton();

        ui.nikeLandingPage.getGamesPerProvider();
    }
}
