package s02_ödevSorular;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_TekrarTest {
    public static void main(String[] args) {
        // 1-C01_TekrarTesti isimli bir class olusturun

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com");

        //3- cookies uyarisini kabul ederek kapatin
        WebElement cookiesButton;
        cookiesButton = driver.findElement(By.xpath("//button[@id='L2AGLb']"));
        cookiesButton.click();

       // driver.findElement(By.xpath("//button[@id='L2AGLb']")).click();

        //4-Sayfa basliginin “Google” ifadesi icerdigini test edin

        String Beklenenicerik = "Google";
        String CikanSonuc = driver.getTitle();

        if(CikanSonuc.contains(Beklenenicerik)) {
            System.out.println("Sayfa basliginin “Google” ifadesi iceriyor");
        } else {
            System.out.println("Sayfa basliginin “Google” ifadesi icerimiyor");
        }

        //5- Arama cubuguna “Nutella” yazip aratin
        WebElement aramaCubugu = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        aramaCubugu.sendKeys("Nutella" + Keys.ENTER);

        //6-Bulunan sonuc sayisini yazdirin
        WebElement bulunanSonuclar = driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(bulunanSonuclar.getText());

        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String[] bulunanElemanlar = bulunanSonuclar.getText().split(" ");
        long sayi = Long.parseLong(bulunanElemanlar[1].replaceAll("\\.", ""));

        if (sayi>10_000_000) {
            System.out.println("sonuc sayisinin 10 milyon’dan fazla");
        }else {
            System.out.println("sonuc sayisinin 10 milyon’dan fazla degil");
        }


        //8-Sayfayi kapatin
        driver.close();

    }
}
