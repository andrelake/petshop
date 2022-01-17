package com.andre.petshop.domain;

import com.andre.petshop.domain.enums.SituacaoPagamentoEnum;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class PagCartao extends Pagamento{

    private Integer parcelas;

    public PagCartao() {
    }

    public PagCartao(Integer id, Double valor, SituacaoPagamentoEnum situacao, Servico servico, Integer parcelas) {
        super(id, valor, situacao, servico);
        this.parcelas = parcelas;
    }

    public Integer getParcelas() {
        return parcelas;
    }

    public void setParcelas(Integer parcelas) {
        this.parcelas = parcelas;
    }
}
