package stepdefines;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

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
	@Given("I open the Amazon website")
	public void i_open_the_amazon_website() {
		driver = new ChromeDriver(); 
		driver.manage().window().maximize(); 
		
		homePage = new homePage(driver); 
		deliveryPage = new DeliveryAddressPage(driver); 
		menuPage = new MenuPage(driver); 
		kindlePage = new KindlePage(driver); 
		
		homePage.openAmazon();
	}
	@When("I go to the delivery address section")
	public void i_go_to_the_delivery_address_section() throws InterruptedException {
		homePage.clickDeliveryAddress();
		Thread.sleep(3000);
	}
	@When("I change the location to India")
	public void i_change_the_location_to_india() throws InterruptedException {
		deliveryPage.changeLocationToIndia();
		Thread.sleep(3000);
	}
	@Then("the page should update to show delivery in India")
	public void the_page_should_update_to_show_delivery_in_india() throws InterruptedException {
		String deliveryText = homePage.getDeliveryLocationText(); 
		Thread.sleep(3000);
		Assert.assertTrue(deliveryText.contains("India"));
		homePage.dismissLocationToggle();
	}
	@When("I open the {string} tab from the left side menu")
	public void i_open_the_tab_from_the_left_side_menu(String string) throws InterruptedException {
		homePage.openAllMenu();
		Thread.sleep(3000);
		
	}
	@When("I navigate to {string}")
	public void i_navigate_to(String string) throws InterruptedException {
		menuPage.navigateToKindleReadersAndBooks();
		Thread.sleep(3000);
	}
	@When("I select {string}")
	public void i_select(String string) throws InterruptedException {
		menuPage.navigateToKindleBooks();
		Thread.sleep(3000);
	}
	@Then("the Kindle Books page should be displayed")
	public void the_kindle_books_page_should_be_displayed() throws InterruptedException {
		String title = driver.getTitle(); 
		Thread.sleep(3000);
		//Assert.assertTrue(title.contains("Kindle Books"));
	}
	@When("I navigate back to the main page")
	public void i_navigate_back_to_the_main_page() throws InterruptedException {
		kindlePage.navigateBackToHome();
		Thread.sleep(3000);
	}
	@Then("the Amazon homepage should be displayed")
	public void the_amazon_homepage_should_be_displayed() throws InterruptedException {
		String title = driver.getTitle(); 
		Thread.sleep(3000);
		//Assert.assertTrue(title.contains("Amazon"));
	}
	@Then("I close the browser")
	public void i_close_the_browser() throws InterruptedException {
		kindlePage.closeBrowser();
		Thread.sleep(3000);
	}



}
