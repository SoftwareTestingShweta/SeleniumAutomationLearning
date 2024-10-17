package Selenium.practiceToolsQA;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Table {

    WebDriver driver;
    ChromeOptions options;
    @BeforeTest
    public void openBrowser(){

        options = new ChromeOptions();
        driver = new ChromeDriver(options);
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver.get("https://demoqa.com/webtables");
        driver.manage().window().maximize();



    }

    @Test
    public void checkTextBox(){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");

        driver.findElement(By.id("addNewRecordButton")).click();
        driver.findElement(By.id("firstName")).sendKeys("Savi");
        driver.findElement(By.id("lastName")).sendKeys("Telka");
        driver.findElement(By.id("userEmail")).sendKeys("Sav123@gmail.com");
        driver.findElement(By.id("age")).sendKeys("29");
        driver.findElement(By.id("salary")).sendKeys("1900000");
        driver.findElement(By.id("department")).sendKeys("QA");
        driver.findElement(By.id("submit")).click();

        List <WebElement> values = driver.findElements(By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']/div[@role='row']/div[@class='rt-td']"));

        for (WebElement cell : values){
            if (cell.getText().contains("Savi")){
                System.out.println("values are set correctly in the table");
            }
        }


    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

}
