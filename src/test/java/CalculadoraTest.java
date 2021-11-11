import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class CalculadoraTest {
    private static ChromeDriver driver;

    @BeforeClass
    public static void beforeClass(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Before
    public void setUp(){
        driver.get("http://vanilton.net/calculatorSoapPHP/");
    }

    @Test
    public void somaValida(){
        driver.findElement(By.name("num1")).sendKeys("4");
        driver.findElement(By.name("num2")).sendKeys("4");
        driver.findElement(By.xpath("//form/select/option[@value='sum']/../../input  [@type='submit']")).click();
        Boolean result = driver.findElement(By.xpath("//body[contains(.,'= 8')]")).isDisplayed();
        Assert.assertTrue(result);
    }

    @Test
    public void subtracaoValida() {
        driver.findElement(By.name("num1")).sendKeys("6");
        WebElement op = driver.findElement(By.name("op"));
        Select operador = new Select(op);
        operador.selectByValue("sub");
        driver.findElement(By.name("num2")).sendKeys("4");
        driver.findElement(By.xpath("//form/select/option[@value='sum']/../../input  [@type='submit']")).click();
        Boolean result = driver.findElement(By.xpath("//body[contains(.,'= 2')]")).isDisplayed();
        Assert.assertTrue(result);
    }

    @Test
    public void multiplicacaoValida() {
        driver.findElement(By.name("num1")).sendKeys("2");
        WebElement op = driver.findElement(By.name("op"));
        Select operador = new Select(op);
        operador.selectByValue("mul");
        driver.findElement(By.name("num2")).sendKeys("3");
        driver.findElement(By.xpath("//form/select/option[@value='sum']/../../input  [@type='submit']")).click();
        Boolean result = driver.findElement(By.xpath("//body[contains(.,'= 6')]")).isDisplayed();
        Assert.assertTrue(result);
    }

    @Test
    public void divisaoValida() {
        driver.findElement(By.name("num1")).sendKeys("10");
        WebElement op = driver.findElement(By.name("op"));
        Select operador = new Select(op);
        operador.selectByValue("div");
        driver.findElement(By.name("num2")).sendKeys("2");
        driver.findElement(By.xpath("//form/select/option[@value='sum']/../../input  [@type='submit']")).click();
        Boolean result = driver.findElement(By.xpath("//body[contains(.,'= 5')]")).isDisplayed();
        Assert.assertTrue(result);
    }
    @Test
    public void raizValida() {
        WebElement op = driver.findElement(By.xpath("//form/select/option[@value='sqrt']/.."));
        Select operador = new Select(op);
        operador.selectByValue("sqrt");
        driver.findElement(By.xpath("//form/select/option[@value='sqrt']/../../input[@name='num1']")).sendKeys("9");
        driver.findElement(By.xpath("//form/select/option[@value='sqrt']/../../input[@type='submit']")).click();
        Boolean result = driver.findElement(By.xpath("//body[contains(.,'= 3')]")).isDisplayed();
        Assert.assertTrue(result);
    }

    @Test
    public void senoValida() {
        WebElement op = driver.findElement(By.xpath("//form/select/option[@value='sqrt']/.."));
        Select operador = new Select(op);
        operador.selectByValue("sin");
        driver.findElement(By.xpath("//form/select/option[@value='sqrt']/../../input[@name='num1']")).sendKeys("90");
        driver.findElement(By.xpath("//form/select/option[@value='sqrt']/../../input[@type='submit']")).click();
        Boolean result = driver.findElement(By.xpath("//body[contains(.,'= 0.89399666360056')]")).isDisplayed();
        Assert.assertTrue(result);
    }

    @Test
    public void cossenoValida() {
        WebElement op = driver.findElement(By.xpath("//form/select/option[@value='sqrt']/.."));
        Select operador = new Select(op);
        operador.selectByValue("cos");
        driver.findElement(By.xpath("//form/select/option[@value='sqrt']/../../input[@name='num1']")).sendKeys("15");
        driver.findElement(By.xpath("//form/select/option[@value='sqrt']/../../input[@type='submit']")).click();
        Boolean result = driver.findElement(By.xpath("//body[contains(.,'= -0.75968791285882')]")).isDisplayed();
        Assert.assertTrue(result);
    }

    @Test
    public void tangenteValida() {
        WebElement op = driver.findElement(By.xpath("//form/select/option[@value='sqrt']/.."));
        Select operador = new Select(op);
        operador.selectByValue("tan");
        driver.findElement(By.xpath("//form/select/option[@value='sqrt']/../../input[@name='num1']")).sendKeys("30");
        driver.findElement(By.xpath("//form/select/option[@value='sqrt']/../../input[@type='submit']")).click();
        Boolean result = driver.findElement(By.xpath("//body[contains(.,'= -6.4053311966463')]")).isDisplayed();
        Assert.assertTrue(result);
    }


    @AfterClass
    public static void tearDown(){
        driver.quit();
    }


}
