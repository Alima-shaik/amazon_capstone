package testing;
	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	import org.openqa.selenium.interactions.Actions;

	public class test_ama {
		public static void main(String[] arga) throws InterruptedException {
			

	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://www.amazon.in/");
	        Thread.sleep(4000);

	        String pagetitle = driver.getTitle();
	        System.out.println(pagetitle);
	        
	        WebElement countryDropdown = driver.findElement(By.id("glow-ingress-block"));//select"));
	 	    countryDropdown.click();
	 	  driver.findElement(By.id("GLUXZipUpdateInput")).click();
	 	    driver.findElement(By.xpath("//option[text()='India']")).click();
	        WebElement applyButton = driver.findElement(By.xpath("//div[@name='glowDoneButton']"));
		    applyButton.click();

	        WebElement l = driver.findElement(By.id("twotabsearchtextbox"));
	        Actions a = new Actions (driver);
	        a.moveToElement(l).click();
	        
	        a.keyDown(Keys.SHIFT);
	        a.sendKeys("laptop").keyUp(Keys.SHIFT).build().perform();
	        a.contextClick().perform();
	        Thread.sleep(2000);
	        
	        driver.quit();
	        
	        
		}

	}

