package com.tablas.relacionales.controller;

import com.tablas.relacionales.entity.Categoria;
import com.tablas.relacionales.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CategoriaController {

    // Controlador de categoria
    @Autowired
    private CategoriaRepository categoriaRepository;

    //Metodo para devolver el listado de categorias
    @GetMapping("/categorias")
    public String listaCategorias(Model model){
        //Para agregar el registro:
        Categoria categoria = new Categoria();
        model.addAttribute("categoria", categoria);


        //Esta "listaCategorias" se envía al archivo html, con esto se recorre para mostrar los datos
        List<Categoria> listaCategoria = categoriaRepository.findAll();
        model.addAttribute("listaCategorias", listaCategoria);
        return "categoria/lista";
    }


    //Metodo para Agregar un registro de categoria
    @PostMapping("/categorias/nuevos")
    public String agregarCategoria(@ModelAttribute("categoria")Categoria categoria, Model model){
        model.addAttribute("categoria", new Categoria());
        categoriaRepository.save(categoria);
        return "redirect:/categorias";

    }


}
