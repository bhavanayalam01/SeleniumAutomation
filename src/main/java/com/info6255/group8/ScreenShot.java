package com.info6255.group8;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShot {
    public static void shot(WebDriver driver,String savedPtah){
        File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(srcfile,new File(savedPtah));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
