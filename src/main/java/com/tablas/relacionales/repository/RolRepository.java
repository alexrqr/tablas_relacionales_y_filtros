package com.tablas.relacionales.repository;

import com.tablas.relacionales.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Integer> {
}
