package test.hungarian_casino;

import automationBase.AutomationBase;
import automationBase.AutomationThreadLocalFactory;
import automationBase.AutomationUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.TestBase;
import webTDK.common.ThreadLocalBaseFactory;
import webTDK.common.helpers.wait.WaitHelpers;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VegasCasinoTest extends TestBase {
    @Test(groups = {"automation", "job"})
    public void vegasCasinoTest(){

        System.out.println("--------------- Vegas Casino ---------------");

        ui.vegasCasinoPage.openVegasCasinoPage();
        ui.vegasCasinoPage.clickToAcceptCookieButton();
        ui.vegasCasinoPage.navigateToProviders();
        ui.vegasCasinoPage.getGameProviderAndNumber();
    }
}
