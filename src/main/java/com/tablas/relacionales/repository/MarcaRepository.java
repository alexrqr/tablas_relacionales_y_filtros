package com.tablas.relacionales.repository;

import com.tablas.relacionales.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Integer> {

}
