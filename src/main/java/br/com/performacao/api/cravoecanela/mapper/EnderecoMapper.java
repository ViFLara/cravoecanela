package br.com.performacao.api.cravoecanela.mapper;

import br.com.performacao.api.cravoecanela.controller.dto.ClienteDTO;
import br.com.performacao.api.cravoecanela.controller.dto.EnderecoDTO;
import br.com.performacao.api.cravoecanela.entities.Cliente;
import br.com.performacao.api.cravoecanela.entities.Endereco;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {

    EnderecoDTO toEnderecoDTO (Endereco endereco);
    Endereco toEnderecoEntity (EnderecoDTO enderecoDTO);
    List<EnderecoDTO> toEnderecoDTOList (List<Endereco> endereco);
    List<Endereco> toEnderecoList (List<EnderecoDTO> enderecoDTOS);

}
