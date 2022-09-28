package br.com.performacao.api.cravoecanela.mapper;

import br.com.performacao.api.cravoecanela.controller.dto.EnderecoDTO;
import br.com.performacao.api.cravoecanela.controller.dto.TransacoesDTO;
import br.com.performacao.api.cravoecanela.entities.Endereco;
import br.com.performacao.api.cravoecanela.entities.Transacoes;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {

    EnderecoDTO toEnderecoDTO (Endereco endereco);

    Endereco toEnderecoEntity (EnderecoDTO enderecoDTO);

    List<EnderecoDTO> toEnderecoDTOList (List<Endereco> enderecos);

    List<Endereco> toEnderecoList (List<EnderecoDTO> enderecoDTOList);

}
