import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;


@ExtendWith(SeleniumExtension.class)
public class WaitTest {
    
    private ChromeDriver driver;
    
    public WaitTest(ChromeDriver driver) {
        this.driver = driver;
    }
    
    @BeforeEach
    public void setDefaultPage() {
        driver.get("https://duckduckgo.com/");
    }
    
    
    @Test
    public void testElementToBeClickable() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("search_form_input_homepage")));
        driver.findElement(By.id("search_form_input_homepage")).sendKeys("Selenium" + Keys.ENTER);
        wait.until(ExpectedConditions.titleContains("Selenium"));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"r1-0\"]/div/h2/a[1]")));
        assertTrue(element.isDisplayed());
    }
    
    
    @Test
    public void testTitleContains() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search_form_input_homepage")));
        driver.findElement(By.id("search_form_input_homepage")).sendKeys("Selenium" + Keys.ENTER);
        boolean result = wait.until(ExpectedConditions.titleContains("Selenium"));
        assertEquals(true,result);
    }
    
    @Test
    public void testElementToBeSelected(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        Assertions.assertThrows(TimeoutException.class, () ->
                wait.until(ExpectedConditions.elementToBeSelected(By.linkText("asdad"))));
    }
    
    @Test
    public void testPresenceOfElementLocated(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search_form_input_homepage")));
        assertTrue(element.isDisplayed());
    }
    
    @Test
    public void testTextToBePresentInElement() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"content_homepage\"]/div[2]/div/div/h1")));
        boolean result=wait.until(ExpectedConditions.textToBePresentInElement(element,"Prywatność — jeszcze prostsza."));
        assertTrue(result);
    }
    
    @Test
    public void testTextToBePresentInElementValue() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search_form_input_homepage")));
        driver.findElement(By.id("search_form_input_homepage")).sendKeys("Selenium");
        WebElement element=driver.findElement(By.id("search_form_input_homepage"));
        boolean result=wait.until(ExpectedConditions.textToBePresentInElementValue(element,"Selenium"));
        assertTrue(result);
    }

}
