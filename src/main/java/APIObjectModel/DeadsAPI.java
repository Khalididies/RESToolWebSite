package APIObjectModel;

import APIObjectModel.APIDeadsObject.DeadsItem;
import APIObjectModel.APIDeadsObject.RequestDeads;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class DeadsAPI {
    private static DeadsAPI instance;
    private static String API_ADDRESS = "https://restool-sample-app.herokuapp.com/api";

    public static DeadsAPI getInstance() {
        if (instance == null) {
            instance = new DeadsAPI();
        }
        return instance;
    }


    public RequestDeads getDead() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String response = HttpUtil.HttpGet(API_ADDRESS + "/dead");
            return mapper.readValue(response, RequestDeads.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public RequestDeads getDeadById(String Id) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String response = HttpUtil.HttpGet(API_ADDRESS + "/dead/"+Id);
            return mapper.readValue(response, RequestDeads.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public DeadsItem PostDead(String name, String reason) {
        ObjectMapper mapper = new ObjectMapper();
        String json ="{\n" +
                "  \"name\": \""+name+"\",\n" +
                "  \"reason\": \""+reason+"\"\n" +
                "}";
        try {
            String response = HttpUtil.HttpPost(API_ADDRESS , "/dead", json);
            return mapper.readValue(response, DeadsItem.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String DeleteDead(String ID) {
        String response = HttpUtil.HttpDelete(API_ADDRESS + "/dead/" + ID);
        return response;
    }

    public String PutDead( String ID, String name, String reason) {
        String json ="{\n" +
                "  \"name\": \""+name+"\",\n" +
                "  \"reason\": \""+reason+"\"\n" +
                "}";

        String response = HttpUtil.HttpPut(API_ADDRESS , "/dead/"+ ID ,json);
        return response;
    }
}
