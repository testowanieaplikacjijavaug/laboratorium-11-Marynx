import io.github.bonigarcia.seljup.SeleniumExtension;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SeleniumExtension.class)
public class ExpectedConditionTest {
    
    private ChromeDriver driver;
    
    public ExpectedConditionTest(ChromeDriver driver){
        this.driver=driver;
    }
    
    @BeforeEach
    public void setUp() throws Exception {
        driver.get("https://duckduckgo.com/");
    }
    
    @Test
    public void testWebElement() {
        try{
            driver.findElement(By.id("search_form_input_homepage")).sendKeys("Selenium" + Keys.ENTER);
            WebElement message = new WebDriverWait(driver, 5)
                    .until(new ExpectedCondition<WebElement>(){
                        @Override
                        public WebElement apply(WebDriver d){
                            return d.findElement(By.xpath("//*[@id=\"r1-0\"]/div/h2/a[1]"));
                        }
                    });
            assertEquals("Selenium",message.getText());
        } finally {
            driver.quit();
        }
    }
    
    @Test
    public void testBoolean() {
        try{
            driver.findElement(By.id("search_form_input_homepage")).sendKeys("Selenium" + Keys.ENTER);
            Boolean message = new WebDriverWait(driver, 5)
                    .until(new ExpectedCondition<Boolean>(){
                        @Override
                        public Boolean apply(WebDriver d){
                            return d.findElement(By.xpath("//*[@id=\"r1-0\"]/div/h2/a[1]")).isDisplayed();
                        }
                    });
            assertTrue(message);
        } finally {
            driver.quit();
        }
    }
    
    @Test
    public void testBoolean2() {
        try{
            driver.findElement(By.id("search_form_input_homepage")).sendKeys("Selenium" + Keys.ENTER);
            driver.findElement(By.xpath("//*[@id=\"r1-0\"]/div/h2/a[1]")).click();
            Boolean message = new WebDriverWait(driver, 5)
                    .until(new ExpectedCondition<Boolean>(){
                        @Override
                        public Boolean apply(WebDriver d){
                            return d.findElement(By.xpath("//*[@id=\"navbar\"]/a[1]")).isDisplayed();
                        }
                    });
            assertTrue(message);
        } finally {
            driver.quit();
        }
    }
}
