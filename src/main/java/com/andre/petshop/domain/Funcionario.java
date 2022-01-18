package com.andre.petshop.domain;

import javax.persistence.Entity;

@Entity
public class Funcionario extends Pessoa{

    private String funcao;

    public Funcionario() {
    }

    public Funcionario(Integer id, String nome, String email, String codNacional, String funcao) {
        super(id, nome, email, codNacional);
        this.funcao = funcao;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}
