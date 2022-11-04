package s03_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P07 {

    /*
            ...Exercise4...
            https://www.teknosa.com/ adresine gidiniz
            arama cubuguna oppo yazip enter diyiniz
            sonuc sayisini yazdiriniz
            cikan ilk urune tiklayiniz
            sepete ekleyiniz
            sepetime git e tiklayiniz
            consol da "Sipariş Özeti" webelementinin text ini yazidiriniz
            Alisverisi tamamlayiniz
            son alarak da "Teknosa'ya hoş geldiniz"  webelementinin text ini yazidiriniz
            driver i kapatiniz
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
    @Before
    public void beforeTest(){
        driver.get("https://www.teknosa.com/");
    }
    @Test
    public void test01(){
        driver.findElement(By.xpath("(//button[@class='search-button js_search_button sbx-fake btn-search'])[1]"))
                .sendKeys("oppo"+ Keys.ENTER);


        System.out.println("Sonuc Sayisi : " + driver.findElement(By.xpath("//div[@class='plp-info']")).getText());
        driver.findElement(By.xpath("(//a[@class='prd-link'])[1]")).click();
        driver.findElement(By.xpath("(//button[@id='addToCartButton'])[1]")).click();
        driver.findElement(By.xpath("(//a[@class='btn btn-secondary'])[1]")).click();
        System.out.println("Siparis Ozeti : " + driver.findElement(By.xpath("(//div[@class='cart-sum-title'])[1]")).getText());
        driver.findElement(By.xpath("(//span[text()='Alışverişi Tamamla'])[1]")).click();
        System.out.println("Siparis Ozeti : " + driver.findElement(By.xpath("(//div[@class='lrl-title'])[1]")).getText());
    }
}
