package br.com.performacao.api.cravoecanela.enums;

public enum Genero {

    FEMCIS("Mulher Cisgênero"),
    FEMTRANS("Mulher Transgênero"),
    MASCIS("Homem Cisgênero"),
    MASTRANS("Homem Transgênero"),
    NAOBINARIO("Não Binário<"),
    OUTROS("Outros");

    private String value;

    Genero(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}
