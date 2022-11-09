import APIObjectModel.APICharacterObject.CharacterItem;
import APIObjectModel.APICharacterObject.RequestCharacter;
import APIObjectModel.APIDeadsObject.DeadsItem;
import APIObjectModel.APIDeadsObject.RequestDeads;
import APIObjectModel.APIEmployeesObject.EmployeesItem;
import APIObjectModel.APIEmployeesObject.RequestEmployees;
import APIObjectModel.APIExtrasObject.ExtrasItem;
import APIObjectModel.APIExtrasObject.RequestExtras;
import APIObjectModel.CharacterAPI;
import APIObjectModel.DeadsAPI;
import APIObjectModel.EmployeesAPI;
import APIObjectModel.ExtrasAPI;
import Entities.Environment;
import PageObjects.CastAndCharactersPageObject.*;
import PageObjects.DeadsPageObjects.AddDeads;
import PageObjects.DeadsPageObjects.Deads;
import PageObjects.DeadsPageObjects.EditDeads;
import PageObjects.EmployeesPageObjects.AddEmployees;
import PageObjects.EmployeesPageObjects.EditEmployees;
import PageObjects.EmployeesPageObjects.Employees;
import PageObjects.EmployeesPageObjects.EmployeesSearchQueryParams;
import PageObjects.ExtrasPageObjects.AddExtras;
import PageObjects.ExtrasPageObjects.EditExtras;
import PageObjects.ExtrasPageObjects.Extras;
import PageObjects.MainMenu;
import PageObjects.SearchQueryParams;
import Utils.OpenBrowsers;
import io.qameta.allure.Allure;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;

import static Entities.Generate.*;

public class UITestCases {
    WebDriver driver;
    int i=0;

    @BeforeMethod
    public void BeforeTest() {
        driver = OpenBrowsers.openBrowser("chrome");
        driver.manage().window().maximize();
        driver.get(Environment.URL.getUrl());
    }

    @Test()
    public void addCastAndCharacters() throws InterruptedException, IOException {
        MainMenu mainMenu = new MainMenu(driver);
        mainMenu.pressMenuItem("Cast & Characters");
        Thread.sleep(2000);

        CastAndCharacters characters = new CastAndCharacters(driver);
        characters.clickAddNewItem();

        Thread.sleep(2000);
        String name =generateString();
        AddCastAndCharacters addCastAndCharacters = new AddCastAndCharacters(driver);
        addCastAndCharacters.fillInNewCharacter(generateString(),name,generateString(),"b",true);
        addCastAndCharacters.clickSubmit();

        SearchQueryParams searchQueryParams = new SearchQueryParams(driver);
        searchQueryParams.fillInSearch(name);
        searchQueryParams.clickSubmit();
        Thread.sleep(2000);

        Allure.addAttachment("addCastAndCharacters", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

        characters = new CastAndCharacters(driver);
        ArrayList<String> character=characters.GetCharacter();

        RequestCharacter getCharacter = CharacterAPI.getInstance().getCharacter();
        CharacterItem Character = getCharacter.characterItems.get(getCharacter.characterItems.size() - 1);

        Assert.assertEquals(character.get(0),Character.id);
        Assert.assertEquals(character.get(1),Character.name);
        Assert.assertEquals(character.get(2),Character.realName);
        Assert.assertEquals(character.get(3),Character.location);
        Assert.assertEquals(character.get(4),Character.isAlive.toString());
    }

    @Test()
    public void editCastAndCharacters() throws InterruptedException {
        CharacterItem postCharacter = CharacterAPI.getInstance().PostCharacter(generateString(),generateString(),generateString(),getLocation("w"),true);

        MainMenu mainMenu = new MainMenu(driver);
        mainMenu.pressMenuItem("Cast & Characters");
        Thread.sleep(2000);

        SearchQueryParams searchQueryParams = new SearchQueryParams(driver);
        searchQueryParams.fillInSearch(postCharacter.name);
        searchQueryParams.clickSubmit();
        Thread.sleep(2000);

        CastAndCharacters characters = new CastAndCharacters(driver);

        ArrayList<String> character=characters.GetCharacter();
        characters.clickEditItem();
        Thread.sleep(2000);

        EditCastAndCharacters editCastAndCharacters = new EditCastAndCharacters(driver);
        editCastAndCharacters.fillInUpdate(getRandomNumber(),getLocation("b"),true);
        editCastAndCharacters.clickSubmit();

        searchQueryParams = new SearchQueryParams(driver);
        searchQueryParams.fillInSearch(postCharacter.name);
        searchQueryParams.clickSubmit();
        Thread.sleep(2000);

        Allure.addAttachment("editCastAndCharacters", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

        Assert.assertEquals(character.get(0),postCharacter.id);
        Assert.assertEquals(character.get(1),postCharacter.name);
        Assert.assertEquals(character.get(2),postCharacter.realName);
        Assert.assertEquals(character.get(3),getLocation("w"));
        Assert.assertEquals(character.get(4),"true");
    }

    @Test()
    public void sendEmailCastAndCharacters() throws InterruptedException {
        CharacterItem postCharacter = CharacterAPI.getInstance().PostCharacter(generateString(),generateString(),generateString(),getLocation("w"),true);

        MainMenu mainMenu = new MainMenu(driver);
        mainMenu.pressMenuItem("Cast & Characters");
        Thread.sleep(2000);

        SearchQueryParams searchQueryParams = new SearchQueryParams(driver);
        searchQueryParams.fillInSearch(postCharacter.name);
        searchQueryParams.clickSubmit();
        Thread.sleep(2000);

        CastAndCharacters characters = new CastAndCharacters(driver);

        characters.clickSendEmailItem();
        Thread.sleep(2000);
        SendEmailCastAndCharacters sendEmailCastAndCharacters= new SendEmailCastAndCharacters(driver);
        sendEmailCastAndCharacters.fillInEmail(generateString(),generateString());
        sendEmailCastAndCharacters.clickSubmit();

        Allure.addAttachment("sendEmailCastAndCharacters", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

        Thread.sleep(2000);
        String AlertMessage =sendEmailCastAndCharacters.getAlertMessage();

        Assert.assertEquals(AlertMessage,"404 - Not Found");
    }

    @Test()
    public void disableCastAndCharacters() throws InterruptedException {
        CharacterItem postCharacter = CharacterAPI.getInstance().PostCharacter(generateString(),generateString(),generateString(),getLocation("w"),true);

        MainMenu mainMenu = new MainMenu(driver);
        mainMenu.pressMenuItem("Cast & Characters");
        Thread.sleep(2000);

        SearchQueryParams searchQueryParams = new SearchQueryParams(driver);
        searchQueryParams.fillInSearch(postCharacter.name);
        searchQueryParams.clickSubmit();
        Thread.sleep(2000);

        CastAndCharacters characters = new CastAndCharacters(driver);

        characters.clickDisableItem();
        Thread.sleep(2000);
        DisableCastAndCharacters disableCastAndCharacters= new DisableCastAndCharacters(driver);
        disableCastAndCharacters.clickSubmit();

        Allure.addAttachment("disableCastAndCharacters", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

        Thread.sleep(2000);
        String AlertMessage =disableCastAndCharacters.getAlertMessage();

        Assert.assertEquals(AlertMessage,"404 - Not Found");
    }

    @Test()
    public void deleteCastAndCharacters() throws InterruptedException {
        CharacterItem postCharacter = CharacterAPI.getInstance().PostCharacter(generateString(),generateString(),generateString(),getLocation("w"),true);

        MainMenu mainMenu = new MainMenu(driver);
        mainMenu.pressMenuItem("Cast & Characters");
        Thread.sleep(2000);

        SearchQueryParams searchQueryParams = new SearchQueryParams(driver);
        searchQueryParams.fillInSearch(postCharacter.name);
        searchQueryParams.clickSubmit();
        Thread.sleep(2000);

        Allure.addAttachment("deleteCastAndCharacters", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

        CastAndCharacters characters = new CastAndCharacters(driver);
        characters.clickDeleteItem();

        boolean IsEmpty=mainMenu.CheckIfEmpty();

        Assert.assertEquals(IsEmpty,true);
    }

    @Test()
    public void addEmployees() throws InterruptedException {
        EmployeesItem postEmployees = EmployeesAPI.getInstance().PostEmployee(generateString(),getLocationEmployees("a"),true);

        MainMenu mainMenu = new MainMenu(driver);
        mainMenu.pressMenuItem("Employees");
        Thread.sleep(2000);

        EmployeesSearchQueryParams searchQueryParams = new EmployeesSearchQueryParams(driver);
        searchQueryParams.fillInSearch(postEmployees.name);
        searchQueryParams.clickSubmit();
        Thread.sleep(2000);

        Employees employees=new Employees(driver);
        employees.clickAddNewItem();
        Thread.sleep(2000);

        AddEmployees addEmployees=new AddEmployees(driver);
        String name = generateString();
        addEmployees.fillInNewEmployees(name,"R",true);
        addEmployees.clickSubmit();
        Thread.sleep(2000);

         searchQueryParams = new EmployeesSearchQueryParams(driver);
        searchQueryParams.fillInSearch(name);
        searchQueryParams.clickSubmit();

        Allure.addAttachment("addEmployees", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

        Thread.sleep(2000);
        Employees employees1=new Employees(driver);
        ArrayList<String> employee = employees1.GetEmployee();

        RequestEmployees getEmployees = EmployeesAPI.getInstance().getEmployee();
        EmployeesItem Employees = getEmployees.EmployeesItem.get(getEmployees.EmployeesItem.size() - 1);

        Assert.assertEquals(employee.get(0),Employees.id);
        Assert.assertEquals(employee.get(1),Employees.name);
        Assert.assertEquals(employee.get(2),Employees.jobTitle);
        Assert.assertEquals(employee.get(3),Employees.isFired.toString());
    }

    @Test()
    public void editEmployees() throws InterruptedException {
        EmployeesItem postEmployees = EmployeesAPI.getInstance().PostEmployee(generateString(),getLocationEmployees("a"),true);
        String name = generateString();

        MainMenu mainMenu = new MainMenu(driver);
        mainMenu.pressMenuItem("Employees");
        Thread.sleep(2000);

        EmployeesSearchQueryParams searchQueryParams = new EmployeesSearchQueryParams(driver);
        searchQueryParams.fillInSearch(postEmployees.name);
        searchQueryParams.clickSubmit();
        Thread.sleep(2000);

        Employees employees=new Employees(driver);
        employees.clickEditItem();
        Thread.sleep(2000);

        EditEmployees editEmployees=new EditEmployees(driver);
        editEmployees.fillInUpdate(name,getLocationEmployees("c"),true);
        editEmployees.clickSubmit();

        Thread.sleep(2000);
        EmployeesSearchQueryParams searchQueryParams2 = new EmployeesSearchQueryParams(driver);
        searchQueryParams2.fillInSearch(name);
        searchQueryParams2.clickSubmit();

        Allure.addAttachment("editEmployees", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

        Thread.sleep(2000);
        employees=new Employees(driver);
        ArrayList<String> employee = employees.GetEmployee();

        Assert.assertEquals(employee.get(0),postEmployees.id);
        Assert.assertEquals(employee.get(1),name);
        Assert.assertEquals(employee.get(2),getLocationEmployees("c"));
        Assert.assertEquals(employee.get(3),"false");
    }

    @Test()
    public void deleteEmployees() throws InterruptedException {
        EmployeesItem postEmployees = EmployeesAPI.getInstance().PostEmployee(generateString(),getLocationEmployees("a"),true);

        MainMenu mainMenu = new MainMenu(driver);
        mainMenu.pressMenuItem("Employees");
        Thread.sleep(2000);

        EmployeesSearchQueryParams searchQueryParams = new EmployeesSearchQueryParams(driver);
        searchQueryParams.fillInSearch(postEmployees.name);
        searchQueryParams.clickSubmit();
        Thread.sleep(2000);

        Allure.addAttachment("deleteEmployees", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

        Employees employees=new Employees(driver);
        employees.clickDeleteItem();

        boolean IsEmpty=mainMenu.CheckIfEmpty();
        Assert.assertEquals(IsEmpty,true);
    }

    @Test()
    public void addDeads() throws InterruptedException {
        MainMenu mainMenu = new MainMenu(driver);
        mainMenu.pressMenuItem("Deads");
        Thread.sleep(3000);

        SearchQueryParams searchQueryParams = new SearchQueryParams(driver);
        searchQueryParams.fillInSearch("Tommen");
        searchQueryParams.clickSubmit();
        Thread.sleep(2000);

        Deads deads=new Deads(driver);
        deads.clickAddNewItem();
        Thread.sleep(2000);

        String name = generateString();
        String reason = generateString();
        AddDeads addDeads=new AddDeads(driver);
        addDeads.fillInNewDeads(name,reason);
        addDeads.clickSubmit();
        Thread.sleep(2000);

        searchQueryParams = new SearchQueryParams(driver);
        searchQueryParams.fillInSearch(name);
        searchQueryParams.clickSubmit();
        Thread.sleep(2000);

        Allure.addAttachment("addDeads", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

        RequestDeads getDeads = DeadsAPI.getInstance().getDead();
        DeadsItem Dead = getDeads.DeadsItem.get(getDeads.DeadsItem.size()-1);

        deads=new Deads(driver);
        ArrayList<String> dead=deads.GetDead();

        Assert.assertEquals(dead.get(0),Dead.id);
        Assert.assertEquals(dead.get(1),Dead.name);
        Assert.assertEquals(dead.get(2),Dead.reason);
    }

    @Test()
    public void editDeads() throws InterruptedException {
        DeadsItem postDeads = DeadsAPI.getInstance().PostDead(generateString(),generateString());
        String name = generateString();
        String reason = generateString();

        MainMenu mainMenu = new MainMenu(driver);
        mainMenu.pressMenuItem("Deads");
        Thread.sleep(2000);

        SearchQueryParams searchQueryParams = new SearchQueryParams(driver);
        searchQueryParams.fillInSearch(postDeads.name);
        searchQueryParams.clickSubmit();
        Thread.sleep(2000);

        Deads deads=new Deads(driver);
        deads.clickEditItem();
        Thread.sleep(2000);

        EditDeads editDeads = new EditDeads(driver);
        editDeads.fillInUpdate(name,reason);
        editDeads.clickSubmit();
        Thread.sleep(2000);

        searchQueryParams = new SearchQueryParams(driver);
        searchQueryParams.fillInSearch(name);
        searchQueryParams.clickSubmit();
        Thread.sleep(2000);

        Allure.addAttachment("editDeads", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

        deads=new Deads(driver);
        ArrayList<String> dead=deads.GetDead();

        Assert.assertEquals(dead.get(0),postDeads.id);
        Assert.assertEquals(dead.get(1),name);
        Assert.assertEquals(dead.get(2),reason);
    }

    @Test()
    public void DeleteDeads() throws InterruptedException {
        DeadsItem postDeads = DeadsAPI.getInstance().PostDead(generateString(),generateString());

        MainMenu mainMenu = new MainMenu(driver);
        mainMenu.pressMenuItem("Deads");
        Thread.sleep(2000);

        SearchQueryParams searchQueryParams = new SearchQueryParams(driver);
        searchQueryParams.fillInSearch(postDeads.name);
        searchQueryParams.clickSubmit();
        Thread.sleep(2000);

        Allure.addAttachment("DeleteDeads", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

        Deads deads=new Deads(driver);
        ArrayList<String> dead=deads.GetDead();

        deads.clickDeleteItem();
        boolean IsEmpty=mainMenu.CheckIfEmpty();
        Assert.assertEquals(IsEmpty,true);
    }

    @Test()
    public void addExtras() throws InterruptedException {
        MainMenu mainMenu = new MainMenu(driver);
        mainMenu.pressMenuItem("Extras");
        Thread.sleep(2000);

        SearchQueryParams searchQueryParams = new SearchQueryParams(driver);
        searchQueryParams.fillInSearch("Ate by a dragon guy");
        searchQueryParams.clickSubmit();
        Thread.sleep(2000);

        Extras extras=new Extras(driver);
        extras.clickAddNewItem();
        Thread.sleep(2000);

        AddExtras addExtras=new AddExtras(driver);
        String name = generateString();
        addExtras.fillInNewExtras(name);
        addExtras.clickSubmit();
        Thread.sleep(2000);

        searchQueryParams = new SearchQueryParams(driver);
        searchQueryParams.fillInSearch(name);
        searchQueryParams.clickSubmit();
        Thread.sleep(2000);

        Allure.addAttachment("addExtras", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

        extras=new Extras(driver);
        ArrayList<String> extra=extras.GetExtra();

        RequestExtras getExtras = ExtrasAPI.getInstance().getExtra();
        ExtrasItem ExtrasItem = getExtras.ExtrasItem.get(getExtras.ExtrasItem.size()-1);

        Assert.assertEquals(extra.get(0),ExtrasItem.id);
        Assert.assertEquals(extra.get(1),ExtrasItem.name);
    }

    @Test()
    public void editExtras() throws InterruptedException {
        ExtrasItem postExtras = ExtrasAPI.getInstance().PostExtra(generateString());
        String name = generateString();

        MainMenu mainMenu = new MainMenu(driver);
        mainMenu.pressMenuItem("Extras");
        Thread.sleep(2000);

        SearchQueryParams searchQueryParams = new SearchQueryParams(driver);
        searchQueryParams.fillInSearch(postExtras.name);
        searchQueryParams.clickSubmit();
        Thread.sleep(2000);

        Extras extras=new Extras(driver);
        extras.clickEditItem();
        Thread.sleep(2000);

        EditExtras editExtras = new EditExtras(driver);
        editExtras.fillInUpdate(name);
        editExtras.clickSubmit();
        Thread.sleep(2000);

        searchQueryParams = new SearchQueryParams(driver);
        searchQueryParams.fillInSearch(name);
        searchQueryParams.clickSubmit();
        Thread.sleep(2000);

        Allure.addAttachment("editExtras", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

        extras=new Extras(driver);
        ArrayList<String> extra=extras.GetExtra();

        Assert.assertEquals(extra.get(0),postExtras.id);
        Assert.assertEquals(extra.get(1),name);
    }

    @Test()
    public void deleteExtras() throws InterruptedException {
        ExtrasItem postExtras = ExtrasAPI.getInstance().PostExtra(generateString());

        MainMenu mainMenu = new MainMenu(driver);
        mainMenu.pressMenuItem("Extras");
        Thread.sleep(2000);

        SearchQueryParams searchQueryParams = new SearchQueryParams(driver);
        searchQueryParams.fillInSearch(postExtras.name);
        searchQueryParams.clickSubmit();
        Thread.sleep(2000);

        Allure.addAttachment("deleteExtras", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

        Extras extras=new Extras(driver);
        extras.clickDeleteItem();

        boolean IsEmpty=mainMenu.CheckIfEmpty();
        Assert.assertEquals(IsEmpty,true);
    }

    @AfterMethod
    public void AfterTest() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
    }
}
