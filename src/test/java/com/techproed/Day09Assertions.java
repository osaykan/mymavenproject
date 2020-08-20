package com.techproed;

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

public class Day09Assertions {

    //    // Ardından aşağıdaki adları kullanarak 3 test metodu oluşturun
    //    // titleTest => Sayfa başlığının “Google” oldugunu assertion kullanarak doğrulayın
    //    // imageTest => Google resminin görüntülenip görüntülenmediğini(isDisplayed()) assertion kullanarak doğrulayın
    //    // gmailLinkTest => "Gmail" linkinin görüntülenip görüntülenmediğini (isDisplayed()) assertion kullanarak doğrulayın
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
    //    if (actualTitle.equals(expectedTitle)) {
      //      System.out.println("PASS");
      //  } else {
       //     System.out.println("FAIL");
       // }
        //Assert class'i JUnit ten gelir.
        //assertEquals() iki tane sitringi alir ve birbirine esit olup olmadigini kontrol eder

        Assert.assertEquals(expectedTitle,actualTitle);    //consolda birsey yok ama yanda yesil tik var.
                                                          // eger FAIL olsaydi expected ve actual consolda yazilir.

    }

    @Test
    public void imageTest() {


        WebElement googleImage = driver.findElement(By.id("hplogo"));
     /*   if (googleImage.isDisplayed()) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
       */
        Assert.assertTrue(googleImage.isDisplayed());  //parantez ici true ise Test Pass olur, false ise Fail olur
      //                                                  //assertTrue kullandigimizda neticenin True olmasini bekliyoruz
      //  Assert.assertFalse(googleImage.isDisplayed());  //parantez ici false ise test Pass, true ise test Fail olur
                                                          //assertFalse kullandigimizda neticenin False olmasini bekliyoruz
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
