package com.tablas.relacionales.repository;

import com.tablas.relacionales.entity.ProductoDetalles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoDetallesRepository extends JpaRepository<ProductoDetalles, Integer> {
}
