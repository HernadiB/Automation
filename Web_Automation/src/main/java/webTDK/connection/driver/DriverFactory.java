package webTDK.connection.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    /**
     * Create driver instance
     * @param driverDto Driver settings
     * @return Webdriver object
     */
    public static WebDriver createInstance(DriverDto driverDto) {
        // Webdriver object
        WebDriver driver = null;
        // Get the browser version
        String browserVersion = driverDto.getBrowserVersion();
        String resolution = (driverDto.getBrowserHeight() == 0 && driverDto.getBrowserWidth() == 0) ? "start-maximized" : "--window-size=" + driverDto.getBrowserWidth() + "," + driverDto.getBrowserHeight();

        //Switch which driver we need
        switch (driverDto.getBrowserType()){
            case "chrome":
                // Set the driver version
                WebDriverManager.chromedriver().browserVersion(browserVersion).setup();

                // Set the Chrome options
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setCapability(CapabilityType.BROWSER_NAME, "chrome");
                chromeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
                chromeOptions.setCapability(CapabilityType.BROWSER_VERSION, browserVersion == null? "latest" : browserVersion);
                chromeOptions.setCapability("e34:token", driverDto.getE34Token());
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.addArguments(resolution);
                try {
                    driver = driverDto.getIsRemote() ? new RemoteWebDriver(new URL(driverDto.getRemoteUrl()), chromeOptions) : new ChromeDriver(chromeOptions);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "firefox":
                // Set the driver version
                WebDriverManager.firefoxdriver().browserVersion(browserVersion).setup();

                // Set the Firefox options
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setCapability(CapabilityType.BROWSER_NAME, "firefox");
                firefoxOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
                break;
            case "edge":
                // Set the driver version
                WebDriverManager.edgedriver().browserVersion(browserVersion).setup();

                // Set the Firefox options
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setCapability(CapabilityType.BROWSER_NAME, "MicrosoftEdge");
                edgeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

                driver = new EdgeDriver(edgeOptions);
                break;
            case "safari":
                // Set the driver version
                WebDriverManager.safaridriver().browserVersion(browserVersion).setup();

                // Set the Safari options
                SafariOptions safariOptions = new SafariOptions();
                safariOptions.setCapability(CapabilityType.BROWSER_NAME, "safari");
                safariOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

                driver = new SafariDriver(safariOptions);
                break;
            case "ie":
                // Set the driver version
                WebDriverManager.iedriver().browserVersion(browserVersion).setup();

                // Set the IE options
                InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
                internetExplorerOptions.setCapability(CapabilityType.BROWSER_NAME, "internet explorer");
                internetExplorerOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

                driver = new InternetExplorerDriver(internetExplorerOptions);
                break;
            default:
                throw new NotImplementedException("This browser type is not supported: " + driverDto.getBrowserType());
        }
        return driver;
    }
}
