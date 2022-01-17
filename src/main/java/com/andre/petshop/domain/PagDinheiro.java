package com.andre.petshop.domain;

import com.andre.petshop.domain.enums.SituacaoPagamentoEnum;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class PagDinheiro extends Pagamento{

    private Date dataPagamento;
    private Double desconto;

    public PagDinheiro() {
    }

    public PagDinheiro(Integer id, Double valor, SituacaoPagamentoEnum situacao, Servico servico,
                       Date dataPagamento, Double desconto) {
        super(id, valor, situacao, servico);
        this.dataPagamento = dataPagamento;
        this.desconto = desconto;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }
}
