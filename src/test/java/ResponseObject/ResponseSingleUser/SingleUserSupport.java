package ResponseObject.ResponseSingleUser;

import ResponseObject.ResponseValidator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.testng.Assert;

public class SingleUserSupport implements ResponseValidator {
    @JsonProperty("url")
    private String url;
    @JsonProperty("text")
    private String text;

    @Override
    public void ValidateResponse() {
        Assert.assertNotNull(url);
        Assert.assertNotNull(text);
    }
}
