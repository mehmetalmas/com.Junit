package s03_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P03 {
        /*
            ...Exercise3...
            go to url : https://www.techlistic.com/p/selenium-practice-form.html
            fill the firstname
            fill the lastname
            check the gender
            check the experience
            fill the date
            choose your profession -> Automation Tester
            choose your tool -> Selenium Webdriver
            choose your continent -> Europa
            choose your command  -> Browser Commands
            click submit button
     */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

        driver.manage().deleteAllCookies();

        driver.findElement(By.xpath("//button[@id='ez-accept-all']")).click(); // Cikan pencereyi asmak icin

        driver.findElement(By.xpath("//a[@id='cookieChoiceDismiss']")).click();

        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Nevzat"+ Keys.ENTER);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Celik" + Keys.ENTER);
        Thread.sleep(1000);

        WebElement genderRadioButton = driver.findElement(By.xpath("//input[@id='sex-0']")); // Gender
        genderRadioButton.click();
        Thread.sleep(1000);
        genderRadioButton.sendKeys(Keys.PAGE_DOWN);

        driver.findElement(By.xpath("//input[@id='exp-2']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("12.02.2023"+ Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='profession-1']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='tool-2']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//select[@class='input-xlarge']")).sendKeys("Europe"+ Keys.ENTER+ Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//select[@id='selenium_commands']")).sendKeys("Browser Commands"+ Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
        Thread.sleep(1000);

        driver.close();
    }
}
