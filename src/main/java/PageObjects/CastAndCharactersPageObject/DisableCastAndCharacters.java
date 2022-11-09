package PageObjects.CastAndCharactersPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DisableCastAndCharacters extends CastAndCharacters {
    WebDriver driver;
    WebElement Submit;


    public DisableCastAndCharacters(WebDriver driver) {
        super(driver);
        this.driver = driver;

        Submit = driver.findElement(By.xpath("//*[@id=\"popup-portal\"]/div/div/div[2]/section/form/div[2]/button"));
    }

    public void clickSubmit() {
        Submit.click();
    }

    public String getAlertMessage(){
        WebElement AlertMessage= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[1]"));

        return AlertMessage.getText();
    }
}
