package com.example.funkeateapi.webs;

import com.example.funkeateapi.model.Categoria;
import com.example.funkeateapi.model.Producto;
import com.example.funkeateapi.repository.CategoriaRepository;
import com.example.funkeateapi.repository.ProductoRepository;
import com.nimbusds.jose.shaded.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 *
 * author = Jacko Tinoco
 *
 * */


@RestController
@RequestMapping(path = "products", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class ProductoController {

	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	JSONObject json = new JSONObject();

	//http://localhost:8080/products/add?name=Iron Man&descripcion=Funko de Iron Man personalizable&image=url&precio=85&categoria_id=2
	@PostMapping(path="/add") // Ruta para añadir productos
	  public @ResponseBody String addNewCategory (@RequestParam String name,
			  @RequestParam String descripcion, @RequestParam String image,
			  @RequestParam double precio, @RequestParam int categoria_id) {

	    Producto p = new Producto();
	    
	    p.setNombre(name);
	    p.setDescripcion(descripcion);
	    p.setImagen(image);
	    p.setPrecio(precio);
	   	p.setEstado(true);
	    p.setCreatedAt(new java.util.Date());
	    p.setUpdateAt(new java.util.Date());
	    
	    Optional<Categoria> cat = categoriaRepository.findById(categoria_id);
	    if(cat.isPresent()) {
	    	Categoria c  = cat.get();
	    	p.setCategoria(c);
		    productoRepository.save(p);
		    return "Saved";
	    }else {
	    	return "Error";
	    }
	  }

	//http://localhost:8080/products/all
	@GetMapping(path="/all") //Ruta para obtener todos los productos
	  public @ResponseBody JSONObject getAllProducto() {
	    // This returns a JSON or XML with the products
		json.put("count", productoRepository.count());
		json.put("data",productoRepository.findAll());
		return json;
	  }

	// http://localhost:8080/products/find?producto_id=1
	@GetMapping(path="/find") // Buscar productos por ID
	  public @ResponseBody JSONObject  findProduct (@RequestParam int producto_id) {
	    // @ResponseBody means the returned String is the response, not a view name
	    // @RequestParam means it is a parameter from the GET or POST request
				
		Optional<Producto> data = productoRepository.findById(producto_id);
		json.put("count",data.stream().count());
		json.put("data",data);
		return json;
	  }

	// http://localhost:8080/products/findbycategoryname?cname=SuperHeroes
	@GetMapping(path="/findbycategoryname") // Obtener productos por categoria
	public @ResponseBody JSONObject findProductbyCategory (@RequestParam String cname) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		List<Categoria> cat = categoriaRepository.findByNombre(cname);
		Categoria c  = cat.get(0);
		List<Producto> data = productoRepository.findByCategoria(c);
		json.put("count",data.stream().count());
		json.put("data",data);
		return json;
	}

	// http://localhost:8080/products/findbycategoryname/{cname}
	@GetMapping(value="/findbycategoryname/{cname}") // Obtener productos por categoria
	public @ResponseBody JSONObject findProductsbyCategoryName (@PathVariable String cname) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		List<Producto> data = productoRepository.findByCategoria_Nombre(cname);
		json.put("count",data.stream().count());
		json.put("data",data);
		return json;
	}
}
