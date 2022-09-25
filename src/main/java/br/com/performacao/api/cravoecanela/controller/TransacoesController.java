package br.com.performacao.api.cravoecanela.controller;

import br.com.performacao.api.cravoecanela.controller.dto.PageDTO;
import br.com.performacao.api.cravoecanela.controller.dto.TransacoesDTO;
import br.com.performacao.api.cravoecanela.entities.Transacoes;
import br.com.performacao.api.cravoecanela.services.TransacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/transacoes")
public class TransacoesController {

    @Autowired
    private TransacoesService transacoesService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransacoesDTO createTransacao(@RequestBody Transacoes transacao)  {
        return transacoesService.createTransacao(transacao);
    }

    @PostMapping("/list")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTransacoesList(@RequestBody List<TransacoesDTO> transacoes)  {
        transacoesService.createTransacoesList(transacoes);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PageDTO<TransacoesDTO> findAll(Pageable pageable, Long clienteId) {
        return transacoesService.findAll(pageable, clienteId);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(String status, Long id) throws ChangeSetPersister.NotFoundException { transacoesService.update(status, id); }

}
