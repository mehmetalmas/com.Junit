package s01_automationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class TestCase1 {



    /*
    RegisterUser

    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Signup / Login' button
    5. Verify 'New User Signup!' is visible
    6. Enter name and email address
    7. Click 'Signup' button
    8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
    9. Fill details: Title, Name, Email, Password, Date of birth
    10. Select checkbox 'Sign up for our newsletter!'
    11. Select checkbox 'Receive special offers from our partners!'
    12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    13. Click 'Create Account button'
    14. Verify that 'ACCOUNT CREATED!' is visible
    15. Click 'Continue' button
    16. Verify that 'Logged in as username' is visible
    17. Click 'Delete Account' button
    18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
     */


    // 1. Launch browser
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @Test
        public void automation() throws InterruptedException {

        //  2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
        WebElement homepageGörünme= driver.findElement(By.xpath("//i[@class='fa fa-home']"));
        Assert.assertTrue(homepageGörünme.isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //5. Verify 'New User Signup!' is visible
        WebElement newUserSignupElementiGörünme= driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        Assert.assertTrue(newUserSignupElementiGörünme.isDisplayed());
        Thread.sleep(1000);

        //6. Enter name and email address
        WebElement nameElementi= driver.findElement(By.xpath("//input[@placeholder='Name']"));
        nameElementi.sendKeys("Ilhan");
        WebElement eMailElementi= driver.findElement(By.xpath("(//input[@placeholder='Email Address'])[2]"));
        eMailElementi.sendKeys("ikskots@gmail.com");
        eMailElementi.sendKeys(Keys.PAGE_DOWN);
        Thread.sleep(1000);

        //7. Click 'Signup' button
        driver.findElement(By.xpath("(//button[@class='btn btn-default'])[2]")).click();
        Thread.sleep(2000);

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccountGörünürElementi=driver.findElement(By.xpath("(//h2[@class='title text-center'])[1]"));
        Assert.assertTrue(enterAccountGörünürElementi.isDisplayed());
        Thread.sleep(2000);

        //9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
        WebElement passwordElementi= driver.findElement(By.xpath("//input[@id='password']"));
        passwordElementi.sendKeys("123456");
        Thread.sleep(2000);

        WebElement birtDayElementi=driver.findElement(By.xpath("//select[@data-qa='days']"));
        Select select=new Select(birtDayElementi);
        select.selectByValue("1");
        Thread.sleep(1000);

        WebElement birtMonthElementi=driver.findElement(By.xpath("//select[@id='months']"));
        Select select1=new Select(birtMonthElementi);
        select1.selectByValue("3");
        Thread.sleep(1000);

        WebElement birtYearElementi=driver.findElement(By.xpath("(//select[@id='years'])[1]"));
        Select select2=new Select(birtYearElementi);
        Thread.sleep(3000);


        //10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("(//input[@id='newsletter'])[1]")).click();
        Thread.sleep(5000);

        // 11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//input[@id='optin']")).click();
        Thread.sleep(3000);

        // 12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        WebElement firstnameElementi= driver.findElement(By.xpath("//input[@id='first_name']"));
        firstnameElementi.sendKeys("Mehmet");
        Thread.sleep(1000);

        WebElement lastnameElementi= driver.findElement(By.xpath("//input[@id='last_name']"));
        lastnameElementi.sendKeys("Almas");
        Thread.sleep(1000);

        WebElement companyElementi= driver.findElement(By.xpath("//input[@id='company']"));
        companyElementi.sendKeys("Ma Tasarim Grafik");
        Thread.sleep(2000);

        WebElement adresElementi1= driver.findElement(By.xpath("//input[@id='address1']"));
        adresElementi1.sendKeys("Deuchland/ Word");
        Thread.sleep(2000);

        WebElement adresElementi2= driver.findElement(By.xpath("//input[@id='address2']"));
        adresElementi2.sendKeys("Augsburg/Deuchland");
        Thread.sleep(2000);

        WebElement countryElementi= driver.findElement(By.xpath("//select[@id='country']"));
        Select select4=new Select(countryElementi);
        select4.selectByValue("Canada");
        Thread.sleep(2000);

        WebElement stateElementi= driver.findElement(By.xpath("//input[@id='state']"));
        stateElementi.sendKeys("Hessen");
        Thread.sleep(2000);

        WebElement cityElementi= driver.findElement(By.xpath("//input[@id='city']"));
        cityElementi.sendKeys("Frankfurt");
        Thread.sleep(2000);

        WebElement zipCodeElementi= driver.findElement(By.xpath("//input[@id='zipcode']"));
        zipCodeElementi.sendKeys("60123");
        Thread.sleep(2000);

        WebElement mobilNummerElementi= driver.findElement(By.xpath("//input[@id='mobile_number']"));
        mobilNummerElementi.sendKeys("+49123456789");
        Thread.sleep(2000);


        //13. Click 'Create Account button'
        WebElement createAccountButonu=driver.findElement(By.xpath("//button[@data-qa='create-account']"));
        createAccountButonu.click();
        Thread.sleep(2000);


        //14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement accountCreatedElementi=driver.findElement(By.xpath(" //*[@id=\"form\"]/div/div/div/h2/b "));
        Assert.assertTrue(accountCreatedElementi.isDisplayed());
        Thread.sleep(2000);

        //15. Click 'Continue' button
        WebElement continueButonu=driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
        continueButonu.click();
        Thread.sleep(2000);

        //16. Verify that 'Logged in as username' is visible
        driver.findElement(By.xpath("//i[@class='fa fa-user']")).isDisplayed();

        //17. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
        Thread.sleep(2000);

        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
    }
    @After
        public void teardown(){
         driver.close();
    }


}
