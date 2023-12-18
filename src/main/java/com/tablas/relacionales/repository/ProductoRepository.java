package com.tablas.relacionales.repository;

import com.tablas.relacionales.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
