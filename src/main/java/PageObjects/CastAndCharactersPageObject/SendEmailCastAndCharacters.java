package PageObjects.CastAndCharactersPageObject;

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

        EmailTitle= driver.findElement(By.xpath("//*[@id=\"popup-portal\"]/div/div/div[2]/section/form/div[2]/input"));
        EmailBody= driver.findElement(By.xpath("//*[@id=\"popup-portal\"]/div/div/div[2]/section/form/div[3]/input"));

        Submit= driver.findElement(By.xpath("//*[@id=\"popup-portal\"]/div/div/div[2]/section/form/div[4]/button"));

    }
    public void fillInEmail(String emailTitle, String emailBody){
        EmailTitle.sendKeys(emailTitle);
        EmailBody.sendKeys(emailBody);
    }

    public void clickSubmit(){
        Submit.click();
    }

    public String getAlertMessage(){
        WebElement AlertMessage= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[1]"));

        return AlertMessage.getText();
    }
}
