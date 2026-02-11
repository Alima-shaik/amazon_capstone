package pages;
import org.openqa.selenium.WebDriver;

	public class KindlePage {
	    WebDriver driver;

	    public KindlePage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void navigateBackToHome() {
	        driver.navigate().back();
	        driver.navigate().back(); // back twice to reach homepage
	    }

	    public void closeBrowser() {
	        driver.quit();
	    }
	}

