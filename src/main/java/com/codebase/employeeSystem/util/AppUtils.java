package com.codebase.employeeSystem.util;

public class AppUtils {

    private static AppUtils appUtils = null;
    private AppUtils(){

    }

    public String getLogString(Object... args){
        StringBuilder sb = new StringBuilder();
        if(args != null){
            for(Object arg : args){
                sb.append(arg);
            }
        }
        return sb.toString();
    }

    public static AppUtils getAppUtils(){
        if(appUtils == null){
            appUtils = new AppUtils();
        }
        return appUtils;
    }
}
