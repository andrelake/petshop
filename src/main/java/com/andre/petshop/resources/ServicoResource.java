package com.andre.petshop.resources;

import com.andre.petshop.domain.Servico;
import com.andre.petshop.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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

    @PostMapping()
    public ResponseEntity<Servico> insert(@RequestBody Servico obj) {
        obj = servicoService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody Servico obj, @PathVariable Integer id) {
        obj.setId(id);
        servicoService.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        servicoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
