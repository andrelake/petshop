package com.andre.petshop.service;

import com.andre.petshop.domain.Categoria;
import com.andre.petshop.repository.CategoriaRepository;
import com.andre.petshop.service.exceptions.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.NoSuchElementException;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria findById(Integer id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new ObjetoNaoEncontradoException("Categoria não encontrada. ID: "
                        + id + ". Tipo: " + Categoria.class.getName()));
    }
}
