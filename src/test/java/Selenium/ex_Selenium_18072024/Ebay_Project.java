package Selenium.ex_Selenium_18072024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Ebay_Project {

    WebDriver driver;
    ChromeOptions options;

    @BeforeTest
    public void openBrowser(){

        options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new ChromeDriver(options);

    }

    @Test
    @Description("Test that the title and prices of macmini will print successfully")
    public void verifyTheList(){

        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement searchproduct = driver.findElement(By.cssSelector("input[placeholder=\"Search for anything\"]"));
        searchproduct.sendKeys("macmini");

        WebElement searchButton = driver.findElement(By.cssSelector("input.gh-spr"));
        searchButton.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

       List <WebElement> searchTitle = driver.findElements(By.cssSelector(".s-item__title"));
        List <WebElement> searchTitlesPrices = driver.findElements(By.cssSelector(".s-item__price"));
        System.out.println(searchTitle.size());
        System.out.println(searchTitlesPrices.size());


//        for (WebElement title: searchTitle ) {
//            System.out.println(title.getText());
//        }
//
//        for (WebElement prices : searchTitlesPrices ){
//            System.out.println(prices.getText());
//        }

        //  Ensure both lists are of the same size to avoid IndexOutOfBoundsException

        int size = Math.min(searchTitle.size(), searchTitlesPrices.size());
        for (int i = 0; i < size; i++) {
            System.out.println("Title "+ searchTitle.get(i).getText()+" || "+" Prices " + searchTitlesPrices.get(i).getText());
        }






    }

    @AfterTest
    public void closeBrowser(){

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
