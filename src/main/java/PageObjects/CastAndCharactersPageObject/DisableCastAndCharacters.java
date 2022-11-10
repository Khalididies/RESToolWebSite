package PageObjects.CastAndCharactersPageObject;

import Entities.CharactersXpath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DisableCastAndCharacters extends CastAndCharacters {
    WebDriver driver;
    WebElement Submit;


    public DisableCastAndCharacters(WebDriver driver) {
        super(driver);
        this.driver = driver;

        Submit = driver.findElement(By.xpath(CharactersXpath.DisableSubmitXpath));
    }

    public void clickSubmit() {
        Submit.click();
    }

    public String getAlertMessage(){
        WebElement AlertMessage= driver.findElement(By.xpath(CharactersXpath.AlertMessageXpath));

        return AlertMessage.getText();
    }
}
