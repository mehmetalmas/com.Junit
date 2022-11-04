package s01_automationExercise;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestCase2 extends TestBase2 {

    /*
    LoginUserWithCorrectEmailAndPassword

    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Signup / Login' button
    5. Verify 'Login to your account' is visible
    6. Enter correct email address and password
    7. Click 'login' button
    8. Verify that 'Logged in as username' is visible
    9. Click 'Delete Account' button
    10. Verify that 'ACCOUNT DELETED!' is visible
     */

    @Test
    public  void test01_Url() throws InterruptedException {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement homePageIsVisible= driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(homePageIsVisible.isDisplayed());
        //4. Click on 'Signup / Login' button
        WebElement singupButton= driver.findElement(By.xpath("//a[@href='/login']"));
        singupButton.click();
        //5. Verify 'Login to your account' is visible
        WebElement loginTextVerify= driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(loginTextVerify.isDisplayed());
        //6. Enter correct email address and password
        WebElement email= driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        email.sendKeys("ilhhh@fff.gmail.com");
        Thread.sleep(3000);
        WebElement password= driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        password.sendKeys("123456");
        Thread.sleep(5000);
        //7. Click 'login' button
        WebElement loginClick= driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
        loginClick.click();
        Thread.sleep(5000);
        System.out.println(driver);
    }
    @Test
    public void test02_User(){
        //8. Verify that 'Logged in as username' is visible
        System.out.println(driver);
        WebElement usernameIsVisible= driver.findElement(By.xpath("//i[@class='fa fa-user']"));
        Assert.assertTrue(usernameIsVisible.isDisplayed());
    }
}
