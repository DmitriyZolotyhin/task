package page;

import java.io.IOException;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CalculatorPage {
    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public void init(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[text()='(']")
    public WebElement openBracket;
    @FindBy(xpath = "//div[text()=')']")
    public WebElement closeBracket;
    @FindBy(xpath = "//div[text()='+']")
    public WebElement plusButton;
    @FindBy(xpath = "//div[text()='×']")
    public WebElement multiplication;
    @FindBy(xpath = "//div[text()='−']")
    public WebElement minusButton;
    @FindBy(xpath = "//div[text()='÷']")
    public WebElement divideButton;
    @FindBy(xpath = "//div[text()='=']")
    public WebElement equalButton;
    @FindBy(xpath = "//div[text()='sin']")
    public WebElement sinButton;
    @FindBy(xpath = "//div[text()='0']")
    public WebElement zeroButton;
    @FindBy(xpath = "//div[text()='1']")
    public WebElement OneButton;
    @FindBy(xpath = "//div[text()='2']")
    public WebElement twoButton;
    @FindBy(xpath = "//div[text()='3']")
    public WebElement threeButton;
    @FindBy(xpath = "//div[text()='4']")
    public WebElement fourButton;
    @FindBy(xpath = "//div[text()='5']")
    public WebElement fiveButton;
    @FindBy(xpath = "//div[text()='6']")
    public WebElement sixButton;

    @Step("Нажать на кнопку:  ( ")
    public void clickOpenBracket() {
        init(driver);
        openBracket.click();
    }

    @Step("Нажать на кнопку: ) ")
    public void clickCloseBracket() {
        closeBracket.click();
    }

    @Step("Нажать на кнопку: 1 ")
    public void clickOne() {
        OneButton.click();
    }

    @Step("Нажать на кнопку: + ")
    public void clickPlus() {
        plusButton.click();
    }

    @Step("Нажать на кнопку: 2 ")
    public void clickTwo() {
        twoButton.click();
    }

    @Step("Нажать на кнопку: * ")
    public void clickMultiplication() {
        multiplication.click();
    }

    @Step("Нажать на кнопку: 3 ")
    public void clickThree() {
        threeButton.click();
    }

    @Step("Нажать на кнопку: - ")
    public void clickMinus() {
        minusButton.click();
    }

    @Step("Нажать на кнопку: 4 ")
    public void clickFour() {
        fourButton.click();
    }

    @Step("Нажать на кнопку: 0 ")
    public void clickZero() {
        zeroButton.click();
    }

    @Step("Нажать на кнопку:  ÷ ")
    public void clickDivide() {
        divideButton.click();
    }

    @Step("Нажать на кнопку:  5 ")
    public void clickFive() {
        fiveButton.click();
    }

    @Step("Нажать на кнопку:  =")
    public void clickEqual() {
        equalButton.click();
    }

    @Step("Нажать на кнопку:  6 ")
    public void clickSix() {
        init(driver);
        sixButton.click();
    }

    @Step("Нажать на кнопку:  sin ")
    public void clickSin() {
        init(driver);
        sinButton.click();
    }

    @Step("Проверка ожидаемого результата")
    public void checkResult() throws IOException {
        String expectedText = "(1 + 2) × 3 - 40 ÷ 5 =";
        String responseText = driver.findElement(By.className("vUGUtc")).getText();
        Assert.assertEquals(expectedText, responseText);
    }

    @Step("Проверка эквивалентности строки expectedText строке responseText и проверки ожидаемого результата")
    public void checkStringEqualsText() throws IOException {
        String expectedText = "6 ÷ 0 =";
        String responseText = driver.findElement(By.className("vUGUtc")).getText();
        String expectedResult = "Infinity";
        String responseResult = driver.findElement(By.id("cwos")).getText();
        Assert.assertEquals(expectedText, responseText);
        Assert.assertEquals(expectedResult, responseResult);
    }

    @Step("Проверка эквивалентности строки expectedText строке responseText  и проверки ожидаемого результата")
    public void checkStringEqualsTextTwo() throws IOException {
        String expectedText = "sin() =";
        String responseText = driver.findElement(By.className("vUGUtc")).getText();
        String expectedTextError = "Error";
        String responseTextError = driver.findElement(By.id("cwos")).getText();
        Assert.assertEquals(expectedText, responseText);
        Assert.assertEquals(expectedTextError, responseTextError);

    }

}


