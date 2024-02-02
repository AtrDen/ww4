import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumTests
    {
     private WebDriver driver;

    @BeforeClass
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

    @Test
    public void testHelloVasya()
    {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Вася");
        driver.findElement(By.name("email")).sendKeys("Den.Atr@yandex.com");
        driver.findElement(By.name("phone")).sendKeys("+7 334 345 27 45");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, Вася.\n" +
                "На вашу почту (Den.Atr@yandex.com) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: +7 334 345 27 45.";
        Assert.assertEquals(actualResult, expectedResult, "Bag");
    }
}
