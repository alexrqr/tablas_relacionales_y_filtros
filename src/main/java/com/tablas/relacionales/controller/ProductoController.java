package com.tablas.relacionales.controller;

import com.tablas.relacionales.entity.Categoria;
import com.tablas.relacionales.entity.Producto;
import com.tablas.relacionales.entity.ProductoDetalles;
import com.tablas.relacionales.repository.CategoriaRepository;
import com.tablas.relacionales.repository.ProductoDetallesRepository;
import com.tablas.relacionales.repository.ProductoRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductoController {

    //Inyeccion del repositorio
    @Autowired
    private ProductoRepository productoRepository;

    //para obtener las categorias
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProductoDetallesRepository productoDetallesRepository;



    //metodo principal
    @GetMapping("/productos")
    public String dashboard_Productos(Model model, HttpServletRequest request) {
        //Agregar un registro
        Producto producto = new Producto();
        model.addAttribute("producto", producto);
        //lista de categorias:
        List<Categoria> listaCategorias = categoriaRepository.findAll();
        model.addAttribute("categoriasLista", listaCategorias);


        //Lista de los productos
        List<Producto> listaProductos = productoRepository.findAll();
        model.addAttribute("listaProductos", listaProductos); //envia lo de comillas al archivo html
        return "producto/lista";
    }

    @PostMapping("productos/nuevos")
    public String agregarProductos(@ModelAttribute("producto") Producto producto, Model model, HttpServletRequest request) {
        //Este codigo obtiene la lista de las categorías para hacer funcionar
        //lo de tablas relacionales ManyToOnne
        List<Categoria> listaCategorias = categoriaRepository.findAll();
        model.addAttribute("categoriasLista", listaCategorias);

        //inicio detalles
        String[] detallesIDs = request.getParameterValues("detallesID");
        String[] detallesNombres = request.getParameterValues("detallesNombre");
        String[] detallesValores = request.getParameterValues("detallesValor");
        //Metodo para registrar los detalles
        for (int i = 0; i < detallesNombres.length; i++) {
            if (detallesIDs != null && detallesIDs.length > 0) {
                producto.setDetalle(Integer.valueOf(detallesIDs[i]), detallesNombres[i], detallesValores[i]);
            } else {
                producto.añadirDetalles(detallesNombres[i], detallesValores[i]);
            }
        }
        //final detalles

        //Este codigo es para agregar solamente el producto
        model.addAttribute("producto", new Producto());
        productoRepository.save(producto);
        return "redirect:/productos";
    }

    //Metodo para editar un registro, obtiene los datos por ID y envía esos datos a un archivo html:
    @GetMapping("/productos/editar/{id}")
    public String form_Editar(@PathVariable("id") Integer id, Model model) {
        Producto productos = productoRepository.findById(id).get();
        model.addAttribute("productos", productos);

        //instanciar la lista de categorias
        List<Categoria> listCategoria = categoriaRepository.findAll();
        model.addAttribute("categoriaList", listCategoria);


        return "producto/edit";
    }

    //Metodo para actualizar los datos
    @PostMapping("/productos/update/{id}")
    public String update_productos(@PathVariable("id") Integer id, @ModelAttribute("producto") Producto producto, HttpServletRequest request) {
        Producto productUpdate = productoRepository.findById(id).orElseThrow(); // Asegúrate de manejar el caso si no se encuentra el producto

        productUpdate.setNombre(producto.getNombre());
        productUpdate.setPrecio(producto.getPrecio());
        productUpdate.setCategoria(producto.getCategoria());
        // Limpiar detalles existentes del producto
        productUpdate.getDetalles().clear();
        //Desde aquí es para actualizar los datos de la tabla productosdetalle
        String[] detallesIDs = request.getParameterValues("detallesID");
        String[] detallesNombres = request.getParameterValues("detallesNombre");
        String[] detallesValores = request.getParameterValues("detallesValor");

        for (int i = 0; i < detallesNombres.length; i++) {
            if (detallesIDs != null && detallesIDs.length > 0) {
                // Actualizar detalles existentes
                Integer detalleId = Integer.valueOf(detallesIDs[i]);
                Optional<ProductoDetalles> detalleExistente = productoDetallesRepository.findById(detalleId);

                if (detalleExistente.isPresent()) {
                    ProductoDetalles detalle = detalleExistente.get();
                    detalle.setNombre(detallesNombres[i]);
                    detalle.setValor(detallesValores[i]);

                    // Asociar el detalle actualizado al producto
                    detalle.setProducto(productUpdate);
                    productUpdate.getDetalles().add(detalle);
                }
            } else {
                // Agregar nuevos detalles
                productUpdate.añadirDetalles(detallesNombres[i], detallesValores[i]);
            }
        }

        productoRepository.save(productUpdate);
        return "redirect:/productos";
    }


    //Metodo para eliminar un registro
    @GetMapping("/productos/delete/{id}")
    public String eliminar_registro(@PathVariable("id") Integer id, Model model){
        productoRepository.deleteById(id);

        return "redirect:/productos";
    }

}
