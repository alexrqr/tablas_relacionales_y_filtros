package com.tablas.relacionales.controller;

import com.tablas.relacionales.entity.Tecnologia;
import com.tablas.relacionales.repository.TecnologiaRepository;
import com.tablas.relacionales.service.TecnologiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TecnologiaController {

    @Autowired
    private TecnologiaRepository tecnologiaRepository;

    @Autowired
    private TecnologiaService tecnologiaService;

    //Puede ser GetMapping o RequestMapping
    @RequestMapping("/tecnologia")
    public String dashboard_tecnologia(Model model, @Param("palabraClave") String palabraClave){
        model.addAttribute("tecnologia", new Tecnologia());
        //Para la busqueda
        model.addAttribute("palabraClave", palabraClave);
        //String palabraClave = "Lenovo";
        List<Tecnologia>listaTecnologia = tecnologiaService.busquedaTecnologia(palabraClave);
        //List<Tecnologia>listaTecnologia = tecnologiaRepository.findAll();
        model.addAttribute("listaTecnologia", listaTecnologia);

        return "tecnologia/lista";
    }

    @PostMapping("/tecnologia/nuevo")
    public String agregar_usuario(@ModelAttribute("tecnologia") Tecnologia tecnologia, Model model){
        tecnologiaRepository.save(tecnologia);

        return "redirect:/tecnologia";
    }
}
