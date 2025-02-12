package ru.shumova.praktikum.page;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.shumova.praktikum.AbstractTest;

import static org.junit.Assert.assertEquals;
import static ru.shumova.praktikum.config.TestData.USER;

public class PersonalAccountTest extends AbstractTest {
    private static HomePage homePage;
    private static PersonalAccountPage personalAccountPage;

    @Before
    public void setUp() {
        initDriver();
        homePage = new HomePage(driver);
        personalAccountPage = new PersonalAccountPage(driver);
        createUser();
    }

    @Test
    @DisplayName("Переход по клику на «Личный кабинет»")
    public void clickOnPersonalAccountTest() {
        homePage.openHomePage();
        homePage.enterPersonalAccountButton();
        personalAccountPage.loginUser(USER);
        homePage.enterPersonalAccountButton();
        assertEquals(URL_ACCOUNT, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Выход по кнопке «Выйти» в личном кабинете")
    public void clickButtonExitTest() {
        homePage.openHomePage();
        homePage.enterPersonalAccountButton();
        personalAccountPage.loginUser(USER);
        homePage.enterPersonalAccountButton();
        personalAccountPage.enterExitClickButton();
        assertEquals(URL_LOGIN, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Переход из личного кабинета по клику на «Конструктор»")
    public void constructorButtonClickButtonTest() {
        homePage.openHomePage();
        homePage.enterPersonalAccountButton();
        personalAccountPage.loginUser(USER);
        homePage.enterPersonalAccountButton();
        personalAccountPage.constructorClickButton();
        assertEquals(URL_MAIN, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Переход из личного кабинета по клику на логотип Stellar Burgers")
    public void loginFromPersonalAccountTest() {
        homePage.openHomePage();
        homePage.enterPersonalAccountButton();
        personalAccountPage.loginUser(USER);
        homePage.enterPersonalAccountButton();
        personalAccountPage.logoClick();
        assertEquals(URL_MAIN, driver.getCurrentUrl());
    }

    @After
    public void tearDown() {
        driver.close();
        deleteUser();
    }
}
