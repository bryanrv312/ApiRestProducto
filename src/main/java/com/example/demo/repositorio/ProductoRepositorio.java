package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Producto;

//METODOS NECESARIOS PARA UN CRUD
@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Integer>{

}
