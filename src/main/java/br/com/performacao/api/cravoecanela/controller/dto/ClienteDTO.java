package br.com.performacao.api.cravoecanela.controller.dto;

import br.com.performacao.api.cravoecanela.entities.Endereco;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private Date dataNascimento;
    private String genero;
    private String estadoCivil;
    private String profissao;
    private Endereco endereco;
}
