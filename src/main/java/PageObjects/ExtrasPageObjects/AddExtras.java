package PageObjects.ExtrasPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddExtras extends Extras{

    WebDriver driver;
    WebElement Name;
    WebElement Submit;

    public AddExtras(WebDriver driver) {
        super(driver);
        this.driver=driver;

        Name = driver.findElement(By.xpath("//*[@id=\"popup-portal\"]/div/div/div[2]/section/form/div[1]/input"));

        Submit = driver.findElement(By.xpath("//*[@id=\"popup-portal\"]/div/div/div[2]/section/form/div[2]/button"));
    }

    public void fillInNewExtras(String name) {
        Name.sendKeys(name);
    }

    public void clickSubmit(){
        Submit.click();
    }
}
