package restassuredDemoExamples;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ParsingXMLData {
    @Test
    public void getXmlData(){
        Response res= when().get("https:www.google.com");
       String value= res.xmlPath().get("").toString();
       Assert.assertEquals(value, "1");
       
       
       XmlPath x= new XmlPath(res.toString());
       List<String>l=x.getList("");
    }

}
