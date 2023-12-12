package apis.objects;

import com.shaft.driver.SHAFT;
import io.restassured.http.ContentType;

public class apis {
    private SHAFT.API api;
    public static String baseUrl = System.getProperty("baseUrl");
    // Status Codes
    public static int success_statusCode = 200;
    public static int successDelete_statusCode = 201;
    private static final String authentication_serviceName = "/auth";

public apis(SHAFT.API api){
    this.api=api;
}
    public static void login(SHAFT.API api, String username, String password) {
        String tokenBody = """
                {
                    "username" : "{USERNAME}",
                    "password" : "{PASSWORD}"
                }
                """
                .replace("{USERNAME}", username)
                .replace("{PASSWORD}", password);

        api.post(authentication_serviceName)
                .setContentType(ContentType.JSON)
                .setRequestBody(tokenBody)
                .setTargetStatusCode(success_statusCode)
                .perform();

        String token = api.getResponseJSONValue("token");

        api.addHeader("Cookie", "token=" + token);
    }
}
