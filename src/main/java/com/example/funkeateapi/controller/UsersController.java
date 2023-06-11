package com.example.funkeateapi.controller;

import com.example.funkeateapi.model.Users;
import com.example.funkeateapi.repository.UsersRepository;
import com.nimbusds.jose.shaded.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * author = Jacko Tinoco
 *
 * */

@Controller
@RequestMapping(path="/users")
public class UsersController {
	@Autowired
	private UsersRepository usersRepository;

	JSONObject json = new JSONObject();

	/*@PostMapping(path="/add") // Map ONLY POST Requests
	  public @ResponseBody String addNewUser (@RequestParam String name
	      , @RequestParam String email) {
	    // @ResponseBody means the returned String is the response, not a view name
	    // @RequestParam means it is a parameter from the GET or POST request

	    Users n = new Users();
	    n.setUsername(name);
	    n.setEmail(email);
	    usersRepository.save(n);
	    return "Saved";
	  }*/

	//http://localhost:8080/users/all
	@GetMapping(path="/all")
	  public @ResponseBody JSONObject getAllUsers() {
	    // This returns a JSON or XML with the users
		json.put("count", usersRepository.count());
		json.put("data",usersRepository.findAll());
		return json;
	  }
}