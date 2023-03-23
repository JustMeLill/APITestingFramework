package RequestObject.RequestLogin;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class RequestLogin {

    @JsonProperty("email")
    private String Email;

    @JsonProperty("password")
    private String Password;

    public static class RequestLoginBuilder{
        public RequestLoginBuilder() {
        }
    }


}
