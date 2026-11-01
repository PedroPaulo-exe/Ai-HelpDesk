package com.pedro.helpdesk.enums;

public enum Prioridade {
    BAIXA(0, "BAIXA"),
    MEDIA(1, "MEDIA"),
    ALTA(2, "ALTA");

    private int codigo;
    private String descricao;

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    Prioridade(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static Prioridade toEnum(Integer codigo){
        if (codigo == null){
            return null;
        }

        for (Prioridade p: Prioridade.values()){
            if (codigo.equals(p.getCodigo())){
                return p;
            }
        }
        throw new IllegalArgumentException("Prioridade invalida");
    }

}
