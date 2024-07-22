package Selenium.ex_Selenium_20072024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropdownHandle {

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
    @Description("Test that user is able to select dropdown")
    public void verifyTheDropdown(){

        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.manage().window().maximize();

        WebElement dropdown = driver.findElement(By.id("dropdown"));

        Select selObj = new Select(dropdown);
        // 1- Select by Index
       // selObj.selectByIndex(2);

        // 2- Select by Value
       // selObj.selectByValue("2");

        // 3- Select by VisibleText
       // selObj.selectByVisibleText("Option 1");

        // 4- getOptions

        List<WebElement> list= selObj.getOptions();
      //  System.out.println(list.size());
        for (WebElement ele: list){
       //     System.out.println(ele.getText());
        //    System.out.println("**************************");

            if (ele.getText().equals("Option 1")){
                System.out.println("Value of dropdown is - "+ele.getText());
                selObj.selectByVisibleText(ele.getText());
            }

            System.out.println(ele.getText());
        }

        // 5- deselectAll()
    //    selObj.deselectByVisibleText("Option 1");

    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {

        Thread.sleep(3000);
        driver.quit();
    }
}
