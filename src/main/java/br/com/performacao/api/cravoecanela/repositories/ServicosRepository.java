package br.com.performacao.api.cravoecanela.repositories;

import br.com.performacao.api.cravoecanela.entities.Servicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicosRepository extends JpaRepository<Servicos, Long> {
}
