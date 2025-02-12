package ru.shumova.praktikum.page;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.shumova.praktikum.AbstractTest;

import static org.junit.Assert.assertTrue;

public class ConstructorTest extends AbstractTest {
    private static HomePage homePage;
    private static ConstructorPage constructorPage;

    @Before
    public void setUp() {
        initDriver();
        homePage = new HomePage(driver);
        constructorPage = new ConstructorPage(driver);
    }

    @Test
    @DisplayName("Переход к разделу «Булки»")
    public void bunsButtonTest() {
        homePage.openHomePage();
        constructorPage.saucesButtonClick();
        constructorPage.bunsButtonClick();
        assertTrue(constructorPage.isBunsButtonActive());
    }

    @Test
    @DisplayName("Переход к разделу «Соусы»")
    public void saucesButtonTest() {
        homePage.openHomePage();
        constructorPage.saucesButtonClick();
        assertTrue(constructorPage.isSaucesButtonActive());
    }

    @Test
    @DisplayName("Переход к разделу «Начинки»")
    public void fillingsButtonTest() {
        homePage.openHomePage();
        constructorPage.fillingsButtonClick();
        assertTrue(constructorPage.isFillingsButtonActive());
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
