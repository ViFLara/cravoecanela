package br.com.performacao.api.cravoecanela.controller;

import br.com.performacao.api.cravoecanela.controller.dto.ClienteDTO;
import br.com.performacao.api.cravoecanela.entities.Cliente;
import br.com.performacao.api.cravoecanela.repositories.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.net.URI;

import static br.com.performacao.api.cravoecanela.utils.MockResponseUtil.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClienteControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private ClienteRepository mockRepository;

    @Test
    public void testeListagemDeClientesComSucesso() {

        when(mockRepository.findAll(any(Pageable.class))).thenReturn(gerarListaPaginadaCliente());

        assertThat(this.restTemplate
                .getForObject("http://localhost:" + port + "/clientes",
                String.class))
                .isGreaterThanOrEqualTo(gerarStringJsonResultadoLista());
    }

    @Test
    public void testeCadastrarClienteComSucesso() {

        when(mockRepository.save(any(Cliente.class))).thenReturn(gerarCliente());

        assertThat(this.restTemplate
                .postForEntity("http://localhost:" + port + "/clientes",
                        gerarClienteDTORequest(),
                        ClienteDTO.class))
                .hasNoNullFieldsOrProperties()
                .returns(Boolean.TRUE,clienteDTOResponseEntity -> clienteDTOResponseEntity.getStatusCode().is2xxSuccessful());
    }

}
