package com.course.selenium;

import com.course.selenium.fragments.LayerCard;
import com.course.selenium.pages.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.course.selenium.fragments.helpers.Helpers.nextWeek;
import static com.course.selenium.fragments.helpers.Helpers.today;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestProceedHotelToShoppingCard {

    private WebDriver driver;

    @Before
    public void openBrowser() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://hotel-testlab.coderslab.pl/en/");
    }

    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void shouldProceedHotelReservation() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickSingIn();

        AuthPage authPage = new AuthPage(driver);
        authPage.typeEmailIntoLogin("foo@bar.com");
        authPage.typePasswordIntoLogin("foobar");
        authPage.clickSingInButton();

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.clickHome();

        homePage = new HomePage(driver);
        homePage.typeLocation("Warsaw");
        homePage.selectHotelCategoryByName("The Hotel Prime");
        homePage.typeCheckInDate(today());
        homePage.typeCheckOutDate(nextWeek());
        homePage.clickSearchButton();

        RoomsPage roomsPage = new RoomsPage(driver);
        roomsPage.clickBookNowButton("Delux Rooms");

        LayerCard layerCard =  new LayerCard(driver);
        layerCard.clickProceedToCheckOut();

        QuickOrderPage quickOrderPage = new QuickOrderPage(driver);

        assertEquals(1, quickOrderPage.getOrderRows());
        assertTrue(quickOrderPage.getRomDescriptions().contains("Delux Rooms"));
    }
}
