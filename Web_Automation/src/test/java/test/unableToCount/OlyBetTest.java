package test.unableToCount;

import test.TestBase;
import org.testng.annotations.Test;
import webTDK.common.helpers.wait.WaitHelpers;

public class OlyBetTest extends TestBase {
    @Test(groups = {"automation", "job"})
    public void olyBetTest(){

        System.out.println("--------------- OlyBet ---------------");

        // OlyBet oldal megnyitása
        ui.olyBetLandingPage.openOlyBetLandingPage();
        WaitHelpers.delay(10);
        ui.olyBetLandingPage.clickToAcceptButton();
        WaitHelpers.delay(4);
        ui.olyBetLandingPage.clickToAllGamesButton();
        driver.navigate().refresh();
        WaitHelpers.delay(2);
        ui.olyBetLandingPage.clickToFilterButton();

        ui.olyBetLandingPage.clickAndCountSuppliers();
    }
}
