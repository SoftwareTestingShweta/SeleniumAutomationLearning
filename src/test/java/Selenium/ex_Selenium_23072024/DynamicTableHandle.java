package Selenium.ex_Selenium_23072024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DynamicTableHandle {

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

        driver.get("https://awesomeqa.com/webtable1.html");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();

        // table - //table[@summary='Sample Table']/tbody

        WebElement table = driver.findElement(By.xpath("//table[@summary='Sample Table']/tbody"));

        List<WebElement> tableRow = table.findElements(By.tagName("tr"));
        System.out.println(tableRow.size());

        for (int i = 0; i < tableRow.size(); i++) {

            List<WebElement> col = tableRow.get(i).findElements(By.tagName("td"));

            for (WebElement c : col){
                System.out.println(c.getText());
            }

        }







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
