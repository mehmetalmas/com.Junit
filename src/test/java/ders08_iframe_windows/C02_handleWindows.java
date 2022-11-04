package ders08_iframe_windows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_handleWindows {
    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void windowtesti(){
        // https://the-internet.herokuapp.com/iframe adresine gidin
        driver.get("https://the-internet.herokuapp.com/iframe");

        // elemental selenium linkini tiklayin
        driver.findElement(By.linkText("Elemental Selenium")).click();

        // Acilan sayfadaki en bastaki yazinin gorunur oldugunu
        WebElement baslikElementi= driver.findElement(By.tagName("h1"));
        Assert.assertTrue(baslikElementi.isDisplayed());

        // ve yazinin Elemental Selenium oldugunu test edin
        String expectedYazi="Elemental Selenium";
        String actualYazi= baslikElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);
    }
    @After
    public void teardown(){
        driver.close();
    }


}
