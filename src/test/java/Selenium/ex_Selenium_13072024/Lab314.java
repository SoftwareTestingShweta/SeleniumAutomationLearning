package Selenium.ex_Selenium_13072024;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Lab314 {

    @Test
    public void testFreeTrial() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://app.vwo.com");
        driver.getTitle();
        Assert.assertEquals(driver.getTitle(),"Login - VWO");

        Thread.sleep(3000);

        WebElement freeTrailLink = driver.findElement(By.linkText("Start a free trial"));
        freeTrailLink.click();

        WebElement emailBox = driver.findElement(By.id("page-v1-step1-email"));
        emailBox.sendKeys("admin@admin.com");

        WebElement checkBox = driver.findElement(By.id("page-559cu-gdpr-consent-checkbox"));
        checkBox.click();

        List<WebElement> buttonList = driver.findElements(By.tagName("button"));
        buttonList.get(0).click();

        Thread.sleep(3000);

        WebElement eamil_exit_error_text = driver.findElement(By.className("invalid-reason"));
        Assert.assertEquals(eamil_exit_error_text.getText(),"An account with this email already exists. Login Here");
        System.out.println(eamil_exit_error_text.getText());

        Thread.sleep(3000);

        driver.quit();




    }
}
