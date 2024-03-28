package webTDK.common.helpers.wait;

import org.openqa.selenium.WebDriver;
import webTDK.common.VoidFunction;
import webTDK.constants.Timeouts;

import java.time.Duration;

/**
 * Helper class for wait helpers
 */
public class WaitHelpers {
    /**
     * Do a voidFunction with custom implicit wait, most used if we wait for an element is disappear
     * @param driver WebDriver
     * @param customDuration Custom duration in second
     * @param function what we want to do
     */
    public static void withCustomImplicitWait(WebDriver driver, Duration customDuration, VoidFunction function){
        driver.manage().timeouts().implicitlyWait(customDuration);
        function.execute();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Timeouts.IMPLICIT_WAIT));
    }

    /**
     * Retry a function if an exception throw with default attempt limit
     * @param retryFunction The function which is executed
     */
    public static void retryIfExceptionThrown(VoidFunction retryFunction){
        retryIfExceptionThrown(Timeouts.ATTEMPT_LIMIT, retryFunction);
    }

    /**
     * Retry a function if an exception throw with added attempt limit
     * @param attemptLimit How many times try to do the function
     * @param retryFunction The function which is executed
     */
    public static void retryIfExceptionThrown(long attemptLimit, VoidFunction retryFunction){
        int attempts = 1;
        while (true){
            try {
                retryFunction.execute();
                return;
            } catch (Exception e){
                System.out.println("exception catched: " + e);
                attempts++;
                if (attempts == attemptLimit){
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException ex){
                        ex.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * Thread sleep for debugging or if really need to wait
     * @param sleepDuration Sleep duration in seconds
     */
    public static void delay(int sleepDuration){
        try {
            Thread.sleep((long) sleepDuration * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
