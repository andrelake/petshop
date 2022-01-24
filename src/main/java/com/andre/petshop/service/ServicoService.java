package com.andre.petshop.service;

import com.andre.petshop.domain.Pessoa;
import com.andre.petshop.domain.Servico;
import com.andre.petshop.repository.PessoaRepository;
import com.andre.petshop.repository.ServicoRepository;
import com.andre.petshop.service.exceptions.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public Servico findById(Integer id) {
        return servicoRepository.findById(id)
                .orElseThrow(() -> new ObjetoNaoEncontradoException("Serviço não encontrado. ID: "
                        + id + ". Tipo: " + Servico.class.getName()));
    }
}
