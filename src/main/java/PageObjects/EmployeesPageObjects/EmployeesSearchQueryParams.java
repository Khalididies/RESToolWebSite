package PageObjects.EmployeesPageObjects;

import Entities.EmployeesXpath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmployeesSearchQueryParams{
    WebDriver driver;
    WebElement Search;
    WebElement Submit;

    public EmployeesSearchQueryParams(WebDriver driver) {
        this.driver=driver;
        Search = driver.findElement(By.xpath(EmployeesXpath.SearchQueryParamsSearchXpath));
        Submit = driver.findElement(By.xpath(EmployeesXpath.SearchQueryParamsSubmitXpath));
    }

    public void fillInSearch(String Name) {
        Search.clear();
        Search.sendKeys(Name);
    }

    public void clickSubmit() {
        Submit.click();
    }
}
