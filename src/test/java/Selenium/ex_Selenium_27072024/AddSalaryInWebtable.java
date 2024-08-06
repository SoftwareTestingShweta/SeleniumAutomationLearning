package Selenium.ex_Selenium_27072024;

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

import static java.lang.Integer.parseInt;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class AddSalaryInWebtable {

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

        driver.get("https://demoqa.com/webtables");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

//        int row = driver.findElements(By.xpath("//table[@id='countries']/tbody/tr")).size();
//        int col = driver.findElements(By.xpath("//table[@id='countries']/tbody/tr[2]/td")).size();
//
//        System.out.println("Size of row is" + row);
//        System.out.println("Size of col is" + col);

        // *****************************************************************************

        // Locate all the salary cells in the column (adjust the XPath accordingly)
        List<WebElement> salaryCells = driver.findElements(By.xpath("//div[@class='rt-tr-group']/div/div[5]"));

        // Initialize the total salary
        int totalSalary = 0;

        // Sum up the salaries
        for (WebElement cell : salaryCells) {
            // Extract the text and convert it to a number (assuming the salary is a number)
            try {
                int salary = Integer.parseInt(cell.getText().replaceAll("[^\\d]", ""));
                totalSalary += salary;
            } catch (NumberFormatException e) {
                // Handle the case where the text is not a number
                System.out.println("Skipping cell with non-numeric value: " + cell.getText());
            }
        }

        // Print the total salary
        System.out.println("Total Salary: " + totalSalary);

        // Locate the cell where you want to insert the total salary (adjust the XPath accordingly)
      //  WebElement totalCell = driver.findElement(By.xpath("//table[@id='salaryTable']//tr[last()]/td[3]"));

        // Enter the total salary
       // totalCell.clear();  // Clear the existing value if necessary
     //   totalCell.sendKeys(String.valueOf(totalSalary));

        // Optionally, you might need to submit the form or press Enter
      //  totalCell.sendKeys(Keys.RETURN);



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
