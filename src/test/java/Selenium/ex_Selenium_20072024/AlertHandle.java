package Selenium.ex_Selenium_20072024;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AlertHandle {

    WebDriver driver;
    ChromeOptions options;

    @BeforeTest
    public void openBrowser(){

        options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new ChromeDriver(options);

    }

    @Test(groups = "QA")
    @Description("Test that user is able to Handle the different alert")
    public void verifyTheList() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());

//        // Alert 1 ==== Normal Alert
//
//        WebElement alert1 = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
//        alert1.click();
//
//        // AWS, Docker, Machine - Slow
//        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.alertIsPresent());
//
//
//        Alert alert = driver.switchTo().alert(); // switch to alert
//        String alertMessage= driver.switchTo().alert().getText(); // capture alert message
//
//
//
//        System.out.println(alertMessage); // Print Alert Message
//        Thread.sleep(3000);
//        alert.accept();
//
//        WebElement result = driver.findElement(By.cssSelector("p[id='result']"));
//        System.out.println("Result of the alert is - "+ result.getText());
//
//        Thread.sleep(3000);

        // ************************************************************************************


//        // Alert 2 ==== Confirmation Alert
//
//        WebElement alertConfirm = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
//        alertConfirm.click();
//
//        // AWS, Docker, Machine - Slow
//        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.alertIsPresent());
//
//
//        Alert alert = driver.switchTo().alert(); // switch to alert
//        String alertMessage= driver.switchTo().alert().getText(); // capture alert message
//
//
//
//        System.out.println(alertMessage); // Print Alert Message
//        Thread.sleep(3000);
//        // Condition 1 - accept
//       // alert.accept();
//
//        // Condition 2 - dismiss
//        alert.dismiss();
//
//        WebElement result = driver.findElement(By.cssSelector("p[id='result']"));
//        System.out.println("Result of the alert is - "+ result.getText());
//
//        Thread.sleep(3000);

 //  *******************************************************************************************

        // Alert 3 ==== Prompt Alert

        WebElement alertPrompt = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        alertPrompt.click();

        // AWS, Docker, Machine - Slow
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());


        Alert alert = driver.switchTo().alert(); // switch to alert
        String alertMessage= driver.switchTo().alert().getText(); // capture alert message



        System.out.println(alertMessage); // Print Alert Message
        Thread.sleep(3000);
        // Condition 1 - accept
         alert.sendKeys("Shweta");
       //  alert.accept();

        // Condition 2 - dismiss
           alert.dismiss();

        WebElement result = driver.findElement(By.cssSelector("p[id='result']"));
        System.out.println("Result of the alert is - "+ result.getText());

        Thread.sleep(3000);



    }

    @AfterTest
    public void closeBrowser(){

       driver.quit();
    }
}
