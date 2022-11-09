package PageObjects;

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
        Search = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/main/section/form/div/input"));
        Submit = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/main/section/form/button"));
    }

    public void fillInSearch(String Name) {
        Search.clear();
        Search.sendKeys(Name);
    }

    public void clickSubmit() {
        Submit.click();
    }
}
