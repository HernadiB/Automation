package test.hungarian_casino;

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
import webTDK.common.ThreadLocalBaseFactory;
import webTDK.common.helpers.wait.WaitHelpers;

import java.util.List;

public class VegasCasinoVipTest {
    private AutomationUI ui;
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void before() {
        AutomationBase.initProps();
        AutomationBase.setDriver();
        this.ui = AutomationThreadLocalFactory.getUi();
        this.driver = AutomationThreadLocalFactory.getConnectionInfo().getDriver();
    }

    @Test(groups = {"automation", "job"})
    public void vegasCasinoVipTest() {

        System.out.println("--------------- Vegas Casino VIP ---------------");

        ui.vegasCasinoVipLandingPage.openVegasCasinoVipPage();
        ui.vegasCasinoVipLandingPage.clickToAcceptCookieButton();
        ui.vegasCasinoVipLandingPage.clickToShowGamesButton();

        WebElement providerFilterButton = driver.findElement(By.xpath("//button[contains(@class, \"game-provider-filter-button\")]"));
        providerFilterButton.click();
        List<WebElement> providers = driver.findElements(By.cssSelector(".game-provider-filter-popper .field-checkbox"));

        for (WebElement provider : providers) {
            WebElement checkbox = provider.findElement(By.cssSelector("input[type='checkbox']"));
            checkbox.click();
            WaitHelpers.delay(5);
            List<WebElement> games = driver.findElements(By.cssSelector(".game-thumbnail"));
            System.out.println(provider.getText() + ": " + games.size());
            checkbox.click();
        }
    }

    @AfterMethod(alwaysRun = true)
    public void after(){
        driver.quit();
        ThreadLocalBaseFactory.removeThreadLocalVariables();
    }
}
