package com.epam.mentorship.utils;

import com.epam.mentorship.core.driver.Driver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.*;

import static com.epam.mentorship.utils.Logger.error;


public class TestListener implements ITestListener, IInvokedMethodListener, IExecutionListener, ISuiteListener{
    public void onTestStart(ITestResult result) {
        Driver.setDriver();
        Logger.info("Test: " + result.getClass() + " " + result.getName() + " is started");
    }

    public void onTestSuccess(ITestResult result) {

        takeScreenshot();
        WebDriver driver = Driver.getDriver();
        if (driver != null) {
            driver.quit();
        }
        Logger.info("Test: " + result.getClass() + " " + result.getName() + " [*PASSED*]");
    }

    public void onTestFailure(ITestResult result) {
        WebDriver driver = Driver.getDriver();
        if (driver != null) {
            driver.quit();
        }
        error("Test: " + result.getClass() + " " + result.getName() + "[*FAILED*]");
    }

    public void onTestSkipped(ITestResult result) {
        WebDriver driver = Driver.getDriver();
        if (driver != null) {
            driver.quit();
        }
        error("Test: " + result.getClass() + " " + result.getName() + "[*SKIPPED*]");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {


    }

    public void onFinish(ITestContext context) {
        Driver.terminate();
        Logger.info("Test: " + context.getClass() + " " + context.getName() + "is finished");

    }

    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
//        if (iInvokedMethod.isTestMethod()) {
//            WebDriver driver = Driver.getDriver();
//            if (driver != null) {
//                driver.quit();
//            }
//        }
    }


    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        byte[] sc = new byte[]{};
        try {
            sc = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        }
        catch (WebDriverException e){
            error("[FAILURE] Failed to capture screenshot. " + e.getMessage());
        }
        return sc;
    }


    @Override
    public void onExecutionStart() {

    }

    @Override
    public void onExecutionFinish() {

    }

    @Override
    public void onStart(ISuite suite) {

    }

    @Override
    public void onFinish(ISuite suite) {

    }
}
