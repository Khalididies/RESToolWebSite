package PageObjects.CastAndCharactersPageObject;

import Entities.CharactersXpath;
import PageObjects.MainMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class CastAndCharacters extends MainMenu {
    ArrayList<String> Character = new ArrayList<>();
    WebDriver driver;
    WebElement ID;
    WebElement Name;
    WebElement RealName;
    WebElement Location;
    WebElement Alive;
    WebElement Add;
    WebElement Edit;
    WebElement Disable;
    WebElement SendEmail;
    WebElement Delete;

    public CastAndCharacters(WebDriver driver) {
        super(driver);
        this.driver=driver;

        ID = driver.findElement(By.xpath(CharactersXpath.IdXpath));
        Name = driver.findElement(By.xpath(CharactersXpath.NameXpath));
        RealName = driver.findElement(By.xpath(CharactersXpath.RealNameXpath));
        Location =  driver.findElement(By.xpath(CharactersXpath.LocationXpath));
        Alive = driver.findElement(By.xpath(CharactersXpath.AliveXpath));

        Add = driver.findElement(By.xpath(CharactersXpath.AddXpath));

        Edit = driver.findElement(By.xpath(CharactersXpath.EditXpath));
        SendEmail = driver.findElement(By.xpath(CharactersXpath.SendEmailXpath));
        Disable =  driver.findElement(By.xpath(CharactersXpath.DisableXpath));
        Delete = driver.findElement(By.xpath(CharactersXpath.DeleteXpath));
    }
    public ArrayList<String> GetCharacter() {
        Character.add(ID.getText());
        Character.add(Name.getText());
        Character.add(RealName.getText());
        Character.add(Location.getText());
        Character.add(String.valueOf(Alive.getAttribute("class").endsWith("true")));

        return Character;
    }
    public void clickAddNewItem() {
        Add.click();
    }
    public void clickEditItem() {
        Edit.click();
    }
    public void clickSendEmailItem() {
        SendEmail.click();
    }
    public void clickDisableItem() {
        Disable.click();
    }
    public void clickDeleteItem() {
        Delete.click();
        driver.switchTo().alert().accept();
    }
}
