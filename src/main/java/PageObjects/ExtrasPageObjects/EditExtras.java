package PageObjects.ExtrasPageObjects;

import Entities.ExtrasXpath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditExtras extends Extras {
    WebDriver driver;
    WebElement Name;
    WebElement Submit;
    public EditExtras(WebDriver driver) {
        super(driver);
        this.driver=driver;

        Name= driver.findElement(By.xpath(ExtrasXpath.EditNameXpath));

        Submit= driver.findElement(By.xpath(ExtrasXpath.EditSubmitXpath));
    }
    public void fillInUpdate(String name){
        Name.click();
        Name.clear();
        Name.sendKeys(name);
    }

    public void clickSubmit(){
        Submit.click();
    }
}

