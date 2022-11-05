package com.kitapyurdu.methods;

import com.kitapyurdu.driver.DriverSetup;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Methods {

    WebDriver driver;

    FluentWait<WebDriver> wait;

    public Methods(){
        driver = DriverSetup.driver;
        wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);
    }

    public WebElement findElement(By webelement){
        return wait.until(ExpectedConditions.elementToBeClickable(webelement));
    }

    public void click(By webelement){
        findElement(webelement).click();
    }

    public void sendKey(By element, String key){
        findElement(element).sendKeys(key);
    }


    public String getText(By element){
        return findElement(element).getText();
    }

    public void scrollScreen(By element){
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(element))
                .build()
                .perform();
    }
    public int randomNumber(int number){
        Random random = new Random();
        return random.nextInt(number - 3) + 3;
    }
    public WebElement randomElement(By element){
        List<WebElement> elementList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
        return elementList.get(randomNumber(elementList.size()));

    }

    public void hoverCursor(By element){
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(element)).perform();
    }

    public String  removeProductxpath(String attributeValue){
        return attributeValue.replace("addTo","removeFrom");
    }

    public void waitBySecond(long second){
        try {
            Thread.sleep(second * 100);
        }catch (Exception e){
            e.printStackTrace();
        }

    }



}
