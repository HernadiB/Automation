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

public class TipSportTest extends TestBase {
    @Test(groups = {"automation", "job"})
    public void tipSportTest(){

        System.out.println("--------------- Tipsport ---------------");

        ui.tipSportLandingPage.openTipSportLandingPage();

        ui.tipSportLandingPage.clickToGameManufacturer();

        //ui.nikeLandingPage.getGamesPerProvider();
    }
}
