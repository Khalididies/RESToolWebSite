package PageObjects.EmployeesPageObjects;

import Entities.EmployeesXpath;
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
        ID = driver.findElement(By.xpath(EmployeesXpath.IDXpath));
        Name = driver.findElement(By.xpath(EmployeesXpath.NameXpath));
        JobTitle = driver.findElement(By.xpath(EmployeesXpath.JobTitleXpath));
        Fired = driver.findElement(By.xpath(EmployeesXpath.FiredXpath));

        Add = driver.findElement(By.xpath(EmployeesXpath.AddXpath));
        Edit = driver.findElement(By.xpath(EmployeesXpath.EditXpath));
        Delete = driver.findElement(By.xpath(EmployeesXpath.DeleteXpath));
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