package Selenium.ex_Selenium_27072024;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandle {

    @Test
    public void testVWOLoginNegative() throws InterruptedException {

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--guest");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        WebDriver driver = new EdgeDriver(options);
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


       String mainWindowHandle = driver.getWindowHandle();
        System.out.println("Before Click" + mainWindowHandle);
        WebElement link = driver.findElement(By.linkText("Click Here"));
        link.click();

        Set<String> windowHandles = driver.getWindowHandles();

        for (String handles :windowHandles){
            driver.switchTo().window(handles);
            System.out.println(handles);
            if (driver.getPageSource().contains("New Window")){
                System.out.println("Testcase passed");
            }
        }

        driver.switchTo().window(mainWindowHandle);




        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();


    }
}
