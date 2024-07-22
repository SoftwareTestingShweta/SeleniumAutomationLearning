package Selenium.ex_Selenium_20072024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SelectCheckbox {

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
    @Description("Test that user is able to select checkbox")
    public void verifyTheList(){

        driver.get("https://the-internet.herokuapp.com/checkboxes");
        driver.manage().window().maximize();

//        WebElement checkBox = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
//        checkBox.click();

        List<WebElement> checkBoxes= driver.findElements(By.xpath("//form[@id='checkboxes']/input"));
        checkBoxes.get(0).click();
        checkBoxes.get(1).click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @AfterTest
    public void closeBrowser(){

        driver.quit();
    }
}
