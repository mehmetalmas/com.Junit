package s01_automationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // @Test notasyonlarini yazildigi siraya göre calistirir

/*
 * Java dilinde Annotation(Notasyonlar), bir veri hakkında bilgi barındıran veriyi sağlayan basit bir yapıdır.
 * Bu sağladığı bilgiye de “metadata” denir.
 * Notasyonlar( Annotation) genellikle Java’da konfigürasyon amacıyla kullanılır. Ya da bir bileşene ek özellikle katar.
 * Bu bileşenler sınıf, metod, değişkenler, paket ya da parametreler olabilir. Bunların hepsinde notasyonları kullanabiliriz.
 */


public class TestBase2 {

    public static WebDriver driver; // Static olarak WebDriver i olusturduk


    // @BeforeClass notasyonu = eger test adimlarimiz birbirine bagli(irtibatli) ise testlerimizi bir den fazla @Test notasyonu altinda calistirabilir
    // Testlerin birbirine bagli olmasinin anlami; ayni WebDriver i kullanmalari anlamina gelmektedir
    // @BeforeClass olusturulan WebDriver birden fazla @Test (önemli olan yer-bir fazla) notayonu icin kullanilabilir vaya calistirilabilir
    // @Before kullanarak birbirine bagli test adimlarini farkli @Test notasyonlari altinda yapilabilir (bir WebDriverler tüm @Test icin ayni sekilde üretileceginden )

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public static void tearDown(){
        //driver.quit();
    }

}
