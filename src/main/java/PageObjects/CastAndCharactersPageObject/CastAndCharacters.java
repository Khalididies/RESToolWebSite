package PageObjects.CastAndCharactersPageObject;

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
                                                       //*[@id="root"]/div/div[1]/main/div/div/div[1]/div[2]/span
        ID = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/main/div/div/div/div[2]/span"));
        Name = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/main/div/div/div/div[3]/span"));
        RealName = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/main/div/div/div/div[4]/span"));
        Location =  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/main/div/div/div/div[5]/span"));
        Alive = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/main/div/div/div/div[6]/div"));

        Add = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/header/button"));

        Edit = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/main/div/div/div/div[7]/button[1]"));
        SendEmail = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/main/div/div/div/div[7]/button[2]"));
        Disable =  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/main/div/div/div/div[7]/button[3]"));
        Delete = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/main/div/div/div/div[7]/button[4]"));
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
