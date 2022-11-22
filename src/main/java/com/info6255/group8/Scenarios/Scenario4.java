package com.info6255.group8.Scenarios;



import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.Keys;



public class Scenario4{


    public static void runScenario4(WebDriver driver) throws InterruptedException {
        driver.get("https://northeastern.bncollege.com/");
        driver.manage().window().maximize();



        driver.navigate().refresh();
        try {
            Thread.sleep(2000);
        } catch (Exception err) {
            System.out.println(err);
        }

        driver.findElement(By.id("bnedLoginButton")).click();

        WebDriverWait wait = new WebDriverWait(driver, 500);

        //switching to login popup and adding details
        driver.switchTo().frame("loginHeaderIframe1");
        WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"email\"]")));
        username.sendKeys("zhang.yuso@northeastern.edu");

        WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"password\"]")));
        password.sendKeys("Zys400419......");
        TimeUnit.SECONDS.sleep(2);
        driver.switchTo().defaultContent();

        //clicking signin
        driver.findElement(By.id("submitLoginHeaderForm")).click();
        TimeUnit.SECONDS.sleep(2);




        //sending search input
        WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bned_site_search\"]")));
        search.sendKeys("laptop");
        TimeUnit.SECONDS.sleep(2);
        search.sendKeys(Keys.RETURN);



//        to perform Scroll on application using Selenium
        driver.findElement(By.xpath("//*[@id=\"extole-7076441836747516576\"]/div/div/a/svg")).click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,250)", "");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-250)", "");



//        selecting option
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement e = wait.until(ExpectedConditions
                .elementToBeClickable(driver.findElement(By.xpath("/html/body/main/div[3]/div[5]/div[1]/div[2]/div/div/div/ul/div[1]/div/a"))));
        TimeUnit.SECONDS.sleep(2);

        e.findElement(By.xpath("/html/body/main/div[3]/div[5]/div[1]/div[2]/div/div/div/ul/div[1]/div/a")).click();


        //to perform Scroll on application using Selenium
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,250)", "");

        //click on add to cart
        TimeUnit.SECONDS.sleep(1);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement addToCart =wait.until(ExpectedConditions
                .elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"addToCartButton\"]"))));
        addToCart.findElement(By.xpath("//*[@id=\"addToCartButton\"]")).click();


        //to perform Scroll on application using Selenium
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-250)", "");

        //opening cart
        TimeUnit.SECONDS.sleep(1);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement cart =wait.until(ExpectedConditions
                .elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"headerDesktopView\"]/div[5]/div/ul/li[3]/div/div/button/a/span/span"))));
        cart.findElement(By.xpath("//*[@id=\"headerDesktopView\"]/div[5]/div/ul/li[3]/div/div/button/a/span/span")).click();
        TimeUnit.SECONDS.sleep(4);


        System.out.println("Scenario4--------NU_BookstoreAddToCart----finished");

    }

}
