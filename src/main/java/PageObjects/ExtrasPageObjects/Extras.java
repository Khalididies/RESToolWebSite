package PageObjects.ExtrasPageObjects;

import Entities.ExtrasXpath;
import PageObjects.MainMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class Extras extends MainMenu {
    ArrayList<String> Extra = new ArrayList<>();
    WebDriver driver;
    WebElement ID;
    WebElement Name;
    WebElement Add;
    WebElement Edit;
    WebElement Delete;
    public Extras(WebDriver driver) {
        super(driver);
        this.driver =driver;
        ID = driver.findElement(By.xpath(ExtrasXpath.IDXpath));
        Name = driver.findElement(By.xpath(ExtrasXpath.NameXpath));

        Add = driver.findElement(By.xpath(ExtrasXpath.AddXpath));
        Edit = driver.findElement(By.xpath(ExtrasXpath.EditXpath));
        Delete = driver.findElement(By.xpath(ExtrasXpath.DeleteXpath));
    }

    public ArrayList<String> GetExtra() {
        Extra.add(ID.getText());
        Extra.add(Name.getText());

        return Extra;
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