package br.com.performacao.api.cravoecanela.controller.dto;

import br.com.performacao.api.cravoecanela.enums.EstadoCivil;
import br.com.performacao.api.cravoecanela.enums.Genero;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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

    @NotBlank
    @Size(min = 4, max = 55)
    private String nome;

    @NotBlank
    @Size(min= 14, max = 15)
    private String cpf;

    @NotBlank
    @Size(min = 10, max = 45)
    private String email;

    @NotBlank
    @Size(min = 9, max = 15)
    private String telefone;

    @NotBlank
    @Size(min = 10, max = 10)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dataNascimento;

    @NotBlank
    private Genero genero;

    @NotBlank
    private EstadoCivil estadoCivil;

    @NotBlank
    @Size(min = 5, max = 25)
    private String profissao;

    @Valid
    private EnderecoDTO endereco;

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
