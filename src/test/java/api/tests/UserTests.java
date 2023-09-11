package api.tests;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.payloads.User;
import org.apache.logging.log4j.LogManager;
import io.restassured.response.Response;
import junit.framework.Assert;

public class UserTests {
   Faker faker;
   User payload;
   public Logger logger=LogManager.getLogger(this.getClass());
    @BeforeTest
    public void setupData(){
        faker= new Faker();
        payload= new User();
        payload.setId(faker.idNumber().hashCode());
        payload.setUsername(faker.name().username());
        System.out.println("Hello world "+payload.getUsername());
        payload.setFirstName(faker.name().firstName());
        payload.setLastName(faker.name().lastName());
        payload.setEmail(faker.internet().safeEmailAddress());
        payload.setPassword(faker.internet().password(1,5));
        payload.setPhone(faker.phoneNumber().cellPhone());   
        payload.getUserStatus();
        
    }
    
    @Test(priority=0)
    public void createUser(){
        Response res=UserEndpoints.createUser(payload);
        res.then().log().all();
        Assert.assertEquals(res.getStatusCode(), 200);
    }
    
    @Test(priority=1)
    public void ReadUser(){
        System.out.println("This is the user name"+payload.getUsername());
        Response res=UserEndpoints.readUser(payload.getUsername());
        res.then().log().all();
        Assert.assertEquals(res.getStatusCode(), 200);
    }

}
