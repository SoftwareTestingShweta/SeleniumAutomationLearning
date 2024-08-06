package Selenium.ex_Selenium_25072024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class ShadowDOMElementFinding {

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

        driver.get("https://selectorshub.com/xpath-practice-page/");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,1200)");

     //   WebElement divScrollTo = driver.findElement(By.xpath("//div[@id='userName']"));

    //    js.executeScript("arguments[0].scrollIntoView(true)",divScrollTo);

        WebElement link = (WebElement) js.executeScript("return document.querySelector(\"div#userName\").shadowRoot.querySelector(\"a.learningHub\")");
        link.click();


//        WebElement inputBoxPizza = (WebElement) js.executeScript("return document.querySelector(\"div#userName\").shadowRoot.querySelector(\"div#app2\").shadowRoot.querySelector(\"input#pizza\")");
//        inputBoxPizza.sendKeys("Farmhouse");







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
