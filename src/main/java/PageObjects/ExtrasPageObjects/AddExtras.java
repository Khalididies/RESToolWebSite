package PageObjects.ExtrasPageObjects;

import Entities.ExtrasXpath;
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

        Name = driver.findElement(By.xpath(ExtrasXpath.AddNameXpath));

        Submit = driver.findElement(By.xpath(ExtrasXpath.AddSubmitXpath));
    }

    public void fillInNewExtras(String name) {
        Name.sendKeys(name);
    }

    public void clickSubmit(){
        Submit.click();
    }
}
