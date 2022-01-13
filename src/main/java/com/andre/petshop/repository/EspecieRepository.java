package com.andre.petshop.repository;

import com.andre.petshop.domain.Especie;
import com.andre.petshop.domain.Raca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecieRepository extends JpaRepository<Especie, Integer> {
}
