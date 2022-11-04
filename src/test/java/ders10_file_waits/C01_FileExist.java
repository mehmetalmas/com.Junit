package ders10_file_waits;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileExist {

    @Test
    public void test01(){

        System.out.println(System.getProperty("user.dir"));
        // C:\Users\Seyma\IdeaProjects\JUnitInt (benim bilgisayarin calistigim bu dosyanin yolu)
            // C:\Users\ffyil\Desktop\JUnitInt ( baska bilgisayarlardan örnekler )
            // C:\Users\Notebook\Desktop\TESTER\JUnuitInt ( baska bilgisayarlardan örnekler )
            // C:\Users\toshiba\IdeaProjects\Junit ( baska bilgisayarlardan örnekler )

        System.out.println(System.getProperty("user.home")); // C:\Users\Seyma

        // masa ustunde olusturdugumuz txt file'in path'i
        // "C:\Users\Seyma\Desktop\FileTesti\deneme.txt"(masa üzerinde olusturgum dosyanin yolu)
        // "C:\Users\Seyma\Downloads (Downloads dosya yolu)

        /*
              System.getProperty("user.home") tum bilgisayarlarda
              kullaniciya kadar olan path'i verir
              ve bu kisim her bilgisayar ve her kullanici icin farklidir
              user.home'dan sonrasi tum kullanicilar ortak olabilir
              ornegin tum kullanicilarin masaustu
              user.home / Desktop
              downloads %90 kullanici icin
              user.home / Downloads
              eger birden fazla bilgisayarda file ile ilgili bir test yapacaksaniz
              dosya yolunu dinamik olarak olusturmaniz gerekir
         */

        // dinamik dosya yolu olusturma
        // masa ustunde FileTesti diye bir klasor ve onun altinda deneme diye bir text dosyasi icin



        String dosyaYolu= System.getProperty("user.home") + "\\Desktop\\FileTesti\\deneme.txt";
        System.out.println(dosyaYolu);
        System.out.println(Files.exists(Paths.get(dosyaYolu))); // true veya false


    }
}
