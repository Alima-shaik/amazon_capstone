/*package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeliveryAddressPage {
	
	    WebDriver driver;

	    public DeliveryAddressPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void changeLocationToIndia() {
	    	 WebElement countryDropdown = driver.findElement(By.xpath("//div[@id='GLUXCountryListDropdown']//select"));
	 	    countryDropdown.click();
	 	 
	 	    driver.findElement(By.xpath("//option[text()='India']")).click();
	        WebElement applyButton = driver.findElement(By.xpath("//div[@name='glowDoneButton']"));
		    applyButton.click();

	    }

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DeliveryAddressPage {
    WebDriver driver;
    WebDriverWait wait;

    By countryDropdown = By.id("GLUXCountryList");
    By applyButton = By.name("glowDoneButton");

    public DeliveryAddressPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void changeLocationToIndia() {
        // Wait for dropdown to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(countryDropdown));
        driver.findElement(countryDropdown).click();

        // Select India from dropdown
        driver.findElement(By.xpath("//option[text()='India']")).click();

        // Click Apply/Done
        driver.findElement(applyButton).click();
    }
}
*/package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;

public class DeliveryAddressPage {
    WebDriver driver;
    WebDriverWait wait;

    By countryDropdown = By.id("GLUXCountryList");
    By applyButton = By.name("glowDoneButton");

    public DeliveryAddressPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void changeLocationToIndia() {
        // Wait until dropdown is present
        wait.until(ExpectedConditions.presenceOfElementLocated(countryDropdown));

        // Use Select class instead of click
        Select countrySelect = new Select(driver.findElement(countryDropdown));
        countrySelect.selectByVisibleText("India");

        // Wait for Apply button and click
        wait.until(ExpectedConditions.elementToBeClickable(applyButton));
        driver.findElement(applyButton).click();
    }
}


