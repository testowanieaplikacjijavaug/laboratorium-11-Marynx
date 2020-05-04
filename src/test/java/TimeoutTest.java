import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SeleniumExtension.class)
public class TimeoutTest {
    
    private ChromeDriver driver;
    
    public TimeoutTest(ChromeDriver driver){
        this.driver=driver;
    }
    
    @BeforeEach
    public void setUp() throws Exception {
        driver.get("https://duckduckgo.com/");
    }
    
    //ograniczenie czasowe na ladowanie strony
    @Test
    public void testPageLoadTimeout() {
        driver.manage()
                .timeouts()
                .pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.findElement(By.id("search_form_input_homepage")).sendKeys("Selenium" + Keys.ENTER);
        assertEquals("Selenium at DuckDuckGo",driver.getTitle());
    }
    
    //ograniczenie czasowe na wykonanie skryptu
    @Test
    public void testSetScriptTimeout(){
        driver.manage()
                .timeouts()
                .setScriptTimeout(10, TimeUnit.SECONDS);
        driver.findElement(By.id("search_form_input_homepage")).sendKeys("Selenium" + Keys.ENTER);
        assertEquals("Selenium at DuckDuckGo",driver.getTitle());
    }
}
