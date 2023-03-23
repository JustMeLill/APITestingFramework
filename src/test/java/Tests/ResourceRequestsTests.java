package Tests;

import RequestObject.RequestMethodType;
import RequestObject.RequestURLType;
import ResponseObject.ResponseBodyType;
import ResponseObject.ResponseCodeType;
import ResponseObject.ResponseHelper;
import SharedData.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ResourceRequestsTests extends BaseTest {

    @Test (priority = 1)
    public void getListResourceTest(){

        Response response = requestHelper.performRequest(RequestMethodType.GET_METHOD, baseURL + RequestURLType.GET_LIST_RESOURCES, null);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_RESOURCES, ResponseCodeType.STATUS_200);
        responseHelper.printResponseBody();

    }

    @Test (priority = 2)
    public void getSingleResourceTest(){

        Response response = requestHelper.performRequest(RequestMethodType.GET_METHOD, baseURL + RequestURLType.GET_SINGLE_RESOURCE, null);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_RESOURCE, ResponseCodeType.STATUS_200);
        responseHelper.printResponseBody();

    }

    @Test (priority = 3)
    public void getSingleResourceNotFoundTest(){

        Response response = requestHelper.performRequest(RequestMethodType.GET_METHOD, baseURL + RequestURLType.GET_RESOURCE_NOTFOUND, null);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_RESOURCE, ResponseCodeType.STATUS_404);
        responseHelper.printResponseBody();

    }


}
