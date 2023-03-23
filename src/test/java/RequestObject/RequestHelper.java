package RequestObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestHelper {

    private RequestSpecification Request;
    private Response response;

    public RequestHelper() {
        Request = RestAssured.given();
        Request.header("Content-Type", "application/json");
    }


    public Response performRequest (String requestType, String endpoint, Object body){
        switch (requestType){
            case "get":
                response = Request.get(endpoint);
                break;
            case "post":
                Request.body(body);
                response = Request.post(endpoint);
                break;
        }
        return response;
    }


}
