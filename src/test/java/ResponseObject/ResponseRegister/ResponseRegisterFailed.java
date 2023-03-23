package ResponseObject.ResponseRegister;

import ResponseObject.ResponseValidator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.testng.Assert;

public class ResponseRegisterFailed implements ResponseValidator {

    @JsonProperty("error")
    public String Error;

    public void ValidateResponse(){
        Assert.assertNotNull(Error);
    }
}
