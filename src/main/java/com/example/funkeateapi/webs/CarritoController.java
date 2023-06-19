package com.example.funkeateapi.webs;

import com.example.funkeateapi.model.Carrito;
import com.example.funkeateapi.repository.CarritoRepository;
import com.example.funkeateapi.repository.UsersRepository;
import com.nimbusds.jose.shaded.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * author = Jacko Tinoco
 *
 * */

@RestController
@RequestMapping(path = "cars", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class CarritoController {

    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private UsersRepository usersRepository;

    JSONObject json = new JSONObject();

    //http://localhost:8080/cars/findByUsersIdAndEstadoIsTrue/{user_id}
    @GetMapping(value = "/findByUsersIdAndEstadoIsTrue/{user_id}")
    public @ResponseBody JSONObject findByUsersIdAndEstadoIsTrue(@PathVariable Integer user_id) {
        // This returns a JSON or XML with the products
        List<Carrito> data = carritoRepository.findByUsersIdAndEstadoIsTrue(user_id);
        json.put("count",data.stream().count());
        json.put("data",data);
        return json;
    }
}
