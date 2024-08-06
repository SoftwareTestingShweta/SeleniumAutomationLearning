package Selenium.ex_Selenium_25072024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.plaf.basic.BasicSliderUI;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MakeMyTrip {

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
    public void testVerifyFREETrial() throws InterruptedException {

        driver.get("https://www.makemytrip.com/");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement closeModal = driver.findElement(By.xpath("//div[@class='imageSlideContainer']/section/span[@class='commonModal__close']"));
        closeModal.click();

        Actions actions = new Actions(driver);

        WebElement fromCity = driver.findElement(By.xpath("//input[@id='fromCity']"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        actions.moveToElement(fromCity).click().sendKeys("Pune").build().perform();



       List<WebElement> suggestionsList = driver.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li"));

       for (WebElement singleSuggestion : suggestionsList){
           if (singleSuggestion.getText().contains("Pune")){
               System.out.println(singleSuggestion.getText());
               singleSuggestion.click();
               break;
           }
       }












    }
    @AfterTest
    public void closeBrowser() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //   driver.quit();
    }
}
