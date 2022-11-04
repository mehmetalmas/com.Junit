package ders13_excel_screenshot_isExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C03_Screenshot extends TestBase {

    @Test
    public void test01() throws IOException {

        driver.get("https://www.amazon.com");

        tumSayfaResimCek();
        bekle(1);

        driver.get("https://www.youtube.com");
        tumSayfaResimCek();
    }





}
