package RequestObject.RequestUser;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class RequestUser {

    @JsonProperty("name")
    private String Name;

    @JsonProperty("job")
    private String Job;

    public static class RequestUserBuilder{
        public RequestUserBuilder() {
        }
    }
}
