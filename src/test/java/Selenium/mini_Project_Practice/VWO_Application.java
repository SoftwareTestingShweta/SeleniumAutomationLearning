package Selenium.mini_Project_Practice;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class VWO_Application {

    @Test
    public void verifyValidUserAndPass() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com/");
        Thread.sleep(3000);
        System.out.println(driver.getTitle());

        WebElement email = driver.findElement(By.id("login-username"));
        email.sendKeys("shwetatelkapalliwar9@gmail.com");
        Thread.sleep(3000);

        WebElement password = driver.findElement(By.id("login-password"));
        password.sendKeys("Shweta@123");
        Thread.sleep(2000);

        WebElement submitButton = driver.findElement(By.id("js-login-btn"));
        submitButton.click();

        Thread.sleep(5000);
        WebElement dashPage = driver.findElement(By.xpath("//h1[@class='page-heading']"));
        System.out.println(dashPage.getText());
        Assert.assertEquals(dashPage.getText(),"Dashboard");

        Thread.sleep(3000);
        WebElement username = driver.findElement(By.xpath("//span[@class='Fw(semi-bold) ng-binding']"));
        System.out.println(username.getText());
        Assert.assertEquals(username.getText(),"Shweta Telka");


        Thread.sleep(5000);

        // Take a screenshot and save it to a file
        takeScreenshot(driver, "screenshot.png");


    }

    public static void takeScreenshot(WebDriver driver, String filePath) {
        // Convert WebDriver object to TakesScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot) driver);

        // Call getScreenshotAs method to create an image file
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

        // Move image file to the specified location
        try {
            FileHandler.copy(srcFile, new File(filePath));
            System.out.println("Screenshot saved to: " + filePath);
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }

}
