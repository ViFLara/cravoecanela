package br.com.performacao.api.cravoecanela.controller;

import br.com.performacao.api.cravoecanela.controller.dto.ClienteDTO;
import br.com.performacao.api.cravoecanela.controller.dto.PageDTO;
import br.com.performacao.api.cravoecanela.entities.Cliente;
import br.com.performacao.api.cravoecanela.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {
    @Autowired
    private ClienteService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDTO createCliente(@RequestBody ClienteDTO cliente)  {
        return service.createCliente(cliente);
    }

    @PostMapping("/list")
    @ResponseStatus(HttpStatus.CREATED)
    public void createClienteList(@RequestBody List<ClienteDTO> clientes)  {
        service.createClienteList(clientes);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<ClienteDTO> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PageDTO<ClienteDTO> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@RequestBody ClienteDTO cliente) throws ChangeSetPersister.NotFoundException { service.update(cliente); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        service.deleteById(id);
    }

}

