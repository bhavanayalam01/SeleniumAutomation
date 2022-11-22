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
    public static String shot(WebDriver driver,String savedPtah,String scenario){
        File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH-mm-ss");
            LocalDateTime now = LocalDateTime.now();
            savedPtah = "src/shots/"+scenario+"/"+dtf.format(now)+".png";
            FileUtils.copyFile(srcfile,new File(savedPtah));
            return savedPtah;
        }catch (IOException e){
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
