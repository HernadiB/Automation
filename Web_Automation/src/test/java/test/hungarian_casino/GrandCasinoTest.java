package test.hungarian_casino;

import automationBase.AutomationUI;
import automationBase.AutomationBase;
import automationBase.AutomationThreadLocalFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import webTDK.common.ThreadLocalBaseFactory;

public class GrandCasinoTest {
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

    @AfterMethod(alwaysRun = true)
    public void after(){
        driver.quit();
        ThreadLocalBaseFactory.removeThreadLocalVariables();
    }
}
