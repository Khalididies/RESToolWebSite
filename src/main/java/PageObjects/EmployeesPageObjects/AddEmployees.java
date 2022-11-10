package PageObjects.EmployeesPageObjects;

import Entities.EmployeesXpath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddEmployees extends Employees{
    WebDriver driver;
    WebElement Name;
    WebElement JobTitle;
    WebElement Fired;
    WebElement Submit;

    public AddEmployees(WebDriver driver) {
        super(driver);
        this.driver=driver;

        Name = driver.findElement(By.xpath(EmployeesXpath.AddNameXpath));
        JobTitle = driver.findElement(By.xpath(EmployeesXpath.AddJobTitleXpath));
        Fired = driver.findElement(By.xpath(EmployeesXpath.AddFiredXpath));

        Submit = driver.findElement(By.xpath(EmployeesXpath.AddSubmitXpath));
    }

    public void fillInNewEmployees(String name, String jobTitle, boolean isFired) {
        Name.sendKeys(name);
        JobTitle.sendKeys(jobTitle);
        if(isFired){
            Fired.click();
        }
    }

    public void clickSubmit(){
        Submit.click();
    }
}
