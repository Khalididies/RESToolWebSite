package PageObjects.CastAndCharactersPageObject;

import Entities.CharactersXpath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditCastAndCharacters extends CastAndCharacters{
    WebDriver driver;
    WebElement NumberTest;
    WebElement Location;
    WebElement Alive;
    WebElement Submit;
    public EditCastAndCharacters(WebDriver driver) {
        super(driver);
        this.driver=driver;

        NumberTest= driver.findElement(By.xpath(CharactersXpath.EditNumberTestXpath));
        Location= driver.findElement(By.xpath(CharactersXpath.EditLocationXpath));
        Alive= driver.findElement(By.xpath(CharactersXpath.EditIsAliveXpath));

        Submit= driver.findElement(By.xpath(CharactersXpath.EditSubmitXpath));

    }
    public void fillInUpdate(String numberTest, String location, boolean isAlive){
        NumberTest.sendKeys(numberTest);
        Location.sendKeys(location);
        if(isAlive){
            Alive.click();
        }
    }
    public void clickSubmit(){
        Submit.click();
    }
}
