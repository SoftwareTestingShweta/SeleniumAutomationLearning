package Selenium.PracticeOmayo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandle {

    WebDriver driver;
    ChromeOptions options;
    @BeforeTest
    public void openBrowser(){

        options = new ChromeOptions();
        driver = new ChromeDriver(options);
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver.manage().window().maximize();
        driver.get("https://omayo.blogspot.com/");

    }

    @Test
    public void checkButtons() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 800);");

        String parentWindow = driver.getWindowHandle();

        driver.findElement(By.linkText("Open a popup window")).click();

        Set<String> allWindow = driver.getWindowHandles();
        for (String childWindow : allWindow){
            if (!parentWindow.equalsIgnoreCase(childWindow)){
                driver.switchTo().window(childWindow);
                System.out.println(driver.findElement(By.tagName("h3")).getText());
                driver.close();
            }
        }

        driver.switchTo().window(parentWindow);
        driver.close();

    }

    @AfterTest
    public void closeBrowser(){
     //   driver.quit();
    }

}
