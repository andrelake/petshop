package com.andre.petshop.repository;

import com.andre.petshop.domain.Pessoa;
import com.andre.petshop.domain.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
}
