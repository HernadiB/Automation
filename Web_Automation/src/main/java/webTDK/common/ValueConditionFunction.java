package webTDK.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@FunctionalInterface
public interface ValueConditionFunction {
    boolean execute(WebDriver driver, WebElement element, Object value);
}
