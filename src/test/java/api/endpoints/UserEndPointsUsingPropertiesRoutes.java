package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPointsUsingPropertiesRoutes {
    
   public static ResourceBundle getUrl(){
        return  ResourceBundle.getBundle("routes");
    }
   public static Response createUser(User payload){
      String url= getUrl().getString("post_url");
       return given().header("accept","application/json").header("Content-Type", "application/json").body(payload).when().post(url);
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
