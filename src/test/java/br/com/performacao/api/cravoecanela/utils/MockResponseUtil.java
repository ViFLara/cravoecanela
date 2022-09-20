package br.com.performacao.api.cravoecanela.utils;

import br.com.performacao.api.cravoecanela.entities.Cliente;
import br.com.performacao.api.cravoecanela.entities.Endereco;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class MockResponseUtil {

    public Page<Cliente> gerarListaPaginadaCliente() {

        /*Cliente.builder()
                .cpf("123.456.789-10")
                .id(1L)
                .email("teste@teste.com")
                .nome("Teste 1")
                .genero("Mulher cisgenero")
                .build();
        */
        return null;
    }

}
