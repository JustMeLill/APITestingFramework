package ResponseObject.ResponseLogin;

import ResponseObject.ResponseSpecificValidator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.testng.Assert;

public class ResponseLoginFailed implements ResponseSpecificValidator {

    @JsonProperty("error")
    public String Error;

    public void ValidateResponse(String expected) {
        Assert.assertEquals(Error, expected);
    }

}
