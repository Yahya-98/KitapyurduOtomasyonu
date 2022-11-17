package com.kitapyurdu.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverSetup {
    public static WebDriver driver;

    public DriverSetup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notification");
        options.addArguments("--disable--gpu");
        options.addArguments("--disable--popup-blocking");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://kitapyurdu.com");

    }

    public void teardown() {

        if (driver != null) {
            //driver.close();
            driver.quit();
        }
    }

}
