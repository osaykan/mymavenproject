package tekrarmaven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day02BeforeAfterMethods1 {
        // Bir class oluşturun: BeforeAfterMethods
        // Ardından aşağıdaki adları kullanarak 3 test metodu oluşturun
        // titleTest => Sayfa başlığının “Google” oldugunu doğrulayın
        // imageTest => Google resminin görüntülenip görüntülenmediğini(isDisplayed()) doğrulayın
        // gmailLinkTest => "Gmail" linkinin görüntülenip görüntülenmediğini (isDisplayed()) doğrulayın
       // Her testten sonra tarayıcıyı kapatin
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("http://www.google.com");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

    }
    @Test
    public void titleTest(){
        String actualTitle = driver.getTitle();
        String expectedTitle="Google";
        if (actualTitle.equals(expectedTitle)){
            System.out.println("PASS");

        }else {
            System.out.println("FAIL");
        }
    }

    @Test
    public void imageTest(){
        WebElement image =driver.findElement(By.id("hplogo"));
        if (image.isDisplayed()){
            System.out.println("PASS");

        }else {
            System.out.println("FAIL");
        }
    }
    @Test
    public void linkTest(){
        WebElement link =driver.findElement(By.linkText("Gmail"));
        if (link.isDisplayed()){
            System.out.println("PASS");

        }else {
            System.out.println("FAIL");
        }
    }
    @After
    public void close(){
        driver.close();
    }

}
