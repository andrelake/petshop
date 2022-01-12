package com.andre.petshop.utils;

import com.andre.petshop.domain.Categoria;
import com.andre.petshop.domain.Produto;
import com.andre.petshop.repository.CategoriaRepository;
import com.andre.petshop.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class PopulaDados {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostConstruct
    public void cadastrar() {
        Categoria c1 = new Categoria(null, "Alimento");
        Categoria c2 = new Categoria(null, "Remédio");
        Categoria c3 = new Categoria(null, "Cosmético");

        Produto p1 = new Produto(null, "Ração", 100.0);
        Produto p2 = new Produto(null, "Sache", 80.0);
        Produto p3 = new Produto(null, "Vermífugo", 20.0);
        Produto p4 = new Produto(null, "Shampoo", 50.0);

        c1.getProdutosList().addAll(Arrays.asList(p1, p2));
        c2.getProdutosList().addAll(Arrays.asList(p3, p4));
        c3.getProdutosList().addAll(Arrays.asList(p4));

        p1.getCategoriasList().add(c1);
        p2.getCategoriasList().add(c1);
        p3.getCategoriasList().add(c2);
        p4.getCategoriasList().addAll(Arrays.asList(c2, c3));

        categoriaRepository.saveAll(Arrays.asList(c1, c2,c3));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
    }
}
