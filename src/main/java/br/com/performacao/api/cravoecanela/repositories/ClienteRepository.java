package br.com.performacao.api.cravoecanela.repositories;

import br.com.performacao.api.cravoecanela.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
