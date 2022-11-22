package com.info6255.group8.Scenarios;

import com.info6255.group8.ReadExcelData;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.info6255.group8.ScreenShot.shot;

public class ScenarioRun {

    ChromeDriver driver;
    static ExtentReports testReport;
    static ExtentTest test1;
    static ExtentTest test2;
    static ExtentTest test3;
    static ExtentTest test4;
    static ExtentTest test5;

    @BeforeClass
    public static void startScenario1Test() {
        testReport = new com.relevantcodes.extentreports.ExtentReports("C:\\Users\\swapn\\Documents\\Fall 2022\\Software Quality Control and Management\\Assignments\\Selenium Assignment\\SeleniumAutomation\\Reports.html", true);
        test1 = testReport.startTest("Scenario1Check");
    }

    @Test(dataProvider = "dataInput")
    public void runScenario1(String userName, String password) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\swapn\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");

        driver = new ChromeDriver();
        // Load Northeastern Login Page
        shot(driver,"");
        driver.get("https://me.northeastern.edu");
        driver.manage().window().maximize();
        shot(driver,"");

        // Validation to check Northeastern Website load was successfully
        if (driver.getTitle().equalsIgnoreCase("Home Realm Discovery")) {
            test1.log(LogStatus.PASS,"Navigation to me.northeastern.edu was successful");
        } else {
            test1.log(LogStatus.FAIL,"Navigation to me.northeastern.edu failed");
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Choose Active Directory
        driver.findElement(By.xpath("//*[text()='Active Directory']")).click();
        shot(driver,"");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Type in username and password and click submit
        driver.findElement(By.id("userNameInput")).sendKeys(userName);
//        System.out.println(Base64.getDecoder().decode(password).toString());
        driver.findElement(By.id("passwordInput")).sendKeys(password);
        shot(driver,"");
        driver.findElement(By.id("submitButton")).click();
        try {
            Thread.sleep(4000);
        } catch (Exception err) {
            err.printStackTrace();
        }

        shot(driver,"");
        // Send a Push notification to the user
        driver.findElement(By.xpath("//*[text()='Send Me a Push ']")).click();
        shot(driver,"");
        try {
            Thread.sleep(7000);
        } catch (Exception err) {
            err.printStackTrace();
        }

        // Login Confirmation
        shot(driver,"");
        driver.findElement(By.id("idSIButton9")).click();
        try {
            Thread.sleep(12000);
        } catch (Exception err) {
            err.printStackTrace();
        }

        // Close the dialog box
        shot(driver,"");
        driver.findElement(By.xpath("//*[text()='\uE711']")).click();
        try {
            Thread.sleep(4000);
        } catch (Exception err) {
            err.printStackTrace();
        }

//        Validation to check login was successful
        if (driver.getTitle().equalsIgnoreCase("Student Hub - Home")) {
            test1.log(LogStatus.PASS,"Login Successful");
        } else {
            test1.log(LogStatus.FAIL,"Login Failed");
        }

        // Click Resources Button
        driver.manage().window().maximize();
        shot(driver,"");
        driver.findElement(By.partialLinkText("Resources")).click();
        try {
            Thread.sleep(3000);
        } catch (Exception err) {
            err.printStackTrace();
        }

        //        Validation to check resource page navigation was successful
        if (driver.getTitle().equalsIgnoreCase("Student Hub - Resources")) {
            test1.log(LogStatus.PASS,"Navigation to Resources Page - Success");
        } else {
            test1.log(LogStatus.FAIL,"Navigation to Resources Page - Failed");
        }

        // Click on the Academics, Classes & Registration Button
        shot(driver,"");
        driver.findElement(By.xpath("//*[text()='Academics, Classes & Registration']")).click();
        try {
            Thread.sleep(2000);
        } catch (Exception err) {
            err.printStackTrace();
        }

        // Add to Favorites

        // 1. Canvas LMS
        shot(driver,"");
        driver.findElement(By.xpath("//*[@data-gtm-sh-resources-favorite='Canvas LMS']")).click();
        try {
            Thread.sleep(1500);
        } catch (Exception err) {
            err.printStackTrace();
        }

        // 2. Course Descriptions
        shot(driver,"");
        driver.findElement(By.xpath("//*[@data-gtm-sh-resources-favorite='Course Descriptions']")).click();
        try {
            Thread.sleep(1500);
        } catch (Exception err) {
            err.printStackTrace();
        }

        // 3. Academic Calender
        shot(driver,"");
        driver.findElement(By.xpath("//*[@data-gtm-sh-resources-favorite='Academic Calendar']")).click();
        try {
            Thread.sleep(1500);
        } catch (Exception err) {
            err.printStackTrace();
        }

        // 4. Advising Services
        shot(driver,"");
        driver.findElement(By.xpath("//*[@data-gtm-sh-resources-favorite='Advising Services']")).click();
        try {
            Thread.sleep(1500);
        } catch (Exception err) {
            err.printStackTrace();
        }

        if (driver.getPageSource().contains("Find a link you want to favorite")) {
            test1.log(LogStatus.FAIL,"Adding link to favorites failed");
        } else {
            test1.log(LogStatus.PASS,"Successfully added link to favorite");
        }

        shot(driver,"");
        // Logout and Close the window
        driver.findElement(By.xpath("//*[@id='O365_MainLink_Me']")).click();
        shot(driver,"");
        driver.findElement(By.xpath("//*[text()='Sign out']")).click();
        shot(driver,"");
        try {
            Thread.sleep(4000);
        } catch (Exception err) {
            err.printStackTrace();
        }
        driver.close();
        shot(driver,"");

    }

    @AfterClass
    public static void endScenario1Test() {
        testReport.endTest(test1);
        testReport.flush();
    }

    @BeforeClass
    public static void startScenario2Test() {
        testReport = new com.relevantcodes.extentreports.ExtentReports("C:\\Users\\swapn\\Documents\\Fall 2022\\Software Quality Control and Management\\Assignments\\Selenium Assignment\\SeleniumAutomation\\Reports.html", true);
        test2 = testReport.startTest("Scenario1Check");
    }

    @Test(dataProvider = "dataInput")
    public void runScenario2(String userName, String password) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\swapn\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");

        driver = new ChromeDriver();
        // Load Northeastern Login Page
        shot(driver,"");
        driver.get("https://me.northeastern.edu");
        driver.manage().window().maximize();
        shot(driver,"");

        // Validation to check Northeastern Website load was successfully
        if (driver.getTitle().equalsIgnoreCase("Home Realm Discovery")) {
            test2.log(LogStatus.PASS,"Navigation to me.northeastern.edu was successful");
        } else {
            test2.log(LogStatus.FAIL,"Navigation to me.northeastern.edu failed");
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Choose Active Directory
        driver.findElement(By.xpath("//*[text()='Active Directory']")).click();
        shot(driver,"");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Type in username and password and click submit
        driver.findElement(By.id("userNameInput")).sendKeys(userName);
//        System.out.println(Base64.getDecoder().decode(password).toString());
        driver.findElement(By.id("passwordInput")).sendKeys(password);
        shot(driver,"");
        driver.findElement(By.id("submitButton")).click();
        try {
            Thread.sleep(4000);
        } catch (Exception err) {
            err.printStackTrace();
        }

        shot(driver,"");
        // Send a Push notification to the user
        driver.findElement(By.xpath("//*[text()='Send Me a Push ']")).click();
        shot(driver,"");
        try {
            Thread.sleep(7000);
        } catch (Exception err) {
            err.printStackTrace();
        }

        // Login Confirmation
        shot(driver,"");
        driver.findElement(By.id("idSIButton9")).click();
        try {
            Thread.sleep(12000);
        } catch (Exception err) {
            err.printStackTrace();
        }

        // Close the dialog box
        shot(driver,"");
        driver.findElement(By.xpath("//*[text()='\uE711']")).click();
        try {
            Thread.sleep(4000);
        } catch (Exception err) {
            err.printStackTrace();
        }

//        Validation to check login was successful
        if (driver.getTitle().equalsIgnoreCase("Student Hub - Home")) {
            test2.log(LogStatus.PASS,"Login Successful");
        } else {
            test2.log(LogStatus.FAIL,"Login Failed");
        }

        // Click Resources Button
        driver.manage().window().maximize();
        shot(driver,"");
        driver.findElement(By.partialLinkText("Resources")).click();
        try {
            Thread.sleep(3000);
        } catch (Exception err) {
            err.printStackTrace();
        }

        //        Validation to check resource page navigation was successful
        if (driver.getTitle().equalsIgnoreCase("Student Hub - Resources")) {
            test2.log(LogStatus.PASS,"Navigation to Resources Page - Success");
        } else {
            test2.log(LogStatus.FAIL,"Navigation to Resources Page - Failed");
        }

        // Click on the Academics, Classes & Registration Button
        shot(driver,"");
        driver.findElement(By.xpath("//*[text()='Academics, Classes & Registration']")).click();
        try {
            Thread.sleep(2000);
        } catch (Exception err) {
            err.printStackTrace();
        }

        // Add to Favorites

        // 1. Canvas LMS
        shot(driver,"");
        driver.findElement(By.xpath("//*[@data-gtm-sh-resources-favorite='Canvas LMS']")).click();
        try {
            Thread.sleep(1500);
        } catch (Exception err) {
            err.printStackTrace();
        }

        // 2. Course Descriptions
        shot(driver,"");
        driver.findElement(By.xpath("//*[@data-gtm-sh-resources-favorite='Course Descriptions']")).click();
        try {
            Thread.sleep(1500);
        } catch (Exception err) {
            err.printStackTrace();
        }

        // 3. Academic Calender
        shot(driver,"");
        driver.findElement(By.xpath("//*[@data-gtm-sh-resources-favorite='Academic Calendar']")).click();
        try {
            Thread.sleep(1500);
        } catch (Exception err) {
            err.printStackTrace();
        }

        // 4. Advising Services
        shot(driver,"");
        driver.findElement(By.xpath("//*[@data-gtm-sh-resources-favorite='Advising Services']")).click();
        try {
            Thread.sleep(1500);
        } catch (Exception err) {
            err.printStackTrace();
        }

        if (driver.getPageSource().contains("Find a link you want to favorite")) {
            test2.log(LogStatus.PASS,"Remove links from favorites was successful");
        } else {
            test2.log(LogStatus.PASS,"Remove links from favorites failed");
        }

        shot(driver,"");
        // Logout and Close the window
        driver.findElement(By.xpath("//*[@id='O365_MainLink_Me']")).click();
        shot(driver,"");
        driver.findElement(By.xpath("//*[text()='Sign out']")).click();
        shot(driver,"");
        try {
            Thread.sleep(4000);
        } catch (Exception err) {
            err.printStackTrace();
        }
        driver.close();
        shot(driver,"");

    }

    @AfterClass
    public static void endScenario2Test() {
        testReport.endTest(test2);
        testReport.flush();
    }

    @BeforeClass
    public static void startScenario4Test() {
        testReport = new com.relevantcodes.extentreports.ExtentReports("C:\\Users\\swapn\\Documents\\Fall 2022\\Software Quality Control and Management\\Assignments\\Selenium Assignment\\SeleniumAutomation\\Reports.html", true);
        test4 = testReport.startTest("Scenario4Check");
    }

    @Test(dataProvider = "dataInput")
    public void runScenario4(String userName, String password) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\swapn\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");

        driver = new ChromeDriver();
        // Load Northeastern Bookstore Page
        shot(driver,"");
        driver.get("https://northeastern.bncollege.com/");
        driver.manage().window().maximize();
        shot(driver,"");

        // Validation to check Northeastern BookStore Website load was successfully
        if (driver.getTitle().equalsIgnoreCase("Apparel, Gifts & Textbooks | Northeastern University Official Bookstore")) {
            test4.log(LogStatus.PASS,"Navigation to Northeastern Bookstore Website was successful");
        } else {
            test4.log(LogStatus.FAIL,"Navigation to Northeastern Bookstore Website failed");
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

//        // Click on Sign-In/Create Account Button to navigate to LoginPage
//        driver.findElement(By.xpath("//*[text()='Sign In / Create Account']")).click();
//        shot(driver,"");
//        try {
//            Thread.sleep(2000);
//        } catch (Exception err) {
//            err.printStackTrace();
//        }

        // Search for an Item from the search bar
        driver.findElement(By.id("bned_site_search")).sendKeys("dell laptop", Keys.ENTER);
        shot(driver, "");
        try {
            Thread.sleep(2000);
        } catch (Exception err) {
            err.printStackTrace();
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

//        // Select the Item from the search result
//        shot(driver,"");
//        driver.findElement(By.partialLinkText("Dell Inspiron 15 3000 (3511) Non-Touch Laptop 128GB-Black")).click();
//        shot(driver,"");
//        try {
//            Thread.sleep(3000);
//        } catch (Exception err) {
//            err.printStackTrace();
//        }
//
//        //Add the selected item to cart
//        driver.findElement(By.id("addToCartButton")).click();
//        shot(driver,"");
//        try {
//            Thread.sleep(2000);
//        } catch (Exception err) {
//            err.printStackTrace();
//        }
    }

    @AfterClass
    public static void endScenario4Test() {
        testReport.endTest(test4);
        testReport.flush();
    }

    @DataProvider(name = "dataInput")
    public Object [][] DataInputFeed() {
        ReadExcelData config = new ReadExcelData();
        int rows = config.getRowCount(0);
        Object [][] credentials = new Object[rows][2];

        for (int i=0;i<rows;i++) {
            credentials[i][0] = config.getData(0,i,0);
            credentials[i][1] = config.getData(0,i,1);
        }
        return credentials;
    }


}
