package com.pedro.helpdesk.enums;

public enum Status {
    ABERTO(0, "ABERTO"),
    ANDAMENTO(1, "ANDAMENTO"),
    ENCERRADO(2, "ENCERRADO");


    private int codigo;
    private String descricao;

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    Status(int codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static Status toEnum(Integer codigo) {
        if (codigo == null) {
            return null;
        }
        for (Status s : Status.values()) {
            if (codigo.equals(s.getCodigo())) {
                return s;
            }
        }
        throw new IllegalArgumentException("Status invalido");
    }
}
