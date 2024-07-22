package Selenium.ex_Selenium_20072024;

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

public class StaticTableXpath {

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
    @Description("")
    public void verifyStaticTableXpath(){

        driver.get("https://awesomeqa.com/webtable.html");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());

        // Print all the data in the table. - P1
        // Halen belong to which country  - P2

        // Row  - //table[@id="customers"]/tbody/tr
        // Col - //table[@id="customers"]/tbody/tr[2]/td

        int row = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr")).size();
        int col = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr[2]/td")).size();

        System.out.println("Size of row is" + row);
        System.out.println("Size of col is" + col);


        //table[@id="customers"]/tbody/tr[i]/td[j]
        // i = 1 to 7
        // j = 1 to 3

        //  // xpath ->  //table[@id="customers"]/tbody/tr[5]/td[2]

        // xpath - //table[@id="customers"]/tbody/tr[
        // i
        // ]/td[
        // j
        // ]

        String firstPart = "//table[@id=\"customers\"]/tbody/tr[";
        String secondPart = "]/td[";
        String thirdPart = "]";

        for (int i = 2; i <= row ; i++) {
            for (int j = 1; j <= col; j++) {
                String dynamic_xpath = firstPart+i+secondPart+j+thirdPart;
                String data = driver.findElement(By.xpath(dynamic_xpath)).getText();
              //  System.out.println(data);

                if (data.contains("Helen Bennett")){

                    String country_path = dynamic_xpath+"/following-sibling::td";
                    String company_path = dynamic_xpath+"/preceding-sibling::td";
                    String country_text = driver.findElement(By.xpath(country_path)).getText();
                    String company_text = driver.findElement(By.xpath(company_path)).getText();

                    System.out.println("Helen Bennett is In - " + country_text) ;
                    System.out.println("Helen Bennett is Company - " + company_text);

                }



            }

        }



    }

    @AfterTest
    public void closeBrowser(){

        driver.quit();
    }


}
