package PageObjects.ExtrasPageObjects;

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
        ID = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/main/div/table/tbody/tr[1]/td[1]/span"));
        Name = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/main/div/table/tbody/tr[1]/td[2]/span"));

        Add = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/header/button"));
        Edit = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/main/div/table/tbody/tr[1]/td[3]/div/button[1]"));
        Delete = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/main/div/table/tbody/tr[1]/td[3]/div/button[2]"));
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