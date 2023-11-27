package com.tablas.relacionales.controller;

import com.tablas.relacionales.entity.Rol;
import com.tablas.relacionales.entity.Usuario;
import com.tablas.relacionales.repository.RolRepository;
import com.tablas.relacionales.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UsuarioController {
    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    //Metodo de vista dashboard del usuario
    @GetMapping("/usuarios")
    private String dashboard_usuarios(Model model){
        //para agregar usuarios
        model.addAttribute("usuario", new Usuario());

        //envío de lista de usuarios
        List<Usuario>listaUsuarios = usuarioRepository.findAll();
        model.addAttribute("listaDeUsuarios", listaUsuarios);

        //envío de lista de roles
        List<Rol>listaRoles = rolRepository.findAll();
        model.addAttribute("listaDeRoles", listaRoles);

        return "usuario/dashboard";
    }

    //Metodo para registrar nuevo usuario con rol
    @PostMapping("/usuarios/nuevos")
    public String add_usuario(@ModelAttribute("usuario") Usuario usuario, Model model){
        //model.addAttribute("usuario", new Usuario());
        usuarioRepository.save(usuario);
        return "redirect:/usuarios";
    }

    //metodo para enviar datos de un registro a un formulario
    @GetMapping("/usuarios/editar/{id}")
    public String edit_usuario(@PathVariable("id") Integer id, Model model){
        Usuario usuario = usuarioRepository.findById(id).get();
        model.addAttribute("usuario", usuario);

        //lista de roles a seleccionar
        List<Rol>listRoles = rolRepository.findAll();
        model.addAttribute("rolLista", listRoles); //lo de comillas se inyecta en el html

        return "usuario/edit";
    }

    //metodo para actualizar los cambios de un registro
    @PostMapping("usuarios/update/{id}")
    public String update_usuario(@PathVariable("id") Integer id, @ModelAttribute("usuario") Usuario usuario){
        //Recogiendo los datos para guardarlos en la base de datos como un update
        Usuario userUpdate = usuarioRepository.findById(id).get();

        userUpdate.setEmail(usuario.getEmail());
        userUpdate.setPassword(usuario.getPassword());
        userUpdate.setRoles(usuario.getRoles());

        usuarioRepository.save(userUpdate);

        return "redirect:/usuarios";
    }

    //metodo para eliminar un registro de la base de datos
     @GetMapping("/usuarios/delete/{id}")
    public String eliminar_usuario(@PathVariable("id") Integer id){
         usuarioRepository.deleteById(id);

         return "redirect:/usuarios";
     }

}
