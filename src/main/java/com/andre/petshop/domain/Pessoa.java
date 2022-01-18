package com.andre.petshop.domain;

import javax.persistence.*;
import java.util.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String codNacional;

    @ElementCollection
    @CollectionTable(name = "TELEFONE", joinColumns = @JoinColumn(name = "id_pessoa"))
    private Set<String> telefone = new HashSet<>();

    @OneToMany(mappedBy = "pessoa")
    private List<Endereco> enderecoList = new ArrayList<>();

    public Pessoa() {
    }

    public Pessoa(Integer id, String nome, String email, String codNacional) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.codNacional = codNacional;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodNacional() {
        return codNacional;
    }

    public void setCodNacional(String codNacional) {
        this.codNacional = codNacional;
    }

    public List<Endereco> getEnderecoList() {
        return enderecoList;
    }

    public void setEnderecoList(List<Endereco> enderecoList) {
        this.enderecoList = enderecoList;
    }

    public Set<String> getTelefone() {
        return telefone;
    }

    public void setTelefone(Set<String> telefoneList) {
        this.telefone = telefoneList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(id, pessoa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
