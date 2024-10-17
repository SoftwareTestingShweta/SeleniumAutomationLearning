package Selenium.practiceToolsQA;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckBox {

    WebDriver driver;
    ChromeOptions options;
    @BeforeTest
    public void openBrowser(){

        options = new ChromeOptions();
        driver = new ChromeDriver(options);
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver.get("https://demoqa.com/checkbox");
        driver.manage().window().maximize();



    }

    @Test
    public void checkTextBox(){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");

        driver.findElement(By.xpath("(//button[@title='Toggle'])[1]")).click();
        driver.findElement(By.xpath("(//button[@title='Toggle'])[2]")).click();


    }

}
