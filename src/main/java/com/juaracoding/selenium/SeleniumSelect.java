package com.juaracoding.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class SeleniumSelect {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\juaracoding\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://demoqa.com/select-menu");
        System.out.println("Get URL");
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");

        String title = driver.findElement(By.className("main-header")).getText();
        System.out.println("Title Page :"+title);

        WebElement selectColor =  driver.findElement(By.id("oldSelectMenu"));
        Select color = new Select(selectColor);
        color.deselectByValue("10");
        color.selectByIndex(9);
        color.selectByVisibleText("Black");
        System.out.println("Test Select Aqua");
        System.out.println("=== Delay 3 second ===");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        driver.quit();
        System.out.println("Quit Browser");

    }
}