package Selenium.dataDrivenTesting;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class Test1 {

    WebDriver driver;
    ChromeOptions options;

    @BeforeTest
    public void openBrowser(){
        options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new ChromeDriver(options);

    }

    @Test(dataProvider ="loginData" ,dataProviderClass = ProviderClass.class )
    public void testLogin(String Username , String Password) throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();

//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//        WebElement username = driver.findElement(By.xpath("//input[@placeholder='username']"));
//        username.sendKeys("shweta");
//
//        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
//        password.sendKeys("telka");
//
//        WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
//        button.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys(Username);

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys(Password);

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement dasgText = driver.findElement(By.xpath("//div[@class='oxd-topbar-header-title']/span/h6"));
        Assert.assertEquals(dasgText.getText(),"Dashboard");
        System.out.println(dasgText.getText());

        driver.findElement(By.xpath("//div[@class='oxd-topbar-header-userarea']/ul/li[@class='oxd-userdropdown']")).click();

        List<WebElement> userMenu = driver.findElements(By.xpath("//ul[@class='oxd-dropdown-menu']/li/a"));
        String option ="Logout";

        for (WebElement menu : userMenu){
            if (menu.getText().contains(option)){
                menu.click();
                System.out.println("clicked it");

                break;
            }

        }




    }

    @AfterTest
    public void closeBrowser(){

        driver.quit();
    }

}
