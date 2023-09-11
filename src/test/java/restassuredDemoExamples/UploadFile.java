package restassuredDemoExamples;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

import java.io.File;

import org.testng.annotations.Test;

public class UploadFile {
    @Test
    public void uploadsingleFile(){
        File file= new File("");
        
        given().multiPart("file",file).contentType("multipart/form-data").
        when().post()
        .then().statusCode(200);
        
    }

}
