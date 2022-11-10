package PageObjects.EmployeesPageObjects;

import Entities.EmployeesXpath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditEmployees extends Employees{
    WebDriver driver;
    WebElement Name;
    WebElement JobTitle;
    WebElement Fired;
    WebElement Submit;
    public EditEmployees(WebDriver driver) {
        super(driver);
        this.driver=driver;

        Name= driver.findElement(By.xpath(EmployeesXpath.EditNameXpath));
        JobTitle= driver.findElement(By.xpath(EmployeesXpath.EditJobTitleXpath));
        Fired= driver.findElement(By.xpath(EmployeesXpath.EditFiredXpath));

        Submit= driver.findElement(By.xpath(EmployeesXpath.EditSubmitXpath));

    }
    public void fillInUpdate(String name, String jobTitle, boolean isFired){
        Name.click();
        Name.clear();
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
