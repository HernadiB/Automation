package test.unableToCount;

import org.testng.annotations.Test;
import test.TestBase;

public class BetfairTest extends TestBase {
    @Test(groups = {"automation", "job"})
    public void betfairTest(){

        System.out.println("--------------- Betfair ---------------");

        ui.betfairLandingPage.openBetfairLandingPage();
        ui.betfairLandingPage.clickToCasinoButton();
    }
}
