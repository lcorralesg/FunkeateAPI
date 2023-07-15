package com.example.funkeateapi.webs;

import com.example.funkeateapi.model.Users;
import com.example.funkeateapi.repository.UsersRepository;
import com.nimbusds.jose.shaded.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

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



	//http://localhost:8080/users/findById/{user_id}
	@GetMapping(value = "/findById/{user_id}")
	public @ResponseBody JSONObject findById(@PathVariable Integer user_id) {
		// This returns a JSON or XML with the products
		Optional<Users> data = usersRepository.findById(user_id);
		json.put("count",data.stream().count());
		json.put("data",data);
		return json;
	}

	//http://localhost:8080/users/findByEmail/{email}
	@GetMapping(value = "/findByEmail/{email}")
	public @ResponseBody JSONObject findByEmail(@PathVariable String email) {
		// This returns a JSON or XML with the products
		Optional<Users> data = usersRepository.findByEmail(email);
		json.put("count",data.stream().count());
		json.put("data",data);
		return json;
	}
}