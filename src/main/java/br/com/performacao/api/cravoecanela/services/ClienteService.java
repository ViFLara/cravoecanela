package br.com.performacao.api.cravoecanela.services;

import br.com.performacao.api.cravoecanela.entities.Cliente;
import br.com.performacao.api.cravoecanela.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente createCliente(Cliente cliente) {
        Cliente savedCliente = clienteRepository.save(cliente);
        return savedCliente;
    }

    public Optional<Cliente> findById(Long id) {
        Optional<Cliente> foundCliente = clienteRepository.findById(id);
        return Optional.ofNullable(foundCliente.orElse(null));
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public void deleteById(Long id) throws ChangeSetPersister.NotFoundException {
        verifyIfExists(id);
        clienteRepository.deleteById(id);
    }

    private Cliente verifyIfExists(Long id) throws ChangeSetPersister.NotFoundException {
        return clienteRepository.findById(id)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }
}
