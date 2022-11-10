package PageObjects.CastAndCharactersPageObject;

import Entities.CharactersXpath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SendEmailCastAndCharacters extends CastAndCharacters{
    WebDriver driver;
    WebElement EmailTitle;
    WebElement EmailBody;
    WebElement Submit;

    public SendEmailCastAndCharacters(WebDriver driver) {
        super(driver);
        this.driver=driver;

        EmailTitle= driver.findElement(By.xpath(CharactersXpath.SendEmailEmailTitleXpath));
        EmailBody= driver.findElement(By.xpath(CharactersXpath.SendEmailEmailBodyXpath));

        Submit= driver.findElement(By.xpath(CharactersXpath.SendEmailSubmitXpath));

    }
    public void fillInEmail(String emailTitle, String emailBody){
        EmailTitle.sendKeys(emailTitle);
        EmailBody.sendKeys(emailBody);
    }

    public void clickSubmit(){
        Submit.click();
    }

    public String getAlertMessage(){
        WebElement AlertMessage= driver.findElement(By.xpath(CharactersXpath.SendEmailAlertMessageXpath));

        return AlertMessage.getText();
    }
}
