package br.com.performacao.api.cravoecanela.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Builder
@Entity
@Table(name = "transacoes")
@NoArgsConstructor
@AllArgsConstructor
public class Transacoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date data;
    private BigDecimal valor_total;
    private BigDecimal horas_totais;
}
