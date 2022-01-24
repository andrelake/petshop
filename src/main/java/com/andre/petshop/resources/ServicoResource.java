package com.andre.petshop.resources;

import com.andre.petshop.domain.Pessoa;
import com.andre.petshop.domain.Servico;
import com.andre.petshop.service.PessoaService;
import com.andre.petshop.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/servicos")
public class ServicoResource {

    @Autowired
    private ServicoService servicoService;

    @GetMapping("/{id}")
    public ResponseEntity<Servico> findById(@PathVariable Integer id) {
        Servico servico = servicoService.findById(id);
        return ResponseEntity.ok(servico);
    }
}
