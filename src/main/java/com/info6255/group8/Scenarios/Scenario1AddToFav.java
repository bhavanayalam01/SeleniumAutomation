package com.info6255.group8.Scenarios;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.info6255.group8.ScreenShot.shot;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Scenario1AddToFav {

    public static void runScenario1(WebDriver driver) {

        // Load data from excel file
//        FileInputStream userData = new FileInputStream("/Users/swapn/Documents/Fall 2022/Software Quality Control and Management/Assignments/Selenium Assignment/SeleniumAutomation/UserData.xlsx");
//        Properties properties = new Properties();
//        properties.load(userData);


        // Load Northeastern Login Page
        shot(driver,"");
        driver.get("https://me.northeastern.edu");
        driver.manage().window().maximize();
        shot(driver,"");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Choose Active Directory
        driver.findElement(By.xpath("//*[text()='Active Directory']")).click();
        shot(driver,"");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

//        // Get Data from Excel Sheet
//        @DataProvider(name="testdata")
//        public Object[][] testDataExample() {
//            ReadExcelFile configuration = new ReadExcelFile("Path_of_Your_Excel_File");
//            int rows = configuration.getRowCount(0);
//            Object[][]signin_credentials = new Object[rows][2];
//
//            for(int i=0;i<rows;i++)
//            {
//                signin_credentials[i][0] = config.getData(0, i, 0);
//                signin_credentials[i][1] = config.getData(0, i, 1);
//            }
//            return signin_credentials;
//        }

//        @Test(dataProvider = "testdata")
//        public void performLogin(String userName, String password) {
            // Type in username and password and click submit
            driver.findElement(By.id("userNameInput")).sendKeys("UserName");
            driver.findElement(By.id("passwordInput")).sendKeys("Password");
            shot(driver,"");
            driver.findElement(By.id("submitButton")).click();
            try {
                Thread.sleep(4000);
            } catch (Exception err) {
                err.printStackTrace();
            }
//        }

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
//        driver.findElement(By.id("id__94")).click();
//        driver.manage().window().maximize();
//        try {
//            Thread.sleep(2000);
//        } catch (Exception err) {
//            System.out.println(err);
//        }

        // Close the dialog box
        shot(driver,"");
        driver.findElement(By.xpath("//*[text()='\uE711']")).click();
        try {
            Thread.sleep(8000);
        } catch (Exception err) {
            err.printStackTrace();
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

        // Click on the Academics, Classes & Registration Button
        shot(driver,"");
        driver.findElement(By.xpath("//*[text()='Academics, Classes & Registration']")).click();
        try {
            Thread.sleep(3000);
        } catch (Exception err) {
            err.printStackTrace();
        }

        // Add to Favorites

        // 1. Canvas LMS
        shot(driver,"");
        driver.findElement(By.xpath("//*[@data-gtm-sh-resources-favorite='Canvas LMS']")).click();
        try {
            Thread.sleep(4000);
        } catch (Exception err) {
            err.printStackTrace();
        }

        // 2. Course Descriptions
        shot(driver,"");
        driver.findElement(By.xpath("//*[@data-gtm-sh-resources-favorite='Course Descriptions']")).click();
        try {
            Thread.sleep(4000);
        } catch (Exception err) {
            err.printStackTrace();
        }

        // 3. Academic Calender
        shot(driver,"");
        driver.findElement(By.xpath("//*[@data-gtm-sh-resources-favorite='Academic Calendar']")).click();
        try {
            Thread.sleep(4000);
        } catch (Exception err) {
            err.printStackTrace();
        }

        // 4. Advising Services
        shot(driver,"");
        driver.findElement(By.xpath("//*[@data-gtm-sh-resources-favorite='Advising Services']")).click();
        try {
            Thread.sleep(4000);
        } catch (Exception err) {
            err.printStackTrace();
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
}
