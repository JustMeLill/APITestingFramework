package RequestObject;

public class RequestURLType {

    public static String GET_LIST_USERS = "api/users?page=2";
    public static String GET_SINGLE_USER = "api/users/2";
    public static String GET_SINGLE_USER_NOTFOUND = "api/users/23";
    public static String GET_DELAYED_RESPONSE = "api/users?page=2";
    public static String GET_LIST_RESOURCES = "api/unknown";
    public static String GET_SINGLE_RESOURCE = "api/unknown/2";
    public static String GET_RESOURCE_NOTFOUND = "api/unknown/23";

    public static String POST_LOGIN = "api/login";
    public static String POST_REGISTER = "api/register";
    public static String POST_USER = "api/users";
    public static String PUT_PATCH_DELETE_USER = "api/users/2";



}
