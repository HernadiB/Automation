package webTDK.connection.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import webTDK.common.helpers.wait.WaitConditions;

public class DriverManager {
    /**
     * Wait the iframe to available and swith to it.
     * @param driver WebDriver
     * @param wait WebDriverWait
     * @param iframeElement Iframe element
     */
    public static void SwitchToFrame(WebDriver driver, WebDriverWait wait, WebElement iframeElement){
        wait.until(WaitConditions.iframeIsAvailable(driver, iframeElement));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeElement));
    }

    public static void switchToDefault(){

    }
}
