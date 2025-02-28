package test.unableToCount;

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

public class LyckostTest extends TestBase {
    @Test(groups = {"automation", "job"})
    public void lyckostTest(){

        System.out.println("--------------- Lyckost ---------------");

        ui.lyckostLandingPage.openLyckostLandingPage();
        ui.lyckostLandingPage.clickToAcceptButton();
        ui.lyckostLandingPage.clickToCasinoButton();

    }
}
