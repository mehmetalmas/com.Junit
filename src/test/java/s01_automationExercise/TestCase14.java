package s01_automationExercise;

import com.github.javafaker.*;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestCase14 extends TestBase {
    final By byCart = By.xpath("(//a[@href='/view_cart'])[1]");
    final By byProccedtoCheckout = By.xpath("//a[@class='btn btn-default check_out']");
    @Test
    public void test() {
        //1. Launch browser

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String expacted = "Automation Exercise";
        String actual = driver.getTitle();
        Assert.assertEquals(expacted, actual);
        bekle(15);


        //4. Add products to cart
        List<WebElement> addItemButtonList = driver.findElements(By.xpath("//a[@class='btn btn-default add-to-cart']"));
        new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
        addItemButtonList.get(0).click();
        WebElement continueShopping = driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']"));
        continueShopping.click();
        addItemButtonList.get(2).click();
        continueShopping = driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']"));
        continueShopping.click();


        //5. Click 'Cart' button
        WebElement cartbuttonClick = driver.findElement(byCart);
        cartbuttonClick.click();


        //6. Verify that cart page is displayed
        expacted = "Automation Exercise - Checkout";
        actual = driver.getTitle();
        Assert.assertEquals(expacted, actual);


        //7. Click Proceed To Checkout
        driver.findElement(byProccedtoCheckout).click();


        //8. Click 'Register / Login' button
        WebElement registerLogin = driver.findElement(By.xpath("//u[text()='Register / Login']"));
        registerLogin.click();


        //Preparation for the fields
        Faker faker = Faker.instance();
        Name fakePerson = faker.name();
        String isim = fakePerson.firstName();
        String soyisim = fakePerson.lastName();
        Internet fakeInternet = faker.internet();
        Address fakeAddress = faker.address();
        String state = fakeAddress.state();
        String address1 = fakeAddress.streetAddress() + " " + fakeAddress.buildingNumber();
        String zipCode = fakeAddress.zipCode();
        String address2 = fakeAddress.cityName();
        Company fakeCompany = faker.company();
        String sirketIsimi = fakeCompany.name();


        //9. Fill all details in Signup and create account
        WebElement nameField = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        nameField.sendKeys(isim);
        WebElement emailField = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        emailField.sendKeys(fakeInternet.emailAddress());
        WebElement signUpButton = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
        signUpButton.click();


        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        expacted = "Automation Exercise - Signup";
        actual = driver.getTitle();
        Assert.assertEquals(expacted, actual);


        //11. Verify ' Logged in as username' at top
        driver.findElement(By.id("id_gender1")).click();
        //driver.findElement(By.id("name")).sendKeys(isim);
        driver.findElement(By.id("password")).sendKeys(fakeInternet.password());
        WebElement days = driver.findElement(By.id("days"));
        new Select(days).selectByValue("15");
        WebElement months = driver.findElement(By.id("months"));
        new Select(months).selectByValue("3");
        WebElement years = driver.findElement(By.id("years"));
        new Select(years).selectByValue("1980");
        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("optin")).click();
        driver.findElement(By.id("first_name")).sendKeys(isim);
        driver.findElement(By.id("last_name")).sendKeys(soyisim);
        driver.findElement(By.id("company")).sendKeys(sirketIsimi);
        driver.findElement(By.id("address1")).sendKeys(address1);
        driver.findElement(By.id("address2")).sendKeys(address2);
        WebElement countries = driver.findElement(By.id("country"));
        new Select(countries).selectByValue("Canada");
        driver.findElement(By.id("state")).sendKeys(state);
        driver.findElement(By.id("city")).sendKeys(address2);
        driver.findElement(By.id("zipcode")).sendKeys(zipCode);
        driver.findElement(By.id("mobile_number")).sendKeys("02122121212");
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
        boolean isAccountCreatedDisplayed  = driver.findElement(By.xpath("//b[text()='Account Created!']")).isDisplayed();
        Assert.assertTrue(isAccountCreatedDisplayed);
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();


        //12.Click 'Cart' button
        driver.findElement(byCart).click();


        //13. Click 'Proceed To Checkout' button
        driver.findElement(byProccedtoCheckout).click();


        //14. Verify Address Details and Review Your Order
        String actualNameSurname = driver.findElement(By.xpath("(//ul[@id='address_delivery']//li)[2]")).getText(); //title, isim, soyisim
        String expectedNameSurname = "Mr. " + isim + " " + soyisim;
        Assert.assertEquals(expectedNameSurname, actualNameSurname);
        String actualSirketIsimi = driver.findElement(By.xpath("(//ul[@id='address_delivery']//li)[3]")).getText(); //title, isim, soyisim
        Assert.assertEquals(sirketIsimi, actualSirketIsimi);
        String actualAddress1 = driver.findElement(By.xpath("(//ul[@id='address_delivery']//li)[4]")).getText(); //title, isim, soyisim
        Assert.assertEquals(address1, actualAddress1);
        String actualAddress2 = driver.findElement(By.xpath("(//ul[@id='address_delivery']//li)[5]")).getText(); //title, isim, soyisim
        Assert.assertEquals(address2, actualAddress2);
        String expectedStateCityZipCode = address2 + " " + state + " " + zipCode;
        String actualStateCityZipCode = driver.findElement(By.xpath("(//ul[@id='address_delivery']//li)[6]")).getText(); //title, isim, soyisim
        Assert.assertEquals(expectedStateCityZipCode, actualStateCityZipCode);
        String actualCountry = driver.findElement(By.xpath("(//ul[@id='address_delivery']//li)[7]")).getText(); //title, isim, soyisim
        Assert.assertEquals("Canada", actualCountry);
        String expectedPhoneNo = "02122121212";
        String actualPhoneNo = driver.findElement(By.xpath("(//ul[@id='address_delivery']//li)[8]")).getText(); //title, isim, soyisim
        Assert.assertEquals(expectedPhoneNo, actualPhoneNo);


        //15. Enter description in comment text area and click 'Place Order' Yorum metni alanına açıklama girin ve 'Sipariş Ver'i tıklayın
        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date - Ödeme ayrıntılarını girin: Karttaki Ad, Kart Numarası, CVC, Son Kullanma tarihi
        //17. Click 'Pay and Confirm Order' button - Öde ve Siparişi Onayla' düğmesine tıklayın
        //18. Verify success message 'Your order has been placed successfully!' - Başarı mesajını doğrulayın 'Siparişiniz başarıyla verildi!'
        //19. Click 'Delete Account' button - 'Hesabı Sil' düğmesini tıklayın
        //20. Verify 'ACCOUNT DELETED!' and click 'Continue' button - 'HESAP SİLİNDİ!' seçeneğini doğrulayın. ve 'Devam' düğmesini tıklayın
    }
}
