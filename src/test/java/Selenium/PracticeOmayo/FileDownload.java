package Selenium.PracticeOmayo;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileDownload {

    WebDriver driver;
    ChromeOptions options;
    @BeforeTest
    public void openBrowser() throws InterruptedException {

        String dir = System.getProperty("user.dir");
        System.out.println(dir);

        String downloadFilePath = dir+"\\src\\test\\Downloads";
        System.out.println(downloadFilePath);// Replace with your path
        String fileName = "DownloadDemo-master.zip";

        // Set Chrome options to automatically download files to the specified directory
        Map<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("download.default_directory", downloadFilePath);
        chromePrefs.put("download.prompt_for_download", false);
        chromePrefs.put("safebrowsing.enabled", true);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

        // Initialize Chrome driver with the specified options
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get("https://omayo.blogspot.com/p/page7.html");

        driver.findElement(By.linkText("ZIP file")).click();

        Thread.sleep(5000);

        // Verify if the file has been downloaded
        File downloadedFile = new File(downloadFilePath + "/" + fileName);
        System.out.println(downloadedFile);
        if (downloadedFile.exists()) {
            System.out.println("File downloaded successfully: " + downloadedFile.getAbsolutePath());
        } else {
            System.out.println("File download failed.");
        }


//        ChromeOptions options = new ChromeOptions();
//        String downloadPath = System.getProperty("user.dir");
//
//        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
//        chromePrefs.put("profile.default_content_settings.popups", 0);
//        chromePrefs.put("download.default_directory", downloadPath);
//
//        options.setExperimentalOption("prefs",chromePrefs);
//
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver(options);
//        driver.get("http://omayo.blogspot.com/p/page7.html");
//        driver.manage().window().maximize();
//        driver.findElement(By.linkText("ZIP file")).click();
//
//        Thread.sleep(5000);
//
//        String filePathUpdated = downloadPath+"\\DownloadDemo-master.zip";
//
//        File file = new File(filePathUpdated);
//
//        Assert.assertTrue(file.exists());

//        if(file.exists()) {
//
//            file.delete();
//
//        }


    }

    @Test
    public void checkButtons() throws InterruptedException {




    }

    @AfterTest
    public void closeBrowser(){
        //   driver.quit();
    }
}
