package PageObjects.EmployeesPageObjects;

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

        Name = driver.findElement(By.xpath("//*[@id=\"popup-portal\"]/div/div/div[2]/section/form/div[1]/input"));
        JobTitle = driver.findElement(By.xpath("//*[@id=\"popup-portal\"]/div/div/div[2]/section/form/div[2]/select"));
        Fired = driver.findElement(By.xpath("//*[@id=\"popup-portal\"]/div/div/div[2]/section/form/div[3]/input"));

        Submit = driver.findElement(By.xpath("//*[@id=\"popup-portal\"]/div/div/div[2]/section/form/div[4]/button"));
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
