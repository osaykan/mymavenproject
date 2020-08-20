package tekrarmaven;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01FirstMavenClass1 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.youtube.com");

        WebElement searchBox =driver.findElement(By.xpath("//input[@name='search_query']"));

        Faker faker= new Faker();
        searchBox.sendKeys(faker.ancient().hero()+ Keys.ENTER);





    }


}
