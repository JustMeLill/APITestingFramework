package ResponseObject.ResponseUser;

import ResponseObject.ResponseValidator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.testng.Assert;

public class ResponsePutPatchUser implements ResponseValidator {

    @JsonProperty("name")
    public String Name;

    @JsonProperty("job")
    public String Job;

    @JsonProperty("updatedAt")
    public String UpdatedAt;

    public void ValidateResponse() {
        Assert.assertNotNull(Name);
        Assert.assertNotNull(Job);
        Assert.assertNotNull(UpdatedAt);
    }
}
