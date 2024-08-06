package Selenium.mini_Project_Practice;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Applitools {

    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);

    }

    @Test(groups = "QA")
    @Description("Test Case Description")
    public void testRelativeXpath() throws InterruptedException {

        driver.get("https://demo.applitools.com/app.html#");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        // Locate all the salary cells in the column (adjust the XPath accordingly)
        List<WebElement> positiveAmount = driver.findElements(By.xpath("//table[@class='table table-padded']/tbody/tr/td/span[@class='text-success']"));

        double totalPositiveAmount = 0.0;

        for (WebElement pa : positiveAmount) {
            // Extract the text and convert it to a number (assuming the salary is a number)
            try {
//                double epa = Double.parseDouble(pa.getText().replaceAll("[^\\d.]", ""));
//                totalPositiveAmount += epa;

                String paText = pa.getText().replaceAll("[^\\d.]", "");  // Remove non-numeric characters except for the dot
                double epa = Double.parseDouble(paText);
                totalPositiveAmount += epa;

            } catch (NumberFormatException e) {
                // Handle the case where the text is not a number
                System.out.println("Skipping cell with non-numeric value: " + pa.getText());
            }
        }
        System.out.println("Total positive amount: " + totalPositiveAmount);

        // negative number

        List<WebElement> negativeAmount = driver.findElements(By.xpath("//table[@class='table table-padded']/tbody/tr/td/span[@class='text-danger']"));

        double totalNegativeAmount = 0.0;

        for (WebElement na : negativeAmount) {
            // Extract the text and convert it to a number (assuming the salary is a number)
            try {
//                double ena = Double.parseDouble(na.getText().replaceAll("[^\\d.]", ""));
//                totalNegativeAmount += ena;

                String naText = na.getText().replaceAll("[^\\d.]", "");  // Remove non-numeric characters except for the dot
                double npa = Double.parseDouble(naText);
                totalNegativeAmount += npa;

            } catch (NumberFormatException e) {
                // Handle the case where the text is not a number
                System.out.println("Skipping cell with non-numeric value: " + na.getText());
            }
        }
        System.out.println("Total negative amount: " + totalNegativeAmount);

        System.out.println(totalPositiveAmount - totalNegativeAmount);



    }
    @AfterTest
    public void closeBrowser() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //   driver.quit();
    }

}
