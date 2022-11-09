package PageObjects.DeadsPageObjects;

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

        Name = driver.findElement(By.xpath("//*[@id=\"popup-portal\"]/div/div/div[2]/section/form/div[1]/input"));
        Reason = driver.findElement(By.xpath("//*[@id=\"popup-portal\"]/div/div/div[2]/section/form/div[2]/input"));

        Submit = driver.findElement(By.xpath("//*[@id=\"popup-portal\"]/div/div/div[2]/section/form/div[3]/button"));
    }

    public void fillInNewDeads(String name, String reason) {
        Name.sendKeys(name);
        Reason.sendKeys(reason);
    }

    public void clickSubmit(){
        Submit.click();
    }
}
