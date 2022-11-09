package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainMenu {
	WebDriver driver;
	WebElement menuItem;

	WebElement IsEmpty;
	
	public MainMenu(WebDriver driver) {
		this.driver = driver;
	}
	
	public void pressMenuItem(String MenuTxt) {
		menuItem = driver.findElement(By.linkText(MenuTxt));
		menuItem.click();
	}

	public boolean CheckIfEmpty(){
		try {
			IsEmpty =driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/main/div"));
			return  true;
		}catch (Error error){
			return false;
		}

	}
}
