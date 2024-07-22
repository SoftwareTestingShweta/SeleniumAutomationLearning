package Selenium.mini_Project_Practice;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Indrive360 {

    @Test
    public void verifySignUp() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        WebDriver driver = new ChromeDriver(options);
        driver.get(" https://www.idrive360.com/enterprise/login");
        driver.manage().window().maximize();
        Assert.assertEquals(driver.getTitle(),"IDrive® 360 - Sign in to your account");
        System.out.println(driver.getTitle());

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("augtest_040823@idrive.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("123456");

        WebElement signUpButton = driver.findElement(By.id("frm-btn"));
        signUpButton.click();

        // FreeTrailExpired Page

//        System.out.println(driver.getCurrentUrl());
//        Assert.assertEquals(driver.getCurrentUrl(),"https://www.idrive360.com/enterprise/account?upgradenow=true");
//
//        Thread.sleep(5000);
        WebElement freeTrialErrorMsg = driver.findElement(By.xpath("//div[@id='upgrade']//span[text()='Your free trial has expired']"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15000));
        wait.until(ExpectedConditions.textToBePresentInElement(freeTrialErrorMsg,"Your free trial has expired"));

        System.out.println(freeTrialErrorMsg.getText());
           Assert.assertEquals(freeTrialErrorMsg.getText(),"Your free trial has expired");

//        WebElement myAccountText = driver.findElement(By.xpath("//h2[@class='id-tab-title']"));
//        System.out.println(myAccountText.getText()); // //h2[@class='id-tab-title' and text()='My Account']"


        Thread.sleep(3000);

        // Take a screenshot and save it to a file
        takeScreenshot(driver, "screenshot.png");

        driver.quit();

    }

    public static void takeScreenshot(WebDriver driver, String filePath) throws InterruptedException {
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

        Thread.sleep(2000);


    }



}
