package com.andre.petshop.utils;

import com.andre.petshop.domain.*;
import com.andre.petshop.repository.*;
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

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private RacaRepository racaRepository;

    @Autowired
    private EspecieRepository especieRepository;

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

        Especie s1 = new Especie(null, "Cachorro");
        Especie s2 = new Especie(null, "Gato");

        Raca rac1 = new Raca(null, "Shitzu");
        Raca rac2 = new Raca(null, "Akita");
        Raca rac3 = new Raca(null, "Persa");

        Pet pet1 = new Pet(null, "John", s1, rac1, 6);
        Pet pet2 = new Pet(null, "Hana", s1, rac2, 5);
        Pet pet3 = new Pet(null, "Mewth", s2, rac3, 8);

        especieRepository.saveAll(Arrays.asList(s1, s2));
        racaRepository.saveAll(Arrays.asList(rac1, rac2, rac3));
        petRepository.saveAll(Arrays.asList(pet1, pet2, pet3));
    }
}
