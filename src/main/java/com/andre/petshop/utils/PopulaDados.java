package com.andre.petshop.utils;

import com.andre.petshop.domain.Categoria;
import com.andre.petshop.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class PopulaDados {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostConstruct
    public void cadastrar() {
        populaCategoriaDB();
    }

    private void populaCategoriaDB() {
        Categoria c1 = new Categoria(null, "Alimento");
        Categoria c2 = new Categoria(null, "Remédio");
        Categoria c3 = new Categoria(null, "Cosmético");

        categoriaRepository.saveAll(Arrays.asList(c1, c2,c3));
    }
}
