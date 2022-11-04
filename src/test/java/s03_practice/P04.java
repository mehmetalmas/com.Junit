package s03_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P04 {
        /*
            ...Exercise4...
            Navigate to  https://testpages.herokuapp.com/styled/index.html
            Click on  Calculater under Micro Apps
            Type any number in the first input
            Type any number in the second input
            Click on Calculate
            Get the result
            Print the result

       */

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        driver.findElement(By.xpath("//a[@id='calculatetest']")).click();
        Thread.sleep(1000);
        WebElement simpleCalculatorYazisi = driver.findElement(By.xpath("//h1[text()='Simple Calculator']"));

        if (simpleCalculatorYazisi.isDisplayed()) System.out.println("Test Passed");
        else System.out.println("Test Failed");

        driver.findElement(By.xpath("//input[@id='number1']")).sendKeys("25");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='number2']")).sendKeys("15");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='calculate']")).click();
        Thread.sleep(1000);

        WebElement answerElementi1 = driver.findElement(By.xpath("//span[@id='answer']"));
        System.out.println("Sonuc : " + answerElementi1.getText());

        //**************2. Yontem**********************
        String answerElementi2 = driver.findElement(By.xpath("//span[@id='answer']")).getText();

        //**************3. Yontem**********************
        int answerElementi3 = Integer.parseInt((driver.findElement(By.xpath("//span[@id='answer']")).getText()));
        System.out.println("Sonuc : " + answerElementi3);
    }
}
