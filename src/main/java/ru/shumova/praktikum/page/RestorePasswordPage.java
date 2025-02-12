package ru.shumova.praktikum.page;

import io.qameta.allure.Step;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Getter
@Setter
public class RestorePasswordPage extends AbstractPage {

    private final By loginButtonPasswordPage = By.xpath("//a[@href='/login']");

    public RestorePasswordPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие 'Восстановление пароля'")
    public void openResetPasswordPage() {
        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");
    }

    @Step("Нажатие на кнопку 'Войти'")
    public void enterAccountClickButton() {
        waitForLoad(loginButtonPasswordPage);
        driver.findElement(loginButtonPasswordPage).click();
    }
}
