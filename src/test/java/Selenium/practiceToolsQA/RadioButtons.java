package Selenium.practiceToolsQA;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RadioButtons {

    WebDriver driver;
    ChromeOptions options;
    @BeforeTest
    public void openBrowser(){

        options = new ChromeOptions();
        driver = new ChromeDriver(options);
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver.get("https://demoqa.com/radio-button");
        driver.manage().window().maximize();



    }

    @Test
    public void checkTextBox(){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");

        driver.findElement(By.xpath("//label[@for='impressiveRadio']")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement no = driver.findElement(By.id("noRadio"));

        WebElement successMsg = driver.findElement(By.xpath("//span[@class='text-success']"));
        Assert.assertEquals(successMsg.getText(),"Impressive");



    }
}
