import com.machinepublishers.jbrowserdriver.JBrowserDriver;
import com.machinepublishers.jbrowserdriver.Settings;
import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SeleniumExtension.class)
public class JBrowserTest {
    
    private JBrowserDriver driver=new JBrowserDriver(Settings.builder().build());
    
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
