package PageObjects.DeadsPageObjects;

import Entities.DeadsXpath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditDeads extends Deads{
    WebDriver driver;
    WebElement Name;
    WebElement Reason;
    WebElement Submit;

    public EditDeads(WebDriver driver) {
        super(driver);
        this.driver=driver;

        Name= driver.findElement(By.xpath(DeadsXpath.EditNameXpath));
        Reason= driver.findElement(By.xpath(DeadsXpath.EditReasonXpath));

        Submit= driver.findElement(By.xpath(DeadsXpath.EditSubmitXpath));
    }

    public void fillInUpdate(String name, String reason){
        Name.click();
        Name.clear();
        Name.sendKeys(name);
        Reason.click();
        Reason.clear();
        Reason.sendKeys(reason);
    }

    public void clickSubmit(){
        Submit.click();
    }
}

