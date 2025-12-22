package com.sauce.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestRetry implements IRetryAnalyzer {

    private int count = 0;

    @Override
    public boolean retry(ITestResult result) {
        int MAX_COUNT = 2;
        if(count < MAX_COUNT){
            count++;
            return true;
        }
        return false;

    }
}
