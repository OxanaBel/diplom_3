package ru.shumova.praktikum.page;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.shumova.praktikum.AbstractTest;

import static org.junit.Assert.assertEquals;
import static ru.shumova.praktikum.config.TestData.USER;

public class LoginTest extends AbstractTest {
    private static HomePage homePage;
    private static PersonalAccountPage personalAccountPage;
    private static RegistrationPage registrationPage;
    private static RestorePasswordPage restorePasswordPage;

    @Before
    public void setUp() {
        initDriver();
        homePage = new HomePage(driver);
        personalAccountPage = new PersonalAccountPage(driver);
        registrationPage = new RegistrationPage(driver);
        restorePasswordPage = new RestorePasswordPage(driver);
        createUser();
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void loginFromHomePageTest() {
        homePage.openHomePage();
        homePage.enterAccountClickButton();
        personalAccountPage.loginUser(USER);
        homePage.enterPersonalAccountButton();
        assertEquals(URL_ACCOUNT, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void loginFromPersonalAccounTest() {
        homePage.openHomePage();
        homePage.enterPersonalAccountButton();
        personalAccountPage.loginUser(USER);
        homePage.enterPersonalAccountButton();
        assertEquals(URL_ACCOUNT, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginFromRegistrationPageTest() {
        registrationPage.openPage();
        registrationPage.enterAccountClickButton();
        personalAccountPage.loginUser(USER);
        homePage.enterPersonalAccountButton();
        assertEquals(URL_ACCOUNT, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void loginFromResetPasswordPageTest() {
        registrationPage.openPage();
        restorePasswordPage.openResetPasswordPage();
        restorePasswordPage.enterAccountClickButton();
        personalAccountPage.loginUser(USER);
        homePage.enterPersonalAccountButton();
        assertEquals(URL_ACCOUNT, driver.getCurrentUrl());
    }

    @After
    public void tearDown() {
        driver.close();
        deleteUser();
    }
}
