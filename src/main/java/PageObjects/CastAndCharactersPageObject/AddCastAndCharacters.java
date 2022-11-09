package PageObjects.CastAndCharactersPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddCastAndCharacters extends CastAndCharacters{
    WebDriver driver;

    WebElement Thumbnail;
    WebElement Name;
    WebElement RealName;
    WebElement Location;
    WebElement IsAlive;

    WebElement Submit;

    public AddCastAndCharacters(WebDriver driver) {
        super(driver);
        this.driver = driver;
        Thumbnail = driver.findElement(By.xpath("//*[@id=\"popup-portal\"]/div/div/div[2]/section/form/div[1]/input"));
        Name = driver.findElement(By.xpath("//*[@id=\"popup-portal\"]/div/div/div[2]/section/form/div[2]/input"));
        RealName = driver.findElement(By.xpath("//*[@id=\"popup-portal\"]/div/div/div[2]/section/form/div[3]/input"));
        Location = driver.findElement(By.xpath("//*[@id=\"popup-portal\"]/div/div/div[2]/section/form/div[4]/select"));
        IsAlive = driver.findElement(By.xpath("//*[@id=\"popup-portal\"]/div/div/div[2]/section/form/div[5]/input"));
        Submit = driver.findElement(By.xpath("//*[@id=\"popup-portal\"]/div/div/div[2]/section/form/div[6]/button"));
    }
    public void fillInNewCharacter(String thumbnail, String name, String realName, String location, boolean isAlive) {
        Thumbnail.sendKeys(thumbnail);
        Name.sendKeys(name);
        RealName.sendKeys(realName);
        Location.sendKeys(location);
        if(isAlive){
            IsAlive.click();
        }
    }
    public void clickSubmit(){
        Submit.click();
    }
}
