/* package pages;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;

	public class MenuPage {
	    WebDriver driver;

	    By kindleReadersAndBooks = By.xpath("//div[text()='Kindle E-readers & Books']");
	    By kindleBooks = By.xpath("//a[text()='Kindle Books']");

	    public MenuPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void navigateToKindleReadersAndBooks() {
	        driver.findElement(kindleReadersAndBooks).click();
	    }

	    public void navigateToKindleBooks() {
	        driver.findElement(kindleBooks).click();
	    }
	}
package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MenuPage {
    WebDriver driver;

    By kindleReadersAndBooks = By.xpath("//div[text()='Kindle E-readers & Books']");
    By kindleBooks = By.xpath("//a[text()='Kindle Books']");

    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }

    private void waitForElementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void navigateToKindleReadersAndBooks() {
        waitForElementToBeClickable(kindleReadersAndBooks);
        driver.findElement(kindleReadersAndBooks).click();
    }

    public void navigateToKindleBooks() {
        waitForElementToBeClickable(kindleBooks);
        driver.findElement(kindleBooks).click();
    }
} */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MenuPage {
    private WebDriver driver;

    // Locators
    private By kindleReadersAndBooks = By.xpath("//div[text()='Kindle E-readers & Books']");
    private By kindleBooks = By.xpath("//a[text()='Kindle Books']");

    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }

    // Wait until element is visible
    private WebElement waitForElementVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Navigate to Kindle Readers & Books section
    public void navigateToKindleReadersAndBooks() {
        WebElement section = waitForElementVisible(kindleReadersAndBooks);
        section.click();

        // Small pause for menu animation
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Navigate to Kindle Books link
    public void navigateToKindleBooks() {
        WebElement kindleBooksLink = waitForElementVisible(kindleBooks);

        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", kindleBooksLink);

        // Use JS click to avoid overlay interception
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", kindleBooksLink);

        // Alternative: Actions class if you prefer
        // Actions actions = new Actions(driver);
        // actions.moveToElement(kindleBooksLink).click().perform();
    }
}


