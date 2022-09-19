package br.com.performacao.api.cravoecanela.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Data
@Builder
@Entity
@Table(name = "cliente")
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private Date dataNascimento;
    private String genero;
    private String estadoCivil;
    private String profissao;
    @OneToOne
    @JsonIgnore
    private Endereco endereco;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return getId().equals(cliente.getId()) && getCpf().equals(cliente.getCpf()) && getEmail().equals(cliente.getEmail()) && getTelefone().equals(cliente.getTelefone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCpf(), getEmail(), getTelefone());
    }
}
