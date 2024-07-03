package test.sweden_casino;

import automationBase.AutomationBase;
import automationBase.AutomationThreadLocalFactory;
import automationBase.AutomationUI;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import webTDK.common.ThreadLocalBaseFactory;
import webTDK.common.helpers.wait.WaitConditions;
import webTDK.common.helpers.wait.WaitHelpers;

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
        //ui.pafLandingPage.clickToGameManufacturerDropdown();

        //ui.pafLandingPage.clickToGameManufacturer();

        //WaitHelpers.delay(5);
        ui.pafLandingPage.clickToGameManufacturerDropdown();
        List<WebElement> listOfManufacturers = driver.findElements(By.xpath("//div[@class = \"enp7ohk0 css-1jrdolm e178mt9h0\"]/a"));
        System.out.println(listOfManufacturers.size());
        if (!listOfManufacturers.isEmpty()) {
            /*for (WebElement element : listOfManufacturers) {
                try {
                    element.click();
                    //WaitConditions.steadinessOf(element);
                    WaitHelpers.delay(3);
                    ui.pafLandingPage.scrollToLastElement();
                    WaitHelpers.delay(3);
                    ui.pafLandingPage.scrollToGameManufacturerDropdown();
                } catch (StaleElementReferenceException e) {
                    System.out.println("StaleElementReferenceException occurred. Refreshing elements..." + "\nException: " + e);
                    // You can retry the operation or refresh the elements here
                    continue;
                }
            }*/

            for (WebElement element : listOfManufacturers) {
                element.click();
                List<WebElement> listOfElements = driver.findElements(By.xpath("//li[@class = \"css-qdmxni e1kpsuhn1\"]"));
                if (!listOfElements.isEmpty()) {
                    WebElement lastElement = listOfElements.get(listOfElements.size() - 1);
                    //ui.pafLandingPage.scrollToElement(lastElement);
                    Actions actions = new Actions(driver);
                    actions.moveToElement(lastElement);
                    actions.perform();
                } else {
                    System.out.println("No elements found.");
                }
                WebElement showMoreButton = driver.findElement(By.xpath("//button[@type = \"button\" and contains(text(), \"Show More\")]"));
                while (showMoreButton.isDisplayed()) {
                    showMoreButton.click();
                    ui.pafLandingPage.scrollToLastElement();
                    showMoreButton = driver.findElement(By.xpath("//button[@type = \"button\" and contains(text(), \"Show More\")]"));
                }
            }
        } else {
            System.out.println("No elements found");
        }
    }

    @AfterMethod(alwaysRun = true)
    public void after(){
        //driver.quit();
        ThreadLocalBaseFactory.removeThreadLocalVariables();
    }
}
