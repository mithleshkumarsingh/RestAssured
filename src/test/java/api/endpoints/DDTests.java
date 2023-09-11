package api.endpoints;

import org.testng.annotations.Test;

import api.payloads.User;
import api.utilities.DataProviders;

public class DDTests {
    @Test(priority=0,dataProvider="Data", dataProviderClass=DataProviders.class) 
    public void testPostUser(String userId, String usreName, String fname, String lname,String userEmail, String pwd, String ph){
        User payload= new User();
        payload.setId(Integer.parseInt(userId));
        payload.setUsername(usreName);
        payload.setFirstName(fname);
        payload.setLastName(lname);
        payload.setEmail(userEmail);
        payload.setPassword(pwd);
        payload.setPhone(ph);   
        
        UserEndpoints.createUser(payload);
    }

}
