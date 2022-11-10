package PageObjects.CastAndCharactersPageObject;

import Entities.CharactersXpath;
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
        Thumbnail = driver.findElement(By.xpath(CharactersXpath.AddThumbnailXpath));
        Name = driver.findElement(By.xpath(CharactersXpath.AddNameXpath));
        RealName = driver.findElement(By.xpath(CharactersXpath.AddRealNameXpath));
        Location = driver.findElement(By.xpath(CharactersXpath.AddLocationXpath));
        IsAlive = driver.findElement(By.xpath(CharactersXpath.AddIsAliveXpath));
        Submit = driver.findElement(By.xpath(CharactersXpath.AddSubmitXpath));
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
