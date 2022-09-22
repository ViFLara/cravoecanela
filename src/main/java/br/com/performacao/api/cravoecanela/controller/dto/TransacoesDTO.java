package br.com.performacao.api.cravoecanela.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransacoesDTO {

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date data;
    private BigDecimal valor_total;
    private BigDecimal horas_totais;
}
