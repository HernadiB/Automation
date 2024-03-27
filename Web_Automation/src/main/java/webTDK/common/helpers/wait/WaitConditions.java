package webTDK.common.helpers.wait;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import webTDK.common.helpers.PresenceHelpers;

public class WaitConditions {
    public static ExpectedCondition<Boolean> iframeIsAvailable(WebDriver driver, final WebElement iframeElement){
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webdriver){
                try {
                    if (PresenceHelpers.isPresent(driver, iframeElement)){return true; }
                } catch (InvalidArgumentException e){
                    System.out.println("iframe is not visible");
                }
                return false;
            }
        };
    }

    /**
     * An expectation for checking that the given element as the same location and dimension between two calls,
     * so it does not have any animation, or moved and is still attached to the DOM
     * Use as wait.until() parameter
     * @param element WebElement
     * @return true once the check element has same dimension and location between two calls, meaning it is ready, and attached to the DOM
     */
    public static ExpectedCondition<Boolean> steadinessOf(final WebElement element){
        return new ExpectedCondition<Boolean>() {
            private WebElement lastElement = null;
            private Point lastLocation = null;
            private Dimension lastDimension = null;

            @Override
            public Boolean apply(WebDriver driver) {
                if (lastElement == null){ lastElement = element; }

                try {
                    if (PresenceHelpers.isPresent(driver, lastElement)){
                        Point location = lastElement.getLocation();
                        Dimension dimension = lastElement.getRect().getDimension();
                        if (location.equals(lastLocation) && dimension.equals(lastDimension)) { return true; }
                        lastLocation = location;
                        lastDimension = dimension;
                    }
                } catch (StaleElementReferenceException e) {
                    lastElement = null;
                }
                return false;
            }

            @Override
            public String toString(){ return "steadiness of element: " + element; }
        };
    }
}
