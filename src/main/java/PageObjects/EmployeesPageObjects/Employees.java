package PageObjects.EmployeesPageObjects;

import PageObjects.MainMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class Employees extends MainMenu {
    ArrayList<String> Employee = new ArrayList<>();
    WebDriver driver;
    WebElement ID;
    WebElement Name;
    WebElement JobTitle;
    WebElement Fired;

    WebElement Add;

    WebElement Edit;
    WebElement Delete;
    public Employees(WebDriver driver) {
        super(driver);
        this.driver =driver;
        ID = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/main/div/table/tbody/tr/td[1]/span"));
        Name = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/main/div/table/tbody/tr/td[2]/span"));
        JobTitle = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/main/div/table/tbody/tr/td[3]/span"));
        Fired = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/main/div/table/tbody/tr/td[4]/div"));

        Add = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/header/button"));
        Edit = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/main/div/table/tbody/tr/td[5]/div/button[1]"));
        Delete = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/main/div/table/tbody/tr/td[5]/div/button[2]"));
    }
    public ArrayList<String> GetEmployee() {
        Employee.add(ID.getText());
        Employee.add(Name.getText());
        Employee.add(JobTitle.getText());
        Employee.add(String.valueOf(Fired.getAttribute("class").endsWith("true")));

        return Employee;
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