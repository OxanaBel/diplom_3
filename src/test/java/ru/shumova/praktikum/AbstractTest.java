package ru.shumova.praktikum;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import ru.shumova.praktikum.dto.UserDto;
import ru.shumova.praktikum.service.UserService;

import static ru.shumova.praktikum.config.TestData.*;
import static ru.shumova.praktikum.config.BrowserFactory.getWebDriver;

public class AbstractTest {
    protected final String URL_MAIN = "https://stellarburgers.nomoreparties.site/";
    protected final String URL_ACCOUNT = "https://stellarburgers.nomoreparties.site/account";
    protected final String URL_LOGIN = "https://stellarburgers.nomoreparties.site/login";
    private final UserService userService = new UserService();

    protected static WebDriver driver;
    private String token;

    @Step("Подготовка данных")
    public void createUser() {
        userService.create(USER);
    }

    @Step("Авторизация")
    public Response login(UserDto user) {
        return userService.login(user);
    }

    @Step("Удаление данных")
    public void deleteUser() {
        if (token == null) {
            token = userService.getToken(USER);
        }
        userService.delete(token);
    }

    public void initDriver() {
        driver = getWebDriver();
    }
}
