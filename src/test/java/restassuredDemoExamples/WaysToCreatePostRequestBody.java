package restassuredDemoExamples;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

public class WaysToCreatePostRequestBody {
    //Using hashmap
    
    
    
    @Test
    public void UsingHashmap(){
       HashMap data= new HashMap();
        String[] courses= {"a","b"};
        data.put("aa", "b");
        data.put("b", courses);
        
        given().contentType("application/json")
                .body(data)
                .when()
                .post()
                .then().statusCode(200).body("",equalToPath(""));
    }
    
    //using org.json library
    @Test
    public void Usingorgjson(){
       JSONObject data= new JSONObject();
        String[] courses= {"a","b"};
        data.put("aa", "b");
        data.put("b", courses);
        
        given().contentType("application/json")
                .body(data.toString())
                .when()
                .post()
                .then().statusCode(200).body("name", equalToPath(""));
    }
    
  //using pojo classes
    @Test
    public void UsingPOJOClasses(){
      POJO data= new POJO();
      String[] courses= {};
      data.setName("abc");
      data.setCourses(courses);
      
       
        
        given().contentType("application/json")
                .body(data)
                .when()
                .post()
                .then().statusCode(200).body("name", equalToPath(""));
    }
    
  //using external json file
    @Test
    public void UsingExternalJsonFile() throws FileNotFoundException{
      File file= new File(".\\filename.json");
      FileReader fr= new FileReader(file);
      JSONTokener jt= new JSONTokener(fr);
      JSONObject data= new JSONObject(jt);
      
       
        
        given().contentType("application/json")
                .body(data)
                .when()
                .post()
                .then().statusCode(200).body("name", equalToPath(""));
    }
}

