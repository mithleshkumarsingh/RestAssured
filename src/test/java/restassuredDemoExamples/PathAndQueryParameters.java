package restassuredDemoExamples;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

public class PathAndQueryParameters {
    @Test
    public void PathAndQueryParams(){
        given().pathParam("a", "parameter name in the url")
        .queryParam("b", "parameter name in the url")
        .queryParam("c", "parameter name in the url")
        .when().get("https://reqres.in/api/{a}");
        
    }

}
