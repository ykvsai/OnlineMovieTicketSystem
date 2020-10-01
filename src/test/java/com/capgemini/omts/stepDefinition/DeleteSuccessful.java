package com.capgemini.omts.stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DeleteSuccessful {
	
	WebDriver driver = AddSuccessful.driver;
	
	/*********************************************************************************************************************************
	 * @Method user_pressed_Delete_Theatre_button_after_entering_to_website
	 * @Description this method will do Given preconditions by customer
	 * @return void
	 * @since 29-September-2020
	 **********************************************************************************************************************************/
	@Given("^user pressed Delete Theatre button after entering to website$")
	public void user_pressed_Delete_Theatre_button_after_entering_to_website() throws Throwable {
	    
		driver.get("http://localhost:4200");
		driver.manage().window().maximize();
		System.out.println("Opened Apllication");
		driver.findElement(By.xpath("//a[contains(text(),'Delete Theater')]")).click();
		
	}
	
	/*********************************************************************************************************************************
	 * @Method user_entered_valid_data_in_Theater_ID
	 * @Description this method will process the requirements given by customer
	 * @return void
	 * @since 29-September-2020
	 **********************************************************************************************************************************/
	@When("^user entered valid data in Theater ID$")
	public void user_entered_valid_data_in_Theater_ID() throws Throwable {
	    
		driver.findElement(By.xpath("//input[@name='txtid']")).sendKeys("9001");
		
	}
	
	/*********************************************************************************************************************************
	 * @Method pressed_DELETE_button
	 * @Description this method executes and shows the final output
	 * @return void
	 * @since 29-September-2020
	 **********************************************************************************************************************************/
	@Then("^pressed DELETE button$")
	public void pressed_DELETE_button() throws Throwable {
		
		driver.findElement(By.xpath("//input[@class='btn btn-danger btn-lg']")).click();
		
	}

}
