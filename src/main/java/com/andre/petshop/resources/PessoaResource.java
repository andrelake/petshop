package com.andre.petshop.resources;

import com.andre.petshop.domain.Pessoa;
import com.andre.petshop.domain.Pessoa;
import com.andre.petshop.dto.PessoaDTO;
import com.andre.petshop.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping()
    public ResponseEntity<List<PessoaDTO>> findAll() {
        List<Pessoa> pessoas = pessoaService.findAll();
        List<PessoaDTO> pessoaDTOS = pessoas.stream().map(x -> new PessoaDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok(pessoaDTOS);
    }

    @PostMapping()
    public ResponseEntity<Pessoa> insert(@RequestBody Pessoa obj) {
        obj = pessoaService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody Pessoa obj, @PathVariable Integer id) {
        obj.setId(id);
        pessoaService.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        pessoaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
