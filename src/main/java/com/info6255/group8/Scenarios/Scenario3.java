//package com.info6255.group8.Scenarios;
//
//import com.info6255.group8.ScreenShot;
//import org.junit.Test;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.*;
//import com.relevantcodes.extentreports.*;
//import org.testng.annotations.BeforeClass;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.util.Properties;
//import java.io.IOException;
//import java.util.concurrent.TimeUnit;
//
//import static com.info6255.group8.ScreenShot.shot;
//
//public class Scenario3 {
//    ChromeDriver driver;
//    static ExtentReports testReport;
//    static ExtentTest test;
//
//    @BeforeClass
//    public static void startTest() {
//        testReport = new com.relevantcodes.extentreports.ExtentReports("shots/Reports.html", true);
//        test = testReport.startTest("Scenario3Check");
//    }
//
//    @Test
//    public void Scenario3() throws InterruptedException, IOException {
//
//        System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
//
//        driver = new ChromeDriver();
//        // Load Northeastern Login Page
//        shot(driver,"");
//        driver.get("https://me.northeastern.edu");
//        driver.manage().window().maximize();
//        shot(driver,"");
//
//        testReport = new com.relevantcodes.extentreports.ExtentReports("src/shots/Reports.html", true);
//        test = testReport.startTest("Scenario1Check");
//
//        // Validation to check Northeastern Website load was successfully
//        if (driver.getTitle().equalsIgnoreCase("Home Realm Discovery")) {
//            test.log(LogStatus.PASS,"Navigation to me.northeastern.edu was successful");
//        } else {
//            test.log(LogStatus.FAIL,"Navigation to me.northeastern.edu failed");
//        }
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//
//        // Choose Active Directory
//        driver.findElement(By.xpath("//*[text()='Active Directory']")).click();
//        shot(driver,"");
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//
//        // Type in username and password and click submit
//        driver.findElement(By.id("userNameInput")).sendKeys("vinugolu.g@northeastern.edu");
////        System.out.println(Base64.getDecoder().decode(password).toString());
//        driver.findElement(By.id("passwordInput")).sendKeys("Steamsitar@007");
//        shot(driver,"");
//        driver.findElement(By.id("submitButton")).click();
//        try {
//            Thread.sleep(4000);
//        } catch (Exception err) {
//            err.printStackTrace();
//        }
//
//        shot(driver,"");
//        // Send a Push notification to the user
//        driver.findElement(By.xpath("//*[text()='Send Me a Push ']")).click();
//        shot(driver,"");
//        try {
//            Thread.sleep(1000);
//        } catch (Exception err) {
//            err.printStackTrace();
//        }
//
//        // Login Confirmation
//        shot(driver,"");
//        driver.findElement(By.id("idSIButton9")).click();
//        try {
//            Thread.sleep(5000);
//        } catch (Exception err) {
//            err.printStackTrace();
//        }
//
//        // Close the dialog box
//        shot(driver,"");
//        driver.findElement(By.xpath("//*[text()='\uE711']")).click();
//        try {
//            Thread.sleep(4000);
//        } catch (Exception err) {
//            err.printStackTrace();
//        }
//
//
////        Validation to check login was successful
//        if (driver.getTitle().equalsIgnoreCase("Student Hub - Home")) {
//            test.log(LogStatus.PASS,"Login Successful");
//        } else {
//            test.log(LogStatus.FAIL,"Login Failed");
//        }
//
//        // Click Resources Button
//        driver.manage().window().maximize();
//        shot(driver,"");
//        driver.findElement(By.partialLinkText("Resources")).click();
//        try {
//            Thread.sleep(3000);
//        } catch (Exception err) {
//            err.printStackTrace();
//        }
//
//        //  Validation to check resource page navigation was successful
//        if (driver.getTitle().equalsIgnoreCase("Student Hub - Resources")) {
//            test.log(LogStatus.PASS,"Navigation to Resources Page - Success");
//        } else {
//            test.log(LogStatus.FAIL,"Navigation to Resources Page - Failed");
//        }
//
//        // Click on the Academics, Classes & Registration Button
//        shot(driver,"");
//        driver.findElement(By.xpath("//*[text()='Academics, Classes & Registration']")).click();
//        try {
//            Thread.sleep(2000);
//        } catch (Exception err) {
//            err.printStackTrace();
//        }
//
//
//        // Click on the Course Registration
//        shot(driver,"");
//        driver.findElement(By.xpath("//*[@data-gtm-sh-resources-link='Course Registration']")).click();
//        try {
//            Thread.sleep(2000);
//        } catch (Exception err) {
//            err.printStackTrace();
//        }
//
//        // switch to new window to open Banner
//        String handle = driver.getWindowHandle();
//        for (String handles : driver.getWindowHandles()) {
//            if (handles.equals(handle))
//                continue;
//            driver.switchTo().window(handles);
//        }
//        try {
//            Thread.sleep(2000);
//        } catch (Exception err) {
//            System.out.println(err);
//        }
//
//        // Click on the Browse Classes
//        shot(driver,"");
//        driver.findElement(By.xpath("//*[text()='Browse Classes']")).click();
//        try {
//            Thread.sleep(2000);
//        } catch (Exception err) {
//            err.printStackTrace();
//        }
//
//
//
//        // Choose 2023 spring semester for the list and confirm
////        driver.switchTo().defaultContent();
//        shot(driver,"");
//
//        driver.findElement(By.id("s2id_txt_term")).click();
//        driver.findElement(By.id("s2id_autogen1_search")).sendKeys("Spring 2023 Semester");
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        driver.findElement(By.xpath("//div[@id=\"202330\"]")).click();
//        driver.findElement(By.id("term-go")).click();
//        shot(driver,"");
//        try {
//            Thread.sleep(5000);
//        } catch (Exception err) {
//            System.out.println(err);
//        }
//
//
//        driver.findElement(By.id("s2id_txt_subject")).click();
//        try {
//            Thread.sleep(2000);
//        } catch (Exception err) {
//            err.printStackTrace();
//        }
//
//        driver.findElement(By.id("s2id_autogen1")).sendKeys("Information Systems Program");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.findElement(By.xpath("//div[@id=\"select2-drop\"]/ul/li/div/div[@id=\"INFO\"]")).click();
//        try {
//            Thread.sleep(2000);
//        } catch (Exception err) {
//            err.printStackTrace();
//        }
//
//
//        driver.findElement(By.id("search-go")).click();
//        try {
//            Thread.sleep(2000);
//        } catch (Exception err) {
//            err.printStackTrace();
//        }
//
////        Scenario1.extent.endTest(test);
////        Scenario1.extent.flush();
////        driver.quit();
//
//    }
//
//}
