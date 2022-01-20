package com.andre.petshop.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Funcionario extends Pessoa{

    private String funcao;

    @OneToMany(mappedBy = "funcionario")
    private List<Servico> servicoList = new ArrayList<>();

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

    public List<Servico> getServicoList() {
        return servicoList;
    }

    public void setServicoList(List<Servico> servicoList) {
        this.servicoList = servicoList;
    }
}
