package test.sweden_casino;

import automationBase.AutomationBase;
import automationBase.AutomationThreadLocalFactory;
import automationBase.AutomationUI;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.openqa.selenium.*;
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

        // Use JavascriptExecutor to scroll to the dropdown element
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].scrollIntoView(true);", ui.pafLandingPage.gameManufacturerDropdown);

        // Click the dropdown to reveal the options
        //ui.pafLandingPage.clickToGameManufacturerDropdown();

        // Get all the options dynamically from the dropdown
        List<WebElement> dropdownOptions = driver.findElements(By.xpath(".//ul[@class = \"css-1tfqmwd e18v8o6f0\"]/li"));

        for (WebElement dr : dropdownOptions) {
            System.out.println(dr.getText());
        }

        // Loop through each dropdown option
        for (int i = 0; i < dropdownOptions.size(); i++) {
            // Reload the options dynamically after every page reload
            WebElement dropdown = driver.findElement(By.xpath("//button[contains(text(), \"Supplier\")]"));
            dropdown.click();
            dropdownOptions = driver.findElements(By.xpath(".//ul[@class = \"css-1tfqmwd e18v8o6f0\"]/li"));

            // Scroll to the option before clicking
            //js.executeScript("arguments[0].scrollIntoView(true);", dropdownOptions.get(i));

            // Click the dropdown option
            dropdownOptions.get(i).click();

            List<WebElement> figures = driver.findElements(By.xpath(".//figure"));
            System.out.println("Number of <figure> elements after clicking option " + (i + 1) + ": " + figures.size());
        }
    }

    @AfterMethod(alwaysRun = true)
    public void after(){
        //driver.quit();
        ThreadLocalBaseFactory.removeThreadLocalVariables();
    }
}
