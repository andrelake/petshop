package com.andre.petshop.repository;

import com.andre.petshop.domain.Pagamento;
import com.andre.petshop.domain.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
}
