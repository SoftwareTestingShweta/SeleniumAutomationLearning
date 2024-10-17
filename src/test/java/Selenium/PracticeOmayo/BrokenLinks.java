package Selenium.PracticeOmayo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinks {

    WebDriver driver;
    ChromeOptions options;
    @BeforeTest
    public void openBrowser(){

        options = new ChromeOptions();
        driver = new ChromeDriver(options);
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");

    }

    @Test
    public void checkButtons() throws InterruptedException {

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

        for (WebElement link : allLinks){

            String url = link.getAttribute("href");
            System.out.println(url);


            if (url==null || url.isEmpty()){

                System.out.println("URL is empty");
                continue;
            }

            try {
                HttpURLConnection huc = (HttpURLConnection) new URL(url).openConnection();
                huc.connect();

                if (huc.getResponseCode() >= 400){
                    System.out.println(url + " is broken");
                }else {
                    System.out.println(url + " is valid");
                }



            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }

    }

    @AfterTest
    public void closeBrowser(){
        //   driver.quit();
    }
}
