package com.tablas.relacionales.repository;

import com.tablas.relacionales.entity.ArticuloCarrito;
import com.tablas.relacionales.entity.Producto;
import com.tablas.relacionales.entity.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class ArticuloCarritoRepositoryTest {

    @Autowired
    private ArticuloCarritoRepository articuloCarritoRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    //metodo para añadir artículo
    @Test
    public void testAñadirArticulo(){
        Producto producto = testEntityManager.find(Producto.class, 3);
        Usuario usuario = testEntityManager.find(Usuario.class, 1);

        //agregando articulo
        ArticuloCarrito articuloCarrito = new ArticuloCarrito(7, producto, usuario);
        articuloCarritoRepository.save(articuloCarrito);
    }

    @Test
    public void testAñadirMultiplesArticulos(){
        Usuario usuario = new Usuario(1);
        Producto producto1 = new Producto(6);
        Producto producto2 = new Producto(8);

        ArticuloCarrito articuloCarrito1 = new ArticuloCarrito(8, producto1,usuario);
        ArticuloCarrito articuloCarrito2 = new ArticuloCarrito(5, producto2,usuario);

        articuloCarritoRepository.saveAll(List.of(articuloCarrito1, articuloCarrito2));
    }

    //Metodo para listar los articulos
    @Test
    public void testListarArticulos(){
        List<ArticuloCarrito> articulos = articuloCarritoRepository.findAll();
        articulos.forEach(System.out::println);
    }

    //Metodo para actualizar articulos
     @Test
    public void testActualizarArticulos(){
        ArticuloCarrito articuloCarrito = articuloCarritoRepository.findById(1).get();
        articuloCarrito.setCantidad(11);
        articuloCarrito.setProducto(new Producto(3));
     }

     //Metodo para eliminar registros
    @Test
    public void testEliminarArticulo(){
        articuloCarritoRepository.deleteById(1);
    }

}
