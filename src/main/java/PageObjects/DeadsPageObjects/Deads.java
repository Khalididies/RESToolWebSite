package PageObjects.DeadsPageObjects;

import Entities.DeadsXpath;
import PageObjects.MainMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class Deads extends MainMenu {
    ArrayList<String> Dead = new ArrayList<>();
    WebDriver driver;
    WebElement ID;
    WebElement Name;
    WebElement DeadReason;
    WebElement Add;
    WebElement Edit;
    WebElement Delete;
    public Deads(WebDriver driver) {
        super(driver);
        this.driver =driver;
        ID = driver.findElement(By.xpath(DeadsXpath.IDXpath));
        Name = driver.findElement(By.xpath(DeadsXpath.NameXpath));
        DeadReason = driver.findElement(By.xpath(DeadsXpath.DeadReasonXpath));

        Add = driver.findElement(By.xpath(DeadsXpath.AddXpath));
        Edit = driver.findElement(By.xpath(DeadsXpath.EditXpath));
        Delete = driver.findElement(By.xpath(DeadsXpath.DeleteXpath));
    }

    public ArrayList<String> GetDead() {
        Dead.add(ID.getText());
        Dead.add(Name.getText());
        Dead.add(DeadReason.getText());

        return Dead;
    }
    public void clickAddNewItem() {
        Add.click();
    }
    public void clickEditItem() {
        Edit.click();
    }
    public void clickDeleteItem() {
        Delete.click();
        driver.switchTo().alert().accept();
    }
}
