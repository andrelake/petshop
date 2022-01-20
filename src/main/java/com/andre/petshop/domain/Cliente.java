package com.andre.petshop.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente extends Pessoa{

    private String tipo;

    @OneToMany(mappedBy = "cliente")
    private List<Servico> servicoList = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(Integer id, String nome, String email, String codNacional, String tipo) {
        super(id, nome, email, codNacional);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Servico> getServicoList() {
        return servicoList;
    }

    public void setServicoList(List<Servico> servicoList) {
        this.servicoList = servicoList;
    }
}
