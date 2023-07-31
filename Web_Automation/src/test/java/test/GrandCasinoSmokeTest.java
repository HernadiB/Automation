package test;

import automationBase.automationUI;
import automationBase.automationBase;
import automationBase.automationThreadLocalFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import webTDK.common.ThreadLocalBaseFactory;
import webTDK.common.helpers.PresenceHelpers;
import webTDK.common.helpers.wait.WaitConditions;
import webTDK.common.helpers.wait.WaitHelpers;

public class GrandCasinoSmokeTest {
    private automationUI ui;
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod(alwaysRun = true)
    public void before(){
        automationBase.initProps();
        automationBase.setDriver();
        this.ui = automationThreadLocalFactory.getUi();
        this.driver = automationThreadLocalFactory.getConnectionInfo().getDriver();
        this.wait = automationThreadLocalFactory.getConnectionInfo().getWait();
    }

    @Test(groups = {"automation", "job"})
    public void loginTest(){
        // Grand Casino oldal megnyitása
        ui.grandCasinoLoginPage.openGrandCasinoLoginPage();

        // Cookie elfogadása
        ExpectedConditions.elementToBeClickable(ui.grandCasinoLoginPage.gamesNavItem);
        ui.grandCasinoLoginPage.clickToCookieAcceptButton();

        // Játékok menü megnyitása
        ui.grandCasinoLoginPage.clickToGamesNavItem();

        // Játékgyártó lenyíló lista kattintása
        ui.grandCasinoLoginPage.clickToGameManufacturerDropdown();

        // Amatic játékok
        ui.grandCasinoLoginPage.clickToAmaticManufacturer();
        ui.grandCasinoLoginPage.clickToAllGamesButton();

        ui.grandCasinoLoginPage.numberOfGames();
    }

    @AfterMethod(alwaysRun = true)
    public void after(){
        //driver.quit();
        ThreadLocalBaseFactory.removeThreadLocalVariables();
    }
}
