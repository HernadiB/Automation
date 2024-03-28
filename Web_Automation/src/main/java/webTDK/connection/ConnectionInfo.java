package webTDK.connection;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;

/**
 * Object to store a connection info like driver, baseUrl, WebDriverWait etc...
 */
public class ConnectionInfo {
    // TODO: starttime, executinId?
    /**
     * Webdriver instance
     */
    private WebDriver driver;

    /**
     * Actual used URL's by test environment (FIT, INT, etc...)
     */
    private HashMap<String, String> baseUrls = new HashMap<>();

    /**
     * Webdriver wait
     */
    private WebDriverWait wait;

    /**
     * Get the webdriver wait
     * @return WebdriverWait
     */
    public WebDriverWait getWait(){
        return this.wait;
    }

    /**
     * Set the wait
     * @param wait WebdriverWait
     * @return ConnectionInfo object
     */
    public ConnectionInfo setWait(WebDriverWait wait){
        this.wait = wait;
        return this;
    }

    /**
     * Get tge Webdriver
     * @return Webdriver
     */
    public WebDriver getDriver(){
        return this.driver;
    }

    /**
     * Set the Webdriver
     * @param driver Webdriver
     * @return ConnectionInfo Object
     */
    public ConnectionInfo setDriver(WebDriver driver){
        this.driver = driver;
        return this;
    }

    /**
     * Get the used base url's
     * @return Hashmap
     */
    public HashMap<String, String> getBaseUrls(){
        return this.baseUrls;
    }

    /**
     * Set the baseUrl object
     * @param baseUrls Hashmap object
     * @return ConnectionInfo object
     */
    public ConnectionInfo setBaseUrls(HashMap<String, String> baseUrls){
        this.baseUrls = baseUrls;
        return this;
    }

    /**
     * Put object to base url's haspmap
     * @param testEnvironment keyword (FIT, INT etc...)
     * @param baseUrl Base Url string
     * @return ConnectionInfo object
     */
    public ConnectionInfo putElementBaseUrl(String testEnvironment, String baseUrl){
        this.baseUrls.put(testEnvironment, baseUrl);
        return this;
    }

}
