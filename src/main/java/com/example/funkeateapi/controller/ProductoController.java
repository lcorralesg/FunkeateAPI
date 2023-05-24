package com.example.funkeateapi.controller;

import com.example.funkeateapi.model.Categoria;
import com.example.funkeateapi.model.Producto;
import com.example.funkeateapi.repository.CategoriaRepository;
import com.example.funkeateapi.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "products", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class ProductoController {
	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;

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
	    p.setCreated_at(new java.util.Date());
	    p.setUpdate_at(new java.util.Date());
	    
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
	  public @ResponseBody Iterable<Producto> getAllProducto() {
	    // This returns a JSON or XML with the products
	    return productoRepository.findAll();
	  }

	// http://localhost:8080/products/find?producto_id=1
	@GetMapping(path="/find") // Buscar productos por ID
	  public @ResponseBody Optional<Producto>  findProduct (@RequestParam int producto_id) {
	    // @ResponseBody means the returned String is the response, not a view name
	    // @RequestParam means it is a parameter from the GET or POST request
				
		return productoRepository.findById(producto_id);
	  }

	// http://localhost:8080/products/findbycategory?categoria_name=SuperHeroes
	@GetMapping(path="/findbycategory") // Obtener productos por categoria
	public @ResponseBody Iterable<Producto> findProductbyCategory (@RequestParam String categoria_name) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		List<Categoria> cat = categoriaRepository.findByNombre(categoria_name);
		Categoria c  = cat.get(0);
		return productoRepository.findByCategoria(c);
	}
}
