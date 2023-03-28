package ResponseObject.ResponseRegister;

import ResponseObject.ResponseSpecificValidator;
import ResponseObject.ResponseValidator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.testng.Assert;

public class ResponseRegisterFailed implements ResponseSpecificValidator {

    @JsonProperty("error")
    public String Error;

    public void ValidateResponse(String expected){
        Assert.assertEquals(Error, expected);
    }
}
