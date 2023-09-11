package restassuredDemoExamples;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

import javax.print.DocFlavor.STRING;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.matcher.RestAssuredMatchers.*;
public class ParsingJsonResponseData {
    
    @Test
    public void validateJsonREsponse(){
       // given().when().get("www.google.com").then().body("book[3].title", equalToPath(""));
        
        Response response = given().when().get("www.google.com");
        String object = response.jsonPath().get("book[3].title").toString();
        
       Assert.assertEquals(object,"lord of the rings");
       JSONObject js= new JSONObject(response.toString());
       for(int i=0;i<js.getJSONArray("abc").length();i++){
           String text= js.getJSONArray("abc").getJSONObject(i).get("title").toString();
       }
    }

}
