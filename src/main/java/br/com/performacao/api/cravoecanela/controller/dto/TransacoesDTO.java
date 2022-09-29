package br.com.performacao.api.cravoecanela.controller.dto;

import br.com.performacao.api.cravoecanela.entities.Servicos;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransacoesDTO {

    private Long id;
    private Long clienteId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date data;
    private BigDecimal valorTotal;
    private BigDecimal horasTotais;
    private List<Long> servicosIds;
    private String status = "CREATED";


    public static List<Long> transformServicos(List<Servicos> servicos){
        List<Long> servicosIds = new ArrayList<>();
        servicos.forEach(s -> servicosIds.add(s.getId()));
        return servicosIds;
    }
}
