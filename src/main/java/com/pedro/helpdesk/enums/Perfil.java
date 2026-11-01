package com.pedro.helpdesk.enums;

public enum Perfil {
    ADMIN(0, "ROLE_ADMIN"),
    USER(1, "ROLE_USER"),
    TECNICO(2, "ROLE_TECNICO");

    private int codigo;
    private String descricao;

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }


    Perfil(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
    @SuppressWarnings("unused")
    public static Perfil toEnum(Integer codigo) {
        if (codigo == null) {
            return null;
        }

            for (Perfil p : Perfil.values()) {
                if (codigo.equals(p.codigo)) {
                    return p;
                }
            }

            throw new IllegalArgumentException("Perfil invalido");
    }


}
