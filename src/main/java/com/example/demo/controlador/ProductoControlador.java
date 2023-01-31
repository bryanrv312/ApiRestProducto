package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.modelo.Producto;
import com.example.demo.servicio.ProductoServicio;

@RestController
public class ProductoControlador {

	
	@Autowired
	private ProductoServicio pserv;
	
	
	@GetMapping({"/productos","/"})
	public List<Producto> listarProducto(){
		return pserv.listarProductos();
	}
	
	@GetMapping("/productos/{id}")
	public ResponseEntity<Producto> obtenerProducto(@PathVariable Integer id){
		try {
			Producto producto = pserv.buscarPorId(id);
			return new ResponseEntity<Producto>(producto,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PostMapping("/productos")
	public void guardarProducto(@RequestBody Producto pro) {
		pserv.guardarProducto(pro);
	}
	
	@PutMapping("/productos/{id}")
	public ResponseEntity<Producto> actualizarProducto(@PathVariable Integer id, @RequestBody Producto pro){
		try {
			Producto productoExistenete = pserv.buscarPorId(id);
			productoExistenete.setNombre(pro.getNombre());
			productoExistenete.setPrecio(pro.getPrecio());
			pserv.actualizarProducto(productoExistenete);
			return new ResponseEntity<Producto>(productoExistenete,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/productos/{id}")
	public void eliminarProducto(@PathVariable Integer id) {
		pserv.eliminarProducto(id);
	}
	
}
