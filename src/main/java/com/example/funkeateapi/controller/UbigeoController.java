package com.example.funkeateapi.controller;

import com.example.funkeateapi.model.Ubigeo;
import com.example.funkeateapi.repository.UbigeoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "ubigeo", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class UbigeoController {
    @Autowired
    private UbigeoRepository ubigeoRepository;

    //http://localhost:8080/ubigeo/all
    @GetMapping(path="/all") //Ruta para obtener todos los ubigeos
    public @ResponseBody Iterable<Ubigeo> getAllUbigeo() {
        // This returns a JSON or XML with the products
        return ubigeoRepository.findAll();
    }
}
