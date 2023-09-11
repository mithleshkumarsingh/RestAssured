package restassuredDemoExamples;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.matcher.RestAssuredMatchers.*;

public class CookiesAndHeaders {
    @Test
    public void getCookies(){
        //given().when().get("www.google.com ").then().cookie("key","value");
      Response res=given().contentType("ContentType.JSON").when().get("https://www.google.com ");
      String cookie = res.getCookie("AEC");
      System.out.println("This is cookie id  "+cookie);
      //String header=res.getHeader("");
      Headers headers = res.getHeaders();
      headers.forEach(m->System.out.println("Hi these are the headers "+m.getName()+ " "+m.getValue()));
      
      //given().when().get("www.google.com ").then().header("key","value").header("key","value");

        
    }

}
