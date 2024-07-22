package Selenium.mini_Project_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Katalon_CURA {

    @Test
    public void makeAppointment() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/");
        Assert.assertEquals(driver.getTitle(),"CURA Healthcare Service");
        System.out.println("Title of the page is - "+driver.getTitle());
        Thread.sleep(5000);

        WebElement appointmentButton = driver.findElement(By.id("btn-make-appointment"));
        appointmentButton.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Login page

        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/profile.php#login");
        System.out.println("URL of login page : "+driver.getCurrentUrl());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement loginHeading = driver.findElement(By.xpath("//h2[normalize-space()='Login']"));
        System.out.println("Heading of login page - "+loginHeading.getText());

        Thread.sleep(3000);

        WebElement username = driver.findElement(By.id("txt-username"));
        username.sendKeys("John Doe");
        Thread.sleep(2000);

        WebElement password = driver.findElement(By.id("txt-password"));
        password.sendKeys("ThisIsNotAPassword");
        Thread.sleep(2000);

        WebElement loginButton = driver.findElement(By.id("btn-login"));
        loginButton.click();
        Thread.sleep(3000);

        // Appointment page

        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/#appointment");
        System.out.println("URL of Appointment page : "+driver.getCurrentUrl());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement appointmentHeading = driver.findElement(By.xpath("//h2[normalize-space()='Make Appointment']"));
        System.out.println("Heading of appointment page - "+appointmentHeading.getText());

        Thread.sleep(3000);



        driver.quit();




    }
}
