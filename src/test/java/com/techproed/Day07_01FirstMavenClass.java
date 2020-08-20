package com.techproed;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day07_01FirstMavenClass {
    public static void main(String[] args) {
      //Driver i baslatmak icin   System.setProperty("",""); bunu Java projelerinde kullaniyoruz
        //Bunun yerine maven projesinde WebDriverManager  kullanacagiz
        //chrome driver icin;
        WebDriverManager.chromedriver().setup();//kirmizi olmasinin sebebi eksik dependencies lerin olmasindandir
        //dependencies ler nereden alinir?? https://mvnrepository.com/ git ve WebDriverManager ara

        WebDriver driver = new ChromeDriver();  // https://mvnrepository.com/ git ve selenium java ara
        driver.get("https://www.google.com");

        //Fake data nasil olusturulur?
        //Fake data olusturmak icin "JavaFaker" denilen bir dependency gerekir.
        // https://mvnrepository.com/ git JavaFaker ara ilki kopy
        //Önce locate ediyoruz
        WebElement searchBox = driver.findElement(By.name("q"));

        //Faker objesini olusturduk
        Faker faker = new Faker();
        //Searchboxa fake data gönder ve ENTER tusuna bas
        //searchBox.sendKeys(faker.country().capital()+ Keys.ENTER);//submit de olurdu veya Keys.ENTER yazilir
       // searchBox.sendKeys(faker.address().fullAddress()+Keys.ENTER);
        //searchBox.sendKeys(faker.name().fullName()+Keys.ENTER);
       // searchBox.sendKeys(faker.country().flag());
        //searchBox.submit();


        System.out.println(faker.country().capital());//Roseau cikti rastgele sadece consolda yaziyor.Google ye yukarda gönderelim




    }
}
