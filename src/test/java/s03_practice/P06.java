package s03_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P06 {

    /*
            ..........Exercise6............
            BeforeClass ile driver'i olusturun ve class icinde static yapin
            Maximize edin ve 10 sn bekletin
            http://www.google.com adresine gidin
            arama kutusuna "The Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
            arama kutusuna "Brave Heart" yazip, cikan sonuc sayisini yazdirin
            arama kutusuna "Harry Potter" yazip, cikan sonuc sayisini yazdirin
            AfterClass ile kapatin
    */

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @After
    public void afterTest(){
        System.out.println("Test sonucu : " + driver.findElement(By.xpath("//div[@id='result-stats']")).getText());
    }

    @Before
    public void beforeTest(){
        driver.get("http://www.google.com");
    }

    @Test
    public void test01(){
        driver.findElement(By.xpath("//div[text()='Tümünü kabul et']")).click();
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys("The Lord of the Rings"+ Keys.ENTER);
    }

    @Test
    public void test02(){
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys("Brave Heart"+ Keys.ENTER);
    }

    @Test
    public void test03(){
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys("Harry Potter"+ Keys.ENTER);
    }

}





