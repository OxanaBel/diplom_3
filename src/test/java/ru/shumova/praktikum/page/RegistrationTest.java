package ru.shumova.praktikum.page;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.shumova.praktikum.AbstractTest;
import ru.shumova.praktikum.dto.UserDto;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;
import static ru.shumova.praktikum.config.TestData.*;

public class RegistrationTest extends AbstractTest {
    private static RegistrationPage registrationPage;

    @Before
    public void setUp() {
        initDriver();
        registrationPage = new RegistrationPage(driver);
    }

    @Test
    @DisplayName("Успешная регистрация пользователя")
    public void successRegistrationTest() {
        registrationPage.openPage();
        UserDto user = registrationPage.userRegistration(USER);
        login(user).then().statusCode(200).body("success", is(true));
        deleteUser();
    }

    @Test
    @DisplayName("Регистрация с паролем < 6 символов")
    public void errorRegistrationTest() {
        registrationPage.openPage();
        registrationPage.userRegistration(USER_INCORRECT);
        assertTrue(registrationPage.passwordError());
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
