package Selenium.ex_Selenium_23072024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DynamicTableOHRM {

    ChromeDriver driver;

    @BeforeTest
    public void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new ChromeDriver(options);
    }


    @Test(groups = "QA")
    @Description("Test Case Description")
    public void testVerifyLogin() throws InterruptedException {

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));


//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//        wait.until(ExpectedConditions.presenceOfElementLocated());

        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement menuList = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a/span"));
        menuList.click();

        WebElement infoHeading =  driver.findElement(By.xpath("//div/h5[@class='oxd-text oxd-text--h5 oxd-table-filter-title']"));
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/h5[@class='oxd-text oxd-text--h5 oxd-table-filter-title']")));

        System.out.println(infoHeading.getText());
        Assert.assertEquals(infoHeading.getText(),"Employee Information");


        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,600)");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement cellList = driver.findElement(By.xpath("//div[@class='oxd-table-body']/div[@class='oxd-table-card'][4]/div[@role='row']/div[@role='cell'][3]/child::div"));
        if (cellList.getText().equals("aniket Ashok")){
            System.out.println(cellList.getText());
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

//        String followingSibling = cellList+"/following::div/div[1]";
//        String followingSibling_text = driver.findElement(By.xpath(followingSibling)).getText();
//
//        System.out.println("The following sibling is "+followingSibling_text);


//        List<WebElement> innerCellList = driver.findElements(By.xpath("//div[@class='oxd-table-body']/div[@class='oxd-table-card'][4]/div[@role='row']/div[@role='cell'][3]/child::div/following::div[@data-v-6c07a142]"));
//
//        String option = "Automaton Tester";
//        for (WebElement singleCell : innerCellList){
//
//            if(singleCell.getText().contains(option)){
//                System.out.println(singleCell.getText());
//
//            }
//
//        }

        List<WebElement> innerCellList = driver.findElements(By.xpath("//div[@class='oxd-table-body']/div[@class='oxd-table-card'][4]/div[@role='row']/div[@role='cell'] "));



    }

    @AfterTest
    public void closeBrowser() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
       // driver.quit();
    }
}
