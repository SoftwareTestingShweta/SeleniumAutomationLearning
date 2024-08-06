package Selenium.ex_Selenium_27072024;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class FileUpload_InputType {

    @Test
    public void testVWOLoginNegative() throws InterruptedException {

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--guest");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        WebDriver driver = new EdgeDriver(options);
       // driver.get("https://awesomeqa.com/selenium/upload.html");
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

       // WebElement fileInput = driver.findElement(By.id("fileToUpload"));
        WebElement fileInput = driver.findElement(By.id("file-upload"));
     //   fileInput.sendKeys("C:\\Users\\rahul\\IdeaProjects\\LearningSeleniumATB6x\\src\\test\\java\\Selenium\\ex_Selenium_27072024\\toUpload.txt");

        String dir = System.getProperty("user.dir");
        System.out.println(dir);

        fileInput.sendKeys(dir+"/src/test/java/Selenium/ex_Selenium_27072024/toUpload.txt");
      //  driver.findElement(By.name("submit")).click();
        driver.findElement(By.id("file-submit")).click();




        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();


    }
}
