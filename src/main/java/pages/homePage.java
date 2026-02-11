package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class homePage {
    WebDriver driver;
    WebDriverWait wait;

    // Locators for the Amazon homepage pop-ups and elements
    By deliverToButton = By.id("nav-global-location-popover-link");
    By allMenuButton = By.id("nav-hamburger-menu");
    By acceptCookiesButton = By.id("sp-cc-accept");  // Cookie consent button
    By modalCloseButton = By.cssSelector(".modal-close-button"); // Modal close button
    By locationToggle = By.id("location-toggle");  // The pop-up toggle's ID (This is just an example; you'll need to confirm the exact locator)
    By dismissLocationButton = By.id("dismiss-location-button"); // Dismiss button for location toggle

    public homePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Open Amazon homepage
    public void openAmazon() {
        driver.get("https://www.amazon.com/");
    }

    // Handle alert pop-ups (JavaScript alerts, confirm boxes, prompts)
    public void handleAlert() {
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();  // Accept the alert (click OK)
            System.out.println("Alert handled");
        } catch (Exception e) {
            System.out.println("No alert present");
        }
    }

    // Close modal pop-ups (like login or promotional modals)
    public void closeModal() {
        try {
            WebElement modalCloseBtn = wait.until(ExpectedConditions.elementToBeClickable(modalCloseButton));
            modalCloseBtn.click();  // Click the modal close button
            System.out.println("Modal closed");
        } catch (Exception e) {
            System.out.println("No modal present");
        }
    }

    // Accept cookie consent pop-ups or any overlay pop-up
    public void acceptCookieConsent() {
        try {
            WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesButton));
            acceptButton.click();  // Accept the cookies
            System.out.println("Cookie consent handled");
        } catch (Exception e) {
            System.out.println("No cookie consent banner found");
        }
    }

    // Dismiss location toggle if it's visible
    public void dismissLocationToggle() {
        try {
            // Wait for the location toggle to be visible, if it's present
            WebElement locationToggleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locationToggle));
            if (locationToggleElement.isDisplayed()) {
                WebElement dismissButton = driver.findElement(dismissLocationButton);
                dismissButton.click();  // Click the dismiss button on the toggle
                System.out.println("Location toggle dismissed");
            }
        } catch (Exception e) {
            System.out.println("No location toggle found");
        }
    }

    // Handle any pop-up that might appear on the page (alert, modal, cookies, location toggle, etc.)
    public void handlePopUps() {
        handleAlert();  // Handle JavaScript alerts
        closeModal();   // Close any modals that appear
        acceptCookieConsent();  // Accept cookies if the banner appears
        dismissLocationToggle();  // Dismiss the location toggle if present
    }

    // Click on the delivery address button
    public void clickDeliveryAddress() {
        // Wait for the "Deliver To" button to be clickable before clicking
        WebElement deliverToBtn = wait.until(ExpectedConditions.elementToBeClickable(deliverToButton));
        deliverToBtn.click();
    }

    // Open the "All" menu (hamburger menu)
    public void openAllMenu() {
        // Re-locate and wait for the hamburger menu to be clickable after page changes
        WebElement menuBtn = wait.until(ExpectedConditions.elementToBeClickable(allMenuButton));
        menuBtn.click();
    }

    // Get the delivery location text
    public String getDeliveryLocationText() {
        // Wait for the delivery location text to be visible
        WebElement locationText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("glow-ingress-line2")));
        return locationText.getText();
    }
}
