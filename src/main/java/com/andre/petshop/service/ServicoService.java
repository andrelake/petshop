package com.andre.petshop.service;

import com.andre.petshop.domain.Servico;
import com.andre.petshop.repository.ServicoRepository;
import com.andre.petshop.service.exceptions.DataIntegrityException;
import com.andre.petshop.service.exceptions.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

    public Servico insert(Servico obj) {
        return servicoRepository.save(obj);
    }

    public Servico update(Servico obj) {
        findById(obj.getId());
        return servicoRepository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            servicoRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Servico não pode ser deletado");
        }
    }
}
