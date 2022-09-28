package br.com.performacao.api.cravoecanela.enums;

public enum EstadoCivil {

    CASADO("Casado(a)"),
    SOLTEIRO("Solteiro(a)"),
    DIVORCIADO("Divorciado(a)"),
    VIUVO("Viúvo(a)"),
    UNIAOESTAVEL("União Estável"),
    OUTROS("Outros");

    private String value;

    EstadoCivil(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
