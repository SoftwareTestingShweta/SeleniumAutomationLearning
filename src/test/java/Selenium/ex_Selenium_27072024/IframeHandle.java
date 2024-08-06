package Selenium.ex_Selenium_27072024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class IframeHandle {

    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }


    @Test(groups = "QA")
    @Description("Test Case Description")
    public void testIframeHandle() throws InterruptedException {

        driver.get("https://codepen.io/AbdullahSajjad/full/LYGVRgK");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();

        driver.switchTo().frame("result");

        WebElement button = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
        button.click();

        WebElement userName = driver.findElement(By.id("username"));
        WebElement username_errMsg = driver.findElement(with(By.tagName("small")).below(userName));
        String username_errMsg_text = username_errMsg.getText();
        System.out.println(username_errMsg_text);
        Assert.assertEquals(username_errMsg_text,"Username must be at least 3 characters");
        Assert.assertTrue(username_errMsg.isDisplayed());

        WebElement email = driver.findElement(By.id("email"));
        WebElement email_errMsg = driver.findElement(with(By.tagName("small")).below(email));
        String email_errMsg_text = email_errMsg.getText();
        System.out.println(email_errMsg_text);
        Assert.assertEquals(email_errMsg_text,"Email is not invalid");
        Assert.assertTrue(email_errMsg.isDisplayed());

        WebElement password = driver.findElement(By.id("password"));
        WebElement password_errMsg = driver.findElement(with(By.tagName("small")).below(password));
        String password_errMsg_text = password_errMsg.getText();
        System.out.println(password_errMsg_text);
        Assert.assertEquals(password_errMsg_text,"Password must be at least 6 characters");
        Assert.assertTrue(password_errMsg.isDisplayed());

        WebElement confPassword = driver.findElement(By.id("password2"));
        WebElement confPassword_errMsg = driver.findElement(with(By.tagName("small")).below(confPassword));
        String confPassword_errMsg_text = confPassword_errMsg.getText();
        System.out.println(confPassword_errMsg_text);
        Assert.assertEquals(confPassword_errMsg_text,"Password2 is required");
        Assert.assertTrue(confPassword_errMsg.isDisplayed());















    }

    @AfterTest
    public void closeBrowser() {
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        driver.quit();
    }
}
