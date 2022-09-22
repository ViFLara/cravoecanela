package br.com.performacao.api.cravoecanela.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dataNascimento;
    private String genero;
    private String estadoCivil;
    private String profissao;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id) && Objects.equals(nome, cliente.nome) && Objects.equals(cpf, cliente.cpf) && Objects.equals(email, cliente.email) && Objects.equals(telefone, cliente.telefone) && Objects.equals(dataNascimento, cliente.dataNascimento) && Objects.equals(genero, cliente.genero) && Objects.equals(estadoCivil, cliente.estadoCivil) && Objects.equals(profissao, cliente.profissao) && Objects.equals(endereco, cliente.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cpf, email, telefone, dataNascimento, genero, estadoCivil, profissao, endereco);
    }
}
