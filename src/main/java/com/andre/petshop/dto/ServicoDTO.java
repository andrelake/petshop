package com.andre.petshop.dto;

import com.andre.petshop.domain.Pessoa;
import com.andre.petshop.domain.Servico;

import java.io.Serializable;
import java.util.Date;

public class ServicoDTO implements Serializable {

    private Date dataEntrada;
    private Date dataSaida;
    private String descricao;

    public ServicoDTO() {
    }

    public ServicoDTO(Servico servico) {
        this.dataEntrada = servico.getDataEntrada();
        this.dataSaida = servico.getDataSaida();
        this.descricao = servico.getDescricao();
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
