package PageObjects.DeadsPageObjects;

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
        ID = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/main/div/table/tbody/tr[1]/td[1]/span"));
        Name = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/main/div/table/tbody/tr/td[2]/span"));
        DeadReason = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/main/div/table/tbody/tr/td[3]/span"));

        Add = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/header/button"));
        Edit = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/main/div/table/tbody/tr[1]/td[4]/div/button[1]"));
        Delete = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/main/div/table/tbody/tr[1]/td[4]/div/button[2]"));
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
