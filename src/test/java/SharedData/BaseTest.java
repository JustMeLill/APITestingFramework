package SharedData;

import RequestObject.RequestHelper;
import ResponseObject.ResponseHelper;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public RequestHelper requestHelper;
    public ResponseHelper responseHelper;

    public String baseURL = "https://reqres.in/";

    @BeforeMethod
    public void Setup(){
        requestHelper = new RequestHelper();

    }
}
