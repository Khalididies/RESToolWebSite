package PageObjects;

import Entities.MainXpath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchQueryParams extends MainMenu{
    WebDriver driver;
    WebElement Submit;
    WebElement Search;
    public SearchQueryParams(WebDriver driver) {
        super(driver);
        this.driver=driver;
        Search = driver.findElement(By.xpath(MainXpath.SearchQueryParamsSearchXpath));
        Submit = driver.findElement(By.xpath(MainXpath.SearchQueryParamsSubmitXpath));
    }

    public void fillInSearch(String Name) {
        Search.clear();
        Search.sendKeys(Name);
    }

    public void clickSubmit() {
        Submit.click();
    }
}
