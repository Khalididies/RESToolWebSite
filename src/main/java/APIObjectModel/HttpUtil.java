package APIObjectModel;

import io.restassured.specification.RequestSpecification;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HttpUtil {
    public static String HttpGet(String url) {
        try {
            Response response = RestAssured.get(url);
            StringBuilder stringBuilder = inputStreamToString(response.asInputStream());
            String s = stringBuilder.toString();
            return s;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String HttpPost(String baseUrl,String route, String request_body) {

        try {
            RestAssured.baseURI =baseUrl;
            RequestSpecification request = RestAssured.given().body(request_body);
            request.header("Content-Type", "application/json");
            Response response = request.post(route);
            StringBuilder stringBuilder = inputStreamToString(response.asInputStream());
            String s = stringBuilder.toString();
            return s;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String HttpDelete(String url) {
        try {
            Response response = RestAssured.delete(url);
            StringBuilder stringBuilder = inputStreamToString(response.asInputStream());
            String s = stringBuilder.toString();
            return s;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String HttpPut(String baseUrl,String route, String request_body)  {
        try {
            RestAssured.baseURI =baseUrl;
            RequestSpecification request = RestAssured.given().body(request_body);
            request.header("Content-Type", "application/json");
            Response response = request.put(route);
            StringBuilder stringBuilder = inputStreamToString(response.asInputStream());
            String s = stringBuilder.toString();
            return s;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static StringBuilder inputStreamToString(InputStream is) throws IOException {
        String line = "";
        StringBuilder total = new StringBuilder();

        // Wrap a BufferedReader around the InputStream
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));

        // Read response until the end
        while ((line = rd.readLine()) != null) {
            total.append(line);
        }
        // Return full string
        return total;
    }
}
