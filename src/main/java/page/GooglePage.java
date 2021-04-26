package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {
    private WebDriver driver;
    @FindBy(name = "q")
    private WebElement searchField;
    public String pageUrl = "https://google.com";

    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public void init(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @Step("Ввести в поиск слово: -Калькулятор- и нажать поиск ")
    public void inputTextAndClickSearchButton() {
        init(driver);
        searchField.sendKeys("Калькулятор");
        searchField.submit();
    }

}
