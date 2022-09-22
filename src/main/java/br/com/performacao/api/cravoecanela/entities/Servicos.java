package br.com.performacao.api.cravoecanela.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@Entity
@Table(name = "servicos")
@NoArgsConstructor
@AllArgsConstructor
public class Servicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private BigDecimal preco;
    private BigDecimal quantidade_horas;
}


