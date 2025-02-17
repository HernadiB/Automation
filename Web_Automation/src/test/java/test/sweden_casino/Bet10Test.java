package test.sweden_casino;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import test.TestBase;

import java.util.ArrayList;
import java.util.List;

public class Bet10Test extends TestBase {
    @Test(groups = {"automation", "job"})
    public void bet10Test(){

        System.out.println("--------------- 10 BET ---------------");

        ui.bet10.open10BetCasinoPage();

        this.driver.navigate().to("https://www.10bet.se/casino/slots");

        ui.bet10.clickFilterAndCountGameProviders();
    }
}
