package ru.shumova.praktikum.page;

import io.qameta.allure.Step;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Getter
@Setter
public class ConstructorPage extends AbstractPage {

    private final By bunsButton = By.xpath("//span[contains(text(), 'Булки')]");
    private final By activeBunsButton = By.xpath("//div[@class='tab_tab__1SPyG " +
            "tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']");
    private final By saucesButton = By.xpath("//span[contains(text(), 'Соусы')]");
    private final By activeSaucesButton = By.xpath("//div[@class='tab_tab__1SPyG " +
            "tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']");
    private final By fillingsButton = By.xpath("//span[contains(text(), 'Начинки')]");
    private final By activeFillingsButton = By.xpath("//div[@class='tab_tab__1SPyG " +
            "tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']");

    public ConstructorPage(WebDriver driver) {
        super(driver);
    }

    @Step("Нажатие на кнопку «Булки»")
    public void bunsButtonClick() {
        waitForLoad(bunsButton);
        driver.findElement(bunsButton).click();
    }

    @Step("Нажатие на кнопку «Соусы»")
    public void saucesButtonClick() {
        waitForLoad(saucesButton);
        driver.findElement(saucesButton).click();
    }

    @Step("Нажатие на кнопку «Начинки»")
    public void fillingsButtonClick() {
        waitForLoad(fillingsButton);
        driver.findElement(fillingsButton).click();
    }

    @Step("Проверка активности кнопки 'Булки'")
    public boolean isBunsButtonActive() {
        waitForLoad(activeBunsButton);
        return driver.findElement(activeBunsButton).isDisplayed();
    }

    @Step("Проверка активности кнопки 'Соусы'")
    public boolean isSaucesButtonActive() {
        waitForLoad(activeSaucesButton);
        return driver.findElement(activeSaucesButton).isDisplayed();
    }

    @Step("Проверка активности кнопки 'Начинки'")
    public boolean isFillingsButtonActive() {
        waitForLoad(activeFillingsButton);
        return driver.findElement(activeFillingsButton).isDisplayed();
    }
}
