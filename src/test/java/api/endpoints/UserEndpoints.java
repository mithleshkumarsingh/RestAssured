package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

import api.payloads.User;

public class UserEndpoints {
    public static Response createUser(User payload){
        return given().header("accept","application/json").header("Content-Type", "application/json").body(payload).when().post(Routes.createUser);
        }
    
    public static Response readUser(String  userName){
        return given().pathParam("username", userName).when().get(Routes.getUser);
        }
    
    public static Response updateUser(User payload,String  userName){
        return given().contentType(ContentType.JSON).accept(ContentType.JSON).pathParam("username", userName).body(payload).when().put(Routes.updateUser);
        }
   
    public static Response deleteUser(String  userName){
        return given().pathParam("username", userName).when().delete(Routes.deleteUser);
        }
}
