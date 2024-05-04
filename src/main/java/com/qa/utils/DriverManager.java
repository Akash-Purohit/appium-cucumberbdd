package com.qa.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    TestUtils utils = new TestUtils();

    public AppiumDriver<?> getDriver(){
        return driver.get();
    }

    public void setDriver(AppiumDriver<?> driver2){
        driver.set(driver2);
    }

    public void initializeDriver() throws Exception {
        AppiumDriver<?> driver = null;
    	GlobalParams params = new GlobalParams();
        Properties props = new PropertyManager().getProps();
        
        if(driver == null){
            try{
                utils.log().info("initializing Appium driver");
                switch(params.getPlatformName()){
                    case "Android":
                        driver = new AndroidDriver(new URL(props.getProperty("appiumURL")), new CapabilitiesManager().getCaps());
                        break;
                    case "iOS":
                        //driver = new IOSDriver(new URL(props.getProperty("appiumURL")), new CapabilitiesManager().getCaps());
                        break;
                }
                if(driver == null){
                    throw new Exception("driver is null. ABORT!!!");
                }
                utils.log().info("Driver is initialized");
                this.driver.set(driver);
            } catch (IOException e) {
                e.printStackTrace();
                utils.log().fatal("Driver initialization failure. ABORT !!!!" + e.toString());
                throw e;
            }
        }

    }

}
