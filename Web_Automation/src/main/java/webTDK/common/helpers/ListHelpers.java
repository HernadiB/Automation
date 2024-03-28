package webTDK.common.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import webTDK.common.ElementValueConditions;
import webTDK.common.Value;
import webTDK.common.helpers.wait.WaitHelpers;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class ListHelpers {
    /**
     * Filters the given list of WebElements by given text
     *
     * @param webElementList the list of WebElements
     * @param textToEqual    the text that filtered WebElements texts are equal to
     * @return List that contains WebElements which have same text as the given textToEqual paramter
     */
    public static List<WebElement> filterWebElementListByText(List<WebElement> webElementList, String textToEqual) {
        return webElementList.stream()
                .filter(webElement -> webElement.getText().equals(textToEqual))
                .collect(Collectors.toList());
    }

    /**
     * Returns a repeating element, if all condition elements are present with the given values.
     * @param rootLocator the locator of the repeating element.
     * @param conditions  an ElementValueConditions object which contains inner element locators and Value object which identifies the expected value and the validating condition
     * @return the repeating element if found, otherwise null
     */
    public static WebElement getWebElementFromRepeatingElementsByConditions(WebDriver driver, By rootLocator, ElementValueConditions conditions) {
        WebElement result = null;
        if (!PresenceHelpers.isVisible(driver, rootLocator)) return null;
        for (WebElement element : driver.findElements(rootLocator)) {
            result = element;
            for (Map.Entry<By, Value> entry : conditions.entrySet()) {
                By innerElementLocator = entry.getKey();
                if (Objects.nonNull(innerElementLocator) && !PresenceHelpers.isVisible(driver, element.findElement(innerElementLocator))) {
                    return null;
                }
                if (Objects.nonNull(innerElementLocator)) {
                    WebElement finalResult = result;
                    AtomicBoolean isInnerElementPresent = new AtomicBoolean(false);
                    WaitHelpers.withCustomImplicitWait(driver, Duration.ofSeconds(0), () ->
                    isInnerElementPresent.set(finalResult.findElements(innerElementLocator).isEmpty()));
                    if (isInnerElementPresent.get()) {
                        result = null;
                        break;
                    }
                }
                Value conditionValue = entry.getValue();
                WebElement examinedElement = Objects.isNull(innerElementLocator) ? result : result.findElement(innerElementLocator);
                if (!conditionValue.isConditionFulfilled(driver, examinedElement, conditionValue.getValue())) {
                    result = null;
                    break;
                }
            }
            if (Objects.nonNull(result)) break;
        }
        return result;
    }
}
