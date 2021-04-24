package gurbetriview;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day08BeforeAfterMethods {
    /// Bir class oluşturun: BeforeAfterMethods
    //    // Ardından aşağıdaki adları kullanarak 3 test metodu oluşturun
    //    // titleTest => Sayfa başlığının “Google” oldugunu doğrulayın
    //    // imageTest => Google resminin görüntülenip görüntülenmediğini(isDisplayed()) doğrulayın
    //    // gmailLinkTest => "Gmail" linkinin görüntülenip görüntülenmediğini (isDisplayed()) doğrulayın
    //    // Her testten sonra tarayıcıyı kapatin
    WebDriver driver;

    @Before
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com");

        //Yavas web siteleri icin implicitly kullanilabilir bekletmek icin
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//10 sn bekleyecek

    }


    @Test
    public void titleTest() {


        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
      /*  if (actualTitle.equals(expectedTitle)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
    */

        Assert.assertEquals(actualTitle,expectedTitle);

    }

    @Test
    public void imageTest() {


        WebElement googleImage = driver.findElement(By.id("hplogo"));
    /*    if (googleImage.isDisplayed()) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
    */
        Assert.assertTrue(googleImage.isDisplayed());

    }

    @Test
    public void gmailLinkTest() {


        WebElement gmailLink = driver.findElement(By.linkText("Gmail"));

     /*   if (gmailLink.isDisplayed()) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        */
        Assert.assertTrue(gmailLink.isDisplayed());

    }

    @After     //@After annotation'i genellikle  tarayiciyi kapatmak icin kullanilir.

    public void tearDown() {
        driver.close();
    }

}
