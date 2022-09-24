package br.com.performacao.api.cravoecanela.controller.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServicosDTO {

    private String descricao;
    private BigDecimal preco;
    private BigDecimal quantidadeHoras;
}
