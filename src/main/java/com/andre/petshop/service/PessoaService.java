package com.andre.petshop.service;

import com.andre.petshop.domain.Categoria;
import com.andre.petshop.domain.Pessoa;
import com.andre.petshop.repository.CategoriaRepository;
import com.andre.petshop.repository.PessoaRepository;
import com.andre.petshop.service.exceptions.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa findById(Integer id) {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new ObjetoNaoEncontradoException("Pessoa não encontrada. ID: "
                        + id + ". Tipo: " + Pessoa.class.getName()));
    }
}
