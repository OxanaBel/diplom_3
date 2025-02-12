package ru.shumova.praktikum.page;

import io.qameta.allure.Step;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.shumova.praktikum.dto.UserDto;

@Getter
@Setter
public class RegistrationPage extends AbstractPage {

    private final By loginButtonRegistrationPage = By.xpath("//a[@href='/login']");
    private final By registerButton = By.xpath("//button[contains(text(), 'Зарегистрироваться')]");
    private final By nameInput = By.cssSelector("input.text.input__textfield.text_type_main-default");
    private final By wrongPasswordMessage = By.xpath("//p[contains(text(), 'Некорректный пароль')]");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы регистрации")
    public void openPage() {
        driver.get("https://stellarburgers.nomoreparties.site/register");
    }

    @Step("Успешная регистрация пользователя")
    public UserDto userRegistration(UserDto user) {
        waitForLoad(nameInput);
        driver.findElements(nameInput).get(0).sendKeys(user.getName());
        driver.findElements(nameInput).get(1).sendKeys(user.getEmail());
        driver.findElements(nameInput).get(2).sendKeys(user.getPassword());
        driver.findElement(registerButton).click();
        return user;
    }

    @Step("Отображение ошибки пароля")
    public boolean passwordError() {
        waitForLoad(wrongPasswordMessage);
        return driver.findElement(wrongPasswordMessage).isDisplayed();
    }

    @Step("Нажатие на кнопку 'Войти' на странице Регистрации")
    public void enterAccountClickButton() {
        waitForLoad(loginButtonRegistrationPage);
        driver.findElement(loginButtonRegistrationPage).click();
    }

}
