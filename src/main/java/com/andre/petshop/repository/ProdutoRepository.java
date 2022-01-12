package com.andre.petshop.repository;

import com.andre.petshop.domain.Categoria;
import com.andre.petshop.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
