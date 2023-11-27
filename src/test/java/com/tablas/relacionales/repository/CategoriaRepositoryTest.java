package com.tablas.relacionales.repository;

import com.tablas.relacionales.entity.Categoria;
import com.tablas.relacionales.repository.CategoriaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Java6Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class CategoriaRepositoryTest {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Test
    public void testAgregarCategoria() {
        //Categoria categoria = categoriaRepository.save(new Categoria("Electrónicos"));
        //Categoria categoria = categoriaRepository.save(new Categoria("Tecnología"));
        //assertThat(categoria.getIdCategoria()).isGreaterThan(0);
    }
}
