package Selenium.ex_Selenium_13072024;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Lab310 {

    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();

        driver.get("https://app.vwo.com/#/login");
        System.out.println(driver.getTitle());
        driver.quit();



    }
}
