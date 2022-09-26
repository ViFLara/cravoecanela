package br.com.performacao.api.cravoecanela.controller.dto;

import br.com.performacao.api.cravoecanela.enums.UF;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {

    @NotBlank
    @Size(min = 2, max = 12)
    private String tipo;

    @NotBlank
    @Size(min = 5, max = 100)
    private String logradouro;

    @NotNull
    private Integer numero;

    @Size(max= 10)
    private String complemento;

    @NotBlank
    @Size(min = 9, max = 9)
    private String cep;

    @NotBlank
    @Size(min = 2, max = 45)
    private String bairro;

    @NotBlank
    @Size(min = 2, max = 30)
    private String cidade;

    @NotNull(message = "{NotNull.endereco.uf}")
    private UF estado;

    @NotBlank
    @Size(min = 2, max = 25)
    private String pais;

}
