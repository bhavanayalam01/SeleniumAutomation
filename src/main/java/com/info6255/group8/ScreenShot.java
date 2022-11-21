package com.info6255.group8;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ScreenShot {
    public static void shot(WebDriver driver,String savedPtah){
        File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
//            System.out.println(dtf.format(now));
            FileUtils.copyFile(srcfile,new File("C:\\Users\\swapn\\Documents\\Fall 2022\\Software Quality Control and Management\\Assignments\\Selenium Assignment\\SeleniumAutomation\\"+now.toString()));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
