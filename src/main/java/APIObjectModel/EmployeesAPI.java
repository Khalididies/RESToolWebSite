package APIObjectModel;

import APIObjectModel.APIEmployeesObject.EmployeesItem;
import APIObjectModel.APIEmployeesObject.RequestEmployees;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class EmployeesAPI {
    private static EmployeesAPI instance;
    private static String API_ADDRESS = "https://restool-sample-app.herokuapp.com/api";

    public static EmployeesAPI getInstance() {
        if (instance == null) {
            instance = new EmployeesAPI();
        }
        return instance;
    }


    public RequestEmployees getEmployee() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String response = HttpUtil.HttpGet(API_ADDRESS + "/employee");
            return mapper.readValue(response, RequestEmployees.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public RequestEmployees getEmployeeById(String ID) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String response = HttpUtil.HttpGet(API_ADDRESS + "/employee/"+ID);
            return mapper.readValue(response, RequestEmployees.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public EmployeesItem PostEmployee( String name, String jobTitle, boolean isFired) {
        ObjectMapper mapper = new ObjectMapper();
        String json ="{\n" +
                "  \"name\": \""+name+"\",\n" +
                "  \"jobTitle\": \""+jobTitle+"\",\n" +
                "  \"isFired\": \""+isFired+"\"\n" +
                "}";
        try {
            String response = HttpUtil.HttpPost(API_ADDRESS , "/employee", json);
            return mapper.readValue(response, EmployeesItem.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String DeletEmployee(String ID) {
        String response = HttpUtil.HttpDelete(API_ADDRESS + "/employee/" + ID);
        return response;
    }

    public String PutEmployee( String ID,String name, String jobTitle, boolean isFired) {
        String json ="{\n" +
                "  \"name\": \""+name+"\",\n" +
                "  \"jobTitle\": \""+jobTitle+"\",\n" +
                "  \"isFired\": \""+isFired+"\"\n" +
                "}";

        String response = HttpUtil.HttpPut(API_ADDRESS , "/employee/"+ ID ,json);
        return response;
    }
}
