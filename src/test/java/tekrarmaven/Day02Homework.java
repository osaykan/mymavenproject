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

public class Day02Homework {
    //// Bir class oluşturun: Homework_BeforeAfterAirbnb
    //// Ardından aşağıdaki adları kullanarak 3 test metodu oluşturun
    //// titleTest => Sayfa başlığının "Airbnb" içerdiğini doğrulayın
    //// logoTest => Airbnb logosunun görüntülenip görüntülenmediğini doğrulayın
    //// helpLinkTest => "Help" linkinin görüntülenip görüntülenmediğini doğrulayın
    //// Her testten sonra tarayıcıyı kapatin

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("http://www.airbnb.com");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @Test
    public void titleTest(){
        String actualTitle=driver.getTitle();
        String ecpectedTitle="Airbnb";
        System.out.println("Actual Title : "+actualTitle);
        System.out.println("Expected Title : "+ecpectedTitle);
        if (actualTitle.contains("Airbnb")){
            System.out.println("PASS");

        }else {
            System.out.println("FAIR");
        }
    }
    @Test
    public void logoTest(){
        WebElement logoTest = driver.findElement(By.xpath("//a[@class='_gpuobnr']"));

        if (logoTest.isDisplayed()){
            System.out.println("Logo Test PASS");

        }else {
            System.out.println("FAIL");

        }
    }
        @Test
        public void helpLink(){
        WebElement helpLink = driver.findElement(By.id("field-guide-toggle"));
        if (helpLink.isDisplayed()){
            System.out.println("Help Link PASS");

        }else{
            System.out.println("HELP LINK FAIL");

        }
        }
        @After
    public void close(){
        driver.close();
        }
}
