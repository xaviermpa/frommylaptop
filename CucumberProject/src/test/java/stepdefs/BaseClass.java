package stepdefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	@Before
	public void SetUp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://simplilearn.com/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	}

	@After
	public void TearDown() {

		driver.close();

	}

}
