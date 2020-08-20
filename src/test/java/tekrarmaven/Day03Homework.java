package tekrarmaven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day03Homework {
    // Create class : FaceDropdown
    // Create method : Birthday
    // https://www.facebook.com adresine gidin
    // Ay , gun ve yil dropdownlarindan istediginiz bir tarihi secin.
    // Tarayiciyi kapatin.

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void birthday() {
        WebElement dayElement = driver.findElement(By.id("day"));
        Select selectday = new Select(dayElement);
        selectday.selectByVisibleText("10");

        WebElement monthElement = driver.findElement(By.id("month"));
        Select selectmonth = new Select(monthElement);
        List<WebElement> allmonth = selectmonth.getOptions();
        for (WebElement element : allmonth) {
            System.out.print(element.getText() + " ");
            // selectmonth.selectByVisibleText("Okt");

        }

        WebElement yearElement = driver.findElement(By.id("year"));
        Select selectyear = new Select(yearElement);
        selectyear.selectByVisibleText("1977");

        WebElement vorname = driver.findElement(By.id("u_0_o"));
        vorname.sendKeys("Osman");

        WebElement nachname = driver.findElement(By.id("u_0_q"));
        nachname.sendKeys("Aykan");

        WebElement mail = driver.findElement(By.id("u_0_t"));
        mail.sendKeys("osmanaykan34@gmail.com");

        WebElement manlich = driver.findElement(By.id("u_0_7"));
        manlich.click();
    }


      @Test
      public void tearDown(){
        driver.close();
   }
}