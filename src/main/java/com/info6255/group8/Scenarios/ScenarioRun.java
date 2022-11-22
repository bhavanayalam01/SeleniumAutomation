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

    }

    @AfterClass
    public static void endScenario2Test() {
        testReport.endTest(test2);
        testReport.flush();
    }

    @BeforeClass
    public static void startScenario3Test() {
        testReport = new com.relevantcodes.extentreports.ExtentReports("shots/Reports.html", true);
        test3 = testReport.startTest("Scenario3Check");
    }

    @Test(dataProvider = "dataInput")
    public void runScenario3(String userName, String password) throws InterruptedException, IOException {

        System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");

        driver = new ChromeDriver();
        // Load Northeastern Login Page
        shot(driver, "");
        driver.get("https://me.northeastern.edu");
        driver.manage().window().maximize();
        shot(driver, "");

        testReport = new com.relevantcodes.extentreports.ExtentReports("src/shots/Reports.html", true);
        test3 = testReport.startTest("Scenario1Check");

        // Validation to check Northeastern Website load was successfully
        if (driver.getTitle().equalsIgnoreCase("Home Realm Discovery")) {
            test3.log(LogStatus.PASS, "Navigation to me.northeastern.edu was successful");
        } else {
            test3.log(LogStatus.FAIL, "Navigation to me.northeastern.edu failed");
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Choose Active Directory
        driver.findElement(By.xpath("//*[text()='Active Directory']")).click();
        shot(driver, "");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Type in username and password and click submit
        driver.findElement(By.id("userNameInput")).sendKeys(userName);
//        System.out.println(Base64.getDecoder().decode(password).toString());
        driver.findElement(By.id("passwordInput")).sendKeys(password);
        shot(driver, "");
        driver.findElement(By.id("submitButton")).click();
        try {
            Thread.sleep(4000);
        } catch (Exception err) {
            err.printStackTrace();
        }

        shot(driver, "");
        // Send a Push notification to the user
        driver.findElement(By.xpath("//*[text()='Send Me a Push ']")).click();
        shot(driver, "");
        try {
            Thread.sleep(1000);
        } catch (Exception err) {
            err.printStackTrace();
        }

        // Login Confirmation
        shot(driver, "");
        driver.findElement(By.id("idSIButton9")).click();
        try {
            Thread.sleep(5000);
        } catch (Exception err) {
            err.printStackTrace();
        }

        // Close the dialog box
        shot(driver, "");
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
        shot(driver, "");
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
        shot(driver, "");
        driver.findElement(By.xpath("//*[text()='Academics, Classes & Registration']")).click();
        try {
            Thread.sleep(2000);
        } catch (Exception err) {
            err.printStackTrace();
        }


        // Click on the Course Registration
        shot(driver, "");
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
        shot(driver, "");
        driver.findElement(By.xpath("//*[text()='Browse Classes']")).click();
        try {
            Thread.sleep(2000);
        } catch (Exception err) {
            err.printStackTrace();
        }


        // Choose 2023 spring semester for the list and confirm
//        driver.switchTo().defaultContent();
        shot(driver, "");

        driver.findElement(By.id("s2id_txt_term")).click();
        driver.findElement(By.id("s2id_autogen1_search")).sendKeys("Spring 2023 Semester");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@id=\"202330\"]")).click();
        driver.findElement(By.id("term-go")).click();
        shot(driver, "");
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

//        driver.findElement(By.id("bnedLoginButton")).click();
//
        WebDriverWait wait = new WebDriverWait(driver, 500);
//
//        //switching to login popup and adding details
//        driver.switchTo().frame("loginHeaderIframe1");
//        WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"email\"]")));
//        username.sendKeys(userName);
//
//        WebElement Password = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"password\"]")));
//        Password.sendKeys(password);
//        try {
//            Thread.sleep(2000);
//        } catch (Exception err) {
//            err.printStackTrace();
//        }
//        driver.switchTo().defaultContent();
//
//        //clicking signin
//        driver.findElement(By.id("submitLoginHeaderForm")).click();
//        try {
//            Thread.sleep(2000);
//        } catch (Exception err) {
//            err.printStackTrace();
//        }

//        // Click on Sign-In/Create Account Button to navigate to LoginPage
//        driver.findElement(By.xpath("//*[text()='Sign In / Create Account']")).click();
//        shot(driver,"");
//        try {
//            Thread.sleep(2000);
//        } catch (Exception err) {
//            err.printStackTrace();
//        }

        // Search for an Item from the search bar
        driver.findElement(By.id("bned_site_search")).sendKeys("laptop", Keys.ENTER);
        shot(driver, "");
        try {
            Thread.sleep(2000);
        } catch (Exception err) {
            err.printStackTrace();
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

        //to perform Scroll on application using Selenium
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,250)", "");

        //click on add to cart
        try {
            Thread.sleep(1000);
        } catch (Exception err) {
            err.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.className("cart-items-info")).click();
        try {
            Thread.sleep(4000);
        } catch (Exception err) {
            err.printStackTrace();
        }

    }

    @AfterClass
    public static void endScenario4Test() {
        testReport.endTest(test4);
        testReport.flush();
    }

    @BeforeClass
    public static void startScenario5Test() {
        testReport = new com.relevantcodes.extentreports.ExtentReports("C:\\Users\\swapn\\Documents\\Fall 2022\\Software Quality Control and Management\\Assignments\\Selenium Assignment\\SeleniumAutomation\\Reports.html", true);
        test5 = testReport.startTest("Scenario1Check");
    }

    @Test(dataProvider = "dataInput")
    public void runScenario5(String userName, String password) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\swapn\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");

        driver = new ChromeDriver();

        // Load Northeastern Login Page
        driver.get("https://me.northeastern.edu");
        driver.manage().window().maximize();
        shot(driver,"");

        // Validation to check Northeastern Website load was successfully
        if (driver.getTitle().equalsIgnoreCase("Home Realm Discovery")) {
            test5.log(LogStatus.PASS,"Navigation to me.northeastern.edu was successful");
        } else {
            test5.log(LogStatus.FAIL,"Navigation to me.northeastern.edu failed");
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Choose Active Directory
        driver.findElement(By.xpath("//*[text()='Active Directory']")).click();
        shot(driver,"");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Type in username and password
        driver.findElement(By.id("userNameInput")).sendKeys(userName);
        driver.findElement(By.id("passwordInput")).sendKeys(password);
        shot(driver,"");
        driver.findElement(By.id("submitButton")).click();
        try {
            Thread.sleep(4000);
        } catch (Exception err) {
            System.out.println(err);
        }


        // Send Duo Authentication
        shot(driver,"");
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
        shot(driver,"");
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
        shot(driver,"");

        //        Validation to check resource page navigation was successful
        if (driver.getTitle().equalsIgnoreCase("Student Hub - Resources")) {
            test5.log(LogStatus.PASS,"Navigation to Resources Page - Success");
        } else {
            test5.log(LogStatus.FAIL,"Navigation to Resources Page - Failed");
        }

        // Click Classes Button
        driver.findElement(By.tagName("p")).click();
        shot(driver,"");
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
        shot(driver,"");
        driver.findElement(By.id("planningLink")).click();

        // Login Again using myNortheastern
        int index = userName.indexOf('@');
        String emailTrimmed = userName.substring(0,index);
        shot(driver,"");
        driver.findElement(By.id("username")).sendKeys(emailTrimmed);
        driver.findElement(By.id("password")).sendKeys(password);
        shot(driver,"");
        driver.findElement(By.name("_eventId_proceed")).click();


        // Send Duo Authentication
        driver.switchTo().frame("duo_iframe");
        driver.findElement(By.xpath("//*[@id=\"auth_methods\"]/fieldset/div[1]/button")).click();
        shot(driver,"");
        try {
            Thread.sleep(7000);
        } catch (Exception err) {
            System.out.println(err);
        }

        // Choose 2023 spring semester for the list and confirm
        driver.switchTo().defaultContent();
        shot(driver,"");

        driver.findElement(By.id("s2id_txt_term")).click();
        driver.findElement(By.id("s2id_autogen1_search")).sendKeys("Spring 2023 Semester");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@id=\"202330\"]")).click();
        driver.findElement(By.id("term-go")).click();
        shot(driver,"");
        try {
            Thread.sleep(5000);
        } catch (Exception err) {
            System.out.println(err);
        }

        // Create Plan
        driver.findElement(By.id("createPlan")).click();
        shot(driver,"");
        try {
            Thread.sleep(2000);
        } catch (Exception err) {
            System.out.println(err);
        }

        // Search Course
        driver.findElement(By.id("search-go")).click();
        shot(driver,"");
        try {
            Thread.sleep(2000);
        } catch (Exception err) {
            System.out.println(err);
        }

        // Add new plan
        driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[1]/td[6]/div/button[2]")).click();
        shot(driver,"");
        driver.findElement(By.id("saveButton")).click();
        shot(driver,"");
        driver.findElement(By.id("txt_planDesc")).sendKeys("NEW PLAN");
        shot(driver,"");
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
        shot(driver,"");

        driver.close();
        driver.close();
    }

    @AfterClass
    public static void endScenario5Test() {
        testReport.endTest(test5);
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
