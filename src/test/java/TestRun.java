import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.CalculatorPage;
import page.GooglePage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class TestRun {

    WebDriver driver = new ChromeDriver();
    GooglePage googlePage = new GooglePage(driver);
    CalculatorPage calculatorPage = new CalculatorPage(driver);


    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() {

        driver.get(googlePage.pageUrl);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (driver.getWindowHandles().size() > 1) {
            driver.close();
        } else {
            driver.quit();
        }
    }

    @Test
    @Step
    public void arithmeticOperations() throws IOException {

        googlePage.inputTextAndClickSearchButton();
        calculatorPage.clickOpenBracket();
        calculatorPage.clickOne();
        calculatorPage.clickPlus();
        calculatorPage.clickTwo();
        calculatorPage.clickCloseBracket();
        calculatorPage.clickMultiplication();
        calculatorPage.clickThree();
        calculatorPage.clickMinus();
        calculatorPage.clickFour();
        calculatorPage.clickZero();
        calculatorPage.clickDivide();
        calculatorPage.clickFive();
        calculatorPage.clickEqual();
        calculatorPage.checkResult();
    }

    @Test
    @Step
    public void divisionByZero() throws IOException {
        googlePage.inputTextAndClickSearchButton();
        calculatorPage.clickSix();
        calculatorPage.clickDivide();
        calculatorPage.clickZero();
        calculatorPage.clickEqual();
        calculatorPage.checkStringEqualsText();

    }

    @Step
    @Test
    public void getError() throws IOException {
        googlePage.inputTextAndClickSearchButton();
        calculatorPage.clickSin();
        calculatorPage.clickEqual();
        calculatorPage.checkStringEqualsTextTwo();

    }


}

