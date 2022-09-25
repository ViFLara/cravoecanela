package br.com.performacao.api.cravoecanela.controller.dto;

import br.com.performacao.api.cravoecanela.entities.Endereco;
import br.com.performacao.api.cravoecanela.enums.EstadoCivil;
import br.com.performacao.api.cravoecanela.enums.Genero;
import lombok.*;

import java.util.Date;

import static br.com.performacao.api.cravoecanela.enums.EstadoCivil.*;
import static br.com.performacao.api.cravoecanela.enums.Genero.OUTROS;
import static br.com.performacao.api.cravoecanela.enums.Genero.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {


    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private Date dataNascimento;
    private Genero genero;
    private EstadoCivil estadoCivil;
    private String profissao;
    private Endereco endereco;

    public static Genero transformGeneroToEnum(String genero) {
        switch (genero) {
            case "Mulher Cisgênero":
                return FEMCIS;
            case "Mulher Transgênero":
                return FEMTRANS;
            case "Homem Cisgênero":
                return MASCIS;
            case "Homem Transgênero":
                return MASTRANS;
            case "Não Binário":
                return NAOBINARIO;
            case "Outros":
                return OUTROS;
            default:
                return null;
        }
    }
    public static EstadoCivil transformECToEnum(String estadoCivil) {
        switch (estadoCivil) {
            case "Casado(a)":
                return CASADO;
            case "Solteiro(a)":
                return SOLTEIRO;
            case "Divorciado(a)":
                return DIVORCIADO;
            case "Viúvo(a)":
                return VIUVO;
            case "União Estável":
                return UNIAOESTAVEL;
            case "Outros":
                return EstadoCivil.OUTROS;
            default:
                return null;

        }
    }

}
