package com.info6255.group8.Scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Scenario1AddToFav {

    public static void runScenario1(WebDriver driver) {

        // Load Northeastern Login Page
        driver.get("https://me.northeastern.edu");
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Choose Active Directory
        driver.findElement(By.xpath("//*[text()='Active Directory']")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Type in username and password and click submit
        driver.findElement(By.id("userNameInput")).sendKeys("UserName");
        driver.findElement(By.id("passwordInput")).sendKeys("Password");
        driver.findElement(By.id("submitButton")).click();
        try {
            Thread.sleep(4000);
        } catch (Exception err) {
            err.printStackTrace();
        }

        driver.findElement(By.xpath("//*[text()='Send Me a Push ']")).click();
        try {
            Thread.sleep(7000);
        } catch (Exception err) {
            err.printStackTrace();
        }

        // Login Confirmation
        driver.findElement(By.id("idSIButton9")).click();
        try {
            Thread.sleep(12000);
        } catch (Exception err) {
            err.printStackTrace();
        }
//        driver.findElement(By.id("id__94")).click();
//        driver.manage().window().maximize();
//        try {
//            Thread.sleep(2000);
//        } catch (Exception err) {
//            System.out.println(err);
//        }

        // Close the dialog box
        driver.findElement(By.xpath("//*[text()='\uE711']")).click();
        try {
            Thread.sleep(12000);
        } catch (Exception err) {
            err.printStackTrace();
        }

        // Click Resources Button
        driver.manage().window().fullscreen();
        driver.findElement(By.partialLinkText("Resources")).click();
        try {
            Thread.sleep(3000);
        } catch (Exception err) {
            err.printStackTrace();
        }

        // Click on the Academics, Classes & Registration Button
        driver.findElement(By.xpath("//*[text()='Academics, Classes & Registration']")).click();
        try {
            Thread.sleep(3000);
        } catch (Exception err) {
            err.printStackTrace();
        }

        // Add to Favorites

        // 1. Canvas LMS
        driver.findElement(By.xpath("//*[@data-gtm-sh-resources-favorite='Canvas LMS']")).click();
        try {
            Thread.sleep(4000);
        } catch (Exception err) {
            err.printStackTrace();
        }

        // 2. Course Descriptions
        driver.findElement(By.xpath("//*[@data-gtm-sh-resources-favorite='Course Descriptions']")).click();
        try {
            Thread.sleep(4000);
        } catch (Exception err) {
            err.printStackTrace();
        }

        // 3. Academic Calender
        driver.findElement(By.xpath("//*[@data-gtm-sh-resources-favorite='Academic Calendar']")).click();
        try {
            Thread.sleep(4000);
        } catch (Exception err) {
            err.printStackTrace();
        }

        // 4. Advising Services
        driver.findElement(By.xpath("//*[@data-gtm-sh-resources-favorite='Advising Services']")).click();
        try {
            Thread.sleep(4000);
        } catch (Exception err) {
            err.printStackTrace();
        }

        // Logout and Close the window
        driver.findElement(By.xpath("//*[@id='O365_MainLink_Me']")).click();
        driver.findElement(By.xpath("//*[text()='Sign out']")).click();
        try {
            Thread.sleep(4000);
        } catch (Exception err) {
            err.printStackTrace();
        }
        driver.close();
    }
}
