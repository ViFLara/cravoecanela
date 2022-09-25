package br.com.performacao.api.cravoecanela.repositories;

import br.com.performacao.api.cravoecanela.entities.Transacoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacoesRepository extends JpaRepository<Transacoes, Long> {
}
