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

public class Day09Tekrar_BeforeAfter_BestBuy {
    /*
    ● Bir class oluşturun: Tekrar_BeforeAfter_BestBuy
● Ardından aşağıdaki adları kullanarak 3 test metodu oluşturun
  https://www.bestbuy.com/
  ○ titleTest => Sayfa başlığının "Best" içerdiğini(contains) doğrulayın
  ○ logoTest => BestBuy logosunun görüntülenip görüntülenmediğini doğrulayın
  ○ mexicoLinkTest => Linkin görüntülenip görüntülenmediğini doğrulayın
● Her testten sonra tarayıcıyı kapatin
● @Before ve @After metotlarini kullanarak yapalim.
     */
    WebDriver driver;
    @Before
    public  void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.bestbuy.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void titieTest(){
        String actualTitle= driver.getTitle();
        String expectedTitle="Best";

        if (actualTitle.contains(expectedTitle)){
            System.out.println("PASS");

        }else {
            System.out.println("FAIL");

        }

        Assert.assertTrue(actualTitle.contains(expectedTitle));  //buda olbilirdi

    }
    @Test
    public void logoTest(){
        WebElement bestBuyLogo=driver.findElement(By.className("logo"));
        Assert.assertTrue(bestBuyLogo.isDisplayed());
    }
    @Test
    public void linkTest(){
        WebElement link = driver.findElement(By.linkText("Mexico"));
        if (link.isDisplayed()){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        Assert.assertTrue(link.isDisplayed());////buda olbilirdi

    }
    @After
    public void tearDown(){
        driver.close();
    }

}
