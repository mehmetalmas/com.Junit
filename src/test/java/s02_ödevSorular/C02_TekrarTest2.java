package s02_ödevSorular;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class C02_TekrarTest2 {

    //1. “https://www.saucedemo.com” Adresine gidin
    //2. Username kutusuna “standard_user” yazdirin
    //3. Password kutusuna “secret_sauce” yazdirin
    //4. Login tusuna basin
    //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
    //6. Add to Cart butonuna basin
    //7. Alisveris sepetine tiklayin
    //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
    //9. Sayfayi kapatin

    @Test
        public void Test_isItemInTheBasket() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1. "https://www.saucedemo.com" Adresine gidin
        driver.get("https://www.saucedemo.com");

        // 2. Username kutusuna "standard_user" yazdirin
        WebElement userInputBox = driver.findElement(By.xpath("//input[@id='user-name']"));
        userInputBox.sendKeys("standard_user");

        // 3. Password kutusuna "secret_sauce" yazdirin
        WebElement passwordInputBox = driver.findElement(By.xpath("//input[@id='password']"));
        passwordInputBox.sendKeys("secret_sauce");

        // 4. Login tusuna basin
        WebElement btnLogin = driver.findElement(By.xpath("//input[@id='login-button']"));
        btnLogin.click();

        // 5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement firstProduct = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
        String productName = firstProduct.getText();
        System.out.println("productName = " + productName);
        firstProduct.click();

        // 6. Add to Cart butonuna basin
        WebElement addToCard = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCard.click();

        // 7. Alisveris sepetine tiklayin
        WebElement shoppingBasket = driver.findElement(By.xpath("(//span[@class='shopping_cart_badge'])"));
        shoppingBasket.click();

        // 8. Sectiginiz urunun basarili olarak sepete eklendigini control edin

        /*
        boolean isProdcutInTheBasket = driver.getPageSource().contains(productName);
        Assert.assertTrue(isProdcutInTheBasket);
         */

        WebElement prodcutInTheBasket = driver.findElement(By.xpath("//div[text()='"+ productName +"']"));
        //Assert sinifindaki methodlar = actual ile expected degerleri karsilatirir ve sonuca gore test gecti ya da kaldi der. If gibi calisir
        Assert.assertTrue(prodcutInTheBasket.isDisplayed());

        // 9. Sayfayi kapatin
        // driver.quit();
    }
}






