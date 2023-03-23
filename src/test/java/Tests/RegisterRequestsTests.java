package Tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterRequestsTests {

    @Test(priority = 1)
    public void postRegisterSuccessTest (){
        RequestSpecification Request = RestAssured.given();
        Request.header("Content-Type", "application/json");
        JSONObject RequestBody = new JSONObject();
        RequestBody.put("email", "eve.holt@reqres.in");
        RequestBody.put("password", "pistol");
        Request.body(RequestBody.toString());

        Response response = Request.post("https://reqres.in/api/register");
        ResponseBody Body = response.getBody();

        System.out.println(Body.asString());
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 2)
    public void postRegisterUnSuccessfulTest (){
        RequestSpecification Request = RestAssured.given();
        Request.header("Content-Type", "application/json");
        JSONObject RequestBody = new JSONObject();
        RequestBody.put("email", "sydney@fife");
        Request.body(RequestBody.toString());

        Response response = Request.post("https://reqres.in/api/register");
        ResponseBody Body = response.getBody();

        System.out.println(Body.asString());
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 400);
    }

}
