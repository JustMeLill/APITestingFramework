package ResponseObject.ResponseLogin;

import ResponseObject.ResponseValidator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.testng.Assert;

public class ResponseLoginFailed implements ResponseValidator {

    @JsonProperty("error")
    public String Error;

    public void ValidateResponse() {
        Assert.assertNotNull(Error);
    }

}
