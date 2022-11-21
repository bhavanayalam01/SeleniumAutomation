package com.info6255.group8.Scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static com.info6255.group8.ScreenShot.shot;

public class Scenario5CreatePlan {
    public static void runScenario5(WebDriver driver) throws InterruptedException {
        driver.get("https://me.northeastern.edu");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        shot(driver,"D:/Github/SeleniumAutomation/Scenario5.1.png");

        // Choose Active Directory
        driver.findElement(By.xpath("//*[text()='Active Directory']")).click();
        shot(driver,"D:/Github/SeleniumAutomation/Scenario5.2.png");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Type in username and password
        driver.findElement(By.id("userNameInput")).sendKeys("Your username");
        driver.findElement(By.id("passwordInput")).sendKeys("Your password");
        shot(driver,"D:/Github/SeleniumAutomation/Scenario5.3.png");
        driver.findElement(By.id("submitButton")).click();
        try {
            Thread.sleep(4000);
        } catch (Exception err) {
            System.out.println(err);
        }


        // Send Duo Authentication
        shot(driver,"D:/Github/SeleniumAutomation/Scenario5.4.png");
        driver.findElement(By.cssSelector("button.positive.auth-button")).click();
        shot(driver,"D:/Github/SeleniumAutomation/Scenario5.5.png");
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
        shot(driver,"D:/Github/SeleniumAutomation/Scenario5.6.png");
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
        shot(driver,"D:/Github/SeleniumAutomation/Scenario5.7.png");

        // Click Classes Button
        driver.findElement(By.tagName("p")).click();
        shot(driver,"D:/Github/SeleniumAutomation/Scenario5.8.png");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Click Registration Button
        driver.findElement(By.partialLinkText("Registration")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Click Plan Ahead
        String handle = driver.getWindowHandle();

        // switch to new window to open Banner
        for (String handles : driver.getWindowHandles()) {
            if (handles.equals(handle))
                continue;
            driver.switchTo().window(handles);
        }
        try {
            Thread.sleep(2000);
        } catch (Exception err) {
            System.out.println(err);
        }
        shot(driver,"D:/Github/SeleniumAutomation/Scenario5.9.png");
        driver.findElement(By.id("planningLink")).click();

        // Login Again? Whats going on?
        shot(driver,"D:/Github/SeleniumAutomation/Scenario5.10.png");
        driver.findElement(By.id("username")).sendKeys("Your username");
        driver.findElement(By.id("password")).sendKeys("Your password");
        shot(driver,"D:/Github/SeleniumAutomation/Scenario5.10.png");
        driver.findElement(By.name("_eventId_proceed")).click();


        // Send Duo Authentication
        driver.switchTo().frame("duo_iframe");
        driver.findElement(By.xpath("//*[@id=\"auth_methods\"]/fieldset/div[1]/button")).click();
        shot(driver,"D:/Github/SeleniumAutomation/Scenario5.11.png");
        try {
            Thread.sleep(7000);
        } catch (Exception err) {
            System.out.println(err);
        }

        // Choose 2023 spring semester for the list and confirm
        driver.switchTo().defaultContent();
        shot(driver,"D:/Github/SeleniumAutomation/Scenario5.12.png");

        driver.findElement(By.id("s2id_txt_term")).click();
        driver.findElement(By.id("s2id_autogen1_search")).sendKeys("Spring 2023 Semester");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@id=\"202330\"]")).click();
        driver.findElement(By.id("term-go")).click();
        shot(driver,"D:/Github/SeleniumAutomation/Scenario5.13.png");
        try {
            Thread.sleep(5000);
        } catch (Exception err) {
            System.out.println(err);
        }

        // Create Plan
        driver.findElement(By.id("createPlan")).click();
        shot(driver,"D:/Github/SeleniumAutomation/Scenario5.14.png");
        try {
            Thread.sleep(2000);
        } catch (Exception err) {
            System.out.println(err);
        }

        // Search Course
        driver.findElement(By.id("search-go")).click();
        shot(driver,"D:/Github/SeleniumAutomation/Scenario5.15.png");
        try {
            Thread.sleep(2000);
        } catch (Exception err) {
            System.out.println(err);
        }

        // Add new plan
        driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[1]/td[6]/div/button[2]")).click();
        shot(driver,"D:/Github/SeleniumAutomation/Scenario5.16.png");
        driver.findElement(By.id("saveButton")).click();
        shot(driver,"D:/Github/SeleniumAutomation/Scenario5.17.png");
        driver.findElement(By.id("txt_planDesc")).sendKeys("NEW PLAN");
        shot(driver,"D:/Github/SeleniumAutomation/Scenario5.18.png");
        try {
            Thread.sleep(1000);
        } catch (Exception err) {
            System.out.println(err);
        }
        driver.findElement(By.xpath("/html/body/div[23]/div[3]/div/button[2]")).click();
        try {
            Thread.sleep(1000);
        } catch (Exception err) {
            System.out.println(err);
        }
        shot(driver,"D:/Github/SeleniumAutomation/Scenario5.19.png");

    }
}
