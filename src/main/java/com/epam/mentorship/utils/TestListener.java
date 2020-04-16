package com.epam.mentorship.utils;

import com.epam.mentorship.core.driver.Driver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.*;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListener implements ITestListener, IInvokedMethodListener {

    public void onTestStart(ITestResult result) {
        Logger.info("Test: " + result.getClass() + " " + result.getName() + " is started");
    }

    public void onTestSuccess(ITestResult result) {
        Logger.info("Test: " + result.getClass() + " " + result.getName() + " PASSED");
    }

    public void onTestFailure(ITestResult result) {
//        takeScreenshot();
        Logger.error("Test: " + result.getClass() + " " + result.getName() + " FAILED");
    }

    public void onTestSkipped(ITestResult result) {
        Logger.error("Test: " + result.getClass() + " " + result.getName() + " SKIPPED");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {
        Driver.quit();
        Logger.info("Test: " + context.getClass() + " " + context.getName() + "is finished");

    }

    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        if (iInvokedMethod.isTestMethod()) {
Driver.setDriver();
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        if (iInvokedMethod.isTestMethod()) {
//Driver.getDriver().quit();
            }
        }


//    @Attachment(value = "Page screenshot", type = "image/png")
//    public byte[] takeScreenshot() {
//        return ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
//    }


}
