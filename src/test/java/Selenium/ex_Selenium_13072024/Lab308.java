package Selenium.ex_Selenium_13072024;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Lab308 {

    public static void main(String[] args) throws InterruptedException {

        EdgeOptions options = new EdgeOptions();
     //   options.addArguments("--start-maximized");
     //   options.addArguments("--window-size=800,600");

        WebDriver driver = new EdgeDriver(options);

        driver.get("https://google.com");
        driver.manage().window().maximize();
     // driver.manage().window().minimize();
        Thread.sleep(2000);
        driver.quit();
    }
}
