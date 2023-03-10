package com.info6255.group8.Scenarios;

import com.info6255.group8.ReadExcelData;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

import static com.info6255.group8.ScreenShot.shot;

public class ScenarioRun {

    ChromeDriver driver;
    static ExtentReports testReport1;
    static ExtentTest test1;
    static ExtentTest test2;
    static ExtentTest test3;
    static ExtentTest test4;
    static ExtentTest test5;

    @BeforeClass
    public static void startScenario1Test() {
        testReport1 = new com.relevantcodes.extentreports.ExtentReports("C:\\Users\\swapn\\Documents\\Fall 2022\\Software Quality Control and Management\\Assignments\\Selenium Assignment\\SeleniumAutomation\\Reports.html", true);
        test1 = testReport1.startTest("Scenario1Check");
    }

    @Test(dataProvider = "dataInput")
    public void runScenario1(String userName, String password) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\swapn\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");

        driver = new ChromeDriver();
        // Load Northeastern Login Page
        shot(driver,"","scenario1");
        driver.get("https://me.northeastern.edu");
        driver.manage().window().maximize();
        shot(driver,"","scenario1");

        // Validation to check Northeastern Website load was successfully
        if (driver.getTitle().equalsIgnoreCase("Home Realm Discovery")) {
            test1.log(LogStatus.PASS,"Navigation to me.northeastern.edu was successful");
        } else {
            test1.log(LogStatus.FAIL,"Navigation to me.northeastern.edu failed");
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Choose Active Directory
        driver.findElement(By.xpath("//*[text()='Active Directory']")).click();
        shot(driver,"","scenario1");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Type in username and password and click submit
        driver.findElement(By.id("userNameInput")).sendKeys(userName);
        driver.findElement(By.id("passwordInput")).sendKeys(password);
        shot(driver,"","scenario1");
        driver.findElement(By.id("submitButton")).click();
        try {
            Thread.sleep(4000);
        } catch (Exception err) {
            err.printStackTrace();
        }

        shot(driver,"","scenario1");
        // Send a Push notification to the user
        driver.findElement(By.xpath("//*[text()='Send Me a Push ']")).click();
        shot(driver,"","scenario1");
        try {
            Thread.sleep(7000);
        } catch (Exception err) {
            err.printStackTrace();
        }

        // Login Confirmation
        shot(driver,"","scenario1");
        driver.findElement(By.id("idSIButton9")).click();
        try {
            Thread.sleep(12000);
        } catch (Exception err) {
            err.printStackTrace();
        }

        // Close the dialog box
        shot(driver,"","scenario1");
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
        shot(driver,"","scenario1");
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
        shot(driver,"","scenario1");
        driver.findElement(By.xpath("//*[text()='Academics, Classes & Registration']")).click();
        try {
            Thread.sleep(2000);
        } catch (Exception err) {
            err.printStackTrace();
        }

        // Add to Favorites

        // 1. Canvas LMS
        shot(driver,"","scenario1");
        driver.findElement(By.xpath("//*[@data-gtm-sh-resources-favorite='Canvas LMS']")).click();
        try {
            Thread.sleep(1500);
        } catch (Exception err) {
            err.printStackTrace();
        }

        // 2. Course Descriptions
        shot(driver,"","scenario1");
        driver.findElement(By.xpath("//*[@data-gtm-sh-resources-favorite='Course Descriptions']")).click();
        try {
            Thread.sleep(1500);
        } catch (Exception err) {
            err.printStackTrace();
        }

        // 3. Academic Calender
        shot(driver,"","scenario1");
        driver.findElement(By.xpath("//*[@data-gtm-sh-resources-favorite='Academic Calendar']")).click();
        try {
            Thread.sleep(1500);
        } catch (Exception err) {
            err.printStackTrace();
        }

        // 4. Advising Services
        shot(driver,"","scenario1");
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

        shot(driver,"","scenario1");
        // Logout and Close the window
        driver.findElement(By.xpath("//*[@id='O365_MainLink_Me']")).click();
        shot(driver,"","scenario1");
        driver.findElement(By.xpath("//*[text()='Sign out']")).click();
        shot(driver,"","scenario1");
        try {
            Thread.sleep(4000);
        } catch (Exception err) {
            err.printStackTrace();
        }
        driver.close();

    }

    @AfterClass
    public static void endScenario1Test() {
        testReport1.endTest(test1);
        testReport1.flush();
    }

    @BeforeClass
    public static void startScenario2Test() {
//        testReport2 = new com.relevantcodes.extentreports.ExtentReports("C:\\Users\\swapn\\Documents\\Fall 2022\\Software Quality Control and Management\\Assignments\\Selenium Assignment\\SeleniumAutomation\\Reports.html", false);
        test2 = testReport1.startTest("Scenario2Check");
    }

    @Test(dataProvider = "dataInput")
    public void runScenario2(String userName, String password) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\swapn\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");

        driver = new ChromeDriver();
        // Load Northeastern Login Page
        shot(driver,"","scenario2");
        driver.get("https://me.northeastern.edu");
        driver.manage().window().maximize();
        shot(driver,"","scenario2");

        // Validation to check Northeastern Website load was successfully
        if (driver.getTitle().equalsIgnoreCase("Home Realm Discovery")) {
            test2.log(LogStatus.PASS,"Navigation to me.northeastern.edu was successful");
        } else {
            test2.log(LogStatus.FAIL,"Navigation to me.northeastern.edu failed");
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Choose Active Directory
        driver.findElement(By.xpath("//*[text()='Active Directory']")).click();
        shot(driver,"","scenario2");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Type in username and password and click submit
        driver.findElement(By.id("userNameInput")).sendKeys(userName);
//        System.out.println(Base64.getDecoder().decode(password).toString());
        driver.findElement(By.id("passwordInput")).sendKeys(password);
        shot(driver,"","scenario2");
        driver.findElement(By.id("submitButton")).click();
        try {
            Thread.sleep(4000);
        } catch (Exception err) {
            err.printStackTrace();
        }

        shot(driver,"","scenario2");
        // Send a Push notification to the user
        driver.findElement(By.xpath("//*[text()='Send Me a Push ']")).click();
        shot(driver,"","scenario2");
        try {
            Thread.sleep(7000);
        } catch (Exception err) {
            err.printStackTrace();
        }

        // Login Confirmation
        shot(driver,"","scenario2");
        driver.findElement(By.id("idSIButton9")).click();
        try {
            Thread.sleep(12000);
        } catch (Exception err) {
            err.printStackTrace();
        }

        // Close the dialog box
        shot(driver,"","scenario2");
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
        shot(driver,"","scenario2");
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
        shot(driver,"","scenario2");
        driver.findElement(By.xpath("//*[text()='Academics, Classes & Registration']")).click();
        try {
            Thread.sleep(2000);
        } catch (Exception err) {
            err.printStackTrace();
        }

        // Add to Favorites

        // 1. Canvas LMS
        shot(driver,"","scenario2");
        driver.findElement(By.xpath("//*[@data-gtm-sh-resources-favorite='Canvas LMS']")).click();
        try {
            Thread.sleep(1500);
        } catch (Exception err) {
            err.printStackTrace();
        }

        // 2. Course Descriptions
        shot(driver,"","scenario2");
        driver.findElement(By.xpath("//*[@data-gtm-sh-resources-favorite='Course Descriptions']")).click();
        try {
            Thread.sleep(1500);
        } catch (Exception err) {
            err.printStackTrace();
        }

        // 3. Academic Calender
        shot(driver,"","scenario2");
        driver.findElement(By.xpath("//*[@data-gtm-sh-resources-favorite='Academic Calendar']")).click();
        try {
            Thread.sleep(1500);
        } catch (Exception err) {
            err.printStackTrace();
        }

        // 4. Advising Services
        shot(driver,"","scenario2");
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

        shot(driver,"","scenario2");
        // Logout and Close the window
        driver.findElement(By.xpath("//*[@id='O365_MainLink_Me']")).click();
        shot(driver,"","scenario2");
        driver.findElement(By.xpath("//*[text()='Sign out']")).click();
        shot(driver,"","scenario2");
        try {
            Thread.sleep(4000);
        } catch (Exception err) {
            err.printStackTrace();
        }
        driver.close();

    }

    @AfterClass
    public static void endScenario2Test() {
        testReport1.endTest(test2);
        testReport1.flush();
    }

    @BeforeClass
    public static void startScenario3Test() {
//        testReport3 = new com.relevantcodes.extentreports.ExtentReports("C:\\Users\\swapn\\Documents\\Fall 2022\\Software Quality Control and Management\\Assignments\\Selenium Assignment\\SeleniumAutomation\\Reports.html", false);
        test3 = testReport1.startTest("Scenario3Check");
    }

    @Test(dataProvider = "dataInput")
    public void runScenario3(String userName, String password) throws InterruptedException, IOException {

        System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");

        driver = new ChromeDriver();
        // Load Northeastern Login Page
        shot(driver, "","scenario3");
        driver.get("https://me.northeastern.edu");
        driver.manage().window().maximize();
        shot(driver, "","scenario3");

        // Validation to check Northeastern Website load was successfully
        if (driver.getTitle().equalsIgnoreCase("Home Realm Discovery")) {
            test3.log(LogStatus.PASS, "Navigation to me.northeastern.edu was successful");
        } else {
            test3.log(LogStatus.FAIL, "Navigation to me.northeastern.edu failed");
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Choose Active Directory
        driver.findElement(By.xpath("//*[text()='Active Directory']")).click();
        shot(driver, "","scenario3");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Type in username and password and click submit
        driver.findElement(By.id("userNameInput")).sendKeys(userName);
//        System.out.println(Base64.getDecoder().decode(password).toString());
        driver.findElement(By.id("passwordInput")).sendKeys(password);
        shot(driver, "","scenario3");
        driver.findElement(By.id("submitButton")).click();
        try {
            Thread.sleep(4000);
        } catch (Exception err) {
            err.printStackTrace();
        }

        shot(driver, "","scenario3");
        // Send a Push notification to the user
        driver.findElement(By.xpath("//*[text()='Send Me a Push ']")).click();
        shot(driver, "","scenario3");
        try {
            Thread.sleep(1000);
        } catch (Exception err) {
            err.printStackTrace();
        }

        // Login Confirmation
        shot(driver, "","scenario3");
        driver.findElement(By.id("idSIButton9")).click();
        try {
            Thread.sleep(5000);
        } catch (Exception err) {
            err.printStackTrace();
        }

        // Close the dialog box
        shot(driver, "","scenario3");
        driver.findElement(By.xpath("//*[text()='\uE711']")).click();
        try {
            Thread.sleep(4000);
        } catch (Exception err) {
            err.printStackTrace();
        }


//        Validation to check login was successful
        if (driver.getTitle().equalsIgnoreCase("Student Hub - Home")) {
            test3.log(LogStatus.PASS, "Login Successful");
        } else {
            test3.log(LogStatus.FAIL, "Login Failed");
        }

        // Click Resources Button
        driver.manage().window().maximize();
        shot(driver, "","scenario3");
        driver.findElement(By.partialLinkText("Resources")).click();
        try {
            Thread.sleep(3000);
        } catch (Exception err) {
            err.printStackTrace();
        }

        //  Validation to check resource page navigation was successful
        if (driver.getTitle().equalsIgnoreCase("Student Hub - Resources")) {
            test3.log(LogStatus.PASS, "Navigation to Resources Page - Success");
        } else {
            test3.log(LogStatus.FAIL, "Navigation to Resources Page - Failed");
        }

        // Click on the Academics, Classes & Registration Button
        shot(driver, "","scenario3");
        driver.findElement(By.xpath("//*[text()='Academics, Classes & Registration']")).click();
        try {
            Thread.sleep(2000);
        } catch (Exception err) {
            err.printStackTrace();
        }


        // Click on the Course Registration
        shot(driver, "","scenario3");
        driver.findElement(By.xpath("//*[@data-gtm-sh-resources-link='Course Registration']")).click();
        try {
            Thread.sleep(2000);
        } catch (Exception err) {
            err.printStackTrace();
        }

        // switch to new window to open Banner
        String handle = driver.getWindowHandle();
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

        // Click on the Browse Classes
        shot(driver, "","scenario3");
        driver.findElement(By.xpath("//*[text()='Browse Classes']")).click();
        try {
            Thread.sleep(2000);
        } catch (Exception err) {
            err.printStackTrace();
        }


        // Choose 2023 spring semester for the list and confirm
//        driver.switchTo().defaultContent();
        shot(driver, "","scenario3");

        driver.findElement(By.id("s2id_txt_term")).click();
        driver.findElement(By.id("s2id_autogen1_search")).sendKeys("Spring 2023 Semester");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@id=\"202330\"]")).click();
        driver.findElement(By.id("term-go")).click();
        shot(driver, "","scenario3");
        try {
            Thread.sleep(5000);
        } catch (Exception err) {
            System.out.println(err);
        }


        driver.findElement(By.id("s2id_txt_subject")).click();
        try {
            Thread.sleep(2000);
        } catch (Exception err) {
            err.printStackTrace();
        }

        driver.findElement(By.id("s2id_autogen1")).sendKeys("Information Systems Program");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@id=\"select2-drop\"]/ul/li/div/div[@id=\"INFO\"]")).click();
        try {
            Thread.sleep(2000);
        } catch (Exception err) {
            err.printStackTrace();
        }


        driver.findElement(By.id("search-go")).click();
        try {
            Thread.sleep(2000);
        } catch (Exception err) {
            err.printStackTrace();
        }

        driver.close();
    }

    @AfterClass
    public static void endScenario3Test() {
        testReport1.endTest(test3);
        testReport1.flush();
    }

    @BeforeClass
    public static void startScenario4Test() {
//        testReport4 = new com.relevantcodes.extentreports.ExtentReports("C:\\Users\\swapn\\Documents\\Fall 2022\\Software Quality Control and Management\\Assignments\\Selenium Assignment\\SeleniumAutomation\\Reports.html", false);
        test4 = testReport1.startTest("Scenario4Check");
    }

    @Test(dataProvider = "dataInput")
    public void runScenario4(String userName, String password) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\swapn\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");

        driver = new ChromeDriver();
        // Load Northeastern Bookstore Page
        shot(driver,"","scenario4");
        driver.get("https://northeastern.bncollege.com/");
        driver.manage().window().maximize();
        shot(driver,"","scenario4");

        // Validation to check Northeastern BookStore Website load was successfully
        if (driver.getTitle().equalsIgnoreCase("Apparel, Gifts & Textbooks | Northeastern University Official Bookstore")) {
            test4.log(LogStatus.PASS,"Navigation to Northeastern Bookstore Website was successful");
        } else {
            test4.log(LogStatus.FAIL,"Navigation to Northeastern Bookstore Website failed");
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

//        driver.findElement(By.id("bnedLoginButton")).click();
//
        WebDriverWait wait = new WebDriverWait(driver, 500);

        // Search for an Item from the search bar
        driver.findElement(By.id("bned_site_search")).sendKeys("laptop", Keys.ENTER);
        shot(driver, "","scenario4");
        try {
            Thread.sleep(2000);
        } catch (Exception err) {
            err.printStackTrace();
        }

        // Validation to check search results were fetched successfully
        if (driver.getTitle().contains("Search laptop")) {
            test4.log(LogStatus.PASS,"Search results fetched successfully");
        } else {
            test4.log(LogStatus.FAIL,"Search results failed");
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        js.executeScript("window.scrollBy(0,250)", "");

        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html/body/main/div[3]/div[5]/div[1]/div[2]/div/div/div/ul/div[1]/div/a"))));
        try {
            Thread.sleep(2000);
        } catch (Exception err) {
            err.printStackTrace();
        }
        e.findElement(By.xpath("/html/body/main/div[3]/div[5]/div[1]/div[2]/div/div/div/ul/div[1]/div/a")).click();

        // Validation to check search results were fetched successfully
        if (driver.getTitle().contains("HP 14")) {
            test4.log(LogStatus.PASS,"Display Item detail load was successfully");
        } else {
            test4.log(LogStatus.FAIL,"Display Item detail load failed");
        }

        //to perform Scroll on application using Selenium
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,250)", "");

        //click on add to cart
        try {
            Thread.sleep(1000);
        } catch (Exception err) {
            err.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        shot(driver, "","scenario4");
        WebElement addToCart =wait.until(ExpectedConditions
                .elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"addToCartButton\"]"))));
        addToCart.findElement(By.xpath("//*[@id=\"addToCartButton\"]")).click();


        //to perform Scroll on application using Selenium
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-250)", "");

        //opening cart
        try {
            Thread.sleep(2000);
        } catch (Exception err) {
            err.printStackTrace();
        }
        shot(driver, "","scenario4");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.className("cart-items-info")).click();
        try {
            Thread.sleep(4000);
        } catch (Exception err) {
            err.printStackTrace();
        }
        // Validation to check cart was loaded
        if (driver.getTitle().contains("Your Shopping Cart")) {
            test4.log(LogStatus.PASS,"Display Items in Cart load was successful");
        } else {
            test4.log(LogStatus.FAIL,"Display Items in Cart load failed");
        }

        driver.close();

//        System.out.println(driver.findElement(By.xpath("//*[text()='1 Item']")));

//        // Validation to check item was added to cart
//        if (driver.findElement(By.xpath("//*[text()='Your cart is empty']") == true) ) {
//            test4.log(LogStatus.PASS,"Display Items in Cart load was successful");
//        } else {
//            test4.log(LogStatus.FAIL,"Display Items in Cart load failed");
//        }

    }

    @AfterClass
    public static void endScenario4Test() {
        testReport1.endTest(test4);
        testReport1.flush();
    }

    @BeforeClass
    public static void startScenario5Test() {
//        testReport5 = new com.relevantcodes.extentreports.ExtentReports("C:\\Users\\swapn\\Documents\\Fall 2022\\Software Quality Control and Management\\Assignments\\Selenium Assignment\\SeleniumAutomation\\Reports.html", false);
        test5 = testReport1.startTest("Scenario5Check");
    }

    @Test(dataProvider = "dataInput")
    public void runScenario5(String userName, String password) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\swapn\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");

        driver = new ChromeDriver();

        // Load Northeastern Login Page
        driver.get("https://me.northeastern.edu");
        driver.manage().window().maximize();
        shot(driver,"","scenario5");

        // Validation to check Northeastern Website load was successfully
        if (driver.getTitle().equalsIgnoreCase("Home Realm Discovery")) {
            test5.log(LogStatus.PASS,"Navigation to me.northeastern.edu was successful");
        } else {
            test5.log(LogStatus.FAIL,"Navigation to me.northeastern.edu failed");
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Choose Active Directory
        driver.findElement(By.xpath("//*[text()='Active Directory']")).click();
        shot(driver,"","scenario5");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Type in username and password
        driver.findElement(By.id("userNameInput")).sendKeys(userName);
        driver.findElement(By.id("passwordInput")).sendKeys(password);
        shot(driver,"","scenario5");
        driver.findElement(By.id("submitButton")).click();
        try {
            Thread.sleep(4000);
        } catch (Exception err) {
            System.out.println(err);
        }


        // Send Duo Authentication
        shot(driver,"","scenario5");
        driver.findElement(By.cssSelector("button.positive.auth-button")).click();
        shot(driver,"","scenario5");
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

//        shot(driver,"D:/Github/SeleniumAutomation/Scenario5.6.png");
//        driver.findElement(By.id("id__94")).click();
//        driver.manage().window().maximize();
//        try {
//            Thread.sleep(2000);
//        } catch (Exception err) {
//            System.out.println(err);
//        }

        //        Validation to check login was successful
        if (driver.getTitle().equalsIgnoreCase("Student Hub - Home")) {
            test5.log(LogStatus.PASS,"Login Successful");
        } else {
            test5.log(LogStatus.FAIL,"Login Failed");
        }

        // Close the dialog box
        shot(driver,"","scenario5");
        driver.findElement(By.xpath("//*[text()='\uE711']")).click();
        try {
            Thread.sleep(4000);
        } catch (Exception err) {
            err.printStackTrace();
        }

        // Click Resources Button
        driver.findElement(By.partialLinkText("Resources")).click();
        try {
            Thread.sleep(3000);
        } catch (Exception err) {
            System.out.println(err);
        }
        shot(driver,"","scenario5");

        //        Validation to check resource page navigation was successful
        if (driver.getTitle().equalsIgnoreCase("Student Hub - Resources")) {
            test5.log(LogStatus.PASS,"Navigation to Resources Page - Success");
        } else {
            test5.log(LogStatus.FAIL,"Navigation to Resources Page - Failed");
        }

        // Click Classes Button
        driver.findElement(By.tagName("p")).click();
        shot(driver,"","scenario5");
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
        shot(driver,"","scenario5");
        driver.findElement(By.id("planningLink")).click();

        // Login Again using myNortheastern
        int index = userName.indexOf('@');
        String emailTrimmed = userName.substring(0,index);
        shot(driver,"","scenario5");
        driver.findElement(By.id("username")).sendKeys(emailTrimmed);
        driver.findElement(By.id("password")).sendKeys(password);
        shot(driver,"","scenario5");
        driver.findElement(By.name("_eventId_proceed")).click();


        // Send Duo Authentication
        driver.switchTo().frame("duo_iframe");
        driver.findElement(By.xpath("//*[@id=\"auth_methods\"]/fieldset/div[1]/button")).click();
        shot(driver,"","scenario5");
        try {
            Thread.sleep(2000);
        } catch (Exception err) {
            System.out.println(err);
        }

        // Choose 2023 spring semester for the list and confirm
        driver.switchTo().defaultContent();
        shot(driver,"","scenario5");

        driver.findElement(By.id("s2id_txt_term")).click();
        driver.findElement(By.id("s2id_autogen1_search")).sendKeys("Spring 2023 Semester");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@id=\"202330\"]")).click();
        driver.findElement(By.id("term-go")).click();
        shot(driver,"","scenario5");
        try {
            Thread.sleep(5000);
        } catch (Exception err) {
            System.out.println(err);
        }

        //        Validation to check banner page navigation was successful
        if (driver.getTitle().equalsIgnoreCase("Banner")) {
            test5.log(LogStatus.PASS,"Navigation to Banner Page - Success");
        } else {
            System.out.println(driver.getTitle());
            test5.log(LogStatus.FAIL,"Navigation to Banner Page - Failed");
        }

        // Create Plan
        driver.findElement(By.id("createPlan")).click();
        shot(driver,"","scenario5");
        try {
            Thread.sleep(2000);
        } catch (Exception err) {
            System.out.println(err);
        }

        // Search Course
        driver.findElement(By.id("search-go")).click();
        shot(driver,"","scenario5");
        try {
            Thread.sleep(2000);
        } catch (Exception err) {
            System.out.println(err);
        }

        // Add new plan
        driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[1]/td[6]/div/button[2]")).click();
        shot(driver,"","scenario5");
        driver.findElement(By.id("saveButton")).click();
        shot(driver,"","scenario5");
        driver.findElement(By.id("txt_planDesc")).sendKeys("NEW PLAN");
        shot(driver,"","scenario5");
        try {
            Thread.sleep(1000);
        } catch (Exception err) {
            System.out.println(err);
        }
        driver.findElement(By.xpath("//*[text()='Save']")).click();
        try {
            Thread.sleep(1000);
        } catch (Exception err) {
            System.out.println(err);
        }
        shot(driver,"","scenario5");

        driver.close();
    }

    @AfterClass
    public static void endScenario5Test() {
        testReport1.endTest(test5);
        testReport1.flush();
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
