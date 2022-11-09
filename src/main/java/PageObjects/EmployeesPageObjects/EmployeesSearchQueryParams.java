package PageObjects.EmployeesPageObjects;

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
        Search = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/main/section/form/div[1]/input"));
        Page = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/main/section/form/div[2]/input"));
        Limit = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/main/section/form/div[3]/input"));
        Submit = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/main/section/form/button"));
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
