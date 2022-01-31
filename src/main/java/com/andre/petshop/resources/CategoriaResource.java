package com.andre.petshop.resources;

import com.andre.petshop.domain.Categoria;
import com.andre.petshop.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;


    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
        Categoria categoria = categoriaService.findById(id);
        return ResponseEntity.ok(categoria);
    }

    @PostMapping()
    public ResponseEntity<Categoria> insert(@RequestBody Categoria obj) {
        obj = categoriaService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody Categoria obj, @PathVariable Integer id) {
        obj.setId(id);
        categoriaService.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
