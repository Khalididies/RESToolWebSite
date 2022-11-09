package PageObjects.CastAndCharactersPageObject;

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

        NumberTest= driver.findElement(By.xpath("//*[@id=\"popup-portal\"]/div/div/div[2]/section/form/div[1]/input"));
        Location= driver.findElement(By.xpath("//*[@id=\"popup-portal\"]/div/div/div[2]/section/form/div[1]/input"));
        Alive= driver.findElement(By.xpath("//*[@id=\"popup-portal\"]/div/div/div[2]/section/form/div[1]/input"));

        Submit= driver.findElement(By.xpath("//*[@id=\"popup-portal\"]/div/div/div[2]/section/form/div[4]/button"));

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
