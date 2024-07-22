package Selenium.ex_Selenium_11072024;

import org.openqa.selenium.edge.EdgeDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class Lab304 {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://bing.com");

        Thread.sleep(2000);

        //  // No back, forward allowed in case of get

        driver.navigate().to("https://app.vwo.com");
        driver.navigate().to(new URL("https://google.com"));
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.quit();


    }
}
