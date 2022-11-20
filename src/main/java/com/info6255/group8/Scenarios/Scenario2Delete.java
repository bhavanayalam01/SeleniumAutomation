package com.info6255.group8.Scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class Scenario2Delete {
    public static void runScenario2(WebDriver driver) throws InterruptedException {
        // Open New Window for me.northeastern.edu

        driver.get("https://me.northeastern.edu");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Choose Active Directory
        driver.findElement(By.xpath("//*[text()='Active Directory']")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Type in username and password
        driver.findElement(By.id("userNameInput")).sendKeys("zhang.yuso@northeastern.edu");
        driver.findElement(By.id("passwordInput")).sendKeys("Zys400419......");
        driver.findElement(By.id("submitButton")).click();
        try {
            Thread.sleep(7000);
        } catch (Exception err) {
            System.out.println(err);
        }

        // Send Duo Authentication
        driver.findElement(By.cssSelector("button.positive.auth-button")).click();
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
        driver.findElement(By.id("id__94")).click();
        driver.manage().window().maximize();
        try {
            Thread.sleep(2000);
        } catch (Exception err) {
            System.out.println(err);
        }


        // Click Resources Button
        driver.findElement(By.partialLinkText("Resources")).click();
        try {
            Thread.sleep(3000);
        } catch (Exception err) {
            System.out.println(err);
        }

        // Click Classes Button
        driver.findElement(By.tagName("p")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Click on option to add in favorites
        driver.findElement(By.xpath("//*[@id=\"7b3083e7-1956-4f64-968b-920d938ba636\"]/div/div/div/div[2]/div/div/div[1]/div/div[10]/div/i")).click();
        try {
            Thread.sleep(2000);
        } catch (Exception err) {
            System.out.println(err);
        }
        driver.findElement(By.xpath("//*[@id=\"7b3083e7-1956-4f64-968b-920d938ba636\"]/div/div/div/div[2]/div/div/div[1]/div/div[11]/div/i")).click();

        ;

    }

}
