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

import java.io.File;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.util.HashMap;

/**
 * Create driver functions
 */
public class DriverFactory {
    /**
     * Create a HashMap and parse all remote settings and then return the setting HashMap.
     * @param driverDto DriverDto object
     * @return Remote setting HashMap
     */
    private static HashMap<String, Object> createRemoteSettingHashMap(DriverDto driverDto){
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", driverDto.getRemoteUsername());
        ltOptions.put("accessKey", driverDto.getRemoteAccessKey());
        ltOptions.put("visual", driverDto.getRemoteVisual());
        ltOptions.put("video", driverDto.getRemoteVideo());
        ltOptions.put("build", driverDto.getRemoteBuild());
        ltOptions.put("project", driverDto.getRemoteProject());
        ltOptions.put("tunnel", driverDto.getRemoteTunnel());
        ltOptions.put("selenium_version", driverDto.getRemoteSeleniumVersion());
        ltOptions.put("w3c", driverDto.getRemoteW3C());
        ltOptions.put("console", driverDto.getRemoteConsole());
        ltOptions.put("terminal", driverDto.getRemoteTerminal());
        return ltOptions;
    }

    /**
     * Create driver instance
     * @param driverDto Driver settings
     * @return Webdriver object
     */
    public static WebDriver createInstance(DriverDto driverDto){
        // Webdriver object
        WebDriver driver = null;
        // Create Remote HashMap
        HashMap<String, Object> RemoteOptions = new HashMap<String, Object>();
        // Get the browser version
        String browserVersion = driverDto.getBrowserVersion();
        String resolution = (driverDto.getBrowserHeight() == 0 && driverDto.getBrowserWidth() == 0) ? "start-maximized" : "--window-size=" + driverDto.getBrowserWidth() + "," + driverDto.getBrowserHeight();
        String browserLang = driverDto.getBrowserLang();

        //Check if local driver available
        File driverRunnableExe = new File("src\\main\\resources\\chromedriver.exe");

        //Switch witch driver we need
        switch (driverDto.getBrowserType()){
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();

                if(!driverDto.getIsRemote()){
                    System.out.println("------------ Run Local Driver ---------------");
                    // Check local chrome driver is exits and set it if its does
                    if(driverRunnableExe.exists()){
                        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
                    }else{
                        try {
                            WebDriverManager.chromedriver().clearDriverCache().browserVersion(browserVersion).setup();
                        }catch (Exception e){
                            throw new RuntimeException("Probably role error. Contact with TACS team. " + e);
                        }

                    }
                }else{
                    System.out.println("------------ Run Remote Driver ---------------");
                    RemoteOptions = createRemoteSettingHashMap(driverDto);
                    chromeOptions.setCapability(CapabilityType.BROWSER_VERSION, browserVersion == "latest" ? null : browserVersion);
                    chromeOptions.setCapability("LT:Options", RemoteOptions);
                }

                // Set the Chrome options
                //chromeOptions.setCapability(CapabilityType.PROXY, Proxy.NO_PROXY);
                chromeOptions.setCapability(CapabilityType.BROWSER_NAME, "chrome");
                chromeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.addArguments("--lang=" + browserLang);
                chromeOptions.addArguments(resolution);

                try {
                    driver = driverDto.getIsRemote() ? new RemoteWebDriver(new URL("https://" + driverDto.getRemoteUsername() + ":" + driverDto.getRemoteAccessKey() + "@hub.lambdatest.com/wd/hub"), chromeOptions) : new ChromeDriver(chromeOptions);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                break;

            case "firefox":
                // Set the Firefox options
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setCapability(CapabilityType.BROWSER_NAME, "firefox");
                firefoxOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
                break;

            case "edge":
                WebDriverManager.edgedriver().browserVersion(browserVersion).setup();
                // Set the Edge options
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setCapability(CapabilityType.BROWSER_NAME, "MicrosoftEdge");
                edgeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

                driver = new EdgeDriver(edgeOptions);
                break;

            case "safari":
                // Set the Safari options
                SafariOptions safariOptions = new SafariOptions();
                safariOptions.setCapability(CapabilityType.BROWSER_NAME, "safari");
                safariOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

                driver = new SafariDriver(safariOptions);
                break;

            case "ie":
                // Set the IE options
                InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
                internetExplorerOptions.setCapability(CapabilityType.BROWSER_NAME, "internet explorer");
                internetExplorerOptions.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                internetExplorerOptions.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);

                driver = new InternetExplorerDriver(internetExplorerOptions);
                break;

            default:
                throw new NotImplementedException("This browser type is not supported: " + driverDto.getBrowserType());
        }

        return driver;
    }
}