package com.example.funkeateapi.controller;

import com.example.funkeateapi.model.Categoria;
import com.example.funkeateapi.repository.CategoriaRepository;
import com.nimbusds.jose.shaded.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
@RequestMapping(path="/categories")
public class CategoriaController {
	@Autowired
	private CategoriaRepository categoriaRepository;

	JSONObject json = new JSONObject();
	@PostMapping(path="/add") // Map ONLY POST Requests
	public @ResponseBody String addNewCategory (@RequestParam String name) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Categoria c = new Categoria();
		c.setNombre(name);
		c.setEstado(true);
		c.setCreatedAt(new java.util.Date());
		c.setUpdateAt(new java.util.Date());
		categoriaRepository.save(c);
		return "Saved";
	}

	@GetMapping(path="/all")
	public @ResponseBody JSONObject getAllCategoria() {
		// This returns a JSON or XML with the categories
		json.put("count", categoriaRepository.count());
		json.put("data",categoriaRepository.findAll());
		return json;
	}

	@GetMapping(path="/find") // Map ONLY POST Requests
	public @ResponseBody JSONObject  findCategory (@RequestParam int categoria_id) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		Optional<Categoria> data = categoriaRepository.findById(categoria_id);
		json.put("count", data.stream().count());
		json.put("data",data);
		return json;
	}
}