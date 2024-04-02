package webTDK.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import webTDK.common.helpers.wait.WaitConditions;
import webTDK.common.helpers.wait.WaitHelpers;
import webTDK.connection.ConnectionInfo;
import webTDK.constants.Timeouts;

import java.time.Duration;
import java.util.function.Function;

public class PageBase {

    public final WebDriver driver;
    public final WebDriverWait wait;

    public PageBase(ConnectionInfo connectionInfo){
        this.driver = connectionInfo.getDriver();
        this.wait = connectionInfo.getWait();
    }

    public PageBase initPage(PageBase page){
        PageFactory.initElements(driver, this);
        return this;
    }

    /**
     * Wait for WebElement to become visible
     * @param webElement : Excepted WebElement
     * @param attemptLimit : Number of attempts (long)
     */
    public void waitUntilWebElementIsVisible(WebElement webElement, long attemptLimit){
        WaitHelpers.retryIfExceptionThrown(attemptLimit, () -> {
            wait.until(WaitConditions.steadinessOf(webElement));
            wait.until(ExpectedConditions.visibilityOf(webElement));
        });
    }

    /**
     * Wait for WebElement to become visible
     * @param webElement : WebElement
     */
    public void waitUntilWebElementIsVisible(WebElement webElement){
        waitUntilWebElementIsVisible(webElement, Timeouts.ATTEMPT_LIMIT);
    }

    /**
     * Wait for WebElement to become visible
     * @param by : Locator of a WebElement
     * @param attemptLimit : Number of attempts (long)
     */
    public void waitUntilWebElementIsVisible(By by, long attemptLimit){
        waitUntilWebElementIsVisible(driver.findElement(by), attemptLimit);
    }


    /**
     * Wait for WebElement to become visible
     * @param by : Locator of a WebElement
     */
    public void waitUntilWebElementIsVisible(By by){
        waitUntilWebElementIsVisible(driver.findElement(by), Timeouts.ATTEMPT_LIMIT);
    }

    /**
     * Wait for WebElement to become clickable
     * @param webElement :WebElement
     * @param attemptLimit : Number of attempts (long)
     */
    public void waitUntilWebElementIsClickable(WebElement webElement, long attemptLimit){
        WaitHelpers.retryIfExceptionThrown(attemptLimit, () -> {
            wait.until(WaitConditions.steadinessOf(webElement));
            wait.until(ExpectedConditions.visibilityOf(webElement));
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
        });
    }

    /**
     * Wait for WebElement to become clickable
     * @param webElement : Locator of a WebElement
     */
    public void waitUntilWebElementIsClickable(WebElement webElement){
        waitUntilWebElementIsClickable(webElement, Timeouts.ATTEMPT_LIMIT);
    }

    /**
     * Wait for WebElement to become clickable
     * @param by : Locator of a WebElement
     */
    public void waitUntilWebElementIsClickable(By by){
        waitUntilWebElementIsClickable(driver.findElement(by), Timeouts.ATTEMPT_LIMIT);
    }

    /**
     * Wait for WebElement to become clickable
     * @param by : Locator of a WebElement
     * @param attemptLimit : Number of attemps (long)
     */
    public void waitUntilWebElementIsClickable(By by, long attemptLimit){
        waitUntilWebElementIsClickable(by, attemptLimit);
    }

    /**
     * Wait for Page Loaded Completely
     * @param webDriver : WebDriver
     */
    public void waitForPageLoad(WebDriver webDriver){
        WebDriverWait wait =new WebDriverWait(webDriver, Duration.ofMillis(Timeouts.IMPLICIT_WAIT));
        Function<WebDriver, Boolean> pageLoaded = new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver input) {
                return ((JavascriptExecutor) input).executeScript("return document.readyState").equals("complete");
            }
        };
        wait.until(pageLoaded);
    }
}
