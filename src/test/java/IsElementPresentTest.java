import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.Assert.*;

@ExtendWith(SeleniumExtension.class)
public class IsElementPresentTest {
    
    private ChromeDriver driver;
    
    public IsElementPresentTest(ChromeDriver driver){
        this.driver=driver;
    }
    
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
    public void testPresentButton(){
        assertTrue(isElementPresent(By.id("search_button_homepage")));
    }
    
    @Test
    public void testSearchInput(){
        assertTrue(isElementPresent(By.xpath("//*[@id=\"search_form_input_homepage\"]")));
    }
    
    @Test
    public void testNotExistingElement(){
        assertFalse(isElementPresent(By.xpath("sddsfsd")));
    }
    
    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch ( Exception e ) {
            return false;
        }
    }
    
    
}
