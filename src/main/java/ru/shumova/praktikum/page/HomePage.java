package ru.shumova.praktikum.page;

import io.qameta.allure.Step;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Getter
@Setter
public class HomePage extends AbstractPage {
    private final By personalAccountButtonOfPage = By.xpath("//a[@href='/account']");
    private final By loginButtonOfHomePage = By.xpath("//button[contains(text(), 'Войти в аккаунт')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы регистрации")
    public void openHomePage() {
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    @Step("Нажатие на кнопку 'Личный кабинет'")
    public void enterPersonalAccountButton() {
        waitForLoad(personalAccountButtonOfPage);
        driver.findElement(personalAccountButtonOfPage).click();
    }

    @Step("Нажатие на кнопку 'Войти в аккаунт'")
    public void enterAccountClickButton() {
        waitForLoad(loginButtonOfHomePage);
        driver.findElement(loginButtonOfHomePage).click();
    }
}
