package test.hungarian_casino;

import automationBase.AutomationUI;
import automationBase.AutomationBase;
import automationBase.AutomationThreadLocalFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.TestBase;
import webTDK.common.ThreadLocalBaseFactory;

public class GrandCasinoTest extends TestBase {

    @Test(groups = {"automation", "job"})
    public void grandCasinoTest(){

        System.out.println("--------------- Grand Casino ---------------");

        // Grand Casino oldal megnyitása
        ui.grandCasinoLandingPage.openGrandCasinoLandingPage();

        // Cookie elfogadása
        ui.grandCasinoLandingPage.clickToCookieAcceptButton();

        // Játékok menü megnyitása
        ui.grandCasinoLandingPage.clickToGamesNavItem();

        // Játékgyártó statisztika
        ui.grandCasinoLandingPage.clickToGameManufacturer();
    }
}
