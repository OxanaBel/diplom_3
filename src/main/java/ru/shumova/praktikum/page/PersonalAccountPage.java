package ru.shumova.praktikum.page;

import io.qameta.allure.Step;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.shumova.praktikum.dto.UserDto;

@Getter
@Setter
public class PersonalAccountPage extends AbstractPage {

    private final By loginInput = By.xpath("//*/input[@class='text input__textfield text_type_main-default']");
    private final By loginButtonPersonalAccount = By.xpath("//button[contains(text(), 'Войти')]");
    private final By constructorButton = By.xpath("//li/a[@href='/']");
    private final By logo = By.xpath("//div/a[@href='/']");
    private final By buttonExit = By.xpath("//li/button");

    public PersonalAccountPage(WebDriver driver) {
        super(driver);
    }

    @Step("Нажатие на кнопку 'Конструктор'")
    public void constructorClickButton() {
        waitForLoad(constructorButton);
        driver.findElement(constructorButton).click();
    }

    @Step("Нажатие на логотип Stellar Burgers")
    public void logoClick() {
        waitForLoad(logo);
        driver.findElement(logo).click();
    }

    @Step("Нажатие на кнопку 'Выйти'")
    public void enterExitClickButton() {
        waitForLoad(buttonExit);
        driver.findElement(buttonExit).click();
        waitForLoad(loginInput);
    }

    @Step("Авторизация пользователя")
    public void loginUser(UserDto user) {
        waitForLoad(loginInput);
        driver.findElements(loginInput).get(0).sendKeys(user.getEmail());
        driver.findElements(loginInput).get(1).sendKeys(user.getPassword());
        driver.findElement(loginButtonPersonalAccount).click();
        waitForLoad(logo);
    }
}
