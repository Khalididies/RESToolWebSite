package PageObjects.EmployeesPageObjects;

import Entities.EmployeesXpath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmployeesSearchQueryParams{
    WebDriver driver;
    WebElement Search;
    WebElement Page;
    WebElement Limit;
    WebElement Submit;

    public EmployeesSearchQueryParams(WebDriver driver) {
        this.driver=driver;
        Search = driver.findElement(By.xpath(EmployeesXpath.SearchQueryParamsSearchXpath));
        Page = driver.findElement(By.xpath(EmployeesXpath.SearchQueryParamsPageXpath));
        Limit = driver.findElement(By.xpath(EmployeesXpath.SearchQueryParamsLimitXpath));
        Submit = driver.findElement(By.xpath(EmployeesXpath.SearchQueryParamsSubmitXpath));
    }

    public void fillInSearch(String Name) {
        Search.clear();
        Search.sendKeys(Name);
        Page.clear();
        Page.sendKeys("1");
        Limit.clear();
        Limit.sendKeys("3");
    }

    public void clickSubmit() {
        Submit.click();
    }
}
