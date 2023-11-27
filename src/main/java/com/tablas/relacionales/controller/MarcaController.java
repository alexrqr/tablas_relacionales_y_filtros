package com.tablas.relacionales.controller;

import com.tablas.relacionales.entity.Categoria;
import com.tablas.relacionales.entity.Marca;
import com.tablas.relacionales.repository.CategoriaRepository;
import com.tablas.relacionales.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MarcaController {
    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/marcas")
    public String dashboard_marca(Model model){
        List<Categoria>listaDeCategorias = categoriaRepository.findAll();
        model.addAttribute("listaDeCategoria", listaDeCategorias);

        //para registrar la marca
        Marca marca = new Marca();
        model.addAttribute("marca", marca); //esto se utiliza para renderizar en el archivo html
        List<Marca>listaDeMarcas = marcaRepository.findAll();
        model.addAttribute("listaDeMarca", listaDeMarcas);

        return "marca/lista";
    }

    @PostMapping("/marcas/nuevos")
    public String agregar_marcas(@ModelAttribute("marca") Marca marca, Model model){
        //para mostrar los datos de la tabla categorias
        List<Categoria>listCategorias = categoriaRepository.findAll();
        model.addAttribute("listCategorias", listCategorias);

        //para agregar la marca
        model.addAttribute("marca", new Marca());
        marcaRepository.save(marca);


        return "redirect:/marcas";
    }


    //Método para editar registros -> envia los datos a un archivo html
    @GetMapping("/marcas/editar/{id}")
    public String form_Editar(@PathVariable("id") Integer id, Model model){

        Marca marca = marcaRepository.findById(id).get();
        model.addAttribute("marcas", marca);

        //instanciamos la lista de categorias
        List<Categoria>listCategoria = categoriaRepository.findAll();
        model.addAttribute("categoriaList", listCategoria);


        return "marca/edit";
    }

    //Metodo para actualizar los registros en la base de datos
    @PostMapping("/marcas/update/{id}")
    public String update_marcas(@PathVariable("id") Integer id, @ModelAttribute("marca") Marca marca){
        Marca marcaUpdate = marcaRepository.findById(id).get();
        marcaUpdate.setNombreMarca(marca.getNombreMarca());
        marcaUpdate.setCategorias(marca.getCategorias());

        marcaRepository.save(marcaUpdate);

        return "redirect:/marcas";
    }


    //Eliminar registro
    @PostMapping("/marcas/delete/{id}")
    public String eliminar_marca(@PathVariable("id") Integer id, Model model){
        marcaRepository.deleteById(id);

        return "redirect:/marcas";
    }
}
