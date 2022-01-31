package com.andre.petshop.dto;

import com.andre.petshop.domain.Pessoa;

import java.io.Serializable;

public class PessoaDTO implements Serializable {

    private String name;
    private String email;
    private String codNacional;

    public PessoaDTO() {
    }

    public PessoaDTO(Pessoa pessoa) {
        this.name = pessoa.getNome();
        this.email = pessoa.getEmail();
        this.codNacional = pessoa.getCodNacional();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
