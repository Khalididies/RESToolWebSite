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
import Utils.AttachFiles;
import Utils.ReadCsvFile;
import org.junit.Assert;
import org.testng.annotations.*;
import java.io.IOException;
import java.util.List;

import static Entities.Generate.generateString;

public class APITestCase {

    @DataProvider
    public static Object[][] getData() throws Exception{
        List<String[]> lines = ReadCsvFile.readAllLines("files/input.csv");
        lines.remove(0);
        Object[][] data = new Object[lines.size()][lines.get(0).length];
        int index = 0;
        for(String[] line : lines) {
            data[index] = line;
            index++;
        }
        return data;
    }

    @Test(dataProvider = "getData")
    public void addCastAndCharactersAPI(String thumbnail, String name, String realName, String location, String isAlive)  {
        CharacterItem postCharacter = CharacterAPI.getInstance().PostCharacter(thumbnail,name,realName,location,true);


        RequestCharacter getCharacter = CharacterAPI.getInstance().getCharacter();
        CharacterItem Character = getCharacter.characterItems.get(getCharacter.characterItems.size() - 1);

        Assert.assertEquals(Character.id,postCharacter.id);
        Assert.assertEquals(Character.name,postCharacter.name);
        Assert.assertEquals(Character.realName,postCharacter.realName);
        Assert.assertEquals(Character.location,postCharacter.location);
        Assert.assertEquals(Character.thumbnail,postCharacter.thumbnail);
        Assert.assertEquals(Character.isAlive,postCharacter.isAlive);
    }

    @Test(dataProvider = "getData")
    public void editCastAndCharactersAPI(String thumbnail, String name, String realName, String location, String isAlive) {
        CharacterItem postCharacter = CharacterAPI.getInstance().PostCharacter(thumbnail,name,realName,location,true);
        String Newlocation = generateString();

        String putCharacter = CharacterAPI.getInstance().PutCharacter(postCharacter.id,Newlocation,false);

        RequestCharacter getCharacter = CharacterAPI.getInstance().getCharacter();
        CharacterItem Character = getCharacter.characterItems.get(getCharacter.characterItems.size() - 1);

        Assert.assertEquals(putCharacter,"ok");
        Assert.assertEquals(Character.id,postCharacter.id);
        Assert.assertEquals(Character.name,postCharacter.name);
        Assert.assertEquals(Character.realName,postCharacter.realName);
        Assert.assertEquals(Character.location,Newlocation);
        Assert.assertEquals(Character.thumbnail,postCharacter.thumbnail);
        Assert.assertEquals(Character.isAlive,false);
    }

    @Test(dataProvider = "getData")
    public void deleteCastAndCharactersAPI(String thumbnail, String name, String realName, String location, String isAlive) {
        CharacterItem postCharacter = CharacterAPI.getInstance().PostCharacter(thumbnail,name,realName,location,true);

        String deleteCharacter = CharacterAPI.getInstance().DeleteCharacter(postCharacter.id);

        RequestCharacter getCharacter = CharacterAPI.getInstance().getCharacterById(postCharacter.id);

        Assert.assertEquals(deleteCharacter,"ok");
        Assert.assertEquals(getCharacter,null);
    }

    @Test(dataProvider = "getData")
    public void addEmployeesAPI(String thumbnail, String name, String realName, String location, String isAlive)  {
        EmployeesItem postEmployees = EmployeesAPI.getInstance().PostEmployee(name,location,true);

        RequestEmployees getEmployees = EmployeesAPI.getInstance().getEmployee();
        EmployeesItem Employees = getEmployees.EmployeesItem.get(getEmployees.EmployeesItem.size() - 1);

        Assert.assertEquals(postEmployees.id,Employees.id);
        Assert.assertEquals(postEmployees.name,Employees.name);
        Assert.assertEquals(postEmployees.jobTitle,Employees.jobTitle);
        Assert.assertEquals(postEmployees.isFired,Employees.isFired);
    }

    @Test(dataProvider = "getData")
    public void editEmployeesAPI(String thumbnail, String name, String realName, String location, String isAlive) {
        EmployeesItem postEmployees = EmployeesAPI.getInstance().PostEmployee(name,location,true);
        String newName = generateString();
        String newJob = generateString();

        String putEmployees = EmployeesAPI.getInstance().PutEmployee(postEmployees.id,newName,newJob,true);

        RequestEmployees getEmployees = EmployeesAPI.getInstance().getEmployee();
        EmployeesItem Employees = getEmployees.EmployeesItem.get(getEmployees.EmployeesItem.size() - 1);

        Assert.assertEquals(putEmployees,"ok");
        Assert.assertEquals(postEmployees.id,Employees.id);
        Assert.assertEquals(newName,Employees.name);
        Assert.assertEquals(newJob,Employees.jobTitle);
        Assert.assertEquals(postEmployees.isFired,Employees.isFired);
    }

    @Test(dataProvider = "getData")
    public void DeleteEmployeesAPI(String thumbnail, String name, String realName, String location, String isAlive) {
        EmployeesItem postEmployees = EmployeesAPI.getInstance().PostEmployee(name,location,true);

        String deleteEmployees = EmployeesAPI.getInstance().DeletEmployee(postEmployees.id);

        RequestEmployees getEmployees = EmployeesAPI.getInstance().getEmployeeById(postEmployees.id);

        Assert.assertEquals(deleteEmployees,"ok");
        Assert.assertEquals(getEmployees,null);
    }

    @Test(dataProvider = "getData")
    public void addDeadsAPI(String thumbnail, String name, String realName, String location, String isAlive) {
        DeadsItem postDeads = DeadsAPI.getInstance().PostDead(name,location);

        RequestDeads getDeads = DeadsAPI.getInstance().getDead();
        DeadsItem Dead = getDeads.DeadsItem.get(getDeads.DeadsItem.size()-1);

        Assert.assertEquals(postDeads.id,Dead.id);
        Assert.assertEquals(postDeads.name,Dead.name);
        Assert.assertEquals(postDeads.reason,Dead.reason);
    }

    @Test(dataProvider = "getData")
    public void editDeadsAPI(String thumbnail, String name, String realName, String location, String isAlive) {
        DeadsItem postDeads = DeadsAPI.getInstance().PostDead(name,location);
        String newName = generateString();
        String newReason = generateString();

        String putDeads= DeadsAPI.getInstance().PutDead(postDeads.id,newName,newReason);

        RequestDeads getDeads = DeadsAPI.getInstance().getDead();
        DeadsItem Dead = getDeads.DeadsItem.get(getDeads.DeadsItem.size()-1);

        Assert.assertEquals(putDeads,"ok");
        Assert.assertEquals(postDeads.id,Dead.id);
        Assert.assertEquals(newName,Dead.name);
        Assert.assertEquals(newReason,Dead.reason);
    }

    @Test(dataProvider = "getData")
    public void deleteDeadsAPI(String thumbnail, String name, String realName, String location, String isAlive) {
        DeadsItem postDeads = DeadsAPI.getInstance().PostDead(name,location);

        String deleteDeads = DeadsAPI.getInstance().DeleteDead(postDeads.id);

        RequestDeads getDeads = DeadsAPI.getInstance().getDeadById(postDeads.id);

        Assert.assertEquals(deleteDeads,"ok");
        Assert.assertEquals(getDeads,null);
    }

    @Test(dataProvider = "getData")
    public void addExtrasAPI(String thumbnail, String name, String realName, String location, String isAlive) {
        ExtrasItem postExtras = ExtrasAPI.getInstance().PostExtra(name);

        RequestExtras getExtras = ExtrasAPI.getInstance().getExtra();
        ExtrasItem Extra = getExtras.ExtrasItem.get(getExtras.ExtrasItem.size()-1);

        Assert.assertEquals(postExtras.id,Extra.id);
        Assert.assertEquals(postExtras.name,Extra.name);
    }

    @Test(dataProvider = "getData")
    public void editExtrasAPI(String thumbnail, String name, String realName, String location, String isAlive) {
        ExtrasItem postExtras = ExtrasAPI.getInstance().PostExtra(name);

        String putExtras= ExtrasAPI.getInstance().PutExtra(postExtras.id,realName);

        RequestExtras getExtras = ExtrasAPI.getInstance().getExtra();
        ExtrasItem Extra = getExtras.ExtrasItem.get(getExtras.ExtrasItem.size()-1);

        Assert.assertEquals(putExtras,"ok");
        Assert.assertEquals(postExtras.id,Extra.id);
        Assert.assertEquals(realName,Extra.name);
    }

    @Test(dataProvider = "getData")
    public void deleteExtrasAPI(String thumbnail, String name, String realName, String location, String isAlive) {
        ExtrasItem postExtras = ExtrasAPI.getInstance().PostExtra(name);

        String deleteExtras = ExtrasAPI.getInstance().DeleteExtra(postExtras.id);

        RequestExtras getExtras = ExtrasAPI.getInstance().getExtraById(postExtras.id);

        Assert.assertEquals(deleteExtras,"ok");
        Assert.assertEquals(getExtras,null);
    }

    @AfterSuite
    public void afterSuiteAPI() throws IOException {
        AttachFiles.attachCsv("files/input.csv", "input.csv");
    }
}
