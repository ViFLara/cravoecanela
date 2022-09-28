package br.com.performacao.api.cravoecanela.utils;

import br.com.performacao.api.cravoecanela.controller.dto.ClienteDTO;
import br.com.performacao.api.cravoecanela.controller.dto.EnderecoDTO;
import br.com.performacao.api.cravoecanela.entities.Cliente;
import br.com.performacao.api.cravoecanela.entities.Endereco;
import br.com.performacao.api.cravoecanela.enums.EstadoCivil;
import br.com.performacao.api.cravoecanela.enums.Genero;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static br.com.performacao.api.cravoecanela.enums.UF.SP;

public class MockResponseUtil {

    public static Page<Cliente> gerarListaPaginadaCliente() {

        Cliente cliente = gerarCliente();

        List<Cliente> clienteList = new ArrayList<>();
        clienteList.add(cliente);

        Page<Cliente> clientePage = new PageImpl<>(clienteList,Pageable.unpaged(),1L);
        return clientePage;
    }

    public static ClienteDTO gerarClienteDTORequest() {

        EnderecoDTO endereco = EnderecoDTO.builder()
                .tipo("Residencial")
                .cep("01010-010")
                .logradouro("Rua de teste")
                .numero(1)
                .complemento("Apto 1A")
                .bairro("Vila de teste")
                .cidade("Cidade de teste")
                .estado(SP)
                .pais("Teste")
                .build();

        ClienteDTO cliente = ClienteDTO.builder()
                .cpf("123.456.789-10")
                .nome("Teste 1")
                .dataNascimento(Date.valueOf("2010-01-01"))
                .genero(Genero.FEMCIS)
                .email("teste@teste.com")
                .telefone("(11) 91111-1111")
                .profissao("Tester")
                .estadoCivil(EstadoCivil.SOLTEIRO)
                .endereco(endereco)
                .build();

        return cliente;
    }

    public static List<ClienteDTO> gerarListClienteDTORequest() {

        List<ClienteDTO> listaCliente = new ArrayList<>();
        listaCliente.add(gerarClienteDTOResponse());

        return listaCliente;
    }

    public static ClienteDTO gerarClienteDTOResponse() {

        ClienteDTO cliente = gerarClienteDTORequest();
        cliente.setId(1L);

        return cliente;
    }

    public static Cliente gerarCliente() {

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

        return cliente;
    }

    public static String gerarStringJsonResultadoLista(){
        return "{\"first\":true,\"last\":true,\"number\":0,\"numberOfElements\":1,\"size\":1,\"totalElements\":1,\"totalPages\":1,\"sort\":{\"sorted\":false,\"unsorted\":true,\"empty\":true},\"pageKey\":null,\"content\":[{\"id\":1,\"nome\":\"Teste 1\",\"cpf\":\"123.456.789-10\",\"email\":\"teste@teste.com\",\"telefone\":\"(11) 91111-1111\",\"dataNascimento\":\"2010-01-01\",\"genero\":\"FEMCIS\",\"estadoCivil\":\"SOLTEIRO\",\"profissao\":\"Tester\",\"endereco\":{\"tipo\":\"Residencial\",\"logradouro\":\"Rua de teste\",\"numero\":1,\"complemento\":\"Apto 1A\",\"cep\":\"01010-010\",\"bairro\":\"Vila de teste\",\"cidade\":\"Cidade de teste\",\"estado\":\"SP\",\"pais\":\"Teste\"}}]}";
    }

}
