package com.info6255.group8;

import com.info6255.group8.Scenarios.Scenario1;
//import com.info6255.group8.Scenarios.Scenario1AddToFav;
import com.info6255.group8.Scenarios.Scenario2Delete;
import org.openqa.selenium.chrome.ChromeDriver;
import static com.info6255.group8.Scenarios.Scenario2Delete.runScenario2;
import static com.info6255.group8.Scenarios.Scenario5CreatePlan.runScenario5;
//import static com.info6255.group8.Scenarios.Scenario1AddToFav.*;

public class Application {
    public static void main(String[] args) throws InterruptedException {

        Scenario1 scenario1 = new Scenario1();
        scenario1.performLogin("z","");
    }

}
