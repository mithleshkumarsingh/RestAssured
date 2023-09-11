package restassuredDemoExamples;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
public class SerializationDeserialization {
    
    @Test//Serialization
    public void ConvertPojoToJson() throws JsonProcessingException{
        POJO data= new POJO();
        String[] courses= {};
        data.setName("abc");
        data.setCourses(courses);
        ObjectMapper obj= new ObjectMapper();
        String writeValueAsString = obj.writerWithDefaultPrettyPrinter().writeValueAsString(data);
        System.out.println(writeValueAsString);
    }
    
    @Test//Serialization
    public void ConvertjsonToPojo() throws JsonProcessingException{
        String str= "provide a json here";
        ObjectMapper obj= new ObjectMapper();
        POJO readValue = obj.readValue(str, POJO.class);
        readValue.getName();
    }

}
