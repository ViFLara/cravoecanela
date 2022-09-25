package br.com.performacao.api.cravoecanela.controller.dto;

import br.com.performacao.api.cravoecanela.entities.Cliente;
import br.com.performacao.api.cravoecanela.enums.UF;
import lombok.*;

import javax.persistence.OneToOne;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {

    private String tipo;
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String cep;
    private String bairro;
    private String cidade;
    private UF estado;
    private String pais;
    @OneToOne(mappedBy = "endereco")
    private Cliente cliente;
}
