import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class onlineMovie {


    private WebDriver driver;
    private WebDriverWait wait;


    @BeforeClass
    public void setUp() {


        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @AfterClass
    public void tearDown() {

        driver.quit();
    }

    @Test
    public void testOnlineMovie() {

        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module05/practice1/");
        var emailElement = driver.findElement(By.className("form-input"));
        var passwordElement = driver.findElement(By.id("password"));
        var passwordConfirmElement = driver.findElement(By.name("confirm_password"));
        var buttonElemen = driver.findElement(By.tagName("button"));
        var headerResultElement = driver.findElement(By.tagName("h3"));
        var password = "321";
        var email = "asd@wew.com";
        emailElement.sendKeys(email);
        passwordElement.sendKeys(password);
        passwordConfirmElement.sendKeys(password);
        buttonElemen.click();
        var emailResultElement = driver.findElement(By.linkText(email));
        var emailResultElement2 = driver.findElement(By.partialLinkText(email));
        Assert.assertEquals( "Спасибо за регистрацию!", headerResultElement.getText());
        Assert.assertEquals( email, emailResultElement.getText());
    }

    @Test
    public void testShoeStore() {


        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module03/practice1/");

        var sizeElement = driver.findElement(By.name("check"));
        var buttonElement = driver.findElement(By.id("check-size-button"));
        var size = "34";
        sizeElement.sendKeys(size);
        buttonElement.click();
        var ResultElement = driver.findElement(By.className("error"));
        Assert.assertEquals( "В нашем магазине есть обувь вашего размера", ResultElement.getText());

    }
    @Test
    public void testShoeStore2() {


        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module03/practice1/");

        var sizeElement = driver.findElement(By.name("check"));
        var buttonElement = driver.findElement(By.id("check-size-button"));
        var size = "";
        sizeElement.sendKeys(size);
        buttonElement.click();
        var ResultElement2 = driver.findElement(By.id("size-error"));
        Assert.assertEquals("Введите размер обуви!", ResultElement2.getText());

    }

    @Test
    public void testShoeStore3() {


        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module03/practice1/");

        var sizeElement = driver.findElement(By.name("check"));
        var buttonElement = driver.findElement(By.id("check-size-button"));
        var size = "33";
        sizeElement.sendKeys(size);
        buttonElement.click();
        var ResultElement3 = driver.findElement(By.id("size-error"));
        Assert.assertEquals("В нашем магазине нет обуви вашего размера", ResultElement3.getText());


    }


    @Test
    public void testMovie() {


        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module07/practice3/");

        var filmsElement = driver.findElement(By.tagName("input"));
        var serialsElement = driver.findElement(By.name("serials"));
        var buttonElement = driver.findElement(By.id("save"));
        var buttonElement2 = driver.findElement(By.id("two"));
        var buttonElement3 = driver.findElement(By.id("save"));
        var buttonElement4 = driver.findElement(By.id("ok"));

        var film = "asd";
        var serial = "dsa";
        filmsElement.sendKeys(film);
        serialsElement.sendKeys(serial);
        buttonElement.click();
        buttonElement2.click();
        buttonElement3.click();
        buttonElement4.click();
        var resultFilmsElement = driver.findElement(By.className("result__text"));
        var resultSerialsElement = driver.findElement(By.id("best_serials"));

        Assert.assertEquals("asd", resultFilmsElement.getText());
        Assert.assertEquals("dsa", resultSerialsElement.getText());


    }

    private By emailElement =  By.className("email");
    private By buttonElement = By.id("write-to-me");
    private By resultElement = By.className("result-email");
    @Test
    public void testKitty() {


        driver.navigate().to("https://qajava.skillbox.ru/module04/lesson2/");


        var email = "asd@dsa.com";
        driver.findElement(emailElement).sendKeys(email);
        driver.findElement(buttonElement).click();

        Assert.assertTrue(driver.findElement(resultElement).isDisplayed());
        Assert.assertEquals("asd@dsa.com", email, driver.findElement(resultElement).getText());

    }


    @Test
    public void testKitty2() {


        driver.navigate().to("https://qajava.skillbox.ru/module04/lesson2/");

                //        var email = "asd@dsa.com";
//      driver.findElement(emailElement).sendKeys(email);
        driver.findElement(buttonElement).click();
       //        Assert.assertEquals(true, resultElement.isDisplayed());
//        Assert.assertEquals("asd@dsa.com", resultElement.getText());
        Assert.assertEquals("", driver.findElement(resultElement).getText());

    }
    private By emailElemenSock =  By.id("email");
    private By passwordElementSock = By.id("password");
    private By enterElementSock = By.className("form-submit");
    private By resultElementSock = By.id("error");

    @Test
    public void testSocks() {


        driver.navigate().to("https://qajava.skillbox.ru/module04/homework/auth/index.html");

        var email = "@";
        var password = "123";
        driver.findElement(emailElemenSock).sendKeys(email);
        driver.findElement(passwordElementSock).sendKeys(password);
        driver.findElement(enterElementSock).click();
        Assert.assertTrue(driver.findElement(resultElementSock).isDisplayed());

        //        Assert.assertEquals(true, resultElement.isDisplayed());
//        Assert.assertEquals("asd@dsa.com", resultElement.getText());
        Assert.assertEquals("Некорректный email или пароль", driver.findElement(resultElementSock).getText());

    }
    private By emailElemenSock2 =  By.cssSelector(".form-input.input-data");
    private By passwordElementSock2 = By.cssSelector("#password");
    private By enterElementSock2 = By.cssSelector("#submit");
    private By resultElementSock2 = By.cssSelector("#error");
    @Test
    public void testSocks2() {


        driver.navigate().to("https://qajava.skillbox.ru/module04/homework/auth/changed.html");

        var email = "@";
        var password = "123";
        driver.findElement(emailElemenSock2).sendKeys(email);
        driver.findElement(passwordElementSock2).sendKeys(password);
        driver.findElement(enterElementSock2).click();
        Assert.assertTrue(driver.findElement(resultElementSock2).isDisplayed());
        Assert.assertEquals("Некорректный email или пароль", driver.findElement(resultElementSock2).getText());

    }
    private By resultElementSock3 = By.cssSelector(".form-error");
    @Test
    public void testSocks3() {


        driver.navigate().to("https://qajava.skillbox.ru/module04/homework/auth/changed.html");

        var email = "v@cc.com";
        var password = "123";
        driver.findElement(emailElemenSock2).sendKeys(email);
        driver.findElement(passwordElementSock2).sendKeys(password);
        driver.findElement(enterElementSock2).click();
        Assert.assertTrue(driver.findElement(resultElementSock3).isDisplayed());
        Assert.assertEquals("Такой email не зарегистрирован", driver.findElement(resultElementSock3).getText());

    }

    private By aboutStore = By.cssSelector("a[test-info='about-us']");


    @Test
    public void testBookStore() {


        driver.navigate().to("https://qajava.skillbox.ru/index.html");

        //        var email = "asd@dsa.com";
//      driver.findElement(emailElement).sendKeys(email);
        var text = driver.findElement(aboutStore).getText();
        System.out.println(text);


        //        Assert.assertEquals(true, resultElement.isDisplayed());
//        Assert.assertEquals("asd@dsa.com", resultElement.getText());
//        Assert.assertEquals("", driver.findElement(resultElement).getText());

    }

    private By addNote = By.cssSelector("textarea");
    private By addNoteButton = By.cssSelector("button.baseButton");
    private By note1 = By.cssSelector("div.vb-content>:first-child>*>p.articlePreview__text");
    private By note1Button = By.cssSelector("div.vb-content>:first-child>button.articlePreview__link");
    private By note1Basket = By.cssSelector("div.pageArticle__buttons>:last-child>svg.pageArticle__icon");


    @Test
    public void noteList() {


        driver.navigate().to("http://qa.skillbox.ru/module15/bignotes/#/");
        driver.findElement(addNote).click();
        driver.findElement(addNote).sendKeys("Yesterday 12:00 meeting John");
        driver.findElement(addNoteButton).click();
        var resultElementNote1 = driver.findElement(note1);

//        Assert.assertEquals(true, resultElement.isDisplayed());
        Assert.assertEquals("Yesterday 12:00 meeting John", resultElementNote1.getText());
//        Assert.assertEquals("", driver.findElement(resultElement).getText());
        driver.findElement(note1Button).click();
//        wait.until(ExpectedConditions.presenceOfElementLocated(note1Basket));
        driver.findElement(note1Basket).click();
        Assert.assertTrue(driver.findElement(note1).isEnabled());

    }
 }