package br.com.performacao.api.cravoecanela.controller;

import br.com.performacao.api.cravoecanela.repositories.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.data.domain.Pageable;

import java.util.HashMap;
import java.util.Map;

import static br.com.performacao.api.cravoecanela.utils.MockResponseUtil.gerarListaPaginadaCliente;
import static br.com.performacao.api.cravoecanela.utils.MockResponseUtil.gerarStringJsonResultadoLista;
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
    public void greetingShouldReturnDefaultMessage() {

        when(mockRepository.findAll(any(Pageable.class))).thenReturn(gerarListaPaginadaCliente());

        assertThat(this.restTemplate
                .getForObject("http://localhost:" + port + "/clientes",
                String.class))
                .isGreaterThanOrEqualTo(gerarStringJsonResultadoLista());
    }

}
