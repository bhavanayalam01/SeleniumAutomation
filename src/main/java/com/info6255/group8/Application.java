package com.info6255.group8;

import com.info6255.group8.Scenarios.Scenario2Delete;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.info6255.group8.Scenarios.Scenario2Delete.runScenario2;
import static com.info6255.group8.Scenarios.Scenario5CreatePlan.runScenario5;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
//        ChromeDriver driver = new ChromeDriver();
//        runScenario2(driver);
//        try {
//            driver.quit();
//            Thread.sleep(3000);
//        } catch (Exception err) {
//            System.out.println(err);
//        }
        ChromeDriver driver2 = new ChromeDriver();
        runScenario5(driver2);
    }

}
