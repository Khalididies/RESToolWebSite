package APIObjectModel;

import APIObjectModel.APIDeadsObject.DeadsItem;
import APIObjectModel.APIDeadsObject.RequestDeads;
import APIObjectModel.APIExtrasObject.ExtrasItem;
import APIObjectModel.APIExtrasObject.RequestExtras;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ExtrasAPI {
    private static ExtrasAPI instance;
    private static String API_ADDRESS = "http://localhost:3000/api";

    public static ExtrasAPI getInstance() {
        if (instance == null) {
            instance = new ExtrasAPI();
        }
        return instance;
    }


    public RequestExtras getExtra() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String response = HttpUtil.HttpGet(API_ADDRESS + "/extra");
            return mapper.readValue(response, RequestExtras.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public RequestExtras getExtraById(String Id) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String response = HttpUtil.HttpGet(API_ADDRESS + "/extra/"+Id);
            return mapper.readValue(response, RequestExtras.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ExtrasItem PostExtra(String name) {
        ObjectMapper mapper = new ObjectMapper();
        String json ="{\n" +
                "  \"name\": \""+name+"\"\n" +
                "}";
        try {
            String response = HttpUtil.HttpPost(API_ADDRESS , "/extra", json);
            return mapper.readValue(response, ExtrasItem.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String DeleteExtra(String ID) {
        String response = HttpUtil.HttpDelete(API_ADDRESS + "/extra/" + ID);
        return response;
    }

    public String PutExtra( String ID, String name) {
        String json ="{\n" +
                "  \"name\": \""+name+"\"\n" +
                "}";

        String response = HttpUtil.HttpPut(API_ADDRESS , "/extra/"+ ID ,json);
        return response;
    }
}
