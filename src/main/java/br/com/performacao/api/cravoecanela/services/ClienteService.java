package br.com.performacao.api.cravoecanela.services;

import br.com.performacao.api.cravoecanela.entities.Cliente;
import br.com.performacao.api.cravoecanela.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente createCliente(Cliente cliente) {
        Cliente savedCliente = clienteRepository.save(cliente);
        return savedCliente;
    }

    @Transactional(readOnly = true)
    public Optional<Cliente> findById(Long id) {
        Optional<Cliente> foundCliente = clienteRepository.findById(id);
        return Optional.ofNullable(foundCliente.orElse(null));
    }

    @Transactional(readOnly = true)
    public Page<Cliente> findAll(Pageable pageable) {
        clienteRepository.findAll();
        Page<Cliente> result = clienteRepository.findAll(pageable);
        return result;
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
