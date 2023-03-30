package ResponseObject.ResponseSingleUser;

import ResponseObject.ResponseValidator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.testng.Assert;

import java.util.List;

public class ResponseSingleUserSuccess implements ResponseValidator {

    @JsonProperty("data")
    private List<SingleUserData> data;
    @JsonProperty("support")
    private SingleUserSupport support;

    @Override
    public void ValidateResponse() {
        Assert.assertNotNull(data);
        for (Integer index = 0; index < data.size(); index++){
            data.get(index).ValidateResponse();
        }
        Assert.assertNotNull(support);
        support.ValidateResponse();
    }
}
