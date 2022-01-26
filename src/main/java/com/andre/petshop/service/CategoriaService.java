package com.andre.petshop.service;

import com.andre.petshop.domain.Categoria;
import com.andre.petshop.repository.CategoriaRepository;
import com.andre.petshop.service.exceptions.DataIntegrityException;
import com.andre.petshop.service.exceptions.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria insert(Categoria obj) {
        return categoriaRepository.save(obj);
    }

    public Categoria findById(Integer id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new ObjetoNaoEncontradoException("Categoria não encontrada. ID: "
                        + id + ". Tipo: " + Categoria.class.getName()));
    }

    public Categoria update(Categoria obj) {
        findById(obj.getId());
        return categoriaRepository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            categoriaRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Categoria possui produtos, não é possível deletar");
        }
    }
}
