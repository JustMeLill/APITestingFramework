package ResponseObject.ResponseUser;

import ResponseObject.ResponseValidator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.testng.Assert;

public class ResponsePostUser implements ResponseValidator {

    @JsonProperty("name")
    public String Name;

    @JsonProperty("job")
    public String Job;

    @JsonProperty("id")
    public String ID;

    @JsonProperty("createdAt")
    public String CreatedAt;

    public void ValidateResponse() {
        Assert.assertNotNull(Name);
        Assert.assertNotNull(Job);
        Assert.assertNotNull(ID);
        Assert.assertNotNull(CreatedAt);
    }
}
