package com.example.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.excepciones.ResourceNotFoundException;
import com.example.demo.modelo.Producto;
import com.example.demo.repositorio.ProductoRepositorio;

@Service
public class ProductoServicio {

	@Autowired
	private ProductoRepositorio prepo;

	public List<Producto> listarProductos() {
		return prepo.findAll();
	}

	public void guardarProducto(Producto pro) {
		prepo.save(pro);
	}

	// si NO encuentra el id, puede ser opcional o excepciones
	public Producto buscarPorId(Integer id) {
		return prepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No se encontró el Producto con id:"));
	}
	
	public void eliminarProducto(Integer id) {
		prepo.deleteById(id);
	}
		
	public void actualizarProducto(Producto p) {
		prepo.save(p);
	}
	

}
