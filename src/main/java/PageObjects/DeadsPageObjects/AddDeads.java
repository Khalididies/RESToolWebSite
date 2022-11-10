package PageObjects.DeadsPageObjects;

import Entities.DeadsXpath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddDeads extends Deads{
    WebDriver driver;
    WebElement Name;
    WebElement Reason;
    WebElement Submit;

    public AddDeads(WebDriver driver) {
        super(driver);
        this.driver=driver;

        Name = driver.findElement(By.xpath(DeadsXpath.AddNameXpath));
        Reason = driver.findElement(By.xpath(DeadsXpath.AddReasonXpath));

        Submit = driver.findElement(By.xpath(DeadsXpath.AddSubmitXpath));
    }

    public void fillInNewDeads(String name, String reason) {
        Name.sendKeys(name);
        Reason.sendKeys(reason);
    }

    public void clickSubmit(){
        Submit.click();
    }
}
