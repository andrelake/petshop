package com.andre.petshop.domain;

import com.andre.petshop.domain.enums.SituacaoPagamentoEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pagamento implements Serializable {

    @Id
    private Integer id;
    private Double valor;
    private Integer situacao;

    @OneToOne
    @JoinColumn(name = "id_servico")
    @MapsId
    private Servico servico;

    public Pagamento() {
    }

    public Pagamento(Integer id, Double valor, SituacaoPagamentoEnum situacao, Servico servico) {
        this.id = id;
        this.valor = valor;
        this.situacao = situacao.getId();
        this.servico = servico;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public SituacaoPagamentoEnum getSituacao() {
        return SituacaoPagamentoEnum.toEnum(situacao);
    }

    public void setSituacao(SituacaoPagamentoEnum situacao) {
        this.situacao = situacao.getId();
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(id, pagamento.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
