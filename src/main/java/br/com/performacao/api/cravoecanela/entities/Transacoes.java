package br.com.performacao.api.cravoecanela.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@Table(name = "transacao")
@NoArgsConstructor
@AllArgsConstructor
public class Transacoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transacao_id")
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date data;
    private BigDecimal valor_total;
    private BigDecimal horas_totais;
    @ManyToOne(optional = false)
    @JoinColumn(name="cliente_id")
    private Cliente cliente;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "transacoes_servicos",
            joinColumns = { @JoinColumn(name = "transacao_id") },
            inverseJoinColumns = { @JoinColumn(name = "servico_id") })
    private List<Servicos> servicos;
    private String status;
}
