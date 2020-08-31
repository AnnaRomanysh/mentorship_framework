package com.epam.mentorship.utils;

import com.epam.mentorship.core.driver.Driver;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.model.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;
import org.testng.xml.XmlSuite;

import java.io.ByteArrayInputStream;

import static com.epam.mentorship.utils.Logger.error;
import static com.epam.mentorship.utils.Logger.step;


public class TestListener implements ITestListener, StepLifecycleListener, ISuiteListener{

    public void onTestStart(ITestResult result) {
        Driver.setDriver();
        Logger.info("Test: " + result.getClass() + " " + result.getName() + " is started");
    }

    public void onTestSuccess(ITestResult result) {
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

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
    }


    @Override
    public void afterStepUpdate(io.qameta.allure.model.StepResult result) {
        if (result.getStatus().equals(Status.FAILED) || result.getStatus().equals(Status.BROKEN)) {
            byte[] sc = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment(result.getName()+" screenshot", new ByteArrayInputStream(sc));
        }
    }

    @Override
    public void onStart(ISuite iSuite) {
        if(Environment.isParallel()){
            step("Running test suite in parallel");
            iSuite.getXmlSuite().setParallel(XmlSuite.ParallelMode.METHODS);
            iSuite.getXmlSuite().setThreadCount(2);
        }
    }

    @Override
    public void onFinish(ISuite iSuite) {

    }

}
