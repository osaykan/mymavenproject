package gurbetriview;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day07FirstMavenClass {
    public static void main(String[] args) throws InterruptedException {
        //Driver i baslatmak icin   System.setProperty("",""); bunu Java projelerinde kullaniyoruz
        //Bunun yerine maven projesinde WebDriverManager  kullanacagiz
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com");
        //Fake data nasil olusturulur?
        //Fake data olusturmak icin "JavaFaker" denilen bir dependency gerekir.
        // https://mvnrepository.com/ git JavaFaker ara ilki kopy
        //Önce locate ediyoruz
        WebElement searchBox=driver.findElement(By.name("q"));
        Faker faker=new Faker();
       // searchBox.sendKeys(faker.country().capital()+ Keys.ENTER);
        //Thread.sleep(3000);
        //searchBox.sendKeys(faker.name().fullName()+Keys.ENTER);
        //searchBox.sendKeys(faker.animal().name()+Keys.ENTER);
       // WebElement submitButton=driver.findElement(By.name("btnK"));
        searchBox.sendKeys(faker.artist().name());
        searchBox.submit();
      // submitButton.click();


    }
}
