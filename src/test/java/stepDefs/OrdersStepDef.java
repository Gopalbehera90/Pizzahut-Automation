package stepDefs;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrdersStepDef {
	
	WebDriver driver = BaseClass.driver;
	
	
	@Given("I have launched the application")
	public void i_have_launched_the_application() {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("https://www.pizzahut.co.in/");
		
	}

	@When("I enter the location as {string}")
	public void i_enter_the_location_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement Location = driver.findElement(By.xpath("//input[@placeholder='Enter your location for delivery']"));
		Location.sendKeys("Pune Railway Station");
	}

	@When("I select the very first suggestion from the list")
	public void i_select_the_very_first_suggestion_from_the_list() throws InterruptedException  {
	    // Write code here that turns the phrase above into concrete actions
		WebElement Place = driver.findElement(By.xpath("//*[contains(text(),'Pune Railway Station')]"));	
		Place.click();
		Thread.sleep(5000);
	}

	@Then("I should land on the Deals page")
	public void i_should_land_on_the_Deals_page() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement Deals = driver.findElement(By.xpath("//a[@data-synth='link--deals--side']//span[text()='Deals']"));
		Assert.assertTrue(Deals.isDisplayed());
	}

	@Then("I select the tab as {string}")
	public void i_select_the_tab_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement Pizzas = driver.findElement(By.xpath("//a[@data-synth='link--pizzas--side']//span[text()='Pizzas']"));
		Pizzas.click();
	}

	@Then("I select the pizza as {string}")
	public void i_select_the_pizza_as(String myPizza) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement MyPizza = driver.findElement(By.xpath("//button[@data-synth='button--momo-mia-veg-recommended-pan-personal--one-tap']//span[text()='Add'][1]"));
		MyPizza.click();
	}

	@Then("I should see the pizza is added to the cart")
	public void i_should_see_the_pizza_is_added_to_the_cart() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement BaseketItem = driver.findElement(By.xpath("//div[@data-testid='basket-item-product']//div[contains(text(),'Personal Momo Mia Pizza-Veg')]"));
		Assert.assertTrue(BaseketItem.isDisplayed());
	}

	@Then("I click on the Checkout button")
	public void i_click_on_the_Checkout_button() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement Checkout = driver.findElement(By.xpath("//span[text()='Checkout']"));
		Checkout.click();
	}

	@Then("I should be landed on the secured checkout page")
	public void i_should_be_landed_on_the_secured_checkout_page() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement checkoutpagetile = driver.findElement(By.xpath("//span[text()='Secure Checkout']"));
		checkoutpagetile.isDisplayed();
	}

	@Then("I enter the personal details")
	public void i_enter_the_personal_details(io.cucumber.datatable.DataTable dataTable) {
	   
		// Write code here that turns the phrase above into concrete actions
		
		WebElement FirstName = driver.findElement(By.xpath("//input[@name='name']"));
		FirstName.sendKeys("Sasmita");
		
		WebElement Mobile = driver.findElement(By.xpath("//input[@name='phone']"));
		Mobile.sendKeys("1122334455");
		
		WebElement Email = driver.findElement(By.xpath("//input[@name='email']"));
		Email.sendKeys("abc@xyz.com");
		
	}

	@Then("I enter the address details")
	public void i_enter_the_address_details(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement HouseNumber = driver.findElement(By.xpath("//input[@class='input has-errors']"));
		HouseNumber.sendKeys("123");
		
		WebElement LandMark = driver.findElement(By.xpath("//input[@name='deliveryAddress.notes']"));
		LandMark.sendKeys("streetroad");
	}

	@Then("I should see three payment options")
	public void i_should_see_three_payment_options(List<String> PaymentOptions) {
	    // Write code here that turns the phrase above into concrete actions
		for(String value:PaymentOptions) 
		{
			//dynamic element find and check whether present or not
			WebElement PaymentOption = driver.findElement(By.xpath("//div[@class='mt-20']"));
			PaymentOption.isDisplayed();	
		}	
	}

	@Then("I select the payment option as {string}")
	public void i_select_the_payment_option_as(String PaymentWallet) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement WalletpaymentOption = driver.findElement(By.xpath("//span[text()='Wallet']/preceding::i[1]"));
		WalletpaymentOption.click();
	}



	
	

}
