package br.com.performacao.api.cravoecanela.controller;

import br.com.performacao.api.cravoecanela.controller.dto.PageDTO;
import br.com.performacao.api.cravoecanela.controller.dto.ServicosDTO;
import br.com.performacao.api.cravoecanela.services.ServicosService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/servicos")
@Api(tags = "Serviços Controller")
public class ServicosController {

    @Autowired
    private ServicosService servicosService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Find all Serviços")
    public PageDTO<ServicosDTO> findAll(Pageable pageable) {
        return servicosService.findAll(pageable);
    }
}
