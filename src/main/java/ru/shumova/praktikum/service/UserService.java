package ru.shumova.praktikum.service;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;
import ru.shumova.praktikum.dto.UserDto;

import static io.restassured.RestAssured.given;

@Getter
@Setter
public class UserService {
    public static final String LOGIN_PATH = "https://stellarburgers.nomoreparties.site/api/auth/login";
    public static final String DELETE_PATH = "https://stellarburgers.nomoreparties.site/api/auth/user";
    public static final String REGISTER_PATH = "https://stellarburgers.nomoreparties.site/api/auth/register";

    @Step("Создание пользователя")
    public void create(UserDto user) {
        given().header("Content-Type", "application/json")
                .and()
                .body(user)
                .when()
                .post(REGISTER_PATH);
    }

    @Step("Вход в учетную запись")
    public Response login(UserDto user) {
        return given().header("Content-Type", "application/json")
                .body(user)
                .when()
                .post(LOGIN_PATH);
    }

    @Step("Получение Token")
    public String getToken(UserDto user) {
        return given().header("Content-Type", "application/json")
                .body(user)
                .when()
                .post(LOGIN_PATH)
                .then()
                .extract()
                .path("accessToken");
    }

    @Step("Удаление пользователя")
    public void delete(String token) {
        if (token != null) {
            given().header("Content-Type", "application/json")
                    .header("Authorization", token)
                    .when()
                    .delete(DELETE_PATH);
        }
    }
}
