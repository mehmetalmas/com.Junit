package ders10_file_waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownloadTesti extends TestBase {

    @Test
    public void downloadTesti(){

        //1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        bekle(5);

        //3. 136525.png dosyasını indirelim
        driver.findElement(By.xpath("//a[@href='download/136525.png']")).click();
        bekle(5);



        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim
        bekle(5);
        String dosyaYolu= System.getProperty("user.home")+ "\\Downloads\\136525.png";

        // String dosyaYolu= "/Users/ahmetbulutluoz/Downloads/logo.png";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }


}
