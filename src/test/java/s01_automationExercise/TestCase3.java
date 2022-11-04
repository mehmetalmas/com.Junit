package s01_automationExercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestCase3 extends TestBase2 {

    //LoginUserWithIncorrectEmailAndPassword

    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Signup / Login' button
    5. Verify 'Login to your account' is visible
    6. Enter incorrect email address and password
    7. Click 'login' button
    8. Verify error 'Your email or password is incorrect!' is visible
     */

    @Test
    public void test01_homePageIsVisible(){

        //2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        //String expectedUrl="http://automationexercise.com";
        //String actualUrl= driver.getCurrentUrl();
        //System.out.println(actualUrl);
        //Assert.assertEquals(expectedUrl,actualUrl);
        WebElement homePageIsVisible= driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(homePageIsVisible.isDisplayed());


    }
    @Test
    public void test02_LoginToYourAccountIsVisible(){

        //4. Click on 'Signup / Login' button

        WebElement signUpButton= driver.findElement(By.xpath("//a[@href='/login']"));
        signUpButton.click();

        //5. Verify 'Login to your account' is visible
        WebElement loginToYourAccount= driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(loginToYourAccount.isDisplayed());


    }
    @Test
    public void test03_incorrectEmailPassword(){

        //6. Enter incorrect email address and password
        WebElement incorrectEmail= driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        incorrectEmail.sendKeys("seher@g.com");
        WebElement incorrectPassword= driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        incorrectPassword.sendKeys("1234");

        //7. Click 'login' button
        WebElement clickLogin=driver.findElement(By.xpath("//button[@data-qa='login-button']"));
        clickLogin.click();

        //8. Verify error 'Your email or password is incorrect!' is visible
        driver.findElement(By.xpath("//p[text()='Your email or password is incorrect!']")).isDisplayed();
        //Assert.assertTrue(incorrectEmailPassword.isDisplayed());


    }

}
