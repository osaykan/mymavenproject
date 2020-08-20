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
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Day09DropDown {
    //Bir class oluşturun: DropDown
    //https://the-internet.herokuapp.com/dropdown adresine gidin.

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");

    }
    @Test
    public void dropdownTest(){
        //Dropdown icin Select class'i kullanilir.
        //Dropdown'u id ile locate edelim
        WebElement selectElement = driver.findElement(By.id("dropdown"));
        //Select classinda option objesini olusturduk
        Select options = new Select(selectElement);
        //getFirstSelectedOption()==> dropdown daki default value i verir.
        String firstOption=options.getFirstSelectedOption().getText();
        System.out.println(firstOption);     //Please select an option
        //Dropdown da elementleri belirlemenin 3 yolu var
        //1.Index ile==> selectByIndex()  2. BY Value ile==> selectByValue(" ")
        // 3.Visible text ile yazi ile==> selectByVisibleTex(" ")

        //1.Index kullanarak Seçenek 1’i (Option 1) seçin
        options.selectByIndex(1);

        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        options.selectByValue("2");

        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        options.selectByVisibleText("Option 1");

        //4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> allOptions = options.getOptions();

        for (WebElement element:allOptions){ System.out.println(element.getText()); }

        //5. Dropdown’un boyutunu(size) bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
        int boyut= allOptions.size();
        System.out.println("Element Sayisi : "+boyut);

      //  Assert.assertTrue(boyut==4);  //fail
            Assert.assertFalse(boyut==4);

            

    }



    @After
    public void tearDown(){
        driver.close();
    }


}
