package ResponseObject;

import RequestObject.RequestHelper;
import ResponseObject.ResponseLogin.ResponseLoginFailed;
import ResponseObject.ResponseLogin.ResponseLoginSuccess;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;

public class ResponseHelper {

    private Response response;

    public ResponseHelper(Response response) {
        this.response = response;
    }

    public void validateResponseCode (Integer expected){
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), expected);
    }

    public void validateResponse (String ResponseType, Integer ResponseCode){
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), ResponseCode);
        if(ResponseType.equals(ResponseBodyType.RESPONSE_LOGIN)){
            switch (ResponseCode){
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
    }

    public void printResponseBody(){
        ResponseBody Body = response.getBody();
        System.out.println(Body.asString());
    }

}
