package test.sweden_casino;

import automationBase.AutomationBase;
import automationBase.AutomationThreadLocalFactory;
import automationBase.AutomationUI;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import webTDK.common.ThreadLocalBaseFactory;
import webTDK.common.helpers.wait.WaitConditions;
import webTDK.common.helpers.wait.WaitHelpers;

import java.util.ArrayList;
import java.util.List;

public class PafTest {
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
    public void pafTest(){

        System.out.println("--------------- Paf ---------------");

        // Paf oldal megnyitása
        ui.pafLandingPage.openPafLandingPage();

        ui.pafLandingPage.clickToAcceptCookieButton();
        ui.pafLandingPage.clickToCasinoSlotsButton();
        ui.pafLandingPage.clickToAllSlotsButton();

        ui.pafLandingPage.clickToGameManufacturerDropdown();

        List<String> suppliers = new ArrayList<>();

        // Save the suppliers into a list
        for (WebElement supplierElement : ui.pafLandingPage.gameManufacturerDropdownListElements) {
            suppliers.add(supplierElement.getText());
        }

        // Iterate through the list of suppliers
        for (String supplier : suppliers) {
            // Find and click on each supplier
            WebElement supplierLink = driver.findElement(By.linkText(supplier));
            supplierLink.click();

            // Wait for the page to refresh
            WaitHelpers.delay(1); // Use a better wait strategy in a real scenario

            // Get the list of game providers and number of games per provider
            List<WebElement> gameProviderElements = driver.findElements(By.cssSelector("a.css-1j2idm3.e1081hx62"));
            List<String> gameProviders = new ArrayList<>();

            for (WebElement gameProviderElement : gameProviderElements) {
                gameProviders.add(gameProviderElement.getText());
            }

            // Output the game providers and number of games
            System.out.println("Supplier: " + supplier);
            System.out.println("Number of Games: " + gameProviders.size());
            //System.out.println("Games: " + gameProviders);
        }
    }

    @AfterMethod(alwaysRun = true)
    public void after(){
        //driver.quit();
        ThreadLocalBaseFactory.removeThreadLocalVariables();
    }
}
