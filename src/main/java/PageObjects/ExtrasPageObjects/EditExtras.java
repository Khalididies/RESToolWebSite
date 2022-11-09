package PageObjects.ExtrasPageObjects;

import PageObjects.DeadsPageObjects.Deads;
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

        Name= driver.findElement(By.xpath("//*[@id=\"popup-portal\"]/div/div/div[2]/section/form/div[1]/input"));

        Submit= driver.findElement(By.xpath("//*[@id=\"popup-portal\"]/div/div/div[2]/section/form/div[2]/button"));
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

