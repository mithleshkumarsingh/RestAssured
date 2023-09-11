package restassuredDemoExamples;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

import org.testng.annotations.Test;


public class Authentication {
    @Test
    public void BasicAuthentication(){
        given().auth().basic("postman", "password").when().get("https://postman-echo.com/basic-auth").then().statusCode(200);
    }
    
    
    @Test
    public void DigestAuthentication(){
        given().auth().digest("postman", "password").when().get("https://postman-echo.com/basic-auth").then().statusCode(200);
    }
    
    @Test
    public void preemptiveAuthentication(){
        given().auth().preemptive().basic("postman", "password").when().get("https://postman-echo.com/basic-auth").then().statusCode(200);
    }
    
    @Test
    public void bearerTokenAuthentication(){
        String bearerToken="";
        given().headers("Authorization", "Bearer "+bearerToken).when().get("https://postman-echo.com/basic-auth").then().statusCode(200);
    }
    @Test
    public void OAuthAuthentication(){
        String bearerToken="";
        given().auth().oauth("ConsumerKey", "Consumer secret key", "AccessToken", "TokenSecret").when().get("https://postman-echo.com/basic-auth").then().statusCode(200);
    }

}
