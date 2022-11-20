package com.info6255.group8;

import com.info6255.group8.Scenarios.Scenario2Delete;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.info6255.group8.Scenarios.Scenario2Delete.runScenario2;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        runScenario2(driver);
    }

}
