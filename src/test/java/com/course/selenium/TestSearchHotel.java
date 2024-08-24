package com.course.selenium;

import com.course.selenium.pages.AuthPage;
import com.course.selenium.pages.HomePage;
import com.course.selenium.pages.MyAccountPage;
import com.course.selenium.pages.RoomsPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.course.selenium.fragments.helpers.Helpers.nextWeek;
import static com.course.selenium.fragments.helpers.Helpers.today;

public class TestSearchHotel {

    private static WebDriver driver;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://hotel-testlab.coderslab.pl/en/");
    }

    @Test
    public void shouldFindHotelsInWarsawToday() {
        HomePage homePage =  new HomePage(driver);
        homePage.clickSingIn();

        AuthPage authPage = new AuthPage(driver);
        authPage.typeEmailIntoLogin("foo@bar.com");
        authPage.typePasswordIntoLogin("foobar");
        authPage.clickSingInButton();

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.clickHome();

        homePage =  new HomePage(driver);
        homePage.typeLocation("Warsaw");
        homePage.selectHotelCategoryByName("The Hotel Prime");
        homePage.typeCheckInDate(today());
        homePage.typeCheckOutDate(nextWeek());
        homePage.clickSearchButton();

        RoomsPage rooms = new RoomsPage(driver);
        Assert.assertTrue(rooms.getNumRooms() > 0);
    }

    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
