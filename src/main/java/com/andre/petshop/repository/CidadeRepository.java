package com.andre.petshop.repository;

import com.andre.petshop.domain.Cidade;
import com.andre.petshop.domain.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
}
