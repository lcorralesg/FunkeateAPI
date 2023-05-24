package com.example.funkeateapi.controller;

import com.example.funkeateapi.model.Users;
import com.example.funkeateapi.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/users")
public class UsersController {
	@Autowired
	private UsersRepository usersRepository;
	
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
	  public @ResponseBody Iterable<Users> getAllUsers() {
	    // This returns a JSON or XML with the users
	    return usersRepository.findAll();
	  }
}