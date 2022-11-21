package com.info6255.group8.Scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.info6255.group8.ScreenShot.shot;


public class Scenario2Delete {
    public static void runScenario2(WebDriver driver) throws InterruptedException {
        // Open New Window for me.northeastern.edu

        driver.get("https://me.northeastern.edu");
        shot(driver,"D:/Github/SeleniumAutomation/Scenario2.1.png");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Choose Active Directory
        driver.findElement(By.xpath("//*[text()='Active Directory']")).click();
        shot(driver,"D:/Github/SeleniumAutomation/Scenario2.2.png");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


        // Type in username and password
        driver.findElement(By.id("userNameInput")).sendKeys("Your username");
        driver.findElement(By.id("passwordInput")).sendKeys("Your password");
        shot(driver,"D:/Github/SeleniumAutomation/Scenario2.3.png");
        driver.findElement(By.id("submitButton")).click();
        try {
            Thread.sleep(4000);
        } catch (Exception err) {
            System.out.println(err);
        }

        // Send Duo Authentication
        shot(driver,"D:/Github/SeleniumAutomation/Scenario2.4.png");
        driver.findElement(By.cssSelector("button.positive.auth-button")).click();
        shot(driver,"D:/Github/SeleniumAutomation/Scenario2.5.png");
        try {
            Thread.sleep(7000);
        } catch (Exception err) {
            System.out.println(err);
        }

        // Login Confirmation
        driver.findElement(By.id("idSIButton9")).click();
        try {
            Thread.sleep(12000);
        } catch (Exception err) {
            System.out.println(err);
        }
        shot(driver,"D:/Github/SeleniumAutomation/Scenario2.6.png");
        driver.findElement(By.id("id__94")).click();
        driver.manage().window().maximize();
        try {
            Thread.sleep(2000);
        } catch (Exception err) {
            System.out.println(err);
        }


        // Click Resources Button
        shot(driver,"D:/Github/SeleniumAutomation/Scenario2.7.png");
        driver.findElement(By.partialLinkText("Resources")).click();
        shot(driver,"D:/Github/SeleniumAutomation/Scenario2.8.png");
        try {
            Thread.sleep(3000);
        } catch (Exception err) {
            System.out.println(err);
        }

        // Click Classes Button
        driver.findElement(By.tagName("p")).click();
        shot(driver,"D:/Github/SeleniumAutomation/Scenario2.9.png");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Click on option to add in favorites
        driver.findElement(By.xpath("//*[@id=\"7b3083e7-1956-4f64-968b-920d938ba636\"]/div/div/div/div[2]/div/div/div[1]/div/div[10]/div/i")).click();
        try {
            Thread.sleep(1000);
        } catch (Exception err) {
            System.out.println(err);
        }
        driver.findElement(By.xpath("//*[@id=\"7b3083e7-1956-4f64-968b-920d938ba636\"]/div/div/div/div[2]/div/div/div[1]/div/div[11]/div/i")).click();
        try {
            Thread.sleep(4000);
        } catch (Exception err) {
            System.out.println(err);
        }
        shot(driver,"D:/Github/SeleniumAutomation/Scenario2.10.png");

    }

}
