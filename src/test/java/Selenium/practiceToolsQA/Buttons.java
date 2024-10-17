package Selenium.practiceToolsQA;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Buttons {

    WebDriver driver;
    ChromeOptions options;
    @BeforeTest
    public void openBrowser(){

        options = new ChromeOptions();
        driver = new ChromeDriver(options);
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver.get("https://demoqa.com/buttons");
        driver.manage().window().maximize();



    }

    @Test
    public void checkButtons() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");

        Actions actions = new Actions(driver);

        WebElement dcButton = driver.findElement(By.id("doubleClickBtn"));
        actions.doubleClick(dcButton).build().perform();

        String dcText =  driver.findElement(By.id("doubleClickMessage")).getText();
        Assert.assertEquals(dcText,"You have done a double click");
        System.out.println(dcText);

        Thread.sleep(2000);

        WebElement rgtButton = driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(rgtButton).build().perform();

        String rgtText =  driver.findElement(By.id("rightClickMessage")).getText();
        Assert.assertEquals(rgtText,"You have done a right click");
        System.out.println(rgtText);

        Thread.sleep(2000);

        WebElement simpleButton = driver.findElement(By.xpath("(//button[@type='button' and contains(text(),\"Click Me\")])[3]"));
        simpleButton.click();

        String sbText =  driver.findElement(By.id("dynamicClickMessage")).getText();
        Assert.assertEquals(sbText,"You have done a dynamic click");
        System.out.println(sbText);


    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

}
