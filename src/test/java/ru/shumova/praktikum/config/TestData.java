package ru.shumova.praktikum.config;

import org.apache.commons.lang3.RandomStringUtils;
import ru.shumova.praktikum.dto.UserDto;

public class TestData {
    public static final String EMAIL = RandomStringUtils.randomAlphabetic(15) + "@yandex.ru";
    public static final String PASSWORD = RandomStringUtils.randomAlphabetic(10);
    public static final String NAME = RandomStringUtils.randomAlphabetic(10);
    public static final String INCORRECT_PASSWORD = RandomStringUtils.randomAlphabetic(4);
    public static final UserDto USER = new UserDto(EMAIL, PASSWORD, NAME);
    public static final UserDto USER_INCORRECT = new UserDto(EMAIL, INCORRECT_PASSWORD, NAME);
}
