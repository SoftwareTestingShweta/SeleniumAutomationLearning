package Selenium.PracticeOmayo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;

public class HiddenElement {

    WebDriver driver;
    ChromeOptions options;
    @BeforeTest
    public void openBrowser(){

        options = new ChromeOptions();
        driver = new ChromeDriver(options);
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver.manage().window().maximize();
        driver.get("https://www.letskodeit.com/practice");

    }

    @Test
    public void checkButtons() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 200);");

        driver.findElement(By.id("hide-textbox")).click();
        js.executeScript("document.getElementById(\"displayed-text\").value='Savi telka';");

    }

    @AfterTest
    public void closeBrowser(){
        //   driver.quit();
    }
}
