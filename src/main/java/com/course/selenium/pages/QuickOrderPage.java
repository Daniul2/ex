package com.course.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

import static com.course.selenium.fragments.helpers.Helpers.waitForPageLoaded;

public class QuickOrderPage {

    private final WebDriver driver;
    @FindBy( id = "cart_summary")
    WebElement cardSummary;

    @FindBy( css = ".table_body")
    List<WebElement> tableBody;

    private final By tableBodyDescriptions = By.cssSelector(".cart_description");


    // Metoda do ponownej inicjalizacji elementów strony - tabela dynamiczna.
    public void refreshPageElements() {
        PageFactory.initElements(driver, this);
    }

    public QuickOrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitForPageLoaded(driver, By.cssSelector("#center_column"),"quick-order");

    }

    public int getOrderRows(){
        refreshPageElements();
        return tableBody.size();
    }

    public List<String> getRomDescriptions(){
        refreshPageElements();

        return tableBody.stream()
                .map(i -> i.findElement(tableBodyDescriptions))
                .map(WebElement::getText)
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
