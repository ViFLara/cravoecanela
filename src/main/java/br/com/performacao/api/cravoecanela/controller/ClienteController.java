package br.com.performacao.api.cravoecanela.controller;

import br.com.performacao.api.cravoecanela.entities.Cliente;
import br.com.performacao.api.cravoecanela.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {
    @Autowired
    private ClienteService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente createCliente(@RequestBody Cliente cliente)  {
        return service.createCliente(cliente);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Cliente>> findById(@PathVariable Long id) {
        Optional<Cliente> obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<Page<Cliente>> findAll(Pageable pageable) {
        Page<Cliente> list = service.findAll(pageable);
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        service.deleteById(id);
    }

}

