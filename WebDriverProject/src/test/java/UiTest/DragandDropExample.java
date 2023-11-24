package UiTest;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragandDropExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/droppable/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		WebElement From = driver.findElement(By.id("draggable"));
		WebElement To = driver.findElement(By.id("droppable"));
		
		
		Actions obj = new Actions(driver);
		obj.dragAndDrop(From, To).perform();
		
		WebElement Msg = driver.findElement(By.xpath("//div[@id='droppable']/p"));
		System.out.println(Msg.getText());

	}

}
