import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class HtmlUnitTest {
    WebDriver driver = new HtmlUnitDriver();
    
    @BeforeEach
    public void setUp() throws Exception {
        driver.get("https://duckduckgo.com/");
    }
    
    @Test
    public void testTitlePage() {
        assertEquals("DuckDuckGo — Privacy, simplified.", driver.getTitle());
    }
    
    @Test
    public void testSource(){
        String source = driver.getPageSource();
        assertTrue(source.contains("DuckDuckGo"));
    }
    
    @Test
    public void testSearch(){
        driver.findElement(By.id("search_form_input_homepage")).sendKeys("Selenium" + Keys.ENTER);
        assertEquals("Selenium at DuckDuckGo",driver.getTitle());
    }
    
}
