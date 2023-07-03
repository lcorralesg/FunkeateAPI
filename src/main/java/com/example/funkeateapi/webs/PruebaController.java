package com.example.funkeateapi.webs;

import com.example.funkeateapi.model.pago.Token;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;

@RestController
@RequestMapping(value="/prueba")
public class PruebaController {

    Token token = new Token();
    @RequestMapping(value="/1", method = RequestMethod.GET)
    public String securityToken() throws IOException {
        Response response = token.getSecurityToken("integraciones@niubiz.com.pe","_7z3@8fF");
        return response.body().string();
    }

    @RequestMapping(value="/2", method = RequestMethod.GET)
    public String sessionToken() throws IOException {
        String securityToken = token.getSecurityToken("integraciones@niubiz.com.pe","_7z3@8fF").body().string();
        String merchantId = "456879852";
        String channel = "web";
        String amount = "82.50";
        Response response = token.getSessionToken(securityToken,merchantId,channel,amount);
        return response.body().string();
    }
}
