package test.sweden_casino.with_vpn;

import automationBase.AutomationBase;
import automationBase.AutomationThreadLocalFactory;
import automationBase.AutomationUI;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import webTDK.common.ThreadLocalBaseFactory;
import webTDK.common.helpers.PresenceHelpers;
import webTDK.common.helpers.wait.WaitConditions;
import webTDK.common.helpers.wait.WaitHelpers;
import webTDK.constants.Timeouts;
import webTDK.pagefactory.PageBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HajperTest {
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
    public void hajperTest(){

        System.out.println("--------------- Hajper ---------------");

        ui.hajperLandingPage.openHajperCasinoPage();
        ui.hajperLandingPage.clickToAcceptCookieButton();

        this.driver.navigate().to("https://www.hajper.com/sv/casino/all-games");

        Map<String, String> gameInfoMap = new HashMap<>();

        // Locate all game cards
        List<WebElement> gameCards = driver.findElements(By.cssSelector("div[data-at='game-card']"));

        for (WebElement gameCard : gameCards) {
            // Click the SVG to open game details
            WebElement infoButton = gameCard.findElement(By.cssSelector("button.info-button__InfoButtonContainer-sc-ubfp7e-0"));
            WaitHelpers.delay(1);
            infoButton.click();

            // Extract game provider and game number
            String gameProvider = driver.findElement(By.cssSelector("p[data-at='game-info-provider-name'] a")).getText();
            String gameNumber = gameCard.getAttribute("data-gamecode");

            // Save the extracted information in the map
            gameInfoMap.put(gameProvider, gameNumber);

            // Close the game details overlay
            WebElement closeButton = driver.findElement(By.cssSelector("button[data-at='game-support-close-button']"));
            closeButton.click();
        }

        // Print the collected game information
        for (Map.Entry<String, String> entry : gameInfoMap.entrySet()) {
            System.out.println("Provider: " + entry.getKey() + ", Game Number: " + entry.getValue());
        }
    }

    @AfterMethod(alwaysRun = true)
    public void after(){
        //driver.quit();
        ThreadLocalBaseFactory.removeThreadLocalVariables();
    }
}
