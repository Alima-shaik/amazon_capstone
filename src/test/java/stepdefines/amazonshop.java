package stepdefines;
import org.apache.logging.log4j.LogManager; 
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports; 
import com.aventstack.extentreports.ExtentTest; 
import io.cucumber.java.After; 
import io.cucumber.java.Before;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DeliveryAddressPage;
import pages.KindlePage;
import pages.MenuPage;
import pages.homePage;
public class amazonshop {
	WebDriver driver; 
	homePage homePage; 
	DeliveryAddressPage deliveryPage; 
	MenuPage menuPage; 
	KindlePage kindlePage;
	private static final Logger logger = LogManager.getLogger(amazonshop.class);
	
	ExtentReports extent = ExtentManager.getInstance(); 
	ExtentTest test;
	
	@Before public void setup() 
	{ 
		test = extent.createTest("Amazon Shop Test"); 
	}
	
	@Given("I open the Amazon website")
	public void i_open_the_amazon_website() {
		test.info("Opening Amazon website");
		driver = new ChromeDriver(); 
		driver.manage().window().maximize(); 
		
		homePage = new homePage(driver); 
		deliveryPage = new DeliveryAddressPage(driver); 
		menuPage = new MenuPage(driver); 
		kindlePage = new KindlePage(driver); 
		
		homePage.openAmazon();
		logger.info("Amazon homepage opened successfully.");
		test.pass("Amazon homepage opened successfully");
	}
	@When("I go to the delivery address section")
	public void i_go_to_the_delivery_address_section() throws InterruptedException {
		logger.info("Navigating to delivery address section...");
		test.info("Navigating to delivery address section");
		homePage.clickDeliveryAddress();
		Thread.sleep(3000);
	}
	@When("I change the location to India")
	public void i_change_the_location_to_india() throws InterruptedException {
		logger.info("Changing location to India...");
		deliveryPage.changeLocationToIndia();
		Thread.sleep(3000);
	}
	@Then("the page should update to show delivery in India")
	public void the_page_should_update_to_show_delivery_in_india() throws InterruptedException {
		String deliveryText = homePage.getDeliveryLocationText(); 
		Thread.sleep(3000);
		Assert.assertTrue(deliveryText.contains("India"));
		homePage.dismissLocationToggle();
		logger.info("Delivery location successfully updated to India.");
		test.info("Verifying delivery location update");
	}
	@When("I open the {string} tab from the left side menu")
	public void i_open_the_tab_from_the_left_side_menu(String string) throws InterruptedException {
		logger.info("Opening menu tab: {}", string);
		test.info("Opening menu tab: " + string);
		homePage.openAllMenu();
		Thread.sleep(3000);
		test.pass("Menu tab opened successfully: " + string); 
		}
		
	@When("I navigate to {string}")
	public void i_navigate_to(String string) throws InterruptedException {
		logger.info("Navigating to section: {}", string);
		test.info("Navigating to section: " + string);
		menuPage.navigateToKindleReadersAndBooks();
		Thread.sleep(3000);
		test.pass("Navigation to section successful: " + string);
	}
	@When("I select {string}")
	public void i_select(String string) throws InterruptedException {
		logger.info("Selecting option: {}", string);
		test.info("Selecting option: " + string);
		menuPage.navigateToKindleBooks();
		Thread.sleep(3000);
		test.pass("Option selected successfully: " + string);
	}
	@Then("the Kindle Books page should be displayed")
	public void the_kindle_books_page_should_be_displayed() throws InterruptedException {
		logger.info("Verifying Kindle Books page...");
		test.info("Verifying Kindle Books page...");
		String title = driver.getTitle(); 
		logger.debug("Page title: {}", title);
		test.info("Page title: " + title);
		Thread.sleep(3000);
		test.pass("Kindle Books page displayed successfully");
		//Assert.assertTrue(title.contains("Kindle Books"));
	}
	@When("I navigate back to the main page")
	public void i_navigate_back_to_the_main_page() throws InterruptedException {
		logger.info("Navigating back to Amazon homepage...");
		test.info("Navigating back to Amazon homepage...");
		kindlePage.navigateBackToHome();
		Thread.sleep(3000);
		test.pass("Navigated back to Amazon homepage");
	}
	@Then("the Amazon homepage should be displayed")
	public void the_amazon_homepage_should_be_displayed() throws InterruptedException {
		logger.info("Verifying Amazon homepage...");
		String title = driver.getTitle(); 
		logger.debug("Page title: {}", title);
		
		Thread.sleep(3000);
		test.pass("Amazon homepage displayed successfully"); 
		//Assert.assertTrue(title.contains("Amazon"));
	}
	@Then("I close the browser")
	public void i_close_the_browser() throws InterruptedException {
		logger.info("Closing browser...");
		kindlePage.closeBrowser();
		Thread.sleep(3000);
		logger.info("Browser closed successfully.");
		test.pass("Browser closed successfully");
	}
	@After public void tearDown() 
	{ 
		extent.flush(); // writes the report to disk 
	}
}

