
//Title:- Automation Script to Validate Login, Product Sorting, and Cart Functionality of an E-commerce Website.

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AutomateEcommerceSite {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.name("login-button")).click();
		
		Thread.sleep(2000);
		
		//Login Assertion
		WebElement logo = driver.findElement(By.className("app_logo"));
		Assert.assertTrue(logo.isDisplayed(), "Login failed");
		
		//Filter Products
		driver.findElement(By.className("product_sort_container")).click();
		driver.findElement(By.xpath("//option[@value='hilo']")).click();
		
		//Validating product results are displayed
		WebElement product = driver.findElement(By.className("inventory_item"));
		Assert.assertTrue(product.isDisplayed(), "Error");
		Thread.sleep(3000);
		
		//Add to cart
		driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
		Thread.sleep(2000);
		
		//Logout
		driver.findElement(By.className("bm-burger-button")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();
		

	}

}

