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
    /*   ● Bir class oluşturun: DropDown
● https://the-internet.herokuapp.com/dropdown adresine gidin.
● 1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
● 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
● 3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
● 4.Tüm dropdown değerleri(value) yazdırın
● 5. Dropdown'un boyutunu bulun, Dropdown'da 4 öğe varsa konsolda True , degilse False yazdırın.
   */
        WebElement selectElement = driver.findElement(By.id("dropdown"));
        Select options = new Select(selectElement);
       String firstoption= options.getFirstSelectedOption().getText();



       options.selectByIndex(1);
        options.selectByValue("2");
        options.selectByVisibleText("Option 1");
        List<WebElement> allOptions = options.getOptions();

        for (WebElement element:allOptions){ System.out.println(element.getText()); }
        int boyut= allOptions.size();
        System.out.println("Element Sayisi : "+boyut);


    }



    @After
    public void tearDown(){
       // driver.close();
    }

}
