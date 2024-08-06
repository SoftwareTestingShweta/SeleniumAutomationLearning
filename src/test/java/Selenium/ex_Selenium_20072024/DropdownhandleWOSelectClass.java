package Selenium.ex_Selenium_20072024;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DropdownhandleWOSelectClass {


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
    @Description("Test that user is able to Handle dropdown w/o select class")
    public void verifyTheList() throws InterruptedException {

 //       driver.get("https://www.bstackdemo.com/");

        driver.get("https://www.browserstack.com/");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());


// **************************************************************************************

     //   Method 1: By storing all the options in List and iterating through it

//        driver.findElement(By.xpath("//select")).click();
//        String option="Highest to lowest";

//        List<WebElement> allOptions=driver.findElements(By.cssSelector("select option"));

//        for(int i=0; i<allOptions.size(); i++) {
//
//            if(allOptions.get(i).getText().contains(option)) {
//
//                allOptions.get(i).click();
//
//                System.out.println("clicked");
//
//                break;
//
//            }
//
//        }

//        for (WebElement elel: allOptions){
//          if (elel.getText().contains(option)){
//              elel.click();
//              System.out.println("clicked it");
//
//              break;
//            }
//        }

// **************************************************************************************

//        Method 2: By creating Custom Locator and without iterating the List

//        driver.findElement(By.xpath("//select")).click();
//        String option="Lowest to highest";
//
//        WebElement dropdown = driver.findElement(By.xpath("//select/option[contains(text(),'" + option + "')]"));
//      //  WebElement dropdown = driver.findElement(By.xpath("//select/option[contains(text(), '" + option + "')]"));
//        dropdown.click();
//        Thread.sleep(3000);
//
//        System.out.println("clicked it");

// **************************************************************************************

//        Method 3: By using JavaScriptExecutor class


//        WebElement dd = driver.findElement(By.xpath("//select"));
//
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//
//        js.executeScript("arguments[0].value='highestprice'", dd);

//  **************************************************************************************

//        Method 4: By using sendKeys method

//        driver.findElement(By.xpath("//select")).sendKeys("highestprice");


//  **************************************************************************************

//        Method 5: By using Actions Class

        WebElement dd = driver.findElement(By.xpath("//button[@id='developers-dd-toggle' and contains(text(),'Developers')]"));

        Actions action=new Actions(driver);

        action.moveToElement(dd).perform();

        String option = "Status";

        WebElement customOption = driver.findElement(By.xpath("//div[@class='bstack-mm-sub-li']/a/span[contains(text(),'"+ option +"')]"));
        customOption.click();









    }

    @AfterTest
    public void closeBrowser(){

      //  driver.quit();
    }
}
