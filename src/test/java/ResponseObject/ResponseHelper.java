package ResponseObject;

import RequestObject.RequestHelper;
import ResponseObject.ResponseLogin.ResponseLoginFailed;
import ResponseObject.ResponseLogin.ResponseLoginSuccess;
import ResponseObject.ResponseRegister.ResponseRegisterFailed;
import ResponseObject.ResponseRegister.ResponseRegisterSuccess;
import ResponseObject.ResponseResource.ResponseResourceSuccess;
import ResponseObject.ResponseResources.ResponseResourcesSuccess;
import ResponseObject.ResponseUser.ResponsePostUser;
import ResponseObject.ResponseUser.ResponsePutPatchUser;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;

public class ResponseHelper {

    private Response response;

    public ResponseHelper(Response response) {
        this.response = response;
    }

    public void validateResponseCode(Integer expected) {
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), expected);
    }

    public void validateResponse(String ResponseType, Integer ResponseCode) {
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), ResponseCode);
        if (ResponseType.equals(ResponseBodyType.RESPONSE_LOGIN)) {
            switch (ResponseCode) {
                case 200:
                    ResponseLoginSuccess ResponseLoginSuccess = response.getBody().as(ResponseLoginSuccess.class);
                    ResponseLoginSuccess.ValidateResponse();
                    break;
                case 400:
                    ResponseLoginFailed ResponseLoginFailed = response.getBody().as(ResponseLoginFailed.class);
                    ResponseLoginFailed.ValidateResponse();
                    break;
            }
        }

        if (ResponseType.equals(ResponseBodyType.RESPONSE_REGISTER)) {
            switch (ResponseCode) {
                case 200:
                    ResponseRegisterSuccess responseRegisterSuccess = response.getBody().as(ResponseRegisterSuccess.class);
                    responseRegisterSuccess.ValidateResponse();
                    break;
                case 400:
                    ResponseRegisterFailed responseRegisterFailed = response.getBody().as(ResponseRegisterFailed.class);
                    responseRegisterFailed.ValidateResponse();
                    break;
            }
        }

        if (ResponseType.equals(ResponseBodyType.RESPONSE_RESOURCES)) {
            switch (ResponseCode) {
                case 200:
                    ResponseResourcesSuccess responseResourcesSuccess = response.getBody().as(ResponseResourcesSuccess.class);
                    responseResourcesSuccess.ValidateResponse();
                    break;
            }

            if (ResponseType.equals(ResponseBodyType.RESPONSE_RESOURCE)) {
                switch (ResponseCode) {
                    case 200:
                        ResponseResourceSuccess responseResourceSuccess = response.getBody().as(ResponseResourceSuccess.class);
                        responseResourceSuccess.ValidateResponse();
                        break;
                    case 400:
                        Assert.assertNotNull(response);
                        break;
                }
            }

            if (ResponseType.equals(ResponseBodyType.RESPONSE_USER)) {
                switch (ResponseCode) {
                    case 201:
                        ResponsePostUser responsePostUser = response.getBody().as(ResponsePostUser.class);
                        responsePostUser.ValidateResponse();
                        break;
                    case 200:
                        ResponsePutPatchUser responsePutPatch = response.getBody().as(ResponsePutPatchUser.class);
                        responsePutPatch.ValidateResponse();
                        break;
                    case 204:
                        Assert.assertNotNull(response.getBody());
                        break;

                }

            }

        }

    }

    public void printResponseBody () {
        ResponseBody Body = response.getBody();
        System.out.println(Body.asString());
    }
}

