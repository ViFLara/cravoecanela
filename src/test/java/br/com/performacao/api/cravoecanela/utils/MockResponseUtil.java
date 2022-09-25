package br.com.performacao.api.cravoecanela.utils;

import br.com.performacao.api.cravoecanela.entities.Cliente;
import br.com.performacao.api.cravoecanela.entities.Endereco;
import org.springframework.data.domain.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class MockResponseUtil {

    public static Page<Cliente> gerarListaPaginadaCliente() {

        Endereco endereco = Endereco.builder()
                .id(1L)
                .tipo("Residencial")
                .cep("01010-010")
                .logradouro("Rua de teste")
                .numero(1)
                .complemento("Apto 1A")
                .bairro("Vila de teste")
                .cidade("Cidade de teste")
                .estado("SP")
                .pais("Teste")
                .build();

        Cliente cliente = Cliente.builder()
                .id(1L)
                .cpf("123.456.789-10")
                .nome("Teste 1")
                .dataNascimento(Date.valueOf("2010-01-01"))
                .genero("Mulher Cisgênero")
                .email("teste@teste.com")
                .telefone("(11) 91111-1111")
                .profissao("Tester")
                .estadoCivil("Solteiro(a)")
                .endereco(endereco)
                .build();

        List<Cliente> clienteList = new ArrayList<>();
        clienteList.add(cliente);

        Page<Cliente> clientePage = new PageImpl<>(clienteList,Pageable.unpaged(),1L);
        return clientePage;
    }

    public static String gerarStringJsonResultadoLista(){
        return "{\"first\":true,\"last\":true,\"number\":0,\"numberOfElements\":1,\"size\":1,\"totalElements\":1,\"totalPages\":1,\"sort\":{\"sorted\":false,\"unsorted\":true,\"empty\":true},\"pageKey\":null,\"content\":[{\"id\":1,\"nome\":\"Teste 1\",\"cpf\":\"123.456.789-10\",\"email\":\"teste@teste.com\",\"telefone\":\"(11) 91111-1111\",\"dataNascimento\":\"2010-01-01\",\"genero\":\"FEMCIS\",\"estadoCivil\":\"SOLTEIRO\",\"profissao\":\"Tester\",\"endereco\":{\"tipo\":\"Residencial\",\"logradouro\":\"Rua de teste\",\"numero\":1,\"complemento\":\"Apto 1A\",\"cep\":\"01010-010\",\"bairro\":\"Vila de teste\",\"cidade\":\"Cidade de teste\",\"estado\":\"SP\",\"pais\":\"Teste\"}}]}";
    }

}
