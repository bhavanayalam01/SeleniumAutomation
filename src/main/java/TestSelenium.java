import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSelenium {
    public static void main(String[] args) {
        //        Open New Window for me.northeastern.edu
        ChromeDriver newWindow = new ChromeDriver();
        newWindow.get("https://sts.northeastern.edu/adfs/ls/?client-request-id=88114b19-dcc0-4e3e-a156-fd561d18aba1&username=&wa=wsignin1.0&wtrealm=urn%3afederation%3aMicrosoftOnline&wctx=estsredirect%3d2%26estsrequest%3drQQIARAA42Kw0s0oKSkottLXz8svKslITSwuSS3K0yvOSCxKLcjPzCvRS87P1csvSs9MAbGKhLgEJL0FOw7csfNbGPY3TFZi9cJZjAIoelNTSlcx6hFhrH5xZklqsX5GaVLxBUbGF4yMt5gE_YvSPVPCi91SU1KLEksy8_MusAi8YuExYLbi4OASYJBgUGD4wcK4iBXojmkvO92ff-Tx6fy2gVu1wI7hFKu-l3mWgW9-oUWFgalzSGaOn6d3WZZjmlF5UmimsaWnSaGBUZlhkXNVZmKIo62FleEENqEJbEyn2Bg-sDF2sDPMYmfYxUmiww_wMvzg-3Z_w7JDbza-9QAA0#");

//        Find the Active Directory Button and Click on it to go to the Login Page
        try {
            Thread.sleep(2000);
            WebElement activeDirectoryButton = newWindow.findElement(By.xpath("//*[text()='Active Directory']"));
            activeDirectoryButton.click();
        } catch (Exception err) {
            System.out.println(err);
        }
    }
}
