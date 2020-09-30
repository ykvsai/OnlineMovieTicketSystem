package com.capgemini.omts.stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddSuccessful {

	public static WebDriver driver;

	@Before
	public void setup() {

		System.setProperty("webdriver.chrome.driver",
				"D:\\BootCamp\\Seleniumsoftware\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("setup chromedriver");

	}

	@After
	public void teardown() {

		driver.close();
		System.out.println("close browser");

	}

	@Given("^user pressed Add Theatre button after opening website$")
	public void user_pressed_Add_Theatre_button_after_opening_website() throws Throwable {

		driver.get("http://localhost:4200");
		driver.manage().window().maximize();
		System.out.println("Opened Apllication");
		driver.findElement(By.xpath("//a[contains(text(),'Add Theater')]")).click();
	}

	@When("^user entered valid data in all fields$")
	public void user_entered_valid_data_in_all_fields() throws Throwable {
		driver.findElement(By.xpath("//input[@name='txtid']")).sendKeys("9001");
		driver.findElement(By.xpath("//input[@name='txtname']")).sendKeys("priya");
		driver.findElement(By.xpath("//input[@name='txtcity']")).sendKeys("Vizag");
		driver.findElement(By.xpath("//input[@name='txtmgname']")).sendKeys("kinta");
		driver.findElement(By.xpath("//input[@name='txtmgct']")).sendKeys("kinta@pb.com");
	}

	@Then("^pressed Add button$")
	public void pressed_Add_button() throws Throwable {
		driver.findElement(By.xpath("//input[@class='btn btn-success btn-lg']")).click();
	}
}
