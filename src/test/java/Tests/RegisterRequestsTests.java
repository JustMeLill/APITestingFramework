package Tests;

import RequestObject.RequestMethodType;
import RequestObject.RequestRegister.RequestRegister;
import RequestObject.RequestURLType;
import ResponseObject.ResponseBodyType;
import ResponseObject.ResponseCodeType;
import ResponseObject.ResponseHelper;
import SharedData.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class RegisterRequestsTests extends BaseTest {

    @Test(priority = 1)
    public void postRegisterSuccessTest (){

        RequestRegister RequestSuccess = new RequestRegister.RequestRegisterBuilder().Email("eve.holt@reqres.in").Password("pistol").build();
        Response response = requestHelper.performRequest(RequestMethodType.POST_METHOD, baseURL + RequestURLType.POST_REGISTER, RequestSuccess);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_REGISTER, ResponseCodeType.STATUS_200);
        responseHelper.printResponseBody();

    }

    @Test(priority = 2)
    public void postRegisterUnSuccessfulTest (){

        RequestRegister RequestFailed = new RequestRegister.RequestRegisterBuilder().Email("sydney@fife").build();
        Response response = requestHelper.performRequest(RequestMethodType.POST_METHOD, baseURL + RequestURLType.POST_REGISTER, RequestFailed);

        String expectedError = "Missing password";
        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_REGISTER, ResponseCodeType.STATUS_400, expectedError);
        responseHelper.printResponseBody();


    }

}
