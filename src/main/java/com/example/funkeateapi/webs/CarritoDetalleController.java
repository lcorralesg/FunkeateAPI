package com.example.funkeateapi.webs;

import com.example.funkeateapi.model.Carrito;
import com.example.funkeateapi.model.CarritoDetalle;
import com.example.funkeateapi.model.Producto;
import com.example.funkeateapi.repository.CarritoDetalleRepository;
import com.example.funkeateapi.repository.CarritoRepository;
import com.example.funkeateapi.repository.ProductoRepository;
import com.nimbusds.jose.shaded.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "carsdetail", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class CarritoDetalleController {

    @Autowired
    private CarritoDetalleRepository carritoDetalleRepository;

    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    JSONObject json = new JSONObject();
   /* @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<CarritoDetalle> create(@RequestBody CarritoDetalle carritoDetalle) {

        return  ResponseEntity.status(HttpStatus.CREATED).body(carritoDetalleRepository.save(carritoDetalle));

    }*/

    //http://localhost:8080/carsdetail/add?
    @PostMapping(path="/add") // Ruta para añadir productos
    public @ResponseBody String addNewCarDetailProduct (@RequestParam double precio, @RequestParam int cantidad,
                                                 @RequestParam int carrito_id, @RequestParam int producto_id) {

        CarritoDetalle cd = new CarritoDetalle();

        cd.setPrecio(precio);
        cd.setCantidad(cantidad);

        List<Carrito> car = carritoRepository.findById(carrito_id);
        Optional<Carrito> c = car.stream().findFirst();

        Optional<Producto> pro = productoRepository.findById(producto_id);

        if(c.isPresent()) {
            Carrito carrito  = c.get();
            cd.setCarrito(carrito);
            if(pro.isPresent()){
                cd.setProducto(pro.get());
                carritoDetalleRepository.save(cd);
                return "Saved";
            }else{
                return "Error";
            }
        }else {
            return "Error";
        }
    }

    //http://localhost:8080/carsdetail/findByCarritoID/{carrito_id}
    @GetMapping(value = "/findByCarrito_EstadoAndCarritoId/{carrito_id}")
    public @ResponseBody JSONObject findByCarrito_EstadoAndCarritoId(@PathVariable Integer carrito_id) {
        // This returns a JSON or XML with the products
        List<CarritoDetalle> data = carritoDetalleRepository.findByCarrito_EstadoAndCarritoId(true,carrito_id);
        json.put("count",data.stream().count());
        json.put("data",data);
        return json;
    }

    //http://localhost:8080/carsdetail/findByCarrito_EstadoAndCarrito_Users_Id/{estado}/{usuario_id}
    @GetMapping(value = "/findByCarrito_EstadoAndCarrito_Users_Id/{estado}/{usuario_id}")
    public @ResponseBody JSONObject findByCarrito_EstadoAndCarrito_Users_Id(@PathVariable boolean estado, @PathVariable int usuario_id) {
        // This returns a JSON or XML with the products
        List<CarritoDetalle> data = carritoDetalleRepository.findByCarrito_EstadoAndCarrito_Users_Id(estado,usuario_id);
        json.put("count",data.stream().count());
        json.put("data",data);
        return json;
    }

    @GetMapping(value = "/findByCarrito_EstadoAndCarrito_Users_Id/{usuario_id}")
    public @ResponseBody JSONObject findByCarrito_Users_Id(@PathVariable int usuario_id) {
        // This returns a JSON or XML with the products
        List<CarritoDetalle> data = carritoDetalleRepository.findByCarrito_EstadoAndCarrito_Users_Id(true,usuario_id);
        json.put("count",data.stream().count());
        json.put("data",data);
        return json;
    }
}
