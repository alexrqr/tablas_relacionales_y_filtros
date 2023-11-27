package com.tablas.relacionales.repository;

import com.tablas.relacionales.entity.Rol;
import com.tablas.relacionales.entity.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UsuarioRepositoryTest {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private RolRepository rolRepository;

    //Prueba de crear roles:
    @Test
    public void testCrearRoles(){
        Rol rolAdmin = new Rol("Administrador");
        Rol rolEditor = new Rol("Editor");
        Rol rolVisitante = new Rol("Visitante");

        entityManager.persist(rolAdmin);
        entityManager.persist(rolEditor);
        entityManager.persist(rolVisitante);
    }
    //Prueba crear usuario con un Rol
    @Test
    public void testCrearNuevoUsuarioConUnRol(){
        Rol rolAdmin = entityManager.find(Rol.class, 1);

        Usuario usuario = new Usuario("jeanalexromero280@outlook.es", "jeanalex_romero");

        usuario.añadirRol(rolAdmin);
        //guardar usuario
        usuarioRepository.save(usuario);
    }

    //Prueba crear nuevo usuario con dos roles
    @Test
    public void testCrearNuevoUsuarioConDosRoles(){
        Rol rolEditor = entityManager.find(Rol.class, 2);
        Rol rolVisitante = entityManager.find(Rol.class, 3);

        Usuario usuario = new Usuario("jeanalexromero200@gmail.com", "alexanderRomero");
        usuario.añadirRol(rolEditor);
        usuario.añadirRol(rolVisitante);

        //guardando el registro
        usuarioRepository.save(usuario);
    }

    //agregar rol a un usuario existente
    @Test
    public void testAsignarRolAusuarioExistente(){
        Usuario usuario = usuarioRepository.findById(1).get();
        Rol rolEditor = entityManager.find(Rol.class, 2);

        usuario.añadirRol(rolEditor);
    }

    //eliminar rol de un usuario existente
    @Test
    public void testEliminarRolDeUnUsuarioExistente(){
        Usuario usuario = usuarioRepository.findById(1).get();

        Rol rol = new Rol("2"); //le pasamos el id a eliminar

        usuario.eliminarRol(rol);
    }

    //Prueba agregar usuario con nuevo rol
    @Test
    public void dsgdsgsdgdsgdsgdsgl() {
        Rol rolVendedor = new Rol("Vendedor");
        Usuario usuario = new Usuario("gabrielram22@gmail.com","123222445");

        usuario.añadirRol(rolVendedor);
        usuarioRepository.save(usuario);
    }
    @Test
    public void testCrearUnUsuarioConNuevoRol() {
        // Crea el Rol pero no lo guardes aún
        Rol rolVendedor = new Rol("Vendedor");
        // Guarda el Rol primero
        rolRepository.save(rolVendedor);
        // Crea el Usuario y asígna el Rol guardado
        Usuario usuario = new Usuario("jromero@gmail.comm", "123456");
        usuario.añadirRol(rolVendedor);
        // Ahora guarda el Usuario
        usuarioRepository.save(usuario);
    }

    //Prueba obtener un usuario
    @Test
    public void testObtenerUsuario(){
        Usuario usuario = usuarioRepository.findById(1).get();
        entityManager.detach(usuario);

        System.out.println("/*------DATOS DEL USUARIO: "+usuario.getIdUsuario() + "-----*/");
        System.out.println("EMAIL: " + usuario.getEmail());
        System.out.println("PASSWORD: " + usuario.getPassword());
    }

    //Prueba eliminar usuario
    @Test
    public void testEliminarUsuario(){
        usuarioRepository.deleteById(2);
    }

}
