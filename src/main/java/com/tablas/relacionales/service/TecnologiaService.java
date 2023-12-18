package com.tablas.relacionales.service;

import com.tablas.relacionales.entity.Tecnologia;
import com.tablas.relacionales.repository.TecnologiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TecnologiaService {

    @Autowired
    private TecnologiaRepository tecnologiaRepository;

    /*public List<Tecnologia>busquedaTecnologia(String palabraClave){
        if(palabraClave != null){
            return tecnologiaRepository.searchTecnology(palabraClave);
        }
        return tecnologiaRepository.searchTecnology(palabraClave);
    }*/

    public List<Tecnologia> busquedaTecnologia(String palabraClave) {
        if (palabraClave != null) {
            return tecnologiaRepository.searchTecnology(palabraClave); //si cumple la condicion devuelve la lista mediante la palabra clave
        } else {
            return tecnologiaRepository.findAll(); //sino devuelve el listado completo de registros
        }
    }

}
