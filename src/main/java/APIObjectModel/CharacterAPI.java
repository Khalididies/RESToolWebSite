package APIObjectModel;

import APIObjectModel.APICharacterObject.CharacterItem;
import APIObjectModel.APICharacterObject.RequestCharacter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class CharacterAPI {
    private static CharacterAPI instance;
    private static String API_ADDRESS = "https://restool-sample-app.herokuapp.com/api";

    public static CharacterAPI getInstance() {
        if (instance == null) {
            instance = new CharacterAPI();
        }
        return instance;
    }


    public RequestCharacter getCharacter() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String response = HttpUtil.HttpGet(API_ADDRESS + "/character");
            return mapper.readValue(response, RequestCharacter.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public RequestCharacter getCharacterById(String ID) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String response = HttpUtil.HttpGet(API_ADDRESS + "/character/"+ID);
            return mapper.readValue(response, RequestCharacter.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public CharacterItem PostCharacter(String thumbnail, String name, String realName, String location, boolean isAlive) {
        ObjectMapper mapper = new ObjectMapper();
        String json ="{\n" +
                "  \"thumbnail\": \""+thumbnail+"\",\n" +
                "  \"name\": \""+name+"\",\n" +
                "  \"realName\": \""+realName+"\",\n" +
                "  \"location\": \""+location+"\",\n" +
                "  \"isAlive\": \""+isAlive+"\"\n" +
                "}";
        try {
        String response = HttpUtil.HttpPost(API_ADDRESS , "/character", json);
            return mapper.readValue(response, CharacterItem.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String DeleteCharacter(String ID) {
        String response = HttpUtil.HttpDelete(API_ADDRESS + "/character/" + ID);
        return response;
    }

    public String PutCharacter( String ID, String location, boolean isAlive) {
        String json ="{\n" +
                "  \"location\": \""+location+"\",\n" +
                "  \"isAlive\": \""+isAlive+"\"\n" +
                "}";

            String response = HttpUtil.HttpPut(API_ADDRESS , "/character/"+ ID ,json);
            return response;
    }
}
