package br.com.performacao.api.cravoecanela.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServicosDTO {

    private String descricao;
    private BigDecimal preco;
    private BigDecimal quantidade_horas;
}
