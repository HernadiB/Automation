package webTDK.screen.capture;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import webTDK.environment.OSManagement;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotManager {
    //DEFAULT_SAVE_PATH = "target/saveScreenshot";

    /**
     * Take screenshot from actual driver
     * @param driver Actual Webdriver
     * @return Embedable screenshot String
     */
    public static byte[] takeScreenshot(WebDriver driver){
        return takeScreenshot(driver, "testCaseScreenshot");
    }

    /**
     * Take screenshot from actual driver
     * @param driver Actual Webdriver
     * @param testName Test name String
     * @return Embedale screenshot String
     */
    public static byte[] takeScreenshot(WebDriver driver, String testName){
        String date = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotName = testName + date;
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        byte[] embeddableImage;
        try {
            FileUtils.copyFile(source, new File(OSManagement.adjustPathToCurrentOS("target/screenshots/" + date + "/" + screenshotName + ".png")));
            embeddableImage = FileUtils.readFileToByteArray(source);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return embeddableImage;
    }
    /*
    public static void takeScreenshotAndAttachToScenario(WebDriver driver, Scenario scenario, String screenshotName){
        byte[] embeddableScreenshot = takeScreenshot(driver, screenshotName);
        attachScreenshotToScenario(scenario, embeddableScreenshot, screenshotName);
    }

    public static void takeScreenshotAndAttachToScenario(WebDriver driver, Scenario scenario){
        byte[] embeddableScreenshot = takeScreenshot(driver, scenario.getName().replace(" ", "_"));
        attachScreenshotToScenario(scenario, embeddableScreenshot);
    }

    public static void attachScreenshotToScenario(Scenario scenario, byte[] embeddableScreenshot, String screenshotName){
        scenario.attach(embeddableScreenshot, "image/png", screenshotName);
    }

    public static void attachScreenshotToScenario(Scenario scenario, byte[] embeddableScreenshot){
        scenario.attach(embeddableScreenshot, "image/png", scenario.getName());
    }
    */

    //saveScreenshot(File screenshot, String path, String fileName);
}
