package com.qa.utils;

import java.io.IOException;
import java.util.Properties;

public class GlobalParams {
    private static ThreadLocal<String> platformName = new ThreadLocal<String>();
    private static ThreadLocal<String> udid = new ThreadLocal<String>();
    private static ThreadLocal<String> deviceName = new ThreadLocal<String>();
    private static ThreadLocal<String> systemPort = new ThreadLocal<String>();
    private static ThreadLocal<String> chromeDriverPort = new ThreadLocal<String>();
    private static ThreadLocal<String> wdaLocalPort = new ThreadLocal<String>();
    private static ThreadLocal<String> webkitDebugProxyPort = new ThreadLocal<String>();

    public void setPlatformName(String platformName1){
        platformName.set(platformName1);
    }

    public String getPlatformName(){
        return platformName.get();
    }

    public String getUDID() {
        return udid.get();
    }

    public void setUDID(String udid2) {
        udid.set(udid2);
    }

    public String getDeviceName() {
        return deviceName.get();
    }

    public void setDeviceName(String deviceName2) {
        deviceName.set(deviceName2);
    }

    public String getSystemPort() {
        return systemPort.get();
    }

    public void setSystemPort(String systemPort2) {
        systemPort.set(systemPort2);
    }

    public String getChromeDriverPort() {
        return chromeDriverPort.get();
    }

    public void setChromeDriverPort(String chromeDriverPort2) {
        chromeDriverPort.set(chromeDriverPort2);
    }

    public String getWdaLocalPort() {
        return wdaLocalPort.get();
    }

    public void setWdaLocalPort(String wdaLocalPort2) {
        wdaLocalPort.set(wdaLocalPort2);
    }

    public String getWebkitDebugProxyPort() {
        return webkitDebugProxyPort.get();
    }

    public void setWebkitDebugProxyPort(String webkitDebugProxyPort2) {
        webkitDebugProxyPort.set(webkitDebugProxyPort2);
    }

    public void initializeGlobalParams() throws IOException{
    	Properties props = new PropertyManager().getProps();
    	
        GlobalParams params = new GlobalParams();
        params.setPlatformName(props.getProperty("platformName"));
        params.setUDID(props.getProperty("udid"));
        params.setDeviceName(props.getProperty("deviceName"));

        switch(params.getPlatformName()){
            case "Android":
                
                break;
            case "iOS":
                params.setWdaLocalPort(System.getProperty("wdaLocalPort", "10001"));
                params.setWebkitDebugProxyPort(System.getProperty("webkitDebugProxyPort", "11001"));
                break;
            case "web":
                break;    
            default:
                throw new IllegalStateException("Invalid Platform Name!");
        }
    }
}
