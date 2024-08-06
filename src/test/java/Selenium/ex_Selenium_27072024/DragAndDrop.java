package Selenium.ex_Selenium_27072024;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDrop {

        @Test
        public void testVWOLoginNegative() throws InterruptedException {

            EdgeOptions options = new EdgeOptions();
            options.addArguments("--guest");
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

            WebDriver driver = new EdgeDriver(options);
          //  driver.get("https://www.globalsqa.com/demo-site/draganddrop/#google_vignette");
             driver.get("https://the-internet.herokuapp.com/drag_and_drop");
            driver.manage().window().maximize();
            System.out.println(driver.getTitle());

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            WebElement from = driver.findElement(By.id("column-a"));
            WebElement to = driver.findElement(By.id("column-b"));

            Actions actions =new Actions(driver);

         //   actions.dragAndDrop(from,to).build().perform();

            actions.clickAndHold(from).moveToElement(to).release(to).perform();



            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            driver.quit();


        }
    }


