package ru.shumova.praktikum.config;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class BrowserFactory {

    @SneakyThrows
    public static WebDriver getWebDriver() {
        Path path = Paths.get("src/test/resources/driver.properties");
        Properties properties = new Properties();
        properties.load(Files.newInputStream(path));
        String driver = properties.getProperty("driver.name");
        if (driver.equals("yandex")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/binary/yandexdriver.exe");
            ChromeOptions options = new ChromeOptions();
            return new ChromeDriver(options);
        }
        ChromeOptions options = new ChromeOptions();
        return new ChromeDriver(options);
    }
}
