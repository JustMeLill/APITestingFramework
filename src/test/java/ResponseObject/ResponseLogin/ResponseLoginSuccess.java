package ResponseObject.ResponseLogin;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.testng.Assert;

public class ResponseLoginSuccess {

    @JsonProperty("token")
    private String Token;

    public void ValidateResponse(){
        Assert.assertNotNull(Token);
    }
}
