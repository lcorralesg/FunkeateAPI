package com.example.funkeateapi.webs;

import com.example.funkeateapi.repository.UbigeoRepository;
import com.nimbusds.jose.shaded.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 *
 * author = Jacko Tinoco
 *
 * */

@RestController
@RequestMapping(path = "ubigeo", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class UbigeoController {
    @Autowired
    private UbigeoRepository ubigeoRepository;

    JSONObject json = new JSONObject();

    //http://localhost:8080/ubigeo/all
    @GetMapping(path="/all") //Ruta para obtener todos los ubigeos
    public @ResponseBody JSONObject getAllUbigeo() {
        // This returns a JSON or XML with the products
        json.put("count", ubigeoRepository.count());
        json.put("data",ubigeoRepository.findAll());
        return json;
    }
}
