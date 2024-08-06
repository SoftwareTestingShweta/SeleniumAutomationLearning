package Selenium.ex_Selenium_27072024;

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

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeXpathTable {

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
    public void testRelativeXpath() throws InterruptedException {

        driver.get("https://cosmocode.io/automation-practice-webtable/");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        int row = driver.findElements(By.xpath("//table[@id='countries']/tbody/tr")).size();
        int col = driver.findElements(By.xpath("//table[@id='countries']/tbody/tr[2]/td")).size();

        System.out.println("Size of row is" + row);
        System.out.println("Size of col is" + col);

        // xpath - //table[@id='countries']/tbody/tr[i]/td[j]

        String firstPart = "//table[@id='countries']/tbody/tr[";
        String secondPart = "]/td[";
        String thirdPart = "]";

        for (int i = 2; i <= row ; i++) {

            for (int j = 3; j <= col ; j++) {

                String dynamicPath = firstPart+i+secondPart+j+thirdPart;
                String data = driver.findElement(By.xpath(dynamicPath)).getText();
                System.out.println(data);

            }

        }


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement tableTr = driver.findElement(By.xpath("//table[@id='countries']/tbody/tr[2]/td[3]"));
        System.out.println(tableTr.getText());

        System.out.println("Is the left of Kabul--> "+driver.findElement(with(By.xpath("//table[@id='countries']/tbody/tr[2]/td[2]/child::strong")).toLeftOf(tableTr)).getText());
        System.out.println("Is the right of Kabul--> "+driver.findElement(with(By.xpath("//table[@id='countries']/tbody/tr[2]/td[4]")).toRightOf(tableTr)).getText());
        System.out.println("Is the below of Kabul--> "+driver.findElement(with(By.xpath("//table[@id='countries']/tbody/tr[3]/td[3]")).below(tableTr)).getText());

// *******************************************************************************************

        //for loop

//        List<WebElement> listOfCurrency = driver.findElements(By.xpath("//table[@id='countries']/tbody/tr/td[4]"));
//        for (WebElement currency:listOfCurrency){
//             String s1 = driver.findElement(with(By.xpath("//table[@id='countries']/tbody/tr/td[3]")).toLeftOf(currency)).getText();
//             String s2 = driver.findElement(with(By.xpath("//table[@id='countries']/tbody/tr/td[5]")).toRightOf(currency)).getText();
//            System.out.println(currency + "--> " +s1 + "--> " + s2);
//        }
//



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
