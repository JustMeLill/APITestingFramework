package ResponseObject.ResponseLogin;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.testng.Assert;

public class ResponseLoginFailed {

    @JsonProperty("error")
    public String Error;

    public void ValidateResponse(){
        Assert.assertNotNull(Error);
    }
}
