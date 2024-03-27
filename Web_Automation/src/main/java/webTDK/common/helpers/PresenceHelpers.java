package webTDK.common.helpers;

import org.openqa.selenium.*;
import webTDK.common.helpers.wait.WaitHelpers;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Helpers class for validate presence of an element
 */
public class PresenceHelpers {
    // TODO: Duration paramter fot Duration.ofSecond(Duration)
    /**
     * Element is present in the DOM
     * @param driver WebDriver
     * @param element WebElement in the DOM
     * @return boolean - false if not present, true is present
     */
    public static boolean isPresent(WebDriver driver, WebElement element){
        AtomicBoolean isPresent = new AtomicBoolean(false);
        WaitHelpers.withCustomImplicitWait(driver, Duration.ofSeconds(0), () -> {
           try {
               element.isDisplayed();
               isPresent.set(true);
           } catch (NoSuchElementException | StaleElementReferenceException e){
               isPresent.set(false);
           }
        });
        return isPresent.get();
    }

    /**
     * Element is present in the DOM
     * @param driver WebDriver
     * @param byLocator Element locator
     * @return boolean - false if not present, true is present
     */
    public static boolean isPresent(WebDriver driver, By byLocator){
        return isPresent(driver, driver.findElement(byLocator));
    }

    public static boolean isPresent(List<WebElement> elementList){
        return elementList.isEmpty();
    }

    /**
     * Element is visible in the DOM
     * @param driver WebDriver
     * @param element WebElement in the DOM
     * @return boolean - false if not present, true is present
     */
    public static boolean isVisible(WebDriver driver, WebElement element){
        return isPresent(driver, element) && element.isDisplayed();
    }

    /**
     * Element is visible in the DOM
     * @param driver WebDriver
     * @param elementLocator Element Locator
     * @return boolean - false if not present, true is present
     */
    public static boolean isVisible(WebDriver driver, By elementLocator){
        return isPresent(driver, driver.findElement(elementLocator)) && driver.findElement(elementLocator).isDisplayed();
    }

    /**
     * Scrolls to the given element, if it is not visible, or it is inside the given thresholds. Should only be used when a sticky header or footer hides the element.
     * @param driver WebDriver
     * @param element The WebElement that needs to be visible
     * @param topThreshold Distance from the top of the page, scrolls if the element is closer than the given top threshold (or not visible)
     * @param bottomThreshold Distance from the top of the page, scrolls if the element is closer than the given bottom threshold (or not visible)
     */
    public static void scrollToElement(WebDriver driver, WebElement element, int topThreshold, int bottomThreshold){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].getBoundingClientRect() && ( " +
                "(arguments[0].getBoundingClientRect().top < " + topThreshold + " || arguments[0].getBoundingClientRect().top > window.innerHeight - " + bottomThreshold + ") &&" +
                "arguments[0].scrollIntoView() || " +
                "window.scrollBy({top: (arguments[0].getBoundingClientRect().top < " + topThreshold + " ? " + -topThreshold + " : arguments[0].getBoundingClientRect().top > window.innerHeight - " + bottomThreshold + " ? " + bottomThreshold + " : 0), behavior: \"instant\"}) +" +
                ")", element);
    }
}
