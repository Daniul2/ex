package com.course.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static com.course.selenium.fragments.helpers.Helpers.selectRadioButtonByText;

public class FormTest {
    private static WebDriver driver;

    By locatorRadioLabel = By.cssSelector(".radio-inline");

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
    }

    @Test
    public void shouldFillGender() throws InterruptedException {

        selectRadioButtonByText(driver, locatorRadioLabel,"Female");



    }




    @After
    public void tearDown() {
        driver.quit();
    }
}
