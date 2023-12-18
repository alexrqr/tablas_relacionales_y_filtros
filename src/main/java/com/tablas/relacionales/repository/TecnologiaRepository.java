package com.tablas.relacionales.repository;

import com.tablas.relacionales.entity.Tecnologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TecnologiaRepository extends JpaRepository<Tecnologia, Integer> {

    //Metodo para la busqueda / filtro


    /*
    *@Query("select t from Tecnologia t where t.marca like %?1%"
            + "OR t.nombre like %?1%"
            + "OR t.hechoEn like %?1%")
    */

    @Query("SELECT t FROM Tecnologia t WHERE "
            + "CONCAT(t.idTecnologia, ' ', t.nombre, ' ', t.marca, ' ', t.hechoEn, ' ', t.precio) "
            + "LIKE %?1%")
    public List<Tecnologia>searchTecnology(String palabra);

    /*
    * Para recordaar:::: lo de la busqueda primero se crea el query aquí en el repositorio y luego
    * se crea el codigo de condicional en el service
    * y finalmente, se crea el codigo de muestra en el controller y listo estimado
    */
}
