package com.andre.petshop.service;

import com.andre.petshop.domain.Pessoa;
import com.andre.petshop.repository.PessoaRepository;
import com.andre.petshop.service.exceptions.DataIntegrityException;
import com.andre.petshop.service.exceptions.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa findById(Integer id) {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new ObjetoNaoEncontradoException("Pessoa não encontrada. ID: "
                        + id + ". Tipo: " + Pessoa.class.getName()));
    }

    public Pessoa insert(Pessoa obj) {
        return pessoaRepository.save(obj);
    }

    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    public Pessoa update(Pessoa obj) {
        findById(obj.getId());
        return pessoaRepository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            pessoaRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Pessoa não pode ser deletada");
        }
    }
}
