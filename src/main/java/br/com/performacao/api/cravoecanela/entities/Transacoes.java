package br.com.performacao.api.cravoecanela.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date data;

    private BigDecimal horas_totais;

    private BigDecimal valor_total;

    @ManyToOne(optional = false)
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

    private String status;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "transacoes_servicos",
            joinColumns = { @JoinColumn(name = "transacao_id") },
            inverseJoinColumns = { @JoinColumn(name = "servico_id") })
    private List<Servicos> servicos;

}
