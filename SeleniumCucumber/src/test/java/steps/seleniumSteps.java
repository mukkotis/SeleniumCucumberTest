package steps;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.utils.FileUtil;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class seleniumSteps {

	public static WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("wendriver.chrome.driver",
				"C:\\Users\\lenovo\\Desktop\\Workspace_Ibm_Manipal_Selenim_Cucumber_Nov2020\\SeleniumCucumber\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	}

	@After
	public void tearDown(Scenario scenario) throws IOException {
		// Screen shot on failure
		if (scenario.isFailed()) {
			//To embed screenshot in extent report with cucumber
			String scenarioName = scenario.getName();
			byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			/*
			 *Embeds data into the report(s). Some reporters (such as the progress one) don't embed data, but others do (html and json). 
			 *Refer the website and go to EMBED method section --> //https://www.javadoc.io/doc/info.cukes/cucumber-core/1.2.5/cucumber/api/Scenario.html#embed-byte:A-java.lang.String-
			*/
			scenario.embed(screenshotBytes, "image/png");
			scenario.write(scenarioName);
			
			//To put screenshot in a folder with scenario name and date format
			Date d = new Date();
			String date = d.toString().replace(":", "_").replace("", "_");
			File fileTemp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File filePerm = new File("C:\\Users\\lenovo\\Desktop\\Workspace_Ibm_Manipal_Selenim_Cucumber_Nov2020\\SeleniumCucumber\\FailedScreenshot\\"+scenarioName+"_"+date+".png");
			FileUtils.copyFile(fileTemp, filePerm);
			
			
			
		}

		if (driver != null) {
			driver.quit();
		}

	}

	@Given("navigate to {string}")
	public void navigate_to(String url) {

		driver.get(url);

	}

	@When("We type the keyword in google edit box")
	public void we_type_the_keyword_in_google_edit_box() throws InterruptedException {
		Thread.sleep(5000L);
		driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys("Cucumber");
	}

	@And("We click on Google Search button")
	public void we_click_on_Google_Search_button() throws InterruptedException {
		Thread.sleep(5000L);
		driver.findElement(By.name("btnK")).click();
	}

	@Then("We validate the {string}")
	public void we_validate_the(String keyword) throws InterruptedException {
		System.out.println(keyword);
		Thread.sleep(5000L);
		String actualKeyword = driver
				.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div[1]/div/div[1]/div/div[2]/div/span/span/b[1]"))
				.getText();
		Assert.assertEquals(keyword, actualKeyword);

	}

}
