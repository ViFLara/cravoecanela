package br.com.performacao.api.cravoecanela.controller;

import br.com.performacao.api.cravoecanela.controller.dto.PageDTO;
import br.com.performacao.api.cravoecanela.controller.dto.TransacoesDTO;
import br.com.performacao.api.cravoecanela.entities.Transacoes;
import br.com.performacao.api.cravoecanela.services.TransacoesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/transacoes")
@Api(tags = "Transações Controller")
public class TransacoesController {

    @Autowired
    private TransacoesService transacoesService;

    @CrossOrigin
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransacoesDTO createTransacao(@RequestBody TransacoesDTO transacao)  {
        return transacoesService.createTransacao(transacao);
    }

    @CrossOrigin
    @PostMapping("/list")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTransacoesList(@RequestBody List<TransacoesDTO> transacoes)  {
        transacoesService.createTransacoesList(transacoes);
    }


    @CrossOrigin
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Find all Transações")
    public PageDTO<TransacoesDTO> findAll(Pageable pageable, Long clienteId) {
        return transacoesService.findAll(pageable, clienteId);
    }


    @CrossOrigin
    @PatchMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ApiOperation("Update Transações")
    public void update(String status, Long id) throws ChangeSetPersister.NotFoundException { transacoesService.update(status, id); }

}
