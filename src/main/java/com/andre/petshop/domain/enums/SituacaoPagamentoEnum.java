package com.andre.petshop.domain.enums;

public enum SituacaoPagamentoEnum {

    QUITADO(1, "Quitado"),
    CANCELADO(2, "Cancelado"),
    PENDENTE(3, "Pendente");

    private int cod;
    private String descricao;

    SituacaoPagamentoEnum(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public static SituacaoPagamentoEnum toEnum(Integer cod) {
        if(cod == null) {
            return null;
        }

        for(SituacaoPagamentoEnum sp: SituacaoPagamentoEnum.values()) {
            if(cod.equals(sp.getId())) {
                return sp;
            }
        }

        throw new IllegalArgumentException();
    }

    public int getId() {
        return cod;
    }

    public void setId(int cod) {
        this.cod = cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
