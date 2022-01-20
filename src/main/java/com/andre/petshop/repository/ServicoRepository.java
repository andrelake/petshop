package com.andre.petshop.repository;

import com.andre.petshop.domain.Categoria;
import com.andre.petshop.domain.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {
}
