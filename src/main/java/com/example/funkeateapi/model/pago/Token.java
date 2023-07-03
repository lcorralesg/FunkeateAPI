package com.example.funkeateapi.model.pago;
import okhttp3.*;
import java.io.IOException;
import java.util.Base64;
public class Token {
    public Response getSecurityToken(String username, String password) throws IOException {

        String valueToEncode = username + ":" + password;
        String basic = "Basic " + Base64.getEncoder().encodeToString(valueToEncode.getBytes());

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://apisandbox.vnforappstest.com/api.security/v1/security")
                .get()
                .addHeader("accept", "text/plain")
                .addHeader("authorization", basic)
                .build();

        return client.newCall(request).execute();
    }

    public Response getSessionToken(String tokenSecurity, String merchantId, String channel, String amount) throws IOException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"channel\":\""+channel+"\",\"amount\":"+amount+"}");
        Request request = new Request.Builder()
                .url("https://apisandbox.vnforappstest.com/api.ecommerce/v2/ecommerce/token/session/"+merchantId)
                .post(body)
                .addHeader("accept", "application/json")
                .addHeader("content-type", "application/json")
                .addHeader("Authorization", tokenSecurity)
                .build();

        Response response = client.newCall(request).execute();

        return response;
    }
}