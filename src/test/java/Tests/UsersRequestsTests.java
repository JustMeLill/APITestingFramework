package Tests;

import RequestObject.RequestMethodType;
import RequestObject.RequestURLType;
import ResponseObject.ResponseBodyType;
import ResponseObject.ResponseCodeType;
import ResponseObject.ResponseHelper;
import SharedData.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class UsersRequestsTests extends BaseTest {

    @Test(priority = 1)
    public void getListUsersTest(){

        Response response = requestHelper.performRequest(RequestMethodType.GET_METHOD, baseURL + RequestURLType.GET_LIST_USERS, null);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_USERS, ResponseCodeType.STATUS_200);
        responseHelper.printResponseBody();


    }

    @Test(priority = 2)
    public void getSingleUserTest(){

        Response response = requestHelper.performRequest(RequestMethodType.GET_METHOD, baseURL + RequestURLType.GET_SINGLE_USER, null);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponseCode(ResponseCodeType.STATUS_200);

    }

    @Test(priority = 3)
    public void getSingleUserNotFound(){

        Response response = requestHelper.performRequest(RequestMethodType.GET_METHOD, baseURL + RequestURLType.GET_SINGLE_USER_NOTFOUND, null);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_USERS, ResponseCodeType.STATUS_404);
        responseHelper.printResponseBody();

    }

    @Test(priority = 4)
    public void getDelayedResponseTest(){

        Response response = requestHelper.performRequest(RequestMethodType.GET_METHOD, baseURL + RequestURLType.GET_DELAYED_RESPONSE, null);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_USERS, ResponseCodeType.STATUS_200);
        responseHelper.printResponseBody();

    }








}
