package com.example.benidictdulce.httpurlconnection_crud.config;

/**
 * Created by Benidict Dulce on 6/23/2016.
 */
public class Config {
    //address
    // if you want to run this app to real device just go to cmd then ipconfig get the ip v4.
    // replace the 10.0.2.2
    public static final String URL_INSERT = "http://10.0.2.2/rest/insertUser.php";
    public static final String URL_Display = "http://10.0.2.2/rest/displayUser.php";
    public static final String URL_GetUser = "http://10.0.2.2/rest/getUser.php?id=";
    public static final String URL_UpdateUser = "http://10.0.2.2/rest/updateUser.php";
    public static final String URL_DeleteUser = "http://10.0.2.2/rest/deleteUser.php?id=";

    //keys for send and request script
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_UNAME  = "username";
    public static final String KEY_PASS = "password";

    //json tags
    public static final String TAG_ARRAY = "result";
    public static final String TAG_ID = "id";
    public static final String TAG_NAME = "name";
    public static final String TAG_UNAME = "username";
    public static final String TAG_PASS = "password";

    //base id use to pass the value of user id into intent
    public static final String BASE_ID = "base_id";
}
