package com.info6255.group8.Scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Scenario5CreatePlan {
    public static void runScenario5(WebDriver driver) throws InterruptedException {
        driver.get("https://me.northeastern.edu");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Choose Active Directory
        driver.findElement(By.xpath("//*[text()='Active Directory']")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Type in username and password
        driver.findElement(By.id("userNameInput")).sendKeys("Your username");
        driver.findElement(By.id("passwordInput")).sendKeys("Your password");
        driver.findElement(By.id("submitButton")).click();
        try {
            Thread.sleep(4000);
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
        driver.findElement(By.id("planningLink")).click();

        // Login Again? Whats going on?
        driver.findElement(By.id("username")).sendKeys("Your username");
        driver.findElement(By.id("password")).sendKeys("Your password");
        driver.findElement(By.name("_eventId_proceed")).click();

        // Send Duo Authentication
        driver.switchTo().frame("duo_iframe");
        driver.findElement(By.xpath("//*[@id=\"auth_methods\"]/fieldset/div[1]/button")).click();
        try {
            Thread.sleep(7000);
        } catch (Exception err) {
            System.out.println(err);
        }

        // Choose 2023 spring semester for the list and confirm
        driver.switchTo().defaultContent();

        driver.findElement(By.id("s2id_txt_term")).click();
        driver.findElement(By.id("s2id_autogen1_search")).sendKeys("Spring 2023 Semester");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@id=\"202330\"]")).click();
        driver.findElement(By.id("term-go")).click();
        try {
            Thread.sleep(5000);
        } catch (Exception err) {
            System.out.println(err);
        }

        // Create Plan
        driver.findElement(By.id("createPlan")).click();
        try {
            Thread.sleep(2000);
        } catch (Exception err) {
            System.out.println(err);
        }

        // Search Course
        driver.findElement(By.id("search-go")).click();
        try {
            Thread.sleep(2000);
        } catch (Exception err) {
            System.out.println(err);
        }

        driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[1]/td[6]/div/button[2]")).click();
        driver.findElement(By.id("saveButton")).click();
        driver.findElement(By.id("txt_planDesc")).sendKeys("NEW PLAN");
        try {
            Thread.sleep(1000);
        } catch (Exception err) {
            System.out.println(err);
        }
        driver.findElement(By.xpath("/html/body/div[23]/div[3]/div/button[2]")).click();

    }
}
