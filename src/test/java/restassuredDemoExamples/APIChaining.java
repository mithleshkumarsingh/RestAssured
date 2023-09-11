package restassuredDemoExamples;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class APIChaining {
    @Test
    public void getAttributevalueAndUseacross(ITestContext context){
        int value=0;
        context.setAttribute("name", value);// this will be available only at the test level.
        context.getSuite().setAttribute("name", value);// This will be available at the suite level.
        int id= (Integer) context.getSuite().getAttribute("name");
    }

}
