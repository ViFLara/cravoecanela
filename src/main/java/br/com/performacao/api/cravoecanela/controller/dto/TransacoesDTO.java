package br.com.performacao.api.cravoecanela.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private BigDecimal valorTotal;
    private BigDecimal horasTotais;
}
