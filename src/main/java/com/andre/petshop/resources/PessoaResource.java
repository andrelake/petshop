package com.andre.petshop.resources;

import com.andre.petshop.domain.Categoria;
import com.andre.petshop.domain.Pessoa;
import com.andre.petshop.service.CategoriaService;
import com.andre.petshop.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable Integer id) {
        Pessoa pessoa = pessoaService.findById(id);
        return ResponseEntity.ok(pessoa);
    }
}
