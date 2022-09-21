package br.com.performacao.api.cravoecanela.services;

import br.com.performacao.api.cravoecanela.controller.dto.ClienteDTO;
import br.com.performacao.api.cravoecanela.entities.Cliente;
import br.com.performacao.api.cravoecanela.mapper.ClienteMapper;
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

    @Autowired
    private ClienteMapper clienteMapper;

    public ClienteDTO createCliente(ClienteDTO cliente) {
        Cliente savedCliente = clienteRepository.save(clienteMapper.toClienteEntity(cliente));
        return clienteMapper.toClienteDTO(savedCliente);
    }

    @Transactional(readOnly = true)
    public Optional<ClienteDTO> findById(Long id) {
        Optional<Cliente> foundCliente = clienteRepository.findById(id);
        return Optional.ofNullable(clienteMapper.toClienteDTO(foundCliente.orElse(new Cliente())));
    }

    @Transactional(readOnly = true)
    public Page<Cliente> findAll(Pageable pageable) {
        Page<Cliente> result = clienteRepository.findAll(pageable);
        return result;
    }

    public void deleteById(Long id) throws ChangeSetPersister.NotFoundException {
        verifyIfExists(id);
        clienteRepository.deleteById(id);
    }

    private void verifyIfExists(Long id) throws ChangeSetPersister.NotFoundException {
        clienteRepository.findById(id)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }
}
